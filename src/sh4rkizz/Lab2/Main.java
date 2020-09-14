package sh4rkizz.Lab2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        short choice;

        System.out.println("Choose task you want to check");
        System.out.println("1 - Test Shape");
        System.out.println("2 - Test Ball");
        System.out.println("3 - Test Dog");
        System.out.println("4 - Test DogKennel");


        choice = input.nextShort();

        switch (choice) {
            case 1:
                System.out.println("Testing 'Shape'");
                TestShape objectShape = new TestShape();
                objectShape.test();
                break;

            case 2:
                System.out.println("Testing 'Ball'");
                TestBall objectBall = new TestBall();
                objectBall.test();
                break;

            case 3:
                System.out.println("Testing 'Dog'");
                TestDog objectDog = new TestDog();
                objectDog.test();
                break;

            case 4:
                System.out.println("Testing 'DogKennel'");
                DogKennel objectDogKennel = new DogKennel();
                objectDogKennel.test();
                break;
        }
    }
}
