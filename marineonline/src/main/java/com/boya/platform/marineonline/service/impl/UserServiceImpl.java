package com.boya.platform.marineonline.service.impl;

import com.boya.platform.marineonline.mapper.BypPersonalUserInfoMapper;
import com.boya.platform.marineonline.mapper.BypStageUserInfoMapper;
import com.boya.platform.marineonline.mapper.LspDocumentFileInfoMapper;
import com.boya.platform.marineonline.model.dto.ForumUserDTO;
import com.boya.platform.marineonline.model.po.BypPersonalUserInfo;
import com.boya.platform.marineonline.model.po.BypStageUserInfo;
import com.boya.platform.marineonline.service.UserService;
import com.boya.platform.marineonline.util.Constants;
import com.boya.platform.marineonline.util.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author Tsunglei Ching [ray@boyamarine.com]
 * @date 2017/11/27 13:26
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private BypStageUserInfoMapper bypStageUserInfoMapper;

    @Autowired
    private BypPersonalUserInfoMapper bypPersonalUserInfoMapper;

    @Autowired
    private LspDocumentFileInfoMapper lspDocumentFileInfoMapper;

    @Override
    public BypStageUserInfo selectStageUser(String loginName, String password) {
        BypStageUserInfo stageUser = new BypStageUserInfo();
        stageUser.setLoginName(loginName);
        stageUser.setPassword(Md5Util.string2MD5(password + Constants.LOGIN_PASSWORD_MD5SUFFIX));
        stageUser.setUserType(Constants.USER_TYPE_PERSONAL_PLATFORM);
        return bypStageUserInfoMapper.selectOne(stageUser);
    }

    @Override
    public BypPersonalUserInfo selectPersonalUser(BypStageUserInfo stage) {
        // 如果在平台查询不到个人的账户，则返回null信息
        if (stage == null) {
            return null;
        }
        // 获取个人资料
        return bypPersonalUserInfoMapper.selectByPrimaryKey(stage.getUserId());
    }

    @Override
    public BypStageUserInfo selectStageUserByLoginName(String loginName) {
        BypStageUserInfo stageUser = new BypStageUserInfo();
        stageUser.setLoginName(loginName);
        stageUser.setUserType(Constants.USER_TYPE_PERSONAL_PLATFORM);
        return bypStageUserInfoMapper.selectOne(stageUser);
    }

    @Override
    public String getPortraitUrl(int docId) {
        return lspDocumentFileInfoMapper.selectUrlByDocId(docId);
    }

    @Override
    public void syncForumToPlatform(ForumUserDTO user) throws Exception {
        // 判断是否已存在该用户
        BypStageUserInfo stage = new BypStageUserInfo();
        stage.setLoginName(user.getLoginName());
        stage.setUserType(Constants.USER_TYPE_PERSONAL_PLATFORM);
        stage = bypStageUserInfoMapper.selectOne(stage);

        if (stage != null) {
            // 更新记录
            pkgStageUserInfo(user, stage);
            if (bypStageUserInfoMapper.updateByPrimaryKey(stage) < 1) {
                throw new Exception("更新登录信息失败！");
            }

            BypPersonalUserInfo person = bypPersonalUserInfoMapper.selectByPrimaryKey(stage.getUserId());
            pkgPersonalUserInfo(user, person);
            if (bypPersonalUserInfoMapper.updateByPrimaryKey(person) < 1) {
                throw new Exception("更新个人用户资料失败！");
            }
        } else {
            // 插入记录
            BypPersonalUserInfo person = new BypPersonalUserInfo();
            pkgPersonalUserInfo(user, person);
            if (bypPersonalUserInfoMapper.insert(person) < 1) {
                throw new Exception("记录个人用户资料失败！");
            }

            stage = new BypStageUserInfo();
            pkgStageUserInfo(user, stage);
            stage.setUserId(person.getId());
            if (bypStageUserInfoMapper.insert(stage) < 1) {
                throw new Exception("记录登录信息失败！");
            }
        }
    }

    private void pkgPersonalUserInfo(ForumUserDTO user, BypPersonalUserInfo person) {
        person.setCompanyName(user.getPersonalCompanyName());
        person.setCompanyPost(user.getPersonalPost());
        person.setCreateDate(new Date());
        person.setMailAddress(user.getPersonalMail());
        person.setPhoneNum(user.getPersonalPhone());
        person.setSex(user.getPersonalSex() == 1 ? "2" : "1");
        person.setUserName(user.getDisplayName());
        person.setUseStatus("1");
        person.setValidFlag("1");
        person.setDelFlag("0");
    }

    private void pkgStageUserInfo(ForumUserDTO user, BypStageUserInfo stage) {
        stage.setPassword(user.getPassword());
        stage.setLoginPhone(user.getPersonalPhone());
        stage.setLoginMail(user.getPersonalMail());
        stage.setUserType(user.getUserType().toString());
        stage.setCreateDate(new Date());
    }

}
