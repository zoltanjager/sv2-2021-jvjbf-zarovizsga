package shipping;

public class InternationalPackage implements Transportable {
    private int weight;
    private boolean breakable;
    private String destinationCountry;
    private int distance;
    private static final int SHIPPING_COST = 1200;

    public InternationalPackage(int weight, boolean breakable, String destinationCountry, int distance) {
        this.weight = weight;
        this.breakable = breakable;
        this.destinationCountry = destinationCountry;
        this.distance = distance;
    }

    @Override
    public int getWeight() {
        return weight;
    }

    @Override
    public boolean isBreakable() {
        return breakable;
    }

    @Override
    public int calculateShippingPrice() {
        if (breakable) {
            return SHIPPING_COST * 2 + distance * 10;
        }
        return SHIPPING_COST + distance * 10;
    }

    @Override
    public String getDestinationCountry() {
        return destinationCountry;
    }

    public int getDistance() {
        return distance;
    }
}
