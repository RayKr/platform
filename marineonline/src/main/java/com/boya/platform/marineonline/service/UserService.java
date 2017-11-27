package com.boya.platform.marineonline.service;

import com.boya.platform.marineonline.model.dto.ForumUserDTO;
import com.boya.platform.marineonline.model.po.BypPersonalUserInfo;
import com.boya.platform.marineonline.model.po.BypStageUserInfo;

/**
 * @author Tsunglei Ching [ray@boyamarine.com]
 * @date 2017/11/27 13:12
 */
public interface UserService {

    /**
     * 根据账号密码验证platform用户
     * @param loginName
     * @param password
     * @return
     */
    BypStageUserInfo selectStageUser(String loginName, String password);

    /**
     * 根据平台登录信息获取用户个人资料
     * @param stage
     * @return
     */
    BypPersonalUserInfo selectPersonalUser(BypStageUserInfo stage);

    /**
     * 获取platform登录信息
     * @param loginName
     * @return
     */
    BypStageUserInfo selectStageUserByLoginName(String loginName);

    /**
     * 获取头像url
     * @param docId
     * @return
     */
    String getPortraitUrl(int docId);

    /**
     * 将forum用户表信息同步到platform用户表
     * @param user
     * @throws Exception
     */
    void syncForumToPlatform(ForumUserDTO user) throws Exception;
}
