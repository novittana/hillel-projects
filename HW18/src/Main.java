import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class Main {
    public static void printLn(String text) {
        try {
            PrintStream ps = new PrintStream(System.out, true, "UTF-8");
            ps.println(text);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Main.printLn("Hello, World");
        Main.printLn("------------------------");
        Main.printLn("--------HOMEWORK--------");
        Main.printLn("------------------------");
        //ДЗ
        /*
            Необходимо написать программу, где бы пользователю предлагалось ввести число на выбор:
            1, 2 или 3, а программа должна сказать, какое число ввёл пользователь: 1, 2, или 3.
            Написать двумя способами. If и switch.
         */
        Main.printLn("--------Task-1.1--------");

        Main.printLn("Введите число 1, 2 или 3: ");
        Scanner inputFigure = new Scanner(System.in);
        int n = inputFigure.nextInt();

        if (n == 1) {
            Main.printLn("Вы ввели число 1");
        } else if (n == 2) {
            Main.printLn("Вы ввели число 2");
        } else if (n == 3) {
            Main.printLn("Вы ввели число 3");
        } else {
            Main.printLn("Вы ввели неправильное число");
        }


        Main.printLn("--------Task-1.2--------");
        // Оператор switch
        Main.printLn("Введите число 1, 2 или 3: ");
        int i = inputFigure.nextInt();
        switch (i) {
            case 1:
                Main.printLn("Вы ввели число 1");
                break;
            case 2:
                Main.printLn("Вы ввели число 2");
                break;
            case 3:
                Main.printLn("Вы ввели число 3");
                break;
            default:
                Main.printLn("Вы ввели неправильное число");
        }

        Main.printLn("---------Task-2----------");

        /*
            Необходимо вывести на экран числа от 5 до 1. На экране должно быть:
            5 4 3 2 1
        */

        for (int a = 5; a >= 1; a--) {
            Main.printLn(Integer.toString(a));
        }
        Main.printLn("------------------------");
        Main.printLn("---------Task-3----------");

        /*
            Необходимо вывести на экран таблицу умножения на 3:
            3*1=3
            3*2=6
            3*3=9
            3*4=12
            3*5=15
            3*6=18
            3*7=21
            3*8=24
            3*9=27
            3*10=30
        */

        int b = 3;
        for (int j = 1; j <= 10; j++) {
            Main.printLn(b + "*" + j + "=" + b * j);
        }

        Main.printLn("---------Task-4----------");

        // Найти среднее арефметическое суммы чисел от 1 до 100
        int s = 0;
        int m = 1;
        int d = 100;
        for (int j = m; j <= d; j++) {
            s += j;
        }
        Main.printLn(Double.toString(s / d));
    }
}
