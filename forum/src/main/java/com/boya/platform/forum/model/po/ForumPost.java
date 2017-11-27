package com.boya.platform.forum.model.po;

import java.util.Date;
import javax.persistence.*;

@Table(name = "forum_post")
public class ForumPost {
    /**
     * 文章ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long postId;

    /**
     * 作者ID
     */
    @Column(name = "post_author_id")
    private Long postAuthorId;

    /**
     * 发布时间
     */
    @Column(name = "post_date")
    private Date postDate;

    /**
     * 发布时间GMT
     */
    @Column(name = "post_date_gmt")
    private Date postDateGmt;

    /**
     * 缩略名
     */
    @Column(name = "post_name")
    private String postName;

    /**
     * 状态（发布、草稿、删除）
     */
    @Column(name = "post_status")
    private Byte postStatus;

    /**
     * 密码
     */
    @Column(name = "post_password")
    private String postPassword;

    /**
     * 修改时间
     */
    @Column(name = "post_modified")
    private Date postModified;

    /**
     * 修改时间GMT
     */
    @Column(name = "post_modified_gmt")
    private Date postModifiedGmt;

    /**
     * MIME
     */
    @Column(name = "post_mime_type")
    private String postMimeType;

    /**
     * 评论状态（可评论/关闭评论）
     */
    @Column(name = "comment_status")
    private Byte commentStatus;

    /**
     * 阅读数
     */
    @Column(name = "read_count")
    private Long readCount;

    /**
     * 是否加精
     */
    @Column(name = "is_sticky")
    private Boolean isSticky;

    /**
     * 是否官方
     */
    @Column(name = "is_official")
    private Boolean isOfficial;

    /**
     * 是否置顶
     */
    @Column(name = "is_top")
    private Boolean isTop;

    /**
     * 正文
     */
    @Column(name = "post_content")
    private String postContent;

    /**
     * 标题
     */
    @Column(name = "post_title")
    private String postTitle;

    /**
     * 摘录
     */
    @Column(name = "post_excerpt")
    private String postExcerpt;

    /**
     * 获取文章ID
     *
     * @return post_id - 文章ID
     */
    public Long getPostId() {
        return postId;
    }

    /**
     * 设置文章ID
     *
     * @param postId 文章ID
     */
    public void setPostId(Long postId) {
        this.postId = postId;
    }

    /**
     * 获取作者ID
     *
     * @return post_author_id - 作者ID
     */
    public Long getPostAuthorId() {
        return postAuthorId;
    }

    /**
     * 设置作者ID
     *
     * @param postAuthorId 作者ID
     */
    public void setPostAuthorId(Long postAuthorId) {
        this.postAuthorId = postAuthorId;
    }

    /**
     * 获取发布时间
     *
     * @return post_date - 发布时间
     */
    public Date getPostDate() {
        return postDate;
    }

    /**
     * 设置发布时间
     *
     * @param postDate 发布时间
     */
    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    /**
     * 获取发布时间GMT
     *
     * @return post_date_gmt - 发布时间GMT
     */
    public Date getPostDateGmt() {
        return postDateGmt;
    }

    /**
     * 设置发布时间GMT
     *
     * @param postDateGmt 发布时间GMT
     */
    public void setPostDateGmt(Date postDateGmt) {
        this.postDateGmt = postDateGmt;
    }

    /**
     * 获取缩略名
     *
     * @return post_name - 缩略名
     */
    public String getPostName() {
        return postName;
    }

    /**
     * 设置缩略名
     *
     * @param postName 缩略名
     */
    public void setPostName(String postName) {
        this.postName = postName == null ? null : postName.trim();
    }

    /**
     * 获取状态（发布、草稿、删除）
     *
     * @return post_status - 状态（发布、草稿、删除）
     */
    public Byte getPostStatus() {
        return postStatus;
    }

    /**
     * 设置状态（发布、草稿、删除）
     *
     * @param postStatus 状态（发布、草稿、删除）
     */
    public void setPostStatus(Byte postStatus) {
        this.postStatus = postStatus;
    }

    /**
     * 获取密码
     *
     * @return post_password - 密码
     */
    public String getPostPassword() {
        return postPassword;
    }

    /**
     * 设置密码
     *
     * @param postPassword 密码
     */
    public void setPostPassword(String postPassword) {
        this.postPassword = postPassword == null ? null : postPassword.trim();
    }

    /**
     * 获取修改时间
     *
     * @return post_modified - 修改时间
     */
    public Date getPostModified() {
        return postModified;
    }

