package com.kh.example.gearrent;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class GearRentMenu {
	private GearRentController gc = new GearRentController();
	Scanner sc = new Scanner(System.in);
	
	public void mainMenu() {
		while(true) {
			System.out.println("================KH장비대여===============");
			System.out.println("1)장비등록 2)회원등록 3)대여 4)반납 5)태그검색");
			System.out.println("6)키워드 검색 7)전체장비 8)대여중목록");
			System.out.println("메뉴 :");
			int sel = sc.nextInt();
			
			switch(sel) {
				case 1:
					addDevice(); break;
				case 2:
					addMember(); break;
				case 3:
					borrow(); break;
				case 4:
					returnItem(); break;
				case 5:
					findByKeyword(); break;
				case 6:
					printAllDevice(); break;
				case 7:
					printActiveDevices(); break;
				case 8:
					printActiveLoans(); break;
				default:
					System.out.println("잘못입력하셨습니다.");
			}
		}
	}
	
	public void addDevice() {
		System.out.println("type : ");
		int type = sc.nextInt();
		
		System.out.println("장비 ID : ");
		int id = sc.nextInt();
		
		System.out.println("장비 이름 : ");
		String name = sc.next();
		
		System.out.println("카테고리 : ");
		String category = sc.next();
		
		System.out.println("태그(쉼표로 구분) : ");
		String tag = sc.next();
		sc.nextLine();
		
		Set<String> tags = new HashSet<>();
		for(String s : tag.split(",")) {
			tags.add(s.trim());
		}
		
		Device device;
		switch(type) {
			case 1 :
				device = new Camera(id, name, catagory, tags);
				break;
			case2 :
				device = new Laptop(id, name, catagory, tags);
				break;
			default :
				System.out.println("유형을 잘못 선택했습니다");
		}
		
		boolean isOk = gc.addDevice(device);
		System.out.println(isOk ? "등록 완료" : "중복된 ID입니다. 다시 입력해주세요");
	}
	
	public void addMember() {
		
		System.out.println("멤버 ID : ");
		int id = sc.nextInt();
		
		System.out.println("멤버 이름 : ");
		String name = sc.next();
		
		boolean isOk = gc.addMember(new Member(id, name));
		System.out.println(isOk ? "등록 완료" : "중복된 ID입니다. 다시 입력해주세요");
}
