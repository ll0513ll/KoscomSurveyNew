package survey.model;

public class SurveyFormVo {
    private long surveyFormNo;
    private long surveyFormGroupNo;
    private String quesName;
    private int type;
    private int order;
    
	public long getSurveyFormNo() {
		return surveyFormNo;
	}
	public void setSurveyFormNo(long surveyFormNo) {
		this.surveyFormNo = surveyFormNo;
	}
	public long getSurveyFormGroupNo() {
		return surveyFormGroupNo;
	}
	public void setSurveyFormGroupNo(long surveyFormGroupNo) {
		this.surveyFormGroupNo = surveyFormGroupNo;
	}
	public String getQuesName() {
		return quesName;
	}
	public void setQuesName(String quesName) {
		this.quesName = quesName;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}
	
}