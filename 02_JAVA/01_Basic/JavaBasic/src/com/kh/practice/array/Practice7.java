package com.kh.practice.array;

import java.util.Scanner;

public class Practice7 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
	
		int[][] arrA = new int[n][m];
		
		 for(int i=0; i<arrA.length; i++) {
	        for(int j=0; j<arrA[i].length; j++) {
	        	arrA[i][j] = sc.nextInt();
	        }
	      }
		 
		 int max = Integer.MIN_VALUE;
		 int x = 0;
		 int y = 0;
		 
		 for(int i=0; i<arrA.length; i++) {
		        for(int j=0; j<arrA[i].length; j++) {
		        	if(arrA[i][j] > max) {
		        		max = arrA[i][j];
		        		x = i;
		        		y = j;
		        	}
		        }
		      }
		 System.out.println(max);
		 System.out.printf("%d %d", x+1, y+1);
	}

}
