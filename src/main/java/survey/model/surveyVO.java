package survey.model;

public class surveyVO {

		private int surveyNo;
		private int companyNo;
		private int quesNo;
		private int quesFormGroupNo;
		private String quesName;
		private String cateName;
		private String manager;
		private String surveyDate;
		private int type;
		private int satisVal;
		private String dissatisReason;
		private String answer;
		private int participate;
		private long surveyFormNo;
	    private long surveyFormGroupNo;
	    private int orderNo;
		

		
		public surveyVO() {
			super();
		}



		public surveyVO(int surveyNo, int companyNo,int quesNo, int quesFormGroupNo, String quesName, String cateName,
				String manager, String surveyDate, int type, int satisVal, String dissatisReason, String answer,
				int participate, long surveyFormNo, long surveyFormGroupNo, int orderNo) {
			super();
			this.surveyNo = surveyNo;
			this.companyNo = companyNo;
			this.quesNo = quesNo;
			this.quesFormGroupNo = quesFormGroupNo;
			this.quesName = quesName;
			this.cateName = cateName;
			this.manager = manager;
			this.surveyDate = surveyDate;
			this.type = type;
			this.satisVal = satisVal;
			this.dissatisReason = dissatisReason;
			this.answer = answer;
			this.participate = participate;
			this.surveyFormNo = surveyFormNo;
			this.surveyFormGroupNo = surveyFormGroupNo;
			this.orderNo = orderNo;
		}



		public int getSurveyNo() {
			return surveyNo;
		}



		public void setSurveyNo(int surveyNo) {
			this.surveyNo = surveyNo;
		}



		public int getCompanyNo() {
			return companyNo;
		}



		public void setCompanyNo(int companyNo) {
			this.companyNo = companyNo;
		}
		
		public int getQuesNo() {
			return quesNo;
		}



		public void setQuesNo(int quesNo) {
			this.quesNo = quesNo;
		}


		public int getQuesFormGroupNo() {
			return quesFormGroupNo;
		}



		public void setQuesFormGroupNo(int quesFormGroupNo) {
			this.quesFormGroupNo = quesFormGroupNo;
		}



		public String getQuesName() {
			return quesName;
		}



		public void setQuesName(String quesName) {
			this.quesName = quesName;
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



		public String getSurveyDate() {
			return surveyDate;
		}



		public void setSurveyDate(String surveyDate) {
			this.surveyDate = surveyDate;
		}



		public int getType() {
			return type;
		}



		public void setType(int type) {
			this.type = type;
		}



		public int getSatisVal() {
			return satisVal;
		}



		public void setSatisVal(int satisVal) {
			this.satisVal = satisVal;
		}



		public String getDissatisReason() {
			return dissatisReason;
		}



		public void setDissatisReason(String dissatisReason) {
			this.dissatisReason = dissatisReason;
		}



		public String getAnswer() {
			return answer;
		}



		public void setAnswer(String answer) {
			this.answer = answer;
		}



		public int getParticipate() {
			return participate;
		}



		public void setParticipate(int participate) {
			this.participate = participate;
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



		public int getOrderNo() {
			return orderNo;
		}



		public void setOrderNo(int orderNo) {
			this.orderNo = orderNo;
		}



		@Override
		public String toString() {
			return "surveyVO [surveyNo=" + surveyNo + ", companyNo=" + companyNo + ", quesNo=" + quesNo
					+ ", quesFormGroupNo=" + quesFormGroupNo + ", quesName=" + quesName + ", cateName=" + cateName
					+ ", manager=" + manager + ", surveyDate=" + surveyDate + ", type=" + type + ", satisVal="
					+ satisVal + ", dissatisReason=" + dissatisReason + ", answer=" + answer + ", participate="
					+ participate + ", surveyFormNo=" + surveyFormNo + ", surveyFormGroupNo=" + surveyFormGroupNo
					+ ", orderNo=" + orderNo + ", getSurveyNo()=" + getSurveyNo() + ", getCompanyNo()=" + getCompanyNo()
					+ ", getQuesNo()=" + getQuesNo() + ", getQuesFormGroupNo()=" + getQuesFormGroupNo()
					+ ", getQuesName()=" + getQuesName() + ", getCateName()=" + getCateName() + ", getManager()="
					+ getManager() + ", getSurveyDate()=" + getSurveyDate() + ", getType()=" + getType()
					+ ", getSatisVal()=" + getSatisVal() + ", getDissatisReason()=" + getDissatisReason()
					+ ", getAnswer()=" + getAnswer() + ", getParticipate()=" + getParticipate() + ", getSurveyFormNo()="
					+ getSurveyFormNo() + ", getSurveyFormGroupNo()=" + getSurveyFormGroupNo() + ", getOrderNo()="
					+ getOrderNo() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
					+ super.toString() + "]";
		}



}
