package com.boya.platform.forum.model.dto;

/**
 * @author Tsunglei Ching [ray@boyamarine.com]
 * @date 2017/11/13 13:20
 */
public class Company {

    private String address;

    private String phone;

    private String mail;

    private String contacts_name;

    private String contacts_phone;

    private String contacts_mail;

    private String contacts_post;

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return this.mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getContacts_name() {
        return this.contacts_name;
    }

    public void setContacts_name(String contactsName) {
        this.contacts_name = contactsName;
    }

    public String getContacts_phone() {
        return this.contacts_phone;
    }

    public void setContacts_phone(String contactsPhone) {
        this.contacts_phone = contactsPhone;
    }

    public String getContacts_mail() {
        return this.contacts_mail;
    }

    public void setContacts_mail(String contactsMail) {
        this.contacts_mail = contactsMail;
    }

    public String getContacts_post() {
        return this.contacts_post;
    }

    public void setContacts_post(String contactsPost) {
        this.contacts_post = contactsPost;
    }
}
