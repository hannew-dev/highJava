package kr.or.ddit.Member.vo;

import java.sql.Date;

/**
	 * 회원정보를 담기 위한 VO클래스
	 * @author PC-04
	 *
	 */
public class MemberVO {
	private String memId;
	private String memName;
	private String memTel;
	private String memAddr;
	private Date regDate;
	
	public MemberVO() {
		
	}
	
	public MemberVO(String memId, String memName, String memTel, String memAddr ,Date regDate) {
		super();
		this.memId = memId;
		this.memName = memName;
		this.memTel = memTel;
		this.memAddr = memAddr;
		this.regDate = regDate;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getMemName() {
		return memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}

	public String getMemTel() {
		return memTel;
	}

	public void setMemTel(String memTel) {
		this.memTel = memTel;
	}

	public String getMemAddr() {
		return memAddr;
	}

	public void setMemAddr(String memAddr) {
		this.memAddr = memAddr;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "MemberVO [memId=" + memId + ", memName=" + memName + ", memTel=" + memTel + ", memAddr=" + memAddr
				+ ", regDate=" + regDate + "]";
	}
	
	
	
}
