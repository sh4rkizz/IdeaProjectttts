package sh4rkizz.Lab_2;

import java.util.Scanner;

public class Dog {
    private String name;
    private int age;

    Scanner input = new Scanner(System.in);

    public Dog() {
        this.name = input.nextLine();
        this.age = input.nextInt();
    }

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public void intoHumanAge() {
        System.out.println(name + "'s age in human years is " + age * 7 + " years");
    }
}