package com.dorong.mapper.log;

import org.springframework.stereotype.Repository;

import com.dorong.model.log.AnalysisLogLocal;

@Repository
public interface AnalysisLogLocalMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AnalysisLogLocal record);

    int insertSelective(AnalysisLogLocal record);

    AnalysisLogLocal selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AnalysisLogLocal record);

    int updateByPrimaryKey(AnalysisLogLocal record);
}