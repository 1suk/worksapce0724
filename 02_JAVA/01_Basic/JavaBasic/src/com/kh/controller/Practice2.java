package com.kh.controller;

import java.util.Scanner;

public class Practice2 {
	/*
	 * 성별을(m/f)로 입력받아 남학생인 여학생인지
	 * 출력한느 프로그램을 작성해라
	 * 
	 * [출력]
	 * 성별(m/f) : x
	 * 여학생입니다/남학생입니다/잘못입력햇습니다
	 * */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char sex;
		
		System.out.println("성별(m/f) 입력 :");
		// 문자열 입력, 대문자로 모두 변경, 맨앞글자로 추출
		sex = sc.next().charAt(0);
		//sex = sc.next().upperCase.charAt(0);
		
		switch(sex) {
		case 'm': //"M" 오류나옴 
		case 'M': 	
			System.out.println("남학생입니다");
			break;
		case 'f': 
		case 'F':
			System.out.println("여학생입니다");
			break;
		default: 
			System.out.println("잘못입력하셨습니다.");
		}
	}
}