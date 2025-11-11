package Bunny.deliver;
import Bunny.child.Child;

public class SnowshoeHareDelivery implements DeliveryStrategy {
    @Override
    public String deliver(Child child) {
        return "Snowshoe Hare Bunny";
    }
}
