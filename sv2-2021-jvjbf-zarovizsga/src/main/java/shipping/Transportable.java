package shipping;

public interface Transportable {

    int getWeight();
    boolean isBreakable();
    int calculateShippingPrice();

    public default String getDestinationCountry(){
        return "Hungary";
    }

}
