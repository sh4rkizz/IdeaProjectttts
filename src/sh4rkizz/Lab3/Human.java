package sh4rkizz.Lab3;

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
