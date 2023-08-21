import java.util.Scanner;

class TaskNumber4 extends RomanNumbers{

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();
        System.out.println(parse(expression));
    }

    public static String parse(String expression) throws Exception {
        int operand1;
        int operand2;
        String operation;
        String result;
        boolean isRoman;
        String[] operands = expression.split("[+\\-*/]"); // знак минус считываем с консоли, поэтому "\\"
        if (operands.length != 2) throw new Exception("Ошибка, т.к. строка не является математической операцией!");
        operation = define(expression);
        if (RomanNumber.isRoman(operands[0]) && RomanNumber.isRoman(operands[1])) {
            operand1 = RomanNumber.convertAr(operands[0]);
            operand2 = RomanNumber.convertAr(operands[1]);
            isRoman = true;
        }
        else if (!RomanNumber.isRoman(operands[0]) && !RomanNumber.isRoman(operands[1])) {
            operand1  = Integer.parseInt(operands[0]);
            operand2 = Integer.parseInt(operands[1]);
            isRoman = false;
        }
        else {
            throw new Exception("Используются одновременно разные системы счисления!");
        }
        if (operand1 > 10 || operand2 > 10) {
            throw new Exception("Калькулятор принимает на вход числа от 1 до 10 включительно, не более!");
        }
        int arabian = calc(operand1 , operand2, operation);
        if (isRoman) {
            if (arabian <= 0) {
                throw new Exception("Используются одновременно разные системы счисления!");
            }
            result = RomanNumber.convertRom(arabian);
        } else {
            result = String.valueOf(arabian);
        }
        return result;
    }

    static String define(String expression) {
        if (expression.contains("+")) return "+";
        else if (expression.contains("-")) return "-";
        else if (expression.contains("*")) return "*";
        else if (expression.contains("/")) return "/";
        else return null;
    }

    static int calc(int a, int b, String oper) {

        if (oper.equals("+")) return a + b;
        else if (oper.equals("-")) return a - b;
        else if (oper.equals("*")) return a * b;
        else return a / b;
    }
}
