package com.dorong.model.log;


import java.util.Date;

public class AnalysisLogDSWY extends AnalysisLogBase {

    private String data_type;

    public AnalysisLogDSWY() {
    }

    public AnalysisLogDSWY(String user_code, Date authorize_date, Date task_begin_time, String mx_task_data, String old_task_data, String task_state, Integer state_code, String data_uri, Date create_time, String remark, String data_type) {
        super(user_code, authorize_date, task_begin_time, mx_task_data, old_task_data, task_state, state_code, data_uri, create_time, remark);
        this.data_type = data_type;
    }

    public String getData_type() {
        return data_type;
    }

    public void setData_type(String data_type) {
        this.data_type = data_type;
    }
}