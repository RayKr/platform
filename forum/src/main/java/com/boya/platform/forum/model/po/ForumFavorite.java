package com.boya.platform.forum.model.po;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import javax.persistence.*;

@Table(name = "forum_favorite")
public class ForumFavorite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @Column(name = "gmt_create")
    private Date gmtCreate;

    @Column(name = "post_id")
    private Long postId;

    @Column(name = "user_id")
    private Long userId;

    /**
     * 收藏类型（FAVOR-收藏；LIKE-点赞）
     */
    @Column(name = "relate_type")
    private String relateType;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return gmt_create
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * @param gmtCreate
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * @return post_id
     */
    public Long getPostId() {
        return postId;
    }

    /**
     * @param postId
     */
    public void setPostId(Long postId) {
        this.postId = postId;
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
     * 获取收藏类型（FAVOR-收藏；LIKE-点赞）
     *
     * @return relate_type - 收藏类型（FAVOR-收藏；LIKE-点赞）
     */
    public String getRelateType() {
        return relateType;
    }

    /**
     * 设置收藏类型（FAVOR-收藏；LIKE-点赞）
     *
     * @param relateType 收藏类型（FAVOR-收藏；LIKE-点赞）
     */
    public void setRelateType(String relateType) {
        this.relateType = relateType == null ? null : relateType.trim();
    }
}