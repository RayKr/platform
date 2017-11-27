package com.boya.platform.marineonline.model.po;

import java.util.Date;
import javax.persistence.*;

@Table(name = "byp_personal_user_info")
public class BypPersonalUserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 姓名
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 昵称
     */
    @Column(name = "nick_name")
    private String nickName;

    /**
     * 手机号
     */
    @Column(name = "phone_num")
    private String phoneNum;

    /**
     * 性别，1女，2男
     */
    private String sex;

    /**
     * 头像fileid
     */
    @Column(name = "head_document_file_id")
    private Integer headDocumentFileId;

    /**
     * 邮箱地址
     */
    @Column(name = "mail_address")
    private String mailAddress;

    /**
     * 地址
     */
    private String address;

    /**
     * 公司名称
     */
    @Column(name = "company_name")
    private String companyName;

    /**
     * 公司职位
     */
    @Column(name = "company_post")
    private String companyPost;

    /**
     * 使用状态，0禁用，1启用
     */
    @Column(name = "use_status")
    private String useStatus;

    /**
     * 有效标记，0是无效，1是有效
     */
    @Column(name = "valid_flag")
    private String validFlag;

    /**
     * 删除标记，0是未删除，1是已删除
     */
    @Column(name = "del_flag")
    private String delFlag;

    /**
     * 创建人userid
     */
    @Column(name = "create_user_id")
    private Integer createUserId;

    /**
     * 创建时间
     */
    @Column(name = "create_date")
    private Date createDate;

    /**
     * 修改人userid
     */
    @Column(name = "update_user_id")
    private Integer updateUserId;

    /**
     * 修改时间
     */
    @Column(name = "update_date")
    private Date updateDate;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取姓名
     *
     * @return user_name - 姓名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置姓名
     *
     * @param userName 姓名
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * 获取昵称
     *
     * @return nick_name - 昵称
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * 设置昵称
     *
     * @param nickName 昵称
     */
    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    /**
     * 获取手机号
     *
     * @return phone_num - 手机号
     */
    public String getPhoneNum() {
        return phoneNum;
    }

    /**
     * 设置手机号
     *
     * @param phoneNum 手机号
     */
    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum == null ? null : phoneNum.trim();
    }

    /**
     * 获取性别，1女，2男
     *
     * @return sex - 性别，1女，2男
     */
    public String getSex() {
        return sex;
    }

    /**
     * 设置性别，1女，2男
     *
     * @param sex 性别，1女，2男
     */
    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    /**
     * 获取头像fileid
     *
     * @return head_document_file_id - 头像fileid
     */
    public Integer getHeadDocumentFileId() {
        return headDocumentFileId;
    }

    /**
     * 设置头像fileid
     *
     * @param headDocumentFileId 头像fileid
     */
    public void setHeadDocumentFileId(Integer headDocumentFileId) {
        this.headDocumentFileId = headDocumentFileId;
    }

    /**
     * 获取邮箱地址
     *
     * @return mail_address - 邮箱地址
     */
    public String getMailAddress() {
        return mailAddress;
    }

    /**
     * 设置邮箱地址
     *
     * @param mailAddress 邮箱地址
     */
    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress == null ? null : mailAddress.trim();
    }

    /**
     * 获取地址
     *
     * @return address - 地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置地址
     *
     * @param address 地址
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * 获取公司名称
     *
     * @return company_name - 公司名称
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * 设置公司名称
     *
     * @param companyName 公司名称
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    /**
     * 获取公司职位
     *
     * @return company_post - 公司职位
     */
    public String getCompanyPost() {
        return companyPost;
    }

    /**
     * 设置公司职位
     *
     * @param companyPost 公司职位
     */
    public void setCompanyPost(String companyPost) {
        this.companyPost = companyPost == null ? null : companyPost.trim();
    }

    /**
     * 获取使用状态，0禁用，1启用
     *
     * @return use_status - 使用状态，0禁用，1启用
     */
    public String getUseStatus() {
        return useStatus;
    }

    /**
     * 设置使用状态，0禁用，1启用
     *
     * @param useStatus 使用状态，0禁用，1启用
     */
    public void setUseStatus(String useStatus) {
        this.useStatus = useStatus == null ? null : useStatus.trim();
    }

    /**
     * 获取有效标记，0是无效，1是有效
     *
     * @return valid_flag - 有效标记，0是无效，1是有效
     */
    public String getValidFlag() {
        return validFlag;
    }

    /**
     * 设置有效标记，0是无效，1是有效
     *
     * @param validFlag 有效标记，0是无效，1是有效
     */
    public void setValidFlag(String validFlag) {
        this.validFlag = validFlag == null ? null : validFlag.trim();
    }

    /**
     * 获取删除标记，0是未删除，1是已删除
     *
     * @return del_flag - 删除标记，0是未删除，1是已删除
     */
    public String getDelFlag() {
        return delFlag;
    }

    /**
     * 设置删除标记，0是未删除，1是已删除
     *
     * @param delFlag 删除标记，0是未删除，1是已删除
     */
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }

    /**
     * 获取创建人userid
     *
     * @return create_user_id - 创建人userid
     */
    public Integer getCreateUserId() {
        return createUserId;
    }

    /**
     * 设置创建人userid
     *
     * @param createUserId 创建人userid
     */
    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    /**
     * 获取创建时间
     *
     * @return create_date - 创建时间
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

    /**
     * 获取修改人userid
     *
     * @return update_user_id - 修改人userid
     */
    public Integer getUpdateUserId() {
        return updateUserId;
    }

    /**
     * 设置修改人userid
     *
     * @param updateUserId 修改人userid
     */
    public void setUpdateUserId(Integer updateUserId) {
        this.updateUserId = updateUserId;
    }

    /**
     * 获取修改时间
     *
     * @return update_date - 修改时间
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * 设置修改时间
     *
     * @param updateDate 修改时间
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}