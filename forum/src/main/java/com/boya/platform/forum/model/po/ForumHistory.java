package com.boya.platform.forum.model.po;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import javax.persistence.*;

@Table(name = "forum_history")
public class ForumHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "history_id")
    private Long historyId;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Long userId;

    /**
     * 文章id
     */
    @Column(name = "post_id")
    private Long postId;

    /**
     * 浏览日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @Column(name = "history_date")
    private Date historyDate;

    /**
     * @return history_id
     */
    public Long getHistoryId() {
        return historyId;
    }

    /**
     * @param historyId
     */
    public void setHistoryId(Long historyId) {
        this.historyId = historyId;
    }

    /**
     * 获取用户id
     *
     * @return user_id - 用户id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置用户id
     *
     * @param userId 用户id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取文章id
     *
     * @return post_id - 文章id
     */
    public Long getPostId() {
        return postId;
    }

    /**
     * 设置文章id
     *
     * @param postId 文章id
     */
    public void setPostId(Long postId) {
        this.postId = postId;
    }

    /**
     * 获取浏览日期
     *
     * @return history_date - 浏览日期
     */
    public Date getHistoryDate() {
        return historyDate;
    }

    /**
     * 设置浏览日期
     *
     * @param historyDate 浏览日期
     */
    public void setHistoryDate(Date historyDate) {
        this.historyDate = historyDate;
    }
}