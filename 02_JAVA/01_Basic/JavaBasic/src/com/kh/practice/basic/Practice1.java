package com.kh.practice.basic;

import java.util.Scanner;

public class Practice1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
//		int[] arrA = {1,1,2,2,2,8};
//			
//		int[] arrB = new int[6];
//		int result;
//		
//		for(int i=0; i<arrB.length;i++) {
//			arrB[i] = sc.nextInt();
//			result = arrA[i] - arrB[i];
//			System.out.print(result + " ");
		
		int[] arrA = {1,1,2,2,2,8};
		
		int[] arrB = new int[arrA.length];
		
		for(int i=0; i<arrB.length;i++) {
			arrB[i] = sc.nextInt();
		}
		
		for(int i=0; i<arrB.length;i++) {
			System.out.print(arrA[i] - arrB[i] + " ");
		}
	}
}
