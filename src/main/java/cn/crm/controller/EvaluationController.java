package cn.crm.controller;

import cn.crm.bean.Evaluation;
import cn.crm.service.EvaluationService;
import cn.crm.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class EvaluationController {
    @Autowired
    EvaluationService evaluationService;

    @GetMapping("evaluation.html")
    public String getEvaluationHtml(){
        return "evaluation/evaluation";
    }
    @GetMapping("evaluationAdd.html")
    public String getEvaluationAddHtml(){
        return "evaluation/evaluationAdd";
    }
    /**
     * evaluationList
     */
    @PostMapping("evaluationList")
    @ResponseBody
    public Page<Evaluation> getevaluationList(@RequestParam(defaultValue="1")Integer page, @RequestParam(defaultValue="10")Integer pageSize,
                                 String custName,String toObject){
        HashMap<String, String> map = new HashMap<>();
        Page<Evaluation> evaluationList = evaluationService.findEvaluationList(page, pageSize, custName, toObject, 1);
        return evaluationList;
    }

    /**
     * saveEvaluation
     */
    @PostMapping("saveEvaluation")
    @ResponseBody
    public Map saveEvaluation(Evaluation evaluation){
        HashMap<String, String> map = new HashMap<>();
        evaluationService.saveEvaluation(evaluation);
        map.put("msg","保存成功");
        return map;
    }
    /**
     * deleteEvaluation
     */
    @PostMapping("deleteEvaluation")
    @ResponseBody
    public Map deleteEvaluation(Long id){
        HashMap<String, String> map = new HashMap<>();
        evaluationService.deleteEvaluation(id);
        map.put("msg","删除成功");
        return map;
    }

    /**
     * editEvaluation，包含客户名称
     */
    @PostMapping("editEvaluation")
    @ResponseBody
    public Evaluation editEvaluation(Long id){
        Evaluation oneEvaluation = evaluationService.getOneEvaluation(id);
        return oneEvaluation;
    }
}
