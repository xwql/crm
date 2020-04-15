package cn.crm.service;

import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.Map;

public interface EvaluationAnalyseService {
    Map findMaxAndMinEvaluation(Date start_time, Date end_time);
    Map findEvaluationAvg(Date start_time, Date end_time);
    Map findEvaluationLine(Date start_time, Date end_time);
}
