package com.yang.test;

import java.util.Map;

// 仓库信息类
public class WarehouseInfo {
    public static final String TAG = "WarehouseInfo";
    
    // 优先级
    private int prior = 0; // 默认最低优先级， 数字越大，优先级越高
    
    private String name; // 仓库名称
    
    private String address; // 仓库地址
    
    private float distance; // 仓库到定点的距离。当订单生成后，这个定点距离才会生成。
    
    private Map<String, GoodsInfo> goods;
    
    // 不被公开的构造器
    private WarehouseInfo() {
    	
    }
    
    public WarehouseInfo(String name, String address, int prior, float distance) {
    	this.name = name;
    	this.address = address;
    	this.prior = prior;
    	this.distance = distance;
    }

	public int getPrior() {
		return prior;
	}

	public void setPrior(int prior) {
		this.prior = prior;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
    
	public void pushGoods(String goodsKey, GoodsInfo goods) {
		if (this.goods.containsKey(goodsKey)) {
			GoodsInfo goodsInfo = this.goods.get(goodsKey);
			goodsInfo.setGoodsNumber(goods.getGoodsNumber()); // 把商品放进去，只增加数量。价格默认跟之前的一样。
		} else {
			this.goods.put(goodsKey, goods); // 价格固定好了。在进入仓库之前。
		}
	}
	
	public void popGoods(String goodsKey, int goodsNumber) {
		if (this.goods.containsKey(goodsKey)) {
			GoodsInfo goodsInfo = this.goods.get(goodsKey);
			if (goodsNumber > goodsInfo.getGoodsNumber()) {
				StringBuilder log = new StringBuilder();
				log.append("此").append(this.name).append(goodsKey).append("商品缺货"); // 订单缺货时，应该提醒
			} else {
				goodsInfo.setGoodsNumber(goodsInfo.getGoodsNumber() - goodsNumber);
			}
		} else {
			StringBuilder log = new StringBuilder();
			log.append("此").append(this.name).append("没有").append(goodsKey).append("商品");
			
		}
	}

	public Map<String, GoodsInfo> getGoods() {
		return goods;
	}
}
