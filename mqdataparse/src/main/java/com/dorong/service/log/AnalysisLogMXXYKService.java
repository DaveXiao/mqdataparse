package com.dorong.service.log;

import com.dorong.model.log.AnalysisLogMXXYK;
import org.springframework.dao.DuplicateKeyException;

/**
 * 魔蝎信用卡日志接口
 * Created by GaoWanli on 2017/9/1.
 */
public interface AnalysisLogMXXYKService {
    int deleteByPrimaryKey(Long id);

    int insert(AnalysisLogMXXYK record) throws DuplicateKeyException;

    int insertSelective(AnalysisLogMXXYK record) throws DuplicateKeyException;

    AnalysisLogMXXYK selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AnalysisLogMXXYK record);

    int updateByPrimaryKey(AnalysisLogMXXYK record);
}
