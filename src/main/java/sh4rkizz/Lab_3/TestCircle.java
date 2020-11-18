package sh4rkizz.Lab_3;

import java.util.Scanner;

public class TestCircle {

    public static void main(String[] args) {

        System.out.println("Testing 'Circle'");
        TestCircle objectCircle = new TestCircle();
        objectCircle.test();
    }

    public void test() {

        System.out.println("Testing Default settings");
        Circle c1 = new Circle(5, "red");

        System.out.println("Radius is " + c1.getRadius()
                + " Color is " + c1.getColor()
                + " Area is " + c1.calculateArea());

        Circle c2 = new Circle(2.0);
        System.out.println("Radius is " + c2.getRadius()
                + " Color is " + c2.getColor()
                + " Area is " + c2.calculateArea());
        System.out.println("\nType in color and radius of your circle");

        Circle circle = new Circle();

        Scanner input = new Scanner(System.in);

        try {
            circle.setColor(input.nextLine());
            circle.setRadius(input.nextInt());
        } catch (Exception e) {
            System.out.println("An error occurred");
            return;
        }

        System.out.println("Radius is " + circle.getRadius()
                + " Color is " + circle.getColor()
                + " Area is " + circle.calculateArea());
    }
}
