package com.kh.example.oop1;

import java.util.jar.Attributes.Name;

import com.kh.example.oop1.Product;

public class Product {
	private String pName;
	private int price;
	private String brand;
	
	//기본 생성자
	public Product() {
		super(); 
	}

//	public Product(String pName, int price, String brand) {
//		this.pName = pName;
//		this.price = price;
//		this.brand = brand;
//	}
	
	public void information() {
		System.out.printf("상품명 : %s / 가격 : %d / 브랜드 : %s\n", pName, price, brand);
	}

}