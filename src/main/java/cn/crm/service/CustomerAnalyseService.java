package cn.crm.service;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.Map;

public interface CustomerAnalyseService {
    Map findAllSingleData(Date startTime, Date endTime);
    Map findCustomerLineData(Date startTime, Date endTime);
    Map findCustomerPieData(Date startTime, Date endTime);
}
