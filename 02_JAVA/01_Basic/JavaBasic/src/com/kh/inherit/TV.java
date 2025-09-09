package com.kh.inherit;

public class TV extends Product {
	private int inch;

	public TV() {
		super();
	}

	public TV(String pName, int price, String brand, int inch) {
		super(pName, price, brand);
		this.inch = inch;
	}
	
	public void setInch(int inch) {
		this.inch = inch;
	}
}
