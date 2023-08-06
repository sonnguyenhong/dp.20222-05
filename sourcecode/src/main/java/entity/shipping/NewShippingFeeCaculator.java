package entity.shipping;

import entity.order.Order;


public class NewShippingFeeCaculator implements ShippingFeeCaculator {
	@Override
	public int caculateShippingFee(Order order) {
		int distance = order.getDeliveryInfo().distanceAdapter.calculateDistance(order.getDeliveryInfo().getAddress(), order.getDeliveryInfo().getProvince());
		return distance;
	}
}
