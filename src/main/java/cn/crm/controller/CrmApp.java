package cn.crm.controller;

import cn.crm.utils.FileToJson;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;

@Controller
public class CrmApp {
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView show(){
        return new ModelAndView("index");
    }

    @RequestMapping(value = "/analyse.html", method = RequestMethod.GET)
    public ModelAndView show1(){
        return new ModelAndView("analyse");
    }

    @RequestMapping(value = "/customerManage1.html", method = RequestMethod.GET)
    public String customerManage(){
        return "customerManage";
    }

    @RequestMapping(value = "/customerAdd.html", method = RequestMethod.GET)
    public String show2(){
        return "customer/customerAdd";
    }

    @RequestMapping(value = "/customerDelete.html", method = RequestMethod.GET)
    public String deleteCustomer(){
        return "customer/customerDelete";
    }

    @RequestMapping(value = "/edit.html", method = RequestMethod.GET)
    public String editTest(){
        return "page/table/edit";
    }

    @RequestMapping(value = "/message.html", method = RequestMethod.GET)
    public String message(){
        return "message/message";
    }

    @RequestMapping(value = "/page/404.html", method = RequestMethod.GET)
    public String to404(){
        return "page/404";
    }

    @RequestMapping(value = "customerAnalyse.html", method = RequestMethod.GET)
    public String getCustomerAnalyse(){
        return "analyse/customerAnalyse";
    }

    @RequestMapping(value = "contractAnalyse.html", method = RequestMethod.GET)
    public String getContractAnalyse(){
        return "analyse/contractAnalyse";
    }

    @RequestMapping(value = "followAnalyse.html", method = RequestMethod.GET)
    public String getFollowAnalyse(){
        return "analyse/followAnalyse";
    }

    @RequestMapping(value = "evaluationAnalyse.html", method = RequestMethod.GET)
    public String getEvaluationAnalyse(){
        return "analyse/evaluationAnalyse";
    }

    @RequestMapping(value = "oneCustomerAnalyse.html", method = RequestMethod.GET)
    public String oneCustomerAnalyse(){
        return "analyse/oneCustomerAnalyse";
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    @GetMapping("init.json")
    @ResponseBody
    public JSONObject initJson() throws IOException {
        return FileToJson.fileToJson("src/main/resources/static/api/init.json");
    }
}
