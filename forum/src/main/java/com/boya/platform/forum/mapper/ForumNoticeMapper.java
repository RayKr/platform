package com.boya.platform.forum.mapper;

import com.boya.platform.forum.model.po.ForumNotice;
import com.boya.platform.forum.model.po.ForumNoticeExtend;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository("forumNoticeMapper")
public interface ForumNoticeMapper extends Mapper<ForumNotice> {

    /**
     * 获取用户的通知信息
     * @param userId
     * @return
     */
    List<ForumNoticeExtend> selectByUserId(Long userId);
}