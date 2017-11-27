package com.boya.platform.forum.util;

import com.boya.platform.forum.model.po.ForumUser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Session工具包
 *
 * @author Tsunglei Ching [ray@boyamarine.com]
 * @date 2017/11/13 10:44
 */
public class SessionUtil {

    /**
     * 检查登录状态
     *
     * @param session session
     * @return true-登录； false-未登录
     */
    public static boolean checkLogin(HttpSession session) {
        return session != null && session.getAttribute(Constants.SESSION_ATTRIBUTE_ID) != null;
    }

    /**
     * 检查是否存在覆盖登录
     * 即当前已有用户登录未登出，换用其他用户覆盖登录
     *
     * @param session session
     * @param loginName 登录名
     * @return true-存在覆盖登录； false-无覆盖登录
     */
    public static boolean checkCoverlogin(HttpSession session, String loginName) {
        String existLoginName = SessionUtil.getLoginName(session);
        return existLoginName != null && !loginName.equals(existLoginName);
    }

    /**
     * 登录后保存用户信息到session
     *
     * @param session
     * @param user
     */
    public static void setAttribute(HttpSession session, ForumUser user) {
        // 保存userId到session中
        if (session.getAttribute(Constants.SESSION_ATTRIBUTE_ID) == null) {
            session.setAttribute(Constants.SESSION_ATTRIBUTE_ID, user.getUserId());
        }
        // 保存loginName到session中
        if (session.getAttribute(Constants.SESSION_ATTRIBUTE_LOGINNAME) == null) {
            session.setAttribute(Constants.SESSION_ATTRIBUTE_LOGINNAME, user.getLoginName());
        }
    }

    /**
     * 登出后从session中移除用户信息
     *
     * @param request
     */
    public static void removeAttribute(HttpServletRequest request) {
        // 清空session信息
        request.getSession(false).removeAttribute(Constants.SESSION_ATTRIBUTE_ID);
        request.getSession(false).removeAttribute(Constants.SESSION_ATTRIBUTE_LOGINNAME);
    }

    /**
     * 从session中获取用户ID
     *
     * @param session session
     * @return user_id
     */
    public static Long getUserId(HttpSession session) {
        return session != null ? (Long) session.getAttribute(Constants.SESSION_ATTRIBUTE_ID) : null;
    }

    /**
     * 从session中获取用户ID
     *
     * @param session session
     * @return user_id
     */
    public static String getLoginName(HttpSession session) {
        return session != null ? (String) session.getAttribute(Constants.SESSION_ATTRIBUTE_LOGINNAME) : null;
    }

}
