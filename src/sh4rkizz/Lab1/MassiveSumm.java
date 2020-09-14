package sh4rkizz.Lab1;

import java.util.Scanner;

public class MassiveSumm {
    public static void main(String[] args) {
        int len, choice, sum = 0, i;
        Scanner woof = new Scanner(System.in);

        System.out.println("Type in massive length");
        len = woof.nextInt();

        int[] arr = new int[len];

        System.out.println("Type the sum finding method");
        choice = woof.nextInt();

        for (i = 0; i < len; i++)
            arr[i] = woof.nextInt();

        switch (choice) {
            case 1:
                for (i = 0; i < len; i++)
                    sum += arr[i];
                break;
            case 2:
                while (i > 0) {
                    i--;
                    sum += arr[i];
                }
                break;
            case 3:
                do {
                    i--;
                    sum += arr[i];
                }
                while (i > 0);
        }
        System.out.println(sum);
    }
}
