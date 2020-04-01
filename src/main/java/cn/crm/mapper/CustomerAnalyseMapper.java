package cn.crm.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository
public interface CustomerAnalyseMapper {
    List<Map<String,Object>> customerLineData(@Param("start_time") Date start_time, @Param("end_time") Date end_time);

    int selectCustomerCreateNum(@Param("start_time") Date start_time, @Param("end_time") Date end_time);

    int selectCustomerVipNum(@Param("start_time") Date start_time, @Param("end_time") Date end_time);

    List<Map<String,Object>> selectCustomerSource(@Param("start_time") Date start_time, @Param("end_time") Date end_time);

    int selectCustomerRecordNum(@Param("start_time") Date start_time, @Param("end_time") Date end_time);

    int selectCustomerContractNum(@Param("start_time") Date start_time, @Param("end_time") Date end_time);
    //客户减少数
    int selectDecrCustomerNum(@Param("start_time") Date start_time, @Param("end_time") Date end_time);
}
