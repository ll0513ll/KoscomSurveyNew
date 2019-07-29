package survey.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import survey.service.SurveyFormService;

import java.util.Map;

@Controller
@RequestMapping(value = "/surveyForm")
public class SurveyFormController {

    @Autowired
    SurveyFormService surveyFormService;

    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public int add(@RequestBody Map<String, Object> param) {
        return surveyFormService.add(param);
    }
}
