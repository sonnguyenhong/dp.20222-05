package entity.shipping;

import entity.order.Order;

public interface ShippingFeeCaculator {
	public int caculateShippingFee(Order order);
}
