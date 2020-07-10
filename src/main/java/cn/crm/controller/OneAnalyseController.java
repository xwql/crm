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
    public Map getAllSingleData(Long custId, Date startTime, Date endTime){
        Map allSingleData = oneAnalyseService.findAllSingleData(custId, startTime, endTime);
        return allSingleData;
    }
    @PostMapping("one/getOneBarData")
    @ResponseBody
    public Map getOneBarData(Long custId, Date startTime, Date endTime){
        return oneAnalyseService.findOneBarData(custId, startTime, endTime);
    }

    @PostMapping("one/getWayPieData")
    @ResponseBody
    public Map getWayPieData(Long custId, Date startTime, Date endTime){
        return oneAnalyseService.findWayPieData(custId, startTime, endTime);
    }
}
