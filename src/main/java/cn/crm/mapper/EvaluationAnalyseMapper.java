package cn.crm.mapper;

import cn.crm.bean.Evaluation;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;
@Repository
public interface EvaluationAnalyseMapper {
    Map<String,Object> selectEvaluationAvg(@Param("start_time") Date start_time, @Param("end_time") Date end_time);
    Evaluation selectMaxEvaluation(@Param("start_time") Date start_time, @Param("end_time") Date end_time);
    Evaluation selectMinEvaluation(@Param("start_time") Date start_time, @Param("end_time") Date end_time);
    List<Map<String,Object>> selectEvaluationLine(@Param("start_time") Date start_time, @Param("end_time") Date end_time);
}
