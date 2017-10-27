package com.dorong.model.localdata;

import java.util.Date;

public class LocalBrowser extends BaseTableName {
    private Integer id;

    private Integer base_id;

    private String url;

    private String host;

    private String path;

    private Date create_time;

    private Integer should_analy;//标识host是否需要被分析

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBase_id() {
        return base_id;
    }

    public void setBase_id(Integer base_id) {
        this.base_id = base_id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host == null ? null : host.trim();
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Integer getShould_analy() {
        return should_analy;
    }

    public void setShould_analy(Integer should_analy) {
        this.should_analy = should_analy;
    }
}