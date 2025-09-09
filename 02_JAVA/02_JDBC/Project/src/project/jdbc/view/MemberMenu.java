package project.jdbc.view;

import java.util.List;
import java.util.Scanner;

import project.jdbc.controller.MemberController;
import project.jdbc.model.vo.Match;
import project.jdbc.model.vo.Member;

public class MemberMenu {
	private Scanner sc;
	private MemberController mc;
	//private Member isLogin;
	
	public MemberMenu() {
		super();
		this.sc = new Scanner(System.in);
		this.mc = new MemberController();
	}
	
	public Member MainMenu(Member isLogin) { 
        while(true) {
        	System.out.println("===== 회원 관리 프로그램 =====");
            System.out.println("1. 회원 가입");
            System.out.println("2. 로그인");
            System.out.println("3. 로그아웃");
            System.out.println("9. 뒤로가기");
            int sel = sc.nextInt();

            switch(sel) {
                case 1: joinMember(); break;
                case 2: isLogin = login(); break;
                case 3: logout(); break;
                case 9: return isLogin;
            }
        }
    }
		
		public void joinMember() {
			System.out.println("===== 회원 가입 =====");
			System.out.println("사용자 아이디를 입력하세요 : ");
			String userId = sc.next();
			
			System.out.println("사용자 비밀번호를 입력하세요 : ");
			String userPwd = sc.next();
			
			System.out.println("사용자 이름을 입력하세요 : ");
			String userName = sc.next();
			
			System.out.println("응원하는 팀을 입력하세요 : ");
			String myTeam = sc.next();
		
			mc.joinMember(userId, userPwd,userName, myTeam);
		}
		
		public Member login() {
			System.out.println("====== 로그인 ======");
			System.out.println("아이디를 입력하세요 : ");
			String userId = sc.next();
			
			System.out.println("비밀번호 입력하세요 : ");
			String userPwd = sc.next();
			
			Member mem = mc.login(userId, userPwd);
			
		    if (mem != null) {
		        System.out.println("로그인 성공! 환영합니다, " + mem.getUserName() + "님");
		    } else {
		        System.out.println("아이디 또는 비밀번호가 올바르지 않습니다.");
		    }
		    return mem;
		}
		
		public Member logout() {
			System.out.println("로그아웃 성공!");
			return null;
		}	
}
