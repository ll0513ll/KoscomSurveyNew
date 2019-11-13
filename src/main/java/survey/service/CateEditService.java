package survey.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import survey.mapper.CateEditDao;
import survey.model.cateVO;

@Service
public class CateEditService {
	
	@Autowired
	CateEditDao cateEditDao;

	
	public List<cateVO> getCateList() throws Exception{
		
		List<cateVO> cateList = cateEditDao.getCateList();
		 return cateList;
	}
	
	public int addCate(cateVO cateVO) throws Exception{
		
		return cateEditDao.addCate(cateVO);
	}
	
	public int delCate(ArrayList<String> delCateList) throws Exception{
		
		
		return cateEditDao.delCate(delCateList);
	}
	
	public int cateUpdate(cateVO cateVO) throws Exception{

		return cateEditDao.cateUpdate(cateVO);
	
	}
	
}
