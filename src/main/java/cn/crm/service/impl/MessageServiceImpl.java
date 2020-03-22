package cn.crm.service.impl;

import cn.crm.bean.Customer;
import cn.crm.bean.Message;
import cn.crm.mapper.MessageMapper;
import cn.crm.service.MessageService;
import cn.crm.utils.Page;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    MessageMapper messageMapper;

    @Override
    public void saveMessage(Message message) {
        message.setVisible(1);
        message.setCreatetime(new Date());
        messageMapper.insert(message);
    }

    @Override
    public List<Message> findMessageByTime(Date startTime, Date endTime) {
        return null;
    }

    @Override
    public List<Message> findMessageByAuthor(String author) {
        return null;
    }

    @Override
    public Page<Message> findMessageList(String author, Date startTime, Date endTime, Integer page, Integer rows) {
        Message message = new Message();
        //判断发布者
        if(StringUtils.isNotBlank(author)){
            message.setAuthor(author);
        }
        //当前页
        message.setStart((page-1) * rows) ;
        //每页数
        message.setRows(rows);
        //查询列表
        List<Message> messages = messageMapper.selectMessageList(message, startTime, endTime);
        //查询总记录数
        Integer count = messageMapper.selectMessageListCount(message, startTime, endTime);
        //创建Page返回对象
        Page<Message> result = new Page<>();
        result.setPage(page);
        result.setRows(messages);
        result.setSize(rows);
        result.setTotal(count);
        return result;
    }

    @Override
    public void deleteMessageWithData(Long id) {

    }

    @Override
    public void deleteMessage(Long id) {
        Message message = messageMapper.selectByPrimaryKey(id);
        message.setVisible(0);
        messageMapper.updateByPrimaryKey(message);
    }
}
