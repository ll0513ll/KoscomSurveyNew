package survey.model;

public class SurveyFormGroupVo {
    private long surveyFormGroupNo;
    private String cateName;
    private String regDate;
    private String startDate;
    private String endDate;
    
    
	public SurveyFormGroupVo() {
		super();
	}
	
	public SurveyFormGroupVo(long surveyFormGroupNo, String cateName, String regDate, String startDate,
			String endDate) {
		super();
		this.surveyFormGroupNo = surveyFormGroupNo;
		this.cateName = cateName;
		this.regDate = regDate;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public long getSurveyFormGroupNo() {
		return surveyFormGroupNo;
	}
	public void setSurveyFormGroupNo(long surveyFormGroupNo) {
		this.surveyFormGroupNo = surveyFormGroupNo;
	}
	public String getCateName() {
		return cateName;
	}
	public void setCateName(String cateName) {
		this.cateName = cateName;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "SurveyFormGroupVo [surveyFormGroupNo=" + surveyFormGroupNo + ", cateName=" + cateName + ", regDate="
				+ regDate + ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}
	
}
