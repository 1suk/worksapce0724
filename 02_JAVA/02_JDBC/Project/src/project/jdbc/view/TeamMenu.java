package project.jdbc.view;

import java.util.List;
import java.util.Scanner;

import project.jdbc.controller.MemberController;
import project.jdbc.controller.TeamController;
import project.jdbc.model.vo.Match;
import project.jdbc.model.vo.Member;

public class TeamMenu {
	private Member user;
	private MemberController mc;
	private TeamController tc;
	Scanner sc = new Scanner(System.in);
	
	public TeamMenu(Member user) {
		this.user = user;
		this.mc = new MemberController();
		this.tc = new TeamController();
	}
	
	public void MainMenu() {
	    while (true) {
	        System.out.println("===== 내 팀 메뉴 =====");
	        System.out.println("1. 내 팀 경기 일정 조회");
	        System.out.println("2. 내 팀 순위 조회");
	        System.out.println("9. 뒤로가기");
	        
	        int sel = sc.nextInt();
	        
	        switch(sel) {
	            case 1: MyTeamMatches(); break;
	            case 2: MyTeamRanking(); break;
	            case 9: return; 
	            default : System.out.println("잘못입력하셨습니다.");
	        }
	    }
	}
	
    private void MyTeamMatches() {
        List<Match> list = mc.getMyTeamMatches(user);
        if (list.isEmpty()) {
            System.out.println("내 팀의 경기가 없습니다.");
        } else {
            System.out.println("===== 내 팀 경기 일정 =====");
            for (Match m : list) {
                System.out.println(m);
            }
        }
    }
    
    private void MyTeamRanking() {
    	String myTeam = user.getMyTeam();
    	tc.myTeamRanking(myTeam);
    }
}
