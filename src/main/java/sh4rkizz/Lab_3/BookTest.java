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
