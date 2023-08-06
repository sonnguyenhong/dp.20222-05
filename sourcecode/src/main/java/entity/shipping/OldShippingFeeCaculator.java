package entity.shipping;

import entity.order.Order;
import entity.shipping.DistanceAdapter;

public class OldShippingFeeCaculator implements ShippingFeeCaculator {
	@Override
	public int caculateShippingFee(Order order) {
		int distance = order.getDeliveryInfo().distanceAdapter.calculateDistance(order.getDeliveryInfo().getAddress(), order.getDeliveryInfo().getProvince());
		return (int)(distance*1.2);
	}
}
