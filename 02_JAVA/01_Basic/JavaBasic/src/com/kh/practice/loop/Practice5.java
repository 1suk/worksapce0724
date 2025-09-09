//package com.kh.practice.loop;
//import java.util.Scanner;
//		
//public class Practice5 {
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		
//		int sum = 0;
//		int num;
//	
//		 System.out.print("숫자 입력 :");
//	     num = sc.nextInt();
//		
//		while(num > 0) {
//			
//			System.out.println("숫자 입력 :");
//			num = sc.nextInt();
//			sum += num;
//		}
//		
//		System.out.println("총합 :" + sum);
//	}
//}

package com.kh.practice.loop;
import java.util.Scanner;
		
public class Practice5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int sum = 0;
		int num;
		
		while(true) {
			
			System.out.println("숫자 입력 :");
			num = sc.nextInt();
			sum += num;
			
			if(num < 0) {
				break;
			}
		}	
		System.out.println("총합 :" + sum);
	}
}