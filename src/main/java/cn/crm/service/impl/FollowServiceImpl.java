package cn.crm.service.impl;

import cn.crm.bean.Customer;
import cn.crm.bean.FollowRecord;
import cn.crm.bean.FollowStatus;
import cn.crm.mapper.CustomerMapper;
import cn.crm.mapper.FollowRecordMapper;
import cn.crm.mapper.FollowStatusMapper;
import cn.crm.service.FollowService;
import cn.crm.utils.DateUtils;
import cn.crm.utils.Page;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

@Service("followService")
public class FollowServiceImpl implements FollowService {
    @Autowired
    FollowStatusMapper followStatusMapper;
    @Autowired
    CustomerMapper customerMapper;
    @Autowired
    FollowRecordMapper followRecordMapper;

    @Override
    public void save(FollowStatus followStatus) {
        followStatus.setFollow_status(1);
        FollowStatus primaryKey = followStatusMapper.selectByPrimaryKey(followStatus.getCust_id());
        if (primaryKey == null) {
            followStatus.setCreatetime(new Date());
            followStatusMapper.insert(followStatus);
        } else {
            followStatus.setFollow_status(1);
            followStatusMapper.updateByPrimaryKeySelective(followStatus);
        }
        Long cust_user_id = followStatus.getCust_user_id();
        String cust_linkman = followStatus.getCust_linkman();
        Customer customerById = customerMapper.getCustomerById(followStatus.getCust_id());
        customerById.setCust_user_id(cust_user_id);
        if(cust_linkman!=null)
            customerById.setCust_linkman(cust_linkman);
        customerMapper.updateCustomer(customerById);

    }

    @Override
    public Page<FollowStatus> findFollowList(Integer page, Integer rows, String custName, String custUserName, Integer followStatus) {
        FollowStatus followS = new FollowStatus();
        //
        if (StringUtils.isNotBlank(custName)) {
            followS.setCust_name(custName);
        }
        //
        if (custUserName != null) {
            followS.setCust_user_name(custUserName);
        }
        //
        if (followStatus != null) {
            followS.setFollow_status(followStatus);
        }else{
            followS.setFollow_status(1);
        }
        //当前页
        followS.setStart((page - 1) * rows);
        //每页数
        followS.setRows(rows);
        //查询客户列表
        List<FollowStatus> followStatuses = followStatusMapper.selectFollowStatusList(followS);
        //查询客户列表总记录数
        Integer count = followStatusMapper.selectFollowListCount(followS);
        //创建Page返回对象
        Page<FollowStatus> result = new Page<>();
        result.setPage(page);
        result.setRows(followStatuses);
        result.setSize(rows);
        result.setTotal(count);
        return result;
    }

    @Override
    public FollowStatus getCustomerFollowStatusById(Long id) {
        Customer customerById = customerMapper.getCustomerById(id);
        FollowStatus followStatus = followStatusMapper.selectByPrimaryKey(id);
        followStatus.setCust_name(customerById.getCust_name());
        followStatus.setCust_linkman(customerById.getCust_linkman());
        followStatus.setCust_user_id(customerById.getCust_user_id());
        return followStatus;
    }

    @Override
    public void stopFollowing(Long id) {
        FollowStatus followStatus = followStatusMapper.selectByPrimaryKey(id);
        followStatus.setFollow_status(0);
        followStatusMapper.updateByPrimaryKeySelective(followStatus);
    }

    @Override
    public void saveFollowRecord(FollowRecord followRecord) {
        followRecord.setVisible(1);
        FollowRecord record = followRecordMapper.selectByPrimaryKey(followRecord.getId());
        if(record == null){
            followRecord.setRecord_time(new Date());
            followRecordMapper.insert(followRecord);
        } else {
            followRecordMapper.updateByPrimaryKeySelective(followRecord);
        }
    }

    @Override
    public Page<FollowRecord> findFollowRecordList(Integer page, Integer rows, Long cust_id, String startTime, String endTime, Integer visible) {
        FollowRecord record = new FollowRecord();
        Date start = null;
        if(StringUtils.isNotEmpty(startTime)) {
            start = DateUtils.stringToDate(startTime);
        }
        Date end = null;
        if(StringUtils.isNotEmpty(endTime)){
            end = DateUtils.stringToDate(endTime);
        }
        if(cust_id != null){
            record.setCust_id(cust_id);
        }
        record.setStartTime(start);
        record.setEndTime(end);
        record.setVisible(visible);
        //当前页
        record.setStart((page-1) * rows) ;
        //每页行数
        record.setRows(rows);
        //查询列表
        List<FollowRecord> messages = followRecordMapper.selectFollowRecordList(record);
        //查询总记录数
        Integer count = followRecordMapper.selectFollowRecordListCount(record);
        //创建Page返回对象
        Page<FollowRecord> result = new Page<>();
        result.setPage(page);
        result.setRows(messages);
        result.setSize(rows);
        result.setTotal(count);
        return result;
    }

    @Override
    public void deleteFollowRecord(Long id) {
        FollowRecord followRecord = new FollowRecord();
        followRecord.setVisible(0);
        followRecord.setId(id);
        followRecordMapper.updateByPrimaryKeySelective(followRecord);
    }

    @Override
    public FollowRecord getFollowRecordByID(Long id) {
        FollowRecord followRecord = followRecordMapper.selectByPrimaryKey(id);
        return followRecord;
    }
}
