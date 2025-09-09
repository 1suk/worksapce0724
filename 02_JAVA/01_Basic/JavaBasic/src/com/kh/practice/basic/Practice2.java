package com.kh.practice.basic;

import java.util.Scanner;

public class Practice2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

//        String input = sc.next();
//        char[] arr = new char[input.length()]; 
//        
//        for (int i = 0; i < input.length(); i++) {
//            arr[i] = input.charAt(i);
//        }
//
//        boolean isPalindrome = true;
//
//        for (int i = 0; i < arr.length / 2; i++) {
//            if (arr[i] != arr[arr.length - 1 - i]) {
//                isPalindrome = false;
//                break;
//            }
//        }
//
//        if (isPalindrome) {
//            System.out.println("1");
//        } else {
//            System.out.println("0");
//        }
        String str = sc.next();
        boolean isOk = true;
        
        for(int i=0, j = str.length() - 1; i<j ; i++, j--) {
        	if(str.charAt(i) != str.charAt(j)) {
        		isOk = false;
        		break;
        	}
        }
        System.out.println(isOk ? 1 : 0);
    }
}
