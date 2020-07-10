package cn.crm.service.impl;

import cn.crm.bean.Customer;
import cn.crm.bean.FollowRecord;
import cn.crm.bean.FollowStatus;
import cn.crm.mapper.CustomerMapper;
import cn.crm.mapper.FollowRecordMapper;
import cn.crm.mapper.FollowStatusMapper;
import cn.crm.service.CustomerService;
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
    CustomerService customerService;
    @Autowired
    CustomerMapper customerMapper;
    @Autowired
    FollowRecordMapper followRecordMapper;

    @Override
    public void save(FollowStatus followStatus) {
        followStatus.setFollowStatus(1);
        FollowStatus primaryKey = followStatusMapper.selectByPrimaryKey(followStatus.getCustId());
        if (primaryKey == null) {
            followStatus.setCreatetime(new Date());
            followStatus.setTimes(0L);
            followStatusMapper.insert(followStatus);
        } else {
            followStatus.setFollowStatus(1);
            followStatusMapper.updateByPrimaryKeySelective(followStatus);
        }
        Long custUserId = followStatus.getCustUserId();
        String custLinkman = followStatus.getCustLinkman();
        Customer customerById = customerMapper.getCustomerById(followStatus.getCustId());
        customerById.setCustUserId(custUserId);
        if(custLinkman!=null)
            customerById.setCustLinkman(custLinkman);
        customerMapper.updateCustomer(customerById);

    }

    @Override
    public Page<FollowStatus> findFollowList(Integer page, Integer rows, String custName, String custUserName, Integer followStatus) {
        FollowStatus followS = new FollowStatus();
        //
        if (StringUtils.isNotBlank(custName)) {
            followS.setCustName(custName);
        }
        //
        if (custUserName != null) {
            followS.setCustUserName(custUserName);
        }
        //
        if (followStatus != null) {
            followS.setFollowStatus(followStatus);
        }else{
            followS.setFollowStatus(1);
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
        followStatus.setCustName(customerById.getCustName());
        followStatus.setCustLinkman(customerById.getCustLinkman());
        followStatus.setCustUserId(customerById.getCustUserId());
        return followStatus;
    }

    @Override
    public void stopFollowing(Long id) {
        FollowStatus followStatus = followStatusMapper.selectByPrimaryKey(id);
        followStatus.setFollowStatus(0);
        followStatusMapper.updateByPrimaryKeySelective(followStatus);
    }

    @Override
    public void saveFollowRecord(FollowRecord followRecord) {
        followRecord.setVisible(1);
        FollowRecord record = followRecordMapper.selectByPrimaryKey(followRecord.getId());
        if(record == null){
            followRecord.setRecordTime(new Date());
            followRecordMapper.insert(followRecord);
        } else {
            followRecordMapper.updateByPrimaryKeySelective(followRecord);
        }
    }

    @Override
    public Page<FollowRecord> findFollowRecordList(Integer page, Integer rows, Long custId, String startTime, String endTime, Integer visible) {
        FollowRecord record = new FollowRecord();
        Date start = null;
        if(StringUtils.isNotEmpty(startTime)) {
            start = DateUtils.stringToDate(startTime);
        }
        Date end = null;
        if(StringUtils.isNotEmpty(endTime)){
            end = DateUtils.stringToDate(endTime);
        }
        if(custId != null){
            record.setCustId(custId);
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
