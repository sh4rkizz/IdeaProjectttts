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
