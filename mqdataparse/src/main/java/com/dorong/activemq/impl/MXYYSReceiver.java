package com.dorong.activemq.impl;

import java.util.ArrayList;
import java.util.List;
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
 * 魔蝎运营商数据接口 Created by GaoWanli on 2017/9/14.
 */
@Service("MXYYSReceiver")
public class MXYYSReceiver extends BaseReceiver {

	private static Logger logger = LoggerFactory.getLogger(MXYYSReceiver.class);

	private static String document_type = "userphoneinfo";

	/*@Autowired
	@Lazy
	public void setHandle(MXYYSParseHandler mxyysParseHandler) {
		super.setHandler(mxyysParseHandler);
	}*/

	/**
	 * 发送源数据
	 * 
	 * @param ossMap
	 * @author xiaoxoing 2017/09/26
	 */
	@Override
	protected String parseOssComment(Map<String, Object> ossMap, String ossFileKey) {
		// TODO Auto-generated method stub
		logger.info(">>>>>>>>>ossFileKey:"+ossFileKey);
		// 根据ossFielKey从OSS获取数据
		List<JSONObject> list = ossFile(ossFileKey);
		
		JSONArray data_array = JSON.parseArray(list.toString());

		ossMap.put("data", data_array);

		return document_type;
	}

	public List<JSONObject> ossFile(String ossFileKey) {
		String str_data = OssUtils.getCllientInstance().getObjectContentUTF8(ossFileKey);

		if (StringUtil.isEmpty(str_data)) {
			return null;
		}

//		String teldata = JSONObject.parseObject(str_data).get("teldata").toString();
		
        JSONArray yysInfo = ((JSONObject) JSONObject.parse(str_data)).getJSONArray("transactions");
        
		List list = new ArrayList();

		// 拆分数据
		for (Object aYysInfo : yysInfo) {

			// calls数据
			JSONArray calls = ((JSONObject) aYysInfo).getJSONArray("calls");
			if (calls != null) {
				for (Object call : calls) {
					JSONObject callObj = (JSONObject) call;
					callObj.put("doc_type", "phoneinfo_calls");
					list.add(callObj);
				}
			}

			// nets数据  doc_type : calls  nets  smses  transactions  basic
			JSONArray nets = ((JSONObject) aYysInfo).getJSONArray("nets");
			if (nets != null) {
				for (Object net : nets) {
					JSONObject netObj = (JSONObject) net;
					netObj.put("doc_type", "phoneinfo_nets");
					list.add(netObj);
				}
			}

			// smses数据
			JSONArray smses = ((JSONObject) aYysInfo).getJSONArray("smses");
			if (smses != null) {
				for (Object smse : smses) {
					JSONObject smseObj = (JSONObject) smse;
					smseObj.put("doc_type", "phoneinfo_smses");
					list.add(smseObj);
				}
			}

			// transactions 数据
			JSONArray transactions = ((JSONObject) aYysInfo).getJSONArray("transactions");
			if (transactions != null) {
				for (Object transaction : transactions) {
					JSONObject transactionObj = (JSONObject) transaction;
					transactionObj.put("doc_type", "phoneinfo_transactions");
					list.add(transactionObj);
				}
			}

			JSONObject basicObj = ((JSONObject) aYysInfo).getJSONObject("basic");
			if (basicObj != null) {
				basicObj.put("doc_type", "phoneinfo_basic");
				list.add(basicObj);
			}
		}
		return list;
	}

	public void onMessage(Message message) {
		doReceve(message);
	}

	@Override
	protected String beforeHandle(String mapMsg) {
		return mapMsg;
	}

}
