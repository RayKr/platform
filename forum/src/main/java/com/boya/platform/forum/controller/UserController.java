package com.boya.platform.forum.controller;

import com.boya.platform.forum.model.dto.ResponseDTO;
import com.boya.platform.forum.model.dto.UserDTO;
import com.boya.platform.forum.model.po.ForumNoticeExtend;
import com.boya.platform.forum.model.po.ForumUser;
import com.boya.platform.forum.service.UserService;
import com.boya.platform.forum.util.Constants;
import com.boya.platform.forum.util.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 用户信息相关路由
 * @author Tsunglei Ching [ray@boyamarine.com]
 * @date 2017/11/9 13:12
 */
@RestController
@RequestMapping(value = "/api/user")
public class UserController extends AbstractController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/info")
    public Object getUserInfo() {
        // 验证用户登录状态
        if (!checkUserStatus()) {
            return res;
        }
        // 封装DTO
        UserDTO userDTO = userService.getUserDTO(userId);
        // 返回给前端json
        res.setData(userDTO);
        return res;
    }

    @RequestMapping(value = "/infoext")
    public Object getUserInfoExt(@RequestBody Map map) {
        // 为了提供可查看他人信息的接口，提供user_id备用
        Long curUserId = getAimUserId(map);
        if (curUserId == null) {
            return res;
        }
        // 封装DTO
        UserDTO userDTO = userService.getUserDTOExt(userId, curUserId);
        // 返回给前端json
        res.setData(userDTO);
        return res;
    }

    /**
     * 获取关注列表
     * @return
     */
    @RequestMapping(value = "/following")
    public Object getFollowing() {
        // 验证用户登录状态
        if (!checkUserStatus()) {
            return res;
        }
        // 封装DTO
        List<UserDTO> userDTO = userService.selectFollowing(userId);
        // 返回给前端json
        res.setData(userDTO);
        return res;
    }

    /**
     * 获取粉丝列表
     * @return
     */
    @RequestMapping(value = "/follower")
    public Object getFollower() {
        // 验证用户登录状态
        if (!checkUserStatus()) {
            return res;
        }
        // 封装DTO
        List<UserDTO> userDTO = userService.selectFollowers(userId);
        // 返回给前端json
        res.setData(userDTO);
        return res;
    }

    /**
     * 关注功能
     * @param map
     * @return
     */
    @RequestMapping(value = "/follow")
    public Object follow(@RequestBody Map map) {
        // 验证用户登录状态
        if (!checkUserStatus()) {
            return res;
        }
        // 获取关注的用户ID
        Long vid = Long.parseLong(map.get("vid").toString());
        // 封装DTO
        try {
            userService.addFollowing(userId, vid);
            res.setMsg("关注成功！");
        } catch (Exception e) {
            res.setMsg(e.getMessage());
        }
        return res;
    }

    /**
     * 取消关注功能
     * @param map
     * @return
     */
    @RequestMapping(value = "/cancelfollow")
    public Object cancelFollow(@RequestBody Map map) {
        // 验证用户登录状态
        if (!checkUserStatus()) {
            return res;
        }
        // 获取关注的用户ID
        Long vid = Long.parseLong(map.get("vid").toString());
        // 封装DTO
        try {
            userService.deleteFollowing(userId, vid);
            res.setMsg("取关成功！");
        } catch (Exception e) {
            res.setMsg(e.getMessage());
        }
        return res;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Object login(@RequestBody Map map) {
        String loginName = map.get("name").toString();
        String password = map.get("password").toString();
        res = new ResponseDTO();

        try {
            // 验证用户信息
//            ForumUser user = this.checkSyncLogin(loginName, password);
//            // 验证session
//            if (!checkLogin(user, loginName)) {
//                return res;
//            }
            res.setMsg("登录成功！");
        } catch (Exception e) {
            // 封装错误信息
            res.setMsg(e.getMessage());
            res.setResult(false);
            e.printStackTrace();
        }
        return res;
    }

    @RequestMapping(value = "/logout")
    public Object logout() {
        // 验证用户登录状态
        if (!checkUserStatus()) {
            return res;
        }
        // 移除session
        SessionUtil.removeAttribute(request);
        res.setResult(true);
        res.setMsg("登出成功！");
        return res;
    }

    @RequestMapping(value = "/checklogin")
    public Object checkLogin() {
        res = new ResponseDTO();
        if (session.getAttribute(Constants.SESSION_ATTRIBUTE_ID) == null) {
            res.setMsg("现在状态为：未登录");
            res.setResult(false);
        } else {
            res.setMsg("现在状态为：已登录");
            res.setResult(true);
        }
        return res;
    }

    @RequestMapping(value = "/updatesignature")
    public Object updateSignature(@RequestBody Map map) {
        // 验证用户登录状态
        if (!checkUserStatus()) {
            return res;
        }

        // 参数
        String signature = map.get("signature").toString();

        // 更新用户个性签名
        int i = userService.updateSignature(userId, signature);

        if (i > 0) {
            res.setResult(true);
            res.setMsg("修改个性签名成功！");
        } else {
            res.setResult(false);
            res.setMsg("修改个性签名失败！");
        }
        return res;
    }

    @RequestMapping(value = "/updateportrait")
    public Object updatePortrait(@RequestBody Map map) {
        // 验证用户登录状态
        if (!checkUserStatus()) {
            return res;
        }

        // 参数
        String portrait = map.get("portrait").toString();

        // 更新用户头像
        int i = userService.updatePortrait(userId, portrait);

        if (i > 0) {
            res.setResult(true);
            res.setMsg("修改头像成功！");
        } else {
            res.setResult(false);
            res.setMsg("修改头像失败！");
        }
        return res;
    }

    /**
     * 获取用户当前的签到天数
     * @return
     */
    @RequestMapping(value = "/checkinfo")
    public Object checkInfo() {
        // 验证用户登录状态
        if (!checkUserStatus()) {
            return res;
        }
        // 连签信息
        res.setData(userService.getCheckInfo(userId));
        res.setResult(true);
        return res;
    }

    @RequestMapping(value = "/checkin")
    public Object checkin() {
        // 验证用户登录状态
        if (!checkUserStatus()) {
            return res;
        }
        try {
            // 签到
            userService.recordIntegration(userId);
            res.setResult(true);
            res.setMsg("签到成功！");
        } catch (Exception e) {
            res.setResult(false);
            res.setMsg(e.getMessage());
        }
        return res;
    }

    @RequestMapping(value = "/register")
    public Object register(@RequestBody Map map) {
        // 验证用户登录状态
        if (checkUserStatus()) {
            res.setResult(false);
            res.setMsg("请先退出当前登录用户！");
            return res;
        }

        // 解析参数
        String loginName = map.get("login_name").toString();
        String password = map.get("password").toString();
        String userName = map.get("name").toString();

        try {
            // 注册
            ForumUser user = userService.registerSimple(loginName, password, userName);
//            // 同步本地用户数据到远程
//            userService.syncForumToPlatform(user);

            res.setResult(true);
            res.setMsg("注册成功！");
        } catch (Exception e) {
            res.setResult(false);
            res.setMsg(e.getMessage());
        }
        return res;
    }

    @RequestMapping(value = "/updateinfo")
    public Object updateUserInfo(@RequestBody Map map) {
        // 验证用户登录状态
        if (!checkUserStatus()) {
            return res;
        }

        // 解析参数
        String phone = map.get("phone") != null ? map.get("phone").toString() : "";
        String mail = map.get("mail") != null ? map.get("mail").toString() : "";
        String sex = map.get("sex") != null ? map.get("sex").toString() : "";
        String post = map.get("post") != null ? map.get("post").toString() : "";

        try {
            // 注册
            ForumUser user = userService.selectUser(userId);
            user.setPersonalPhone(phone);
            user.setPersonalMail(mail);
            if (sex != null && !"".equals(sex)) {
                user.setPersonalSex(Byte.parseByte(sex));
            }
            user.setPersonalPost(post);
            user.setUserId(userId);
            userService.updateUser(user);
//            // 同步到远程数据库
//            userService.syncForumToPlatform(user);

            res.setResult(true);
            res.setMsg("用户信息修改成功！");
        } catch (Exception e) {
            res.setResult(false);
            res.setMsg("用户信息修改失败：" + e.getMessage());
        }
        return res;
    }

    /**
     * 获取通知列表
     * @return
     */
    @RequestMapping(value = "/notification")
    public Object getNotification() {
        // 验证用户登录状态
        if (!checkUserStatus()) {
            return res;
        }
        // 封装DTO
        List<ForumNoticeExtend> userDTO = userService.selectNotificationByUserId(userId);
        // 返回给前端json
        res.setData(userDTO);
        return res;
    }

    /**
     * 已读通知
     * @return
     */
    @RequestMapping(value = "/readnotice")
    public Object readNotice(@RequestBody Map map) {
        // 验证用户登录状态
        if (!checkUserStatus()) {
            return res;
        }
        // 获取通知主键
        Long noticeId = Long.parseLong(map.get("notice_id").toString());
        // 封装DTO
        userService.updateNotice(noticeId);
        res.setMsg("消息已读");
        return res;
    }

}
