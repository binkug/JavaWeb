package domain;

import java.sql.Date;

public class Blkin {
	//클라이언트용 프로그램이면 속성 앞의 접근 지장자를 public으로 하고
	//생성자만 만들고 접근자 메소드는 만들지 않아도 됩니다.
	private int member_num;
	private String member_email;
	private String member_password;
	private String member_gender;
	private String member_name;
	private Float member_kg;
	private Date member_birthday;
	private String member_image;
	private String member_content;
	private String islogin;
	private Date logindate;
	private String isremove;
	
	
	
	public Blkin() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Blkin(int member_num, String member_email, String member_password, String member_gender, String member_name,
			Float member_kg, Date member_birthday, String member_image, String member_content, String islogin,
			Date logindate, String isremove) {
		super();
		this.member_num = member_num;
		this.member_email = member_email;
		this.member_password = member_password;
		this.member_gender = member_gender;
		this.member_name = member_name;
		this.member_kg = member_kg;
		this.member_birthday = member_birthday;
		this.member_image = member_image;
		this.member_content = member_content;
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
	public String getMember_content() {
		return member_content;
	}
	public void setMember_content(String member_content) {
		this.member_content = member_content;
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
				+ member_kg + ", member_birthday=" + member_birthday + ", member_image=" + member_image
				+ ", member_content=" + member_content + ", islogin=" + islogin + ", logindate=" + logindate
				+ ", isremove=" + isremove + "]";
	}
	
	
}
