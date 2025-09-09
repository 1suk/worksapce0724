package com.kh.example.abstractNInerface;

public abstract class SmartPhone {
	private String maker;
	
	public SmartPhone() {
		super();
	}
	
	public void setMaker(String maker) {
		this.maker = maker;
	}
	
	public String getMaker() {
		return maker;
	}
	
	//각 인터페이스의 메서드들의 반환값을 모두 조합해서 반환 (자식에서 구현)
	public abstract String printInformation();
}
