package cn.crm.service.impl;

import cn.crm.mapper.FollowAnalyseMapper;
import cn.crm.service.FollowAnalyseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class FollowAnalyseServiceImpl implements FollowAnalyseService {

    @Autowired
    private FollowAnalyseMapper followAnalyseMapper;

    @Override
    public Map findPieData(Date startTime, Date endTime) {
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
        List<Map<String, Object>> businessPie = followAnalyseMapper.selectBusinessPie(start, end);
        List<Map<String, Object>> wayPie = followAnalyseMapper.selectWayPie(start, end);
        //business
        HashMap<String, List> businessMap = new HashMap<>();
        businessMap.put("pieData",businessPie);
        ArrayList<String> list = new ArrayList<>();
        for(Map m : businessPie){
            list.add(m.get("name").toString());
        }
        businessMap.put("content",list);
        //way
        HashMap<String, List> wayMap = new HashMap<>();
        wayMap.put("pieData",wayPie);
        ArrayList<String> wayList = new ArrayList<>();
        for(Map m : wayPie){
            wayList.add(m.get("name").toString());
        }
        wayMap.put("content",wayList);
        HashMap<String, Map> map = new HashMap<>();
        map.put("businessPie",businessMap);
        map.put("wayPie",wayMap);
        return map;
    }

    @Override
    public Map findFollowBar(Date startTime, Date endTime) {
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
        List<Map<String, Object>> followFreBar = followAnalyseMapper.selectFollowFreBar(start, end);
        TreeMap<String, Integer> followFreMap = new TreeMap<>();
        for (Map m : followFreBar) {
            followFreMap.put(m.get("month").toString(),Integer.parseInt(m.get("fre").toString()));
        }
        HashMap<String, Map> map = new HashMap<>();
        map.put("followFreBar",followFreMap);
        return map;
    }

    @Override
    public Map findFollowNumAndNot(Date startTime, Date endTime) {
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
        Map<String, Object> numAndNot = followAnalyseMapper.selectFollowNumAndNot(start, end);
        return numAndNot;
    }
}
