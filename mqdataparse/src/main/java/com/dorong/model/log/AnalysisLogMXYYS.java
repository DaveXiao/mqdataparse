package com.dorong.model.log;


import java.util.Date;

public class AnalysisLogMXYYS extends AnalysisLogBase{

    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public AnalysisLogMXYYS() {
    }

    public AnalysisLogMXYYS(String user_code, Date authorize_date, Date task_begin_time, String mx_task_data, String old_task_data, String task_state, Integer state_code, String data_uri, Date create_time, String remark) {
        super(user_code, authorize_date, task_begin_time, mx_task_data, old_task_data, task_state, state_code, data_uri, create_time, remark);
    }
}