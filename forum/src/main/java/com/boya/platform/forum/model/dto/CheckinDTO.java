package com.boya.platform.forum.model.dto;

/**
 * @author Tsunglei Ching [ray@boyamarine.com]
 * @date 2017/11/15 13:55
 */
public class CheckinDTO {

    /**
     * 今日是否已签到
     */
    private Boolean todayChecked;

    /**
     * 连签次数
     */
    private Integer series;

    public Boolean getTodayChecked() {
        return todayChecked;
    }

    public void setTodayChecked(Boolean todayChecked) {
        this.todayChecked = todayChecked;
    }

    public Integer getSeries() {
        return series;
    }

    public void setSeries(Integer series) {
        this.series = series;
    }
}
