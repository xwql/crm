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
    public Map getPieData(Date start_time,Date end_time){
        return followAnalyseService.findPieData(start_time, end_time);
    }

    @PostMapping("followAnalyse/getFollowBar")
    @ResponseBody
    public Map getFollowBar(Date start_time,Date end_time){
        return followAnalyseService.findFollowBar(start_time, end_time);
    }

    @PostMapping("followAnalyse/getFollowNumAndNot")
    @ResponseBody
    public Map getFollowNumAndNot(Date start_time,Date end_time){
        return followAnalyseService.findFollowNumAndNot(start_time, end_time);
    }
}
