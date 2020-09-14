package sh4rkizz.Lab2;

import java.util.Arrays;

public class DogKennel {
    private Dog bark = new Dog("Myxtap", 2);
    private Dog woof = new Dog("Bernie", 7);

    private Dog[] kennel = {bark, woof};

    public Dog[] dogAdd(Dog[] kennel, Dog woof) {
        kennel = Arrays.copyOf(kennel, kennel.length + 1);
        kennel[kennel.length - 1] = woof;
        return kennel;
    }

    public void test() {

        System.out.println("To stop the input, fill in '0' as" +
                " the name of the dog");
        System.out.println("Input goes as: 'name' 'age'");

        System.out.println("\nLook! You already have" +
                " 2 good boys in the Kennel!!");

        for (Dog doggie : kennel) {
            System.out.println(doggie.toString());
        }

        try {
            woof = new Dog();
        } catch (Exception e) {
            System.out.println("An ERROR occurred");
            System.out.println("You shall type numbers as an age, " +
                    "and not letters");
            return;
        }

        while (woof.getName() != "0") {
            kennel = dogAdd(kennel, woof);

            System.out.println("\nLook! You already have " +
                    kennel.length + " good boys in the Kennel!!");

            for (Dog doggie : kennel) {
                System.out.println(doggie.toString());
            }

            try {
                woof = new Dog();
            } catch (Exception e) {
                System.out.println("\nAn ERROR occurred");
                System.out.println("The final DogList before an exception is:");
                for (Dog doggie : kennel) {
                    System.out.println(doggie.toString());
                }
                return;
            }
        }
    }
}