package survey.model;


public class userVO {
	
	private int userNo;
	
	private String userName;
	
	private String email;
	
	private String password;
	
	private String department;
	
	private String telephone;

	public userVO() {

	}

	public userVO(int userNo, String userName, String email, String password, String department, String telephone) {
		super();
		this.userNo = userNo;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.department = department;
		this.telephone = telephone;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Override
	public String toString() {
		return "userVO [userNo=" + userNo + ", userName=" + userName + ", email=" + email + ", password=" + password
				+ ", department=" + department + ", telephone=" + telephone + "]";
	}
	
}
