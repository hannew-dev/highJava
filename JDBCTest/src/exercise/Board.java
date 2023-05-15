package exercise;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import kr.or.ddit.util.JDBCUtil3;

/**
 * 위의 테이블을 작성하고 게시판을 관리하는
다음 기능들을 구현하시오.

기능 구현하기 ==> 전체 목록 출력, 새글작성, 수정, 삭제, 검색 
 
------------------------------------------------------------

게시판 테이블 구조 및 시퀀스

create table jdbc_board(
    board_no number not null,  -- 번호(자동증가)
    board_title varchar2(100) not null, -- 제목
    board_writer varchar2(50) not null, -- 작성자
    board_date date not null,   -- 작성날짜
    board_content clob,     -- 내용
    constraint pk_jdbc_board primary key (board_no)
);
create sequence board_seq
    start with 1   -- 시작번호
    increment by 1; -- 증가값
		
----------------------------------------------------------

// 시퀀스의 다음 값 구하기
//  board_seq.nextVal



 * @author PC-04
 *
 */
public class Board {
	
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private Scanner scan = new Scanner(System.in);

	/**
	 * 메뉴를 출력하는 메서드
	 */
	public void displayMenu() {
		System.out.println();
		System.out.println("----------------------");
		System.out.println("  === 작 업 선 택 ===");
		System.out.println("  1. 전체글 목록 조회");
		System.out.println("  2. 새 글 작성");
		System.out.println("  3. 글 수정");
		System.out.println("  4. 글 삭제");
		System.out.println("  5. 글 검색.");
		System.out.println("  6. 종    료.");
		System.out.println("----------------------");
		System.out.print("원하는 작업 선택 >> ");
	}
	
	/**
	 * 프로그램 시작메서드
	 */
	public void start() {
		int choice;
		do {
			displayMenu(); // 메뉴 출력
			choice = scan.nextInt(); // 메뉴번호 입력받기
			switch (choice) {
			case 1: // 전체글 목록 조회
				selectAllPost();
				break;
			case 2: // 새 글 작성
				writePost();
				break;
			case 3: // 글 수정
				updatePost();
				break;
			case 4: // 글 삭제
				deletePost();
				break;
			case 5: // 글 검색
				searchPost();
				break;
			case 6: // 종료
				System.out.println("작업을 마칩니다.");
				break;
			default:
				System.out.println("번호를 잘못 입력했습니다. 다시입력하세요");
			}
		} while (choice != 6);
	}

