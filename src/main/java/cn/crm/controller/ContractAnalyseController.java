package cn.crm.controller;

import cn.crm.service.ContractAnalyseService;
import cn.crm.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.Map;
@Controller
public class ContractAnalyseController {


    @Autowired
    private ContractAnalyseService contractAnalyseService;
    @PostMapping("contract/getAllSingleData")
    @ResponseBody
    public Map getAllSingleData(Date start_time, Date end_time){

     return contractAnalyseService.findAllSingleData(start_time, end_time);
    }
    @PostMapping("contract/getContractBar")
    @ResponseBody
    public Map getContractBar(Date start_time,  Date end_time){
        return contractAnalyseService.findContractBar(start_time, end_time);
    }
}
