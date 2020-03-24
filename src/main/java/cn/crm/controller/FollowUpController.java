package cn.crm.controller;

import cn.crm.bean.FollowStatus;
import cn.crm.service.FollowService;
import cn.crm.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
public class FollowUpController {

    @Autowired
    FollowService followService;

    @GetMapping("followStatus.html")
    public String getFollowStatusHtml(){
        return "follow/followStatus";
    }

    @GetMapping("followAdd.html")
    public String getFollowAddHtml(){
        return "follow/followAdd";
    }

    //修改或保存
    @RequestMapping(value = "saveFollowStatus",method = RequestMethod.POST)
    @ResponseBody
    public Map saveFollowStatus(FollowStatus followStatus){
        HashMap<String, String> map = new HashMap<>();
        //try {
            followService.save(followStatus);
            map.put("msg","提交保存成功");
        //}catch (Exception e){
          //  map.put("msg","提交保存失败，请检查填写是否正确");
        //}

        return map;
    }

    @RequestMapping(value = "/followStatusList")
    @ResponseBody
    public Page getlist(@RequestParam(defaultValue="1")Integer page, @RequestParam(defaultValue="10")Integer pageSize,
                        FollowStatus followStatus) {

        Page<FollowStatus> followStatusPage = followService.findFollowList(page, pageSize, followStatus.getCust_name(),
                followStatus.getCust_user_name(),followStatus.getFollow_status());

        return followStatusPage;
    }

    @PostMapping("editFollowStatus")
    @ResponseBody
    public FollowStatus editFollowStatus(Long id){
        FollowStatus followStatus = followService.getCustomerFollowStatusById(id);
        return followStatus;
    }

    @PostMapping("stopFollowing")
    @ResponseBody
    public Map stopFollowing(Long id){
        HashMap<String, String> map = new HashMap<>();
        followService.stopFollowing(id);
        map.put("msg","停止跟进成功");
        return map;
    }
}
