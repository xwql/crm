package cn.crm.controller;

import cn.crm.bean.Customer;
import cn.crm.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Controller
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @RequestMapping(value = "/saveCustomer",method= RequestMethod.POST)
    @ResponseBody
    public Map saveCustomer(Customer customer) {
        HashMap<Object, Object> map = new HashMap<>();
        customerService.saveCustomer(customer);
        map.put("msg","成功");
        return map;
    }
}
