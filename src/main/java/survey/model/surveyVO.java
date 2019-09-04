package survey.model;

public class surveyVO {

		private int surveyNo;
		private int companyNo;
		private int surveyGroupNo;
		private int quesNo;
		private int quesFormGroupNo;
		private String quesName;
		private String cateName;//설문지 제목
		private String companyName;//회사이름
		private String manager;//설문조사에 참여한 담당 직원
		private String surveyDate;//설문조사 제출한 날짜
		private int type;//객관식 주관식 타입
		private int satisVal;//객관식 선택
		private String dissatisReason;//객관식 나쁨이상 선택시 사유
		private String answer;//주관식 답변
		private int participate;//참여여부
		private int satisfaction;//만족도
		private long surveyFormNo;
	    private long surveyFormGroupNo;
	    private int orderNo;
	    private int quesCount;
		

		
		public surveyVO() {
			super();
		}



		public surveyVO(int surveyNo, int companyNo, int surveyGroupNo,int quesNo, int quesFormGroupNo, String quesName, String cateName,
				String companyName, String manager, String surveyDate, int type, int satisVal, String dissatisReason,
				String answer, int participate,int satisfaction, long surveyFormNo, long surveyFormGroupNo, int orderNo,int quesCount) {
			super();
			this.surveyNo = surveyNo;
			this.companyNo = companyNo;
			this.surveyGroupNo = surveyGroupNo;
			this.quesNo = quesNo;
			this.quesFormGroupNo = quesFormGroupNo;
			this.quesName = quesName;
			this.cateName = cateName;
			this.companyName = companyName;
			this.manager = manager;
			this.surveyDate = surveyDate;
			this.type = type;
			this.satisVal = satisVal;
			this.dissatisReason = dissatisReason;
			this.answer = answer;
			this.participate = participate;
			this.satisfaction = satisfaction;
			this.surveyFormNo = surveyFormNo;
			this.surveyFormGroupNo = surveyFormGroupNo;
			this.orderNo = orderNo;
			this.quesCount = quesCount;
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

		

		public int getSurveyGroupNo() {
			return surveyGroupNo;
		}



		public void setSurveyGroupNo(int surveyGroupNo) {
			this.surveyGroupNo = surveyGroupNo;
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



		public int getSatisfaction() {
			return satisfaction;
		}



		public void setSatisfaction(int satisfaction) {
			this.satisfaction = satisfaction;
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

		


		public int getQuesCount() {
			return quesCount;
		}



		public void setQuesCount(int quesCount) {
			this.quesCount = quesCount;
		}



		@Override
		public String toString() {
			return "surveyVO [surveyNo=" + surveyNo + ", companyNo=" + companyNo + ", surveyGroupNo=" + surveyGroupNo
					+ ", quesNo=" + quesNo + ", quesFormGroupNo=" + quesFormGroupNo + ", quesName=" + quesName
					+ ", cateName=" + cateName + ", companyName=" + companyName + ", manager=" + manager
					+ ", surveyDate=" + surveyDate + ", type=" + type + ", satisVal=" + satisVal + ", dissatisReason="
					+ dissatisReason + ", answer=" + answer + ", participate=" + participate + ", satisfaction="
					+ satisfaction + ", surveyFormNo=" + surveyFormNo + ", surveyFormGroupNo=" + surveyFormGroupNo
					+ ", orderNo=" + orderNo + ", quesCount=" + quesCount + "]";
		}



}
