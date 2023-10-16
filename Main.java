import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        char action;
        String[] data;
        if (input.contains(" + ")) {
            data = input.split(" \\+ ");
            action = '+';
        } else if (input.contains(" - ")) {
            data = input.split(" - ");
            action = '-';
        } else if (input.contains(" * ")) {
            data = input.split(" \\* ");
            action = '*';
        } else if (input.contains(" / ")) {
            data = input.split(" / ");
            action = '/';
        } else {
            throw new Exception("Invalid string operand");
        }
        validate(data, action);
        for (int i = 0; i < data.length; i++) {
            data[i] = data[i].replace("\"", "");
        }
        calculate(action, data);

    }

    private static void validate(String[] data, char action) throws Exception {
        if (isNumeric(data[0]) && isNumeric(data[1])) {
            throw new IllegalArgumentException("Invalid string operand");
        }
        if (action == '*' || action == '/') {
            if (!isNumeric(data[1])) {
                throw new Exception("Invalid string operand");
            }
        }
        if ((!isNumeric(data[0]) && data[0].length() > 10) || (!isNumeric(data[1]) && data[1].length() > 10)) {
            throw new Exception("Invalid string operand");
        }
        if (isNumeric(data[1]) && (Integer.parseInt(data[1]) > 10 || Integer.parseInt(data[1]) < 1)) {
            throw new Exception("Invalid string operand");
        }
    }

    private static void calculate(char action, String[] data) {
        switch (action) {
            case '+':
                System.out.println(appendMarks(data[0] + data[1]));
                break;
            case '*':
                int multiplier = Integer.parseInt(data[1]);
                System.out.println(appendMarks(String.valueOf(data[0]).repeat(Math.max(0, multiplier))));
                break;
            case '-':
                int index = data[0].indexOf(data[1]);
                if (index == -1) {
                    System.out.println(appendMarks(data[0]));
                } else {
                    String result = data[0].substring(0, index);
                    result += data[0].substring(index + data[1].length());
                    System.out.println(appendMarks(result));
                }
                break;
            default:
                int length = data[0].length() / Integer.parseInt(data[1]);
                String result = data[0].substring(0, length);
                System.out.println(appendMarks(result));
                break;
        }
    }

    static String appendMarks(String text) {
        if (text.length() > 40) {
            return "\"" + text.substring(0, 40) + "..." + "\"";
        }
        return "\"" + text + "\"";
    }

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}