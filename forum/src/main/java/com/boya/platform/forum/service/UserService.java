package com.boya.platform.forum.service;

import com.boya.platform.forum.model.dto.CheckinDTO;
import com.boya.platform.forum.model.dto.UserDTO;
import com.boya.platform.forum.model.po.ForumNoticeExtend;
import com.boya.platform.forum.model.po.ForumUser;

import java.util.List;

/**
 * 用户信息
 * @author Tsunglei Ching [ray@boyamarine.com]
 * @date 2017/11/9 13:03
 */
public interface UserService {

    /**
     * 根据登录名获取用户信息
      * @param loginName
     * @return
     */
    ForumUser getUserByLoginName(String loginName);

    /**
     * 用户名唯一，则可根据用户名获取用户唯一主键
     * @param loginName 登录名/用户名
     * @return 用户ID
     */
    Long getUserIdByLoginName(String loginName);

    /**
     * 获取用户类型
     * @param userId userid
     * @return 用户类型
     */
    Byte getUserType(Long userId);

    /**
     * 获取用户基本信息
     * @param userId 用户ID
     * @return 用户实体
     */
    ForumUser selectUser(Long userId);

    /**
     * 封装为传输给前端的用户信息实体
     * @param userId 用户ID
     * @return UserDTO
     */
    UserDTO getUserDTO(Long userId);

    /**
     * 获取任意用户的信息（封装是否关注状态）
     * @param userId
     * @param curUserId
     * @return
     */
    UserDTO getUserDTOExt(Long userId, Long curUserId);

    /**
     * 获取粉丝（谁关注我）
     * @param userId 用户ID
     * @return 粉丝列表
     */
    List<UserDTO> selectFollowers(Long userId);

    /**
     * 获取我关注的用户
     * @param userId 用户ID
     * @return 关注的用户列表
     */
    List<UserDTO> selectFollowing(Long userId);

    /**
     * 更新个人签名
     * @param userId 用户id
     * @param signature 个性签名
     * @return 影响的行数
     * @throws Exception 异常信息处理
     */
    int updateSignature(Long userId, String signature);

    /**
     * 修改头像
     * @param userId
     * @param signature
     * @return
     */
    int updatePortrait(Long userId, String signature);

    /**
     * 签到功能
     * @param userId
     * @return
     * @throws Exception 异常信息处理
     */
    void recordIntegration(Long userId) throws Exception;

    /**
     * 获取用户签到信息
     * @param userId
     * @return
     */
    CheckinDTO getCheckInfo(Long userId);

    /**
     * 关注功能
     * @param userId 当前登录用户ID
     * @param vid 要关注的人的ID
     * @return
     */
    void addFollowing(Long userId, Long vid) throws Exception;

    /**
     * 取消关注功能
     * @param userId 当前登录用户ID
     * @param vid 要取消关注的人的ID
     * @throws Exception
     */
    void deleteFollowing(Long userId, Long vid) throws Exception;

    /**
     * 新用户注册功能
     * @param loginName 登录名
     * @param password 密码
     * @param userName 用户姓名
     */
    ForumUser registerSimple(String loginName, String password, String userName) throws Exception;

    /**
     * 获取用户的通知信息
     * @param userId
     * @return
     */
    List<ForumNoticeExtend> selectNotificationByUserId(Long userId);

    /**
     * 已读通知
     * @param noticeId
     */
    void updateNotice(Long noticeId);

    /**
     * 修改用户基本信息
     * @param user
     */
    void updateUser(ForumUser user) throws Exception;
}
