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

import sun.util.logging.resources.logging;

/**
 * 应用本地数据接口：应用列表，浏览器，通话清单
 * Created by GaoWanli on 2017/9/14.
 */
@Service("APPDATAReceiver")
public class APPDATAReceiver extends BaseReceiver {
	private static Logger logger = LoggerFactory.getLogger(APPDATAReceiver.class);
	
	private String document_type;

    /*@Autowired @Lazy
    public void setHandle(RealTimeDataProcessingHandler handler) {
        super.setHandler(handler);
    }*/

    public void onMessage(Message message) {
        doReceve(message);
    }

    @Override
    protected String beforeHandle(String mapMsg) {
        return mapMsg;
    }

	@Override
	protected String parseOssComment(Map<String, Object> ossMap, String ossFileKey) {
		try {
			logger.info("ossFileKey>>>"+ossFileKey);
			
			
			document_type = ossFileKey.split("/")[0];
			
			//根据ossFielKey从OSS获取数据
			String str_data = OssUtils.getCllientInstance().getObjectContentUTF8(ossFileKey);

//			logger.info("str_data>>>>>>"+str_data);
			
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
			
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}

//	@Override
//	protected String ossFileDataToJson(String ossFileKey) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
}
