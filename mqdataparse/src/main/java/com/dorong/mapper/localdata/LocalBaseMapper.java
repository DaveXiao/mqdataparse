package com.dorong.mapper.localdata;

import com.dorong.model.localdata.LocalBase;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface LocalBaseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LocalBase record);

    int insertSelective(LocalBase record);

    LocalBase selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LocalBase record);

    int updateByPrimaryKey(LocalBase record);

    int updateByUserCode(LocalBase record);

    int createTable(@Param("tableName")String tableName);

    int deleteByBaseId(@Param("tableName")String tableName,@Param("baseId")Integer baseId);

    List<LocalBase> selectIds(@Param("tableName")String tableName);

    int updateAnaly(LocalBase record);

    int existTable(Map param);
}