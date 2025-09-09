package project.jdbc.view;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import project.jdbc.controller.MatchController;
import project.jdbc.controller.TeamController;
import project.jdbc.model.vo.Match;

public class MatchMenu {
	private Scanner sc;
	private MatchController mc;
	private TeamController tc;
	
	public MatchMenu() {
		super();
		this.sc = new Scanner(System.in);
		this.mc = new MatchController();
		this.tc = new TeamController();
	}
	
	public void MainMenu() {
		while(true){
			System.out.println("===== 경기 관리 프로그램 =====");
	        System.out.println("1. 경기 추가");
	        System.out.println("2. 경기 목록 조회");
	        System.out.println("3. 경기 수정");
	        System.out.println("4. 경기 삭제");
	        System.out.println("5. 경기 결과 입력");
	        System.out.println("6. 전체 팀 순위");
	        System.out.println("9. 뒤로 가기");
            System.out.print("메뉴 선택: ");
			int sel = sc.nextInt();
			
			switch(sel) {
				case 1 :
					insertMatch();
					break;
				case 2 : mc.selectMatchAll(); break;
				case 3 : updateMatch(); break;
				case 4 : deleteMatch(); break;
				case 5 : updateResult(); break;
				case 6: tc.getTeamRanking(); break;
				case 9 :
					return;
				default :
					System.out.println("잘못입력하셨습니다. 다시 입력해주세요!");
			}
		}
	}	
		
		public void insertMatch() {
			System.out.println("===== 매치 추가 =====");
			System.out.println("HOME팀 입력하세요 : ");
			String teamA = sc.next();
			
			System.out.println("AWAY팀 입력하세요 : ");
			String teamB = sc.next();
			
			System.out.println("매치 날짜를 입력하세요 : ");
			String strDate = sc.next();
			LocalDate matchDate = LocalDate.parse(strDate);
			
			mc.insertMatch(teamA, teamB, matchDate);
		}
		
		/*
		public void displayList(List list) {
			System.out.println("===== 전체 매치 목록 조회 =====");
			for(Object obj : list) {
				System.out.println(obj);
			}
			
		}
		*/
		
		public void displayList(List<Match> list) {
			System.out.println("===== 전체 매치 목록 조회 =====");
			for(int i=0; i<list.size(); i++) {
				System.out.println((i+1) + ") " + list.get(i));
			}
		}
		
		public void deleteMatch() {
			System.out.println("===== 매치 삭제 =====");
			System.out.println("매치 번호를 입력하세요 : ");
			int matchId = sc.nextInt();
			mc.deleteMatch(matchId);
		}
		
		public void updateMatch() {
			System.out.println("===== 매치 수정 =====");
			System.out.println("HOME팀 입력하세요 :");
			String teamA = sc.next();
			
			System.out.println("AWAY팀 입력하세요 :");
			String teamB = sc.next();
			
			System.out.println("매치 날짜를 입력하세요 :");
			String strDate = sc.next();
			LocalDate matchDate = LocalDate.parse(strDate);
			
			mc.updateMatch(teamA, teamB, matchDate);
		}
		
		public void updateResult() {
			List<Match> list = mc.selectMatchAll();
			
			System.out.println("매치 번호를 선택해주세요 :");
			int sel = sc.nextInt() - 1;
			Match selected = list.get(sel); 
			
			System.out.println("===== 승부 결과 입력 =====");
			System.out.println("1) HOME_WIN 2) AWAY_WIN 3) DRAW");
			int select = sc.nextInt();
			sc.nextLine();
			mc.updateResult(selected.getMatchId(), select);
			
		}
}
