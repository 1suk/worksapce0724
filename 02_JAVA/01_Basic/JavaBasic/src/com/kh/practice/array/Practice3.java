package com.kh.practice.array;

import java.util.Scanner;

public class Practice3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
				
		int[] basket = new int[n];
		
		for(int h=0; h<m; h++) {
			int i = sc.nextInt();
			int j = sc.nextInt();
			int k = sc.nextInt();
			for(int idx=i; idx<=j; idx++) {
				basket[idx - 1] = k;
			}
			for(int num : basket) {
				System.out.println(num + " ");
			}
			sc.close();
		}
	}

}
