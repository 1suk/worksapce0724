package com.kh.practice.basic;

import java.util.Scanner;

public class Practice5 {
	//문자가 등장할 때 등장한 문자를 체크해두고
	//이미 나왔떤 문자가 다시 등장했다면, 이전문자와 같은지 확인 후
	//이미 나왔떤 문자가 이전문자와 다른문자라면 그룹단어가 아니다.
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int count = 0;
		int n = sc.nextInt();
		
		for(int i=0; i<n; i++) {
			String str = sc.next();
			
			boolean[] isDupl = new boolean[26];
			char prev = 0;
			boolean isOk = true;
			
			for(int j=0; j<str.length(); j++) {
				char ch = str.charAt(j);
				if(prev != ch) {
					int index = ch - 'a';
					if(isDupl[index]) { //그룹단어가 아님
						isOk = false;
						break;
					}
					isDupl[index] = true; //이미 등장한 알바벳 체크
					prev = ch; // 비교를 위한 이전문자 저장
				}
			}
			
			if(isOk) count++;
	
		}
		System.out.println(count);
	}

}
