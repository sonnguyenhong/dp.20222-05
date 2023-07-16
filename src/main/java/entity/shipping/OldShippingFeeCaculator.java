package entity.shipping;

import entity.order.Order;

public class OldShippingFeeCaculator implements ShippingFeeCaculator {
	@Override
	public int caculateShippingFee(int distance) {
		System.out.println("Hello old");
		return (int)(distance*1.2);
	}
}
