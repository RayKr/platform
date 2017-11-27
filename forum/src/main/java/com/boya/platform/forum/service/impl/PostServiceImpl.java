package com.boya.platform.forum.service.impl;

import com.boya.platform.forum.mapper.ForumFavoriteMapper;
import com.boya.platform.forum.mapper.ForumHistoryMapper;
import com.boya.platform.forum.mapper.ForumNoticeMapper;
import com.boya.platform.forum.mapper.ForumPostMapper;
import com.boya.platform.forum.model.dto.PostDTO;
import com.boya.platform.forum.model.po.*;
import com.boya.platform.forum.service.PostService;
import com.boya.platform.forum.util.Constants;
import com.boya.platform.forum.util.TextUtil;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author Tsunglei Ching [ray@boyamarine.com]
 * @date 2017/11/13 16:20
 */
@Service("postService")
public class PostServiceImpl implements PostService {

    @Autowired
    private ForumPostMapper forumPostMapper;

    @Autowired
    private ForumHistoryMapper forumHistoryMapper;

    @Autowired
    private ForumFavoriteMapper forumFavoriteMapper;

    @Autowired
    private ForumNoticeMapper forumNoticeMapper;

    @Override
    public List<PostDTO> selectByUser(Long userId, int pageNum, int pageSize) {
        // 分页查询
        PageHelper.startPage(pageNum, pageSize);
        return forumPostMapper.selectByUserId(userId);
    }

    @Override
    public PostDTO selectByPostId(Long userId, Long postId) {
        return forumPostMapper.selectByPostId(userId, postId);
    }

    @Override
    public List<PostDTO> selectAll(int pageNum, int pageSize) {
        // 分页查询
        PageHelper.startPage(pageNum, pageSize);
        return forumPostMapper.selectAllPosts();
    }

    @Override
    public List<PostDTO> selectAllOfficial(int pageNum, int pageSize) {
        // 分页查询
        PageHelper.startPage(pageNum, pageSize);
        return forumPostMapper.selectAllOfficialPosts();
    }

    @Override
    public List<PostDTO> selectFollowingPosts(Long userId, int pageNum, int pageSize) {
        // 分页查询
        PageHelper.startPage(pageNum, pageSize);
        return forumPostMapper.selectFollowingPosts(userId);
    }

    @Override
    public int insertPost(Long userId,String title, String post) {
        ForumPost p = new ForumPost();
        p.setPostTitle(title);
        p.setPostContent(post);
        // 自动摘要
        String excerpt = TextUtil.htmlRemoveTag(post);
        excerpt = excerpt.length() > 50 ? excerpt.substring(0, 50) : excerpt;
        p.setPostExcerpt(excerpt);

        p.setPostAuthorId(userId);
        Date postDate = new Date();
        p.setPostDate(postDate);
        p.setPostDateGmt(postDate);
        return forumPostMapper.insertPost(p);
    }

    @Override
    public int deletePost(Long postId) {
        ForumPost post = forumPostMapper.selectByPrimaryKey(postId);
        post.setPostStatus(Constants.POST_STATUS_DELETED);
        post.setPostModifiedGmt(new Date());
        post.setPostModified(new Date());
        return forumPostMapper.updateByPrimaryKey(post);
    }

    @Override
    public void addReadCount(Long postId) {
        // 获取当前文章信息
        ForumPost forumPost = forumPostMapper.selectByPrimaryKey(postId);
        // 获取该文章明细一次，则增加一次阅读数
        forumPost.setReadCount(forumPost.getReadCount() + 1);
        // 更新记录
        forumPostMapper.updateByPrimaryKey(forumPost);
    }

    @Override
    public void recordHistory(Long userId, Long postId) {
        ForumHistory history = new ForumHistory();
        history.setUserId(userId);
        history.setPostId(postId);
        history.setHistoryDate(new Date());
        forumHistoryMapper.insert(history);
    }

    @Override
    public List<ForumHistoryExtend> selectHistory(Long userId, int pageNum, int pageSize) {
        // 分页查询
        PageHelper.startPage(pageNum, pageSize);
        return forumHistoryMapper.selectByUserId(userId);
    }

    @Override
    public List<ForumHistoryExtend> selectHistoryLatest(Long userId) {
        return this.selectHistory(userId, 1, 20);
    }

    @Override
    public void addFavoritePost(Long userId, Long postId) throws Exception {
        ForumFavorite fav = new ForumFavorite();
        fav.setPostId(postId);
        fav.setUserId(userId);
        fav.setRelateType(Constants.FAVOR_TYPE_FAVORITE);
        // 验证是否重复收藏
        ForumFavorite favorite = forumFavoriteMapper.selectOne(fav);
        if (favorite != null) {
            throw new Exception("您已收藏该帖，请勿重复收藏！");
        }

        fav.setGmtCreate(new Date());
        forumFavoriteMapper.insert(fav);
    }

    @Override
    public void delFavoritePost(Long userId, Long postId) throws Exception {
        ForumFavorite fav = new ForumFavorite();
        fav.setPostId(postId);
        fav.setUserId(userId);
        fav.setRelateType(Constants.FAVOR_TYPE_FAVORITE);
        ForumFavorite favorite = forumFavoriteMapper.selectOne(fav);
        if (favorite == null) {
            throw new Exception("您没有收藏该帖子，无法取消收藏！");
        }
        forumFavoriteMapper.deleteByPrimaryKey(favorite.getId());
    }

    @Override
    public void addLikePost(Long userId, Long postId) throws Exception {
        ForumFavorite fav = new ForumFavorite();
        fav.setPostId(postId);
        fav.setUserId(userId);
        fav.setRelateType(Constants.FAVOR_TYPE_LIKE);
        // 验证是否重复点赞
        ForumFavorite favorite = forumFavoriteMapper.selectOne(fav);
        if (favorite != null) {
            throw new Exception("您已点赞该帖，请勿重复点赞！");
        }
        fav.setGmtCreate(new Date());
        forumFavoriteMapper.insert(fav);

        // 记录通知
        ForumNotice notice = new ForumNotice();
        ForumPost post = forumPostMapper.selectByPrimaryKey(postId);
        notice.setNoticeType(Constants.NOTICE_TYPE_LIKE);
        notice.setUserId(post.getPostAuthorId());
        notice.setNoticeDate(new Date());
        notice.setPostId(postId);
        notice.setFavorId(fav.getId());
        notice.setNoticeStatus(Constants.NOTICE_STATUS_UNREAD);
        forumNoticeMapper.insert(notice);
    }

    @Override
    public List<ForumFavoriteExtend> selectFavoritePostList(Long userId) {
        return forumFavoriteMapper.selectFavoritesByUserId(userId);
    }

    @Override
    public List<ForumFavoriteExtend> selectLikePostList(Long userId) {
        return forumFavoriteMapper.selectLikesByUserId(userId);
    }

    @Override
    public List<PostDTO> searchByKeyWords(String keywords, int pageNum, int pageSize) {
        // 分页查询
        PageHelper.startPage(pageNum, pageSize);
        return forumPostMapper.selectByKeyWords(keywords);
    }

}
