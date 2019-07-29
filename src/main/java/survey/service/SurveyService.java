package survey.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import survey.mapper.SurveyDao;
import survey.model.quesVO;
import survey.model.surveyParamVo;
import survey.model.surveyVO;

@Service
public class SurveyService {
	
	@Autowired
	SurveyDao surveyDao;
	
	public List<quesVO> getQuesList(ArrayList<String> quesNoList){
		
		return surveyDao.getQuesList(quesNoList);
	}

	public int surveyAdd(surveyParamVo surveyParam) {

		surveyVO surveyVo = new surveyVO();
		for (int i=0; i < surveyParam.getQuesNo().length; i++) {
			surveyVo = new surveyVO();
			surveyVo.setCateNo(surveyParam.getCateNo());
			surveyVo.setCompanyNo(surveyParam.getCompanyNo());
			surveyVo.setQuesNo(surveyParam.getQuesNo()[i]);
			surveyVo.setManager(surveyParam.getManager());
			surveyVo.setDissatisReason(surveyParam.getDissatisReason()[i]);
			surveyVo.setSatisVal(surveyParam.getMultipleVal()[i]);
			surveyVo.setType(surveyParam.getType()[i]);
			
			if (surveyParam.getType()[i] == 2) {
				surveyVo.setAnswer(surveyParam.getAnswer()[i]);
			}
			  System.out.println(surveyVo);
			  surveyDao.surveyAdd(surveyVo);
		}
		 
		 return 1;
		
	}
}
