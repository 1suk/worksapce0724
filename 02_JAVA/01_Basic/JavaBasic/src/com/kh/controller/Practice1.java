package com.kh.controller;

import java.util.Scanner;

public class Practice1 {
	/*
	 * 나이를 입력받아 13세 이하면 어린이
	 * 13세 초과 19세 이하 : 청소년
	 * 19세 초과 : 성인
	 * [출력]
	 * 나이를 입력 : XX
	 * xx은 xxx에 속합니다.
	 * */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int age;
		String grade;
		
		System.out.println("나이를 입력하세요 :");
		age = sc.nextInt();
		
		if(age <= 13){
			grade = "어린이";
			System.out.println(age + "살은 " + grade + "에 속합니다.");
		}else if(age > 13 && age <= 19){
			grade = "청소년";
			System.out.println(age + "살은 " + grade + "에 속합니다.");
		}else {
			grade = "성인";
			System.out.println(age + "살은 " + grade + "에 속합니다.");
		}
	}
}
