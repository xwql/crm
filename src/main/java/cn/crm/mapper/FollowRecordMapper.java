package cn.crm.mapper;

import cn.crm.bean.FollowRecord;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FollowRecordMapper {
    int deleteByPrimaryKey(Long id);

    int insert(FollowRecord record);

    int insertSelective(FollowRecord record);

    FollowRecord selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FollowRecord record);

    int updateByPrimaryKey(FollowRecord record);

    List<FollowRecord> selectFollowRecordList(FollowRecord record);
    int selectFollowRecordListCount(FollowRecord record);
}