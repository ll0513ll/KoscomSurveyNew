package survey.mapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import survey.model.cateVO;
import survey.model.quesVO;

@Repository
public class QuesEditDao {

	@Autowired
	SqlSession sqlSession;
	
	public cateVO getCateName(int cateName) {
		
		return sqlSession.selectOne("getCateName",cateName);
	}
	
	public List<quesVO> getQuesList(){
		System.out.println("get 질문 다오");
		List<quesVO> quesList = sqlSession.selectList("getQuesList");
		return quesList;
	 }
	
	public int addQues(quesVO quesVO) {
		 
		 System.out.println("질문추가 다오");
		 
		return  sqlSession.insert("addQues",quesVO);
	 }
	
	public int delQues(ArrayList<String> delQuesList) {
		 
		 System.out.println("질문삭제 다오");
		 System.out.println(delQuesList);
		 List<String> list = delQuesList;
		 
		 return sqlSession.delete("delQues", list);
		 
	 }
}
