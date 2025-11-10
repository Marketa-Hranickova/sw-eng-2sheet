package Bunny.gifts;

public class Book implements Gift {
    private final String genre;
    private final String title;
    private final int minAge;

    public Book(String genre, String title, int minAge) {
        this.genre = genre;
        this.title = title;
        this.minAge = minAge;
    }

    @Override
    public String getDescription() {
        return genre + " Book: " + title;
    }

    public int getRecommendedAge() {
        return minAge;
    }
}
