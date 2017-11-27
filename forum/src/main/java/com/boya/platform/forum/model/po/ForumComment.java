package com.boya.platform.forum.model.po;

import java.util.Date;
import javax.persistence.*;

@Table(name = "forum_comment")
public class ForumComment {
    /**
     * 跟帖主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long commentId;

    /**
     * 跟帖的主题帖ID
     */
    @Column(name = "comment_post_id")
    private Long commentPostId;

    /**
     * 评论人ID
     */
    @Column(name = "comment_user_id")
    private Long commentUserId;

    /**
     * 评论人当前IP
     */
    @Column(name = "comment_ip")
    private String commentIp;

    /**
     * 评论时间
     */
    @Column(name = "comment_date")
    private Date commentDate;

    /**
     * 评论时间GMT
     */
    @Column(name = "comment_date_gmt")
    private Date commentDateGmt;

    /**
     * 跟帖是否被批准
     */
    @Column(name = "comment_approved")
    private String commentApproved;

    /**
     * 评论者的USER AGENT
     */
    @Column(name = "comment_agent")
    private String commentAgent;

    /**
     * 父评论ID
     */
    @Column(name = "comment_parent")
    private Long commentParent;

    /**
     * 跟帖正文
     */
    @Column(name = "comment_content")
    private String commentContent;

    /**
     * 获取跟帖主键
     *
     * @return comment_id - 跟帖主键
     */
    public Long getCommentId() {
        return commentId;
    }

    /**
     * 设置跟帖主键
     *
     * @param commentId 跟帖主键
     */
    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    /**
     * 获取跟帖的主题帖ID
     *
     * @return comment_post_id - 跟帖的主题帖ID
     */
    public Long getCommentPostId() {
        return commentPostId;
    }

    /**
     * 设置跟帖的主题帖ID
     *
     * @param commentPostId 跟帖的主题帖ID
     */
    public void setCommentPostId(Long commentPostId) {
        this.commentPostId = commentPostId;
    }

    /**
     * 获取评论人ID
     *
     * @return comment_user_id - 评论人ID
     */
    public Long getCommentUserId() {
        return commentUserId;
    }

    /**
     * 设置评论人ID
     *
     * @param commentUserId 评论人ID
     */
    public void setCommentUserId(Long commentUserId) {
        this.commentUserId = commentUserId;
    }

    /**
     * 获取评论人当前IP
     *
     * @return comment_ip - 评论人当前IP
     */
    public String getCommentIp() {
        return commentIp;
    }

    /**
     * 设置评论人当前IP
     *
     * @param commentIp 评论人当前IP
     */
    public void setCommentIp(String commentIp) {
        this.commentIp = commentIp == null ? null : commentIp.trim();
    }

    /**
     * 获取评论时间
     *
     * @return comment_date - 评论时间
     */
    public Date getCommentDate() {
        return commentDate;
    }

    /**
     * 设置评论时间
     *
     * @param commentDate 评论时间
     */
    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }

    /**
     * 获取评论时间GMT
     *
     * @return comment_date_gmt - 评论时间GMT
     */
    public Date getCommentDateGmt() {
        return commentDateGmt;
    }

    /**
     * 设置评论时间GMT
     *
     * @param commentDateGmt 评论时间GMT
     */
    public void setCommentDateGmt(Date commentDateGmt) {
        this.commentDateGmt = commentDateGmt;
    }

    /**
     * 获取跟帖是否被批准
     *
     * @return comment_approved - 跟帖是否被批准
     */
    public String getCommentApproved() {
        return commentApproved;
    }

    /**
     * 设置跟帖是否被批准
     *
     * @param commentApproved 跟帖是否被批准
     */
    public void setCommentApproved(String commentApproved) {
        this.commentApproved = commentApproved == null ? null : commentApproved.trim();
    }

    /**
     * 获取评论者的USER AGENT
     *
     * @return comment_agent - 评论者的USER AGENT
     */
    public String getCommentAgent() {
        return commentAgent;
    }

    /**
     * 设置评论者的USER AGENT
     *
     * @param commentAgent 评论者的USER AGENT
     */
    public void setCommentAgent(String commentAgent) {
        this.commentAgent = commentAgent == null ? null : commentAgent.trim();
    }

    /**
     * 获取父评论ID
     *
     * @return comment_parent - 父评论ID
     */
    public Long getCommentParent() {
        return commentParent;
    }

    /**
     * 设置父评论ID
     *
     * @param commentParent 父评论ID
     */
    public void setCommentParent(Long commentParent) {
        this.commentParent = commentParent;
    }

    /**
     * 获取跟帖正文
     *
     * @return comment_content - 跟帖正文
     */
    public String getCommentContent() {
        return commentContent;
    }

    /**
     * 设置跟帖正文
     *
     * @param commentContent 跟帖正文
     */
    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent == null ? null : commentContent.trim();
    }

    @Override
    public String toString() {
        return "ForumComment{" +
                "commentId=" + commentId +
                ", commentPostId=" + commentPostId +
                ", commentUserId=" + commentUserId +
                ", commentIp='" + commentIp + '\'' +
                ", commentDate=" + commentDate +
                ", commentDateGmt=" + commentDateGmt +
                ", commentApproved='" + commentApproved + '\'' +
                ", commentAgent='" + commentAgent + '\'' +
                ", commentParent=" + commentParent +
                ", commentContent='" + commentContent + '\'' +
                '}';
    }
}