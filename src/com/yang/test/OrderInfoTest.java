package com.yang.test;

import static org.junit.Assert.*;

import org.junit.Test;

public class OrderInfoTest {

	@Test
	public void testToString() {
		fail("Not yet implemented");
		OrderInfo order = new OrderInfo();
		order.setOrderId("0000001");
		order.setGoodsName("A");
		order.setGoodsNumber(10);
		order.setWarehouseName("W1|W2|W3");
		order.setWarehouseAddress("W1_Add|W2_Add|W3_Add");
		order.setWarehouse_goods_num("2|3|5");
		
		assert(order.getOrderId() == "00002");
	}

}
