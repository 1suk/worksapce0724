package com.kh.controller;

import java.util.Scanner;

public class Practice3 {

	public static void main(String[] args) {
		/*
		 * 정수(양수)를 입력받아
		 * 짝수인지 홀수인지 출력하는 프로그램
		 * */
		Scanner sc = new Scanner(System.in);
		
		int num;
		System.out.println("숫자를 입력하시오 : ");
		num = sc.nextInt();
		if(num > 0) {
			if(num % 2 == 1) {
				System.out.println("홀수입니다");
			}else {
				System.out.println("짝수입니다");
			}
		}else {
			System.out.println("양수가 아니다");
		}
	}

}
