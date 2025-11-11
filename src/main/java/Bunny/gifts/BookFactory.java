package Bunny.gifts;

public class BookFactory implements GiftFactory {
    @Override
    public Gift createGift(String genre) {
        String title, author;
        switch (genre.toLowerCase()) {
            case "adventure":
                title = "The Lost Compass";
                author = "A. V. Smith";
                break;
            case "science":
                title = "Nebula's Edge";
                author = "S. C. Clarke";
                break;
            case "fantasy":
            default:
                title = "The Dragon's Eye";
                author = "E. B. Tolkien";
                genre = "Fantasy";
                break;
        }
        return new Book(title, genre, author);
    }
}