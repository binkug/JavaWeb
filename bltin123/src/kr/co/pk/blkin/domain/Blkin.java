package kr.co.pk.blkin.domain;

import java.sql.Date;

public class Blkin {
	private int member_num;
	private String member_email;
	private String member_password;
	private String member_gender;
	private String member_name;
	private Float member_kg;
	private Date member_birthday;
	private String member_image;
	private String islogin;
	private Date logindate;
	private String isremove;
	
	
	
	//매개변수가 없는 생성자
	public Blkin() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//매개변수가 있는 생성자
	//이미 데이터가 존재하는 경우 set을 호출하지 않고 한번에 초기화 할 목적으로 생성
	public Blkin(int member_num, String member_email, String member_password, String member_gender, String member_name,
			Float member_kg, Date member_birthday, String member_image, String islogin, Date logindate,
			String isremove) {
		super();
		this.member_num = member_num;
		this.member_email = member_email;
		this.member_password = member_password;
		this.member_gender = member_gender;
		this.member_name = member_name;
		this.member_kg = member_kg;
		this.member_birthday = member_birthday;
		this.member_image = member_image;
		this.islogin = islogin;
		this.logindate = logindate;
		this.isremove = isremove;
	}
	
	public int getMember_num() {
		return member_num;
	}
	public void setMember_num(int member_num) {
		this.member_num = member_num;
	}
	public String getMember_email() {
		return member_email;
	}
	public void setMember_email(String member_email) {
		this.member_email = member_email;
	}
	public String getMember_password() {
		return member_password;
	}
	public void setMember_password(String member_password) {
		this.member_password = member_password;
	}
	public String getMember_gender() {
		return member_gender;
	}
	public void setMember_gender(String member_gender) {
		this.member_gender = member_gender;
	}
	public String getMember_name() {
		return member_name;
	}
	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}
	public Float getMember_kg() {
		return member_kg;
	}
	public void setMember_kg(Float member_kg) {
		this.member_kg = member_kg;
	}
	public Date getMember_birthday() {
		return member_birthday;
	}
	public void setMember_birthday(Date member_birthday) {
		this.member_birthday = member_birthday;
	}
	public String getMember_image() {
		return member_image;
	}
	public void setMember_image(String member_image) {
		this.member_image = member_image;
	}
	public String getIslogin() {
		return islogin;
	}
	public void setIslogin(String islogin) {
		this.islogin = islogin;
	}
	public Date getLogindate() {
		return logindate;
	}
	public void setLogindate(Date logindate) {
		this.logindate = logindate;
	}
	public String getIsremove() {
		return isremove;
	}
	public void setIsremove(String isremove) {
		this.isremove = isremove;
	}
	
	
	@Override
	public String toString() {
		return "Blkin [member_num=" + member_num + ", member_email=" + member_email + ", member_password="
				+ member_password + ", member_gender=" + member_gender + ", member_name=" + member_name + ", member_kg="
				+ member_kg + ", member_birthday=" + member_birthday + ", member_image=" + member_image + ", islogin="
				+ islogin + ", logindate=" + logindate + ", isremove=" + isremove + "]";
	}
	
}
