import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args)  {
        System.out.println("Введите арифметическую операцию:");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input;
        try {
            input = reader.readLine();
            System.out.println(calc(input));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static String calc(String input) {
        String[] arifm = input.split(" ");
        try {
            return new Parser().Input(arifm);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
