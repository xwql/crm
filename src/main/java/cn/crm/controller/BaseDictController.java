package cn.crm.controller;

import cn.crm.bean.BaseDict;
import cn.crm.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class BaseDictController {

    @Autowired
    SystemService systemService;
    //来源类别
    @RequestMapping("getSourceType")
    @ResponseBody
    public Map<String, String> getSourceList(){
        List<BaseDict> baseDictListByType = systemService.findBaseDictListByType("002");
        HashMap<String, String> map = new HashMap<>();
        for (BaseDict b: baseDictListByType) {
            map.put(b.getDict_id(),b.getDict_item_name());
        }
        return map;
    }

    //行业类别
    @RequestMapping("getBaseDictType")
    @ResponseBody
    public Map getIndustryList(){
        List<BaseDict> industryType = systemService.findBaseDictListByType("001");
        List<BaseDict> sourceType = systemService.findBaseDictListByType("002");
        List<BaseDict> levelType = systemService.findBaseDictListByType("006");
        HashMap<String, Map> map = new HashMap<>();
        HashMap<String, String> industryMap = new HashMap<>();
        HashMap<String, String> sourceMap = new HashMap<>();
        HashMap<String, String> levelMap = new HashMap<>();
        for (BaseDict b: industryType) {

            industryMap.put(b.getDict_id(),b.getDict_item_name());
        }
        for(BaseDict b: sourceType){
            sourceMap.put(b.getDict_id(),b.getDict_item_name());
        }
        for(BaseDict b: levelType){
            levelMap.put(b.getDict_id(),b.getDict_item_name());
        }
        map.put("cust_level",levelMap);
        map.put("cust_source",sourceMap);
        map.put("cust_industry",industryMap);
       /* HashMap<String, List> map = new HashMap<>();
        ArrayList<String> industryList = new ArrayList<>();
        ArrayList<String> sourceList = new ArrayList<>();
        ArrayList<String> levelList = new ArrayList<>();
        for (BaseDict b: industryType) {

            industryList.add(b.getDict_item_name());
        }
        for(BaseDict b: sourceType){
            sourceList.add(b.getDict_item_name());
        }
        for(BaseDict b: levelType){
            levelList.add(b.getDict_item_name());
        }
        map.put("cust_level",levelList);
        map.put("cust_source",sourceList);
        map.put("cust_industry",industryList);*/
        return map;
    }

    //级别类别
    @RequestMapping("getLevelType")
    @ResponseBody
    public Map getLevelType(){
        List<BaseDict> baseDictListByType = systemService.findBaseDictListByType("006");
        HashMap<String, String> map = new HashMap<>();
        for (BaseDict b: baseDictListByType) {
            map.put(b.getDict_id(),b.getDict_item_name());
        }
        return map;
    }
}
