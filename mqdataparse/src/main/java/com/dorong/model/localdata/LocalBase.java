package com.dorong.model.localdata;

import java.util.Date;

public class LocalBase extends BaseTableName {
    private Integer id;

    private String user_code;

    private String mobile;

    private String name;

    private String idcard;

    private Integer sex;

    private Integer age;

    private Integer shebei_cnt;

    private Integer userdaikuan_cnt;

    private Integer core;

    private Integer is_core_350_550;

    private Date authorize_date;

    private Date create_time;

    private Integer has_analy;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUser_code() {
        return user_code;
    }

    public void setUser_code(String user_code) {
        this.user_code = user_code == null ? null : user_code.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard == null ? null : idcard.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getShebei_cnt() {
        return shebei_cnt;
    }

    public void setShebei_cnt(Integer shebei_cnt) {
        this.shebei_cnt = shebei_cnt;
    }

    public Integer getUserdaikuan_cnt() {
        return userdaikuan_cnt;
    }

    public void setUserdaikuan_cnt(Integer userdaikuan_cnt) {
        this.userdaikuan_cnt = userdaikuan_cnt;
    }

    public Integer getCore() {
        return core;
    }

    public void setCore(Integer core) {
        this.core = core;
    }

    public Integer getIs_core_350_550() {
        return is_core_350_550;
    }

    public void setIs_core_350_550(Integer is_core_350_550) {
        this.is_core_350_550 = is_core_350_550;
    }

    public Date getAuthorize_date() {
        return authorize_date;
    }

    public void setAuthorize_date(Date authorize_date) {
        this.authorize_date = authorize_date;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Integer getHas_analy() {
        return has_analy;
    }

    public void setHas_analy(Integer has_analy) {
        this.has_analy = has_analy;
    }
}