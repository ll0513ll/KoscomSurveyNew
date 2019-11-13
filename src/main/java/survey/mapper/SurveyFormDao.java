package survey.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import survey.model.SurveyFormGroupVo;
import survey.model.SurveyFormVo;

@Repository
public class SurveyFormDao {

    @Autowired
    SqlSession sqlSession;

    public int surveyFormGroupAdd(SurveyFormGroupVo surveyFormGroupVo) {
        return sqlSession.insert("surveyFormGroupAdd", surveyFormGroupVo);
    }

    public int surveyFormAdd(SurveyFormVo surveyFormVo) {
        return sqlSession.insert("surveyFormAdd", surveyFormVo);
    }
    
    public int getSurvey() {
    	
    	return sqlSession.selectOne("getSurvey");
    }
    
    public List<SurveyFormVo> getSurveyForm(int surveyFormGroupNo) {
    	
    	return sqlSession.selectList("getSurveyForm",surveyFormGroupNo);
    }
}
