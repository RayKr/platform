package com.boya.platform.marineonline.model.po;

import java.util.Date;
import javax.persistence.*;

@Table(name = "lsp_document_file_info")
public class LspDocumentFileInfo {
    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    /**
     * 附件表ID
     */
    @Column(name = "DOCUMENT_MAIN_ID")
    private Integer documentMainId;

    /**
     * 名称
     */
    @Column(name = "NAME")
    private String name;

    /**
     * 附件地址
     */
    @Column(name = "URL")
    private String url;

    /**
     * 附件服务器名称
     */
    @Column(name = "SERVER_NAME")
    private String serverName;

    /**
     * 排序
     */
    @Column(name = "SORT")
    private Integer sort;

    /**
     * 创建人
     */
    @Column(name = "CREATE_USER")
    private String createUser;

    /**
     * 创建时间
     */
    @Column(name = "CREATE_DATE")
    private Date createDate;

    /**
     * 获取ID
     *
     * @return ID - ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置ID
     *
     * @param id ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取附件表ID
     *
     * @return DOCUMENT_MAIN_ID - 附件表ID
     */
    public Integer getDocumentMainId() {
        return documentMainId;
    }

    /**
     * 设置附件表ID
     *
     * @param documentMainId 附件表ID
     */
    public void setDocumentMainId(Integer documentMainId) {
        this.documentMainId = documentMainId;
    }

    /**
     * 获取名称
     *
     * @return NAME - 名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置名称
     *
     * @param name 名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取附件地址
     *
     * @return URL - 附件地址
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置附件地址
     *
     * @param url 附件地址
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * 获取附件服务器名称
     *
     * @return SERVER_NAME - 附件服务器名称
     */
    public String getServerName() {
        return serverName;
    }

    /**
     * 设置附件服务器名称
     *
     * @param serverName 附件服务器名称
     */
    public void setServerName(String serverName) {
        this.serverName = serverName == null ? null : serverName.trim();
    }

    /**
     * 获取排序
     *
     * @return SORT - 排序
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置排序
     *
     * @param sort 排序
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * 获取创建人
     *
     * @return CREATE_USER - 创建人
     */
    public String getCreateUser() {
        return createUser;
    }

    /**
     * 设置创建人
     *
     * @param createUser 创建人
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    /**
     * 获取创建时间
     *
     * @return CREATE_DATE - 创建时间
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 设置创建时间
     *
     * @param createDate 创建时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}