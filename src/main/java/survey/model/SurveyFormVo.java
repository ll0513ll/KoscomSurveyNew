package survey.model;

public class SurveyFormVo {
    private long surveyFormNo;
    private long surveyFormGroupNo;
    private String quesName;
    private int type;
    private int orderNo;
    
    
	public SurveyFormVo() {
		super();
	}

	public SurveyFormVo(long surveyFormNo, long surveyFormGroupNo, String quesName, int type, int orderNo) {
		super();
		this.surveyFormNo = surveyFormNo;
		this.surveyFormGroupNo = surveyFormGroupNo;
		this.quesName = quesName;
		this.type = type;
		this.orderNo = orderNo;
	}
	
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
	public int getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	@Override
	public String toString() {
		return "SurveyFormVo [surveyFormNo=" + surveyFormNo + ", surveyFormGroupNo=" + surveyFormGroupNo + ", quesName="
				+ quesName + ", type=" + type + ", orderNo=" + orderNo + "]";
	}
	
	
}