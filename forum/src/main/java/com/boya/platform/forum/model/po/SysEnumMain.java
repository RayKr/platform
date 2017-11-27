package com.boya.platform.forum.model.po;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_enum_main")
public class SysEnumMain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "gmt_create")
    private Date gmtCreate;

    @Column(name = "gmt_modified")
    private Date gmtModified;

    /**
     * 枚举类型
     */
    @Column(name = "enum_type")
    private String enumType;

    /**
     * 枚举名称
     */
    @Column(name = "enum_title")
    private String enumTitle;

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
     * 获取枚举类型
     *
     * @return enum_type - 枚举类型
     */
    public String getEnumType() {
        return enumType;
    }

    /**
     * 设置枚举类型
     *
     * @param enumType 枚举类型
     */
    public void setEnumType(String enumType) {
        this.enumType = enumType == null ? null : enumType.trim();
    }

    /**
     * 获取枚举名称
     *
     * @return enum_title - 枚举名称
     */
    public String getEnumTitle() {
        return enumTitle;
    }

    /**
     * 设置枚举名称
     *
     * @param enumTitle 枚举名称
     */
    public void setEnumTitle(String enumTitle) {
        this.enumTitle = enumTitle == null ? null : enumTitle.trim();
    }

    @Override
    public String toString() {
        return "SysEnumMain{" +
                "id=" + id +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                ", enumType='" + enumType + '\'' +
                ", enumTitle='" + enumTitle + '\'' +
                '}';
    }
}