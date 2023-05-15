package kr.or.ddit.basic;

import java.io.Reader;
import java.nio.charset.Charset;
import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.or.ddit.Member.vo.MemberVO;

public class MybatisTest {
	public static void main(String[] args) {
		// myBatis를 이용하여 DB작업을 처리하는 방법
		// 1.myBatis의 환경설정 파일을 읽어와 실행시킨다.

		SqlSessionFactory sessionFactory = null;

		try {
			// 1-1.xml 설정파일 읽어오기
			Charset charset = Charset.forName("utf-8");// 한글처리를 위해
			Resources.setCharset(charset);

			Reader rd = Resources.getResourceAsReader("mybatis-config.xml");

			// 1-2.Reader객체를 이용하여 SqlSessionFactory객체 생성하기
			sessionFactory = new SqlSessionFactoryBuilder().build(rd);

			// 1-3.Reader닫기
			rd.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		// 2.실행할 SQL문에 맞는 쿼리문을 호출하여 원하는 작업을 수행한다.

		// 2-1.insert작업 연습

//		System.out.println("insert 작업 시작");
//		
//		//1)저장할 데이터를 VO에 담는다.
//		MemberVO mv = new MemberVO();
//		mv.setMemId("d001");
//		mv.setMemName("강감찬");
//		mv.setMemTel("1111-2222");
//		mv.setMemAddr("경남 진주");
//
//		//2)SqlSession 객체를 이용하여 해당 쿼리문을 실행한다.
//		//형식) sqlSession.insert("namespace값.id값", 파라미터 객체);
//		//반환값 : 성공한 레코드 수
		SqlSession session = sessionFactory.openSession(false);// 오토커밋 여부(false)->하지않겠다

//		
//		try {
//			int cnt = session.insert("memberTest.insertMember", mv);
//			if (cnt>0) {
//				System.out.println("insert 작업 성공");
//				session.commit();//오토커밋을 풀어놔서 직접 커밋 해줘야한다.
//			}else {
//				System.out.println("insert 작업 실패!!");
//				
//			}
//			
//		} catch (PersistenceException e) {
//			e.printStackTrace();
//			session.rollback();
//		
//		}finally {
//			session.close();
//		}
//		
		System.out.println("---------------------------------------------");

		// 2-2 update 연습
		System.out.println("update 작업 시작..");

		MemberVO mv2 = new MemberVO();
		mv2.setMemId("d001");
		mv2.setMemName("허자연");
		mv2.setMemTel("3333-2222");
		mv2.setMemAddr("부산시 해운대구");

		session = sessionFactory.openSession(false);

		try {
			// update()메서드의 반환값도 성공한 레코드 수 이다.
			int cnt = session.update("memberTest.updateMember", mv2);

			if (cnt > 0) {
				System.out.println("update 성공");
				session.commit();// 오토커밋을 풀어놔서 직접 커밋 해줘야한다.
			} else {
				System.out.println("update 실패!!");

			}

		} catch (PersistenceException e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}
		System.out.println("---------------------------------------------");

		// 2-3. delete연습
		System.out.println("delete 연습 시작!");

		session = sessionFactory.openSession();// 괄호 비어있으면 디폴드값이 false

		try {
			// delete()메서드도 성공한 레코드 수를 반환한다.
			int cnt = session.update("memberTest.deleteMember", "d001");

			if (cnt > 0) {
				System.out.println("delete 성공");
				session.commit();// 오토커밋을 풀어놔서 직접 커밋 해줘야한다.
			} else {
				System.out.println("delete 실패!!");

			}

		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}

		System.out.println("---------------------------------------------");

		// 2-4. select 연습
		// 1)응답 결과가 여러개인 경우
		System.out.println("select 연습(~응답 결과가 여러개인 경우~) 시작!");// 여러개인경우는 리턴값이 List 한개인경우는 object

		// 응답 결과가 여러개일 경우에는 selectList 메서드를 사용한다.
		// 이 메서드는 여러개의 레코드를 VO에 담은 후 이 VO객체를 List에 추가해 주는 각업을 자동으로 수행한다.

		session = sessionFactory.openSession();// 괄호 비어있으면 디폴드값이 false
		try {
			List<MemberVO> memList = session.selectList("memberTest.selectAllMember");

			for (MemberVO mv : memList) {
				System.out.println("I D : " + mv.getMemId());
				System.out.println("이  름 : " + mv.getMemName());
				System.out.println("전화번호 : " + mv.getMemTel());
				System.out.println("주  소 : " + mv.getMemAddr());
				System.out.println("===============================");
			}
			System.out.println("출력 끝~~~");

		} finally {
			session.close();
			// select는 트렌젝션관리를 해줄 필요가 없다.(커밋 필요없음)
		}

		// 2) 응답이 1개인 경우
		System.out.println("select 연습 시작 (결과가 1개인 경우)");

		session = sessionFactory.openSession();
		// 응답 결과가 1개가 확실한 경우에는 selectOne() 메서드 이용한다.
		try {
			MemberVO mv3 = session.selectOne("memberTest.getMember", "a121");
			System.out.println("I D : " + mv3.getMemId());
			System.out.println("이  름 : " + mv3.getMemName());
			System.out.println("전화번호 : " + mv3.getMemTel());
			System.out.println("주  소 : " + mv3.getMemAddr());
			System.out.println("출력 끝!!!!");

		} finally {
			session.close();
		}

		System.out.println("select 연습 시작 (결과가 1개인 경우)");

		session = sessionFactory.openSession();
		// 응답 결과가 1개가 확실한 경우에는 selectOne() 메서드 이용한다.
		try {
			int cnt = session.selectOne("memberTest.checkMember", "a003");

			if (cnt > 0) {
				System.out.println("회원 존재");
			} else {
				System.out.println("회원 없음");
			}
			System.out.println("==========================");
		} finally {
			session.close();
		}

	}
}
