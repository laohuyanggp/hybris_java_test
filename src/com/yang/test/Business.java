package com.yang.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Business {
    
	private static int order_id_start = 0;
	
	private final static int PRIOR_FLG = 1;
	private final static int DISTANCE_FLG = 2;
	
	private List<WarehouseInfo> warehouses = new ArrayList<WarehouseInfo>(3); //题目只有三个仓库, 如果由不定的任意个时
	private List<WarehouseInfo> warehouses1 = new ArrayList<WarehouseInfo>(3);
	
	private Map<String, OrderInfo> orders = new HashMap<String, OrderInfo>();
	
	// 需要有一个缓存器，再生成几个仓库。按照优先级级别获取仓库
	
	
	// 生成仓库。这些仓库，由优先级最大开始填入。一直到优先级最低。
	public void buildWarehouses() {
		WarehouseInfo w3 = new WarehouseInfo("W3", "W3_address", 3, 4.0f);
		WarehouseInfo w2 = new WarehouseInfo("W2", "W2_address", 2, 4.0f);
		WarehouseInfo w1 = new WarehouseInfo("W1", "W1_address", 1, 2.5f);
		
		// 一个仓库引用，加入到安装不同排序方式的Array中。
		
		warehouses.add(w3);
		warehouses.add(w2);
		warehouses.add(w1);

		warehouses1.add(w1);
		warehouses1.add(w2);
		warehouses1.add(w3);
	}
	
	public OrderInfo createOrder() {
		// 生成一个订单信息
		
		OrderInfo order =  new OrderInfo();
		order_id_start = order_id_start + 1;
		String orderId = String.format("%08d", order_id_start);
		order.setOrderId(orderId);
		orders.put(orderId, order);
		return order;
	}
	

	// 判断 商品数量 够不够
	public boolean checkGoodsNumber(String goodsKey, int orderGoodsNumber) {
		if (warehouses == null || warehouses.size() == 0)
		
		return false;
		int goods_sum = 0;
		for (int i = 0; i < warehouses.size(); i++) {
			WarehouseInfo warehouseInfo = warehouses.get(i);
			Map<String, GoodsInfo> goods = warehouseInfo.getGoods();
			if (goods.containsKey(goodsKey)) {
				goods_sum = goods_sum + goods.get(goodsKey).getGoodsNumber();
			}
		}
		if (orderGoodsNumber > goods_sum) {
		    return true;	
		} else {
		    return false;
		}
	}
	
	// 需要根据优先级进行挑选
	public void buyGoodsByPrior(String goodsKey, int orderGoodsNumber) {
		this.buyGoods(goodsKey, orderGoodsNumber, 1);
		
	}
	
	// 根据仓库距离来进行挑选
	public void buyGoodsByDistance(String goodsKey, int orderGoodsNumber) {
		
		this.buyGoods(goodsKey, orderGoodsNumber, 2);
	}
	
	public void buyGoods(String goodsKey, int orderGoodsNumber, int flg) {

		OrderInfo orderInfo = this.createOrder();
		orderInfo.setGoodsName(goodsKey); // 订单产品名称
		orderInfo.setGoodsNumber(orderGoodsNumber); // 订单产品数量
	    // 1.先从优先级高的仓库开始选择
		// 2.从商品所在仓库近的距离选择，距离最小原则
		// 3.当一个仓库的商品数量不够时，从其他仓库调货。而从其他仓库调货也是需要根据距离和优先级来选择
		// 4.但是在优先级和距离，这个题目并没有更多信息。需要对优先级和距离两者如何权衡选择。
		
		StringBuilder warehouse_name = new StringBuilder();
		StringBuilder warehouse_address = new StringBuilder();
		StringBuilder warehouse_num = new StringBuilder();
		int goods_num_sum = 0;
		
		List<WarehouseInfo> fromWarehouse = null;
		
		if (flg == PRIOR_FLG) {// 按照优先级别
			fromWarehouse = warehouses;
		} else if (flg == DISTANCE_FLG){ // 按照距离最小优先
			fromWarehouse = warehouses1;
		}
		// 按照优先级别
		for (int i = 0; i < fromWarehouse.size(); i++) {
			WarehouseInfo warehouse = fromWarehouse.get(i);
			Map<String, GoodsInfo> goodses = warehouse.getGoods();
			GoodsInfo goods = goodses.get(goodsKey);
			int goodsNumber = goods.getGoodsNumber();
			if (goodsNumber == 0) {
				continue;// 此仓库没有该类商品时，不用处理。
			}
			
			goods_num_sum = goods_num_sum + goodsNumber;
			if (goods_num_sum < orderGoodsNumber) {
				// 记录仓库名称，仓库地址，仓库商品数量。
				warehouse_name.append(warehouse.getName()).append("|");
				warehouse_address.append(warehouse.getAddress()).append("|");
				warehouse_num.append(goodsNumber).append("|");
				// 减去该仓库的商品数量。
				goods.setGoodsNumber(0);
			} else {

				// 记录仓库名称，仓库地址，仓库商品数量。
				warehouse_name.append(warehouse.getName()).append("|");
				warehouse_address.append(warehouse.getAddress()).append("|");
				warehouse_num.append(goods_num_sum - orderGoodsNumber).append("|"); // 最后一个仓库需要减去的数量
				// 减去该仓库的商品数量。
				goods.setGoodsNumber(goods_num_sum - orderGoodsNumber);
				
				return; // 退出
			}
		}
	}
	
	public List<WarehouseInfo> getPriorWarehouses() {
		return this.warehouses;
	}
	
	public List<WarehouseInfo> getDistanceWarehouses() {
		return this.warehouses1;
	}
	
}
