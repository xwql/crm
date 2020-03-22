package cn.crm.controller;

import cn.crm.bean.Message;
import cn.crm.service.MessageService;
import cn.crm.utils.DateUtils;
import cn.crm.utils.Page;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
public class MessageController {

    @Autowired
    MessageService messageService;

    @RequestMapping(value = "messageAdd.html",method = RequestMethod.GET)
    public String getMessageAdd(){
        return "message/messageAdd";
    }

    @RequestMapping(value = "saveMessage",method = RequestMethod.POST)
    @ResponseBody
    public Map saveMessage(Message message){
        HashMap<String, String> map = new HashMap<>();
        messageService.saveMessage(message);
        map.put("msg","添加成功");
        return map;
    }

    @RequestMapping(value = "/getMessageList",method = RequestMethod.POST )
    @ResponseBody
    public Page getlist(@RequestParam(defaultValue="1")Integer page, @RequestParam(defaultValue="10")Integer pageSize,
                        String author, String startTime,String endTime) {
        Date start = null;
        if(StringUtils.isNotEmpty(startTime)) {
            start = DateUtils.stringToDate(startTime);
        }
        Date end = null;
        if(StringUtils.isNotEmpty(endTime)){
            end = DateUtils.stringToDate(endTime);
        }
        Page<Message> messageList = messageService.findMessageList(author, start, end,page,pageSize);
        return messageList;
    }

    @RequestMapping(value = "deleteMessage",method = RequestMethod.POST)
    @ResponseBody
    public Map deleteMessage(Message message){
        HashMap<String, String> map = new HashMap<>();
        try {
            messageService.deleteMessage(message.getId());
            map.put("msg","删除成功");
        }catch(Exception e){
            map.put("msg","删除失败");
        }

        return map;
    }

}
