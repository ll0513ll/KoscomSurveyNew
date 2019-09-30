package survey.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import survey.mapper.MasterDao;
import survey.model.cliVO;
import survey.model.userVO;

@Service
public class MasterService {

	
	@Autowired
	MasterDao masterDao;
	
	public userVO checkLogin(userVO userVo) {
		
		return masterDao.checkLogin(userVo);
	}
	
	public cliVO cliLoginCheck(cliVO cliVo) {
		
		return masterDao.cliLoginCheck(cliVo);
	}
}
