package com.fsnip.platform.core;

import java.util.HashMap;
import java.util.Map;

public class Error {

	private boolean isError;
	
	private Map<String, String> errors = new HashMap<String, String>();
	
	public void addError(String field, String message){
		this.isError = true;
		this.errors.put(field, message);
	}
	
	public Map<String, String> getErrors(){
		return errors;
	}
	
	public boolean isError(){
		return isError;
	}

}
