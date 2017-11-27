package com.boya.platform.forum.mapper;

import com.boya.platform.forum.model.dto.UserDTO;
import com.boya.platform.forum.model.po.ForumUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 用户表持久层
 * @author Tsunglei Ching [ray@boyamarine.com]
 * @date 2017/11/13 8:58
 */
@Repository("forumUserMapper")
public interface ForumUserMapper extends Mapper<ForumUser> {

    /**
     * 通过登录名获取用户主键
     * @param loginName 登录名
     * @return 用户主键
     */
    Long getIdByLoginName(@Param("loginName") String loginName);

    /**
     * 获取所关注人的ids
     * @param userId
     * @return
     */
    List<Long> getFollowingIds(@Param("userId") Long userId);

    /**
     * 获取粉丝的ids
     * @param userId
     * @return
     */
    List<Long> getFollowerIds(@Param("userId") Long userId);


    /**
     * 获取关注人列表
     * @param userId
     * @return
     */
    List<UserDTO> selectFollowingUsers(@Param("userId") Long  userId);

    /**
     * 获取粉丝列表
     * @param userId
     * @return
     */
    List<UserDTO> selectFollowerUsers(@Param("userId") Long  userId);

    /**
     * 更新个性签名
     * @param userId 用户id
     * @param signature 签名
     * @return 更新的行数
     */
    int updateSignature(@Param("userId") Long userId,
                        @Param("signature") String signature);

    /**
     * 修改头像
     * @param userId
     * @param portrait
     * @return
     */
    int updatePortrait(@Param("userId") Long userId,
                       @Param("portrait") String portrait);
}