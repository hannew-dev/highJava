package kr.or.ddit.Member.main;

import java.util.List;
import java.util.Scanner;

import kr.or.ddit.Member.service.IMemberService;
import kr.or.ddit.Member.service.MemberServiceImp;
import kr.or.ddit.Member.vo.MemberVO;

/*
	회원정보를 관리하는 프로그램을 작성하는데 
	아래의 메뉴를 모두 구현하시오. (CRUD기능 구현하기)
	(DB의 MYMEMBER테이블을 이용하여 작업한다.)
	
	* 자료 삭제는 회원ID를 입력 받아서 삭제한다.
	
	예시메뉴)
	----------------------
		== 작업 선택 ==
		1. 자료 입력			---> insert
		2. 자료 삭제			---> delete
		3. 자료 수정			---> update
		4. 전체 자료 출력	---> select
		5. 작업 끝.
	----------------------
	 
	   
// 회원관리 프로그램 테이블 생성 스크립트 
create table mymember(
    mem_id varchar2(8) not null,  -- 회원ID
    mem_name varchar2(100) not null, -- 이름
    mem_tel varchar2(50) not null, -- 전화번호
    mem_addr varchar2(128),    -- 주소
    reg_dt DATE DEFAULT sysdate, -- 등록일
    CONSTRAINT MYMEMBER_PK PRIMARY KEY (mem_id)
);

*/
public class MemberMain {

	private Scanner scan = new Scanner(System.in);

	private IMemberService memService;

	public MemberMain() {

		memService = new MemberServiceImp();

	}

