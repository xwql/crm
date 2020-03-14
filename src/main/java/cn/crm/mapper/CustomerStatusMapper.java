package cn.crm.mapper;

import cn.crm.bean.CustomerStatus;
import cn.crm.bean.CustomerStatusExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerStatusMapper {
    long countByExample(CustomerStatusExample example);

    int deleteByExample(CustomerStatusExample example);

    int deleteByPrimaryKey(Long custId);

    int insert(CustomerStatus record);

    int insertSelective(CustomerStatus record);

    List<CustomerStatus> selectByExample(CustomerStatusExample example);

    CustomerStatus selectByPrimaryKey(Long custId);

    int updateByExampleSelective(@Param("record") CustomerStatus record, @Param("example") CustomerStatusExample example);

    int updateByExample(@Param("record") CustomerStatus record, @Param("example") CustomerStatusExample example);

    int updateByPrimaryKeySelective(CustomerStatus record);

    int updateByPrimaryKey(CustomerStatus record);
}