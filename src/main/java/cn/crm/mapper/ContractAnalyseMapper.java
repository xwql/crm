package cn.crm.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository
public interface ContractAnalyseMapper {
    Map<String,Object> selectAllSingleData(@Param("start_time") Date start_time, @Param("end_time") Date end_time);
    List<Map<String,Object>> selectContractBar(@Param("start_time") Date start_time, @Param("end_time") Date end_time);
}
