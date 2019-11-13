package survey.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import survey.model.cliVO;
import survey.model.companyVO;
import survey.model.surveyVO;
import survey.model.userVO;
import survey.service.CompanyService;
import survey.service.MasterService;
import survey.service.SurveyService;


@Controller
@RequestMapping(value = "/master")

public class MasterController {
	
	@Autowired
	MasterService masterService;
	
	@Autowired
	CompanyService companyService;
	
	@Autowired
	SurveyService surveyService;
	
	
	@RequestMapping(value="/main", method= {RequestMethod.GET,RequestMethod.POST})
	public String main() {
		return "master/login";
	}
	

	@RequestMapping(value="/login", method= {RequestMethod.GET,RequestMethod.POST})
	public String login(@ModelAttribute userVO userVo,HttpSession session) {
		
		userVO authUser =  masterService.checkLogin(userVo);
		
		if (authUser != null) {
			session.setAttribute("authUser", authUser);
			return "redirect:/cateEdit/";
		} else {
			return "redirect:/master/main?result=fail&master=fail";
		}
			
		
	}
	
	@RequestMapping(value="/cliLogin", method= {RequestMethod.GET,RequestMethod.POST})
	public String cliLogin(@RequestParam(value="quesFormGroupNo",required=false) int quesFormGroupNo, Model model) {
		model.addAttribute("quesFormGroupNo", quesFormGroupNo);
		boolean dudate = masterService.checkDudate(quesFormGroupNo);
		List<companyVO> companyVO = companyService.getCompanyList();
		model.addAttribute("companyVO", companyVO);
		if(dudate == false) {
			return "master/close";//같은 화면으로 종료안내 페이지 만들기
		}
		
		return "master/cliLogin";
		
	}
	
	@RequestMapping(value="/cliLoginCheck", method= {RequestMethod.GET,RequestMethod.POST})
	public String cliLoginCheck(@RequestParam(value="quesFormGroupNo",required=false) int quesFormGroupNo, @ModelAttribute cliVO cliVo,Model model) {
		
		cliVO authUser = masterService.cliLoginCheck(cliVo);
		if (authUser != null) {
			List<surveyVO> surveyVo = surveyService.getQuesList(quesFormGroupNo);
			cliVO company = companyService.getCompany(cliVo);
			model.addAttribute("quesFormGroupNo", quesFormGroupNo);
			model.addAttribute("company", company);
			model.addAttribute("surveyVo", surveyVo);
			return "master/cliSurvey";
		} else {
			model.addAttribute("quesFormGroupNo", quesFormGroupNo);
			model.addAttribute("cliVo", cliVo);
			return "redirect:/master/cliLogin?result=fail";
		}
		
	}
	
	
	@RequestMapping(value="/surveyManage", method= {RequestMethod.GET,RequestMethod.POST})
	public String surveyManage(String cliName,Model model) {
		
		return "master/surveyManage";
	}
	

}
