package com.kh.operator;

import java.util.Scanner;

public class Practice2 {
	/*
	 * 키보드로 정수 두개를 입력받아 두 수의 합, 차, 곱, 나누기, 나머지 값을 출력
	 * */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num1, num2, sum, sub, mul, div, rem;
		
		System.out.println("숫자1 입력:");
		num1 = sc.nextInt();
		System.out.println("숫자2 입력:");
		num2 = sc.nextInt();
		
		sum = num1 + num2;
		sub = num1 - num2;
		mul = num1 * num2;
		div = num1 / num2;
		rem = num1 % num2;
		
		System.out.println("두 수의 합 :" + sum);
		System.out.println("두 수의 차 :" + sub);
		System.out.println("두 수의 곱셈 :" + mul);
		System.out.println("두 수의 나눗셈 :" + div);
		System.out.println("두 수의 나머지 :" + rem);
	}
}
