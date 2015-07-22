package com.fsnip.platform.global;

import java.util.HashMap;
import java.util.Map;



/**
 * 全局数据
 * @author achuanok
 *
 */
public class DataMap {
	
	/**
	 * 资源管理，日志数据
	 * @return
	 */
	public static Map<String, String> getResourceIsLogMap(){
		Map<String, String> map = new HashMap<String, String>();  
		map.put("0", "否");  
		map.put("1", "是");  
		return map;
	}
	
	public static String getResourceIsLog(String key){
		return getResourceIsLogMap().get(key);
	}
	
	
	public static Map<String, String> getMenuTypeMap(){
		Map<String, String> map = new HashMap<String, String>();  
		map.put("1", "模块");  
		map.put("2", "菜单");  
		map.put("3", "操作");
		return map;
	}
	
	public static String getMenuType(String key){
		return getMenuTypeMap().get(key);
	}
	
	public static Map<String, String> getUserStatusMap(){
		Map<String, String> map = new HashMap<String, String>();  
		map.put("0", "正常");
		map.put("1", "停用");  
		map.put("2", "注销");  
		return map;
	}
	
	public static String getUserStatus(String key){
		return getUserStatusMap().get(key);
	}
}