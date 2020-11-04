# Java sh4rkizz`s programming report
## Lab_1
**FactorialOfN.java**
```java
package sh4rkizz.Lab_1;

import java.util.Scanner;

public class FactorialOfN {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int len = input.nextInt();
        int factorial = 1;

        for (int i = 1; i < len + 1; i++)
            factorial *= i;

        System.out.println(factorial);
    }
}
```
**HarmonicNumbers.java**
```java
package sh4rkizz.Lab_1;

public class HarmonicNumbers {
    public static void main(String[] args) {
        System.out.print(1);

        for (short i=2; i<11; i++)
            System.out.print(" 1/"+ i);
    }
}
```
**MassiveSort.java**
```java
package sh4rkizz.Lab_1;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MassiveSort {
    public static void math_rand() {
        int quantity = 4 + (int) (Math.random() * 15);

        int[] arr = new int[quantity];

        for (short i = 0; i < quantity; i++) {
            arr[i] = -100 + (int) (Math.random() * 200);
            System.out.print(arr[i] + " ");
        }

        System.out.print("\n");

        Arrays.sort(arr);

        for (short i = 0; i < quantity; i++)
            System.out.print(arr[i] + " ");
    }

    public static void rand() {
        Random random = new Random();

        int num = random.nextInt(15 + 1);

        int[] arr = new int[num];

        for (int i = 0; i < num; i++) {
            arr[i] = random.nextInt(200) - 100;
            System.out.print(arr[i] + " ");
        }

        System.out.print("\n");

        Arrays.sort(arr);

        for (short i = 0; i < num; i++)
            System.out.print(arr[i] + " ");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Choose the sort method:");
        System.out.println("1 - Math.random");
        System.out.println("2 - Random");

        int q = input.nextInt();
        if (q == 1)
            math_rand();
        else
            rand();
    }
}
```
**MassiveSum.java**
```java
package sh4rkizz.Lab_1;

import java.util.Scanner;

public class MassiveSum {
    public static void main(String[] args) {
        int len, choice, sum = 0, i;
        Scanner woof = new Scanner(System.in);

        System.out.println("Type in massive length");
        len = woof.nextInt();

        int[] arr = new int[len];

        System.out.println("Type the sum finding method");
        choice = woof.nextInt();

        for (i = 0; i < len; i++)
            arr[i] = woof.nextInt();

        switch (choice) {
            case 1:
                for (i = 0; i < len; i++)
                    sum += arr[i];
                break;
            case 2:
                while (i > 0) {
                    i--;
                    sum += arr[i];
                }
                break;
            case 3:
                do {
                    i--;
                    sum += arr[i];
                }
                while (i > 0);
        }
        System.out.println(sum);
    }
}
```
**ShowArgs.java**
```java
package sh4rkizz.Lab_1;

public class ShowArgs {
    public static void main(String[] args) {
        for (String arg : args)
            System.out.println(arg);
    }
}
```
## Lab_2
**Ball.java**
```java
package sh4rkizz.Lab_2;

public class Ball {
    private String ballType;
    private double weight;

    public Ball() {
        this.ballType = "None";
        this.weight = 0;
    }

    public Ball(String ballType) {
        this.ballType = ballType;
        this.weight = 0;
    }

    public Ball(String ballType, double weight) {
        this.ballType = ballType;
        this.weight = weight;
    }

    public String getBallType() {
        return this.ballType;
    }

    public double getWeight() {
        return this.weight;
    }

    public void setBallType(String ballType) {
        this.ballType = ballType;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }


    public String toString() {
        return "Ball{" +
                "ballType='" + ballType + '\'' +
                ", weight=" + weight +
                '}';
    }
}
```
**Book.java**
```java
package sh4rkizz.Lab_2;

public class Book {
    private String author, name;

    public Book() {
        this.author = "";
        this.name = "";
    }

    public Book(String author) {
        this.author = author;
        this.name = "";
    }

    public Book(String author, String name) {
        this.author = author;
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", name=" + name +
                '}';
    }
}
```
**Dog.java**
```java
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
```
**DogKennel.java**
```java
package sh4rkizz.Lab_2;

import java.util.Arrays;

public class DogKennel {
    private final Dog bark = new Dog("Myxtap", 2);
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

        while (!woof.getName().equals("0")) {
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
```
**Main.java**
```java
package sh4rkizz.Lab_2;

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
            case 1 -> {
                System.out.println("Testing 'Shape'");
                TestShape objectShape = new TestShape();
                objectShape.test();
            }
            case 2 -> {
                System.out.println("Testing 'Ball'");
                TestBall objectBall = new TestBall();
                objectBall.test();
            }
            case 3 -> {
                System.out.println("Testing 'Dog'");
                TestDog objectDog = new TestDog();
                objectDog.test();
            }
            case 4 -> {
                System.out.println("Testing 'DogKennel'");
                DogKennel objectDogKennel = new DogKennel();
                objectDogKennel.test();
            }
        }
    }
}
```
**Shape.java**
```java
package sh4rkizz.Lab_2;

public class Shape {
    private String name;

    public Shape() {
        this.name = "";
    }

    public Shape(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return "Shape{" +
                "name='" + name + '\'' +
                '}';
    }
}
```
**TestBall.java**
```java
package sh4rkizz.Lab_2;

public class TestBall {
    public void test() {
        Ball b1 = new Ball();
        Ball b2 = new Ball("Football", 153);

        b1.setBallType("Basketball");
        b1.setWeight(337);

        System.out.println(b1.toString());
        System.out.println(b2.toString());
    }
}
```
**TestBook.java**
```java
package sh4rkizz.Lab_2;

public class TestBook {
    public void test() {
        Book b1 = new Book("Nikolai Nosov", "Shurik u dedushki");
        Book b2 = new Book();

        b2.setAuthor("Daniel Defoe");
        b2.setName("Robinson Crusoe");

        System.out.println(b1.toString());
        System.out.println(b2.toString());
    }
}
```
**TestDog.java**
```java
package sh4rkizz.Lab_2;

public class TestDog {
    public void test(){
        Dog woof = new Dog("Ricardo", 6);
        Dog bark = new Dog("", 0);

        bark.setName("J. J. Jameson");
        bark.setAge(12);

        System.out.println(woof.toString());
        System.out.println(bark.toString());

        woof.intoHumanAge();
        bark.intoHumanAge();
    }
}
```
**TestShape.java**
```java
package sh4rkizz.Lab_2;

public class TestShape {
    public void test() {
        Shape fig1 = new Shape();
        Shape fig2 = new Shape("Circle");

        fig1.setName("Rectangle");
        System.out.println(fig1.toString());
        System.out.println(fig2.toString());
    }
}
```
## Lab_3
**Book.java**
```java
package sh4rkizz.Lab_3;

public class Book {
    private int year;
    private String author;
    private  String title;

    public Book() {

    }

    public Book(int year, String author, String title) {
        this.year = year;
        this.author = author;
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Book{" +
                "year=" + year +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
```
**BookTest.java**
```java
package sh4rkizz.Lab_3;

public class BookTest {
    public static void main(String[] args) {
        Book book = new Book(1870,"Daniel Dafoe", "Robinson Crusoe");
        Book kniga = new Book();

        kniga.setAuthor("J.K. Rowling");
        kniga.setTitle("Harry Potter and The Chamber of Secrets");
        kniga.setYear(2001);

        System.out.println(book);
        System.out.println(kniga);
    }
}
```
**Circle.java**
```java
package sh4rkizz.Lab_3;

public class Circle {
    private double radius;
    private String color;

    public Circle() {
        radius = 10;
        color = "pink";
    }

    public Circle(double radius) {
        this.radius = radius;
        color = "green";
    }

    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color){
        this.color = color;
    }

    public void setRadius(double radius){
        this.radius = radius;
    }

    public double calculateArea() {
        return radius * radius * Math.PI;
    }
}
```
**Hand.java**
```java
package sh4rkizz.Lab_3;

public class Hand {

    public Hand(int armsQuantity, int fingerQuantity) {
        this.armsQuantity = armsQuantity;
        this.fingerQuantity = fingerQuantity;
    }

    private int armsQuantity, fingerQuantity;

    public int getArmsQuantity() {
        return armsQuantity;
    }

    public void setArmsQuantity(int armsQuantity) {
        this.armsQuantity = armsQuantity;
    }

    public int getFingerQuantity() {
        return fingerQuantity;
    }

    public void setFingerQuantity(int fingerQuantity) {
        this.fingerQuantity = fingerQuantity;
    }

    @Override
    public String toString() {
        return "Hand{" +
                "armsQuantity=" + armsQuantity +
                ", fingerQuantity=" + fingerQuantity +
                '}';
    }
}
```
**Head.java**
```java
package sh4rkizz.Lab_3;

public class Head {
    private String hairColor;
    private double hairLength;

    public Head(String hairColor, double hairLength) {
        this.hairColor = hairColor;
        this.hairLength = hairLength;
    }

    public String getHairColor() {
        return hairColor;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    public double getHairLength() {
        return hairLength;
    }

    public void setHairLength(double hairLength) {
        this.hairLength = hairLength;
    }

    @Override
    public String toString() {
        return "Head{" +
                "hairColor='" + hairColor + '\'' +
                ", hairLength=" + hairLength +
                '}';
    }
}
```
**Human.java**
```java
package sh4rkizz.Lab_3;

public class Human {
    private Head head;
    private Leg leg;
    private Hand hand;

    private String name;

    public Human() {

    }

    public Human(Head head, Leg leg, Hand hand, String name) {
        this.head = head;
        this.leg = leg;
        this.hand = hand;
        this.name = name;
    }

    public Head getHead() {
        return head;
    }

    public void setHead(Head head) {
        this.head = head;
    }

    public Leg getLeg() {
        return leg;
    }

    public void setLeg(Leg leg) {
        this.leg = leg;
    }

    public Hand getHand() {
        return hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "\nHuman{" + "name=" + name +
                ", " + head +
                ", " + leg +
                ", " + hand +
                '}';
    }
}
```
**Leg.java**
```java
package sh4rkizz.Lab_3;

public class Leg {
    private int fingerQuantity, legSize;

    public Leg(int fingerQuantity, int legSize) {
        this.fingerQuantity = fingerQuantity;
        this.legSize = legSize;
    }

    public int getFingerQuantity() {
        return fingerQuantity;
    }

    public void setFingerQuantity(int fingerQuantity) {
        this.fingerQuantity = fingerQuantity;
    }

    public int getLegSize() {
        return legSize;
    }

    public void setLegSize(int legSize) {
        this.legSize = legSize;
    }

    @Override
    public String toString() {
        return "Leg{" +
                "fingerQuantity=" + fingerQuantity +
                ", legSize=" + legSize +
                '}';
    }
}
```
**Main.java**
```java
package sh4rkizz.Lab_3;

public class Main {
    public static void main(String[] args) {
        TestHuman obj = new TestHuman();
        obj.test();
    }
}
```
**TestCircle.java**
```java
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
```
**TestHuman.java**
```java
package sh4rkizz.Lab_3;

public class TestHuman {
    public void test() {
        Human person = new Human();
        person.setName("Alexa");

        person.setHand(new Hand(2, 10));

        person.setLeg(new Leg(10, 38));

        person.setHead(new Head("Blue", 3.2));

        System.out.println(person);

    }
}
```
## Lab_4
**Circle.java**
```java
package sh4rkizz.Lab_4;

public class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea(){
        return Math.PI*Math.pow(radius, 2);
    }

    public double getPerimeter() {
        return 2*Math.PI*radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                '}';
    }
}
```
**Rectangle.java**
```java
package sh4rkizz.Lab_4;

public class Rectangle extends Shape{
    private double width, length;

    public Rectangle() {

    }

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public Rectangle(String color, boolean filled, double width, double length) {
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getArea() {
        return width*length;
    }

    public double getPerimeter(){
        return (width+length)*2;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", length=" + length +
                '}';
    }
}
```
**Shape.java**
```java
package sh4rkizz.Lab_4;

public abstract class Shape {
    private String color;
    private boolean filled;

    public Shape() {

    }

    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public boolean isFilled() {
        return filled;
    }

    public abstract double getArea();

    public abstract double getPerimeter();

    @Override
    public String toString() {
        return "Shape{" +
                "color='" + color + '\'' +
                ", filled=" + filled +
                '}';
    }
}
```
**Square.java**
```java
package sh4rkizz.Lab_4;

public class Square extends Shape {
    private double side;

    public Square() {
    }

    public Square(double side) {
    }

    public Square(String color, boolean filled, double side) {
        super(color, filled);
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public double getArea() {
        return side * side;
    }

    public double getPerimeter() {
        return side * 2;
    }

    @Override
    public String toString() {
        return "Square{" +
                "side=" + side +
                '}';
    }
}
```
**TestUML.java**
```java
package sh4rkizz.Lab_4;

public class TestUML {
    public static void main(String[] args) {
        Rectangle abc = new Rectangle();
        abc.setWidth(10);
        abc.setLength(14);
        System.out.println(abc.getArea());
    }
}
```
## Lab_5
**Main.java**
```java
package sh4rkizz.Lab_5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        System.out.println("Choose the code you want to test:\n"
                + "1 - 'MovableCircle'\n"
                + "2 - 'MovableRectangle'");

        switch (inp.nextShort()) {
            case 1 -> {
                System.out.print("Testing 'MovableCircle'\n"
                        + "Input the radius: ");

                MovableCircle circle = new MovableCircle(inp.nextInt());

                circle.moveDown((int) (Math.random() * 15));
                circle.moveLeft((int) (Math.random() * 15));

                System.out.println(circle.toString());
            }
            case 2 -> {
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
            }
        }
    }
}
```
**Movable.java**
```java
package sh4rkizz.Lab_5;

public interface Movable {
void moveUp(double up);
void moveDown(double down);
void moveLeft(double left);
void moveRight(double right);
}
```
**MovableCircle.java**
```java
package sh4rkizz.Lab_5;

public class MovableCircle implements Movable {
    private final double radius;
    private final MovablePoint center = new MovablePoint();

    public MovableCircle(int radius) {
        this.radius = radius;
    }

    public void moveUp(double up) {
        center.setX(center.getX()+up);
    }
    public void moveDown(double down) {
        center.setY(center.getY()+down);
    }
    public void moveLeft(double left) {
        center.setX(center.getX()-left);
    }
    public void moveRight(double right) {
        center.setX(center.getX()+right);
    }

    @Override
    public String toString() {
        return "MovableCircle{" +
                "radius=" + radius +
                ", center=" + center +
                '}';
    }
}
```
**MovablePoint.java**
```java
package sh4rkizz.Lab_5;

public class MovablePoint implements Movable {
    private double x, y;

    public MovablePoint() {
    }

    public MovablePoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void moveUp(double up) {
        y -= up;
    }

    public void moveDown(double down) {
        y += down;
    }

    public void moveLeft(double left) {
        x -= left;
    }

    public void moveRight(double right) {
        x += right;
    }

    @Override
    public String toString() {
        return "MovablePoint{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
```
**MovableRectangle.java**
```java
package sh4rkizz.Lab_5;

public class MovableRectangle {
    private double width, length;
    private double perimeter, area;
    private final MovablePoint leftAngle;
    private final MovablePoint rightAngle;

    public MovableRectangle(MovablePoint leftAngle, MovablePoint rightAngle) {
        this.leftAngle = leftAngle;
        this.rightAngle = rightAngle;
    }

    public double getWidth() {
        return width;
    }

    public double getLength() {
        return length;
    }

    public void recalculateParameters(MovablePoint rightAngle, MovablePoint leftAngle) {
        this.length = Math.abs(rightAngle.getX() - leftAngle.getX());
        this.width = Math.abs(rightAngle.getY() - leftAngle.getY());
        this.perimeter = 2 * (this.width + this.length);
        this.area = this.width * this.length;
    }

    @Override
    public String toString() {
        recalculateParameters(rightAngle, leftAngle);

        return "\nMovableRectangle {" +
                "\nLeftAngle = " + leftAngle +
                ", rightAngle = " + rightAngle +
                "\nWidth = " + width +
                ", length = " + length +
                "\nPerimeter = " + perimeter +
                ", area = " + area +
                "\n}";
    }
}
```
## Lab_6
**SquareGame.java**
```java
package sh4rkizz.Lab_6;

import java.util.Scanner;

public class SquareGame {
    public static short[][] fieldCreation(short n) {
        short[][] square = new short[n][n];

        for (short i = 0; i < n; i++)
            for (short j = 0; j < n; j++)
                square[i][j] = (short) (Math.random() * 100 - 50);

        return square;
    }

    public static void showField(short n, short[][] square) {
        for (short i = 0; i < n; i++) {
            for (short j = 0; j < n; j++)
                System.out.print(square[i][j] + " ");

            System.out.print("\n");
        }
    }

    public static void squareGame(short n, short[][] square) {
        //showField(n, square);

        if (n == 1) {
            System.out.println(square[0][0]);

            return;
        }

        for (short i = 0; i < n; i++)
            for (short k = 0; k < n; k++)
                if (i != 0) {
                    if (i == n - 1) {
                        if (k != n - 1 && square[i - 1][k + 1] < square[i][k])
                            square[i][k + 1] += square[i][k] - square[i - 1][k + 1];
                    } else {
                        if (!(k == n - 1))
                            if (square[i - 1][k + 1] < square[i][k])
                                square[i][k + 1] += square[i][k] - square[i - 1][k + 1];

                        square[i + 1][k] += square[i][k];
                    }
                } else {
                    if (!(k == n - 1))
                        square[i][k + 1] += square[i][k];

                    square[i + 1][k] += square[i][k];
                }
        System.out.println("The answer is: " + square[n - 1][n - 1]);
    }

    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        short n = inp.nextShort();

        squareGame(n, fieldCreation(n));
    }
}
```
## Lab_7_8
**Company.java**
```java
package sh4rkizz.Lab_7_8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Company {
    private static double companyIncome = 0;
    private final ArrayList<Employee> staff = new ArrayList<>();
    private final ArrayList<Employee> staffSalarySorted = new ArrayList<>();

    public List<Employee> getTopSalaryStaff(int count) {
        staffSalarySorted.clear();

        for (int j = 0; j < staff.size(); j++)
            for (int i = 0; i < staff.size() - j - 1; i++)
                if (staff.get(i).getSalary() < staff.get(i + 1).getSalary())
                    Collections.swap(staff, i, i + 1);


        for (int i = 0; i < count; i++) {
            staffSalarySorted.add(staff.get(i));
        }

        return staffSalarySorted;
    }
    public List<Employee> getLowestSalaryStaff(int count) {
        staffSalarySorted.clear();

        for (int j = 0; j < staff.size(); j++)
            for (int i = 0; i < staff.size() - j - 1; i++)
                if (staff.get(i).getSalary() > staff.get(i + 1).getSalary())
                    Collections.swap(staff, i, i + 1);

        for (int i = 0; i < count; i++) {
            staffSalarySorted.add(staff.get(i));
        }

        return staffSalarySorted;
    }

    public void hire(Employee intern) {
        staff.add(intern);
    }

    public void hireAll(ArrayList<Employee> interns) {
        staff.addAll(interns);
    }

    public void fire(Employee getRidOfHim) {
        staff.remove(getRidOfHim);
    }

    public static void nullIncome() {
        companyIncome = 0;
    }

    public static void setIncome(double income) {
        companyIncome += income;
    }

    public static double getIncome() {
        return companyIncome;
    }

    public ArrayList<Employee> getStaff() {
        return staff;
    }
}
```
**Employee.java**
```java
package sh4rkizz.Lab_7_8;

public class Employee {
    private String name, surname, position;
    private final double salary;

    public Employee(Operator operator) {
        this.position = operator.getJobTitle();
        this.salary = operator.calcSalary(80000);
    }

    public Employee(Manager manager) {
        this.position = manager.getJobTitle();
        manager.setCompanyIncome();
        this.salary = manager.calcSalary(95000);
    }

    public Employee(TopManager topManager) {
        this.position = topManager.getJobTitle();
        this.salary = topManager.calcSalary(75000);
    }

    public String getJobTitle() {
        return position;
    }

    public double getSalary() {
        return salary;
    }
}
```
**EmployeePosition.java**
```java
package sh4rkizz.Lab_7_8;

public interface EmployeePosition {
    String getJobTitle();
    double calcSalary(double baseSalary);
}
```
**Main.java**
```java
package sh4rkizz.Lab_7_8;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Main {
    private static boolean checkError(int cnt, Company samsung) {
        if (cnt <= 0) {
            System.out.println("Incorrect input\n" +
                    "'count' = " + cnt + " is not a natural number");
            return false;
        } else if (cnt > samsung.getStaff().size()) {
            System.out.println("Incorrect input\n"
                    + "Currently, 'Company' has less than " + cnt + "employees");
            return false;
        } else return true;
    }

    public static void main(String[] args) {
        NumberFormat nf = new DecimalFormat("#.##");
        Company apple = new Company();
        int staffSize, count, k, cnt = 0;

        for (int i = 0; i < 180; i++) {
            Employee operator = new Employee(new Operator());
            apple.hire(operator);
        }

        for (int i = 0; i < 80; i++) {
            Employee manager = new Employee(new Manager());
            apple.hire(manager);
        }

        for (int i = 0; i < 10; i++) {
            Employee topManager = new Employee(new TopManager());
            apple.hire(topManager);
        }

        staffSize = apple.getStaff().size();

        count = (int) (15 - Math.random() * 5);
        System.out.println("Top salary list:");
        if (checkError(count, apple))
            for (int i = 0; i < count; i++)
                System.out.println(nf.format(apple.getTopSalaryStaff(count).get(i).getSalary()) + " rub.");

        count = 30;
        System.out.println("Lowest salary list:");
        if (checkError(count, apple))
            for (int i = 0; i < count; i++)
                System.out.println(nf.format(apple.getLowestSalaryStaff(count).get(i).getSalary()) + " rub.");

        for (int i = 0; i < staffSize / 2; i++) {
            k = (int) (Math.random() * apple.getStaff().size());
            apple.fire(apple.getStaff().get(k));
        }

        Company.nullIncome();
        for (Employee employee : apple.getStaff())
            if (employee.getJobTitle().equals("Manager"))
                Company.setIncome((employee.getSalary() - 95000) * 20);

        for (int i = apple.getStaff().size() - 1; i >= 0; i--)
            if (apple.getStaff().get(i).getJobTitle().equals("TopManager")) {
                cnt++;
                apple.fire(apple.getStaff().get(i));
            }
        for (int i = 0; i < cnt; i++) {
            Employee topManager = new Employee(new TopManager());
            apple.hire(topManager);
        }

        staffSize = apple.getStaff().size();
        for (int i = 0; i < staffSize; i++)
            System.out.println(i + " " + apple.getStaff().get(i).getJobTitle()
                    + " " + nf.format(apple.getStaff().get(i).getSalary()) + " rub.");

        count = (int) (15 - Math.random() * 5);
        System.out.println("Top salary list after dismissal of 50% of employees:");
        if (checkError(count, apple))
            for (int i = 0; i < count; i++)
                System.out.println(nf.format(apple.getTopSalaryStaff(count).get(i).getSalary()) + " rub.");

        count = 30;
        System.out.println("Lowest salary list after dismissal of 50% of employees:");
        if (checkError(count, apple))
            for (int i = 0; i < count; i++)
                System.out.println(nf.format(apple.getLowestSalaryStaff(count).get(i).getSalary()) + " rub.");
    }
}
```
**Manager.java**
```java
package sh4rkizz.Lab_7_8;

public class Manager implements EmployeePosition {
    private final String jobTitle;
    private double salary, localIncome;

    public Manager() {
        this.jobTitle = "Manager";
    }

    public void setCompanyIncome() {
        this.localIncome = 140000 - Math.random() * 25000;
        Company.setIncome(localIncome);
    }

    @Override
    public String getJobTitle() {
        return jobTitle;
    }

    @Override
    public double calcSalary(double baseSalary) {
        this.salary = baseSalary + this.localIncome * 0.05;
        return salary;
    }
}
```
**Operator.java**
```java
package sh4rkizz.Lab_7_8;

public class Operator implements EmployeePosition {
    private final String jobTitle;
    private double salary;

    public Operator() {
        this.jobTitle = "Operator";
    }

    @Override
    public String getJobTitle() {
        return jobTitle;
    }

    @Override
    public double calcSalary(double baseSalary) {
        salary = baseSalary;
        return salary;
    }
}
```
**TopManager.java**
```java
package sh4rkizz.Lab_7_8;

public class TopManager implements EmployeePosition {
    private final String jobTitle;
    private double salary;

    public TopManager() {
        this.jobTitle = "TopManager";
    }

    @Override
    public String getJobTitle() {
        return jobTitle;
    }

    @Override
    public double calcSalary(double baseSalary) {
        this.salary = baseSalary;

        if (Company.getIncome() > 10000000)
            this.salary += 1.5 * baseSalary;

        return salary;
    }
}
```
## Lab_9
**Company.java**
```java
package sh4rkizz.Lab_9;

import java.util.ArrayList;
import java.util.Scanner;

public class Company implements Factory {
    private final ArrayList<Employee> staff = new ArrayList<>();
    private final Scanner in = new Scanner(System.in);

    public void hire(Employee intern) {
        staff.add(intern);
    }

    public void hireAll(ArrayList<Employee> interns) {
        for (Employee intern : interns)
            hire(intern);
    }

    public void fire(Employee getRidOfHim) {
        staff.remove(getRidOfHim);
    }

    public void fireAll(ArrayList<Employee> getRidOfThem) {
        for (Employee getRidOfHim : getRidOfThem)
            fire(getRidOfHim);
    }

    public ArrayList<Employee> getStaff() {
        return staff;
    }

    public void increaseSalary(ArrayList<Employee> employees, double increment) {
        for (Employee employee : employees)
            employee.increaseSalary(increment);
    }

    public void decreaseSalary(ArrayList<Employee> employees, double decrement) {
        for (Employee employee : employees)
            employee.decreaseSalary(decrement);
    }

    public void outStaffSalary() {
        for (Employee emp : staff)
            System.out.println(emp.getName() + " " + emp.getSalary() + "rub.");
    }

    @Override
    public void handleEmployees(ArrayList<Employee> employees) {
        System.out.println("1 - if you want to hire these interns to the company");
        System.out.println("2 - if you want to fire these employees");
        System.out.println("3 - if you want to increase the salary of these workers");
        System.out.println("4 - if you want to decrease the salary of these workers");
        System.out.println("5 - if you want to get the list of employees");

        switch (in.nextShort()) {
            case 1 -> hireAll(employees);
            case 2 -> fireAll(employees);
            case 3 -> {
                System.out.println("Input the salary`s increment");
                increaseSalary(employees, in.nextDouble());
            }
            case 4 -> {
                System.out.println("Input the salary`s decrement");
                decreaseSalary(employees, in.nextDouble());
            }
            case 5 -> {
                System.out.println("Employees list:");
                outStaffSalary();
            }
            default -> System.exit(0);
        }
    }
}
```
**Employee.java**
```java
package sh4rkizz.Lab_9;

