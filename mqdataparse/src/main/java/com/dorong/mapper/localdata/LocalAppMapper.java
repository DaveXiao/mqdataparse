package com.dorong.mapper.localdata;

import com.dorong.model.localdata.LocalApp;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocalAppMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LocalApp record);

    int insertSelective(LocalApp record);

    LocalApp selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LocalApp record);

    int updateByPrimaryKey(LocalApp record);

    int createTable(@Param("tableName")String tableName);

    int batchInsert(@Param("tableName")String tableName,@Param("list")List<LocalApp> list);
}