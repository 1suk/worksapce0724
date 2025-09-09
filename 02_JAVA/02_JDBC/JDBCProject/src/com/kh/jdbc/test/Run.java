package com.kh.jdbc.test;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Run {
/*
 * JDBC를 사용하기 위해서는 자바 프로젝트에 JDBC드라이버를 추가해줘야한다.
 * 프로젝트 우클릭 -> properties -> java build path -> library -> add external jar -> ojdbc.jar 추가
 * 
 * JDBC용 객체
 * - Connection : DB의 연결 정보를 담고 있는 객체
 * - [Prepared]Statement : 연결된 DB에 sql문을 전달해서 신행하고, 결과를 받아내는 객체
 * - ResultSet : SELECT문(쿼리) 실행 후 조회된 결과를 담는 객체
 * - 
 * */
	
	public static void main(String[] args) {
		/*
		Scanner sc = new Scanner(System.in);
		
		//JDBC 관련 변수 선언
		Connection conn = null;
		Statement stmt = null;
		int result = 0;

		System.out.println("번호 : ");
		int tno = sc.nextInt();

		System.out.println("이름 : ");
		String tName = sc.next();
		sc.nextLine();
		
		//SQL 문자열 생성
		String sql = "INSERT INTO TEST VALUES("+tno+", '"+tName+"', SYSDATE)";

		try {
			//드라이버 로드
		    Class.forName("oracle.jdbc.driver.OracleDriver");
		    System.out.println("oracleDriver 등록성공");
		    
		    //연결
		    conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "C##JDBC","JDBC");
		    conn.setAutoCommit(false);
		    
		    //실행
		    stmt = conn.createStatement();
		    result = stmt.executeUpdate(sql);

		    if(result > 0) conn.commit();
		    else conn.rollback();

		} catch(ClassNotFoundException e) {
		    e.printStackTrace();
		} catch(SQLException e) {
		    e.printStackTrace();
		} finally {
		    try {
		        if(stmt != null) stmt.close();
		        if(conn != null) conn.close();
		    } catch(SQLException e) {
		        e.printStackTrace();
		    }
		    sc.close();
		}

		if(result > 0) System.out.println("데이터 추가 성공");
		else System.out.println("데이터 추가 실패");
*/
	
	//각자의 pc에 jdbc계정 연결 후 test 테이블의 데이터를 select
	//select -> 결과 : ResultSet -> 데이터를 추출
	Scanner sc = new Scanner(System.in);
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		List<Test> list = new ArrayList<>();
		
		//실행할 sql
		String sql = "SELECT * FROM TEST";
		try {
		    // 1) JDBC Driver 등록
		    Class.forName("oracle.jdbc.driver.OracleDriver");
		    System.out.println("OracleDriver 등록 완료");    
		    
		    // 2) Connection 생성
		    conn = DriverManager.getConnection(
		            "jdbc:oracle:thin:@localhost:1521:xe",
		            "c##JDBC",
		            "JDBC"
		    );
		    
		    // 3) Statement 생성
		    stmt = conn.createStatement();
		    
		    // 4, 5) SQL 실행 후 결과 받기
		    rset = stmt.executeQuery(sql);
		    
		    // 6) ResultSet -> 객체 변환
		    while(rset.next()) {
		        int tno = rset.getInt("TNO");
		        String tName = rset.getString("TNAME");
		        Date tDate = rset.getDate("TDATE");
		        
		        list.add(new Test(tno, tName, tDate.toLocalDate()));
		    }
		    //출력
			for (Test t : list) {
			    System.out.println(t);
			}
			
		}catch(ClassNotFoundException e) {
		    e.printStackTrace();
		}catch(SQLException e) {
		    e.printStackTrace();
		}finally {
		    try {
		        if(rset != null) rset.close();
		        if(stmt != null) stmt.close();
		        if(conn != null) conn.close();
		    }catch(SQLException e) {
		        e.printStackTrace();
		    }
		}
		
		/*
		Connection conn = null;
		PreparedStatement pstmt = null;
		Scanner sc = new Scanner(System.in);
		int result = 0;

		System.out.println("수정할 번호를 입력하세요 : ");
		int tno = sc.nextInt();

		System.out.println("새로운 이름을 입력하세요 : ");
		String newName = sc.next();

		System.out.println("새로운 날짜를 입력하세요 (YYYY-MM-DD 형식): ");
		String newDate = sc.next();
		sc.nextLine();

		String sql = "UPDATE TEST SET TNAME = ?, TDATE = TO_DATE(?, 'YYYY-MM-DD') WHERE TNO = ?";

		try {
		    Class.forName("oracle.jdbc.driver.OracleDriver");
		    conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "C##JDBC", "JDBC");
		    conn.setAutoCommit(false);

		    // 미완성된 sql문을 전달해서 pstmt객체 생성
		    pstmt = conn.prepareStatement(sql);

		    // ? 값 세팅
		    pstmt.setString(1, newName);
		    pstmt.setString(2, newDate);
		    pstmt.setInt(3, tno);
		    
		    //실행
		    result = pstmt.executeUpdate();

		    if (result > 0) {
		        conn.commit();
		    } else {
		        conn.rollback();
		    }

		} catch (ClassNotFoundException e) {
		    e.printStackTrace();
		} catch (SQLException e) {
		    e.printStackTrace();
		} finally {
		    try {
		        if (pstmt != null) pstmt.close();
		        if (conn != null) conn.close();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		}

		if (result > 0) {
		    System.out.println(result + "개의 행 UPDATE");
		} else {
		    System.out.println("UPDATE 실패");
		}
		*/			
	}
}