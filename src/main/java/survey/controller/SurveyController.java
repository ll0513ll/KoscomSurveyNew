package survey.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import survey.model.cateVO;
import survey.model.companyVO;
import survey.model.quesVO;
import survey.model.surveyParamVo;
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
	public String cliSurvey(@RequestParam(value="selectCate",required=false) int cateName,
							@RequestParam(value="quesName[]",required=false) ArrayList<String> quesNoList,
							Model model)throws Exception {
		
		cateVO cateVo = quesService.getCateName(cateName);
		model.addAttribute("cateVo", cateVo);
		
		List<companyVO> cliVo = companyService.getCompanyList();
		model.addAttribute("cliVo", cliVo);
		
		List<quesVO> selectQlist = surveyService.getQuesList(quesNoList);
		model.addAttribute("selectQlist", selectQlist);
		
		return "master/cliSurvey";
	}
	
	@ResponseBody
	@RequestMapping(value="surveyAdd", method= {RequestMethod.GET,RequestMethod.POST})
	public int surveyAdd(@ModelAttribute surveyParamVo surveyParam ) {
		
		System.out.println("설문지 하나 만들었다");
		System.out.println(surveyParam);
		
		return surveyService.surveyAdd(surveyParam);
		
		
	}
	
	@RequestMapping(value="thanks", method= {RequestMethod.GET,RequestMethod.POST})
	public String thanksView() {
		
		return "master/thanks";
	}

}
