package cn.crm.service.impl;

import cn.crm.bean.Customer;
import cn.crm.bean.FollowStatus;
import cn.crm.mapper.CustomerMapper;
import cn.crm.mapper.FollowStatusMapper;
import cn.crm.service.FollowService;
import cn.crm.utils.Page;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("followService")
public class FollowServiceImpl implements FollowService {
    @Autowired
    FollowStatusMapper followStatusMapper;
    @Autowired
    CustomerMapper customerMapper;

    @Override
    public void save(FollowStatus followStatus) {
        followStatus.setFollow_status(1);
        followStatus.setCreatetime(new Date());
        FollowStatus primaryKey = followStatusMapper.selectByPrimaryKey(followStatus.getCust_id());
        if (primaryKey == null) {
            followStatusMapper.insert(followStatus);
        } else {
            followStatus.setFollow_status(1);
            followStatusMapper.updateByPrimaryKey(followStatus);
        }
        Long cust_user_id = followStatus.getCust_user_id();
        String cust_linkman = followStatus.getCust_linkman();
        Customer customerById = customerMapper.getCustomerById(followStatus.getCust_id());
        String cust_linkman1 = customerById.getCust_linkman();
        if (!cust_user_id.equals(customerById.getCust_user_id()) || !cust_linkman.equals(cust_linkman1)) {
            customerById.setCust_user_id(cust_user_id);
            customerById.setCust_linkman(cust_linkman);
            customerMapper.updateCustomer(customerById);
        }
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
        followStatusMapper.updateByPrimaryKey(followStatus);
    }
}
