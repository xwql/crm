package cn.crm.controller;

import cn.crm.bean.BaseDict;
import cn.crm.bean.Customer;
import cn.crm.bean.CustomerStatus;
import cn.crm.service.CustomerService;
import cn.crm.service.SystemService;
import cn.crm.utils.Page;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

@Controller
public class CustomerController {

    @Autowired
    CustomerService customerService;
    @Autowired
    private SystemService systemService;


    //@Value("${base_dict.source}")
    @Value("002")
    private String FROM_TYPE;
    //@Value("${base_dict.industry}")
    @Value("001")
    private String INDUSTRY_TYPE;
    //@Value("${base_dict.level}")
    @Value("006")
    private String LEVEL_TYPE;

    /**
     * 添加或编辑
     * @param customer
     * @return
     */
    @RequestMapping(value = "/saveCustomer",method= RequestMethod.POST)
    @ResponseBody
    public Map saveCustomer(Customer customer) {
        HashMap<String, String> map = new HashMap<>();
        Customer customerById = customerService.getCustomerById(customer.getCust_id());
        if(customerById!=null) {
            customerService.updateCustomer(customer);
            map.put("msg","修改成功");
        }else {
            customerService.saveCustomer(customer);
            map.put("msg", "添加成功");
        }
        return map;
    }
    // 依赖注入


    @RequestMapping(value = "/customer")
    public String showCumtomer() {
        return "redirect:/customerManage.html";
    }

    // 客户列表
    @RequestMapping(value = "/customerManage.html")
    public String list(){
        return "customerManage";
    }


            /*@RequestParam(defaultValue="1")Integer page, @RequestParam(defaultValue="10")Integer rows,
                       String custName, String custSource,	String custIndustry, String custLevel, Model model) {

        Page<Customer> customers = customerService.findCustomerList(page, rows, custName, custSource, custIndustry, custLevel);
        model.addAttribute("page", customers);
        //客户来源
        List<BaseDict> fromType = systemService.findBaseDictListByType(FROM_TYPE);
        //客户所属行业
        List<BaseDict> industryType = systemService.findBaseDictListByType(INDUSTRY_TYPE);
        //客户级别
        List<BaseDict> levelType = systemService.findBaseDictListByType(LEVEL_TYPE);
        model.addAttribute("sourceList", fromType);
        model.addAttribute("industryList", industryType);
        model.addAttribute("levelList", levelType);
        //参数回显
        model.addAttribute("custName", custName);
        model.addAttribute("custSource", custSource);
        model.addAttribute("custIndustry", custIndustry);
        model.addAttribute("custLevel", custLevel);
        return "customerManage";
    }*/

    //
    @RequestMapping(value = "/customerList1")
    @ResponseBody
    public Page getlist1(@RequestParam(defaultValue="1")Integer page, @RequestParam(defaultValue="10")Integer pageSize,
                        String cust_name, String cust_source, String cust_industry, String cust_level) {

        Page<Customer> customers = customerService.findCustomerList(page, pageSize, cust_name, cust_source, cust_industry, cust_level);

        return customers;
    }

    @RequestMapping(value = "/customerList")
    @ResponseBody
    public Page getlist(@RequestParam(defaultValue="1")Integer page, @RequestParam(defaultValue="10")Integer pageSize,
                        Customer customer) {

        Page<Customer> customers = customerService.findCustomerList(page, pageSize, customer.getCust_name(),
                customer.getCust_source(), customer.getCust_industry(), customer.getCust_level());

        return customers;
    }

    @RequestMapping(value = "/deleteCustomer",method = RequestMethod.POST)
    @ResponseBody
    public Map deleteCustomer(Long cust_id,String deletereason,String remark){
        HashMap<String, String> map = new HashMap<>();
        customerService.deleteCustomer2(cust_id,deletereason,remark);
        map.put("msg","删除成功");
        return map;
    }

    @RequestMapping("/editCustomer")
    @ResponseBody
    public Customer getCustomerById(Long id) {
        Customer customer = customerService.getCustomerById(id);
        return customer;
    }

    @RequestMapping(value = "/batchRemoveCustomer",method = RequestMethod.POST)
    @ResponseBody
    public Map batchRemoveCustomer(String customer){
        HashMap<String, String> map = new HashMap<>();
       // customerService.deleteCustomer2(cust_id,null,null);
        List<Customer> customers= JSON.parseArray(customer,Customer.class);
        for (Customer cust: customers) {
            customerService.deleteCustomer2(cust.getCust_id(),null,null);
        }
        map.put("msg","删除成功");
        return map;
    }

}
