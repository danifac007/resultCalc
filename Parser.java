class Parser {

    boolean What(String a) {
        String[] arr = {"0","1","2","3","4","5","6","7","8","9","10"};
        for (int i = 0; i< 11; i++) {
            if (arr[i].equals(a)) {
                return true;
            }
        }
        return false;
    }
    String Input(String[] arifm) throws Exception {

        if(What(arifm[0])){
            String s = arifm[1];
            Calculator calculator = new Calculator(Integer.parseInt(arifm[0]),s,Integer.parseInt(arifm[2]));
            return String.valueOf(calculator.operation());}
        else {
            RomanNumber roman = new RomanNumber();
            int fch = roman.digit(arifm[0]);
            int sch = roman.digit(arifm[2]);
            if (fch < sch && arifm[1].equals("-")) {
                throw new Exception("В римской системе нет отрицательных чисел");
            }
            Calculator calculator = new Calculator(fch,arifm[1],sch);
            return integerToRomanNumeral(calculator.operation());
        }
    }

    static String integerToRomanNumeral(int input) {
        if (input < 1 || input > 101)
            return "0";
        StringBuilder s = new StringBuilder();
        while (input >= 100) {
            s.append("C");
            input -= 100;
        }
        while (input >= 90) {
            s.append("XC");
            input -= 90;
        }
        while (input >= 50) {
            s.append("L");
            input -= 50;
        }
        while (input >= 40) {
            s.append("XL");
            input -= 40;
        }
        while (input >= 10) {
            s.append("X");
            input -= 10;
        }
        while (input >= 9) {
            s.append("IX");
            input -= 9;
        }
        while (input >= 5) {
            s.append("V");
            input -= 5;
        }
        while (input >= 4) {
            s.append("IV");
            input -= 4;
        }
        while (input >= 1) {
            s.append("I");
            input -= 1;
        }
        return s.toString();
    }
}
