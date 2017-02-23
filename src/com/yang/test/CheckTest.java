package com.yang.test;

public class CheckTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		float w1_a_p = 1.0f;
		float w2_a_p = 2.0f;
		float w3_a_p = 3.0f;

		float w1_b_p = 10.0f;
		float w2_b_p = 20.0f;
		float w3_b_p = 30.0f;

		float w1_c_p = 11.0f;
		float w2_c_p = 22.0f;
		float w3_c_p = 33.0f;
		
		int w1_a_n = 1;
		int w1_b_n = 2;
		int w1_c_n = 2;
		
		int w2_a_n = 2;
		int w2_b_n = 1;
		int w2_c_n = 2;
		
		int w3_a_n = 1;
		int w3_b_n = 3;
		int w3_c_n = 1;
		
		// 生成仓库
		
		WarehouseInfo w1 = new WarehouseInfo("W1", "W1_address", 1, 2.5f);
		
		WarehouseInfo w2 = new WarehouseInfo("W2", "W2_address", 2, 4.0f);
		
		WarehouseInfo w3 = new WarehouseInfo("W3", "W3_address", 3, 4.0f);
		
		// 生成商品
		GoodsInfo w1_a = new GoodsInfo("A", w1_a_p, w1_a_n, "W1_address");
		GoodsInfo w2_a = new GoodsInfo("A", w2_a_p, w2_a_n, "W2_address");
		GoodsInfo w3_a = new GoodsInfo("A", w2_a_p, w3_a_n, "W3_address");

		GoodsInfo w1_b = new GoodsInfo("B", w1_b_p, w1_b_n, "W1_address");
		GoodsInfo w2_b = new GoodsInfo("B", w2_b_p, w2_b_n, "W2_address");
		GoodsInfo w3_b = new GoodsInfo("B", w2_b_p, w3_b_n, "W3_address");
		
		GoodsInfo w1_c = new GoodsInfo("C", w1_c_p, w1_c_n, "W1_address");
		GoodsInfo w2_c = new GoodsInfo("C", w2_c_p, w2_c_n, "W2_address");
		GoodsInfo w3_c = new GoodsInfo("C", w2_c_p, w3_c_n, "W3_address");
		
		
		
	}

}
