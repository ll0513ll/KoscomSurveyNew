package survey.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import survey.model.PagingVO;
import survey.model.SurveyFormGroupVo;

@Repository
public class SurveyUrlDao {
	
	@Autowired
    SqlSession sqlSession;
	
	public int SurveyCount() {
		
		return  sqlSession.selectOne("getServeyCount");
	
	}
	
	public List<SurveyFormGroupVo> SurveyList(PagingVO paging) {
		
		return  sqlSession.selectList("getServeyList", paging);
	
	}
	
	public List<SurveyFormGroupVo> totalCount() {
		
		return  sqlSession.selectList("totalCount");
	}
	
	public int addDate(SurveyFormGroupVo SurveyFormGroupVo) {
		return sqlSession.update("addDate", SurveyFormGroupVo);
	}

}
