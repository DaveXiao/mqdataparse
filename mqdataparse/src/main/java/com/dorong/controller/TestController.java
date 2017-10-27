package com.dorong.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dorong.utils.JSonUtil;
import com.pay.inf.params.HessianInvokeParam;
import com.pay.inf.service.HessianInvokeService;
import com.pay.inf.utils.HessianInvokeHelper;


/**
 * 测试HTTP接口
 * Created by ljy on 2017/3/27.
 */
@Controller
public class TestController {
	
	@Resource(name = "client-hessianService")
	private HessianInvokeService invokeService;

	/**
	 * 魔蝎运营商通话记录测试
	 */
	@RequestMapping("/local/test")
	public void testRealTimeData(){
		Map<String,String> map = new HashMap<String,String>();
		map.put("ossFileKey", "callrecords/17681831252-1503647878526");
		map.put("userCode", "405003");
		map.put("type", "THQD");//分析数据类型
		map.put("authorizeDate", "2017-07-08");
		HessianInvokeParam param = HessianInvokeHelper.processRequest(JSonUtil.toJSonString(map));
		String result = invokeService.invoke("10004",
				param.getDataLength(), param.getMsgCompress(),
				param.getDataMsg());

		System.out.println("result " +  result);
	}

	/**
	 * 魔蝎运营商通话记录测试
	 */
    @RequestMapping("/mx/yys/bill")
	public void test1(){
		Map<String,String> map = new HashMap<String,String>();
		map.put("ossFileKey", "dataSource/yys/mx/jxl/20170918/1633179_13717946366.txt");
		map.put("userCode", "1633179");
		map.put("type", "bill");
		map.put("authorizeDate", "2017-09-18");
		HessianInvokeParam param = HessianInvokeHelper.processRequest(JSonUtil.toJSonString(map));
		String result = invokeService.invoke("10001",
				param.getDataLength(), param.getMsgCompress(),
				param.getDataMsg());

		System.out.println("result " +  result);
	}

	/**
	 * 魔蝎运营商账单测试
	 */
	@RequestMapping("/mx/yys/report")
	public void test5(){
		Map<String,String> map = new HashMap<String,String>();
		map.put("ossFileKey", "dataSource/yys/mx/report/20170904/405189_13138671241.txt");
		map.put("userCode", "404652");
		map.put("type", "report");
		map.put("authorizeDate", "2017-07-08");
		HessianInvokeParam param = HessianInvokeHelper.processRequest(JSonUtil.toJSonString(map));
		String result = invokeService.invoke("10001",
				param.getDataLength(), param.getMsgCompress(),
				param.getDataMsg());

		System.out.println("result " +  result);
	}
    
    @RequestMapping("/mx/xykwy")
    public void test2(){
    	Map<String,String> map = new HashMap<String,String>();
    	map.put("ossFileKey", "dataSource/wy/mx/20170628/404902_13660735852.txt");
    	map.put("userCode", "404652");
    	map.put("authorizeDate", "2017-07-08");
    	HessianInvokeParam param = HessianInvokeHelper.processRequest(JSonUtil.toJSonString(map));
		String result = invokeService.invoke("10002",
				param.getDataLength(), param.getMsgCompress(),
				param.getDataMsg());
		
		System.out.println("result " +  result);
    }
    
    @RequestMapping("/ds/xykwy")
    public void test3(){
    	Map<String,String> map = new HashMap<String,String>();
    	map.put("ossFileKey", "dataSource/wy/mx/20170701/1228256_15352553215.txt");
    	map.put("userCode", "404652");
    	map.put("authorizeDate", "2017-07-08");
    	HessianInvokeParam param = HessianInvokeHelper.processRequest(JSonUtil.toJSonString(map));
		String result = invokeService.invoke("10003",
				param.getDataLength(), param.getMsgCompress(),
				param.getDataMsg());
		
		System.out.println("result " +  result);
    }
    
    
    
}
