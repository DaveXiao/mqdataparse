package com.dorong.model.log;

import java.util.Date;

/**
 * 数据分析日志基础�?
 * Created by GaoWanli on 2017/9/1.
 */
public class AnalysisLogBase {
    private Long id;

    private String user_code;

    private Date authorize_date;

    private Date task_begin_time;

    private Date task_end_time;

    private String mx_task_data;

    private String old_task_data;

    private String task_state;

    private Integer state_code;

    private Long spend_time;

    private String data_uri;

    private Date create_time;

    private String remark;

    public AnalysisLogBase() {
    }

    public AnalysisLogBase(String user_code, Date authorize_date, Date task_begin_time, String mx_task_data, String old_task_data, String task_state, Integer state_code, String data_uri, Date create_time, String remark) {
        this.user_code = user_code;
        this.authorize_date = authorize_date;
        this.task_begin_time = task_begin_time;
        this.mx_task_data = mx_task_data;
        this.old_task_data = old_task_data;
        this.task_state = task_state;
        this.state_code = state_code;
        this.data_uri = data_uri;
        this.create_time = create_time;
        this.remark = remark;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUser_code() {
        return user_code;
    }

    public void setUser_code(String user_code) {
        this.user_code = user_code == null ? null : user_code.trim();
    }

    public Date getAuthorize_date() {
        return authorize_date;
    }

    public void setAuthorize_date(Date authorize_date) {
        this.authorize_date = authorize_date;
    }

    public Date getTask_begin_time() {
        return task_begin_time;
    }

    public void setTask_begin_time(Date task_begin_time) {
        this.task_begin_time = task_begin_time;
    }

    public Date getTask_end_time() {
        return task_end_time;
    }

    public void setTask_end_time(Date task_end_time) {
        this.task_end_time = task_end_time;
    }

    public String getMx_task_data() {
        return mx_task_data;
    }

    public void setMx_task_data(String mx_task_data) {
        this.mx_task_data = mx_task_data == null ? null : mx_task_data.trim();
    }

    public String getOld_task_data() {
        return old_task_data;
    }

    public void setOld_task_data(String old_task_data) {
        this.old_task_data = old_task_data == null ? null : old_task_data.trim();
    }

    public String getTask_state() {
        return task_state;
    }

    public void setTask_state(String task_state) {
        this.task_state = task_state == null ? null : task_state.trim();
    }

    public Integer getState_code() {
        return state_code;
    }

    public void setState_code(Integer state_code) {
        this.state_code = state_code;
    }

    public Long getSpend_time() {
        return spend_time;
    }

    public void setSpend_time(Long spend_time) {
        this.spend_time = spend_time;
    }

    public String getData_uri() {
        return data_uri;
    }

    public void setData_uri(String data_uri) {
        this.data_uri = data_uri == null ? null : data_uri.trim();
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}
