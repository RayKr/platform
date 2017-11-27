package com.boya.platform.forum.mapper;

import com.boya.platform.forum.model.po.ForumCheckin;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository("forumCheckinMapper")
public interface ForumCheckinMapper extends Mapper<ForumCheckin> {

    /**
     * 获取上次签到的信息
     * @param userId
     * @return
     */
    ForumCheckin selectLastCheckByUserId(@Param("userId") Long userId);

}