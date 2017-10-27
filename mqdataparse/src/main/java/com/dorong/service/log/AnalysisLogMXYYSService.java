package com.dorong.service.log;

import com.dorong.model.log.AnalysisLogMXYYS;
import org.springframework.dao.DuplicateKeyException;

/**
 * 魔蝎运营商分析日志接口
 * Created by GaoWanli on 2017/8/31.
 */
public interface AnalysisLogMXYYSService {
    int deleteByPrimaryKey(Long id);

    int insert(AnalysisLogMXYYS record) throws DuplicateKeyException;

    int insertSelective(AnalysisLogMXYYS record) throws DuplicateKeyException;

    AnalysisLogMXYYS selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AnalysisLogMXYYS record);

    int updateByPrimaryKey(AnalysisLogMXYYS record);
}
