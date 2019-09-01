package survey.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import survey.mapper.SurveyFormDao;
import survey.model.SurveyFormGroupVo;
import survey.model.SurveyFormVo;

@Service
public class SurveyFormService {

    @Autowired
    SurveyFormDao surveyFormDao;

    public Map<String, Object> add(Map<String, Object> param) {
        List<SurveyFormVo> result = null;
        Map<String, Object> map  = new HashMap<String, Object>();
        try {
            SurveyFormGroupVo surveyFormGroupVo = new SurveyFormGroupVo();
            surveyFormGroupVo.setCateName(param.get("cateName").toString());
            surveyFormGroupVo.setStartDate(param.get("startDate").toString());
            surveyFormGroupVo.setEndDate(param.get("endDate").toString());
            surveyFormDao.surveyFormGroupAdd(surveyFormGroupVo);

            List<Map<String,Object>> quesList = (List<Map<String,Object>>) param.get("quesList");
            SurveyFormVo surveyFormVo;
            for (int i = 0; i < quesList.size(); i++) {
            	System.out.println(quesList);
            	System.out.println("Survey폼 추가 서비스");
                surveyFormVo = new SurveyFormVo();
                surveyFormVo.setSurveyFormGroupNo(surveyFormGroupVo.getSurveyFormGroupNo());
                surveyFormVo.setQuesName(quesList.get(i).get("quesName").toString());
                surveyFormVo.setType(Integer.parseInt(quesList.get(i).get("quesType").toString()));
                surveyFormVo.setOrderNo(Integer.parseInt(quesList.get(i).get("quesOrder").toString()));
                System.out.println(surveyFormVo);
                surveyFormDao.surveyFormAdd(surveyFormVo);
            	
            }
            
            int surveyFormGroupNo = 0;
        	surveyFormGroupNo = surveyFormDao.getSurvey();
        	result = surveyFormDao.getSurveyForm(surveyFormGroupNo);
        	
        	map.put("cateName", surveyFormGroupVo.getCateName());
        	map.put("result",result);
        	
        	
        } catch (Exception e) {
            e.printStackTrace();
            return map;
        }

        return map;
    }
    
}
