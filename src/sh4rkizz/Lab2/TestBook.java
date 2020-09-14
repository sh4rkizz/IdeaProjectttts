package sh4rkizz.Lab2;

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