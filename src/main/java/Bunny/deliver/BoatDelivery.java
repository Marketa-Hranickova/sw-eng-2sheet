package Bunny.deliver;

import Bunny.child.Child;

public class BoatDelivery implements DeliveryStrategy {
    @Override
    public String deliver(Child child) {
        return "Boat";
    }
}
