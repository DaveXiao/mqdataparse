package com.dorong.mapper.log;

import com.dorong.model.log.AnalysisLogMXYYS;
import org.springframework.stereotype.Repository;

@Repository
public interface AnalysisLogMXYYSMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AnalysisLogMXYYS record);

    int insertSelective(AnalysisLogMXYYS record);

    AnalysisLogMXYYS selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AnalysisLogMXYYS record);

    int updateByPrimaryKey(AnalysisLogMXYYS record);
}