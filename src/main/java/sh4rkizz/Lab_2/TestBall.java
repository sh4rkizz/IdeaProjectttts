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