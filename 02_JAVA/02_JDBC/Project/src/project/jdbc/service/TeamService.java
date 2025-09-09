package project.jdbc.service;

import static project.jdbc.common.JDBCTemplate.close;
import static project.jdbc.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import project.jdbc.model.dao.TeamDao;
import project.jdbc.model.vo.Team;

public class TeamService {
	private TeamDao td;
	public TeamService() {
		this.td = new TeamDao();
	}
	
	public List<Team> getTeamRanking(){
		Connection conn = getConnection();
		List<Team> list = td.teamRanking(conn);
		close(conn);
		return list;
	}
}
