package sh4rkizz.Lab1;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MassiveSort {
    public static void math_rand() {
        int quantity;

        quantity = 4 + (int) (Math.random() * 15);

        int[] arr = new int[quantity];

        for (short i = 0; i < quantity; i++) {
            arr[i] = -100 + (int) (Math.random() * 200);
            System.out.print(arr[i] + " ");
        }

        System.out.print("\n");

        Arrays.sort(arr);

        for (short i = 0; i < quantity; i++)
            System.out.print(arr[i] + " ");
    }

    public static void rand() {
        Random random = new Random();

        int num = random.nextInt(15 + 1);

        int[] arr = new int[num];

        for (int i = 0; i < num; i++) {
            arr[i] = random.nextInt(200) - 100;
            System.out.print(arr[i] + " ");
        }

        System.out.print("\n");

        Arrays.sort(arr);

        for (short i = 0; i < num; i++)
            System.out.print(arr[i] + " ");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Choose the sort method:");
        System.out.println("1 - Math.random");
        System.out.println("2 - Random");

        int q = input.nextInt();
        if (q == 1)
            math_rand();
        else
            rand();
    }
}