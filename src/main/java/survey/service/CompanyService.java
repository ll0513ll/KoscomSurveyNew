package survey.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import survey.mapper.CompanyDao;
import survey.model.companyVO;

@Service
public class CompanyService {

	@Autowired
	CompanyDao companyDao;
	
	public List<companyVO> getCompanyList() throws Exception{
		
		return companyDao.getCompanyList();
	}
	
}
