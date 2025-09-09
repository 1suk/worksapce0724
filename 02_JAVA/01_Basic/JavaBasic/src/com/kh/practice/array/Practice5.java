package com.kh.practice.array;

import java.util.Scanner;

public class Practice5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); 
        int m = sc.nextInt(); 
        int[] arr = new int[n];

       
        for(int i=0; i<arr.length; i++) {
            arr[i] = i + 1;
        }

        
        for(int j=0; j<m; j++) {
            int i = sc.nextInt() - 1;
            int k = sc.nextInt() - 1; 

            while(i < k) {
                int tmp = arr[i];
                arr[i] = arr[k];
                arr[k] = tmp;
                i++;
                k--;
            }
        }

        for(int num : arr) {
            System.out.print(num + " ");
        }
    }
}
