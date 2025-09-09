package com.kh.operator;

public class Operator4 {
	/*
	 * 비교연산자 (관계연산자)
	 * 두 값을 비교하여 조건을 판단하는 연산자
	 * 
	 * 종류
	 * - 대소비교 : < , > , <= , >=
	 * - 동등비교 : == , !=
	 * 
	 * 원시타입 비교
	 * - 정수, 실수, 문자등의 기본 변수는 ==, != 등으로 비교 가능
	 * 
	 * 참조형 비교(String)
	 * - String 같은 객체는 참조형이므로 == 비교시 문제가 발생한다.
	 * (참조형은 일반적으로 연산자를 사용해 비교하면 값자체가 아닌 주소값이 비교된다.)
	 * - 문자열1.equals(문자열2) 처럼 내부의 함수를 이용해서 비교해야 함.
	 *  (해당 참조변수가 가지고 있는 메모리에 실제 값을 비교함)
	 * */
	public static void main(String[] args) {
//		int a = 10;
//		int b = 25;
		
//		System.out.println("a == b :" + (a == b));
//		System.out.println("a == b :" + (a <= b));
//		
//		System.out.println((a * 2) > (b / 5));
		
		String str1 = "hello"; //hello는 문자열 리터럴
		String str2 = "hello"; //자바에서 문자열 리터럴은 String Pool이라는 메모리 영역에 저장됨
		//만약 위처럼 동일한 문자열 리터럴이 또 참조가 되면, 기존에 있던 문자열 객체의 주소를 재사용함.
		//즉, 한번만 리터럴 메모리에 값을 올려 메로리를 효울적으로 사용함.
		
		System.out.println("str1 == str2 : " + (str1 == str2));
		// == 주소값을 비교하는것, 메모리 안 값을 비교하는 건 아님
		
		String str3 = new String("hello"); //new 키워드를 만드는건 스트링풀에 저장하는것이 아닌 힙메모리에 새로운 객체를 만듬
		System.out.println("str1 == str3 :" + (str1 == str3));
		System.out.println(str1 + " " + str2 + " " + str3); //메모리 주소는 다르지만 값은 똑같음
		
		System.out.println(" str1 == str3 " + (str1.equals(str3))); 
		System.out.println(" str1 == str3 " + ("hello".equals(str3))); 
		
		//특이케이스(문자와 숫자간의 대소비교)
		System.out.println('A' + 0); //char(A)는  숫자(65)로 저장돼서 값비교 가능
		System.out.println('A' > 70);
	}
}