public class Employee {
    private String name, surname, telephoneNumber, residence;
    private double salary;

    public Employee(double salary) {
        this.salary = salary;
        this.name = setRandName();
    }

    public String getName() {
        return name;
    }

    public String setRandName() {
        final String alphaString = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        int k = 25 - (int) (Math.random() * 25);

        for (int i = 0; i < 4; i++) {
            name += alphaString.charAt(k);
            k = 51 - (int) (Math.random() * 25);
        }
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getResidence() {
        return residence;
    }

    public void setResidence(String residence) {
        this.residence = residence;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void increaseSalary(double increase) {
        salary += increase;
    }

    public void decreaseSalary(double decrease) {
        salary -= decrease;
    }
}
```
**Factory.java**
```java
package sh4rkizz.Lab_9;

import java.util.ArrayList;

public interface Factory {
        void handleEmployees(ArrayList<Employee> employees);
}
```
**Main.java**
```java
package sh4rkizz.Lab_9;

import java.util.ArrayList;

public class Main {
    private static final Company apple = new Company();
    private static final ArrayList<Employee> interns = new ArrayList<>();

    public static void test() {
        Factory factory;
        factory = (interns) -> apple.handleEmployees(interns);
        factory.handleEmployees(interns);
        apple.outStaffSalary();
        interns.clear();
    }

    public static void main(String[] args) {

        //Создание стартовой компании
        for (int i = 0; i < 30; i++)
            interns.add(new Employee(30000));
        apple.hireAll(interns);
        interns.clear();

        //Тест найма
        for (int i = 0; i < 10; i++)
            interns.add(new Employee(15000));
        test();

        //Тест увольнения
        for (int i = 0; i < apple.getStaff().size(); i += 2)
            interns.add(apple.getStaff().get(i));
        test();

        //Тест прибавки к ЗП
        for (Employee employee : apple.getStaff())
            if (employee.getSalary() < 35000)
                interns.add(employee);
        test();

        //Тест урезания ЗП
        for (Employee employee : apple.getStaff())
            if (employee.getSalary() > 45000)
                interns.add(employee);
        test();
    }
}
```
## Lab_A_10
**Calculator.java**
```java
package sh4rkizz.Lab_A_10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.util.Objects;

public class Calculator extends JFrame {
    private final JButton mButton = new JButton("*");
    private final JButton dButton = new JButton("/");
    private final JButton aButton = new JButton("+");
    private final JButton sButton = new JButton("-");
    private final JTextField inputA = new JTextField("Значение А");
    private final JTextField inputB = new JTextField("Значение Б");
    private final JTextField resultField = new JTextField("Результат");
    private double valA, valB, result;

    public Calculator(String title) {
        super(title);
        Font font = new Font("Serif", Font.PLAIN, 30);
        JFrame container = new JFrame(title);

        int x = 40, y = 125;
        final int side = 56, gap = 30;
        aButton.setBounds(x, y, side, side);

        inputA.setHorizontalAlignment(JTextField.CENTER);
        inputB.setHorizontalAlignment(JTextField.CENTER);
        resultField.setHorizontalAlignment(JTextField.CENTER);

        x += side + gap;
        inputA.setBounds(x - gap, y - side - gap - 15, 2 * side + 3 * gap, side);
        inputB.setBounds(x - gap, y + gap + side + 15, 2 * side + 3 * gap, side);
        resultField.setBounds(x - 2 * gap, y + gap + 4 * side + 15, 2 * side + 5 * gap, side);
        sButton.setBounds(x, y, side, side);

        x += side + gap;
        dButton.setBounds(x, y, side, side);

        x += side + gap;
        mButton.setBounds(x, y, side, side);

        mButton.addActionListener(new Calc());
        dButton.addActionListener(new Calc());
        aButton.addActionListener(new Calc());
        sButton.addActionListener(new Calc());
        inputB.addActionListener(new Calc());
        inputA.addActionListener(new Calc());

        sButton.setFont(font);
        dButton.setFont(font);
        aButton.setFont(font);
        mButton.setFont(font);
        resultField.setFont(font);
        inputA.setFont(font);
        inputB.setFont(font);

        container.add(sButton);
        container.add(mButton);
        container.add(dButton);
        container.add(aButton);
        container.add(inputA);
        container.add(inputB);
        container.add(resultField);

        inputA.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                inputA.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (Objects.equals(inputA.getText(), ""))
                    inputA.setText("Значение А");
            }
        });

