package cn.crm.controller;

import cn.crm.service.FollowAnalyseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.Map;
@Controller
public class FollowAnalyseController {

    @Autowired
    private FollowAnalyseService followAnalyseService;
    @PostMapping("followAnalyse/getPieData")
    @ResponseBody
    public Map getPieData(Date startTime,Date endTime){
        return followAnalyseService.findPieData(startTime, endTime);
    }

    @PostMapping("followAnalyse/getFollowBar")
    @ResponseBody
    public Map getFollowBar(Date startTime,Date endTime){
        return followAnalyseService.findFollowBar(startTime, endTime);
    }

    @PostMapping("followAnalyse/getFollowNumAndNot")
    @ResponseBody
    public Map getFollowNumAndNot(Date startTime,Date endTime){
        return followAnalyseService.findFollowNumAndNot(startTime, endTime);
    }
}
