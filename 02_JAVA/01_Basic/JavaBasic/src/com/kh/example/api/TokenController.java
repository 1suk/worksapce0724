package com.kh.example.api;

import java.util.StringTokenizer;

public class TokenController {
    
  
    public TokenController() {
    	super();
    }
	
    public String afterToken(String str) {
        StringTokenizer stn = new StringTokenizer(str, " ");
        StringBuilder sb = new StringBuilder();
        
        while(stn.hasMoreTokens()) {
        	sb.append(stn.nextToken());
        }	
        /*
        String result = " ";
        while(stn.hasMoreTokens()) {
        	result += stn.nextToken();
        }
        */
        return sb.toString();
    }

    //첫글자를 대문자로 변경
    public String firstCap(String input) {
      char first = input.toUpperCase().charAt(0);
      return first + input.substring(1);
    }

  //특정 문자 갯수 검색
    public int findChar(String input, char one) {
        if (input == null) {
            return 0;
        }
        
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == one) {
                count++;
            }
        }
        return count;
    }
}
