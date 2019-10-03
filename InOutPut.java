import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//класс интерфейса. Ввод и вывод
public class InOutPut {

    public String input() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String result = reader.readLine();
        reader.close();
        return result;
    } 

    public void output(String outString){
        System.out.println(outString);
    }
}
