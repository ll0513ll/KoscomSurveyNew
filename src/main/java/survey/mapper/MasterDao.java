package survey.mapper;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import survey.model.cliVO;
import survey.model.userVO;

@Repository
public class MasterDao {

	
	@Autowired
	SqlSession sqlSession;
	
	public userVO checkLogin(userVO userVo) {
		
		return sqlSession.selectOne("checkLogin", userVo);
	}
	
	public cliVO cliLoginCheck(cliVO cliVo) {
		
		return sqlSession.selectOne("cliLoginCheck", cliVo);
	}
	

}
