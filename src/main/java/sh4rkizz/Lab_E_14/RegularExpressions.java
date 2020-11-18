package sh4rkizz.Lab_E_14;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressions {
    public static void main(String[] args) {
        System.out.println(changeLine());
    }

    public static String changeLine() {
        Scanner scn = new Scanner(System.in);
        StringBuilder stringBuff = new StringBuilder();
        Map<String, String> changingRules = new HashMap<>();
        short n;
        String line;

        n = Short.parseShort(scn.nextLine());

        for (int i = 0; i < n; i++)
            changingRules.put(scn.next(), scn.next());

        scn.nextLine();
        line = scn.nextLine();

        for (int i = 0; i < changingRules.size(); i++) {
            stringBuff.append(changingRules.keySet().toArray()[i]);

            if (i != changingRules.size() - 1)
                stringBuff.append("|");
        }

        Pattern pattern = Pattern.compile(stringBuff.toString());
        Matcher matcher = pattern.matcher(line);

        line = matcher.replaceAll(result -> changingRules.get(result.group()));
        return line;
    }
}