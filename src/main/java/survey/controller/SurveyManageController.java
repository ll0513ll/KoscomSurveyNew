package survey.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import survey.model.quesVO;
import survey.model.surveyVO;
import survey.service.SurveyManageService;

@Controller
@RequestMapping(value = "/surveyManage")
public class SurveyManageController {
	
	@Autowired
	SurveyManageService manageService;
	
	@RequestMapping(value="/", method= {RequestMethod.GET,RequestMethod.POST})
	public String getSurveyList(Model model) {
		
		
		List<surveyVO> surveyList =  manageService.getSurveyList();
		model.addAttribute("surveyList", surveyList);
		 
		 return "master/surveyManage";
	}
	
	@ResponseBody 
	@RequestMapping(value="/getSelectSurvey", method= {RequestMethod.GET,RequestMethod.POST})
	public List<surveyVO> getSelectSurvey(@RequestParam(value="surveyNo") int surveyNo)  throws Exception{
		
		System.out.println("설문지 선택후 컨트롤러");
		System.out.println(surveyNo);
		return manageService.getSelectSurvey(surveyNo);
	}
	

}
