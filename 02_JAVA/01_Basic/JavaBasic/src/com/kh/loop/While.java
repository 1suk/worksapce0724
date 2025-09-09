package com.kh.loop;

import java.util.Scanner;

public class While {
    /*
     * while문
     * 
     * [표현법]
     * 
     * while(조건식){
     *     반복할 코드
     *     [탈출이 가능한 구조]
     * }
     */
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. while문 간단 예시
        // int i = 0;
        // while(i < 10) {
        //     System.out.println("안녕하세요.");
        //     i++;
        // }

        // 2. 사용자 입력 반복 (0 입력 시 종료)
        // int n = sc.nextInt();
        // while(n != 0) {
        //     System.out.println(n);
        //     n = sc.nextInt();
        // }

        // 3. 랜덤값 생성 및 합 구하기
        // int random = (int)(Math.random() * 100) + 1;
        // int sum = 0;
        // for (int i = 1; i <= random; i++) {
        //     sum += i;
        // }

        // 4. 사용자가 0 입력 전까지 랜덤값 합산
        // int choice = sc.nextInt();
        // int total = 0;
        // while(choice != 0) {
        //     int rand = (int)(Math.random() * 100) + 1;
        //     total += rand;
        //     choice = sc.nextInt();
        // }
        // System.out.println("총합: " + total);

        // 5. 서비스 번호 입력 로직
        int num;

        System.out.println("서비스 번호를 입력하세요 :");
        System.out.println("1. 삭제");
        System.out.println("2. 추가");
        System.out.println("3. 종료");

        System.out.print("입력 : ");
        num = sc.nextInt();

        while (num != 3) {
            switch (num) {
                case 1:
                    System.out.println("삭제되었습니다.");
                    break;
                case 2:
                    System.out.println("추가되었습니다.");
                    break;
                default:
                    System.out.println("잘못 입력하셨습니다.");
            }

            System.out.print("입력 : ");
            num = sc.nextInt();
        }

        System.out.println("종료합니다.");
        sc.close();
    }
}
