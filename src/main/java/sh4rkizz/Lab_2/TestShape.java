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