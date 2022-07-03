import java.util.Scanner;
class calculator {
static Scanner sc  = new Scanner (System.in );
static  int vvod1, vvod2;
static int result;

public static void main (String[] args) throws Exception {
        String[] inp = sc.nextLine().split(" ");
        if (inp.length != 3) {
        throw new Exception("Два операнда и один оператор (+,-,*,/)");
        }
        if (inp [0].equals ("I") || inp [0].equals("II") || inp [0].equals("III") || inp [0].equals("IV") || inp [0].equals("V") || inp [0]. equals ("VI") || inp [0]. equals ("VII") || inp [0]. equals ("VIII") || inp [0]. equals ("IX") || inp[0].equals ("X") && inp[2]. equals ("I") || inp[2]. equals ("II") || inp[2]. equals ("III") || inp[2].equals ("IV") || inp [2]. equals ("V") || inp [2]. equals ("VI") || inp [2]. equals ("VII") || inp [2]. equals ("VIII") || inp [2].equals("IX") || inp [2].equals("X")) {
        vvod1 = convertRomanToArab(inp [0]);
        vvod2 = convertRomanToArab(inp [2]);

        if (vvod1 > 0 && vvod1 < 11 && vvod2 > 0 && vvod2 < 11) {
        result = calc(vvod1, 2, inp [1]);
        if (result> 0) {
        String resultRomanNum = convertArabToRoman(result);
        System.out.println(resultRomanNum);
        } else {
        throw new Exception("Римское число не может быть 0 или отрицательным!");
        }
        }
        } else {
        vvod1 = Integer.parseInt(inp [0]);
        vvod2 = Integer.parseInt(inp [2]);
        if (vvod1 < 11 && vvod1 > 0 && vvod2 < 11 && vvod2 > 0) {
        result = calc(vvod1, vvod2, inp[1]);
        System.out.println(result);
        } else {
        throw new Exception("Вводить нужно только от 1 до 10 включительно!");
        }
        }
        }

static int convertRomanToArab(String str) throws Exception {
        if (str.equals("I") || str.equals("II") || str.equals("III") || str.equals("IV") || str.equals("V") || str.equals("VI") || str.equals("VII") || str.equals("VIII") || str.equals("IX") || str.equals("X")) {
        switch (str) {
        case "I":
        return 1;
        case "II":
        return 2;
        case "III":
        return 3;
        case "IV":
        return 4;
        case "V":
        return 5;
        case "VI":
        return 6;
        case "VII":
        return 7;
        case "VIII":
        return 8;
        case "IX":
        return 9;
        case "X":
        return 10;
        }
        } else {
        throw new Exception("Используются одновременно разные системы счисления!");
        }
        return 0;
        }

static String convertArabToRoman(int arabic) {
        int[] values = {100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romanLiterals = {"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder roman = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
        while (arabic >= values[i]) {
        arabic -= values[i];
        roman.append(romanLiterals[i]);
        }
        }
        return roman.toString();
        }

static int calc(int a, int b, String operator) {
        int result;
        switch (operator) {
        case "+":
        result = a + b;
        break;
        case "-":
        result = a - b;
        break;
        case "*":
        result = a * b;
        break;
        case "/":
        try {
        result = a / b;
        } catch (ArithmeticException e) {
        throw new ArithmeticException("Нельзя делить на 0");
        }
        break;
default:
        throw new IllegalArgumentException("Не верный знак операции: " + operator);
        }
        return result;
        }
        }
