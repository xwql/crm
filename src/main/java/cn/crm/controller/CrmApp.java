package cn.crm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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

    @RequestMapping(value = "/customerManage.html", method = RequestMethod.GET)
    public String show2(){
        return "customerManage";
    }
}