	private void selectAllPost() {
		try {
			conn = JDBCUtil3.getConnection();
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery("select * from jdbc_board");
			
			System.out.println();
			System.out.println("----------------------------------------------------");
			System.out.println(" 글 번호 \t 제   목 \t작 성 자 \t\t작성날짜 \t\t내    용");
			System.out.println("----------------------------------------------------");
			
			while (rs.next()) {
				String boardNo = rs.getString("board_no");
				String boardTitle = rs.getString("board_title");
				String boardWriter = rs.getString("board_writer");
				String boardDate = rs.getString("board_date");
				String boardContent = rs.getString("board_content");
				
				System.out.println(" "+ boardNo + "\t"+ boardTitle + "\t" + boardWriter + "\t" + boardDate  + "\t" +boardContent);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCUtil3.close(conn, pstmt, stmt, rs);
		}
		
		
	}

	private void writePost() {
		
			int boardNo = 0;
		
			System.out.println();
			System.out.println("글 제목을 입력해 주세요.");
			System.out.print("글 제목 >>");

			String boardTitle = scan.next();

			

		System.out.print("작성자 >> ");
		String boardWriter = scan.next();


		scan.nextLine();

		System.out.print("내용 >> ");
		String boardContent = scan.nextLine();

		try {
			conn = JDBCUtil3.getConnection();

			String sql = " INSERT INTO jdbc_board (" 
						+ "     board_no," 
						+ "     board_title," 
						+ "     board_writer,"
						+ "     board_date," 
						+ "     board_content" 
						+ " ) VALUES (" 
						+ "     board_seq.nextVal," 
						+ "     ?,"
						+ "     ?," 
						+ "     SYSDATE," 
						+ "     ?" 
						+ " )";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardTitle);
			pstmt.setString(2, boardWriter);
			pstmt.setString(3, boardContent);

			int cnt = pstmt.executeUpdate(); // select는 executeQuery
			
			boardNo++;

			if (cnt > 0) {
				System.out.println("게시글 작성 성공!");
			} else {
				System.out.println("게시글 작성 실패!!");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			JDBCUtil3.close(conn, pstmt, stmt, rs);

		}
		
	}

	private void updatePost() {
		boolean isExist = false;

		String boardNo = "";
			selectAllPost();

		do {
			System.out.println();
			System.out.println("수정할 글 번호를 입력하세요");
			System.out.print("글 	번호 >>");

			boardNo = scan.next();

			isExist = checkNum(boardNo);// 아이디를 확인해서 DB에 있나 확인

			if (!isExist) {
				System.out.println("글 번호가 " + boardNo + "인 글은 존재하지 않습니다.");
				System.out.println("다시 입력해주세요");
			}

		} while (!isExist);

		System.out.print("글제목 >> ");
		String boardTitle = scan.next();

		scan.nextLine();//엔터 초기화
		
		System.out.print("내용 >> ");
		String boardContent = scan.next();
		
		scan.nextLine();//엔터 초기화
	
		
		try {
			conn = JDBCUtil3.getConnection();
			String sql = " UPDATE jdbc_board" + 
								"    SET board_title = ?," + 
								"        board_date = SYSDATE," + 
								"        board_content = ?" + 
								"    WHERE board_no = ?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, boardTitle);
			pstmt.setString(2, boardContent);
			pstmt.setString(3, boardNo);

			
			int cnt = pstmt.executeUpdate();
			
			if (cnt > 0) {
				System.out.println("글번호: "+boardNo + " 수정 성공!");
			} else {
				System.out.println("글번호: "+boardNo + " 수정 실패!!");
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCUtil3.close(conn, pstmt, stmt, rs);
		}
		
	
		
	}
	
	private boolean checkNum(String boardno) {
		boolean isExist = false;
		try {
			conn = JDBCUtil3.getConnection();
			
			String sql = " SELECT" + 
						"    count(*)"+ 
						" as CNT" + 
						" FROM" + 
						"    jdbc_board" + 
						" WHERE" + 
						"    board_No = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,boardno);
			
			rs = pstmt.executeQuery();
			
			int cnt = 0;
			
			while (rs.next()) {
				cnt = rs.getInt("CNT");
			}
			if (cnt > 0) {
				isExist =  true;//존재하면 true
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return isExist;//존재하지 않으면 false
	}


	private void deletePost() {
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println("삭제할 글 정보를 입력해 주세요.");
		

		selectAllPost();
		
		scan.nextLine();//엔터 초기화
		System.out.print("글 번호 >>");
		String boardNo = scan.next();
		
		
		try {
			conn = JDBCUtil3.getConnection();
			
			String sql = "DELETE FROM jdbc_board "
						+ "WHERE board_no = ?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, boardNo);
			
			int cnt = pstmt.executeUpdate();
			
			if(cnt>0) {
				System.out.println(boardNo + "글 삭제 작업 성공!");
			} else {
				System.out.println(boardNo + "글 삭제 작업 실패!!");
			}
			
			
		}catch (Exception e) {
			// TODO: handle exception
		}finally {
			JDBCUtil3.close(conn, pstmt, stmt, rs);
		}
		
	}

	private void searchPost() {
		// TODO Auto-generated method stub
		
		scan.nextLine();// 버퍼비우기

		System.out.println();
		System.out.println("검색할 정보를 입력하세요.");
		System.out.print("글 번호>> ");

		String boardNo = scan.nextLine().trim();

		System.out.print("글 제목>> ");

		String boardTitle = scan.nextLine().trim();

		System.out.print("작성자>> ");

		String boardWriter = scan.nextLine().trim();

		System.out.print("작성날짜>> ");

		String boardDate = scan.nextLine().trim();
		
		System.out.print("글내용>> ");
		
		String boardContent = scan.nextLine().trim();
		
		try {
			conn = JDBCUtil3.getConnection();
			
			
			String sql = "select * from jdbc_board where 1 = 1 ";
			
			if(boardNo!= null && !boardNo.equals("")) {
				sql += " and board_no = ? ";
			}
			if(boardTitle!= null && !boardTitle.equals("")) {
				sql += " and board_title like '%'|| ? ||'%' ";
			}
			if(boardWriter!= null && !boardWriter.equals("")) {
				sql += " and board_writer = ? ";
			}
			if(boardDate!= null && !boardDate.equals("")) {
				sql += " and board_date like '%'|| ? ||'%' ";
			}
			if(boardContent!= null && !boardContent.equals("")) {
				sql += " and board_content like '%'|| ? ||'%'";
			}
			
			pstmt = conn.prepareStatement(sql);
			
			int index = 1;
			
			if(boardNo!= null && !boardNo.equals("")) {
				pstmt.setString(index++, boardNo);
			}
			if(boardTitle!= null && !boardTitle.equals("")) {
				pstmt.setString(index++, boardTitle);			}
			if(boardWriter!= null && !boardWriter.equals("")) {
				pstmt.setString(index++, boardWriter);			}
			if(boardDate!= null && !boardDate.equals("")) {
				pstmt.setString(index++, boardDate);	}
			if(boardContent!= null && !boardContent.equals("")) {
				pstmt.setString(index++, boardContent);	
			}
			
			System.out.println();
			System.out.println("----------------------------------------------------");
			System.out.println("\t\t\t검색 결과\t\t\t");
			System.out.println(" 글 번호 \t 제   목 \t작 성 자 \t\t작성날짜 \t\t내    용");
			System.out.println("----------------------------------------------------");

			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				 boardNo = rs.getString("board_no");
				 boardTitle = rs.getString("board_title");
				 boardWriter = rs.getString("board_writer");
				 boardDate = rs.getString("board_date");
				 boardContent = rs.getString("board_content");
				 
				 System.out.println(" "+ boardNo + "\t"+ boardTitle + "\t" + boardWriter + "\t" + boardDate  + "\t" +boardContent);
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCUtil3.close(conn, pstmt, stmt, rs);
		}
		
	}
	

	
	public static void main(String[] args) {
		Board obj = new Board();
		obj.start();
	}
	
	

}
