package shipping;

import java.util.*;

public class ShippingService {
    private List<Transportable> packages = new ArrayList<>();

    public void addPackage(Transportable transportable) {
        packages.add(transportable);
    }

    public List<Transportable> collectItemsByBreakableAndWeight(boolean breakable, int weight) {
        return packages.stream()
                .filter(transportable -> transportable.isBreakable() == breakable && transportable.getWeight() >= weight)
                .toList();
    }

    public Map<String, Integer> collectTransportableByCountry() {
        Map<String, Integer> result = new HashMap<>();
        for (Transportable actual : packages) {
            result.compute(actual.getDestinationCountry(), (a, i) -> (i == null) ? 1 : i + 1);
        }
        return result;
    }

    public List<Transportable> sortInternationalPackagesByDistance() {
        List<Transportable> result = new ArrayList<>(packages);
        return result.stream()
                .filter(InternationalPackage.class::isInstance)
                .sorted(Comparator.comparing(product -> ((InternationalPackage) product).getDistance()))
                .toList();
    }

    public List<Transportable> getPackages() {
        return packages;
    }
}
