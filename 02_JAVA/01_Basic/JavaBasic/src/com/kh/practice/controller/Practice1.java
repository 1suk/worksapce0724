package com.kh.practice.controller;
import java.util.Scanner;

public class Practice1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int score;
		char grade;
		System.out.println("점수를 입력하세요 : ");
		score = sc.nextInt();
		
		if(score >= 90){
			grade = 'A';
			System.out.println("당신의 성적은" + grade + "입니다.");
		}else if(score >= 80) {
			grade = 'B';
			System.out.println("당신의 성적은" + grade + "입니다.");
		}else if(score >= 70) {
			grade = 'C';
			System.out.println("당신의 성적은" + grade + "입니다.");
		}else if(score >= 60) {
			grade = 'D';
			System.out.println("당신의 성적은" + grade + "입니다.");
		}else {
			grade = 'F';
			System.out.println("당신의 성적은" + grade + "입니다.");
		}
	}

}
