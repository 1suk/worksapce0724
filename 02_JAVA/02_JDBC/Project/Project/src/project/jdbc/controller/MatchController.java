package project.jdbc.controller;

import java.time.LocalDate;
import java.util.List;

import project.jdbc.model.vo.Match;
import project.jdbc.service.MatchService;
import project.jdbc.view.MatchMenu;

public class MatchController {
	private MatchService ms = new MatchService();
	
	public void insertMatch(String teamA, String teamB, LocalDate matchDate) {
		Match m = new Match(teamA, teamB, matchDate);
		
		int result = ms.insertMatch(m);
		
		 if(result > 0) {
	            System.out.println("경기 등록 성공!!");
	        } else {
	            System.out.println("경기 등록 실패!!");
	        }
	}
	
	public List<Match> selectMatchAll() {
		List<Match> list = ms.selectMatchList();
		
		if(list.isEmpty()) {	
			System.out.println("매치 목록 조회 결과가 없습니다.");
		}else {
			new MatchMenu().displayList(list);
		}
		return list;
	}
	
	public void deleteMatch(int matchId) {
		Match m = new Match();
		m.setMatchId(matchId);
		
		int result = ms.deleteMatch(m);
		
		if(result > 0) {
			System.out.println("성공적으로 삭제되었습니다");
		}else {
			System.out.println("삭제 실패하였습니다.");
		}
		
	}
	
	public void updateMatch(String teamA, String teamB,  LocalDate matchDate) {
		Match m = new Match(teamA, teamB, matchDate);
		int result = ms.updateMatch(m);
		if(result > 0) {
			System.out.println("성공적으로 수정되었습니다");
		}else {
			System.out.println("수정 실패하였습니다.");
		}
	}
	
	public void updateResult(int matchId, int select) {
		int result = ms.updateResult(matchId, select);
		System.out.println("컨트롤러 실행 ");

		if(result > 0) {
			System.out.println("성공적으로 결과가 업데이트되었습니다");
		}else {
			System.out.println("업데이트 실패하였습니다.");
		}
	}
}
