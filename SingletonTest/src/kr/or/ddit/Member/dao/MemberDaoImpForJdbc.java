package kr.or.ddit.Member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

import kr.or.ddit.Member.vo.MemberVO;
import kr.or.ddit.util.JDBCUtil3;

public class MemberDaoImpForJdbc implements IMemberDAO {
	//JDBC관련된 모든것들 DAO에 넣어줄것임
	
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private static IMemberDAO memDAO;
	
	private MemberDaoImpForJdbc(){
		// TODO Auto-generated constructor stub
	}
	
	public static IMemberDAO getInstance() {
		if (memDAO == null) {
			memDAO = new MemberDaoImpForJdbc();
		}
		return memDAO;
	}
	@Override
	public int insertMember(MemberVO mv) {
		int cnt =0;
		try {
			conn = JDBCUtil3.getConnection();

			String sql = " INSERT INTO mymember (" 
						+ "     mem_id," 
						+ "     mem_name," 
						+ "     mem_tel,"
						+ "     mem_addr," 
						+ "     reg_dt" 
						+ " ) VALUES (" 
						+ "     ?," 
						+ "     ?,"
						+ "     ?," 
						+ "     ?," 
						+ "     SYSDATE" 
						+ " )";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mv.getMemId());
			pstmt.setString(2, mv.getMemName());
			pstmt.setString(3, mv.getMemTel());
			pstmt.setString(4, mv.getMemAddr());

			cnt = pstmt.executeUpdate(); // select는 executeQuery


		} catch (SQLException e) {
			throw new RuntimeException("회원정보 등록중 예외발생",e);
		} finally {

			JDBCUtil3.close(conn, pstmt, pstmt, rs);

		}		return cnt;
	}

	@Override
	public boolean checkMember(String memId) {
		boolean isExist = false;
		try {
			conn = JDBCUtil3.getConnection();
			
			String sql = " SELECT" + 
						"    count(*)"+ 
						" as CNT" + 
						" FROM" + 
						"    mymember" + 
						" WHERE" + 
						"    mem_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,memId);
			
			rs = pstmt.executeQuery();
			
			int cnt = 0;
			
			while (rs.next()) {
				cnt = rs.getInt("CNT");
			}
			if (cnt > 0) {
				isExist =  true;//존재하면 true
			}
		} catch (SQLException e) {
			throw new RuntimeException("회원정보 확인중 예외발생",e);
		}
		
		
		return isExist;//존재하지 않으면 false
	}		

	@Override
	public int updateMember(MemberVO mv) {
		int cnt = 0;
		try {
			conn = JDBCUtil3.getConnection();
			String sql = " UPDATE mymember" + 
								"    SET mem_name = ?," + 
								"        mem_tel = ?," + 
								"        mem_addr = ?" + 
								"    WHERE mem_id = ?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, mv.getMemName());
			pstmt.setString(2, mv.getMemTel());
			pstmt.setString(3, mv.getMemAddr());
			pstmt.setString(4, mv.getMemId());
			
			cnt = pstmt.executeUpdate();
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("회원정보 수정중 예외발생",e);
		}finally {
			JDBCUtil3.close(conn, pstmt, pstmt, rs);
		}
		return cnt;
	}

	@Override
	public int deleteMember(String memId) {
		int cnt =0;
		try {
			conn = JDBCUtil3.getConnection();
			
			String sql = "DELETE FROM mymember "
						+ "WHERE mem_id = ?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, memId);
			
			cnt = pstmt.executeUpdate();
			
			
		}catch (Exception e) {
			
			throw new RuntimeException("회원정보 삭제중 예외발생",e);

		}finally {
			
			JDBCUtil3.close(conn, pstmt, pstmt, rs);
		}
				return cnt;
	}

	@Override
	public List<MemberVO> selectAllMember() {
		List<MemberVO> memList = new ArrayList<MemberVO>();
		
		try {
			conn = JDBCUtil3.getConnection();
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery("select * from mymember");
			
			
			while (rs.next()) {
				MemberVO mv  = new MemberVO();
				mv.setMemId(rs.getString("mem_id"));
				mv.setMemName(rs.getString("mem_name"));
				mv.setMemTel(rs.getString("mem_tel"));
				mv.setMemAddr(rs.getString("mem_addr"));
				
				memList.add(mv);
				
			}
			
		} catch (Exception e) {
			throw new RuntimeException("회원정보 수정중 예외발생",e);
			
		}finally {
			JDBCUtil3.close(conn, pstmt, pstmt, rs);
		}
		
				return memList;
	}

	@Override
	public List<MemberVO> searchMember(MemberVO mv) {
		List<MemberVO> memList = new ArrayList<MemberVO>();
		
		try {
			conn = JDBCUtil3.getConnection();

			
			String sql = "select * from mymember where 1 = 1 ";
			
			if(mv.getMemId()!= null && !mv.getMemId().equals("")) {
				sql += " and mem_id = ? ";
			}
			if(mv.getMemName()!= null && !mv.getMemName().equals("")) {
				sql += " and mem_name = ? ";
			}
			if(mv.getMemTel()!= null && !mv.getMemTel().equals("")) {
				sql += " and mem_tel = ? ";
			}
			if(mv.getMemAddr()!= null && !mv.getMemAddr().equals("")) {
				sql += " and mem_Addr like '%'|| ? ||'%'";
			}
			
			pstmt = conn.prepareStatement(sql);
			
			int index = 1;
			
			if(mv.getMemId()!= null && !mv.getMemId().equals("")) {
				pstmt.setString(index++, mv.getMemId());
			}
			if(mv.getMemName()!= null && !mv.getMemName().equals("")) {
				pstmt.setString(index++, mv.getMemName());			}
			if(mv.getMemTel()!= null && !mv.getMemTel().equals("")) {
				pstmt.setString(index++, mv.getMemTel());			}
			if(mv.getMemAddr()!= null && !mv.getMemAddr().equals("")) {
				pstmt.setString(index++, mv.getMemAddr());	
			}
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				MemberVO mv2  = new MemberVO();
				mv2.setMemId(rs.getString("mem_id"));
				mv2.setMemName(rs.getString("mem_name"));
				mv2.setMemTel(rs.getString("mem_tel"));
				mv2.setMemAddr(rs.getString("mem_addr"));
				
				memList.add(mv2);
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCUtil3.close(conn, pstmt, pstmt, rs);
		}
		
				return memList;
	}
	
}
