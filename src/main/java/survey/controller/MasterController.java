package survey.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import survey.model.userVO;
import survey.service.MasterService;


@Controller
@RequestMapping(value = "/master")

public class MasterController {
	
	@Autowired
	MasterService masterService;
	
	@RequestMapping(value="/main", method= {RequestMethod.GET,RequestMethod.POST})
	public String main() {
		return "master/login";
	}
	

	@RequestMapping(value="/login", method= {RequestMethod.GET,RequestMethod.POST})
	public String login(@ModelAttribute userVO userVo,HttpSession session) {
		
		System.out.println("로그인 컨트롤러");
		System.out.println(userVo);
		//return "redirect:/cateEdit/";
		userVO authUser =  masterService.checkLogin(userVo);
		
		if (authUser != null) {
			session.setAttribute("authUser", authUser);
			return "redirect:/cateEdit/";
		} else {
			return "redirect:/master/main?result=fail";
		}
			
		
	}
	
	
	@RequestMapping(value="/surveyManage", method= {RequestMethod.GET,RequestMethod.POST})
	public String surveyManage(String cliName,Model model) {
		
		/*cliName = "키움증권";
		model.addAttribute("cliName", cliName);*/
		return "master/surveyManage";
	}
	

}
