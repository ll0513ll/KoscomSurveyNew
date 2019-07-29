package survey.model;


public class companyVO {

	
	private int companyNo;
	
	private String companyName;
	
	private String manager;
	

	public companyVO() {
	
	}


	public companyVO(int companyNo, String companyName, String manager) {
		super();
		this.companyNo = companyNo;
		this.companyName = companyName;
		this.manager = manager;
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


	public String getManager() {
		return manager;
	}


	public void setManager(String manager) {
		this.manager = manager;
	}


	@Override
	public String toString() {
		return "companyVO [companyNo=" + companyNo + ", companyName=" + companyName + ", manager=" + manager + "]";
	}

}
