package com.dorong.utils;

/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. */
/*
 * Copyright (C) 2011 Fhpt All Rights Reserved.
 * 
 * yuxin
 */
/**
 * [文件名称]<br>
 * StringUtil <br>
 * <br>
 * [文件描述]<br>
 * 内容摘要.<br>
 * <br>
 * [修改记录]<br>
 * 2011-8-8 ver1.00 创建 yuxin <br>
 * 
 * @author yuxin
 * @version 1.00
 */
public class StringUtil {

    /**
     * 隐藏构造函数
     */
    private StringUtil() {

    }

    /**
     * String null-->""
     * 
     * @param value 传入的字符串
     * @return String null-->""
     */
    public static String nvl(String value) {
	if (value == null) {
	    return "";
	} else {
	    return value.trim();
	}
    }

    /**
     * @param value
     *            字符串
     * @return String ""-->null
     * 
     */
    public static String nvlNull(String value) {
	if (value == null || "".equals(value.trim())) {
	    return null;
	} else {
	    return value.trim();
	}
    }

    /**
     * 两个字符串比较
     * 
     * @param s1
     *            字符串1
     * @param s2
     *            字符串2
     * @return 如果两个字符串相同返回true，否则返回false
     * 
     */
    public static boolean isEqual(String s1, String s2) {
	if (s1 == null && s2 == null) {
	    // 两个字符串都是null，返回true
	    return true;
	}
	if (s1 == null) {
	    return false;
	}
	if (s2 == null) {
	    return false;
	}
	return s1.equals(s2);
    }

    /**
     * 判断字符串是否为null或者空串
     * 
     * @param value 传入的字符串
     * @return 如果为null或者空串，返回true，否则返回false
     */
    public static boolean isEmpty(String value) {
	if (value == null || "".equals(value.trim())) {
	    return true;
	} else {
	    return false;
	}
    }
    
    /**
     * 返回加密的银行账号作显示
     * @param memberBankAcct
     * @return
     */
    public static String getMemberBankAcctAlias(String memberBankAcct) {
    	int l = memberBankAcct.length();
		return "********"+memberBankAcct.substring(l-4);
	}

}
