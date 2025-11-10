package Bunny.gifts;

public class GadgetFactory implements GiftFactory {
    @Override
    public Gift createGift(String preference, int age) {
        String pref = (preference == null) ? "" : preference.toLowerCase();
        if (pref.contains("phone")) {
            return new Gadget("phone", "Apple", 12);
        } else if (pref.contains("headphones") || pref.contains("headset")) {
            return new Gadget("Headphones", "Sony", 8);
        } else if (pref.contains("pc") || pref.contains("computer")) {
            return new Gadget("computer", "Asus", 13);
        } else {
            // fallback: choose a sensible default based on age
            if (age >= 14)
                return new Gadget("Phone", "Apple", 12);
            if (age >= 10)
                return new Gadget("Headphones", "Sony", 8);
            return null; // too young for gadgets by default
        }
    }
}
