package sh4rkizz.Lab2;

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