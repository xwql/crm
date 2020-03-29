package cn.crm.mapper;

import cn.crm.bean.Contract;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContractMapper {
    int deleteByPrimaryKey(String id);

    int insert(Contract record);

    int insertSelective(Contract record);

    Contract selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Contract record);

    int updateByPrimaryKey(Contract record);

    List<Contract> selectContractList(Contract contract);
    Integer selectContractListCount(Contract contract);
}