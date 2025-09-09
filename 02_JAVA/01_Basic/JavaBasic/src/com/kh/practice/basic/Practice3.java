package com.kh.practice.basic;

import java.util.Scanner;

public class Practice3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] count = new int[26];
		//boolean[] arrB = new boolean[];
		String str = sc.next();
		
		for(int i=0; i<str.length() ; i++) {
			int index = str.charAt(i) - 'A';
			count[index]++;
		}
		int max = 0, index = 0;
		boolean isDupl = false;
		
		for(int i=0; i<count.length; i++) {
			//max = count[i] > max ? count[i] : max;
			
			if(count[i] > max) {
				max = count[i];
				index = i;
				isDupl = false;
			}else if(count[i] == max) {
				isDupl = true;
			}
		}
		
		System.out.println(isDupl ? "?" : (char)(index + 'A'));
		
	}

}
