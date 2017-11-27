package com.boya.platform.forum.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @author Tsunglei Ching [ray@boyamarine.com]
 * @date 2017/11/13 20:22
 */
public class CommentDTO {

    private Long comment_id;

    private Long comment_post_id;

    private String comment_post_title;

    private Long comment_user_id;

    private String comment_user_name;

    private String comment_user_portrait;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date comment_date;

    private Long comment_parent;

    private String comment_content;

    public Long getComment_id() {
        return comment_id;
    }

    public void setComment_id(Long comment_id) {
        this.comment_id = comment_id;
    }

    public Long getComment_post_id() {
        return comment_post_id;
    }

    public void setComment_post_id(Long comment_post_id) {
        this.comment_post_id = comment_post_id;
    }

    public String getComment_post_title() {
        return comment_post_title;
    }

    public void setComment_post_title(String comment_post_tile) {
        this.comment_post_title = comment_post_tile;
    }

    public String getComment_user_name() {
        return comment_user_name;
    }

    public void setComment_user_name(String comment_user_name) {
        this.comment_user_name = comment_user_name;
    }

    public String getComment_user_portrait() {
        return comment_user_portrait;
    }

    public void setComment_user_portrait(String comment_user_portrait) {
        this.comment_user_portrait = comment_user_portrait;
    }

    public Long getComment_user_id() {
        return comment_user_id;
    }

    public void setComment_user_id(Long comment_user_id) {
        this.comment_user_id = comment_user_id;
    }

    public Date getComment_date() {
        return comment_date;
    }

    public void setComment_date(Date comment_date) {
        this.comment_date = comment_date;
    }

    public Long getComment_parent() {
        return comment_parent;
    }

    public void setComment_parent(Long comment_parent) {
        this.comment_parent = comment_parent;
    }

    public String getComment_content() {
        return comment_content;
    }

    public void setComment_content(String comment_content) {
        this.comment_content = comment_content;
    }

    @Override
    public String toString() {
        return "CommentDTO{" +
                "comment_id=" + comment_id +
                ", comment_post_id=" + comment_post_id +
                ", comment_post_title='" + comment_post_title + '\'' +
                ", comment_user_id=" + comment_user_id +
                ", comment_user_name='" + comment_user_name + '\'' +
                ", comment_user_portrait='" + comment_user_portrait + '\'' +
                ", comment_date=" + comment_date +
                ", comment_parent=" + comment_parent +
                ", comment_content='" + comment_content + '\'' +
                '}';
    }
}
