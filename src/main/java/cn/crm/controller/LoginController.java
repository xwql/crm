package cn.crm.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {
    @PostMapping("user/login")
    @ResponseBody
    public Map toLogin(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession session){
        HashMap<String, String> map = new HashMap<>();
        if(!StringUtils.isEmpty(username) && "admin".equals(password)){
            map.put("msg","success");
            session.setAttribute("loginUser",username);
            return map;
        }else {
            //model.addAttribute("msg","用户名或密码错误");
            //map.put("msg","用户名或密码错误");
            map.put("msg","error");
            return map;
        }
        //return "index";
    }

    @GetMapping("user/logout")
    @ResponseBody
    public Map logout(HttpSession session) {
        HashMap<String, Boolean> map = new HashMap<>();
        session.removeAttribute("loginUser");
        map.put("success",true);
        return map;
    }
}
