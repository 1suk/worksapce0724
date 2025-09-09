package com.kh.practice.array;
import java.util.Scanner;


public class Practice2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt(); 
		int[] arr = new int[a];
		
		arr[0] = sc.nextInt();
		int max = arr[0];
		int min = arr[0];
		
		for (int i = 1; i < a; i++) {
		    int b = sc.nextInt();
		    arr[i] = b;
		    //System.out.println(arr[i]);
		    if(arr[i] > max) {
		    	max = arr[i];
		    }
		    if(min > arr[i] ) {
		    	min = arr[i];
		    }
		}
		System.out.println(max);
		System.out.print(min);
	}
}
