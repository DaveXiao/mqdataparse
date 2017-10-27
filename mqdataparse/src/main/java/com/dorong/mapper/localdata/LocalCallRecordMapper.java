package com.dorong.mapper.localdata;

import com.dorong.model.localdata.LocalCallRecord;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocalCallRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LocalCallRecord record);

    int insertSelective(LocalCallRecord record);

    LocalCallRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LocalCallRecord record);

    int updateByPrimaryKey(LocalCallRecord record);

    int createTable(@Param("tableName")String tableName);

    int batchInsert(@Param("tableName")String tableName,@Param("list")List<LocalCallRecord> list);
}