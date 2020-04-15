package cn.crm.service.impl;

import cn.crm.mapper.OneAnalyseMapper;
import cn.crm.service.OneAnalyseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OneAnalyseServiceImpl implements OneAnalyseService {

    @Autowired
    private OneAnalyseMapper oneAnalyseMapper;
    @Override
    public Map findAllSingleData(Long cust_id, Date start_time, Date end_time) {
        Date start = null;
        Date end = null;
        if(start_time == null || end_time == null) {
            Calendar instance = Calendar.getInstance();
            end = new Date();
            instance.setTime(end);
            instance.add(Calendar.YEAR, -1);
            start = instance.getTime();
        } else {
            start = start_time;
            end = end_time;
        }
        Map<String, Object> contractData = oneAnalyseMapper.selectContractData(cust_id, start, end);
        List<Map<String, Object>> maps = oneAnalyseMapper.selectEvaluationAvgAndNum(cust_id, start, end);
        Map<String, Object> status = oneAnalyseMapper.selectStatus(cust_id);
        HashMap<String, Object> map = new HashMap<>();
        map.put("cust_source",status.get("cust_source"));
        map.put("cust_industry",status.get("cust_industry"));
        map.put("cust_level",status.get("cust_level"));
        map.put("cust_status",status.get("cust_status"));
        map.put("business_status",status.get("business_status"));
        map.put("cust_property",status.get("cust_property"));
        for (Map m:maps){
            if(m.get("to_object").equals("客户对公司")) {
                map.put("cust_scoreAvg", m.get("scoreAvg"));
                map.put("cust_num",m.get("num"));
            }else {
                map.put("self_scoreAvg", m.get("scoreAvg"));
                map.put("self_num",m.get("num"));
            }
        }
        map.put("money",contractData.get("money"));
        map.put("contractNum",contractData.get("contractNum"));
        return map;
    }

    @Override
    public Map findOneBarData(Long cust_id, Date start_time, Date end_time) {
        Date start = null;
        Date end = null;
        if(start_time == null || end_time == null) {
            Calendar instance = Calendar.getInstance();
            end = new Date();
            instance.setTime(end);
            instance.add(Calendar.YEAR, -1);
            start = instance.getTime();
        } else {
            start = start_time;
            end = end_time;
        }
        List<Map<String, Object>> contractBar = oneAnalyseMapper.selectContractBar(cust_id, start, end);
        List<Map<String, Object>> followFreBar = oneAnalyseMapper.selectFollowFreBar(cust_id, start, end);
        TreeMap<String, Integer> contractMap = new TreeMap<>();
        TreeMap<String, Integer> followFreMap = new TreeMap<>();
        for (Map m : contractBar) {
            contractMap.put(m.get("month").toString(),Integer.parseInt(m.get("money").toString()));
        }
        for (Map m : followFreBar) {
            followFreMap.put(m.get("month").toString(),Integer.parseInt(m.get("fre").toString()));
        }
        HashMap<String, Map> map = new HashMap<>();
        map.put("contractBar",contractMap);
        map.put("followFreBar",followFreMap);
        return map;
    }

    @Override
    public Map findWayPieData(Long cust_id, Date start_time, Date end_time) {
        Date start = null;
        Date end = null;
        if(start_time == null || end_time == null) {
            Calendar instance = Calendar.getInstance();
            end = new Date();
            instance.setTime(end);
            instance.add(Calendar.YEAR, -1);
            start = instance.getTime();
        } else {
            start = start_time;
            end = end_time;
        }
        List<Map<String, Object>> maps = oneAnalyseMapper.selectWayPie(cust_id, start, end);
        HashMap<String, List> map = new HashMap<>();
        map.put("pieData",maps);
        ArrayList<String> list = new ArrayList<>();
        for(Map m : maps){
            list.add(m.get("name").toString());
        }
        map.put("content",list);
        return map;
    }
}
