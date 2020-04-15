package cn.crm.service.impl;

import cn.crm.mapper.ContractAnalyseMapper;
import cn.crm.service.ContractAnalyseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ContractAnalyseServiceImpl implements ContractAnalyseService {

    @Autowired
    private ContractAnalyseMapper contractAnalyseMapper;

    @Override
    public Map findAllSingleData(Date start_time, Date end_time) {
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
        Map<String, Object> allSingleData = contractAnalyseMapper.selectAllSingleData(start, end);

        return allSingleData;
    }

    @Override
    public Map findContractBar(Date start_time, Date end_time) {
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
        List<Map<String, Object>> contractBar = contractAnalyseMapper.selectContractBar(start, end);
        TreeMap<String, Integer> contractMap = new TreeMap<>();
        for (Map m : contractBar) {
            contractMap.put(m.get("month").toString(),Integer.parseInt(m.get("money").toString()));
        }
        HashMap<String, Map> map = new HashMap<>();
        map.put("contractBar",contractMap);
        return map;
    }
}