        inputB.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                inputB.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (Objects.equals(inputB.getText(), ""))
                    inputB.setText("Значение А");
            }
        });

        container.setLayout(null);
        container.setVisible(true);
        container.setBounds(770, 170, 400, 550);
    }

    class Calc implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String resultStr = "";
            try {
                valA = Double.parseDouble(inputA.getText());
                try {
                    valB = Double.parseDouble(inputB.getText());
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,
                            "Second input is incorrect",
                            "Output", JOptionPane.PLAIN_MESSAGE);
                    resultStr = "error";
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,
                        "First input is incorrect",
                        "Output", JOptionPane.PLAIN_MESSAGE);
                resultStr = "error";
            }
            if (!resultStr.equals("error")) {
                if (event.getSource() == mButton)
                    result = valA * valB;
                else if (event.getSource() == sButton)
                    result = valA - valB;
                else if (event.getSource() == aButton)
                    result = valA + valB;
                else if (event.getSource() == dButton)
                    result = valA / valB;

                resultStr = new DecimalFormat("#.####").format(result);
                resultField.setText(resultStr);
            }
        }
    }
}
```
**Main.java**
```java
package sh4rkizz.Lab_A_10;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator("Calculator");
        calculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
```
## Lab_B_11
**Threads.java**
```java
package sh4rkizz.Lab_B_11;

