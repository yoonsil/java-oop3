package com.bitcamp.domains;

public class MemberBean {
	private String id, pw, name, ssn, blood;
	private double height, weight;
	
	public void setId(String id) {
		this.id = id;
	}
	public String getId() {
		return id;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getPw() {
		return pw;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setSsn(String ssn) {
		this.ssn=ssn;
	}
	public String getSsn() {
		return ssn;
	}
	public void setBlood(String blood) {
		this.blood = blood;
	}
	public String getBlood() {
		return blood;
	}
	//------------------------------
	public void setHeight(double height) {
		this.height= height;
	}
	public double getHeight() {
		return height;
	}
	public void setWeight(double weight) {
		this.weight= weight;
	}
	public double getWeight() {
		return weight;
	}
	
	@Override
	public String toString() {
		return String.format("1.아이디:%s\n"
				+ "2.비밀번호:%s\n"
				+ "3.이름:%s\n"
				+ "4.주민번호앞자리:%s\n"
				+ "5.혈액형:%s형\n"
				+ "6.키:%.1fcm\n"
				+ "7.몸무게:%.1fkg\n"
				+ "---------------\n", id, pw, name, ssn, blood, height, weight);
	}
	
}
