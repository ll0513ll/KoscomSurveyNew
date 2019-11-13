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
	
	//제목편집 화면 이동
	@RequestMapping(value="/", method= {RequestMethod.GET,RequestMethod.POST})
	public String cateEdit(Model model) throws Exception{
		
		List<cateVO> cateList = cateEditService.getCateList();
		
		model.addAttribute("cateList",cateList);
		
		return "master/cateEdit";
	}
	
	//제목 추가
	@ResponseBody
	@RequestMapping(value="/addCate", method= {RequestMethod.POST})
	public int addCate(@ModelAttribute cateVO cateVO) throws Exception{
		
		return cateEditService.addCate(cateVO);
	}
	
	//제목 리스트 불러오기
	@ResponseBody
	@RequestMapping(value="/getCateList", method= {RequestMethod.GET,RequestMethod.POST})
	public List<cateVO> getCateList(Model model) throws Exception{
		
		List<cateVO> cateList = cateEditService.getCateList();
		model.addAttribute("cateList",cateList);
		
		return cateList;
	}
	
	//제목 삭제
	@ResponseBody
	@RequestMapping(value="/delCate", method= {RequestMethod.GET,RequestMethod.POST})
	public int delCate(@RequestParam(value="delCateList[]") ArrayList<String> delCateList) throws Exception{

		return cateEditService.delCate(delCateList);
	
	}
	
	//제목 수정
	@ResponseBody
	@RequestMapping(value="/cateUpdate", method= {RequestMethod.GET,RequestMethod.POST})
	public int cateUpdate(@ModelAttribute cateVO cateVO) throws Exception{

		return cateEditService.cateUpdate(cateVO);
	
	}
	
	
}
