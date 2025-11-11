package Bunny.main;

import Bunny.child.Child;
import Bunny.child.LocationType;
import Bunny.deliver.*;


public class DeliveryContext {

    private static DeliveryStrategy getStrategy(LocationType location) {
        switch (location) {
            case SNOWY:
                return new SnowshoeHareDelivery();
            case URBAN:
                return new DroneDelivery();
            case COASTAL:
                return new BoatDelivery();
            default:
                throw new IllegalArgumentException("Unsupported location type: " + location);
        }
    }

    public static String executeDelivery(Child child) {
        DeliveryStrategy strategy = getStrategy(child.location);
        return strategy.deliver(child);
    }
}
