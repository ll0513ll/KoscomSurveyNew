package survey.controller;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@Autowired
	MasterController masterController;
	
	@RequestMapping(value="/", method= {RequestMethod.GET,RequestMethod.POST})
	public String masterSurvey(@RequestParam(value="quesFormGroupNo",required=false) int quesFormGroupNo, @RequestParam(value="master",required=false) boolean master,
							Model model)throws Exception {
		if(master != true) {
			model.addAttribute("quesFormGroupNo", quesFormGroupNo);
			return "redirect:/master/cliLogin";
		}
		List<surveyVO> surveyVo = surveyService.getQuesList(quesFormGroupNo);
		List<companyVO> cliVo = companyService.getCompanyList();
		model.addAttribute("cliVo", cliVo);
		model.addAttribute("surveyVo", surveyVo);
		model.addAttribute("quesFormGroupNo", quesFormGroupNo);
		
		return "master/cliSurvey";
	}
	
	
	@ResponseBody
	@RequestMapping(value="surveyAdd", method= {RequestMethod.GET,RequestMethod.POST})
	public int surveyAdd(@RequestBody surveyParamVo surveyParam ) {
		int result = surveyService.surveyAdd(surveyParam);
		
		return result;
	}
	
	@RequestMapping(value="/thanks", method= {RequestMethod.GET,RequestMethod.POST})
	public String thanksView() {
		
		return "master/thanks";
	}



	public static Object convertMapToObject(Map map, Object objClass){
		String keyAttribute = null;
		String setMethodString = "set";
		String methodString = null;
		Iterator itr = map.keySet().iterator();
		while(itr.hasNext()){
			keyAttribute = (String) itr.next();
			methodString = setMethodString+keyAttribute.substring(0,1).toUpperCase()+keyAttribute.substring(1);
			try {
				Method[] methods = objClass.getClass().getDeclaredMethods();
				for(int i=0;i<=methods.length-1;i++){
					if(methodString.equals(methods[i].getName())){
						methods[i].invoke(objClass, map.get(keyAttribute));
					}
				}
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		return objClass;
	}
}
