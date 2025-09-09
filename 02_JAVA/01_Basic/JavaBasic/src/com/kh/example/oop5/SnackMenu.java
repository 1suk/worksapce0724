package com.kh.example.oop5;

import java.util.Scanner;

public class SnackMenu {
	private Scanner sc = new Scanner(System.in);
	private SnackController scr = new SnackController();
	
	public void menu() {
		System.out.println("스낵류를 입력하세요.");
		System.out.println("종류 : ");
		String kind = sc.next();
		
		System.out.println("이름 : ");
		String name = sc.next();
		

		System.out.println("맛 : ");
		String flavor = sc.next();

		System.out.println("개수 : ");
		int numOf = sc.nextInt();
		
		System.out.println("가격 : ");
		int price = sc.nextInt();
		sc.nextLine(); //개행문자 비우기
		
		System.out.println(scr.saveData(kind, name, flavor, numOf, price));
		System.out.println("저장한 정보를 확인하시겠습니까? (y/n) :");
		String answer = sc.nextLine();
		
		if(answer.equals("y")) {
			System.out.println(scr.confirmData());
		}
	}
}
