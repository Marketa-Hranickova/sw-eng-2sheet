package Bunny.gifts;



public class Book implements Gift {
    private String title;
    private String genre;
    private String author;
    private String isbn;
    private int pages;

    public Book(String title, String genre, String author) {
        this.title = title;
        this.genre = genre;
        this.author = author;
        this.isbn = "ISBN-" + Math.abs(title.hashCode());
        this.pages = 250 + (title.length() * 5);
    }

    @Override
    public String describe() {
        return this.genre + " Book (" + this.title + " by " + this.author + ")";
    }
}
