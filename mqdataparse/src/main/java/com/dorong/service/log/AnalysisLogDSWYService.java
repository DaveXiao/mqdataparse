package com.dorong.service.log;

import com.dorong.model.log.AnalysisLogDSWY;
import org.springframework.dao.DuplicateKeyException;

/**
 * Created by GaoWanli on 2017/9/1.
 */
public interface AnalysisLogDSWYService {

    int deleteByPrimaryKey(Long id);

    int insert(AnalysisLogDSWY record) throws DuplicateKeyException;

    int insertSelective(AnalysisLogDSWY record) throws DuplicateKeyException;

    AnalysisLogDSWY selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AnalysisLogDSWY record);

    int updateByPrimaryKey(AnalysisLogDSWY record);
}
