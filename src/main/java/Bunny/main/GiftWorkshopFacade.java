package Bunny.main;
import Bunny.child.GiftPreference;
import Bunny.gifts.*;

public class GiftWorkshopFacade {
    private BookFactory bookFactory = new BookFactory();
    private GadgetFactory gadgetFactory = new GadgetFactory();

    public Gift produceGift(GiftPreference preference, String specificType) {
        switch (preference) {
            case BOOK:
                return bookFactory.createGift(specificType);
            case GADGET:
                return gadgetFactory.createGift(specificType);
            default:
                throw new IllegalArgumentException("Unsupported gift preference.");
        }
    }
}
