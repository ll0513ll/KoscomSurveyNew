package survey.mapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import survey.model.cateVO;

@Repository
public class CateEditDao {
	
	 @Autowired SqlSession sqlSession;
	 
	 public List<cateVO> getCateList(){
		List<cateVO> cateList = sqlSession.selectList("getCateList");
		return cateList;
	 }
	 
	 
	 public int addCate(cateVO cateVO) {
		 
		return  sqlSession.insert("addCate",cateVO);
	 }
	 
	 
	 public int delCate(ArrayList<String> delCateList) {
		
		 List<String> list = delCateList;
		 
		 return sqlSession.delete("delCate", list);
		 
	 }
	 
	 public int cateUpdate(cateVO cateVO) throws Exception{

			return sqlSession.update("cateUpdate",cateVO);
		
		}
	

}
