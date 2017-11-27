package com.boya.platform.forum.model.dto;

/**
 * 用户信息DTO
 * @author Tsunglei Ching [ray@boyamarine.com]
 * @date 2017/11/11 10:31
 */
public class UserDTO {

    /**
     * 用户ID
     */
    private Long user_id;

    /**
     * 头像
     */
    private String portrait;

    /**
     * 登录名
     */
    private String login_name;

    /**
     * 姓名
     */
    private String name;

    /**
     * 积分
     */
    private Integer integration;

    /**
     * 个性签名
     */
    private String signature;

    /**
     * 用户类型
     */
    private Byte usertype;

    /**
     * 个人信息
     */
    private Person person;

    /**
     * 企业信息
     */
    private Company company;

    /**
     * 是否已关注该用户
     */
    private Boolean is_followed;

    public Boolean getIs_followed() {
        return is_followed;
    }

    public void setIs_followed(Boolean is_followed) {
        this.is_followed = is_followed;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin_name() {
        return login_name;
    }

    public void setLogin_name(String login_name) {
        this.login_name = login_name;
    }

    public Integer getIntegration() {
        return integration;
    }

    public void setIntegration(Integer integration) {
        this.integration = integration;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public Byte getUsertype() {
        return usertype;
    }

    public void setUsertype(Byte usertype) {
        this.usertype = usertype;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "portrait='" + portrait + '\'' +
                ", name='" + name + '\'' +
                ", integration='" + integration + '\'' +
                ", signature='" + signature + '\'' +
                ", usertype=" + usertype +
                '}';
    }
}
