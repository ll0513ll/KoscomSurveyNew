package survey.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import survey.model.cliVO;
import survey.model.companyVO;

@Repository
public class CompanyDao {
	
	@Autowired
	SqlSession sqlSession;
	
	public List<companyVO> getCompanyList(){
		return  sqlSession.selectList("getCompanyList");
	 }
	
	public cliVO getCompany(cliVO cliVo){
		return  sqlSession.selectOne("getCompanyName",cliVo);
	 }

}
