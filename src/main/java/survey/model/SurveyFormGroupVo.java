package survey.model;

public class SurveyFormGroupVo {
    private long surveyFormGroupNo;
    private String cateName;
    private String regDate;
    
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
}
