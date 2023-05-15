package kr.or.ddit.basic;

import java.io.*;

public class T15ObjectStreamTest {
	public static void main(String[] args) {
		Member mem1 = new Member("홍길동", 20, "대전");
		Member mem2 = new Member("일지매", 30, "경기");
		Member mem3 = new Member("이몽룡", 40, "광주");
		Member mem4 = new Member("성춘향", 50, "제주");

		ObjectOutputStream oss = null;

		try {
			// 객체를 파일에 저장하기
			oss = new ObjectOutputStream(
					new BufferedOutputStream(
							new FileOutputStream("d:/D_Other/memObj.bin ")));

			// 쓰기 작업
			oss.writeObject(mem1); // 직렬화
			oss.writeObject(mem2);
			oss.writeObject(mem3);
			oss.writeObject(mem4);

			System.out.println("쓰기 작업 완료");

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				oss.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		//////////////////////////////////////////////////////////////////////////////////////////////
		ObjectInputStream ois = null;

		try {
			// 객체 로딩용 스트림 객체 생성
			ois = new ObjectInputStream(
						new BufferedInputStream(
							new FileInputStream("d:/D_Other/memObj.bin")));

			Object obj = null;

			while ((obj = ois.readObject()) != null) { // 역직렬화
				// 파일의 마지막에 다다르면 EOF Exception 발생
				Member mem = (Member) obj;
				System.out.println("이름: " + mem.getName());
				System.out.println("나이: " + mem.getAge());
				System.out.println("주소: " + mem.getAddr());
				System.out.println("----------------------------------");
			}
		} catch (IOException e) {
			// e.printStackTrace();
			System.out.println("읽기작업 완료!!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}

/*
 * 회원정보를 담기 위한 VO클래스
 * 
 */
class Member implements Serializable {
	// 자바는 Serializable 인터페이스를 구현한 클래스만 직렬화 할 수 있도록 제한하고 있음
	
	//transient =>직렬화가 되지않을 멤버변수에 지정한다.(static필드도 직렬화 대상에서 제외됨)
	//			=>직렬화 대상이 아닌 멤버 변수는 기본값으로 저장된다.(참조형 변수: null; 숫자형변수: 0)

	transient private String name;
	transient private int age;
	private String addr;

	public Member(String name, int age, String addr) {
		super();
		this.name = name;
		this.age = age;
		this.addr = addr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

}