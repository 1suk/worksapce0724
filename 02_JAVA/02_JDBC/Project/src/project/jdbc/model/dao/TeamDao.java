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

import project.jdbc.model.vo.Team;

public class TeamDao {
	 private Properties prop = new Properties();
	 
	 public TeamDao() {
	        try {
	            prop.loadFromXML(new FileInputStream("resources/query.xml"));
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	 
	 public int increaseWin(Connection conn, String team) {
		    PreparedStatement pstmt = null;
		    int result = 0;

		    String sql = prop.getProperty("increaseWin"); 
		

		    try {
		        pstmt = conn.prepareStatement(sql);
		        pstmt.setString(1, team); 

		        result = pstmt.executeUpdate();
		        System.out.println("update 실행 결과: " + result);

		    } catch (SQLException e) {
		        e.printStackTrace();
		    } finally {
		        if (pstmt != null) {
		            try {
		                pstmt.close();
		            } catch (SQLException e) {
		                e.printStackTrace();
		            }
		        }
		    }

		    return result;
		}
	 
	 public int increaseLose(Connection conn, String team) {
		 PreparedStatement pstmt = null;
		 int result = 0;
		 
		 String sql = prop.getProperty("increaseLose");
		 try {
			 pstmt = conn.prepareStatement(sql);
			 pstmt.setString(1, team);
			 
			 result = pstmt.executeUpdate();
		 }catch(SQLException e) {
			 e.printStackTrace();
		 }finally {
			 close(pstmt);
		 }
		 return result;
	 }
	 
	 public int increaseDraw(Connection conn, String home, String away) {
		 PreparedStatement pstmt = null;
		 int result = 0;
		 
		 String sql = prop.getProperty("increaseDraw");
		 try {
			 pstmt = conn.prepareStatement(sql);
			 pstmt.setString(1, home);
			 pstmt.setString(2, away);
			 
			 result = pstmt.executeUpdate();
		 }catch(SQLException e) {
			 e.printStackTrace();
		 }finally {
			 close(pstmt);
		 }
		 return result;
	 }
	 
	 public List<Team> teamRanking(Connection conn){
		 PreparedStatement pstmt = null;
		 ResultSet rset = null;
		 String sql = prop.getProperty("getRanking");
		 ArrayList<Team> list = new ArrayList();
		 
		 try {
			 pstmt = conn.prepareStatement(sql);
			 rset = pstmt.executeQuery();
			 
			 while(rset.next()) {
				 Team t = new Team();
				 t.setTeamName(rset.getString("teamName"));
				 t.setWin(rset.getInt("win"));
				 t.setLose(rset.getInt("lose"));
				 t.setDraw(rset.getInt("draw"));
				 t.setTotalScore(rset.getInt("totalScore"));
				 
				 list.add(t);
			 }
		 }catch(SQLException e){
			 e.printStackTrace();
		 }
		 
		 return list;
	 }
	 
}
