package Bunny.gifts;

public class BookFactory implements GiftFactory {
    @Override
    public Gift createGift(String preference, int age) {
        String pref = (preference == null) ? "" : preference.toLowerCase();
        // pick genre based on preference or fall back to age
        String genre;
        if (pref.contains("adventure"))
            genre = "Adventure";
        else if (pref.contains("fantasy"))
            genre = "Fantasy";
        else if (pref.contains("science"))
            genre = "Detective";
        else {
            if (age < 8)
                genre = "Fantasy";
            else if (age < 13)
                genre = "Adventure";
            else
                genre = "Science";
        }

        // choose a simple title and recommended age
        String title;
        int minAge;
        switch (genre) {
            case "Adventure":
                title = "The Lost Island";
                minAge = 9;
                break;
            case "Detective":
                title = "Murder in Orient Express";
                minAge = 12;
                break;
            default:
                title = "Harry Potter";
                minAge = 6;
        }
        return new Book(genre, title, minAge);
    }
}

