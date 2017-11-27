package com.boya.platform.forum.service.impl;

import com.boya.platform.forum.mapper.*;
import com.boya.platform.forum.model.dto.CheckinDTO;
import com.boya.platform.forum.model.dto.Company;
import com.boya.platform.forum.model.dto.Person;
import com.boya.platform.forum.model.dto.UserDTO;
import com.boya.platform.forum.model.po.*;
import com.boya.platform.forum.service.UserService;
import com.boya.platform.forum.util.Constants;
import com.boya.platform.forum.util.DateUtil;
import com.boya.platform.forum.util.Md5Util;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author Tsunglei Ching [ray@boyamarine.com]
 * @date 2017/11/9 13:06
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    private UserDTO userDTO;

    @Autowired
    private ForumUserMapper forumUserMapper;

    @Autowired
    private ForumIntegrationMapper forumIntegrationMapper;

    @Autowired
    private ForumCheckinMapper forumCheckinMapper;

    @Autowired
    private ForumUserRelationshipMapper forumUserRelationshipMapper;

    @Autowired
    private ForumNoticeMapper forumNoticeMapper;

    @Override
    public ForumUser getUserByLoginName(String loginName) {
        Long userId = this.getUserIdByLoginName(loginName);
        return forumUserMapper.selectByPrimaryKey(userId);
    }

    @Override
    public Long getUserIdByLoginName(String loginName) {
        return forumUserMapper.getIdByLoginName(loginName);
    }

    @Override
    public Byte getUserType(Long userId) {
        return this.selectUser(userId).getUserType();
    }

    @Override
    public ForumUser selectUser(Long userId) {
        return forumUserMapper.selectByPrimaryKey(userId);
    }

    @Override
    public UserDTO getUserDTO(Long userId) {
        userDTO = new UserDTO();

        // 获取最新的用户信息
        ForumUser user = forumUserMapper.selectByPrimaryKey(userId);

        // 封装通用部分
        userDTO.setLogin_name(user.getLoginName());
        userDTO.setPortrait(user.getPortrait());
        userDTO.setIntegration(user.getIntegration());
        userDTO.setSignature(user.getSignature());
        userDTO.setUsertype(user.getUserType());
        // 区分个人用户和企业用户
        if (Constants.USER_TYPE_PERSONAL.equals(user.getUserType())) {
            userDTO.setName(user.getPersonalName());

            Person person = new Person();
            person.setSex(user.getPersonalSex());
            person.setCompany_name(user.getPersonalCompanyName());
            person.setMail(user.getPersonalMail());
            person.setPhone(user.getPersonalPhone());
            person.setContacts_post(user.getPersonalPost());

            userDTO.setPerson(person);

        } else if (Constants.USER_TYPE_COMPANY.equals(user.getUserType())) {
            userDTO.setName(user.getCompanyName());

            Company company = new Company();
            company.setAddress(user.getCompanyAddress());
            company.setContacts_mail(user.getContactsMail());
            company.setContacts_name(user.getContactsName());
            company.setContacts_phone(user.getContactsPhone());
            company.setContacts_post(user.getContactsPost());
            company.setMail(user.getCompanyMail());
            company.setPhone(user.getCompanyPhone());

            userDTO.setCompany(company);

        }
        return userDTO;
    }

    @Override
    public UserDTO getUserDTOExt(Long userId, Long curUserId) {
        // 封装目标用户的信息
        UserDTO dto = this.getUserDTO(curUserId);

        if (userId == null) {
            return dto;
        }

        // 查询当前用户是否已关注目标用户
        ForumUserRelationship ur = new ForumUserRelationship();
        ur.setUserId(curUserId);
        ur.setFollowerId(userId);

        ForumUserRelationship relationship = forumUserRelationshipMapper.selectOne(ur);
        dto.setIs_followed(relationship != null);
        return dto;
    }

    @Override
    public List<UserDTO> selectFollowers(Long userId) {
        return forumUserMapper.selectFollowerUsers(userId);
    }

    @Override
    public List<UserDTO> selectFollowing(Long userId) {
        return forumUserMapper.selectFollowingUsers(userId);
    }

    @Override
    public int updateSignature(Long userId, String signature) {
        return forumUserMapper.updateSignature(userId, signature);
    }

    @Override
    public int updatePortrait(Long userId, String portrait) {
        return forumUserMapper.updatePortrait(userId, portrait);
    }

    @Override
    public void recordIntegration(Long userId) throws Exception {

        // 判断是否已经签到
        if (todayChecked(userId)) {
            throw new Exception("您今日已签到，请勿重复签到！");
        }

        // 逻辑判断连续签到次数
        int series = getCurrentSeries(userId) + 1;
        // 根据连签次数获取对应积分
        int integration = forumIntegrationMapper.getIntegrationByCheckinTimes(series);

        // 插入签到记录
        ForumCheckin checkin = new ForumCheckin();
        Date today = new Date();
        checkin.setCheckinDate(today);
        checkin.setUserId(userId);
        checkin.setGmtCreate(today);
        checkin.setSeriesTimes(series);
        checkin.setCheckinIntegration(integration);
        forumCheckinMapper.insert(checkin);

        // 更新用户积分
        ForumUser user = forumUserMapper.selectByPrimaryKey(userId);
        user.setIntegration(user.getIntegration() + integration);
        forumUserMapper.updateByPrimaryKey(user);

    }

    @Override
    public CheckinDTO getCheckInfo(Long userId) {
        CheckinDTO dto = new CheckinDTO();
        dto.setTodayChecked(this.todayChecked(userId));
        dto.setSeries(this.getCurrentSeries(userId));
        return dto;
    }

    @Override
    public void addFollowing(Long userId, Long vid) throws Exception {

        if (vid == null) {
            throw new Exception("请指定被关注人的ID！");
        }
        if (userId.equals(vid)) {
            throw new Exception("不可以关注自己！");
        }

        ForumUserRelationship ur = new ForumUserRelationship();
        ur.setFollowerId(userId);
        ur.setUserId(vid);

        // 验证是否已关注
        ForumUserRelationship fur = forumUserRelationshipMapper.selectOne(ur);
        if (fur != null) {
            throw new Exception("已关注过，请勿重复关注！");
        }

        ur.setGmtCreate(new Date());
        forumUserRelationshipMapper.insert(ur);

        // 记录通知
        ForumNotice notice = new ForumNotice();
        notice.setNoticeType(Constants.NOTICE_TYPE_FOLLOW);
        notice.setUserId(vid);
        notice.setFollowerId(userId);
        notice.setNoticeDate(new Date());
        notice.setNoticeStatus(Constants.NOTICE_STATUS_UNREAD);
        forumNoticeMapper.insert(notice);
    }

    @Override
    public void deleteFollowing(Long userId, Long vid) throws Exception {
        if (vid == null) {
            throw new Exception("请指定被关注人的ID！");
        }
        if (userId.equals(vid)) {
            throw new Exception("不可以取关自己！");
        }

        ForumUserRelationship ur = new ForumUserRelationship();
        ur.setFollowerId(userId);
        ur.setUserId(vid);

        // 验证是否已关注
        ForumUserRelationship fur = forumUserRelationshipMapper.selectOne(ur);
        if (fur == null) {
            throw new Exception("您还未关注过此人，无法取关！");
        }

        forumUserRelationshipMapper.delete(fur);

        // 取关暂不通知用户
    }

    @Override
    public ForumUser registerSimple(String loginName, String password, String userName) throws Exception {
        ForumUser user = new ForumUser();
        user.setLoginName(loginName);

        // 验证是否已存在该账号
        ForumUser one = forumUserMapper.selectOne(user);
        if (one != null) {
            throw new Exception("已存在该账号！");
        }

        user.setPassword(Md5Util.string2MD5(password + Constants.LOGIN_PASSWORD_MD5SUFFIX));
        user.setDisplayName(userName);
        user.setPersonalName(userName);
        user.setGmtCreate(new Date());
        user.setIntegration(0);
        user.setUserType(Constants.USER_TYPE_PERSONAL);
        user.setTrade(Constants.TRADE_DEFAULT);
        forumUserMapper.insert(user);

        return user;
    }

    @Override
    public List<ForumNoticeExtend> selectNotificationByUserId(Long userId) {
        PageHelper.startPage(1, 20);
        return forumNoticeMapper.selectByUserId(userId);
    }

    @Override
    public void updateNotice(Long noticeId) {
        ForumNotice n = forumNoticeMapper.selectByPrimaryKey(noticeId);
        if (Constants.NOTICE_STATUS_READED.equals(n.getNoticeStatus())) {
            return;
        }
        n.setNoticeStatus(Constants.NOTICE_STATUS_READED);
        forumNoticeMapper.updateByPrimaryKey(n);
    }

    @Override
    public void updateUser(ForumUser user) throws Exception {
        ForumUser ou = forumUserMapper.selectByPrimaryKey(user.getUserId());

        if (ou != null) {
            ou.setPersonalPost(user.getPersonalPost());
            ou.setPersonalSex(user.getPersonalSex());
            ou.setPersonalMail(user.getPersonalMail());
            ou.setPersonalPhone(user.getPersonalPhone());
            ou.setGmtModified(new Date());
            forumUserMapper.updateByPrimaryKey(ou);
        } else {
            throw new Exception("查无此用户！");
        }


    }

    /**
     * 判断今天是否已签到
     * @param userId
     * @return
     */
    private boolean todayChecked(Long userId) {
        // 获取上一次签到的记录
        ForumCheckin lastCheck = forumCheckinMapper.selectLastCheckByUserId(userId);
        return lastCheck != null && DateUtil.getDistanceTime(lastCheck.getCheckinDate(), new Date())[0] == 0;
    }

    /**
     * 获取当前用户的连续签到天数
     * @param userId
     * @return
     */
    private int getCurrentSeries(Long userId) {
        // 获取上一次签到的记录
        ForumCheckin lastCheck = forumCheckinMapper.selectLastCheckByUserId(userId);
        if (lastCheck == null) {
            return 0;
        }
        Date lastDay = lastCheck.getCheckinDate();
        Date today = new Date();

        // 判断上一次签到是否为昨天或今天
        if (DateUtil.getDistanceTime(lastDay, today)[0] > 1) {
            return 0;
        } else {
            return lastCheck.getSeriesTimes();
        }
    }

}
