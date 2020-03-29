package cn.crm.service;

import cn.crm.bean.Contract;
import cn.crm.utils.Page;

public interface ContractService {
    /**
     * 列表
     */
    Page<Contract> findContractList(Integer page, Integer rows, Long custID, String startTime,String endTime, Integer enable);
    /**
     * 保存或编辑
     */
    void saveContract(Contract contract);
    /**
     * 删除(不删除数据)
     */
    void deleteContract(String id);
    /**
     * 回显一条评价
     */
    Contract getOneContract(String id);
}
