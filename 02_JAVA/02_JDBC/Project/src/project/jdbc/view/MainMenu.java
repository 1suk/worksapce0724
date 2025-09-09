package project.jdbc.view;

import java.util.Scanner;

import project.jdbc.model.vo.Member;

public class MainMenu {
    private Scanner sc = new Scanner(System.in);
    private MemberMenu memberMenu = new MemberMenu();
    private MatchMenu matchMenu = new MatchMenu();
    private Member isLogin = null;
    
    public void Menu() {
        while(true) {
            System.out.println("===== 축구 관리 프로그램 =====");
            System.out.println("1. 경기 관리");
            System.out.println("2. 회원 관리");
            System.out.println("3. 내 팀 메뉴 (로그인 필요)");
            System.out.println("9. 종료");
            System.out.print("메뉴 선택: ");
            int sel = sc.nextInt();

            switch(sel) {
                case 1: matchMenu.MainMenu(); break;
                case 2:
                	isLogin = new MemberMenu().MainMenu(isLogin); //isLogin = MemberMenu.MainMenu 시 static으로 바꿔줘야함 Why
                	break;
                case 3: if(isLogin != null) new TeamMenu(isLogin).MainMenu(); break;
                case 9: System.out.println("종료합니다."); return;
                default: System.out.println("잘못 입력했습니다."); 
            }
        }
    }
}

