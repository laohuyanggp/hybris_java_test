package com.yang.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class BusinessTest {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testBuildWarehouses() {
		Business bus = new Business();
		bus.buildWarehouses();
		List<WarehouseInfo> ws1 = bus.getPriorWarehouses();
		List<WarehouseInfo> ws2 = bus.getDistanceWarehouses();
		
		WarehouseInfo ws1_3 = ws1.get(0);
		
		WarehouseInfo ws2_3 = ws2.get(2);
		
		assert(ws1_3.getName() == ws2_3.getName());

		ws1_3.setPrior(4);
		assert(ws2_3.getPrior() == 4);
	}

}
