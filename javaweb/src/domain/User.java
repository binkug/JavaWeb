package domain;

import java.sql.Date;

public class User {
	private int userNum;
	private String userEmail;
	private String userPassword;
	private String userName;
	private String userGender;
	private Float userKg;
	private Date userBirthday;
	private String userImage;
	private int isLogin;
	private int isRemove;
	private Date logindate;
	private Date joinDate;
	private int isEmail;
	

	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	//매개변수가 있는 생성자
	//이미 데이터가 존재하는 경우 set을 호출하지 않고 한번에 초기화 할 목적으로 생성
	public User(int userNum, String userEmail, String userPassword, String userName, String userGender, Float userKg,
			Date userBirthday, String userImage, int isLogin, int isRemove, Date logindate, Date joinDate,
			int isEmail) {
		super();
		this.userNum = userNum;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userName = userName;
		this.userGender = userGender;
		this.userKg = userKg;
		this.userBirthday = userBirthday;
		this.userImage = userImage;
		this.isLogin = isLogin;
		this.isRemove = isRemove;
		this.logindate = logindate;
		this.joinDate = joinDate;
		this.isEmail = isEmail;
	}



	public int getUserNum() {
		return userNum;
	}
	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserGender() {
		return userGender;
	}
	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}
	public Float getUserKg() {
		return userKg;
	}
	public void setUserKg(Float userKg) {
		this.userKg = userKg;
	}
	public Date getUserBirthday() {
		return userBirthday;
	}
	public void setUserBirthday(Date userBirthday) {
		this.userBirthday = userBirthday;
	}
	public String getUserImage() {
		return userImage;
	}
	public void setUserImage(String userImage) {
		this.userImage = userImage;
	}
	public int getIsLogin() {
		return isLogin;
	}
	public void setIsLogin(int isLogin) {
		this.isLogin = isLogin;
	}
	public int getIsRemove() {
		return isRemove;
	}
	public void setIsRemove(int isRemove) {
		this.isRemove = isRemove;
	}
	public Date getLogindate() {
		return logindate;
	}
	public void setLogindate(Date logindate) {
		this.logindate = logindate;
	}
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	public int getIsEmail() {
		return isEmail;
	}
	public void setIsEmail(int isEmail) {
		this.isEmail = isEmail;
	}
	@Override
	public String toString() {
		return "User [userNum=" + userNum + ", userEmail=" + userEmail + ", userPassword=" + userPassword
				+ ", userName=" + userName + ", userGender=" + userGender + ", userKg=" + userKg + ", userBirthday="
				+ userBirthday + ", userImage=" + userImage + ", isLogin=" + isLogin + ", isRemove=" + isRemove
				+ ", logindate=" + logindate + ", joinDate=" + joinDate + ", isEmail=" + isEmail + "]";
	}
	
	

	
	
	
}
