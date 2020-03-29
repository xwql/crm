package cn.crm.service;

import cn.crm.bean.Evaluation;
import cn.crm.utils.Page;

public interface EvaluationService {
    /**
     * 评价列表
     */
    Page<Evaluation> findEvaluationList(Integer page, Integer rows,String custName,String toObject,Integer visible);
    /**
     * 保存或编辑
     */
    void saveEvaluation(Evaluation evaluation);
    /**
     * 删除(不删除数据)
     */
    void deleteEvaluation(Long id);
    /**
     * 回显一条评价
     */
    Evaluation getOneEvaluation(Long id);
}
