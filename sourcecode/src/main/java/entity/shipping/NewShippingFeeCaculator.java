package entity.shipping;

import entity.order.Order;

public class NewShippingFeeCaculator implements ShippingFeeCaculator {
	@Override
	public int caculateShippingFee(int distance) {
		int text = (int)(distance*3) + 1;
		System.out.println("Hello " + text);
		return text;
	}
}
