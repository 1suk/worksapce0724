package com.kh.loop;

import java.util.Scanner;

public class For {
	/*
	 * <반복문>
	 * 특정 코드를 여러 번 반복해서 실행하고자 할 때 사용하는 제어문.
	 * 
	 * 대표적으로 for, while, do-while이 있다.
	 * 
	 * for문
	 * 반복횟수가 명확할 때 가장 많이 사용된다.
	 * 
	 * for(초기식; 조건식; 증감식){
	 * 	반복 실행 할 코드
	 * }
	 * 
	 * 초기식 : 반복을 시작하기 전 변수를 선언하고 초기값 설정, 처음 딱 한번만 실행됨.
	 * 조건식 : 반복을 계속 진행할지 여부를 판단하는 조건.
	 * 	 	조건이 true이면 반복진행, false면 반복종료.
	 * 		매번 반복문의 코들르 실행하기 전에 확인하며 보통 초기식에서 제시된 변수를 활용하여 조건식을 정함.
	 * 
	 * 증감식 :매번 반복이 끝난 후 변수 값을 증가/감소시키는 부분.
	 * 		보통 초기식에서 제시된 변수를 가지고 증감을 처리함.
	 * */
	public static void main(String[] args) {
	 	Scanner sc = new Scanner(System.in);
//		System.out.println("안녕하세요.");
//		System.out.println("안녕하세요.");
//		System.out.println("안녕하세요.");
//		System.out.println("안녕하세요.");
//		System.out.println("안녕하세요.");
//		
		//5번 반복하는 반복문
//		for(int i=0; i<5; i++) {
//			System.out.println("안녕하세요.");
//		}
//		
		/*
		 * n번 반복
		 * for(int i=0; i < n; i++){
		 * 반복할 코드
		 * }
		 * */
		
//		for(int i=11 ; i <= 17; i+=2) {
//			System.out.println(i);
//		}
//		
//		for(int i=0; i<5; i++) {
//			//System.out.println(i);
//			System.out.print(i + 1 + " ");
//		}
//		
		/*
		 * 자바의 지역변수 (블록 scope)
		 * -특정 메서드나 블록({}) 내부에서 선언하고
		 * 	선언된 블록 범위 내에서만 접근이 가능하다.
		 * -해당 블록이 종료되면 블록 내부의 변수도 함께 사라진다.
		 * */
//		for(int i=6; i>0; i--) {
//			int num =10;
//			System.out.println(10 - 1);
//		}
		//정수 n을 입력받아 1부터 n까지 1씩 증가시키면서 출력해라
		//정수입력: n
		//1 2 3 4 ... n
		
//		Scanner sc = new Scanner(System.in);
//		
//		System.out.print("정수입력 :");
//		int num = sc.nextInt();
//		
//		for(int i=0; i<= num; i++) {
//			System.out.print(i + " ");
//		}
//		
		/*
		 * 커피주문 키오스크
		 * [출력]
		 * 아메리카노를 몇잔 구매하시겠습니까? (1100원) : n
		 * 결제하시 금액은 xxxx원입니다.
		 * 
		 * 1 -> 1100
		 * 2 -> 2200
		 * 3 -> 3300
		 * */
		
		//Scanner sc = new Scanner(System.in);
//		System.out.println("아메리카노를 몇잔 구매하시겠습니까?(1100원) :");
//		int count = sc.nextInt();
//		int sum = 0;
//		for(int i=0; i<count; i++) {
//			sum += 1100;
//		}
//		
//		System.out.println("결제 금액은 :" + sum + "원 입니다.");
		
		//1~10 숫자중 홀수만 출력(조건처리)
		//1 3 5 7 9
//		for(int i=1; i<=10; i++) {
//			if(i % 2 == 1) {
//				System.out.print(i + " ");
//			}
//		}
		
//		int sum = 0;
//		for(int i=0; i<101; i++) {
//			if(i % 2 == 0) {
//				sum += i;
//			}
//		}
//		System.out.println("1부터 100까지의 짝수 합 :" + sum);
		//System.out.println(Math.random());
		/*
		 * Math.random()
		 * java.lang.Math 클래스에서 기본적으로 제공하는 함수로 호출하면 매번 다른 랜덤값을 반환한다.
		 * 
	 * Math.random() 호출시 -> 0.0 ~ 0.999999999999999999999999999사이의 랜덤값을 반환
	 * int num = (int)Math.random() -> 0 ~ 0
	 * int num = (int)(Math.random() * 10) + 1; -> 1 ~ 10;
	 * 최소값 ~ 최대값 랜덤 수 : (int)(Math.random() *(최대값 + 1 - 최소값)) + 최소값;
	 * */
		
		//random(1~10)한 숫자 n을 생성해서 1부터 n까지 모두 더한값을 출력해라
		//random 수 : n
		//1~n가지의 합 : xxx
		
//		int n = (int)(Math.random() *10) + 1;
//		int sum = 0;
//		for(int i=0; i<n; i++) {
//			sum += n;
//		}
//		System.out.println("random 수 :" + n);
//		System.out.printf("1~%d까지의 합 : %d\n", n, sum);
//	
	
	/*
	 * 각 인덱스별 문자 출력 : Hello
	 * str.charAt(0)  -> H
	 * str.charAt(1)  -> e
	 * str.charAt(2)  -> l
	 * str.charAt(3)  -> l
	 * str.charAt(4)  -> o
	 * index 반복 -> 0 ~ (길이-1)
	 * 
	 * 문자열 길이 : 문자열.length()
	 * */
//	 	System.out.print("문자열을 입력하세요: ");
//	    String str = sc.next();
//	    System.out.println("문자열 길이: " + str.length());
//
//	    for (int i = 0; i < str.length(); i++) {
//	    	System.out.print(str.charAt(i) + " ");
//	    }
	 	
	 	//짝수 자리글자만 출력
	 	//문자열 hello
//	 	System.out.print("문자열을 입력하세요: ");
//	 	String str = sc.next();
//	 	for(int i=0; i<str.length(); i++) {
//	 		if(i % 2 == 1) { //index가 짝수 일때만
//	 			System.out.println(str.charAt(i) + " ");
//	 		}
//	 	}
	 	
	 	//1~9까지 1씩 증가하면서 반복
//	 	for(int i=1; i<=9; i++) {
//	 		System.out.printf("%d * %d = %d\n", 4, i, (4*i));
//	 	}
	 	
	 	//구구단
	 	for(int i=2; i<=9; i++) {
	 		for(int j=1; j<=9; j++) {
	 			System.out.printf("%d * %d = %d\n", i, j, i*j);
	 		}
	 	}
	}
}
