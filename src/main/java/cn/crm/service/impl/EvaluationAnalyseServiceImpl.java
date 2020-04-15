package cn.crm.service.impl;

import cn.crm.bean.Evaluation;
import cn.crm.mapper.EvaluationAnalyseMapper;
import cn.crm.service.EvaluationAnalyseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EvaluationAnalyseServiceImpl implements EvaluationAnalyseService {

    @Autowired
    private EvaluationAnalyseMapper evaluationAnalyseMapper;

    @Override
    public Map findMaxAndMinEvaluation(Date start_time, Date end_time) {
        Date start = null;
        Date end = null;
        if(start_time == null || end_time == null) {
            Calendar instance = Calendar.getInstance();
            end = new Date();
            instance.setTime(end);
            instance.add(Calendar.YEAR, -1);
            start = instance.getTime();
        } else {
            start = start_time;
            end = end_time;
        }
        HashMap<String, Evaluation> map = new HashMap<>();
        Evaluation maxEvaluation = evaluationAnalyseMapper.selectMaxEvaluation(start, end);
        Evaluation minEvaluation = evaluationAnalyseMapper.selectMinEvaluation(start, end);
        map.put("maxEvaluation",maxEvaluation);
        map.put("minEvaluation",minEvaluation);
        return map;
    }

    @Override
    public Map findEvaluationAvg(Date start_time, Date end_time) {
        Date start = null;
        Date end = null;
        if(start_time == null || end_time == null) {
            Calendar instance = Calendar.getInstance();
            end = new Date();
            instance.setTime(end);
            instance.add(Calendar.YEAR, -1);
            start = instance.getTime();
        } else {
            start = start_time;
            end = end_time;
        }
        Map<String, Object> avg = evaluationAnalyseMapper.selectEvaluationAvg(start, end);
        /*HashMap<String, Double> map = new HashMap<>();
        map.put("companyToCustomer",Double.parseDouble(avg.get("companyToCustomer").toString()));
        map.put("customerToCompany",Double.parseDouble(avg.get("customerToCompany").toString()));
        return map;*/
        return avg;
    }

    @Override
    public Map findEvaluationLine(Date start_time, Date end_time) {
        Date start = null;
        Date end = null;
        if(start_time == null || end_time == null) {
            Calendar instance = Calendar.getInstance();
            end = new Date();
            instance.setTime(end);
            instance.add(Calendar.YEAR, -1);
            start = instance.getTime();
        } else {
            start = start_time;
            end = end_time;
        }
        List<Map<String, Object>> maps = evaluationAnalyseMapper.selectEvaluationLine(start, end);
        TreeMap<String, Integer> evaluationMap = new TreeMap<>();
        for (Map m : maps) {
            evaluationMap.put(m.get("score").toString(),Integer.parseInt(m.get("num").toString()));
        }
        HashMap<String, Map> map = new HashMap<>();
        map.put("evaluationLine",evaluationMap);
        return map;
    }
}
