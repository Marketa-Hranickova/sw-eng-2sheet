package Bunny.gifts;

public class Gadget implements Gift {
    private final String type;
    private final String brand;
    private final int minAge;

    public Gadget(String type, String brand, int minAge) {
        this.type = type;
        this.brand = brand;
        this.minAge = minAge;
    }
    @Override
    public String getDescription() {
        return brand + " " + type + " (Gadget)";
    }

    public int getMinAge() {
        return minAge;
    }

}
