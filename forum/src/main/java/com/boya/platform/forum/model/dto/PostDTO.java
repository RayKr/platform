package com.boya.platform.forum.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @author Tsunglei Ching [ray@boyamarine.com]
 * @date 2017/11/13 17:10
 */
public class PostDTO {

    private Long post_id;

    private Long post_author_id;

    private String post_author_name;

    private String post_author_portrait;

    private String post_title;

    private String post_content;

    private String post_excerpt;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date post_date;

    private Long comment_count;

    private Long read_count;

    private Long like_count;

    private Boolean is_sticky;

    private Boolean is_top;

    private Boolean is_official;

    private Boolean is_followed;

    public Boolean getIs_sticky() {
        return is_sticky;
    }

    public void setIs_sticky(Boolean is_sticky) {
        this.is_sticky = is_sticky;
    }

    public Boolean getIs_top() {
        return is_top;
    }

    public void setIs_top(Boolean is_top) {
        this.is_top = is_top;
    }

    public Boolean getIs_official() {
        return is_official;
    }

    public void setIs_official(Boolean is_official) {
        this.is_official = is_official;
    }

    public Long getPost_id() {
        return post_id;
    }

    public void setPost_id(Long post_id) {
        this.post_id = post_id;
    }

    public Long getPost_author_id() {
        return post_author_id;
    }

    public void setPost_author_id(Long post_author_id) {
        this.post_author_id = post_author_id;
    }

    public String getPost_author_name() {
        return post_author_name;
    }

    public void setPost_author_name(String post_author_name) {
        this.post_author_name = post_author_name;
    }

    public String getPost_author_portrait() {
        return post_author_portrait;
    }

    public void setPost_author_portrait(String post_author_portrait) {
        this.post_author_portrait = post_author_portrait;
    }

    public String getPost_title() {
        return post_title;
    }

    public void setPost_title(String post_title) {
        this.post_title = post_title;
    }

    public String getPost_content() {
        return post_content;
    }

    public void setPost_content(String post_content) {
        this.post_content = post_content;
    }

    public String getPost_excerpt() {
        return post_excerpt;
    }

    public void setPost_excerpt(String post_excerpt) {
        this.post_excerpt = post_excerpt;
    }

    public Date getPost_date() {
        return post_date;
    }

    public void setPost_date(Date post_date) {
        this.post_date = post_date;
    }

    public Long getComment_count() {
        return comment_count;
    }

    public void setComment_count(Long comment_count) {
        this.comment_count = comment_count;
    }

    public Long getRead_count() {
        return read_count;
    }

    public void setRead_count(Long read_count) {
        this.read_count = read_count;
    }

    public Long getLike_count() {
        return like_count;
    }

    public void setLike_count(Long like_count) {
        this.like_count = like_count;
    }

    public Boolean getIs_followed() {
        return is_followed;
    }

    public void setIs_followed(Boolean is_followed) {
        this.is_followed = is_followed;
    }

    @Override
    public String toString() {
        return "PostDTO{" +
                "post_id=" + post_id +
                ", post_author_id=" + post_author_id +
                ", post_author_name='" + post_author_name + '\'' +
                ", post_author_portrait='" + post_author_portrait + '\'' +
                ", post_title='" + post_title + '\'' +
                ", post_content='" + post_content + '\'' +
                ", post_excerpt='" + post_excerpt + '\'' +
                ", post_date=" + post_date +
                ", comment_count=" + comment_count +
                ", read_count=" + read_count +
                ", like_count=" + like_count +
                '}';
    }
}
