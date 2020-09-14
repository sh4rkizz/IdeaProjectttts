package sh4rkizz.Lab1;

import java.util.Scanner;

public class FactorialOfN {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int len = input.nextInt();
        int factorial = 1;

        for (int i = 1; i < len + 1; i++)
            factorial *= i;

        System.out.println(factorial);
    }
}