package Bunny.deliver;

public class DeliveryContext {
    private DeliveryStrategy strategy;

    public void setStrategy(DeliveryStrategy strategy) {
        this.strategy = strategy;
    }

    public String executeDelivery() {
        return strategy.getName();
    }
}
