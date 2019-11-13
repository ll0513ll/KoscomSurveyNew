package survey.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import survey.model.surveyParamVo;
import survey.model.surveyVO;

@Repository
public class SurveyDao {
	
	@Autowired
	SqlSession sqlSession;
	
	public List<surveyVO> getQuesList(int quesFormGroupNo){
		
	    return sqlSession.selectList("quesList",quesFormGroupNo);
	}
	
	public int duplCheck(surveyParamVo surveyParam) {
		return sqlSession.selectOne("duplCheck",surveyParam);
	}
	
	public int surveyAdd(surveyVO surveyVo) {
		 
	    return sqlSession.insert("surveyAdd",surveyVo);
		
	}

}
