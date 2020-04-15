package cn.crm.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;
@Repository
public interface FollowAnalyseMapper {
    List<Map<String,Object>> selectFollowFreBar( @Param("start_time") Date start_time, @Param("end_time") Date end_time);
    List<Map<String,Object>> selectWayPie(@Param("start_time") Date start_time, @Param("end_time") Date end_time);
    List<Map<String,Object>> selectBusinessPie(@Param("start_time") Date start_time, @Param("end_time") Date end_time);

    Map<String,Object> selectFollowNumAndNot(@Param("start_time") Date start_time, @Param("end_time") Date end_time);
}
