package cn.crm.service;

import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.Map;

public interface FollowAnalyseService {

    Map findPieData(Date start_time, Date end_time);
    Map findFollowBar(Date start_time, Date end_time);
    Map findFollowNumAndNot(Date start_time, Date end_time);
}
