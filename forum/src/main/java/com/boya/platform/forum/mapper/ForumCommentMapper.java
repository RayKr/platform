package com.boya.platform.forum.mapper;

import com.boya.platform.forum.model.dto.CommentDTO;
import com.boya.platform.forum.model.po.ForumComment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 评论表持久层
 * @author Tsunglei Ching [ray@boyamarine.com]
 * @date 2017/11/13 8:58
 */
@Repository("forumCommentMapper")
public interface ForumCommentMapper extends Mapper<ForumComment> {

    /**
     * 通过用户id获取其回复的帖子内容
     * @param userId 用户id
     * @return 评论列表
     */
    List<CommentDTO> selectByUserId(@Param("userId") Long userId);

    /**
     * 通过文章id获取其标题下跟帖内容
     * @param postId 文章id
     * @return 评论列表
     */
    List<CommentDTO> selectByPostId(@Param("postId") Long postId);

}