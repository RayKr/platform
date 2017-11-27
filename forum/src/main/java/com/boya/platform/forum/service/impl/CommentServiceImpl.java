package com.boya.platform.forum.service.impl;

import com.boya.platform.forum.mapper.ForumCommentMapper;
import com.boya.platform.forum.mapper.ForumNoticeMapper;
import com.boya.platform.forum.mapper.ForumPostMapper;
import com.boya.platform.forum.model.dto.CommentDTO;
import com.boya.platform.forum.model.po.ForumComment;
import com.boya.platform.forum.model.po.ForumNotice;
import com.boya.platform.forum.model.po.ForumPost;
import com.boya.platform.forum.service.CommentService;
import com.boya.platform.forum.util.Constants;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author Tsunglei Ching [ray@boyamarine.com]
 * @date 2017/11/13 20:48
 */
@Service("commentService")
public class CommentServiceImpl implements CommentService {

    @Autowired
    private ForumCommentMapper forumCommentMapper;

    @Autowired
    private ForumPostMapper forumPostMapper;

    @Autowired
    private ForumNoticeMapper forumNoticeMapper;

    @Override
    public List<CommentDTO> selectByUserId(Long userId, int pageNum, int pageSize) {
        // 分页查询
        PageHelper.startPage(pageNum, pageSize);
        return forumCommentMapper.selectByUserId(userId);
    }

    @Override
    public List<CommentDTO> selectByPostId(Long postId, int pageNum, int pageSize) {
        // 分页查询
        PageHelper.startPage(pageNum, pageSize);
        return forumCommentMapper.selectByPostId(postId);
    }

    @Override
    public int recordComment(Long userId, Long postId, String comment) {
        // 记录评论
        ForumComment ct = new ForumComment();
        ct.setCommentUserId(userId);
        ct.setCommentPostId(postId);
        ct.setCommentContent(comment);
        Date today = new Date();
        ct.setCommentDate(today);
        ct.setCommentDateGmt(today);
        ct.setCommentApproved("1");
        int i = forumCommentMapper.insert(ct);

        // 记录通知
        ForumNotice notice = new ForumNotice();
        ForumPost post = forumPostMapper.selectByPrimaryKey(postId);
        notice.setUserId(post.getPostAuthorId());
        notice.setNoticeType(Constants.NOTICE_TYPE_COMMENT);
        notice.setNoticeDate(new Date());
        notice.setPostId(postId);
        notice.setCommentId(ct.getCommentId());
        notice.setNoticeStatus(Constants.NOTICE_STATUS_UNREAD);
        forumNoticeMapper.insert(notice);

        return i;
    }

}
