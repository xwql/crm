package cn.crm.service;

import java.util.Date;
import java.util.Map;

public interface OneAnalyseService {
    Map findAllSingleData(Long custId, Date startTime, Date endTime);
    Map findOneBarData(Long custId, Date startTime, Date endTime);
    Map findWayPieData(Long custId, Date startTime, Date endTime);

}
