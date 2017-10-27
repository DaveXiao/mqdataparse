package com.dorong.model.localdata;

/**
 * 分表插入时设置表名
 * 实现Cloneable接口方便对象复用
 * Created by GaoWanli on 2017/9/12.
 */
public abstract class BaseTableName implements Cloneable{
    private String tableName;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    /**
     * 对象深度克隆
     * @return  复制的新对象
     */
    @Override
    public Object clone(){
        BaseTableName baseTableName = null;
        try {
            baseTableName = (BaseTableName) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return baseTableName;
    }
}
