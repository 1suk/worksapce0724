package com.kh.operator;

import java.util.Scanner;

public class Practice1 {
	/*
	 * 키보드로 가로, 세로값을 실수형으로 입력받아 사각형의 면적과 둘레를 계산하여 출력
	 * 면적 : 가로 * 세로
	 * 둘레 : (가로 + 세로) *2
	 * 
	 * [출력]
	 * 가로 : (키입력)
	 * 세로 : (키입력)
	 * 면적 : ~
	 * 둘레 : ~
	 * +소수점은 2번쨰 자리까지 출력
	 * */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		float width, height,area,perimeter;
		
		System.out.println("가로 입력: ");
		width = sc.nextFloat();
		System.out.println("세로 입력:");
		height = sc.nextFloat();		
		
		area = width * height;
		System.out.printf("면적의 넓이 :  %.2f\n", area);
		perimeter = (width + height) * 2 ;
		System.out.printf("둘레 : %.2f " , perimeter);
	}
}
