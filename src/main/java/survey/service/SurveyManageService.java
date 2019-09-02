package survey.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import survey.mapper.SurveyManageDao;
import survey.model.surveyVO;

@Service
public class SurveyManageService {
	
	@Autowired
	SurveyManageDao manageDao;
	
	
	public List<surveyVO> getSurveyList() {
		
		return manageDao.getSurveyList();
	}
	
	public List<surveyVO> getSelectSurvey(int surveyNo){
		
		return manageDao.getSelectSurvey(surveyNo);
	}

}
