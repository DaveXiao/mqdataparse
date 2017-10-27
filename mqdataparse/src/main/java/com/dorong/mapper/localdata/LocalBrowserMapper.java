package com.dorong.mapper.localdata;

import com.dorong.model.localdata.LocalBrowser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocalBrowserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LocalBrowser record);

    int insertSelective(LocalBrowser record);

    LocalBrowser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LocalBrowser record);

    int updateByPrimaryKey(LocalBrowser record);

    int createTable(@Param("tableName")String tableName);

    int batchInsert(@Param("tableName")String tableName,@Param("list")List<LocalBrowser> list);
}