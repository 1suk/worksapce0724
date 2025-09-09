package com.kh.practice.controller;
import java.util.Scanner;

public class Practice2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num1, num2, num3;
		
		System.out.printf("숫자를 입력하세요 :");
		num1 = sc.nextInt();
		num2 = sc.nextInt();
		num3 = sc.nextInt();
		
		int result;
		
		if(num1 == num2 && num1 == num3){
			result = 10000 + num1 * 1000;
		}else if(num1  == num2 || num1 == num3 ) {
			result = 1000 + num1 * 100;
		}else if(num2 == num3){
			result = 1000 + num2 * 100;
		}else {
            int max = num1;
            if (num2 > max) {
                max = num2;
            }
            if (num3 > max) {
                max = num3;
            }
			result = max * 100;
		}
		System.out.println("출력: " + result);
	}
}

//package com.kh.practice.controller;
//import java.util.Scanner;
//
//public class Practice2 {
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int num1, num2, num3;
//
//        System.out.print("숫자를 입력하세요: ");
//        num1 = sc.nextInt();
//        num2 = sc.nextInt();
//        num3 = sc.nextInt();
//
//        int result;
//
//        if (num1 == num2 && num1 == num3) {
//            result = 10000 + num1 * 1000;
//        } else if (num1 == num2 || num1 == num3) {
//            result = 1000 + num1 * 100;
//        } else if (num2 == num3) {
//            result = 1000 + num2 * 100; 
//        } else {
		//java에서 제공해주는 수학함수
		//java.lang.Math -> 코드를 작성할 때 기본적으로 유용한 것들을 담아서 제공해줌/
		//Math.max(num1,num2) -> 둘중 큰값을 반환함
//            int max = Math.max(num1, num2);
//            max = Math.max(max, num3);
//            result = max * 100;
//        }
//
//        System.out.println("출력: " + result);
//    }
//}

