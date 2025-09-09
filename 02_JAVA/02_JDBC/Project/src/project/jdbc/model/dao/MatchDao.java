package project.jdbc.model.dao;

import static project.jdbc.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import project.jdbc.model.vo.Match;

public class MatchDao {
	
	 private Properties prop = new Properties();

	    public MatchDao() {
	        try {
	            prop.loadFromXML(new FileInputStream("resources/query.xml"));
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	    
	    
    public int insertMatch(Connection conn, Match m) {
        PreparedStatement pstmt = null;
        int result = 0;
        
        String sql = prop.getProperty("insertMatch");
        
        try {
            pstmt = conn.prepareStatement(sql);
            
            pstmt.setString(1, m.getTeamA());
            pstmt.setString(2, m.getTeamB());
            pstmt.setDate(3, java.sql.Date.valueOf(m.getMatchDate()));

            
            result = pstmt.executeUpdate();
            
        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            close(pstmt); 
        }
        return result;
    }
    
    public List<Match> selectMatchList(Connection conn) {
    	PreparedStatement pstmt = null;
    	ResultSet rset = null;
    	String sql = prop.getProperty("selectMatch");
    	ArrayList<Match> list = new ArrayList<>();
    	
    	try {
    		pstmt = conn.prepareStatement(sql);
    		rset = pstmt.executeQuery();
    		
    		while(rset.next()) {
    			Match m = new Match();
    			m.setMatchId(rset.getInt("match_id"));
    			m.setTeamA(rset.getString("teamA"));
    			m.setTeamB(rset.getString("teamB"));
    			m.setMatchDate(rset.getDate("match_date").toLocalDate());
    			
    			list.add(m);
    		}
    		
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}finally {
    		close(pstmt);
    		close(rset);
    	}
    	return list;
    }
    
    public int updateMatch(Connection conn, Match m) {
    	PreparedStatement pstmt = null;
    	int result = 0;
    	String sql = prop.getProperty("updateMatch");
    	
    	try {
    		pstmt = conn.prepareStatement(sql);
    		pstmt.setString(1, m.getTeamA());
    		pstmt.setString(2, m.getTeamB());
            pstmt.setDate(3, java.sql.Date.valueOf(m.getMatchDate()));
    		
    		result = pstmt.executeUpdate();
    		
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}finally {
    		close(pstmt);
    	}
    	return result;
    	
    }
    
    public int deleteMatch(Connection conn, Match m) {
    	PreparedStatement pstmt = null;
    	int result = 0;
    	String sql = prop.getProperty("deleteMatch");
    	
    	try {
    		pstmt = conn.prepareStatement(sql);
    		pstmt.setInt(1, m.getMatchId());
    		
    		result = pstmt.executeUpdate();
    		
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}finally {
    		close(pstmt);
    	}
    	return result;
    }
    
    public List<Match> selectMatches(Connection conn, String team){
    	List<Match> list = new ArrayList<>();
    	PreparedStatement pstmt = null;
    	ResultSet rset = null;
    	String sql = prop.getProperty("selectMatches");
    	try {
    		pstmt = conn.prepareStatement(sql);
        	pstmt.setString(1, team);
        	pstmt.setString(2, team);
        	
        	rset = pstmt.executeQuery();
        	while(rset.next()) {
        		Match m = new Match();
        		m.setMatchId(rset.getInt("match_id"));
        		m.setTeamA(rset.getString("teamA"));
        		m.setTeamB(rset.getString("teamB"));
        		m.setMatchDate(rset.getDate("match_date").toLocalDate());
        		list.add(m);
        	}
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}finally {
    		close(pstmt);
    		close(rset);
    	}
    	return list;
    }
    
    public Match selectMatchesById(Connection conn, int matchId){
    	Match m = null;
    	PreparedStatement pstmt = null;
    	ResultSet rset = null;
    	String sql = "SELECT * FROM matches WHERE match_id = ?";
    	
    	try {
    		pstmt = conn.prepareStatement(sql);
        	pstmt.setInt(1, matchId);
        	
        	rset = pstmt.executeQuery();
        	while(rset.next()) {
        		m = new Match();
        		m.setMatchId(rset.getInt("match_id"));
        		m.setTeamA(rset.getString("teamA"));
        		m.setTeamB(rset.getString("teamB"));
        		m.setMatchDate(rset.getDate("match_date").toLocalDate());
        		m.setResult(rset.getString("result"));
        	}
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}finally {
    		close(pstmt);
    		close(rset);
    	}
    	return m;
    }
    
    public int updateResult(Connection conn, int matchId, String result) {
    	PreparedStatement pstmt = null;
    	String sql = prop.getProperty("updateResult");
    	int res = 0;
    	
    	try {
    		pstmt = conn.prepareStatement(sql);
    		pstmt.setString(1, result);
    		pstmt.setInt(2, matchId);
    		
    		res = pstmt.executeUpdate();
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}finally {
    		close(pstmt);
    	}
    	return res;
    }
}
