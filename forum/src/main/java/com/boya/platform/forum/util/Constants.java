package com.boya.platform.forum.util;

/**
 * @author Tsunglei Ching [ray@boyamarine.com]
 * @date 2017/11/11 13:28
 */
public class Constants {

    /**
     * 用于存储用户信息的session属性字段
     */
    public static final String SESSION_ATTRIBUTE_ID = "userId";
    public static final String SESSION_ATTRIBUTE_LOGINNAME = "loginName";

    /**
     * 性别 0-女； 1-男
     */
    public static final Byte SEX_MALE = 1;
    public static final Byte SEX_FEMALE = 0;


    /**
     * 用户类型 1-个人； 2-企业
     */
    public static final Byte USER_TYPE_PERSONAL = 1;
    public static final Byte USER_TYPE_COMPANY = 2;

    /**
     * 海科在线平台用户类型 1-个人，2企业
     */
    public static final String USER_TYPE_PERSONAL_PLATFORM = "1";
    public static final String USER_TYPE_COMPANY_PLATFORM = "2";

    /**
     * 帖子状态
     */
    public static final Byte POST_STATUS_NORMAL = 1;
    public static final Byte POST_STATUS_DRAFT = 2;
    public static final Byte POST_STATUS_DELETED = 3;

    /**
     * 行业类别
     */
    public static final Byte TRADE_DEFAULT = 1;

    /**
     * 收藏帖子类型 FAVOR-收藏； LIKE-点赞/喜爱
     */
    public static final String FAVOR_TYPE_FAVORITE = "FAVOR";
    public static final String FAVOR_TYPE_LIKE = "LIKE";

    /**
     * 通知类型 1-关注，2-点赞，3-评论
     */
    public static final Byte NOTICE_TYPE_FOLLOW = 1;
    public static final Byte NOTICE_TYPE_LIKE = 2;
    public static final Byte NOTICE_TYPE_COMMENT = 3;

    /**
     * 通知状态 0-未读，1已读
     */
    public static final Byte NOTICE_STATUS_UNREAD = 0;
    public static final Byte NOTICE_STATUS_READED = 1;

    /**
     * MD5后缀
     */
    public static final String LOGIN_PASSWORD_MD5SUFFIX = "&BOYA_SUFFIX";
    public static final String CENTER_CHAT_MD5SUFFIX = "&BOYA_CHAT";

}
