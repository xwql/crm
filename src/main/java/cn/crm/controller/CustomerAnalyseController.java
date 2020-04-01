package cn.crm.controller;

import cn.crm.service.CustomerAnalyseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.Map;

@Controller
public class CustomerAnalyseController {

    @Autowired
    CustomerAnalyseService customerAnalyseService;
    @PostMapping("allSingleData")
    @ResponseBody
    public Map getAllSingleData(Date start_time,Date end_time){
        Map data = customerAnalyseService.findAllSingleData(start_time, end_time);
        return data;
        //return null;
    }

    @PostMapping("customerLineData")
    @ResponseBody
    public Map getCustomerLineData(Date start_time,Date end_time){
        Map data = customerAnalyseService.findCustomerLineData(start_time, end_time);
        return data;
    }
    @PostMapping("customerPieData")
    @ResponseBody
    public Map getCustomerPieData(Date start_time,Date end_time){
        Map data = customerAnalyseService.findCustomerPieData(start_time, end_time);
        return data;
    }
}
