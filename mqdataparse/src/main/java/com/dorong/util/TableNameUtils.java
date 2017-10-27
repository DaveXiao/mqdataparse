package com.dorong.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public  class TableNameUtils {
	
	private static Logger log = LoggerFactory.getLogger(TableNameUtils.class);
	/**
	 * @Description: 根据 type 为 tableName 生成后缀
	 * @param: tableName:原始的表明
	 * @param: strDate:表后缀的日期
	 * @param: type: 1 -> 一年创建一张表; 2 -> 一个月创建一张表; 4 -> 一个月创建三张表;
	 * @return: 原始的表明+后缀 @throws
	 */
	public static String generateTableName(String tableName, Date date, int type) {
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

			date = format.parse(format.format(date));
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);

			int year = calendar.get(Calendar.YEAR);
			String month = (calendar.get(Calendar.MONTH) + 1) + "";
			month = month.length() == 1 ? "0" + month : month;
			int day = calendar.get(Calendar.DAY_OF_MONTH);

			switch (type) {
				case 1:
					tableName += "_" + year;
					break;
				case 2:
					tableName += "_" + year + month;
					break;
				case 4:
					String section = "";
					if (day <= 10) {
						section = "01";
					} else if (day > 10 && day <= 20) {
						section = "02";
					} else if (day > 20) {
						section = "03";
					}
					tableName += "_" + year + month + section;
					break;
			}
		} catch (ParseException e) {
			log.info("==============  : 日期格式化异常");
		}
		return tableName;
	}

	/**
	 * @Description: 根据 type 为 tableName 生成后缀
	 * @param: tableName:原始的表明
	 * @param:type:  1 -> 一年创建一张表; 2 -> 一个月创建一张表; 4 -> 一个月创建三张表;
	 * @return:原始的表明+后缀 @throws
	 */
	public static String generateTableName(String tableName,String strDate, int type) {
		try {
			Date date = new SimpleDateFormat("yyyy-MM-dd").parse(strDate);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);

			int year = calendar.get(Calendar.YEAR);
			String month = (calendar.get(Calendar.MONTH) + 1)+"";
			month = month.length() == 1 ? "0" + month : month;
			int day = calendar.get(Calendar.DAY_OF_MONTH);

			switch (type) {
				case 1:
					tableName += "_" + year;
					break;
				case 2:
					tableName += "_" + year + month;
					break;
				case 4:
					String section = "";
					if (day <= 10) {
						section = "01";
					} else if (day > 10 && day <= 20) {
						section = "02";
					} else if (day > 20) {
						section = "03";
					}
					tableName += "_" + year + month + section;
					break;
			}
		} catch (ParseException e) {
			log.info("==============  : 日期格式化异常");
		}
		return tableName;
	}

	/**
	 * @Description: 根据 type 为 tableName 生成后缀 
	 * @param: tableName:原始的表明 
	 * @param:type:1 -> 一年创建一张表; 2 -> 一个月创建一张表; 4 -> 一个月创建三张表; 
	 * @return:原始的表明+后缀 @throws
	 */
	public static String generateTableName(String tableName, int type) {
		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);
		String month = (now.get(Calendar.MONTH) + 1) + "";
		int day = now.get(Calendar.DAY_OF_MONTH);
		month = month.length() == 1 ? "0" + month : month;

		switch (type) {
		case 1:
			tableName += "_" + year;
			break;
		case 2:
			tableName += "_" + year + month;
			break;
		case 4:
			String section = "";
			if (day <= 10) {
				section = "01";
			} else if (day > 10 && day <= 20) {
				section = "02";
			} else if (day > 20) {
				section = "03";
			}
			tableName += "_" + year + month + section;
			break;
		default:
			return tableName;
		}
		return tableName;
	}
}
