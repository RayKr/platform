package com.boya.platform.forum.service;

import com.boya.platform.forum.model.dto.PostDTO;
import com.boya.platform.forum.model.po.ForumFavoriteExtend;
import com.boya.platform.forum.model.po.ForumHistoryExtend;

import java.util.List;

/**
 * 帖子相关 业务逻辑层
 * @author Tsunglei Ching [ray@boyamarine.com]
 * @date 2017/11/13 16:13
 */
public interface PostService {

    /**
     * 分页获取用户所发的帖子
     * @param userId 用户ID
     * @param pageNum 分页数
     * @param pageSize 每页条数
     * @return 帖子列表
     */
    List<PostDTO> selectByUser(Long userId, int pageNum, int pageSize);

    /**
     * 获取帖子详细内容
     * @param userId
     * @param postId
     * @return
     */
    PostDTO selectByPostId(Long userId, Long postId);

    /**
     * 分页获取所有帖子列表
     * @param pageNum 分页数
     * @param pageSize 每页条数
     * @return 帖子列表
     */
    List<PostDTO> selectAll(int pageNum, int pageSize);


    /**
     * 获取所有官方帖子
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<PostDTO> selectAllOfficial(int pageNum, int pageSize);

    /**
     * 获取当前登录用户所关注的人的帖子列表
     * @param userId 当前登录用户
     * @param pageNum 分页数
     * @param pageSize 每页条数
     * @return 帖子
     */
    List<PostDTO> selectFollowingPosts(Long userId, int pageNum, int pageSize);

    /**
     * 发帖功能
     * @param userId 用户ID
     * @param title 文章标题
     * @param post 文章内容
     * @return
     */
    int insertPost(Long userId, String title, String post);

    /**
     * 删帖功能
     * @param postId 文章ID
     * @return
     */
    int deletePost(Long postId);

    /**
     * 增加一次阅读数
     * @param postId 文章ID
     */
    void addReadCount(Long postId);

    /**
     * 记录用户阅读的历史记录
     * @param userId 用户ID
     * @param postId 文章ID
     */
    void recordHistory(Long userId, Long postId);

    /**
     * 获取用户的浏览历史
     * @param userId
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<ForumHistoryExtend> selectHistory(Long userId, int pageNum, int pageSize);

    /**
     * 获取用户最近20条浏览历史
     * @param userId
     * @return
     */
    List<ForumHistoryExtend> selectHistoryLatest(Long userId);

    /**
     * 收藏帖子
     * @param userId
     * @param postId
     */
    void addFavoritePost(Long userId, Long postId) throws Exception;

    /**
     * 取消收藏帖子
     * @param userId
     * @param postId
     */
    void delFavoritePost(Long userId, Long postId) throws Exception;

    /**
     * 点赞帖子
     * @param userId
     * @param postId
     */
    void addLikePost(Long userId, Long postId) throws Exception;

    /**
     * 查询用户收藏列表
     * @param userId
     * @return
     */
    List<ForumFavoriteExtend> selectFavoritePostList(Long userId);

    /**
     * 查询用户点赞的文章列表
     * @param userId
     * @return
     */
    List<ForumFavoriteExtend> selectLikePostList(Long userId);

    /**
     * 按标题关键字查询帖子
     * @param keywords
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<PostDTO> searchByKeyWords(String keywords, int pageNum, int pageSize);
}
