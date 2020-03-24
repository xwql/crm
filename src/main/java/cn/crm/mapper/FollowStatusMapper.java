package cn.crm.mapper;

import cn.crm.bean.FollowStatus;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FollowStatusMapper {
    int deleteByPrimaryKey(Long custId);

    int insert(FollowStatus record);

    int insertSelective(FollowStatus record);

    FollowStatus selectByPrimaryKey(Long custId);

    int updateByPrimaryKeySelective(FollowStatus record);

    int updateByPrimaryKey(FollowStatus record);

    List<FollowStatus> selectFollowStatusList(FollowStatus followStatus);
    int selectFollowListCount(FollowStatus followStatus);
}