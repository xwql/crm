package cn.crm.service.impl;

import cn.crm.mapper.CustomerAnalyseMapper;
import cn.crm.service.CustomerAnalyseService;
import cn.crm.utils.MiddleMonth;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.*;

@Service("customerAnalyseService")
public class CustomerAnalyseServiceImpl implements CustomerAnalyseService {

    @Autowired
    CustomerAnalyseMapper customerAnalyseMapper;
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
        int contractNum = customerAnalyseMapper.selectCustomerContractNum(start, end);
        int incrCustomerNum = customerAnalyseMapper.selectCustomerCreateNum(start, end);
        int followNum = customerAnalyseMapper.selectCustomerRecordNum(start, end);
        int incrCustomerVIPPer = customerAnalyseMapper.selectCustomerVipNum(start, end);
        double incrVip = (incrCustomerVIPPer*1.0/incrCustomerNum)*100;
        int allCustomerNum = customerAnalyseMapper.selectCustomerCreateNum(null,null);
        int allCustomerVIPPer = customerAnalyseMapper.selectCustomerVipNum(null,null);
        double allVIP = (allCustomerVIPPer*1.0/allCustomerNum) * 100;
        int allDecrCustomerNum = customerAnalyseMapper.selectDecrCustomerNum(null,null);
        int decrCustomerNum = customerAnalyseMapper.selectDecrCustomerNum(start,end);
        HashMap<String, Integer> map = new HashMap<>();
        map.put("incrCustomerNum",incrCustomerNum);
        map.put("incrCustomerVIPPer",(int)incrVip);
        map.put("decrCustomerNum",decrCustomerNum);
        map.put("followNum",followNum);
        map.put("contractNum",contractNum);
        map.put("allCustomerNum",allCustomerNum);
        map.put("allCustomerVIPPer",(int)allVIP);
        map.put("allDecrCustomerNum",allDecrCustomerNum);
        return map;
    }
    @Test
    public void test(){
        Calendar instance = Calendar.getInstance();
        Date end = new Date();
        instance.setTime(end);
        instance.add(Calendar.YEAR, -1);
        Date start = instance.getTime();
        System.out.println("start = " + start);
        System.out.println("end = " + end);
    }

    @Override
    public Map findCustomerLineData(Date start_time, Date end_time) {
        Date start = null;
        Date end = null;
        if(start_time == null || end_time == null) {
            Calendar instance = Calendar.getInstance();
            instance.setTime(new Date());
            instance.add(Calendar.YEAR, -1);
            start = instance.getTime();
            instance.add(Calendar.YEAR, 1);
            instance.add(Calendar.MONTH,1);
            end = instance.getTime();
        } else {
            start = start_time;
            end = end_time;
        }
        //System.out.println("end = " + end);
        List<Map<String, Object>> maps = customerAnalyseMapper.customerLineData(start, end);
        //System.out.println("maps = " + maps);
        TreeMap<String, Integer> mapIncr = new TreeMap<>();
        TreeMap<String, Integer> mapDecr = new TreeMap<>();
        for(Map<String,Object> m : maps){
            mapIncr.put(m.get("month").toString() ,Integer.parseInt(m.get("customernum").toString()));
            mapDecr.put(m.get("month").toString() ,Integer.parseInt(m.get("decrease").toString()));
        }

        HashMap<String, Map> incrAndDecr = new HashMap<>();
        incrAndDecr.put("increase",mapIncr);
        incrAndDecr.put("decrease",mapDecr);
        return incrAndDecr;
    }

    @Override
    public Map findCustomerPieData(Date start_time, Date end_time) {
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
        List<Map<String, Object>> maps = customerAnalyseMapper.selectCustomerSource(start, end);
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
