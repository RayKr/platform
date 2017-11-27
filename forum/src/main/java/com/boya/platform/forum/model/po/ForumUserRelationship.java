package com.boya.platform.forum.model.po;

import java.util.Date;
import javax.persistence.*;

@Table(name = "forum_user_relationship")
public class ForumUserRelationship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_relation_id")
    private Long userRelationId;

    @Column(name = "gmt_create")
    private Date gmtCreate;

    @Column(name = "gmt_modified")
    private Date gmtModified;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "follower_id")
    private Long followerId;

    /**
     * @return user_relation_id
     */
    public Long getUserRelationId() {
        return userRelationId;
    }

    /**
     * @param userRelationId
     */
    public void setUserRelationId(Long userRelationId) {
        this.userRelationId = userRelationId;
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
     * @return gmt_modified
     */
    public Date getGmtModified() {
        return gmtModified;
    }

    /**
     * @param gmtModified
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
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
     * @return follower_id
     */
    public Long getFollowerId() {
        return followerId;
    }

    /**
     * @param followerId
     */
    public void setFollowerId(Long followerId) {
        this.followerId = followerId;
    }

    @Override
    public String toString() {
        return "ForumUserRelationship{" +
                "userRelationId=" + userRelationId +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                ", userId=" + userId +
                ", followerId=" + followerId +
                '}';
    }
}