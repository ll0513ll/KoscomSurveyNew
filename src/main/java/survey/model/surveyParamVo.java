package survey.model;

import java.util.Arrays;

public class surveyParamVo {
	private int surveyNo;
	private int cateNo;
	private int companyNo;
	private int quesFormGroupNo;
	private int[] quesNo;
	private String cateName;
	private String manager;
	private String companyName;
	private String surveyDate;
	private int[] type;
	private String[] quesName;
	private int satisVal;
	private String[] dissatisReason;
	private String[] answer;
	private int[] multipleVal;
	
	
	public surveyParamVo() {
		super();
	}
	
	
	public surveyParamVo(int surveyNo, int cateNo, int companyNo, int quesFormGroupNo, int[] quesNo, String cateName,
			String manager, String companyName, String surveyDate, int[] type, String[] quesName, int satisVal,
			String[] dissatisReason, String[] answer, int[] multipleVal) {
		super();
		this.surveyNo = surveyNo;
		this.cateNo = cateNo;
		this.companyNo = companyNo;
		this.quesFormGroupNo = quesFormGroupNo;
		this.quesNo = quesNo;
		this.cateName = cateName;
		this.manager = manager;
		this.companyName = companyName;
		this.surveyDate = surveyDate;
		this.type = type;
		this.quesName = quesName;
		this.satisVal = satisVal;
		this.dissatisReason = dissatisReason;
		this.answer = answer;
		this.multipleVal = multipleVal;
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


	public int[] getQuesNo() {
		return quesNo;
	}
	public void setQuesNo(int[] quesNo) {
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
	public int[] getType() {
		return type;
	}
	public void setType(int[] type) {
		this.type = type;
	}
	public String[] getQuesName() {
		return quesName;
	}
	public void setQuesName(String[] quesName) {
		this.quesName = quesName;
	}
	public int getSatisVal() {
		return satisVal;
	}
	public void setSatisVal(int satisVal) {
		this.satisVal = satisVal;
	}
	public String[] getDissatisReason() {
		return dissatisReason;
	}
	public void setDissatisReason(String[] dissatisReason) {
		this.dissatisReason = dissatisReason;
	}
	public String[] getAnswer() {
		return answer;
	}
	public void setAnswer(String[] answer) {
		this.answer = answer;
	}
	public int[] getMultipleVal() {
		return multipleVal;
	}
	public void setMultipleVal(int[] multipleVal) {
		this.multipleVal = multipleVal;
	}


	@Override
	public String toString() {
		return "surveyParamVo [surveyNo=" + surveyNo + ", cateNo=" + cateNo + ", companyNo=" + companyNo
				+ ", quesFormGroupNo=" + quesFormGroupNo + ", quesNo=" + Arrays.toString(quesNo) + ", cateName="
				+ cateName + ", manager=" + manager + ", companyName=" + companyName + ", surveyDate=" + surveyDate
				+ ", type=" + Arrays.toString(type) + ", quesName=" + Arrays.toString(quesName) + ", satisVal="
				+ satisVal + ", dissatisReason=" + Arrays.toString(dissatisReason) + ", answer="
				+ Arrays.toString(answer) + ", multipleVal=" + Arrays.toString(multipleVal) + "]";
	}
	
	
}
