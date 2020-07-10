package cn.crm.controller;

import cn.crm.service.EvaluationAnalyseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.Map;

@Controller
public class EvaluationAnalyseController {

    @Autowired
    private EvaluationAnalyseService evaluationAnalyseService;

    @PostMapping("evaluationAnalyse/getMaxAndMinEvaluation")
    @ResponseBody
    public Map getMaxAndMinEvaluation(Date startTime, Date endTime){
     return evaluationAnalyseService.findMaxAndMinEvaluation(startTime,endTime);
    }

    @PostMapping("evaluationAnalyse/getEvaluationAvg")
    @ResponseBody
    public Map getEvaluationAvg(Date startTime, Date endTime){
        return evaluationAnalyseService.findEvaluationAvg(startTime, endTime);
    }

    @PostMapping("evaluationAnalyse/getEvaluationLine")
    @ResponseBody
    public Map getEvaluationLine(Date startTime, Date endTime){
        return evaluationAnalyseService.findEvaluationLine(startTime, endTime);
    }
}
