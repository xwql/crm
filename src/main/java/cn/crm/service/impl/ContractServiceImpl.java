package cn.crm.service.impl;

import cn.crm.bean.Contract;
import cn.crm.mapper.ContractMapper;
import cn.crm.service.ContractService;
import cn.crm.utils.DateUtils;
import cn.crm.utils.Page;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("contractService")
public class ContractServiceImpl implements ContractService {

    @Autowired
    ContractMapper contractMapper;

    @Override
    public Page<Contract> findContractList(Integer page, Integer rows, Long custID, String startTime, String endTime, Integer enable) {
        Contract contract = new Contract();
        Date start = null;
        if(StringUtils.isNotEmpty(startTime)) {
            start = DateUtils.stringToDate(startTime);
        }
        Date end = null;
        if(StringUtils.isNotEmpty(endTime)){
            end = DateUtils.stringToDate(endTime);
        }
        if(custID != null){
            contract.setCustId(custID);
        }
        contract.setStartTime(start);
        contract.setEndTime(end);
        contract.setEnable(enable);
        contract.setStart((page-1) * rows) ;
        //每页行数
        contract.setRows(rows);
        //查询列表
        List<Contract> messages = contractMapper.selectContractList(contract);
        //查询总记录数
        Integer count = contractMapper.selectContractListCount(contract);
        //创建Page返回对象
        Page<Contract> result = new Page<>();
        result.setPage(page);
        result.setRows(messages);
        result.setSize(rows);
        result.setTotal(count);
        return result;
    }

    @Override
    public void saveContract(Contract contract) {
        contract.setEnable(1);
        Contract select = contractMapper.selectByPrimaryKey(contract.getId());
        if(select == null){
            contractMapper.insertSelective(contract);
        } else {
            contractMapper.updateByPrimaryKeySelective(contract);
        }
    }

    @Override
    public void deleteContract(String id) {
        Contract contract = new Contract();
        contract.setEnable(0);
        contract.setId(id);
        contractMapper.updateByPrimaryKeySelective(contract);
    }

    @Override
    public Contract getOneContract(String id) {
        Contract contract = contractMapper.selectByPrimaryKey(id);
        return contract;
    }
}
