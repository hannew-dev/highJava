package kr.or.ddit.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * db.properties파일의 내용으로 DB정보를 설정하는 방법
 * 방법1)Properties객체 이용하기
 * 
 * @author PC-04
 *
 */
import java.util.Properties;

public class JDBCUtil2 {

	static Properties prop; // 객체 변수 선언

	static {
		prop = new Properties();// 객체생성

		try {
			prop.load(new FileInputStream("res/db.properties"));
			Class.forName(prop.getProperty("driver"));
			System.out.println("드라이버 로딩 성공!");

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패!");
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(prop.getProperty("url"),
												prop.getProperty("username"), 
												prop.getProperty("password"));
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

	/**
	 * 자원반납
	 * 
	 * @param conn
	 * @param pstmt
	 * @param stmt
	 * @param rs
	 */
	public static void close(Connection conn, PreparedStatement pstmt, Statement stmt, ResultSet rs) {
		if (rs != null)
			try {
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
