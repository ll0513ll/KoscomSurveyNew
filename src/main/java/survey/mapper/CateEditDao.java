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
		 //return surveyMapper.getCateList();
		System.out.println("카테 다오");
		List<cateVO> cateList = sqlSession.selectList("getCateList");
		System.out.println(cateList);
		return cateList;
	 }
	 
	 
	 public int addCate(cateVO cateVO) {
		 
		 System.out.println("카테추가 다오");
		 
		return  sqlSession.insert("addCate",cateVO);
	 }
	 
	 
	 public int delCate(ArrayList<String> delCateList) {
		 
		 System.out.println("카테삭제 다오");
		 System.out.println(delCateList);
		 List<String> list = delCateList;
		 
		 return sqlSession.delete("delCate", list);
		 
	 }
	

}
