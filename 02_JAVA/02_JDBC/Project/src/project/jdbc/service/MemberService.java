package project.jdbc.service;

import static project.jdbc.common.JDBCTemplate.close;
import static project.jdbc.common.JDBCTemplate.commit;
import static project.jdbc.common.JDBCTemplate.getConnection;
import static project.jdbc.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import project.jdbc.model.dao.MatchDao;
import project.jdbc.model.dao.MemberDao;
import project.jdbc.model.vo.Match;
import project.jdbc.model.vo.Member;

public class MemberService {
	private MemberDao md;
	private MatchDao mtd;
	public MemberService(){
		super();
		this.md = new MemberDao();
		this.mtd = new MatchDao();
	}
	
	public int joinMember(Member m) {
		Connection conn = getConnection();
		int result = md.joinMemeber(conn, m);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		return result;
	}
	
	public String getMyTeam(String userId) {
		Connection conn = getConnection();
	    String myTeam = null;
	    myTeam = md.getMyTeam(conn, userId);
	    close(conn);  
	    return myTeam;
	}
	
	public Member login(String userId, String userPwd) {
		Connection conn = getConnection();
		Member m = md.login(conn, userId, userPwd);
		close(conn);
		return m;
	}
}
