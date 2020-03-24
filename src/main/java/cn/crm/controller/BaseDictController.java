package cn.crm.controller;

import cn.crm.bean.BaseDict;
import cn.crm.service.SystemService;
import cn.crm.utils.Page;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    public Map<Long, String> getSourceList(){
        List<BaseDict> baseDictListByType = systemService.findBaseDictListByType("002");
        HashMap<Long, String> map = new HashMap<>();
        for (BaseDict b: baseDictListByType) {
            map.put(b.getId(),b.getItem_name());
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
        HashMap<Long, String> industryMap = new HashMap<>();
        HashMap<Long, String> sourceMap = new HashMap<>();
        HashMap<Long, String> levelMap = new HashMap<>();
        for (BaseDict b: industryType) {

            industryMap.put(b.getId(),b.getItem_name());
        }
        for(BaseDict b: sourceType){
            sourceMap.put(b.getId(),b.getItem_name());
        }
        for(BaseDict b: levelType){
            levelMap.put(b.getId(),b.getItem_name());
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
        HashMap<Long, String> map = new HashMap<>();
        for (BaseDict b: baseDictListByType) {
            map.put(b.getId(),b.getItem_name());
        }
        return map;
    }

    @RequestMapping(value = "dictionary.html", method = RequestMethod.GET)
    public String getDictManageHtml(){
        return "baseDict/dictionary";
    }

    @RequestMapping(value = "baseDictAdd.html", method = RequestMethod.GET)
    public String getDictAddHtml(){
        return "baseDict/baseDictAdd";
    }

    @RequestMapping(value = "getBaseDictList", method = RequestMethod.POST)
    @ResponseBody
    public Page getBaseDictList(@RequestParam(defaultValue="1")Integer page, @RequestParam(defaultValue="10")Integer pageSize,
                                 String type_code, String type_name){
        Page<BaseDict> baseDicts = systemService.findBaseDictList(page,pageSize,type_code,type_name);
        return baseDicts;
    }

    @RequestMapping(value = "getAllTypeName", method = RequestMethod.GET)
    @ResponseBody
    public List<BaseDict> getAllTypeName(){
        return systemService.findAllTypeName();
    }

    /**
     * 添加或编辑saveDict
     * @param baseDict
     * @return
     */
    @RequestMapping(value = "/saveDict",method= RequestMethod.POST)
    @ResponseBody
    public Map saveDict(BaseDict baseDict) {
        HashMap<String, String> map = new HashMap<>();
        //BaseDict dictById = systemService.findBaseDictById(baseDict.getId());
        try {
            if (baseDict.getId() != null) {
                systemService.updateBaseDictById(baseDict);
                map.put("msg", "修改成功");
            } else {
                systemService.saveBaseDict(baseDict);
                map.put("msg", "添加成功");
            }
        }catch (Exception e){
            map.put("msg","操作失败，请查看数据填写是否正确");
        }
        return map;
    }
    //跟进状态字典
    @GetMapping("getFollowDict")
    @ResponseBody
    public Map getFollowDict(){
        List<BaseDict> custType = systemService.findBaseDictListByType("005");
        List<BaseDict> businessType = systemService.findBaseDictListByType("007");
        List<BaseDict> propertyType = systemService.findBaseDictListByType("003");
        HashMap<String, Map> map = new HashMap<>();
        HashMap<Long, String> custMap = new HashMap<>();
        HashMap<Long, String> businessMap = new HashMap<>();
        HashMap<Long, String> propertyMap = new HashMap<>();
        for (BaseDict b: custType) {

            custMap.put(b.getId(),b.getItem_name());
        }
        for(BaseDict b: businessType){
            businessMap.put(b.getId(),b.getItem_name());
        }
        for(BaseDict b: propertyType){
            propertyMap.put(b.getId(),b.getItem_name());
        }
        map.put("cust_status",custMap);
        map.put("business_status",businessMap);
        map.put("cust_property",propertyMap);
        return map;
    }

}
