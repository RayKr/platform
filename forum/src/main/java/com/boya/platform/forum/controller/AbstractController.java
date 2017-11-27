package com.boya.platform.forum.controller;

import com.boya.platform.forum.model.dto.ResponseDTO;
import com.boya.platform.forum.model.po.ForumUser;
import com.boya.platform.forum.util.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * 提取Controller抽象类
 * @author Tsunglei Ching [ray@boyamarine.com]
 * @date 2017/11/13 17:44
 */
@Controller
public abstract class AbstractController {

    /**
     * 用来返回给前端的封装对象
     */
    protected ResponseDTO res;

    protected Long userId;

    @Autowired
    protected HttpServletRequest request;

    @Autowired
    protected HttpSession session;

    protected boolean checkLogin(ForumUser user, String loginName) {
        res = new ResponseDTO();
        // 验证是否存在覆盖登录
        if (SessionUtil.checkCoverlogin(session, loginName)){
            res.setResult(false);
            res.setMsg("您已登录其他用户，请登出后再登录！");
            return false;
        }
        // 若首次登录，则写入session
        if (!SessionUtil.checkLogin(session)) {
            SessionUtil.setAttribute(session, user);
        }
        res.setResult(true);
        return true;
    }

    /**
     * 检查用户登录状态
     * @return ResponseJSON
     */
    protected boolean checkUserStatus() {
        if (!isLogin()) {
            res.setResult(false);
            res.setMsg("请先登录！");
            return false;
        } else {
            res.setResult(true);
            return true;
        }
    }

    /**
     * 判断当前是否已登录
     * @return true-已登录，false-未登录
     */
    protected boolean isLogin() {
        res = new ResponseDTO();
        boolean islogin = SessionUtil.checkLogin(session);
        if (islogin) {
            // 获取当前登录用户
            userId = SessionUtil.getUserId(session);
        }
        return islogin;
    }

    /**
     * 获取查看目标的userid
     * @param map
     * @return
     */
    protected Long getAimUserId(Map map) {
        Long curUserId = null;
        if (map.containsKey("user_id")) {
            curUserId = Long.parseLong(map.get("user_id").toString());
            res = new ResponseDTO();
        } else {
            // 验证用户登录状态
            if (checkUserStatus()) {
                curUserId = userId;
            }
        }
        return curUserId;
    }

}
