package project.jdbc.service;

import static project.jdbc.common.JDBCTemplate.close;
import static project.jdbc.common.JDBCTemplate.commit;
import static project.jdbc.common.JDBCTemplate.getConnection;
import static project.jdbc.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import project.jdbc.controller.TeamController;
import project.jdbc.model.dao.MatchDao;
import project.jdbc.model.dao.TeamDao;
import project.jdbc.model.vo.Match;

public class MatchService {
	private MatchDao md;
	private TeamDao td;
	
	public MatchService() {
		super();
		this.md = new MatchDao();
		this.td = new TeamDao();
	}
	
	public int insertMatch(Match m) {
		Connection conn = getConnection();
		int result = md.insertMatch(conn,m);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		return result;		
	}
	
	public List<Match> selectMatchList(){
		Connection conn = getConnection();
		List<Match> list = md.selectMatchList(conn);
		
		close(conn);
		return list;
	}
	
	public int deleteMatch(Match m) {
		Connection conn = getConnection();
		int result = md.deleteMatch(conn, m);
		
		if(result > 0) {
			commit(conn);
		}else{
			rollback(conn);
		}
		return result;
	}
	
	public int updateMatch(Match m) {
		Connection conn = getConnection();
		int result = md.updateMatch(conn, m);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		return result;
		
	}
	
	 public List<Match> selectMatchesByTeam(String team) {
		 Connection conn = getConnection();
	     List<Match> matches = md.selectMatches(conn, team);
	     close(conn);
	     return matches;
	 }
	 
	 public int updateResult(int matchId, int select) {
		 String result = null;
		 Connection conn = getConnection();
		 int res = 0;
		 
		 Match match = md.selectMatchesById(conn, matchId);
		 String Home = match.getTeamA();
		 String Away = match.getTeamB();
		 //System.out.println("Home 팀: " + Home);
	     //System.out.println("Away 팀: " + Away);
		 
		 switch(select) {
		 	case 1: 
		 		result = "HOME_WIN"; 
		 		res = md.updateResult(conn, matchId, result);
		 		td.increaseWin(conn, Home);
		 		td.increaseLose(conn, Away);
		 		break;
		 	case 2: 
		 		result = "AWAY_WIN";
		 		res = md.updateResult(conn, matchId, result);
		 		td.increaseWin(conn, Away);
		 		td.increaseLose(conn, Home);
		 		break;
		 	case 3: 
		 		result = "DRAW"; 
		 		res = md.updateResult(conn, matchId, result);
		 		td.increaseDraw(conn, Home, Away);
		 		break;
		 	default : return 0;
		 }
		 
		 
		 if(res > 0) {
			 commit(conn);
		 }else {
			 rollback(conn);
		 }
		 return res;
	 }
}
