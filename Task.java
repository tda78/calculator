import java.io.IOException;

//объект задания, поля - операнды, оператор и форма записи. основной объект вычислений.
public class Task {
    boolean isRome;
    int firstOperand;
    int secondOperand;
    String operator;
    private final int MIN_VALUE = 1;
    private final int MAX_VALUE = 10;

    //Получение объекта вычислений из строки задания.
    // Делим строку на массив,получаем из элементов операнды и систему записи.
    //операнды - пробуем арабские, не получается - пробуем римские.
    //валидация ввода.
    static Task StringToTask(String taskString) throws IOException {
        String[] array = taskString.split(" ");
        if (array.length!=3) throw new IOException();

        Task task = new Task();
        task.isRome = false;

        try {
            task.firstOperand = Integer.parseInt(array[0]);
        }
        catch (Exception e){
            task.isRome = true;
            task.firstOperand = RomeNumbers.romeToArabian(array[0]);
        }

        if (task.isRome == false) {task.secondOperand = Integer.parseInt(array[2]);}
        else task.secondOperand = RomeNumbers.romeToArabian(array[2]);

        task.operator = array[1];
        task.validate();

        return task;
    }

    //валидация по значению и оператору
    private void validate() throws IOException {
        if (
                firstOperand < MIN_VALUE ||
                        secondOperand < MIN_VALUE ||
                        firstOperand > MAX_VALUE ||
                        secondOperand > MAX_VALUE ) {
            throw new IOException("illegal numbers!");
        }
        if (
                operator.equals("+") ||
                        operator.equals("-") ||
                        operator.equals("/") ||
                        operator.equals("*") ){
            return;

        }
        throw new IOException("unknown operator");

    }
}
