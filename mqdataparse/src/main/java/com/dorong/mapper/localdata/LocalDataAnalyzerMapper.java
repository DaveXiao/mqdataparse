package com.dorong.mapper.localdata;

import com.dorong.model.localdata.LocalDataAnalyzerDTO;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface LocalDataAnalyzerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LocalDataAnalyzerDTO record);

    int insertSelective(LocalDataAnalyzerDTO record);

    LocalDataAnalyzerDTO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LocalDataAnalyzerDTO record);

    int updateByPrimaryKey(LocalDataAnalyzerDTO record);

    /************ apps数据和用户基础数据 ***************/
    Map<String,Object> selectBase(Map<String,Object> baseData);

    Map<String,Object> selectAPPS(Map<String,Object> baseData);

    /******************* 通讯清单数据 *****************/
    Map<String,Object> selectTHQDAvg(Map<String,Object> baseData);

    Map<String,Object> selectTHQDis_contact_in_one_month(Map<String,Object> baseData);

    Map<String,Object> selectTHQDdabanye_contact_cnt(Map<String,Object> baseData);

    Map<String,Object> selectTHQDis_huchu_gaopin_yingxiao_phone(Map<String,Object> baseData);

    Map<String,Object> selectTHQDis_has_jjlxr_in_thqd(Map<String,Object> baseData);

    /**************** 通讯录数据分析 *****************/
    Map<String,Object> selectTXLis_has_jjlxr_in_contact(Map<String,Object> baseData);

    Map<String,Object> selectTXLphone_cnt(Map<String,Object> baseData);

    /**************** 浏览器数据解析 *****************/
    Map<String,Object> selectBrowserData(Map<String,Object> baseData);

    /**************** 运营商商数据解析 *****************/
    Map<String,Object> selectYYSData(Map<String,Object> baseData);

}