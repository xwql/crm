package cn.crm.mapper;

import cn.crm.bean.Evaluation;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EvaluationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Evaluation record);

    int insertSelective(Evaluation record);

    Evaluation selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Evaluation record);

    int updateByPrimaryKey(Evaluation record);

    List<Evaluation> selectEvaluationList(Evaluation evaluation);
    Integer selectEvaluationListCount(Evaluation evaluation);
}