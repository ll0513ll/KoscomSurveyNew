package survey.service;

import java.util.List;
import java.util.stream.Collectors;

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
		
		List<surveyVO> result = manageDao.getSelectSurvey(surveyNo);
		
		
//		List<surveyVO> qusCount = manageDao.getQusCount(surveyNo);
//		System.out.println(qusCount);
//
//		//선택한 객관식 구해오기 but 회사no값을 뽑아서 가져가야함
//		List<surveyVO> satisVal = manageDao.getSatisVal(surveyNo);
//		System.out.println(satisVal);
//
		
		 return result;
	}

}
