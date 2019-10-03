import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

//класс для конвертирования римских цифр в арабские и наоборот
public class RomeNumbers {

    /* ---------------------------------------------------------
    конверт арабских в римские. Используем рекурсию.
     Добавляем записи в римскую запись, при этом вычитая значение из числа. От большего к меньшему.
     Смотрел вчера разные алгоритмы, этот понравился - Рекурсия!
    ------------------------------------------------------*/
    public static String arabianToRome(int inputNumber){
        if (inputNumber > 99)  return "C" + arabianToRome(inputNumber-100);
        if (inputNumber > 89)  return "XC" + arabianToRome(inputNumber-90);
        if (inputNumber > 49)  return "L" + arabianToRome(inputNumber-50);
        if (inputNumber > 39)  return "XL" + arabianToRome(inputNumber-40);
        if (inputNumber > 9)  return "X" + arabianToRome(inputNumber-10);
        if (inputNumber > 8)  return "IX" + arabianToRome(inputNumber-9);
        if (inputNumber > 4)  return "V" + arabianToRome(inputNumber-5);
        if (inputNumber > 3)  return "IV" + arabianToRome(inputNumber-4);
        if (inputNumber > 0)  return "I" + arabianToRome(inputNumber-1);
        return "";
    }

    /*-----------------------------------------------------------------------
    конверт римских цифер в числа. Тут постарался, хотя больше 10 и не нужно было. Но вдруг пригодится.
    Словарик из значений. Строку просматриваем посимвольно: если впереди символ с большим значением - вычитаем,
    иначе - прибавляем.
     * -------------------------------------------------------------------- */
    public  static int romeToArabian(String InputString) throws IOException {

        Map<Character,Integer> romeVolumes = new HashMap<>();
        romeVolumes.put('I',1 );
        romeVolumes.put('V',5 );
        romeVolumes.put('X',10 );
        romeVolumes.put('L',50 );
        romeVolumes.put('C',100);


        char[] romeChars = InputString.toCharArray();

        int length = romeChars.length;
        int last = length - 1;
        int result = 0;
        int tempValue;

        for (int i = 0; i < length; i++)
        {
            tempValue = romeVolumes.get(romeChars[i]);
            if ( i < last && tempValue < romeVolumes.get(romeChars[i+1])) {
                result -= tempValue;
            }
            else result += tempValue;

        }
        /*
            Защита от дурака - проверка на прваильный формат (чтобы не было чисел типа LC, IL и т.д.)
        * */
        if (!InputString.equals(arabianToRome(result)))throw new IOException("Uncorrect format of rome number");
        return (result);
    }

    public static void main(String[] args) throws IOException {
        System.out.println(arabianToRome(99));
        System.out.println(romeToArabian("XLCIX"));
    }
}

