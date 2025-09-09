package com.kh.practice.array;
import java.util.Scanner;

public class Practice4 {
	// ex) arr = [0,0,0,0,0] => [1,0,1,1,0]
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt(); 
        boolean[] submitted = new boolean[30]; 

        for (int i = 0; i < count; i++) {
        	int num = sc.nextInt();
            submitted[num - 1] = true;
            // submitted[sc.nextInt() - 1]
        }

        
        for (int i = 0; i < submitted.length; i++) {
            if (!submitted[i]) {
                System.out.println(i + 1); 
            }
        }
    }
}
