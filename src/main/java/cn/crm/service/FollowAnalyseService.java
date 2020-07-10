package cn.crm.service;

import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.Map;

public interface FollowAnalyseService {

    Map findPieData(Date startTime, Date endTime);
    Map findFollowBar(Date startTime, Date endTime);
    Map findFollowNumAndNot(Date startTime, Date endTime);
}
