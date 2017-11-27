package com.boya.platform.marineonline.model.dto;

/**
 * 论坛用户实体
 * @author Tsunglei Ching
 * @date 2017-11-27
 */
public class ForumUserDTO {
    /**
     * 自增主键
     */
    private Long userId;

    /**
     * 登录名
     */
    private String loginName;

    /**
     * 登录密码
     */
    private String password;

    /**
     * 头像路径
     */
    private String portrait;

    /**
     * 积分
     */
    private Integer integration;

    /**
     * 个性签名
     */
    private String signature;

    /**
     * 用户类别（1-个人；2-企业）
     */
    private Byte userType;

    /**
     * 所属行业
     */
    private Byte trade;

    /**
     * 个人姓名
     */
    private String personalName;

    /**
     * 个人电话
     */
    private String personalPhone;

    /**
     * 个人性别
     */
    private Byte personalSex;

    /**
     * 个人邮箱
     */
    private String personalMail;

    /**
     * 个人所在公司名称
     */
    private String personalCompanyName;

    /**
     * 个人职位
     */
    private String personalPost;

    /**
     * 显示名字，个人用户显示个人名称，企业用户显示企业名称
     */
    private String displayName;

    /**
     * 获取自增主键
     *
     * @return user_id - 自增主键
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置自增主键
     *
     * @param userId 自增主键
     */
    public void setUserId(Long userId) {
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
     * 获取登录密码
     *
     * @return password - 登录密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置登录密码
     *
     * @param password 登录密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 获取头像路径
     *
     * @return portrait - 头像路径
     */
    public String getPortrait() {
        return portrait;
    }

    /**
     * 设置头像路径
     *
     * @param portrait 头像路径
     */
    public void setPortrait(String portrait) {
        this.portrait = portrait == null ? null : portrait.trim();
    }

    /**
     * 获取积分
     *
     * @return integration - 积分
     */
    public Integer getIntegration() {
        return integration;
    }

    /**
     * 设置积分
     *
     * @param integration 积分
     */
    public void setIntegration(Integer integration) {
        this.integration = integration;
    }

    /**
     * 获取个性签名
     *
     * @return signature - 个性签名
     */
    public String getSignature() {
        return signature;
    }

    /**
     * 设置个性签名
     *
     * @param signature 个性签名
     */
    public void setSignature(String signature) {
        this.signature = signature == null ? null : signature.trim();
    }

    /**
     * 获取用户类别（1-个人；2-企业）
     *
     * @return user_type - 用户类别（1-个人；2-企业）
     */
    public Byte getUserType() {
        return userType;
    }

    /**
     * 设置用户类别（1-个人；2-企业）
     *
     * @param userType 用户类别（1-个人；2-企业）
     */
    public void setUserType(Byte userType) {
        this.userType = userType;
    }

    /**
     * 获取所属行业
     *
     * @return trade - 所属行业
     */
    public Byte getTrade() {
        return trade;
    }

    /**
     * 设置所属行业
     *
     * @param trade 所属行业
     */
    public void setTrade(Byte trade) {
        this.trade = trade;
    }

    /**
     * 获取个人姓名
     *
     * @return personal_name - 个人姓名
     */
    public String getPersonalName() {
        return personalName;
    }

    /**
     * 设置个人姓名
     *
     * @param personalName 个人姓名
     */
    public void setPersonalName(String personalName) {
        this.personalName = personalName == null ? null : personalName.trim();
    }

    /**
     * 获取个人电话
     *
     * @return personal_phone - 个人电话
     */
    public String getPersonalPhone() {
        return personalPhone;
    }

    /**
     * 设置个人电话
     *
     * @param personalPhone 个人电话
     */
    public void setPersonalPhone(String personalPhone) {
        this.personalPhone = personalPhone == null ? null : personalPhone.trim();
    }

    /**
     * 获取个人性别
     *
     * @return personal_sex - 个人性别
     */
    public Byte getPersonalSex() {
        return personalSex;
    }

    /**
     * 设置个人性别
     *
     * @param personalSex 个人性别
     */
    public void setPersonalSex(Byte personalSex) {
        this.personalSex = personalSex;
    }

    /**
     * 获取个人邮箱
     *
     * @return personal_mail - 个人邮箱
     */
    public String getPersonalMail() {
        return personalMail;
    }

    /**
     * 设置个人邮箱
     *
     * @param personalMail 个人邮箱
     */
    public void setPersonalMail(String personalMail) {
        this.personalMail = personalMail == null ? null : personalMail.trim();
    }

    /**
     * 获取个人所在公司名称
     *
     * @return personal_company_name - 个人所在公司名称
     */
    public String getPersonalCompanyName() {
        return personalCompanyName;
    }

    /**
     * 设置个人所在公司名称
     *
     * @param personalCompanyName 个人所在公司名称
     */
    public void setPersonalCompanyName(String personalCompanyName) {
        this.personalCompanyName = personalCompanyName == null ? null : personalCompanyName.trim();
    }

    /**
     * 获取个人职位
     *
     * @return personal_post - 个人职位
     */
    public String getPersonalPost() {
        return personalPost;
    }

    /**
     * 设置个人职位
     *
     * @param personalPost 个人职位
     */
    public void setPersonalPost(String personalPost) {
        this.personalPost = personalPost == null ? null : personalPost.trim();
    }

    /**
     * 获取显示名字，个人用户显示个人名称，企业用户显示企业名称
     *
     * @return display_name - 显示名字，个人用户显示个人名称，企业用户显示企业名称
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * 设置显示名字，个人用户显示个人名称，企业用户显示企业名称
     *
     * @param displayName 显示名字，个人用户显示个人名称，企业用户显示企业名称
     */
    public void setDisplayName(String displayName) {
        this.displayName = displayName == null ? null : displayName.trim();
    }

    @Override
    public String toString() {
        return "ForumUserDTO{" +
                "userId=" + userId +
                ", loginName='" + loginName + '\'' +
                ", password='" + password + '\'' +
                ", portrait='" + portrait + '\'' +
                ", integration=" + integration +
                ", signature='" + signature + '\'' +
                ", userType=" + userType +
                ", trade=" + trade +
                ", personalName='" + personalName + '\'' +
                ", personalPhone='" + personalPhone + '\'' +
                ", personalSex=" + personalSex +
                ", personalMail='" + personalMail + '\'' +
                ", personalCompanyName='" + personalCompanyName + '\'' +
                ", personalPost='" + personalPost + '\'' +
                ", displayName='" + displayName + '\'' +
                '}';
    }
}