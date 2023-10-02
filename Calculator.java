class Calculator {

    int digit;
    String operation;
    int sdigit;
    Calculator(int parseInt, String s, int parseInt1) {
        digit = parseInt;
        operation = s;
        sdigit = parseInt1;
    }


    int operation() throws Exception {
        if (1 <= digit && digit <= 10 && sdigit <= 10 && sdigit >= 1) {
            return switch (operation) {
                case ("-") -> digit - sdigit;
                case ("+") -> digit + sdigit;
                case ("*") -> digit * sdigit;
                case ("/") -> digit / sdigit;
                default -> throw new Exception();
            };
        }else {
            throw new Exception("Одно из чисел превышает 10, меньше 1 или неверная арифмитическая операция");
        }
    }

}
