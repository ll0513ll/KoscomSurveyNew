package survey.model;

public class surveyVO {

		private int surveyNo;
		private int cateNo;
		private int companyNo;
		private int quesNo;
		private String manager;
		private String surveyDate;
		private int type;
		private int satisVal;
		private String dissatisReason;
		private String answer;
		

		
		public surveyVO() {
			super();
		}
		public surveyVO(int surveyNo, int cateNo, int companyNo, int quesNo, String manager,
				String surveyDate, int type, int satisVal, String dissatisReason, String answer) {
			super();
			this.surveyNo = surveyNo;
			this.cateNo = cateNo;
			this.companyNo = companyNo;
			this.quesNo = quesNo;
			this.manager = manager;
			this.surveyDate = surveyDate;
			this.type = type;
			this.satisVal = satisVal;
			this.dissatisReason = dissatisReason;
			this.answer = answer;
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
		public int getQuesNo() {
			return quesNo;
		}
		public void setQuesNo(int quesNo) {
			this.quesNo = quesNo;
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
		
		@Override
		public String toString() {
			return "surveyVO [surveyNo=" + surveyNo + ", cateNo=" + cateNo + ", companyNo=" + companyNo + ", quesNo="
					+ quesNo + ", manager=" + manager + ", surveyDate=" + surveyDate + ", type=" + type + ", satisVal="
					+ satisVal + ", dissatisReason=" + dissatisReason + ", answer=" + answer + "]";
		}
		
		
		
}
