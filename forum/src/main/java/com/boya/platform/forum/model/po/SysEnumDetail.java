package com.boya.platform.forum.model.po;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_enum_detail")
public class SysEnumDetail {
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
     * 枚举值
     */
    @Column(name = "enum_value")
    private Byte enumValue;

    /**
     * 枚举值显示名称
     */
    @Column(name = "enum_name")
    private String enumName;

    /**
     * 枚举描述
     */
    @Column(name = "enum_desc")
    private String enumDesc;

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
     * 获取枚举值
     *
     * @return enum_value - 枚举值
     */
    public Byte getEnumValue() {
        return enumValue;
    }

    /**
     * 设置枚举值
     *
     * @param enumValue 枚举值
     */
    public void setEnumValue(Byte enumValue) {
        this.enumValue = enumValue;
    }

    /**
     * 获取枚举值显示名称
     *
     * @return enum_name - 枚举值显示名称
     */
    public String getEnumName() {
        return enumName;
    }

    /**
     * 设置枚举值显示名称
     *
     * @param enumName 枚举值显示名称
     */
    public void setEnumName(String enumName) {
        this.enumName = enumName == null ? null : enumName.trim();
    }

    /**
     * 获取枚举描述
     *
     * @return enum_desc - 枚举描述
     */
    public String getEnumDesc() {
        return enumDesc;
    }

    /**
     * 设置枚举描述
     *
     * @param enumDesc 枚举描述
     */
    public void setEnumDesc(String enumDesc) {
        this.enumDesc = enumDesc == null ? null : enumDesc.trim();
    }

    @Override
    public String toString() {
        return "SysEnumDetail{" +
                "id=" + id +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                ", enumType='" + enumType + '\'' +
                ", enumValue=" + enumValue +
                ", enumName='" + enumName + '\'' +
                ", enumDesc='" + enumDesc + '\'' +
                '}';
    }
}