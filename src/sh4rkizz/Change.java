package sh4rkizz;

import java.util.Scanner;

public class Change {
    private static int findPossibilities(int possibilities, int buff) {
        if (buff == 1)
            return possibilities;

        if (buff % 5 == 0)
            possibilities++;

        if (buff % 3 == 0)
            possibilities++;

        for (int k = 1; k < buff / 3; k++)
            if ((buff - 5 * k) % 3 == 0 && buff - 5 * k > 0) {
                possibilities++;
                break;
            }

        return findPossibilities(possibilities, buff - 1);
    }

    private static void change() {
        Scanner inp = new Scanner(System.in);
        int ex = inp.nextInt();

        if (ex < 3)
            System.out.println(1);

        else if (ex < 5)
            System.out.println(2);

        else System.out.println(findPossibilities(1, ex));
    }

    public static void main(String[] args) {
        change();
    }
}
