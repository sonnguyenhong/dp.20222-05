package entity.shipping;

import entity.order.Order;
//import org.;
import org.example.DistanceCalculator;
import entity.shipping.ShippingFeeCaculator;
public class DeliveryInfo {

    private String name;
    private String phone;
    private String province;
    private String address;
    private String shippingInstructions;
    protected DistanceAdapter distanceAdapter;

    protected ShippingFeeCaculator shippingFeeCaculator;

    public DeliveryInfo(String name, String phone, String province, String address, String shippingInstructions
            , DistanceAdapter distanceAdapter, ShippingFeeCaculator shippingFeeCaculator
    ) {
        this.name = name;
        this.phone = phone;
        this.province = province;
        this.address = address;
        this.shippingInstructions = shippingInstructions;
        this.distanceAdapter = distanceAdapter;
    }

    public int calculateShippingFee(Order order) {
        return shippingFeeCaculator.caculateShippingFee(order);
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getProvince() {
        return province;
    }

    public String getAddress() {
        return address;
    }

    public String getShippingInstructions() {
        return shippingInstructions;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setShippingInstructions(String shippingInstructions) {
        this.shippingInstructions = shippingInstructions;
    }
}
