package survey.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import survey.mapper.SurveyUrlDao;
import survey.model.PagingVO;
import survey.model.SurveyFormGroupVo;

@Service
public class SurveyUrlService {
	
	@Autowired
	SurveyUrlDao urlDao;
	
	public int SurveyCount() {
		
		return urlDao.SurveyCount();
		
	}
	
	public List<SurveyFormGroupVo> SurveyList(PagingVO paging) {
		
		return urlDao.SurveyList(paging);
		
	}
	
	public int totalCount() {
		
		List<SurveyFormGroupVo> surveyCount = urlDao.totalCount();
		int totalCount = 0;
		System.out.println(surveyCount.size());
		
		for(int i = 0;i<surveyCount.size();i++) {
			
			totalCount = i+1;
		}
		System.out.println(totalCount);
		
		return totalCount;
	}

	public int addDate(SurveyFormGroupVo SurveyFormGroupVo) {
		System.out.println("날짜저장 서비스");
		return urlDao.addDate(SurveyFormGroupVo);
	}
}
