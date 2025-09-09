package com.kh.example.gearrent;

import java.util.Set;

public class Laptop extends Device{

	public Laptop(String id, String name, String category, int borrowCount, Set<String> tags) {
		super(id, name, category, borrowCount, tags);
	}
	
	@Override
	public int getBorrowLimitDays() {
		return 14;
	}
	@Override
	public int calcLateFee(int overdueDays) {
		return overdueDays * 500;
	}
}
