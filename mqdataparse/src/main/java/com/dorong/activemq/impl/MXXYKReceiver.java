package com.dorong.activemq.impl;

import java.util.Map;

import javax.jms.Message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import com.dorong.activemq.BaseReceiver;


/**
 * 魔蝎信用卡数据接口
 * Created by GaoWanli on 2017/9/14.
 */
@Service("MXXYKReceiver")
public class MXXYKReceiver extends BaseReceiver{
   /* @Autowired @Lazy
    public void setHandle(MXXYKParseHandler mxxykParseHandler) {
        super.setHandler(mxxykParseHandler);
    }*/

    public void onMessage(Message message) {
        doReceve(message);
    }

    @Override
    protected String beforeHandle(String mapMsg) {
        return mapMsg;
    }

	@Override
	protected String parseOssComment(Map<String, Object> metaData, String ossFileKey) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	protected String ossFileDataToJson(String ossFileKey) {
//		// TODO Auto-generated method stub
//		return null;
//	}
}
