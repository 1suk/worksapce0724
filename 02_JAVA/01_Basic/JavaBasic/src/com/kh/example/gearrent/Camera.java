package com.kh.example.gearrent;

import java.util.Set;

public class Camera extends Device{

	public Camera(String id, String name, String category, int borrowCount, Set<String> tags) {
		super(id, name, category, borrowCount, tags);
	}
	
	public int getBorrowLimitDays() {
		return 7;
	}
	
	public int calcLateFee(int overdueDays) {
		return overdueDays * 300;
	}
}
