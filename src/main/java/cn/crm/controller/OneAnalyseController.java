package cn.crm.controller;

import cn.crm.service.OneAnalyseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.Map;
@Controller
public class OneAnalyseController {
    @Autowired
    private OneAnalyseService oneAnalyseService;
    @PostMapping("one/getAllSingleData")
    @ResponseBody
    public Map getAllSingleData(Long cust_id, Date start_time, Date end_time){
        Map allSingleData = oneAnalyseService.findAllSingleData(cust_id, start_time, end_time);
        return allSingleData;
    }
    @PostMapping("one/getOneBarData")
    @ResponseBody
    public Map getOneBarData(Long cust_id, Date start_time, Date end_time){
        return oneAnalyseService.findOneBarData(cust_id, start_time, end_time);
    }

    @PostMapping("one/getWayPieData")
    @ResponseBody
    public Map getWayPieData(Long cust_id, Date start_time, Date end_time){
        return oneAnalyseService.findWayPieData(cust_id, start_time, end_time);
    }
}
