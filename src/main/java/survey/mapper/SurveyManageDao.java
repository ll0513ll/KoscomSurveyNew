package survey.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import survey.model.surveyVO;


@Repository
public class SurveyManageDao {
	
	@Autowired
	SqlSession sqlSession;
	
	public List<surveyVO> getSurveyList() {
		
		return sqlSession.selectList("getSurveyList");
	}
	
	public List<surveyVO> getSelectSurvey(int surveyNo){
		
		return sqlSession.selectList("getSelectSurvey",surveyNo);
	}

	public List<surveyVO> getQusCount(int surveyNo){
		
		return sqlSession.selectList("getQusCount",surveyNo);
	}
	
	public List<surveyVO> getSatisVal(int surveyNo){
		
		return sqlSession.selectList("getSatisVal",surveyNo);
	}
}
