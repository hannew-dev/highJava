package kr.or.ddit.Member.service;

import java.util.List;

import kr.or.ddit.Member.dao.IMemberDAO;
import kr.or.ddit.Member.dao.MemberDaoImpForJdbc;
import kr.or.ddit.Member.vo.MemberVO;

public class MemberServiceImp implements IMemberService{
	
	private static IMemberService memService; //객체변수 선언1
	
	private IMemberDAO memDAO;
	
	private MemberServiceImp() { //private으로 바꿔준다.2
		memDAO = MemberDaoImpForJdbc.getInstance();
	}
	
	public static IMemberService getInstance() {//getInstance 생성해준다
		if (memService == null) {
			memService = new MemberServiceImp();
		}
		return memService;
	}

	@Override
	public int resistMember(MemberVO mv) {
		
		
	
		//DAO를 통한 회원등록하기
		
		//할수있는것들!
		//등록한 회원에게 메일보내기
		//로그 남기기
		return memDAO.insertMember(mv);
	}

	@Override
	public boolean checkMember(String memId) {
		// TODO Auto-generated method stub
		return memDAO.checkMember(memId);
	}

	@Override
	public int modifyMember(MemberVO mv) {
		return memDAO.updateMember(mv);
	}

	@Override
	public int removeMember(String memId) {
		// TODO Auto-generated method stub
		
		return memDAO.deleteMember(memId);
	}

	@Override
	public List<MemberVO> listAllMember() {
		// TODO Auto-generated method stub
		return memDAO.selectAllMember();
	}

	@Override
	public List<MemberVO> searchMember(MemberVO mv) {
		// TODO Auto-generated method stub
		return memDAO.searchMember(mv);
	}
	
}