import java.util.concurrent.atomic.AtomicLong;

public class Threads extends Thread {
    private static AtomicLong countRuns = new AtomicLong(0);

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " " + operations());
    }

    public static long operations() {
        long number = 900_000_000;
        final long num = 700_000_000;

        for (int i = 0; i < 9_000_000; i++) {
            number = (long) (num - Math.sqrt(num * num) - Math.sqrt((Math.sqrt(num)
                    * (long) (Math.random() * Math.sqrt(Math.sqrt(num) * num))
                    / Math.sqrt(num - num * (long) (Math.random())) + num)));
            raiseCountRuns();
        }
        return number;
    }

    public static void raiseCountRuns() {
        countRuns.incrementAndGet();
    }

    public static AtomicLong getCountRuns(){
        return countRuns;
    }
}
```
**ThreadsOperation.java**
```java
package sh4rkizz.Lab_B_11;

public class ThreadsOperation {
    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 10; i++) {
            Thread thread = new Threads();
            thread.start();
            thread.join();
        }

        long endTime = System.currentTimeMillis();
        long result = endTime - startTime;
        System.out.println("Total threads time: " + result);

        startTime = System.currentTimeMillis();
        Threads main = new Threads();

        for (int i = 0; i < 10; i++)
            main.run();

        endTime = System.currentTimeMillis();
        System.out.println("Total runs: " + Threads.getCountRuns());
        System.out.println("Total main thread time: " + (endTime - startTime));

        result -= endTime - startTime;
        System.out.println("The difference between timers equals: " + result);
    }
}
```
## Lab_C_12
**ColoredText.java**
```java
package sh4rkizz.Lab_C_12;

