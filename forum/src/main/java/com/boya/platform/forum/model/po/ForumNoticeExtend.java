package com.boya.platform.forum.model.po;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @author Tsunglei Ching [ray@boyamarine.com]
 * @date 2017/11/17 10:01
 */
public class ForumNoticeExtend {

    private Long noticeId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date noticeDate;

    /**
     * 通知类型（被关注1、被点赞2、被评论3）
     */
    private Byte noticeType;

    /**
     * 文章ID，类型为评论和点赞时可用
     */
    private Long postId;

    /**
     * 评论ID，当类型为评论时可用
     */
    private Long commentId;

    /**
     * 用户头像
     */
    private String operPortrait;

    /**
     * 用户ID
     */
    private Long operId;

    /**
     * 产生通知的用户名称
     */
    private String operName;

    /**
     * 文章标题
     */
    private String postTitle;

    /**
     * 评论内容
     */
    private String commentContent;

    public String getOperPortrait() {
        return operPortrait;
    }

    public void setOperPortrait(String operPortrait) {
        this.operPortrait = operPortrait;
    }

    public Long getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(Long noticeId) {
        this.noticeId = noticeId;
    }

    public Date getNoticeDate() {
        return noticeDate;
    }

    public void setNoticeDate(Date noticeDate) {
        this.noticeDate = noticeDate;
    }

    public Byte getNoticeType() {
        return noticeType;
    }

    public void setNoticeType(Byte noticeType) {
        this.noticeType = noticeType;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public String getOperName() {
        return operName;
    }

    public void setOperName(String operName) {
        this.operName = operName;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public Long getOperId() {
        return operId;
    }

    public void setOperId(Long operId) {
        this.operId = operId;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }
}
