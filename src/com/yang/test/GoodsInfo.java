package com.yang.test;

// 商品信息类
public class GoodsInfo {
	
	public static final String TAG = "GoodsInfo";
	
	// 产品名称
	private String goodsName;
	
	// 产品价格
	private float goodsPrice;
	
	// 产品数量
	private int goodsNumber;
	
	// 产品所在仓库
	private String goodsAddress;
	
	// 此构造函数 不被利用。
	private GoodsInfo() {
		goodsName = "";
		goodsPrice = 0.0f;
	}
	
	// 公开构造函数，需要生成实例
	public GoodsInfo(String goodsName, float goodsPrice, int goodsNumber, String goodsAddress) {
		this.goodsName = goodsName;
		this.goodsPrice = goodsPrice;
		this.goodsNumber = goodsNumber;
		this.goodsAddress = goodsAddress;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public float getGoodsPrice() {
		return goodsPrice;
	}

	public void setGoodsPrice(float goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	public int getGoodsNumber() {
		return goodsNumber;
	}

	public void setGoodsNumber(int goodsNumber) {
		this.goodsNumber = goodsNumber;
	}

	public String getGoodsAddress() {
		return goodsAddress;
	}

	public void setGoodsAddress(String goodsAddress) {
		this.goodsAddress = goodsAddress;
	}
	
	

}