public enum ColoredText {
    RED_TEXT("\u001B[31m", "Red"),
    GREEN_TEXT("\u001B[32m", "Green"),
    YELLOW_TEXT("\u001B[33m", "Yellow"),
    BLUE_TEXT("\u001B[34m", "Blue"),
    PURPLE_TEXT("\u001B[35m", "Purple"),
    CYAN_TEXT("\u001B[36m", "Cyan"),
    WHITE_TEXT("\u001B[30m", "White"),
    RESET_COLOR("\u001B[0m", "");

    private final String color;
    private final String name;

    ColoredText(String color, String name) {
        this.color = color;
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public String getName() {
        return name;
    }
}
```
**Colors.java**
```java
package sh4rkizz.Lab_C_12;

public class Colors {
    public static void outColoredText(String message, ColoredText COLOR) {
        System.out.println(COLOR.getColor() + message + ColoredText.RESET_COLOR);
    }

    public static void test() {
        String message = "Сейчас 12 ночи, я прогаю на жаве";
        outColoredText(ColoredText.YELLOW_TEXT.getName() + " " + message, ColoredText.YELLOW_TEXT);

        message = "Придумывать сообщения для этих тестов очень сложно";
        outColoredText(ColoredText.RED_TEXT.getName() + " " + message, ColoredText.RED_TEXT);

        message = "Поэтому анекдот!";
        outColoredText(ColoredText.CYAN_TEXT.getName() + " " + message, ColoredText.CYAN_TEXT);

        message = "Колобок повесился";
        outColoredText(ColoredText.PURPLE_TEXT.getName() + " " + message, ColoredText.PURPLE_TEXT);

        message = "Смешно.";
        outColoredText(ColoredText.BLUE_TEXT.getName() + " " + message, ColoredText.BLUE_TEXT);
    }

