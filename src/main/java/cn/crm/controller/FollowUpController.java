package cn.crm.controller;

import cn.crm.bean.FollowRecord;
import cn.crm.bean.FollowStatus;
import cn.crm.service.FollowService;
import cn.crm.utils.Page;
import com.sun.prism.impl.Disposer;
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
    public String getFollowStatusHtml() {
        return "follow/followStatus";
    }

    @GetMapping("followAdd.html")
    public String getFollowAddHtml() {
        return "follow/followAdd";
    }

    //修改或保存
    @RequestMapping(value = "saveFollowStatus", method = RequestMethod.POST)
    @ResponseBody
    public Map saveFollowStatus(FollowStatus followStatus) {
        HashMap<String, String> map = new HashMap<>();
        //try {
        followService.save(followStatus);
        map.put("msg", "提交保存成功");
        //}catch (Exception e){
        //  map.put("msg","提交保存失败，请检查填写是否正确");
        //}

        return map;
    }

    @RequestMapping(value = "/followStatusList")
    @ResponseBody
    public Page getlist(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer pageSize,
                        FollowStatus followStatus) {

        Page<FollowStatus> followStatusPage = followService.findFollowList(page, pageSize, followStatus.getCustName(),
                followStatus.getCustUserName(), followStatus.getFollowStatus());

        return followStatusPage;
    }

    @PostMapping("editFollowStatus")
    @ResponseBody
    public FollowStatus editFollowStatus(Long id) {
        FollowStatus followStatus = followService.getCustomerFollowStatusById(id);
        return followStatus;
    }

    @PostMapping("stopFollowing")
    @ResponseBody
    public Map stopFollowing(Long id) {
        HashMap<String, String> map = new HashMap<>();
        followService.stopFollowing(id);
        map.put("msg", "停止跟进成功");
        return map;
    }

    @GetMapping("following.html")
    public String getFollowingHtml() {
        return "follow/following";
    }

    @GetMapping("followRecord.html")
    public String getFollowRecordHtml() {
        return "follow/followRecord";
    }
    @GetMapping("followRecordEdit.html")
    public String getFollowRecordEditHtml() {
        return "follow/followRecordEdit";
    }

    //添加跟进记录saveFollowRecord
    @PostMapping("saveFollowRecord")
    @ResponseBody
    public Map saveFollowRecord(FollowRecord followRecord) {
        HashMap<String, String> map = new HashMap<>();
        followService.saveFollowRecord(followRecord);
        map.put("msg","保存成功");
        return map;
    }

    /**
     * followRecordList
     */
    @PostMapping("followRecordList")
    @ResponseBody
    public Page<FollowRecord> followRecordList(@RequestParam(defaultValue="1")Integer page, @RequestParam(defaultValue="3")Integer pageSize,
                                               Long custId, String startTime,String endTime) {
        Page<FollowRecord> recordList = followService.findFollowRecordList(page, pageSize, custId, startTime, endTime, 1);

        return recordList;
    }
    /**
     * deleteRecord
     */
    @PostMapping("deleteRecord")
    @ResponseBody
    public Map deleteRecord(Long id){
        HashMap<String, String> map = new HashMap<>();
        followService.deleteFollowRecord(id);
        map.put("msg","删除成功");
        return map;
    }
    @GetMapping("getOneRecord")
    @ResponseBody
    public FollowRecord getOneRecord(Long id){
        HashMap<String, String> map = new HashMap<>();
        FollowRecord recordByID = followService.getFollowRecordByID(id);
        return recordByID;
    }
}
