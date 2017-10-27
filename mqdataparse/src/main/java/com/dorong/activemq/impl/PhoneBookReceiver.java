package com.dorong.activemq.impl;

import java.util.Map;

import javax.jms.Message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dorong.activemq.BaseReceiver;
import com.dorong.utils.OssUtils;
import com.dorong.utils.StringUtil;

/**
 * 用户本地通讯录数据接口
 * Created by GaoWanli on 2017/9/14.
 */
@Service("PhoneBookReceiver")
public class PhoneBookReceiver extends BaseReceiver {
	private static Logger logger = LoggerFactory.getLogger(PhoneBookReceiver.class);
	
	private static String document_type = "userphonebook";
	
    /*@Autowired @Lazy
    public void setHandle(RealTimeDataProcessingHandler handler) {
        super.setHandler(handler);
    }*/

    public void onMessage(Message message) {
        doReceve(message);
    }

    @Override
    protected String beforeHandle(String mapMsg) {
        //防止对方没有设置type
        JSONObject jsonObj = JSONObject.parseObject(mapMsg);
        jsonObj.put("type","TXL");
        return jsonObj.toJSONString();
    }

	@Override
	protected String parseOssComment(Map<String, Object> ossMap, String ossFileKey) {
		logger.info("ossFileKey>>>"+ossMap.get("ossFileKey"));
		//根据ossFielKey从OSS获取数据
        String str_data = OssUtils.getCllientInstance().getObjectContentUTF8(ossFileKey);
        
        if(StringUtil.isEmpty(str_data)){
        	return null;
        }
        
        String flag = str_data.substring(0,1);
		
		if(flag.equals("[")){
			JSONArray data_array = JSON.parseArray(str_data);
			ossMap.put("data", data_array);
		} else {
			JSON data_json = JSON.parseObject(str_data);
			ossMap.put("data", data_json);
		}
		return document_type;
	}

//	@Override
//	protected String ossFileDataToJson(String ossFileKey) {
//		// TODO Auto-generated method stub
//		return null;
//	}
}