    public static void main(String[] args) {
        test();
    }
}
```
## Lab_D_13
**Main.java**
```java
package sh4rkizz.Lab_D_13;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        test();
        myRuntimeException();
    }

    public static void test() throws InterruptedException {
        try {
            myExcept(Math.random() < 0.5);
            except();
        } catch (MyException myEx) {
            System.out.println("Сработал 'MyException'");
        } catch (Exception ex) {
            System.out.println("Сработал 'Exception'");
        } finally {
            System.out.print("Совершаются очень важные действия");
            for (int i = 0; i < 10; i++) {
                Thread.sleep(500);
                System.out.print(".");
            }
            System.out.println("\nВажные действия совершены");
        }
    }

    public static void except() throws Exception {
        throw new Exception();
    }

    public static void myExcept(boolean b) throws MyException {
        if (b)
            throw new MyException();
    }

    public static void myRuntimeException() {
        throw new MyRuntimeException();
    }
}
```
**MyException.java**
```java
package sh4rkizz.Lab_D_13;

public class MyException extends IllegalAccessException {
}
```
**MyRuntimeException.java**
```java
package sh4rkizz.Lab_D_13;

public class MyRuntimeException extends RuntimeException {
    public MyRuntimeException() {
        System.out.println("Сработал 'MyRuntimeException'");
    }
}
```
## Lab_E_14
**NoRegularExpressions.java**
```java
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
```
**RegularExpressions.java**
```java
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
```
## Lab_F_15_16
**Main.java**
```java
package sh4rkizz.Lab_F_15_16;

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
```
**Node.java**
```java
package sh4rkizz.Lab_F_15_16;

