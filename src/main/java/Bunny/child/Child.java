package Bunny.child;


public class Child {
    public String name;
    public int age;
    public LocationType location;
    public GiftPreference preference;
    public String rawPreference;

    public Child(String name, int age, LocationType location, String rawPreference) {
        this.name = name;
        this.age = age;
        this.location = location;
        this.rawPreference = rawPreference;
        try {
            this.preference = GiftPreference.valueOf(rawPreference.toUpperCase());
        } catch (IllegalArgumentException e) {
            this.preference = GiftPreference.UNKNOWN;
        }
    }
}
