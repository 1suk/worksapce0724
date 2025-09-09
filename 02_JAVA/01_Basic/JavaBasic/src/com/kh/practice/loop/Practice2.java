package com.kh.practice.loop;

import java.util.Scanner;

public class Practice2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt();
		int n = sc.nextInt();
		int total = 0;
		
		for(int i=0; i<n; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			total += (a * b);
		}
		if(total == x) {
			System.out.println("YES");
		}else {
			System.out.println("NO");
		}
	}

}

