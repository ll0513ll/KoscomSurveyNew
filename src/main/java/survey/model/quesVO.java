package survey.model;

public class quesVO {
	
	private int quesNo;
	private int cateNo;
	private int companyNo;
	private int type;
	private String quesName;
	
	public quesVO() {

	}

	public quesVO(int quesNo, int cateNo, int companyNo, int type, String quesName) {
		super();
		this.quesNo = quesNo;
		this.cateNo = cateNo;
		this.companyNo = companyNo;
		this.type = type;
		this.quesName = quesName;
	}

	public int getQuesNo() {
		return quesNo;
	}

	public void setQuesNo(int quesNo) {
		this.quesNo = quesNo;
	}

	public int getCateNo() {
		return cateNo;
	}

	public void setCateNo(int cateNo) {
		this.cateNo = cateNo;
	}

	public int getCompanyNo() {
		return companyNo;
	}

	public void setCompanyNo(int companyNo) {
		this.companyNo = companyNo;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getQuesName() {
		return quesName;
	}

	public void setQuesName(String quesName) {
		this.quesName = quesName;
	}

	@Override
	public String toString() {
		return "quesVO [quesNo=" + quesNo + ", cateNo=" + cateNo + ", companyNo=" + companyNo + ", type=" + type
				+ ", quesName=" + quesName + "]";
	}

}
