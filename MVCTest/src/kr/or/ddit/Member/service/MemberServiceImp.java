package kr.or.ddit.Member.service;

import java.util.List;

import kr.or.ddit.Member.dao.IMemberDAO;
import kr.or.ddit.Member.dao.MemberDaoImpForJdbc;
import kr.or.ddit.Member.vo.MemberVO;

public class MemberServiceImp implements IMemberService{
	
	private IMemberDAO memDAO;
	
	public MemberServiceImp() {
		memDAO = new MemberDaoImpForJdbc();
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
