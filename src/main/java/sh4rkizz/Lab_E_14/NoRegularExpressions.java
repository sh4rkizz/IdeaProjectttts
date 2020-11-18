package sh4rkizz.Lab_E_14;

import java.util.ArrayList;
import java.util.Scanner;

public class NoRegularExpressions {
    public static void main(String[] args) {
        System.out.println(changeLine());
    }

    private static String compare(String line, ArrayList<String> changeFrom, ArrayList<String> changeTo) {
        for (int pos = 0; pos < line.length(); pos++)
            for (int i = 0; i < changeFrom.size(); i++) {
                String changeF = changeFrom.get(i);
                String changeT = changeTo.get(i);

                if (line.indexOf(changeF) == pos)
                    line = line.replaceFirst(changeF, "/" + changeT + ".");
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

        int n = Integer.parseInt(scn.nextLine());

        for (int i = 0; i < n; i++) {
            changeFrom.add(scn.next());
            changeTo.add(scn.next());
        }
        scn.nextLine();

        line = scn.nextLine();

        return compare(line, changeFrom, changeTo);
    }
}