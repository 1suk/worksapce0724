//package com.kh.practice.controller;
//import java.util.Scanner;
//
//public class Practice3 {
//
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		
//		int age, price = 0;
//		String day, grade;
//		
//		System.out.println("나이를 입력하세요 :");
//		age = sc.nextLine();
//		System.out.println("요일을 입력하세요 :");
//		day = sc.nextLine();
//		
//		switch(day){
//		case "토":
//		case "일":
//			if(age <= 12){
//				grade = "어린이";
//				price = 5000;
//				System.out.println(grade +" 요금입니다. (주말 할인 적용)");
//			}else if(age >= 13 && age <= 18) {
//				grade = "청소년";
//				price = 7000;
//				System.out.println(grade +" 요금입니다. (주말 할인 적용)");
//			}else {
//				grade = "성인";
//				price = 12000;
//				System.out.println(grade +" 요금입니다. (주말 할인 적용)");
//			}
//			System.out.println("최종 요금은" + (price * 0.8) + " 요금입니다.");
//			break;
//		default:
//			if(age <= 12){
//				grade = "어린이";
//				price = 5000;
//				System.out.println(grade +" 요금입니다.");
//			}else if(age >= 13 && age <= 18) {
//				grade = "청소년";
//				price = 7000;
//				System.out.println(grade +" 요금입니다.");
//			}else {
//				grade = "성인";
//				price = 12000;
//				System.out.println(grade +" 요금입니다.");
//			}
//			System.out.println("최종 요금은" + price + " 요금입니다.");
//		}
//	}
//
//}

package com.kh.practice.controller;
import java.util.Scanner;

public class Practice3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int age, price = 0;
		String day, grade;
		
		System.out.println("나이를 입력하세요 :");
		age = sc.nextInt();
		sc.nextLine();
		System.out.println("요일을 입력하세요 :");
		day = sc.next();
		
		int fee = 0;
		
		if (age <= 12) {
			fee = 5000;
			grade = "어린이";
		}else if(age <= 18) {
			fee = 7000;
			grade = "청소년";
		}else {
			fee = 10000;
			grade = "성인";
		}
		
		if(day.equals("토")|| day.equals("일")) {
			fee = (int)(fee * 0.8);
			System.out.println(grade + " 요금입니다.(주말 할인 적용)");
		}else {
			System.out.println(grade + " 요금입니다.");
		}
		System.out.println("최종 요금은" + fee + " 요금입니다.");
	}
}
