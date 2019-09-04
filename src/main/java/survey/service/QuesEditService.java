package survey.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import survey.mapper.QuesEditDao;
import survey.model.cateVO;
import survey.model.quesVO;

@Service
public class QuesEditService {

	@Autowired
	QuesEditDao quesDao;
	
	public cateVO getCateName(int cateName) {
		
		return quesDao.getCateName(cateName);
	}
	
	public List<quesVO> getQuesList() throws Exception{
		
		List<quesVO> quesList = quesDao.getQuesList();
		 return quesList;
	}
	
	public int addQues(quesVO quesVO) throws Exception{
		
		
		return quesDao.addQues(quesVO);
	}
	
	public int delQues(ArrayList<String> delQuesList) throws Exception{
		
		
		return quesDao.delQues(delQuesList);
	}
	
	public int quesUpdate(quesVO quesVO) {
		
		return quesDao.quesUpdate(quesVO);
	}

}
