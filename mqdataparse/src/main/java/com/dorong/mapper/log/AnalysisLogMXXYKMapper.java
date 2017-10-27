package com.dorong.mapper.log;

import com.dorong.model.log.AnalysisLogMXXYK;
import org.springframework.stereotype.Repository;

@Repository
public interface AnalysisLogMXXYKMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AnalysisLogMXXYK record);

    int insertSelective(AnalysisLogMXXYK record);

    AnalysisLogMXXYK selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AnalysisLogMXXYK record);

    int updateByPrimaryKey(AnalysisLogMXXYK record);
}