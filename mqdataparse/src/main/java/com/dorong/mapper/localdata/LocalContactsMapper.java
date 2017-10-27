package com.dorong.mapper.localdata;

import com.dorong.model.localdata.LocalContacts;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocalContactsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LocalContacts record);

    int insertSelective(LocalContacts record);

    LocalContacts selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LocalContacts record);

    int updateByPrimaryKey(LocalContacts record);

    int createTable(@Param("tableName")String tableName);

    int batchInsert(@Param("tableName")String tableName,@Param("list")List<LocalContacts> list);
}