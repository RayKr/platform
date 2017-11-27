package com.boya.platform.forum.model.po;

import java.util.Date;
import javax.persistence.*;

@Table(name = "forum_term")
public class ForumTerm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "term_id")
    private Long termId;

    @Column(name = "gmt_create")
    private Date gmtCreate;

    @Column(name = "gmt_modified")
    private Date gmtModified;

    @Column(name = "term_name")
    private String termName;

    @Column(name = "term_slug")
    private String termSlug;

    /**
     * @return term_id
     */
    public Long getTermId() {
        return termId;
    }

    /**
     * @param termId
     */
    public void setTermId(Long termId) {
        this.termId = termId;
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
     * @return term_name
     */
    public String getTermName() {
        return termName;
    }

    /**
     * @param termName
     */
    public void setTermName(String termName) {
        this.termName = termName == null ? null : termName.trim();
    }

    /**
     * @return term_slug
     */
    public String getTermSlug() {
        return termSlug;
    }

    /**
     * @param termSlug
     */
    public void setTermSlug(String termSlug) {
        this.termSlug = termSlug == null ? null : termSlug.trim();
    }

    @Override
    public String toString() {
        return "ForumTerm{" +
                "termId=" + termId +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                ", termName='" + termName + '\'' +
                ", termSlug='" + termSlug + '\'' +
                '}';
    }
}