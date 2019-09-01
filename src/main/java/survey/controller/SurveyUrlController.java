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

import survey.model.PagingVO;
import survey.model.SurveyFormGroupVo;
import survey.service.SurveyUrlService;


@Controller
@RequestMapping(value = "/surveyURL")
public class SurveyUrlController {
	
	@Autowired
	SurveyUrlService urlService;
	
	@RequestMapping(value="/", method= {RequestMethod.GET,RequestMethod.POST})
	public String SurveyList(@RequestParam(value="pageNo", defaultValue="1") int pageNo, Model model)throws Exception {
		
		System.out.println("URL컨트롤러");
		
		try {
	        // (Before) Doing...
			int totalCount = urlService.SurveyCount();
			
			if (pageNo < 0) {
				pageNo = 1;
			}
			int pageSize = 5;
	        PagingVO paging = new PagingVO();
	        paging.setPageNo(pageNo);
	        paging.setPageSize(pageSize);
	        paging.setTotalCount(totalCount);
	        paging.setStartLimit((pageNo-1) * pageSize);
	        System.out.println(paging);

			List<SurveyFormGroupVo> urlList = urlService.SurveyList(paging);
	        // (After) Doing...
	        model.addAttribute("urlList",urlList);
	        model.addAttribute("paging",paging);

		} catch (Exception e) {
	        throw e;
	    }

		return "master/surveyList";
	}
	
	@ResponseBody
    @RequestMapping(value = "/addDate", method = RequestMethod.POST)
    public int addDate(@ModelAttribute SurveyFormGroupVo SurveyFormGroupVo) {
    	
		System.out.println("날짜저장 컨트롤러");
		System.out.println(SurveyFormGroupVo);
    	return urlService.addDate(SurveyFormGroupVo);
         
         
    }

}
