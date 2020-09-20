package sh4rkizz.Lab3;

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
