package com.boya.platform.forum.mapper;

import com.boya.platform.forum.model.po.ForumHistory;
import com.boya.platform.forum.model.po.ForumHistoryExtend;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository("forumHistoryMapper")
public interface ForumHistoryMapper extends Mapper<ForumHistory> {

    /**
     * 查询用户的浏览历史
     * @param userId
     * @return
     */
    List<ForumHistoryExtend> selectByUserId(@Param("userId") Long userId);
}