package com.boya.platform.forum.model.po;

import java.util.Date;
import javax.persistence.*;

@Table(name = "forum_checkin")
public class ForumCheckin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "checkin_id")
    private Long checkinId;

    @Column(name = "gmt_create")
    private Date gmtCreate;

    @Column(name = "gmt_modified")
    private Date gmtModified;

    /**
     * 签到人
     */
    @Column(name = "user_id")
    private Long userId;

    /**
     * 签到日期（年-月-日）
     */
    @Column(name = "checkin_date")
    private Date checkinDate;

    /**
     * 连续签到次数
     */
    @Column(name = "series_times")
    private Integer seriesTimes;

    /**
     * 此次签到所得积分
     */
    @Column(name = "checkin_integration")
    private Integer checkinIntegration;

    /**
     * @return checkin_id
     */
    public Long getCheckinId() {
        return checkinId;
    }

    /**
     * @param checkinId
     */
    public void setCheckinId(Long checkinId) {
        this.checkinId = checkinId;
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
     * 获取签到人
     *
     * @return user_id - 签到人
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置签到人
     *
     * @param userId 签到人
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取签到日期（年-月-日）
     *
     * @return checkin_date - 签到日期（年-月-日）
     */
    public Date getCheckinDate() {
        return checkinDate;
    }

    /**
     * 设置签到日期（年-月-日）
     *
     * @param checkinDate 签到日期（年-月-日）
     */
    public void setCheckinDate(Date checkinDate) {
        this.checkinDate = checkinDate;
    }

    /**
     * 获取连续签到次数
     *
     * @return series_times - 连续签到次数
     */
    public Integer getSeriesTimes() {
        return seriesTimes;
    }

    /**
     * 设置连续签到次数
     *
     * @param seriesTimes 连续签到次数
     */
    public void setSeriesTimes(Integer seriesTimes) {
        this.seriesTimes = seriesTimes;
    }

    /**
     * 获取此次签到所得积分
     *
     * @return checkin_integration - 此次签到所得积分
     */
    public Integer getCheckinIntegration() {
        return checkinIntegration;
    }

    /**
     * 设置此次签到所得积分
     *
     * @param checkinIntegration 此次签到所得积分
     */
    public void setCheckinIntegration(Integer checkinIntegration) {
        this.checkinIntegration = checkinIntegration;
    }
}