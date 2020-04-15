package cn.crm.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;
@Repository
public interface OneAnalyseMapper {
    /**
     * 客户信息状态数据
     * @param cust_id
     * @return
     */
    Map<String,Object> selectStatus(@Param("cust_id")Long cust_id);

    /**
     *评分
     */
    List<Map<String,Object>> selectEvaluationAvgAndNum(@Param("cust_id")Long cust_id, @Param("start_time") Date start_time, @Param("end_time") Date end_time);

    List<Map<String,Object>> selectWayPie(@Param("cust_id")Long cust_id,@Param("start_time") Date start_time, @Param("end_time") Date end_time);

    List<Map<String,Object>> selectFollowFreBar(@Param("cust_id")Long cust_id,@Param("start_time") Date start_time, @Param("end_time") Date end_time);

    Map<String,Object> selectContractData(@Param("cust_id")Long cust_id, @Param("start_time") Date start_time, @Param("end_time") Date end_time);

    List<Map<String,Object>> selectContractBar(@Param("cust_id")Long cust_id, @Param("start_time") Date start_time, @Param("end_time") Date end_time);
}
