package com.kh.jdbc.service;

//Static으로 import시 static 메서드를 직접 가져와서 사용할 수 있다.
import static com.kh.jdbc.common.JDBCTemplate.close;
import static com.kh.jdbc.common.JDBCTemplate.commit;
import static com.kh.jdbc.common.JDBCTemplate.getConnection;
import static com.kh.jdbc.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

//import com.kh.jdbc.common.JDBCTemplate;
import com.kh.jdbc.model.dao.MemberDao;
import com.kh.jdbc.model.vo.Member;

/*
 * Service
 * 트랜잭션 관리와 같은 비즈니스 로직을 처리하는 계층, Dao와 Controller의 중간 역할
 * 
 * */

public class MemberService {
	private MemberDao md;
	
	public MemberService() {
		super();
		this.md = new MemberDao();
	}

	public int insertMember(Member m) {
		Connection conn = getConnection();
		
		int result = md.insertMember(conn, m);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	public List<Member> selectMemberList() {
		Connection conn = getConnection();
		//Connection conn = md.selectMemberList(conn);
		List<Member> list = md.selectMemberList(conn);
		close(conn);
		
		return list;
	}
	
	public int deleteMembers(List<String> userIds) {
		Connection conn = getConnection();
		
		int result = md.deleteMembers(conn, userIds);
		
		if(result > 0) {
			commit(conn);
		}else{
			rollback(conn);
		}
		return result;
	}
	
	public int updateMember(Member m) {
		Connection conn = getConnection();
		
		int result = md.updateMember(conn, m);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}
	
	public int deleteMember(Member m) {
	Connection conn = getConnection();
		
		int result = md.deleteMember(conn, m);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}
	
	//트랜잭션 처리/ 비즈니스 로직 -> MemberDao로 전달
	public ArrayList<Member> searchKeyword(String userName) {
	    Connection conn = getConnection();
	    ArrayList<Member> list = md.searchKeywordList(conn, userName);
	    close(conn);
	    return list;
	}

}
