package survey.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import survey.mapper.SurveyFormDao;
import survey.model.SurveyFormGroupVo;
import survey.model.SurveyFormVo;

import java.util.List;
import java.util.Map;

@Service
public class SurveyFormService {

    @Autowired
    SurveyFormDao surveyFormDao;

    public int add(Map<String, Object> param) {
        int resutl = 0;
        try {
            SurveyFormGroupVo surveyFormGroupVo = new SurveyFormGroupVo();
            surveyFormGroupVo.setCateName(param.get("cateName").toString());
            resutl = surveyFormDao.surveyFormGroupAdd(surveyFormGroupVo);

            List<Map<String,Object>> quesList = (List<Map<String,Object>>) param.get("quesList");
            SurveyFormVo surveyFormVo;
            for (int i = 0; i < param.size(); i++) {
                surveyFormVo = new SurveyFormVo();
                surveyFormVo.setSurveyFormGroupNo(surveyFormGroupVo.getSurveyFormGroupNo());
                surveyFormVo.setQuesName(quesList.get(i).get("quesName").toString());
                surveyFormVo.setType(Integer.parseInt(quesList.get(i).get("quesType").toString()));
                surveyFormDao.surveyFormAdd(surveyFormVo);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return resutl;
        }

        return resutl;
    }
}