	/**
	 * 메뉴를 출력하는 메서드
	 */
	public void displayMenu() {
		System.out.println();
		System.out.println("----------------------------------------------------");
		System.out.println("  === 작 업 선 택 ===");
		System.out.println("  1. 자료 입력");
		System.out.println("  2. 자료 삭제");
		System.out.println("  3. 자료 수정");
		System.out.println("  4. 전체 자료 출력");
		System.out.println("  5. 자료검색");
		System.out.println("  6. 작업 끝.");
		System.out.println("----------------------------------------------------");
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
			case 1: // 자료 입력
				insertMember();

				break;
			case 2: // 자료 삭제
				deleteMember();
				break;
			case 3: // 자료 수정
				updateMember();
				break;
			case 4: // 전체 자료 출력
				selectAllMember();
				break;
			case 5: // 자료검색
				saerchMember();
				break;
			case 6: // 작업 끝
				System.out.println("작업을 마칩니다.");
				break;
			default:
				System.out.println("번호를 잘못 입력했습니다. 다시입력하세요");
			}
		} while (choice != 6);
	}

	/**
	 * 회원정보 전체 조회 하기위한 메서드
	 */
	private void selectAllMember() {

		System.out.println();
		System.out.println("----------------------------------------------------");
		System.out.println(" ID \t 이   름 \t전화번호 \t\t주   소");
		System.out.println("----------------------------------------------------");

		List<MemberVO> memList = memService.listAllMember();

		if (memList.size() == 0) {
			System.out.println("회원정보가 존재하지 않습니다.");
		} else {

			for (MemberVO mv : memList) {

				System.out.println(
						" " + mv.getMemId() + "\t" + mv.getMemName() + "\t" + mv.getMemTel() + "\t" + mv.getMemAddr());
			}

		}

	}

	/**
	 * 회원정보를 삭제하기 위한 메서드
	 */
	private void deleteMember() {
		System.out.println();
		System.out.println("삭제할 회원 정보를 입력해 주세요.");
		System.out.print("회원ID >>");

		String memId = scan.next();

		int cnt = memService.removeMember(memId);

		if (cnt > 0) {
			System.out.println(memId + "회원 탈퇴 작업 성공!");
		} else {
			System.out.println(memId + "회원 탈퇴 작업 실패!!");
		}

	}

	/**
	 * 회원정보를 수정하기 위한 메서드
	 */
	private void updateMember() {

		boolean isExist = false;

		String memId = "";

		do {
			System.out.println();
			System.out.println("수정할 회원 정보를 입력해 주세요.");
			System.out.print("회원ID >>");

			memId = scan.next();

			isExist = memService.checkMember(memId);// 아이디를 확인해서 DB에 있나 확인

			if (!isExist) {
				System.out.println("회원 아이디가 " + memId + "인 회원은 존재하지 않습니다.");
				System.out.println("다시 입력해주세요");
			}

		} while (!isExist);

		System.out.print("회원이름 >> ");
		String memName = scan.next();

		System.out.print("회원 전화번호 >> ");
		String memTel = scan.next();

		scan.nextLine();// 버퍼지우기 엔터키 제거용

		System.out.print("회원주소 >> ");
		String memAddr = scan.nextLine();

		MemberVO mv = new MemberVO();
		mv.setMemId(memId);
		mv.setMemName(memName);
		mv.setMemTel(memTel);
		mv.setMemAddr(memAddr);

		int cnt = memService.modifyMember(mv);

		if (cnt > 0) {
			System.out.println(memId + "회원 수정 작업 성공!");
		} else {
			System.out.println(memId + "회원 수정 작업 실패!!");
		}

	}

	/**
	 * 회원정보를 추가하기 위한 메서드
	 */
	private void insertMember() {
		boolean isExist = false;

		String memId = "";

		do {
			System.out.println();
			System.out.println("추가할 회원 정보를 입력해 주세요.");
			System.out.print("회원ID >>");

			memId = scan.next();

			isExist = memService.checkMember(memId);// 아이디를 확인해서 DB에 있나 확인

			if (isExist) {
				System.out.println("회원 아이디가 " + memId + "인 회원은 이미 존재합니다");
				System.out.println("다시 입력해주세요");
			}

		} while (isExist);

		System.out.print("회원이름 >> ");
		String memName = scan.next();

		System.out.print("회원 전화번호 >> ");
		String memTel = scan.next();

		scan.nextLine();

		System.out.print("회원주소 >> ");
		String memAddr = scan.nextLine();

		MemberVO mv = new MemberVO();
		mv.setMemId(memId);
		mv.setMemName(memName);
		mv.setMemTel(memTel);
		mv.setMemAddr(memAddr);

		int cnt = memService.resistMember(mv);

		if (cnt > 0) {
			System.out.println(memId + "회원 추가 작업 성공!");
		} else {
			System.out.println(memId + "회원 추가 작업 실패!!");
		}

	}

	/**
	 * 회원정보를 검색하는 메서드
	 */
	public void saerchMember() {
		// 검색할 회원 ID, 회원이름, 전화번호, 주소 등을 입력하면
		// 입력한 정보만 사용하여 검색하는 기능을 구현하시오.
		// 주소는 입력한 값이 포함만 되어도 검색되도록 한다.
		// 입력을 하지 않을 경우에는 엔터키를 입력하여 다음이력으로 넘긴다.
		scan.nextLine();// 버퍼비우기

		System.out.println();
		System.out.println("검색할 정보를 입력하세요.");
		System.out.print("회원ID>> ");

		String memId = scan.nextLine().trim();

		System.out.print("회원이름>> ");

		String memName = scan.nextLine().trim();

		System.out.print("회원전화번호>> ");

		String memTel = scan.nextLine().trim();

		System.out.print("회원주소>> ");

		String memAddr = scan.nextLine().trim();

		MemberVO mv = new MemberVO();
		mv.setMemId(memId);
		mv.setMemName(memName);
		mv.setMemTel(memTel);
		mv.setMemAddr(memAddr);

		List<MemberVO> memList = memService.searchMember(mv);
		
		System.out.println();
		System.out.println("----------------------------------------------------");
		System.out.println(" ID \t 이   름 \t전화번호 \t\t주   소");
		System.out.println("----------------------------------------------------");


		if (memList.size() == 0) {
			System.out.println("회원정보가 존재하지 않습니다.");
		} else {

			for (MemberVO mv2 : memList) {

				System.out.println(" " + mv2.getMemId() + "\t" + mv2.getMemName() + "\t" + mv2.getMemTel() + "\t"
						+ mv2.getMemAddr());
			}
		}

	}

	public static void main(String[] args) {
		MemberMain memObj = new MemberMain();
		memObj.start();
	}

}