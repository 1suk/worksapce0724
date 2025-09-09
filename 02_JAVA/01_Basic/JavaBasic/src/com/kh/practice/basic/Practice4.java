package com.kh.practice.basic;

import java.util.Scanner;

public class Practice4 {
	
	/*
	 * 문자열.replace("찾을 문자열", "바꿀 문자열");
	 * 원래 문자열에서 찾을 문자열을 검색하여 바꾼문자열로 치환한 새로운 문자열을 반환.
	 * */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        int i = 0, count = 0;

        while (i < str.length()) {
            // "dz=" 처리
            if (i + 2 < str.length()
                    && str.charAt(i) == 'd'
                    && str.charAt(i + 1) == 'z'
                    && str.charAt(i + 2) == '=') {
                count++;
                i += 3;
                continue;
            }

            // 2글자 처리
            if (i + 1 < str.length()) {
                String s = "" + str.charAt(i) + str.charAt(i + 1);
                if (s.equals("c=") || s.equals("c-") || s.equals("d-") ||
                    s.equals("lj") || s.equals("nj") || s.equals("s=") ||
                    s.equals("z=")) {
                    count++;
                    i += 2;
                    continue;
                }
            }

            // 1글자 처리
            count++;
            i++;
        }

        System.out.println(count);
    }
}
