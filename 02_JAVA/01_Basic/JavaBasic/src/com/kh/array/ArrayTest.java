package com.kh.array;

import java.util.Scanner;

public class ArrayTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		//1. 크기가 10인 정수형 배열 생성
		int[] arr = new int[10];
		//2. 반복문을 통해서 0번 인덱스부터 마지막 인덱스 가지 10으로 초기화
		for(int i=0; i<arr.length; i++) {
			arr[i] = 10;
			//System.out.print(arr[i] + " ");
		}
		//3. for-each를 통해서 모든배열의 요소를 출력
		for(int i :arr) {
			System.out.println(i);
		}
		
		//4. 사용자에게 배열의 길이를 입력받아, 해당 크기의 문자열 배열 nameArr을 생성
		System.out.println("배열의 길이 입력 : ");
		int size = sc.nextInt();
		String[] nameArr = new String[size];
		
		//5. 사용자에게 사람의 이름을 입력받아, nameArr의 모든 요소만큼 실행.
		for(int i=0; i < nameArr.length;i++) {
			System.out.print("이름 입력 :");
			nameArr[i] = sc.next();
			//System.out.print(nameArr[i] + " ");
		}
		
		//6. 사용자에게 이름을 하나 입력받아, nameArr에 동일한 이름이 있다면
		//동일한 이름이 존재합니다 / 동일한 이름이 존재하지 않습니다. 출력
		System.out.println("이름 입력:");
		String name = sc.next();
//		
//		for(int i=0; i<nameArr.length; i++) {
//			if(nameArr[i].equals(name)) {
//				System.out.println("동일한 이름 존재합니다");
//				break;
//			}else if(i == (nameArr.length - 1)) {
//				System.out.println("동일한 이름 존재하지 않습니다");
//			}
//		}
			
		boolean isDupl = false;
		for(String n : nameArr) {
			if(name.equals(n)) {
				isDupl = true;
				break;
			}
		}
		System.out.println(isDupl ? "동일 이름 존재" : "동일 이름 존재 X");
//		
	}

}
