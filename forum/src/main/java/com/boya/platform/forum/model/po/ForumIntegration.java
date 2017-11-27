package com.boya.platform.forum.model.po;

import java.util.Date;
import javax.persistence.*;

@Table(name = "forum_integration")
public class ForumIntegration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "integration_id")
    private Long integrationId;

    @Column(name = "gmt_create")
    private Date gmtCreate;

    @Column(name = "gmt_modified")
    private Date gmtModified;

    /**
     * 积分额度
     */
    @Column(name = "integration_num")
    private Integer integrationNum;

    /**
     * 最少连续次数
     */
    @Column(name = "start_checkin_num")
    private Integer startCheckinNum;

    /**
     * 最多连续签到次数
     */
    @Column(name = "end_checkin_num")
    private Integer endCheckinNum;

    /**
     * @return integration_id
     */
    public Long getIntegrationId() {
        return integrationId;
    }

    /**
     * @param integrationId
     */
    public void setIntegrationId(Long integrationId) {
        this.integrationId = integrationId;
    }

    /**
     * @return gmt_create
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * @param gmtCreate
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * @return gmt_modified
     */
    public Date getGmtModified() {
        return gmtModified;
    }

    /**
     * @param gmtModified
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    /**
     * 获取积分额度
     *
     * @return integration_num - 积分额度
     */
    public Integer getIntegrationNum() {
        return integrationNum;
    }

    /**
     * 设置积分额度
     *
     * @param integrationNum 积分额度
     */
    public void setIntegrationNum(Integer integrationNum) {
        this.integrationNum = integrationNum;
    }

    /**
     * 获取最少连续次数
     *
     * @return start_checkin_num - 最少连续次数
     */
    public Integer getStartCheckinNum() {
        return startCheckinNum;
    }

    /**
     * 设置最少连续次数
     *
     * @param startCheckinNum 最少连续次数
     */
    public void setStartCheckinNum(Integer startCheckinNum) {
        this.startCheckinNum = startCheckinNum;
    }

    /**
     * 获取最多连续签到次数
     *
     * @return end_checkin_num - 最多连续签到次数
     */
    public Integer getEndCheckinNum() {
        return endCheckinNum;
    }

    /**
     * 设置最多连续签到次数
     *
     * @param endCheckinNum 最多连续签到次数
     */
    public void setEndCheckinNum(Integer endCheckinNum) {
        this.endCheckinNum = endCheckinNum;
    }
}