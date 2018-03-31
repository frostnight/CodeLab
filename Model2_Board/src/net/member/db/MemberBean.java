package net.member.db;

public class MemberBean {

	private String MEMBER_ID;
	private String MEMBER_PW;
	private String MEMBER_NAME;
	private int MEMBER_AGE;
	private String MEMBER_GENDER;
	private String MEMBER_EMAIL;
	
	public String getMEMBER_ID() {
		return MEMBER_ID;
	}
	public void setMEMBER_ID(String MEMBER_ID) {
		this.MEMBER_ID = MEMBER_ID;
	}
	public String getMEMBER_PW() {
		return MEMBER_PW;
	}
	public void setMEMBER_PW(String MEMBER_PW) {
		this.MEMBER_PW = MEMBER_PW;
	}
	public String getMEMBER_NAME() {
		return MEMBER_NAME;
	}
	public void setMEMBER_NAME(String MEMBER_NAME) {
		this.MEMBER_NAME = MEMBER_NAME;
	}
	public int getMEMBER_AGE() {
		return MEMBER_AGE;
	}
	public void setMEMBER_AGE(int MEMBER_AGE) {
		this.MEMBER_AGE = MEMBER_AGE;
	}
	public String getMEMBER_GENDER() {
		return MEMBER_GENDER;
	}
	public void setMEMBER_GENDER(String MEMBER_GENDER) {
		this.MEMBER_GENDER = MEMBER_GENDER;
	}
	public String getMEMBER_EMAIL() {
		return MEMBER_EMAIL;
	}
	public void setMEMBER_EMAIL(String MEMBER_EMAIL) {
		this.MEMBER_EMAIL = MEMBER_EMAIL;
	}
	@Override
	public String toString() {
		return "MemberBean [MEMBER_ID=" + MEMBER_ID + ", MEMBER_PW=" + MEMBER_PW + ", MEMBER_NAME=" + MEMBER_NAME
				+ ", MEMBER_AGE=" + MEMBER_AGE + ", MEMBER_GENDER=" + MEMBER_GENDER + ", MEMBER_EMAIL=" + MEMBER_EMAIL
				+ "]";
	}
	
}
