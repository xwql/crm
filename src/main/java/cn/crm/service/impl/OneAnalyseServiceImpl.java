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
    public Map findAllSingleData(Long custId, Date startTime, Date endTime) {
        Date start = null;
        Date end = null;
        if(startTime == null || endTime == null) {
            Calendar instance = Calendar.getInstance();
            end = new Date();
            instance.setTime(end);
            instance.add(Calendar.YEAR, -1);
            start = instance.getTime();
        } else {
            start = startTime;
            end = endTime;
        }
        Map<String, Object> contractData = oneAnalyseMapper.selectContractData(custId, start, end);
        List<Map<String, Object>> maps = oneAnalyseMapper.selectEvaluationAvgAndNum(custId, start, end);
        Map<String, Object> status = oneAnalyseMapper.selectStatus(custId);
        HashMap<String, Object> map = new HashMap<>();
        map.put("custSource",status.get("custSource"));
        map.put("custIndustry",status.get("custIndustry"));
        map.put("custLevel",status.get("custLevel"));
        map.put("custStatus",status.get("custStatus"));
        map.put("businessStatus",status.get("businessStatus"));
        map.put("custProperty",status.get("custProperty"));
        for (Map m:maps){
            if(m.get("toObject").equals("客户对公司")) {
                map.put("custScoreAvg", m.get("scoreAvg"));
                map.put("custNum",m.get("num"));
            }else {
                map.put("selfScoreAvg", m.get("scoreAvg"));
                map.put("selfNum",m.get("num"));
            }
        }
        map.put("money",contractData.get("money"));
        map.put("contractNum",contractData.get("contractNum"));
        return map;
    }

    @Override
    public Map findOneBarData(Long custId, Date startTime, Date endTime) {
        Date start = null;
        Date end = null;
        if(startTime == null || endTime == null) {
            Calendar instance = Calendar.getInstance();
            end = new Date();
            instance.setTime(end);
            instance.add(Calendar.YEAR, -1);
            start = instance.getTime();
        } else {
            start = startTime;
            end = endTime;
        }
        List<Map<String, Object>> contractBar = oneAnalyseMapper.selectContractBar(custId, start, end);
        List<Map<String, Object>> followFreBar = oneAnalyseMapper.selectFollowFreBar(custId, start, end);
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
    public Map findWayPieData(Long custId, Date startTime, Date endTime) {
        Date start = null;
        Date end = null;
        if(startTime == null || endTime == null) {
            Calendar instance = Calendar.getInstance();
            end = new Date();
            instance.setTime(end);
            instance.add(Calendar.YEAR, -1);
            start = instance.getTime();
        } else {
            start = startTime;
            end = endTime;
        }
        List<Map<String, Object>> maps = oneAnalyseMapper.selectWayPie(custId, start, end);
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
