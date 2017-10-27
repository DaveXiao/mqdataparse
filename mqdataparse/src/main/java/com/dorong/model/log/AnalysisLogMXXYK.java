package com.dorong.model.log;

import java.util.Date;

public class AnalysisLogMXXYK extends AnalysisLogBase {

    private String card_type;

    public AnalysisLogMXXYK() {
    }

    public AnalysisLogMXXYK(String user_code, Date authorize_date, Date task_begin_time, String mx_task_data, String old_task_data, String task_state, Integer state_code, String data_uri, Date create_time, String remark, String card_type) {
        super(user_code, authorize_date, task_begin_time, mx_task_data, old_task_data, task_state, state_code, data_uri, create_time, remark);
        this.card_type = card_type;
    }

    public String getCard_type() {
        return card_type;
    }

    public void setCard_type(String card_type) {
        this.card_type = card_type;
    }
}