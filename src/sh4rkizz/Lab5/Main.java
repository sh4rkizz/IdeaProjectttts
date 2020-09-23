package sh4rkizz.Lab5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        System.out.println("Choose the code you want to test:\n"
                + "1 - 'MovableCircle'\n"
                + "2 - 'MovableRectangle'");

        switch (inp.nextShort()) {
            case 1: {
                System.out.print("Testing 'MovableCircle'\n"
                        + "Input the radius: ");

                MovableCircle circle = new MovableCircle(inp.nextInt());

                circle.moveDown((int) (Math.random() * 15));
                circle.moveLeft((int) (Math.random() * 15));

                System.out.println(circle.toString());
                break;
            }
            case 2:
                System.out.print("Testing 'MovableRectangle'\n"
                        + "Set 'Top left angle's' coordinates: ");
                MovablePoint leftAngle = new MovablePoint(inp.nextDouble(), inp.nextDouble());

                System.out.println("Set 'Top right angle's' coordinates: ");
                MovablePoint rightAngle = new MovablePoint(inp.nextDouble(), inp.nextDouble());

                MovableRectangle rect = new MovableRectangle(leftAngle, rightAngle);

                leftAngle.moveDown((int) (Math.random() * 15));
                leftAngle.moveRight((int) (Math.random() * 15));

                rightAngle.moveLeft((int) (Math.random() * 15));
                rightAngle.moveUp((int) (Math.random() * 15));

                System.out.println(rect.toString());
                break;
        }
    }
}
