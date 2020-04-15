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
    public Map getMaxAndMinEvaluation(Date start_time, Date end_time){
     return evaluationAnalyseService.findMaxAndMinEvaluation(start_time,end_time);
    }

    @PostMapping("evaluationAnalyse/getEvaluationAvg")
    @ResponseBody
    public Map getEvaluationAvg(Date start_time, Date end_time){
        return evaluationAnalyseService.findEvaluationAvg(start_time, end_time);
    }

    @PostMapping("evaluationAnalyse/getEvaluationLine")
    @ResponseBody
    public Map getEvaluationLine(Date start_time, Date end_time){
        return evaluationAnalyseService.findEvaluationLine(start_time, end_time);
    }
}
