package com.kh.example.poly2;

public class CookBook extends Book {
	private Boolean coupon;
	
	public CookBook() {
		super();
	}
	
	public CookBook(String title, String author, String publisher, Boolean coupon) {
		super(title, author, publisher);
		this.coupon = coupon;
	}

	public Boolean getCoupon() {
		return coupon;
	}

	public void setCoupon(Boolean coupon) {
		this.coupon = coupon;
	}
	
	public String toString() {
		return super.toString() +"," + coupon;
	}
}