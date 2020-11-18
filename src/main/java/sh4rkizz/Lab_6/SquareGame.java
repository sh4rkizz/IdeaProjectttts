package sh4rkizz.Lab_6;

import java.util.Scanner;

public class SquareGame {
    public static short[][] fieldCreation(short n) {
        short[][] square = new short[n][n];

        for (short i = 0; i < n; i++)
            for (short j = 0; j < n; j++)
                square[i][j] = (short) (Math.random() * 100 - 50);

        return square;
    }

    public static void showField(short n, short[][] square) {
        for (short i = 0; i < n; i++) {
            for (short j = 0; j < n; j++)
                System.out.print(square[i][j] + " ");

            System.out.print("\n");
        }
    }

    public static void squareGame(short n, short[][] square) {
        //showField(n, square);

        if (n == 1) {
            System.out.println(square[0][0]);

            return;
        }

        for (short i = 0; i < n; i++)
            for (short k = 0; k < n; k++)
                if (i != 0) {
                    if (i == n - 1) {
                        if (k != n - 1 && square[i - 1][k + 1] < square[i][k])
                            square[i][k + 1] += square[i][k] - square[i - 1][k + 1];
                    } else {
                        if (!(k == n - 1))
                            if (square[i - 1][k + 1] < square[i][k])
                                square[i][k + 1] += square[i][k] - square[i - 1][k + 1];

                        square[i + 1][k] += square[i][k];
                    }
                } else {
                    if (!(k == n - 1))
                        square[i][k + 1] += square[i][k];

                    square[i + 1][k] += square[i][k];
                }
        System.out.println("The answer is: " + square[n - 1][n - 1]);
    }

    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        short n = inp.nextShort();

        squareGame(n, fieldCreation(n));
    }
}
