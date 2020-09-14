package sh4rkizz.Lab2;

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