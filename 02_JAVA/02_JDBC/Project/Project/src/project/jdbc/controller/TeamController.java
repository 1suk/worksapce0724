package project.jdbc.controller;

import java.util.List;

import project.jdbc.model.vo.Team;
import project.jdbc.service.TeamService;
import project.jdbc.view.MatchMenu;

public class TeamController {
	private TeamService ts;
	
	public TeamController() {
		this.ts = new TeamService();
	}
	
	public List<Team> myTeamRanking(String myTeam) {	   
	    List<Team> list = ts.getTeamRanking();

	    if(list.isEmpty()) {
	        System.out.println("랭킹 정보가 없습니다.");
	        return list;
	    }

	    int myIndex = -1;
	    for(int i = 0; i < list.size(); i++) {
	        if(list.get(i).getTeamName().equals(myTeam)) {
	            myIndex = i;
	            break;
	        }
	    }

	    if(myIndex == -1) {
	        System.out.println("내 팀 정보가 랭킹에 없습니다.");
	        return list;
	    }

	    int start = 0;
	    int end = list.size() - 1;

	    if(myIndex == 0) { 
	        start = 0;
	        end = 1; 
	    } else if(myIndex == list.size() - 1) { 
	        start = myIndex - 1; 
	        end = myIndex;
	    } else { 
	        start = myIndex - 1;
	        end = myIndex + 1;
	    }

	    for(int i = start; i <= end; i++) {
	        Team t = list.get(i);
	        String marker = t.getTeamName().equals(myTeam) ? " (*)" : "";
	        System.out.println((i + 1) + "위 / " + t.getTeamName()
	                           + " / 승: " + t.getWin()
	                           + " / 무: " + t.getDraw()
	                           + " / 패: " + t.getLose()
	                           + " / 총점: " + t.getTotalScore()
	                           + marker);
	    }
	    return list;
	}


	
	public List<Team> getTeamRanking() {
		List<Team> list = ts.getTeamRanking();
		
		if(list.isEmpty()) {	
			System.out.println("매치 목록 조회 결과가 없습니다.");
		}else {
			for(int i=0; i<list.size(); i++) {
				Team t = list.get(i);
	            System.out.println((i + 1) + "위 / " + t.getTeamName() 
	                               + " / 승: " + t.getWin() 
	                               + " / 무: " + t.getDraw() 
	                               + " / 패: " + t.getLose() 
	                               + " / 총점: " + t.getTotalScore());
			}
		}
		return list;
	}
	

}
