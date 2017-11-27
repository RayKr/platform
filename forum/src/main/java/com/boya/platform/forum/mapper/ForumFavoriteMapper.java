package com.boya.platform.forum.mapper;

import com.boya.platform.forum.model.po.ForumFavorite;
import com.boya.platform.forum.model.po.ForumFavoriteExtend;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository("forumFavoriteMapper")
public interface ForumFavoriteMapper extends Mapper<ForumFavorite> {

    /**
     * 获取用户点赞的帖子
     * @param userId
     * @return
     */
    List<ForumFavoriteExtend> selectLikesByUserId(@Param("userId") Long userId);

    /**
     * 获取用户收藏的帖子
     * @param userId
     * @return
     */
    List<ForumFavoriteExtend> selectFavoritesByUserId(@Param("userId") Long userId);
}