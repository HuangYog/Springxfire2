package com.fsnip.platform.core;

public class AppException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AppException(String msg){
		throw new RuntimeException(AppUtil.getExMsg(msg));
	}
}
