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
    public Map getAllSingleData(Date startTime,Date endTime){
        Map data = customerAnalyseService.findAllSingleData(startTime, endTime);
        return data;
        //return null;
    }

    @PostMapping("customerLineData")
    @ResponseBody
    public Map getCustomerLineData(Date startTime,Date endTime){
        Map data = customerAnalyseService.findCustomerLineData(startTime, endTime);
        return data;
    }
    @PostMapping("customerPieData")
    @ResponseBody
    public Map getCustomerPieData(Date startTime,Date endTime){
        Map data = customerAnalyseService.findCustomerPieData(startTime, endTime);
        return data;
    }
}
