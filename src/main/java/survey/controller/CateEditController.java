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
import survey.service.CateEditService;

@Controller
@RequestMapping(value = "/cateEdit")
public class CateEditController {
	
	@Autowired
	CateEditService cateEditService;
	
	@RequestMapping(value="/", method= {RequestMethod.GET,RequestMethod.POST})
	public String cateEdit(Model model) throws Exception{
		
		List<cateVO> cateList = cateEditService.getCateList();
		
		model.addAttribute("cateList",cateList);
		
		return "master/cateEdit";
	}
	
	@ResponseBody
	@RequestMapping(value="/addCate", method= {RequestMethod.POST})
	public int addCate(@ModelAttribute cateVO cateVO) throws Exception{
		
		return cateEditService.addCate(cateVO);
	}
	
	@ResponseBody
	@RequestMapping(value="/getCateList", method= {RequestMethod.GET,RequestMethod.POST})
	public List<cateVO> getCateList(Model model) throws Exception{
		
		List<cateVO> cateList = cateEditService.getCateList();
		model.addAttribute("cateList",cateList);
		
		return cateList;
	}
	
	@ResponseBody
	@RequestMapping(value="/delCate", method= {RequestMethod.GET,RequestMethod.POST})
	public int delCate(@RequestParam(value="delCateList[]") ArrayList<String> delCateList) throws Exception{

		return cateEditService.delCate(delCateList);
	
	}
	
	@ResponseBody
	@RequestMapping(value="/cateUpdate", method= {RequestMethod.GET,RequestMethod.POST})
	public int cateUpdate(@ModelAttribute cateVO cateVO) throws Exception{

		System.out.println(cateVO);
		return cateEditService.cateUpdate(cateVO);
	
	}
	
	
}
