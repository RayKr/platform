package com.boya.platform.forum.model.dto;

/**
 * @author Tsunglei Ching [ray@boyamarine.com]
 * @date 2017/11/13 13:20
 */
public class Person {

    public String phone;

    private Byte sex;

    private String mail;

    private String company_name;

    private String contacts_post;

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Byte getSex() {
        return this.sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    public String getMail() {
        return this.mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getCompany_name() {
        return this.company_name;
    }

    public void setCompany_name(String companyName) {
        this.company_name = companyName;
    }

    public String getContacts_post() {
        return this.contacts_post;
    }

    public void setContacts_post(String post) {
        this.contacts_post = post;
    }
}
