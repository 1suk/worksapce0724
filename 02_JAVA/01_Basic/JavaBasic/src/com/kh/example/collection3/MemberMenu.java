package com.kh.example.collection3;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class MemberMenu {
	MemberController mc = new MemberController();
	Scanner sc = new Scanner(System.in);
   
    
    public void mainMenu() {
        while(true) {
            System.out.println("1. 회원가입");
            System.out.println("2. 로그인");
            System.out.println("3. 같은 이름 회원 찾기");
            System.out.println("4. 종료");
            
            int select = sc.nextInt();    
            
            switch(select) {
                case 1:
                	joinMemberShip();  
                    break;
                case 2:
                	boolean isLogin = login();
                    if(isLogin) {
                    	memberMenu();
                    }
                    break;
                case 3:
                    sameName(); 
                    break;
                case 4:
                    System.out.println("종료");
                    return;
                default :
                    System.out.println("잘못입력하셨습니다.");
            }
            System.out.println();
        }
    }
    
    public void memberMenu() {
        while(true) {
            System.out.println("1. 비밀번호 바꾸기");
            System.out.println("2. 이름 바꾸기");
            System.out.println("3. 로그아웃");
            
            int select = sc.nextInt();    
            
            switch(select) {
                case 1:
                    changePassword();
                    break;
                case 2:
                    changeName(); 
                    break;
                case 3:
                    System.out.println("로그아웃");
                    return;
                default :
                    System.out.println("잘못입력하셨습니다.");
            }
        }
    }
    
    public void joinMemberShip() {
    	System.out.println("아이디를 입력하세요.");
    	String id = sc.nextLine();
    	System.out.println("패스워드를 입력하세요.");
    	String password = sc.nextLine();
    	System.out.println("이름을 입력하세요.");
    	String name = sc.nextLine();
    	
    	Member mem = new Member(password, name);
    	boolean isOk = mc.joinMembership(id, mem);
    	
    	if(isOk) {
    		System.out.println("성공적으로 회원가입 완료하였습니다.");
    	}else {
    		System.out.println("중복된 아이디입니다. 다시 입력해주세요");
    	}
    }
    
    public boolean login() {
    	for(int i=0; i<3; i++) {
    	 	System.out.println("아이디를 입력하세요.");
        	String id = sc.nextLine();
        	System.out.println("패스워드를 입력하세요.");
        	String password = sc.nextLine();
        	
        	String name = mc.logIn(id, password);
        	
        	if(name != null) {
            	System.out.println(name + "님, 환영합니다!");
            	return true;
            }
        	System.out.println("잘못된 아이디와 패스워드 입니다");
    	}
    	return false;
    }
    
    public void changePassword() {
    	System.out.println("아이디를 입력하세요.");
    	String id = sc.nextLine();
    	System.out.println("기존 패스워드를 입력하세요.");
    	String oldPwd = sc.nextLine();
    	System.out.println("변경할 비밀번호를 입력하세요.");
    	String newPwd = sc.nextLine();
    	
    	boolean isChange = mc.changePassword(id, oldPwd, newPwd);
    	if(isChange) {
    		System.out.println("비밀번호 변경에 성공하였습니다.");
    		return;
    	}
    	System.out.println("비밀번호 변경에 실패했습니다.");
    }
    
    public void changeName() {
    	while(true) {
        	System.out.println("아이디를 입력하세요.");
        	String id = sc.nextLine();
        	System.out.println("패스워드를 입력하세요.");
        	String oldPwd = sc.nextLine();
        	
        	String name = mc.logIn(id, oldPwd);

        	
        	if(name == null) {
        		System.out.println("해당 정보를 찾을 수 없습니다.");
        		continue;
        	}
        	
        	System.out.println("현재 설정된 이름 : " + name);
        	System.out.println("변경할 이름 : ");
        	String newName = sc.nextLine();
        	
        	mc.changeName(id, newName);
        	System.out.println("이름 변경에 성공하였습니다.");
        	break;	
    	}
    }
    
    public void sameName() {
        System.out.println("검색할 이름 입력: ");
        String name = sc.nextLine();
        TreeMap<String, String> map = mc.sameName(name);
        
        for(Map.Entry<String, String> e : map.entrySet()) {
        	System.out.println(e.getValue() + "-" + e.getKey());
        }
    }

}
