package com.kh.practice.array;

import java.util.Scanner;

public class Practice8 {
	/*
	 * f f f f f...
	 * f f f f f
	 * f f f f f
	 * f f f f f
	 * f f f f f 
	 * */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        boolean[][] paper = new boolean[100][100];
        int n = sc.nextInt(); // 색종이 개수
        
        // 색종이 붙이기
        for (int k = 0; k < n; k++) {
            int x = sc.nextInt(); // 왼쪽 거리
            int y = sc.nextInt(); // 아래쪽 거리
            
            for (int i = x; i < x + 10; i++) {
                for (int j = y; j < y + 10; j++) {
                    paper[i][j] = true; // 붙인 부분 체크
                }
            }
        }
        
        // 전체 넓이 계산
        int area = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (paper[i][j]) {
                    area++;
                }
            }
        }
        
        System.out.println(area);
        sc.close();
    }
}

