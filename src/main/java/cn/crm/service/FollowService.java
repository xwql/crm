package cn.crm.service;

import cn.crm.bean.FollowStatus;
import cn.crm.utils.Page;

public interface FollowService {
    void save(FollowStatus followStatus);
    //Page<FollowStatus> findFollowList();
    public Page<FollowStatus> findFollowList(Integer page, Integer rows,
                                           String custName, String custUserName, Integer followStatus);
    FollowStatus getCustomerFollowStatusById(Long id);
    void stopFollowing(Long id);
}
