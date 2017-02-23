package com.yang.test;

// 订单信息
// 一个订单只能加入一个商品类型
// 一个订单需要加入更多商品类型 还需要考虑
public class OrderInfo {
    public static final String TAG = "OrderInfo";
    
    // 订单编号：
    private String orderId;
    
    // 订单商品
    private String goodsName;
    
    // 订单商品数量
    private int goodsNumber;
    
    // 下面三个跟仓库有关系的信息，都记录下来，用 | 分割
    
    // 商品所在仓库名称
    private String warehouseName;
    
    // 商品所在仓库地址
    private String warehouseAddress;
    
    // 商品所在仓库获取数量
    private String warehouse_goods_num;

	/**
	 * @return the orderId
	 */
	public String getOrderId() {
		return orderId;
	}

	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	/**
	 * @return the goodsName
	 */
	public String getGoodsName() {
		return goodsName;
	}

	/**
	 * @param goodsName the goodsName to set
	 */
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	/**
	 * @return the goodsNumber
	 */
	public int getGoodsNumber() {
		return goodsNumber;
	}

	/**
	 * @param goodsNumber the goodsNumber to set
	 */
	public void setGoodsNumber(int goodsNumber) {
		this.goodsNumber = goodsNumber;
	}

	/**
	 * @return the warehouseName
	 */
	public String getWarehouseName() {
		return warehouseName;
	}

	/**
	 * @param warehouseName the warehouseName to set
	 */
	public void setWarehouseName(String warehouseName) {
		this.warehouseName = warehouseName;
	}

	/**
	 * @return the warehouseAddress
	 */
	public String getWarehouseAddress() {
		return warehouseAddress;
	}

	/**
	 * @param warehouseAddress the warehouseAddress to set
	 */
	public void setWarehouseAddress(String warehouseAddress) {
		this.warehouseAddress = warehouseAddress;
	}

	/**
	 * @return the warehouse_goods_num
	 */
	public String getWarehouse_goods_num() {
		return warehouse_goods_num;
	}

	/**
	 * @param warehouse_goods_num the warehouse_goods_num to set
	 */
	public void setWarehouse_goods_num(String warehouse_goods_num) {
		this.warehouse_goods_num = warehouse_goods_num;
	}
	
	@Override
	public String toString() {
		String r = "123";
		return r; 
	}
    
    
}
