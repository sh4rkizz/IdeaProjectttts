package sh4rkizz.Lab15;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Node nodeList = new Node();
        Scanner scn = new Scanner(System.in);
        byte step;

        nodeList.inputNodes();
        step = Byte.parseByte(scn.nextLine());

        do {
            System.out.println(nodeList.moveByNodes(step));
            step = Byte.parseByte(scn.nextLine());
        } while (step != -1);
    }
}
