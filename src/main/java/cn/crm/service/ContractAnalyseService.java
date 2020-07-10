package cn.crm.service;

import java.util.Date;
import java.util.Map;

public interface ContractAnalyseService {
    Map findAllSingleData( Date startTime, Date endTime);
    Map findContractBar(Date startTime,  Date endTime);
}
