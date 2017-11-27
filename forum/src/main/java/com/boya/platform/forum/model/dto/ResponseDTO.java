package com.boya.platform.forum.model.dto;

import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 返回给前端的JSON
 *
 * @author Tsunglei Ching [ray@boyamarine.com]
 * @date 2017/11/13 8:58
 */
public class ResponseDTO {

    /**
     * 请求数据的结果
     */
    private Boolean result;

    /**
     * 请求数据的返回信息
     */
    private String msg;

    /**
     * 请求的数据总条数（不分页的条数）
     */
    private Long total;

    /**
     * 请求数据的返回对象
     */
    private Object data;

    public ResponseDTO() {
        // result默认为true
        this.result = true;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    /**
     * 重载，可以通过list计算出分页记录总数
     * @param list
     */
    public void setTotal(List<?> list) {
        setTotalNum(list);
    }

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        // 设置数据
        this.data = data;
        // 默认设置总记录数
        if (data instanceof List<?>) {
            setTotalNum((List<?>) data);
        }
    }

    private void setTotalNum(List<?> list) {
        // 取分页信息
        PageInfo<?> pageInfo = new PageInfo<>(list);
        //获取总记录数
        this.total = pageInfo.getTotal();
    }

    @Override
    public String toString() {
        return "ResponseDTO{" +
                "result=" + result +
                ", msg='" + msg + '\'' +
                ", total=" + total +
                ", data=" + data +
                '}';
    }
}
