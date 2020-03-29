package cn.crm.controller;

import cn.crm.bean.Contract;
import cn.crm.service.ContractService;
import cn.crm.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;
@Controller
public class ContractController {

    @Autowired
    ContractService contractService;

    @GetMapping("contract.html")
    public String getContractHtml(){
        return "contract/contract";
    }
    @GetMapping("contractAdd.html")
    public String getContractAddHtml(){
        return "contract/contractAdd";
    }
    /**
     * contractList
     */
    @PostMapping("contractList")
    @ResponseBody
    public Page<Contract> getContractList(@RequestParam(defaultValue="1")Integer page, @RequestParam(defaultValue="10")Integer pageSize,
                                          Long cust_id, String start_time, String end_time){
        //HashMap<String, String> map = new HashMap<>();
        Page<Contract> contractList = contractService.findContractList(page, pageSize, cust_id, start_time, end_time, 1);
        return contractList;
    }

    /**
     * saveContract
     */
    @PostMapping("saveContract")
    @ResponseBody
    public Map saveContract(Contract contract){
        HashMap<String, String> map = new HashMap<>();
        contractService.saveContract(contract);
        map.put("msg","保存成功");
        return map;
    }
    /**
     * deleteContract
     */
    @PostMapping("deleteContract")
    @ResponseBody
    public Map deleteContract(String id){
        HashMap<String, String> map = new HashMap<>();
        contractService.deleteContract(id);
        map.put("msg","删除成功");
        return map;
    }

    /**
     * getOneContract，返回一条记录
     */
    @PostMapping("getOneContract")
    @ResponseBody
    public Contract getOneContract(String id){
        Contract oneContract = contractService.getOneContract(id);
        return oneContract;
    }
}
