package survey.mapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import survey.model.quesVO;
import survey.model.surveyVO;

@Repository
public class SurveyDao {
	
	@Autowired
	SqlSession sqlSession;
	
	public List<quesVO> getQuesList(ArrayList<String> quesNoList){
		
		List<String> list = quesNoList;
	    return sqlSession.selectList("quesList",list);
	}
	
	public int surveyAdd(surveyVO surveyVo) {
		
		 return sqlSession.insert("surveyAdd",surveyVo);
	}

}
