package Bunny.gifts;

public class BookFactory implements GiftFactory {
    @Override
    public Gift createGift(String genre) {
        String title, author;
        switch (genre.toLowerCase()) {
            case "adventure":
                title = "Adventure of completing homework";
                author = "Busy Student";
                break;
            case "science":
                title = "Physic is really not fun";
                author = "My Opinion";
                break;
            case "fantasy":
            default:
                title = "Passing this degree";
                author = "My Dreams";
                genre = "Fantasy";
                break;
        }
        return new Book(title, genre, author);
    }
}