package com.kh.example.gearrent;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale.Category;

public class GearRentController {
	private HashMap<String, Device> catalog = new HashMap<>(); 
	private HashMap<String, Member> members = new HashMap<>();
	private HashMap<String, Loan> activeLoans = new HashMap<>();
	
	public boolean addDevice(Device device) {
		String id = device.getId();
		if(catalog.containsKey(id)) {
			return false;
		}else {
			catalog.put(id, device);
			return true;
		}
	}
	
	public boolean addMember(Member member) {
			String id = member.getId();
			if(members.containsKey(id)) {
				return false;
			}else {
				members.put(id, member);
				return true;
			}	
	}
	
	public Loan borrow(String memberId, String itemId, LocalDate today) {
		Device device = catalog.get(itemId);
		LocalDate due = today.plusDays(device.getBorrowLimitDays());
		Loan loan = new Loan(itemId, memberId, today, due);
		activeLoans.put(itemId, loan);
		device.increaseBorrowCount();
		return loan;
	}
	
	public int returnItem(String itemId, LocalDate today) {
		Loan loan = activeLoans.get(itemId);
		
		loan.setReturnedDate(today); //실제 반납일
		int overdueDay = loan.isOverdueDays(today);
		
		Device device = catalog.get(itemId);
		int fee = device.calcLateFee(overdueDay);
		activeLoans.remove(itemId);
		
		return fee;
	}
	
	public ArrayList<Device> findByTag(String tag){
		ArrayList<Device> list = new ArrayList<>();
		if(tag == null) return list;
		for(Device d : catalog.values()) {
			if(d.hasTag(tag)) {
				list.add(d);
			}
		}
		return list;
	}
	
	public ArrayList<Device> findByKeyword(String keyword){
		ArrayList<Device> list = new ArrayList<>();
		if(keyword == null || keyword.equals(" ")) return list;
		
		String key = keyword.toLowerCase();
		for(Device d : catalog.values()) {
			if(d.hasTag(tag)) {
				String name = d.getName().toLowerCase();
				String cat = d.getCategory().toLowerCase();
				if(name.contains(key) || cat.contains(key)) {
					list.add(d);
				}
			}
		}
		return list;
	}
	
	public Collection<Device> getAllDevices(){
		//읽기전용 뷰를 만들어준다 -> 추가/삭제/수정/불가
		return Collections.unmodifiableCollection(catalog.values());
	} 
	
}
