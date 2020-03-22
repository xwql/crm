package cn.crm.service;

import cn.crm.bean.Message;
import cn.crm.utils.Page;

import java.util.Date;
import java.util.List;

public interface MessageService {
    /**
     * 自动设时间和show
     * @param message
     */
    void saveMessage(Message message);
    List<Message> findMessageByTime(Date startTime, Date endTime);
    List<Message> findMessageByAuthor(String author);
    Page<Message> findMessageList(String author, Date startTime, Date endTime, Integer page, Integer rows);
    void deleteMessageWithData(Long id);
    void deleteMessage(Long id);
}
