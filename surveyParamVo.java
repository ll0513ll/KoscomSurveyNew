package survey.model;

import java.util.Arrays;
import java.util.List;

public class surveyParamVo {
	private int surveyNo;
	private int cateNo;
	private int companyNo;
	private int quesFormGroupNo;
	private List<Integer> quesNo;
	private String cateName;
	private String manager;
	private String companyName;
	private String surveyDate;
	private List<Integer> type;
	private List<String> quesName;
	private int satisVal;
	private List<String> dissatisReason;
	private List<String> answer;
	private List<Integer> multipleVal;
	
	
	public surveyParamVo() {
		super();
	}


	public int getSurveyNo() {
		return surveyNo;
	}

	public void setSurveyNo(int surveyNo) {
		this.surveyNo = surveyNo;
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

	public int getQuesFormGroupNo() {
		return quesFormGroupNo;
	}

	public void setQuesFormGroupNo(int quesFormGroupNo) {
		this.quesFormGroupNo = quesFormGroupNo;
	}

	public List<Integer> getQuesNo() {
		return quesNo;
	}

	public void setQuesNo(List<Integer> quesNo) {
		this.quesNo = quesNo;
	}

	public String getCateName() {
		return cateName;
	}

	public void setCateName(String cateName) {
		this.cateName = cateName;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getSurveyDate() {
		return surveyDate;
	}

	public void setSurveyDate(String surveyDate) {
		this.surveyDate = surveyDate;
	}

	public List<Integer> getType() {
		return type;
	}

	public void setType(List<Integer> type) {
		this.type = type;
	}

	public List<String> getQuesName() {
		return quesName;
	}

	public void setQuesName(List<String> quesName) {
		this.quesName = quesName;
	}

	public int getSatisVal() {
		return satisVal;
	}

	public void setSatisVal(int satisVal) {
		this.satisVal = satisVal;
	}

	public List<String> getDissatisReason() {
		return dissatisReason;
	}

	public void setDissatisReason(List<String> dissatisReason) {
		this.dissatisReason = dissatisReason;
	}

	public List<String> getAnswer() {
		return answer;
	}

	public void setAnswer(List<String> answer) {
		this.answer = answer;
	}

	public List<Integer> getMultipleVal() {
		return multipleVal;
	}

	public void setMultipleVal(List<Integer> multipleVal) {
		this.multipleVal = multipleVal;
	}

	@Override
	public String toString() {
		return "surveyParamVo{" +
				"surveyNo=" + surveyNo +
				", cateNo=" + cateNo +
				", companyNo=" + companyNo +
				", quesFormGroupNo=" + quesFormGroupNo +
				", quesNo=" + quesNo +
				", cateName='" + cateName + '\'' +
				", manager='" + manager + '\'' +
				", companyName='" + companyName + '\'' +
				", surveyDate='" + surveyDate + '\'' +
				", type=" + type +
				", quesName=" + quesName +
				", satisVal=" + satisVal +
				", dissatisReason=" + dissatisReason +
				", answer=" + answer +
				", multipleVal=" + multipleVal +
				'}';
	}
}