import java.util.ArrayList;

class Node {
    private final static ArrayList<String> message = new ArrayList<>();
    private final static ArrayList<Node> nodes = new ArrayList<>();
    private Node first, second;
    private Node activeNode;

    public void inputNodes() {
        for (byte i = 0; i < 5; i++)
            nodes.add(new Node());

        nodes.get(0).setFirstAndSecond(nodes.get(1), nodes.get(4));
        nodes.get(1).setFirstAndSecond(nodes.get(2), nodes.get(3));
        nodes.get(2).setFirstAndSecond(nodes.get(3), nodes.get(4));
        nodes.get(3).setFirstAndSecond(nodes.get(2), nodes.get(4));
        nodes.get(4).setFirstAndSecond(nodes.get(0), nodes.get(2));

        activeNode = nodes.get(0);

        message.add("create_project");
        message.add("add_library");
        message.add("restart");
        message.add("test");
        message.add("deploy");
        message.add("drop_db");
    }

    private void setFirstAndSecond(Node first, Node second) {
        this.first = first;
        this.second = second;
    }

    private void setActiveNode(Node activeNode, byte step) {
        switch (step) {
            case 0 -> this.activeNode = activeNode.first;
            case 1 -> this.activeNode = activeNode.second;
            default -> this.activeNode = null;
        }
    }

