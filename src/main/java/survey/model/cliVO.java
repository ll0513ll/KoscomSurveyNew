package survey.model;


public class cliVO {
	
	private int cliNo;
	private int companyNo;
	private String companyName;
	private String cliName;
	private String id;
	private String password;
	
	
	public cliVO() {
		super();
	}


	public cliVO(int cliNo, int companyNo, String companyName, String cliName, String id, String password) {
		super();
		this.cliNo = cliNo;
		this.companyNo = companyNo;
		this.companyName = companyName;
		this.cliName = cliName;
		this.id = id;
		this.password = password;
	}


	public int getCliNo() {
		return cliNo;
	}


	public void setCliNo(int cliNo) {
		this.cliNo = cliNo;
	}


	public int getCompanyNo() {
		return companyNo;
	}


	public void setCompanyNo(int companyNo) {
		this.companyNo = companyNo;
	}


	public String getCompanyName() {
		return companyName;
	}


	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}


	public String getCliName() {
		return cliName;
	}


	public void setCliName(String cliName) {
		this.cliName = cliName;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "cliVO [cliNo=" + cliNo + ", companyNo=" + companyNo + ", companyName=" + companyName + ", cliName="
				+ cliName + ", id=" + id + ", password=" + password + "]";
	}


	
	
}