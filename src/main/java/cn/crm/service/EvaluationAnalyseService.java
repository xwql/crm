package cn.crm.service;

import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.Map;

public interface EvaluationAnalyseService {
    Map findMaxAndMinEvaluation(Date startTime, Date endTime);
    Map findEvaluationAvg(Date startTime, Date endTime);
    Map findEvaluationLine(Date startTime, Date endTime);
}
