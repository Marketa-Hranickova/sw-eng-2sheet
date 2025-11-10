package Bunny.deliver;

public class DeliverySelector {

    public static DeliveryStrategy select(String locationType) {
        if (locationType == null)
            return null;
        String which = locationType.toLowerCase().trim();
        switch (which) {
            case "snowy":
            case "mountain":
                return new SnowshoeHareBunny();
            case "urban":
            case "city":
                return new DroneDelivery();
            case "coastal":
            case "island":
            case "sea":
                return new BoatDelivery();
            default:
                return null;
        }
    }
}

