package survey.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping(value = "/master")

public class MasterController {
	
	
	@RequestMapping(value="/main", method= {RequestMethod.GET,RequestMethod.POST})
	public String main() {
		return "master/login";
	}
	

	@RequestMapping(value="/login", method= {RequestMethod.GET,RequestMethod.POST})
	public String login() {
		return "master/add";
	}
	
	
	@RequestMapping(value="/surveyManage", method= {RequestMethod.GET,RequestMethod.POST})
	public String surveyManage(String cliName,Model model) {
		
		/*cliName = "키움증권";
		model.addAttribute("cliName", cliName);*/
		return "master/surveyManage";
	}
	

}
