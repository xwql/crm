package cn.crm.service.impl;

import cn.crm.bean.Customer;
import cn.crm.bean.Evaluation;
import cn.crm.mapper.CustomerMapper;
import cn.crm.mapper.EvaluationMapper;
import cn.crm.service.CustomerService;
import cn.crm.service.EvaluationService;
import cn.crm.utils.Page;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("evaluationService")
public class EvaluationServiceImpl implements EvaluationService {

    @Autowired
    EvaluationMapper evaluationMapper;
    @Autowired
    CustomerService customerService;
    @Autowired
    CustomerMapper customerMapper;

    @Override
    public Page<Evaluation> findEvaluationList(Integer page, Integer rows, String custName, String toObject, Integer visible) {
        Evaluation evaluation = new Evaluation();
        if(StringUtils.isNotBlank(custName)){
            evaluation.setCustName(custName);
        }
        if(StringUtils.isNotBlank(toObject)){
            evaluation.setToObject(toObject);
        }
        evaluation.setVisible(visible);
        evaluation.setStart((page-1) * rows) ;
        //每页行数
        evaluation.setRows(rows);
        //查询列表
        List<Evaluation> messages = evaluationMapper.selectEvaluationList(evaluation);
        //查询总记录数
        Integer count = evaluationMapper.selectEvaluationListCount(evaluation);
        //创建Page返回对象
        Page<Evaluation> result = new Page<>();
        result.setPage(page);
        result.setRows(messages);
        result.setSize(rows);
        result.setTotal(count);
        return result;
    }

    @Override
    public void saveEvaluation(Evaluation evaluation) {
        evaluation.setVisible(1);
        Evaluation select = evaluationMapper.selectByPrimaryKey(evaluation.getId());
        if(select == null){
            evaluation.setCreatetime(new Date());
            evaluationMapper.insertSelective(evaluation);
        } else {
            evaluationMapper.updateByPrimaryKeySelective(evaluation);
        }
    }

    @Override
    public void deleteEvaluation(Long id) {
        Evaluation evaluation = new Evaluation();
        evaluation.setVisible(0);
        evaluation.setId(id);
        evaluationMapper.updateByPrimaryKeySelective(evaluation);
    }

    @Override
    public Evaluation getOneEvaluation(Long id) {
        Evaluation evaluation = evaluationMapper.selectByPrimaryKey(id);
        Customer customerById = customerMapper.getCustomerById(evaluation.getCustId());
        evaluation.setCustName(customerById.getCustName());
        return evaluation;
    }
}