    /**
     * 设置修改时间
     *
     * @param postModified 修改时间
     */
    public void setPostModified(Date postModified) {
        this.postModified = postModified;
    }

    /**
     * 获取修改时间GMT
     *
     * @return post_modified_gmt - 修改时间GMT
     */
    public Date getPostModifiedGmt() {
        return postModifiedGmt;
    }

    /**
     * 设置修改时间GMT
     *
     * @param postModifiedGmt 修改时间GMT
     */
    public void setPostModifiedGmt(Date postModifiedGmt) {
        this.postModifiedGmt = postModifiedGmt;
    }

    /**
     * 获取MIME
     *
     * @return post_mime_type - MIME
     */
    public String getPostMimeType() {
        return postMimeType;
    }

    /**
     * 设置MIME
     *
     * @param postMimeType MIME
     */
    public void setPostMimeType(String postMimeType) {
        this.postMimeType = postMimeType == null ? null : postMimeType.trim();
    }

    /**
     * 获取评论状态（可评论/关闭评论）
     *
     * @return comment_status - 评论状态（可评论/关闭评论）
     */
    public Byte getCommentStatus() {
        return commentStatus;
    }

    /**
     * 设置评论状态（可评论/关闭评论）
     *
     * @param commentStatus 评论状态（可评论/关闭评论）
     */
    public void setCommentStatus(Byte commentStatus) {
        this.commentStatus = commentStatus;
    }

    /**
     * 获取阅读数
     *
     * @return read_count - 阅读数
     */
    public Long getReadCount() {
        return readCount;
    }

    /**
     * 设置阅读数
     *
     * @param readCount 阅读数
     */
    public void setReadCount(Long readCount) {
        this.readCount = readCount;
    }

    /**
     * 获取是否加精
     *
     * @return is_sticky - 是否加精
     */
    public Boolean getIsSticky() {
        return isSticky;
    }

    /**
     * 设置是否加精
     *
     * @param isSticky 是否加精
     */
    public void setIsSticky(Boolean isSticky) {
        this.isSticky = isSticky;
    }

    /**
     * 获取是否官方
     *
     * @return is_official - 是否官方
     */
    public Boolean getIsOfficial() {
        return isOfficial;
    }

    /**
     * 设置是否官方
     *
     * @param isOfficial 是否官方
     */
    public void setIsOfficial(Boolean isOfficial) {
        this.isOfficial = isOfficial;
    }

    /**
     * 获取是否置顶
     *
     * @return is_top - 是否置顶
     */
    public Boolean getIsTop() {
        return isTop;
    }

    /**
     * 设置是否置顶
     *
     * @param isTop 是否置顶
     */
    public void setIsTop(Boolean isTop) {
        this.isTop = isTop;
    }

    /**
     * 获取正文
     *
     * @return post_content - 正文
     */
    public String getPostContent() {
        return postContent;
    }

    /**
     * 设置正文
     *
     * @param postContent 正文
     */
    public void setPostContent(String postContent) {
        this.postContent = postContent == null ? null : postContent.trim();
    }

    /**
     * 获取标题
     *
     * @return post_title - 标题
     */
    public String getPostTitle() {
        return postTitle;
    }

    /**
     * 设置标题
     *
     * @param postTitle 标题
     */
    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle == null ? null : postTitle.trim();
    }

    /**
     * 获取摘录
     *
     * @return post_excerpt - 摘录
     */
    public String getPostExcerpt() {
        return postExcerpt;
    }

    /**
     * 设置摘录
     *
     * @param postExcerpt 摘录
     */
    public void setPostExcerpt(String postExcerpt) {
        this.postExcerpt = postExcerpt == null ? null : postExcerpt.trim();
    }

    @Override
    public String toString() {
        return "ForumPost{" +
                "postId=" + postId +
                ", postAuthorId=" + postAuthorId +
                ", postDate=" + postDate +
                ", postDateGmt=" + postDateGmt +
                ", postName='" + postName + '\'' +
                ", postStatus=" + postStatus +
                ", postPassword='" + postPassword + '\'' +
                ", postModified=" + postModified +
                ", postModifiedGmt=" + postModifiedGmt +
                ", postMimeType='" + postMimeType + '\'' +
                ", commentStatus=" + commentStatus +
                ", readCount=" + readCount +
                ", isSticky=" + isSticky +
                ", isOfficial=" + isOfficial +
                ", isTop=" + isTop +
                ", postContent='" + postContent + '\'' +
                ", postTitle='" + postTitle + '\'' +
                ", postExcerpt='" + postExcerpt + '\'' +
                '}';
    }
}