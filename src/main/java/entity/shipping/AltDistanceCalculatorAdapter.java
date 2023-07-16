package entity.shipping;

public class AltDistanceCalculatorAdapter implements DistanceAdapter {
    private AltDistanceCalculator altDistanceCalculator;

    public AltDistanceCalculatorAdapter(AltDistanceCalculator altDistanceCalculator) {
        this.altDistanceCalculator = altDistanceCalculator;
    }

    @Override
    public int calculateDistance(String address, String province) {
        String fullAddress = address + " " + province;
        return altDistanceCalculator.calculateDistance(fullAddress);
    }
}
