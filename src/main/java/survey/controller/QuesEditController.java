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
import survey.model.quesVO;
import survey.service.CateEditService;
import survey.service.QuesEditService;


@Controller
@RequestMapping(value = "/quesEdit")
public class QuesEditController {
	
	@Autowired
	QuesEditService quesService;
	
	@Autowired
	CateEditService cateEditService;
	
	@RequestMapping(value="/", method= {RequestMethod.GET,RequestMethod.POST})
	public String edit(Model model) throws Exception {
		
		
		List<quesVO> quesList = quesService.getQuesList();
		model.addAttribute("quesList", quesList);

		List<cateVO> cateList = cateEditService.getCateList();
		model.addAttribute("cateList",cateList);

		
		return "master/add";
	}
	
	@RequestMapping(value="/quesList", method= {RequestMethod.GET,RequestMethod.POST})
	public String quesList(Model model) throws Exception {
		
		List<quesVO> quesList = quesService.getQuesList();
		model.addAttribute("quesList", quesList);
		
		
		List<cateVO> cateList = cateEditService.getCateList();
		model.addAttribute("cateList",cateList);
		
		return "master/add";
	}
	
	@ResponseBody
	@RequestMapping(value="/ajaxQuesList", method= {RequestMethod.GET,RequestMethod.POST})
	public List<quesVO> ajaxQuesList() throws Exception {
		
		List<quesVO> quesList = quesService.getQuesList();
		return quesList;
	}
	
	@ResponseBody
	@RequestMapping(value="/addQues", method= {RequestMethod.POST})
	public int addQues(@ModelAttribute quesVO quesVO ) throws Exception{
		
		
		return quesService.addQues(quesVO);
	}
	
	@ResponseBody
	@RequestMapping(value="/delQues", method= {RequestMethod.GET,RequestMethod.POST})
	public int delQues(@RequestParam(value="delQuesList[]") ArrayList<String> delQuesList) throws Exception{
		
		return quesService.delQues(delQuesList);
	
	}
	
	@ResponseBody
	@RequestMapping(value="/quesUpdate", method= {RequestMethod.GET,RequestMethod.POST})
	public int quesUpdate(@ModelAttribute quesVO quesVO) {

		return quesService.quesUpdate(quesVO);
	}

	

}
