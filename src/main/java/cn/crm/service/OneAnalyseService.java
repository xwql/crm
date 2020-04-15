package cn.crm.service;

import java.util.Date;
import java.util.Map;

public interface OneAnalyseService {
    Map findAllSingleData(Long cust_id, Date start_time, Date end_time);
    Map findOneBarData(Long cust_id, Date start_time, Date end_time);
    Map findWayPieData(Long cust_id, Date start_time, Date end_time);

}
