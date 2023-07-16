package entity.shipping;

import org.example.DistanceCalculator;

public class DistanceCalculatorAdapter implements DistanceAdapter {
    private DistanceCalculator distanceCalculator;

    public DistanceCalculatorAdapter(DistanceCalculator distanceCalculator) {
        this.distanceCalculator = distanceCalculator;
    }

    @Override
    public int calculateDistance(String address, String province) {
        return distanceCalculator.calculateDistance(address, province);
    }

}
