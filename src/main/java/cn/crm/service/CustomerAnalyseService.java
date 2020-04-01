package cn.crm.service;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.Map;

public interface CustomerAnalyseService {
    Map findAllSingleData(Date start_time, Date end_time);
    Map findCustomerLineData(Date start_time, Date end_time);
    Map findCustomerPieData(Date start_time, Date end_time);
}
