package sh4rkizz.Lab14;

import java.util.ArrayList;
import java.util.Scanner;

public class NoRegularExpressions {
    private static String compare(String line, ArrayList<String> changeFrom, ArrayList<String> changeTo) {
        for (int pos = 0; pos < line.length(); pos++) {
            for (int i = 0; i < changeFrom.size(); i++) {
                String changeF = changeFrom.get(i);
                String changeT = changeTo.get(i);

                if (line.indexOf(changeF) == pos)
                    line = line.replaceFirst(changeF, "/" + changeT + ".");
            }
        }
        line = line.replace("/", "");
        line = line.replace(".", "");

        return line;
    }

    public static String changeLine() {
        Scanner scn = new Scanner(System.in);
        ArrayList<String> changeFrom = new ArrayList<>();
        ArrayList<String> changeTo = new ArrayList<>();
        String line;

        System.out.print("Введите количество условий: ");
        short n = scn.nextShort();
        System.out.println("\nВведите условия: ");


        for (int i = 0; i < n; i++) {
            System.out.print("Change: ");
            changeFrom.add(scn.next());
            changeTo.add(scn.next());
        }
        scn.nextLine();

        System.out.println("Введите строку, которую нужно изменить:");
        line = scn.nextLine();

        return compare(line, changeFrom, changeTo);
    }

    public static void main(String[] args) {
        System.out.println(changeLine());
    }
}