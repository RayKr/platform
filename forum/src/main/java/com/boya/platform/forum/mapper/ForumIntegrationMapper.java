package com.boya.platform.forum.mapper;

import com.boya.platform.forum.model.po.ForumIntegration;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository("forumIntegrationMapper")
public interface ForumIntegrationMapper extends Mapper<ForumIntegration> {

    /**
     * 根据签到次数区间获取此次签到的积分
     * @param checkinTimes
     * @return
     */
    Integer getIntegrationByCheckinTimes(@Param("checkinTimes") Integer checkinTimes);
}