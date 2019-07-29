package survey.model;


public class userVO {
	
	private int user_no;
	
	private String user_name;
	
	private String email;
	
	private String password;
	
	private String department;
	
	private String telephone;

	public userVO() {

	}

	public userVO(int user_no, String user_name, String email, String password, String department, String telephone) {
		this.user_no = user_no;
		this.user_name = user_name;
		this.email = email;
		this.password = password;
		this.department = department;
		this.telephone = telephone;
	}

	public int getUser_no() {
		return user_no;
	}

	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
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
		return "userVO [user_no=" + user_no + ", user_name=" + user_name + ", email=" + email + ", password=" + password
				+ ", department=" + department + ", telephone=" + telephone + "]";
	}
	
	
	
}
