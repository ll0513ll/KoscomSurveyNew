package survey.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import survey.service.SurveyFormService;

@Controller
@RequestMapping(value = "/surveyForm")
public class SurveyFormController {

    @Autowired
    SurveyFormService surveyFormService;

    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Map<String, Object> add(@RequestBody Map<String, Object> param,Model model) {
    	
    	return surveyFormService.add(param);
         
         
    }
    
}
