import java.io.IOException;

public class Calculator {

    // основная операция: ввод, расчеты, вывод
    public static void operation() throws IOException {
        InOutPut iface = new InOutPut();
        String taskString = iface.input ();
        String result = calculate(taskString);
        iface.output(result);

    }

    //расчеты. Получаем операнды из строки, вычисляем, возвращаем ответ
    public static String calculate (String taskString) throws IOException {
        Task task = Task.StringToTask(taskString);
        Integer intResult = 0;
        if (task.operator.equals("+")) intResult = task.firstOperand + task.secondOperand;
        if (task.operator.equals("-")) intResult = task.firstOperand - task.secondOperand;
        if (task.operator.equals("*")) intResult = task.firstOperand * task.secondOperand;
        if (task.operator.equals("/")) intResult = task.firstOperand / task.secondOperand;
        if (task.isRome == true && intResult < 1) throw new  IOException("result uncorrect by rome numbers");
     //   System.out.println(task.firstOperand+task.operator+task.secondOperand+task.isRome);

        if (task.isRome == false) return intResult.toString();
        else return RomeNumbers.arabianToRome(intResult);

    }

    //главный метод отделим от счета, цикл сделать, например, или что-то еще.
    public static void main(String[] args) throws IOException {
       operation();
    }
}
