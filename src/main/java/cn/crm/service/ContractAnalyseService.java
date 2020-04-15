package cn.crm.service;

import java.util.Date;
import java.util.Map;

public interface ContractAnalyseService {
    Map findAllSingleData( Date start_time, Date end_time);
    Map findContractBar(Date start_time,  Date end_time);
}
