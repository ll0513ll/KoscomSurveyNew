package survey.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import survey.mapper.SurveyDao;
import survey.model.SurveyFormGroupVo;
import survey.model.SurveyFormVo;
import survey.model.quesVO;
import survey.model.surveyParamVo;
import survey.model.surveyVO;

@Service
public class SurveyService {
	
	@Autowired
	SurveyDao surveyDao;
	
	public List<surveyVO> getQuesList(int quesFormGroupNo){
		
		return surveyDao.getQuesList(quesFormGroupNo);
	}

	public int surveyAdd(surveyParamVo surveyParam) {

		surveyVO surveyVo = new surveyVO();
		int result = 0;
		try {
			for (int i=0; i < surveyParam.getQuesName().length; i++) {
				//surveyVo = new surveyVO();				surveyVo.setCateName(surveyParam.getCateName());
				surveyVo.setQuesFormGroupNo(surveyParam.getQuesFormGroupNo());
				surveyVo.setCompanyNo(surveyParam.getCompanyNo());
				surveyVo.setQuesName(surveyParam.getQuesName()[i]);
				surveyVo.setManager(surveyParam.getManager());
				surveyVo.setDissatisReason(surveyParam.getDissatisReason()[i]);
				System.out.println(surveyParam.getDissatisReason()[i]);
				surveyVo.setSatisVal(surveyParam.getMultipleVal()[i]);
				surveyVo.setType(surveyParam.getType()[i]);
				
				if (surveyParam.getType()[i] == 2) {
					surveyVo.setAnswer(surveyParam.getAnswer()[i]);
					surveyVo.setType(surveyParam.getType()[i]);
				}
					System.out.println(surveyVo);
					result =  surveyDao.surveyAdd(surveyVo);
					System.out.println(result);
			}
			
			
		}catch (Exception e) {
            e.printStackTrace();
            return result;
        }
		
		 return result;
		
	}

}