    public String moveByNodes(byte step) {
        setActiveNode(activeNode, step);

        return message.get((byte) (Math.random() * 6));
    }
}


```
## Lab_G_17_18
**ReportMaker.java**
```java
package sh4rkizz.Lab_G_17_18;

import java.io.*;

public class ReportMaker {
    private static final String basePath = "src/sh4rkizz";
    private static final String mdFilePath = basePath + "/Lab_G_17_18/result.md";

    public static void main(String[] args) {
        File file = new File(basePath);

        try (PrintWriter writer = new PrintWriter(mdFilePath)) {
            writer.write("# " + "Java sh4rkizz`s programming report" + "\n");
        } catch (Exception exception) {
            System.out.println("File has not been opened");
            exception.printStackTrace();
        }

        if (file.isDirectory()) {
            File[] fileList = file.listFiles();

            if (fileList != null)
                for (File f : fileList)
                    reportCreator(f.getPath());
        }
    }

    public static void reportCreator(String path) {
        File file = new File(path);
        String line;
        String[] files = null;

        if (file.isDirectory())
            files = file.list();

        try (FileWriter writer = new FileWriter(mdFilePath, true)) {
            writer.write("## " + path.substring(path.lastIndexOf("\\") + 1) + "\n");

            if (files != null)
                for (String str : files)
                    if (str.endsWith(".java")) {
                        writer.write("**" + str + "**" + "\n");
                        writer.write("```java" + "\n");

                        try (BufferedReader reader = new BufferedReader(new FileReader(path + "/" + str))) {
                            line = reader.readLine();

                            while (line != null) {
                                writer.write(line + "\n");
                                line = reader.readLine();
                            }
                        } catch (Exception exception) {
                            System.out.println("An error occurred when when the the .java file search conducted");
                            exception.printStackTrace();
                        }

                        writer.write("```" + "\n");
                    }
        } catch (IOException ioException) {
            System.out.println("An error occurred when was the .md file search conducted");
            ioException.printStackTrace();
        }
    }
}
```
