package Bunny.gifts;

public class GadgetFactory implements GiftFactory {
    @Override
    public Gift createGift(String type) {
        String name, model;
        if (type.toLowerCase().contains("smartwatch")) {
            name = "Aura 5";
            model = "SM-05";
            type = "Smartwatch";
        } else if (type.toLowerCase().contains("console")) {
            name = "Zenith X";
            model = "GC-01";
            type = "Gaming Console";
        } else {
            name = "Clarity Buds";
            model = "HP-77";
            type = "Headphones";
        }
        return new Gadget(name, type, model);
    }
}
