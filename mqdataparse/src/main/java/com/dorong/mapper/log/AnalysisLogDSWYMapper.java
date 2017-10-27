package com.dorong.mapper.log;

import com.dorong.model.log.AnalysisLogDSWY;
import org.springframework.stereotype.Repository;

@Repository
public interface AnalysisLogDSWYMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AnalysisLogDSWY record);

    int insertSelective(AnalysisLogDSWY record);

    AnalysisLogDSWY selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AnalysisLogDSWY record);

    int updateByPrimaryKey(AnalysisLogDSWY record);
}