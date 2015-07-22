package com.fsnip.platform.core;

import com.fsnip.platform.system.Resource;

import javax.servlet.http.HttpServletRequest;
import java.security.MessageDigest;
import java.util.List;

public class AppUtil {

	public static String getUUID() {
		return java.util.UUID.randomUUID().toString();
	}
	
	/**
	 * 验证是否权限进行操作
	 * @param request
	 * @param actionURI 操作路径，如/console/system/role/edit.do
	 * @return
	 */
	@SuppressWarnings({"unchecked" })
	public static boolean ActionAuth(HttpServletRequest request, String actionURI) {
		if(actionURI == null){
			return false;
		}
		
		List<Resource> resourceList = (List<Resource>)request.getSession().getAttribute("USERRES");
		
		for (Resource resource : resourceList) {
			if(actionURI.equals(resource.getUrl())){
				return true;
			}
		}
		return false;
	}
	
	

	public static String getWebPath(HttpServletRequest request) {
		String path = request.getContextPath();
		String basePath = request.getScheme() + "://" + request.getServerName()
				+ ":" + request.getServerPort() + path;
		return basePath;
	}

	public static String getExMsg(String msg) {
		return "<{}>" + msg;
	}

	public static String md5(String str) {
		StringBuffer sb = new StringBuffer(32);
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] array = md.digest(str.getBytes("utf-8"));
			for (int i = 0; i < array.length; i++) {
				sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100)
						.toUpperCase().substring(1, 3));
			}
		} catch (Exception e) {
			return null;
		}
		return sb.toString();
	}

	public static String getIp(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}
}