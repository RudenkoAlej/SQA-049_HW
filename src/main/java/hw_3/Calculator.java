package hw_3;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String userInput = "";

        while (!"q".equals(userInput)) {
            try {
                System.out.println("Введите первое число");
                int firstValue = scanner.nextInt();

                System.out.println("Введите второе число");
                int secondValue = scanner.nextInt();

                System.out.println("Введите знак дествия с числами: +, -, *, /, ! или командой для выхода \"q\" из программы");
//            userInput = scanner.nextLine();
                userInput = reader.readLine();

                double result;

                switch (userInput) {
                    case "+":
                        result = add(firstValue, secondValue);
                        break;
                    case "-":
                        result = minus(firstValue, secondValue);
                        break;
                    case "*":
                        result = multiply(firstValue, secondValue);
                        break;
                    case "/":
                        if (secondValue == 0) {
                            continue;
                        }
                        result = divide(firstValue, secondValue);
                        break;
                    case "!":
                        result = factorial(firstValue);
                        System.out.printf("Факториал выполниться только для первого введенного числа %d :", firstValue);
                        break;
                    case "q":
                        System.out.println("Программа завершена. Результату будет присвоин 0.");
                        result = 0;
                        break;
                    default:
                        System.out.println("Был ввиден невалидный символ действий над числами. Попробуйте еще раз!");
                        result = 0;
                        break;
                }
                System.out.printf("Результат : %5.2f \n", result);
            } catch (InputMismatchException e) {
                System.out.println("Введенный символ не является числом");
                e.printStackTrace();
                break;
            }
        }
    }


    public static int add(int a, int b) {
        int sum = a + b;
        return sum;
    }

    public static int minus(int a, int b) {
        int minus = a - b;
        return minus;
    }

    public static int multiply(int a, int b) {
        int multiply = a * b;
        return multiply;
    }

    public static float divide(int a, int b) {
        float divide = (float) a / b;
        return divide;
    }

    public static int factorial(int a) {
        int factorial1 = 1;
        for(int i = 1; i<a; i++) {
            factorial1 = factorial1*a;
        }
        return factorial1;
    }
}
