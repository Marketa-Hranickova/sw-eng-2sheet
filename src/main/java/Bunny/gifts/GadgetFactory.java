package Bunny.gifts;

public class GadgetFactory implements GiftFactory {
    @Override
    public Gift createGift(String type) {
        String name, model;
        if (type.toLowerCase().contains("smartwatch")) {
            name = "Dumbwatch";
            model = "ABC 78";
            type = "Smartwatch";
        } else if (type.toLowerCase().contains("console")) {
            name = "Gaming buddy";
            model = "345DV";
            type = "Gaming Console";
        } else {
            name = "Earbros";
            model = "THS56";
            type = "Headphones";
        }
        return new Gadget(name, type, model);
    }
}
