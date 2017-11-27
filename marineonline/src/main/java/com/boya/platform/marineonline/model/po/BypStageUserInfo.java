package com.boya.platform.marineonline.model.po;

import java.util.Date;
import javax.persistence.*;

@Table(name = "byp_stage_user_info")
public class BypStageUserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 对应前台个人和企业用户ID
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 登录名
     */
    @Column(name = "login_name")
    private String loginName;

    /**
     * 手机号
     */
    @Column(name = "login_phone")
    private String loginPhone;

    /**
     * 邮箱
     */
    @Column(name = "login_mail")
    private String loginMail;

    /**
     * 密码
     */
    private String password;

    /**
     * 用户类型，1是个人用户，2是企业用户
     */
    @Column(name = "user_type")
    private String userType;

    /**
     * 状态，1正常，7限制登录，8锁定，9封停
     */
    private String status;

    /**
     * 登录状态异常原因
     */
    @Column(name = "status_content")
    private String statusContent;

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
     * 最近一次登录时间
     */
    @Column(name = "last_login_time")
    private Date lastLoginTime;

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
     * 获取对应前台个人和企业用户ID
     *
     * @return user_id - 对应前台个人和企业用户ID
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置对应前台个人和企业用户ID
     *
     * @param userId 对应前台个人和企业用户ID
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取登录名
     *
     * @return login_name - 登录名
     */
    public String getLoginName() {
        return loginName;
    }

    /**
     * 设置登录名
     *
     * @param loginName 登录名
     */
    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    /**
     * 获取手机号
     *
     * @return login_phone - 手机号
     */
    public String getLoginPhone() {
        return loginPhone;
    }

    /**
     * 设置手机号
     *
     * @param loginPhone 手机号
     */
    public void setLoginPhone(String loginPhone) {
        this.loginPhone = loginPhone == null ? null : loginPhone.trim();
    }

    /**
     * 获取邮箱
     *
     * @return login_mail - 邮箱
     */
    public String getLoginMail() {
        return loginMail;
    }

    /**
     * 设置邮箱
     *
     * @param loginMail 邮箱
     */
    public void setLoginMail(String loginMail) {
        this.loginMail = loginMail == null ? null : loginMail.trim();
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 获取用户类型，1是个人用户，2是企业用户
     *
     * @return user_type - 用户类型，1是个人用户，2是企业用户
     */
    public String getUserType() {
        return userType;
    }

    /**
     * 设置用户类型，1是个人用户，2是企业用户
     *
     * @param userType 用户类型，1是个人用户，2是企业用户
     */
    public void setUserType(String userType) {
        this.userType = userType == null ? null : userType.trim();
    }

    /**
     * 获取状态，1正常，7限制登录，8锁定，9封停
     *
     * @return status - 状态，1正常，7限制登录，8锁定，9封停
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置状态，1正常，7限制登录，8锁定，9封停
     *
     * @param status 状态，1正常，7限制登录，8锁定，9封停
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 获取登录状态异常原因
     *
     * @return status_content - 登录状态异常原因
     */
    public String getStatusContent() {
        return statusContent;
    }

    /**
     * 设置登录状态异常原因
     *
     * @param statusContent 登录状态异常原因
     */
    public void setStatusContent(String statusContent) {
        this.statusContent = statusContent == null ? null : statusContent.trim();
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
     * 获取最近一次登录时间
     *
     * @return last_login_time - 最近一次登录时间
     */
    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    /**
     * 设置最近一次登录时间
     *
     * @param lastLoginTime 最近一次登录时间
     */
    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
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

    @Override
    public String toString() {
        return "BypStageUserInfo{" +
                "id=" + id +
                ", userId=" + userId +
                ", loginName='" + loginName + '\'' +
                ", loginPhone='" + loginPhone + '\'' +
                ", loginMail='" + loginMail + '\'' +
                ", password='" + password + '\'' +
                ", userType='" + userType + '\'' +
                ", status='" + status + '\'' +
                ", statusContent='" + statusContent + '\'' +
                ", useStatus='" + useStatus + '\'' +
                ", validFlag='" + validFlag + '\'' +
                ", delFlag='" + delFlag + '\'' +
                ", lastLoginTime=" + lastLoginTime +
                ", createUserId=" + createUserId +
                ", createDate=" + createDate +
                ", updateUserId=" + updateUserId +
                ", updateDate=" + updateDate +
                '}';
    }
}