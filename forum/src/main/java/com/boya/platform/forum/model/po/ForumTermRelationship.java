package com.boya.platform.forum.model.po;

import java.util.Date;
import javax.persistence.*;

@Table(name = "forum_term_relationship")
public class ForumTermRelationship {
    /**
     * 分类与文章关联主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "term_relation_id")
    private Long termRelationId;

    @Column(name = "gmt_create")
    private Date gmtCreate;

    @Column(name = "gmt_modified")
    private Date gmtModified;

    /**
     * 文章ID
     */
    @Column(name = "post_id")
    private Long postId;

    /**
     * 分类ID
     */
    @Column(name = "term_id")
    private Long termId;

    /**
     * 获取分类与文章关联主键
     *
     * @return term_relation_id - 分类与文章关联主键
     */
    public Long getTermRelationId() {
        return termRelationId;
    }

    /**
     * 设置分类与文章关联主键
     *
     * @param termRelationId 分类与文章关联主键
     */
    public void setTermRelationId(Long termRelationId) {
        this.termRelationId = termRelationId;
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
     * 获取分类ID
     *
     * @return term_id - 分类ID
     */
    public Long getTermId() {
        return termId;
    }

    /**
     * 设置分类ID
     *
     * @param termId 分类ID
     */
    public void setTermId(Long termId) {
        this.termId = termId;
    }

    @Override
    public String toString() {
        return "ForumTermRelationship{" +
                "termRelationId=" + termRelationId +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                ", postId=" + postId +
                ", termId=" + termId +
                '}';
    }
}