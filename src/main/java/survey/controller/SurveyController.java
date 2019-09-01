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

import survey.model.companyVO;
import survey.model.surveyParamVo;
import survey.model.surveyVO;
import survey.service.CompanyService;
import survey.service.QuesEditService;
import survey.service.SurveyService;

@Controller
@RequestMapping(value = "/survey")
public class SurveyController {
	
	@Autowired
	SurveyService surveyService;
	
	@Autowired
	QuesEditService quesService;
	
	@Autowired
	CompanyService companyService;
	
	@RequestMapping(value="/", method= {RequestMethod.GET,RequestMethod.POST})
	public String cliSurvey(
							@RequestParam(value="quesFormGroupNo",required=false) int quesFormGroupNo,
							Model model)throws Exception {
		System.out.println("실제 설문지 페이지 컨트롤러");
		System.out.println(quesFormGroupNo);
		List<surveyVO> surveyVo = surveyService.getQuesList(quesFormGroupNo);
		List<companyVO> cliVo = companyService.getCompanyList();
		System.out.println(surveyVo);
		System.out.println(cliVo);
		model.addAttribute("cliVo", cliVo);
		model.addAttribute("surveyVo", surveyVo);
		model.addAttribute("quesFormGroupNo", quesFormGroupNo);
		
		return "master/cliSurvey";
	}
	
	@ResponseBody
	@RequestMapping(value="surveyAdd", method= {RequestMethod.GET,RequestMethod.POST})
	public int surveyAdd(@ModelAttribute surveyParamVo surveyParam ) {
		
		System.out.println("설문지 하나 만들었다");
		System.out.println(surveyParam);
		int result = surveyService.surveyAdd(surveyParam);
		System.out.println(result);
		
		return result;
		
		
	}
	
	@RequestMapping(value="thanks", method= {RequestMethod.GET,RequestMethod.POST})
	public String thanksView() {
		
		return "master/thanks";
	}

}
