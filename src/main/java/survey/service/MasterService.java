package survey.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import survey.mapper.MasterDao;
import survey.model.userVO;

@Service
public class MasterService {

	
	@Autowired
	MasterDao masterDao;
	
	public userVO checkLogin(userVO userVo) {
		
		System.out.println("로그인 서비스");
		return masterDao.checkLogin(userVo);
	}
}
