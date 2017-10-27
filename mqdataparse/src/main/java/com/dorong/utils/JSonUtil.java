package com.dorong.utils;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.ser.StdSerializerProvider;

import net.sf.json.JSONArray;
import net.sf.json.JSONNull;
import net.sf.json.JSONObject;

public class JSonUtil {
	
	protected static Logger logger = Logger.getLogger(JSonUtil.class);
	
	public static String toJSonString(Object obj) {
		ObjectMapper mapper = new ObjectMapper();
		StringWriter out = new StringWriter();
		try {
			mapper.writeValue(out, obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return out.toString();
	}

	public static String toNoNullString(Object obj) {
		StdSerializerProvider sp = new StdSerializerProvider();
		sp.setNullValueSerializer(new JsonSerializer() {
			public void serialize(Object arg0, JsonGenerator arg1, SerializerProvider arg2)
					throws IOException, JsonProcessingException {
				arg1.writeString("");
			}
		});
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializerProvider(sp);
		StringWriter out = new StringWriter();
		try {
			mapper.writeValue(out, obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return out.toString();
	}

	public static <T> T toObject(String json, Class<T> clazz) {
		ObjectMapper mapper = new ObjectMapper();
		Object t = null;
		try {
			t = mapper.readValue(json, clazz);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return (T) t;
	}

	public static Collection json2Collection(String json, Class collectionClz, Class valueClz) {
		JSONArray jsonArray = JSONArray.fromObject(json);
		return JSONArray.toCollection(jsonArray, valueClz);
	}

	public static Object json2Object(String json, Class beanClz) {
		return JSONObject.toBean(JSONObject.fromObject(json), beanClz);
	}

	public static String bean2json(Object object) {
		JSONObject jsonObject = JSONObject.fromObject(object);
		return jsonObject.toString();
	}

	public static HashMap<String, String> toHashMap(Object object) {
		HashMap data = new HashMap();

		JSONObject jsonObject = JSONObject.fromObject(object);
		Iterator it = jsonObject.keys();

		while (it.hasNext()) {
			String key = String.valueOf(it.next());
			String value = (String) jsonObject.get(key);
			data.put(key, value);
		}
		return data;
	}

	public static HashMap<String, Object> toHashMap2(Object object) {
		HashMap data = new HashMap();

		JSONObject jsonObject = JSONObject.fromObject(object);
		Iterator it = jsonObject.keys();

		while (it.hasNext()) {
			String key = String.valueOf(it.next());
			Object value = jsonObject.get(key);
			data.put(key, value);
		}
		return data;
	}

	public static HashMap<String, String> toHashMapOffNull(Object object) {
		HashMap data = new HashMap();

		JSONObject jsonObject = JSONObject.fromObject(object);
		Iterator it = jsonObject.keys();

		while (it.hasNext()) {
			String key = String.valueOf(it.next());
			if (!(JSONNull.getInstance().equals(jsonObject.get(key)))) {
				logger.info(key);
				data.put(key, String.valueOf(jsonObject.get(key)));
			}
		}
		return data;
	}
}