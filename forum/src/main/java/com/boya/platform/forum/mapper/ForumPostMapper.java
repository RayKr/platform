package com.boya.platform.forum.mapper;

import com.boya.platform.forum.model.dto.PostDTO;
import com.boya.platform.forum.model.po.ForumPost;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 帖子表持久层
 * @author Tsunglei Ching [ray@boyamarine.com]
 * @date 2017/11/13 8:58
 */
@Repository("forumPostMapper")
public interface ForumPostMapper extends Mapper<ForumPost> {

    /**
     * 通过用户ID查询出其发表的帖子
     * @param userId
     * @return
     */
    List<PostDTO> selectByUserId(@Param("userId") Long userId);

    /**
     * 通过帖子ID获取帖子内容
     * @param userId 用户ID
     * @param postId 文章ID
     * @return
     */
    PostDTO selectByPostId(@Param("userId") Long userId, @Param("postId") Long postId);

    /**
     * 获取所有帖子列表（除官方）
     * @return 帖子列表
     */
    List<PostDTO> selectAllPosts();

    /**
     * 获取所有官方帖子
     * @return
     */
    List<PostDTO> selectAllOfficialPosts();

    /**
     * 获取该用户所关注的用户的帖子列表
     * @param userId 用户ID
     * @return 帖子列表
     */
    List<PostDTO> selectFollowingPosts(@Param("userId") Long userId);

    /**
     * 插入文章
     * @param post
     * @return
     */
    int insertPost(@Param("post") ForumPost post);

    /**
     * 标题关键字搜索
     * @param keywords
     * @return
     */
    List<PostDTO> selectByKeyWords(@Param("keywords") String keywords);
}