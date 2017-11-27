package com.boya.platform.forum.model.po;

import java.util.Date;
import javax.persistence.*;

@Table(name = "forum_notice")
public class ForumNotice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notice_id")
    private Long noticeId;

    @Column(name = "notice_date")
    private Date noticeDate;

    /**
     * 通知类型（被关注1、被点赞2、被评论3）
     */
    @Column(name = "notice_type")
    private Byte noticeType;

    @Column(name = "user_id")
    private Long userId;

    /**
     * 粉丝ID
     */
    @Column(name = "follower_id")
    private Long followerId;

    /**
     * 文章ID，类型为评论和点赞时可用
     */
    @Column(name = "post_id")
    private Long postId;

    /**
     * 评论ID，当类型为评论时可用
     */
    @Column(name = "comment_id")
    private Long commentId;

    /**
     * 收藏ID，当类型为点赞时可用
     */
    @Column(name = "favor_id")
    private Long favorId;

    /**
     * 通知状态（0-未读， 1-已读）
     */
    @Column(name = "notice_status")
    private Byte noticeStatus;

    /**
     * @return notice_id
     */
    public Long getNoticeId() {
        return noticeId;
    }

    /**
     * @param noticeId
     */
    public void setNoticeId(Long noticeId) {
        this.noticeId = noticeId;
    }

    /**
     * @return notice_date
     */
    public Date getNoticeDate() {
        return noticeDate;
    }

    /**
     * @param noticeDate
     */
    public void setNoticeDate(Date noticeDate) {
        this.noticeDate = noticeDate;
    }

    /**
     * 获取通知类型（被关注1、被点赞2、被评论3）
     *
     * @return notice_type - 通知类型（被关注1、被点赞2、被评论3）
     */
    public Byte getNoticeType() {
        return noticeType;
    }

    /**
     * 设置通知类型（被关注1、被点赞2、被评论3）
     *
     * @param noticeType 通知类型（被关注1、被点赞2、被评论3）
     */
    public void setNoticeType(Byte noticeType) {
        this.noticeType = noticeType;
    }

    /**
     * @return user_id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取粉丝ID
     *
     * @return follower_id - 粉丝ID
     */
    public Long getFollowerId() {
        return followerId;
    }

    /**
     * 设置粉丝ID
     *
     * @param followerId 粉丝ID
     */
    public void setFollowerId(Long followerId) {
        this.followerId = followerId;
    }

    /**
     * 获取文章ID，类型为评论和点赞时可用
     *
     * @return post_id - 文章ID，类型为评论和点赞时可用
     */
    public Long getPostId() {
        return postId;
    }

    /**
     * 设置文章ID，类型为评论和点赞时可用
     *
     * @param postId 文章ID，类型为评论和点赞时可用
     */
    public void setPostId(Long postId) {
        this.postId = postId;
    }

    /**
     * 获取评论ID，当类型为评论时可用
     *
     * @return comment_id - 评论ID，当类型为评论时可用
     */
    public Long getCommentId() {
        return commentId;
    }

    /**
     * 设置评论ID，当类型为评论时可用
     *
     * @param commentId 评论ID，当类型为评论时可用
     */
    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    /**
     * 获取收藏ID，当类型为点赞时可用
     *
     * @return favor_id - 收藏ID，当类型为点赞时可用
     */
    public Long getFavorId() {
        return favorId;
    }

    /**
     * 设置收藏ID，当类型为点赞时可用
     *
     * @param favorId 收藏ID，当类型为点赞时可用
     */
    public void setFavorId(Long favorId) {
        this.favorId = favorId;
    }

    /**
     * 获取通知状态（0-未读， 1-已读）
     *
     * @return notice_status - 通知状态（0-未读， 1-已读）
     */
    public Byte getNoticeStatus() {
        return noticeStatus;
    }

    /**
     * 设置通知状态（0-未读， 1-已读）
     *
     * @param noticeStatus 通知状态（0-未读， 1-已读）
     */
    public void setNoticeStatus(Byte noticeStatus) {
        this.noticeStatus = noticeStatus;
    }
}