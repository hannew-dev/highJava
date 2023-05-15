package kr.or.ddit.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * db.properties 파일의 내용으로 DB정보를 
 * @author PC-04
 *
 */
import java.util.ResourceBundle;
public class JDBCUtil3 {
	//static블럭 객체 로딩되는 시점에 딱 한번 호출된다.
	static ResourceBundle bundle;//객체 변수 선언
	
	static {
		bundle = ResourceBundle.getBundle("db");
		
	
		try {
			Class.forName(bundle.getString("driver"));
			System.out.println("드라이버 로딩 성공!");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패!");
			e.printStackTrace();
		}
	}

	public static Connection getConnection() { 
		try {
			return DriverManager.getConnection(
					bundle.getString("url"),
					bundle.getString("username"), 
					bundle.getString("password"));
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}
	/**
	 * 자원반납
	 * @param conn
	 * @param pstmt
	 * @param stmt
	 * @param rs
	 */
	public static void close(Connection conn,
							PreparedStatement pstmt,
							Statement stmt,
							ResultSet rs) {
							if (rs != null)try {
									rs.close();
								} catch (SQLException e) {
								}
							if (stmt != null)
								try {
									stmt.close();
								} catch (SQLException e) {
								}
							if (pstmt != null)
								try {
									pstmt.close();
								} catch (SQLException e) {
								}
							if (conn != null)
								try {
									conn.close();
								} catch (SQLException e) {
								}
		
	}
}
