package survey.mapper;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import survey.model.userVO;

@Repository
public class MasterDao {

	
	@Autowired
	SqlSession sqlSession;
	
	public userVO checkLogin(userVO userVo) {
		
		System.out.println("로그인 다오");
		return sqlSession.selectOne("checkLogin", userVo);
	}
	

}
