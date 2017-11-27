package com.boya.platform.forum.service;

import com.boya.platform.forum.model.dto.CommentDTO;

import java.util.List;

/**
 * 评论业务逻辑层
 * @author Tsunglei Ching [ray@boyamarine.com]
 * @date 2017/11/13 20:43
 */
public interface CommentService {

    /**
     * 分页获取用户所发的回帖
     * @param userId 用户ID
     * @param pageNum 分页数
     * @param pageSize 每页条数
     * @return 回复列表
     */
    List<CommentDTO> selectByUserId(Long userId, int pageNum, int pageSize);

    /**
     * 分页获取某主题下的跟帖
     * @param postId 文章ID
     * @param pageNum 分页数
     * @param pageSize 每页条数
     * @return 回复列表
     */
    List<CommentDTO> selectByPostId(Long postId, int pageNum, int pageSize);

    /**
     * 回帖功能
     * @param userId 用户ID
     * @param postId 文章ID
     * @param comment 评论内容
     * @return
     */
    int recordComment(Long userId, Long postId, String comment);

}
