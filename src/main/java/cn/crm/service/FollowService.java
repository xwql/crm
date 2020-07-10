package cn.crm.service;

import cn.crm.bean.FollowRecord;
import cn.crm.bean.FollowStatus;
import cn.crm.utils.Page;

import javax.xml.crypto.Data;
import java.util.Date;

public interface FollowService {
    void save(FollowStatus followStatus);
    //Page<FollowStatus> findFollowList();

    /**
     * 客户跟进列表
     * @param page
     * @param rows
     * @param custName
     * @param custUserName
     * @param followStatus
     * @return
     */
    public Page<FollowStatus> findFollowList(Integer page, Integer rows,
                                           String custName, String custUserName, Integer followStatus);
    FollowStatus getCustomerFollowStatusById(Long id);
    void stopFollowing(Long id);
    void saveFollowRecord(FollowRecord followRecord);

    /**
     * 不删除数据
     * @param id
     */
    void deleteFollowRecord(Long id);

    Page<FollowRecord> findFollowRecordList(Integer page, Integer rows, Long custId, String startTime, String endTime,Integer visible);

    FollowRecord getFollowRecordByID(Long id);
}
