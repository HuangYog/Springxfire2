package com.fsnip.platform.core;


import com.fsnip.platform.global.Config;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UrlPathHelper;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;




public class BaseController{
	
	protected String SAVE_SUCCESS = "保存成功！"; 
	protected String SAVE_FAIL = "保存失败！"; 
	
	protected String UPDATE_SUCCESS = "修改成功！"; 
	protected String UPDATE_FAIL = "修改失败！"; 
	
	protected String REMOVE_SUCCESS = "删除成功！"; 
	protected String REMOVE_FAIL = "删除失败！";
	
	protected String ACTION_SUCCESS = "操作成功！"; 
	protected String ACTION_FAIL = "操作失败！";
	
	@RequestMapping(value = "/view/{viewName}", method = RequestMethod.GET)
	protected String view(HttpServletRequest request, @PathVariable String viewName) {
		
		//String uri = request.getRequestURI();
		
		UrlPathHelper urlPathHelper = new UrlPathHelper();
		String uri = urlPathHelper.getLookupPathForRequest(request);
		
		if(null == uri){
			throw new RuntimeException(AppUtil.getExMsg("未定义的视图！"));
		}
		
		String str[] = uri.replace(".do", "").split("/");

		StringBuffer sb = new StringBuffer();
		sb.append(str[1]).append("/").append(str[2]).append("/").append(str[3]).append("/").append(str[5]);
		
		return sb.toString();
	}
	

	protected Map<String, Object> jsonView(boolean success, String message) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("success", success);
		map.put("msg", message);

		return map;
	}
	
	protected int getStart(HttpServletRequest request){
		int start = request.getParameter("page") != null ? Integer.parseInt((String)request.getParameter("page")) : 0;
		return start;
	}
	
	protected int getLimit(HttpServletRequest request){
		int limit = request.getParameter("rows") != null ? Integer.parseInt((String)request.getParameter("rows")) : Integer.parseInt(Config.page_size);
		return limit;
	}
	
	public void addModelPage(Model model, Map<String, Object> page){
		model.addAttribute("LIST", page.get("rows"));
		model.addAttribute("PAGE_NUM", page.get("page_num"));
		model.addAttribute("PAGE_SIZE", page.get("page_size"));
		model.addAttribute("PAGE_BAR", page.get("page_bar"));
	}
	
	public void addModelError(Model model, Map<String, String> errors){
		model.addAttribute("ERROR", errors);
	}
	
	public String doSuccess(Model model){
		this.addMessage(model, this.SAVE_SUCCESS, "");
		return "/console/success";
	}
	
	public String doSuccess(Model model, String url){
		this.addMessage(model, url, this.ACTION_SUCCESS);
		return "/console/success";
	}
	
	/**
	 * 
	 * @param model
	 * @param url 成功跳转URL
	 * @param message 提示信息文字
	 * @return
	 */
	public String doSuccess(Model model, String url, String message){
		this.addMessage(model, url, message);
		return "/console/success";
	}
	
	public void addMessage(Model model, String url, String message){
		model.addAttribute("message", message);
		model.addAttribute("url", url);
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder){ 
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}
	
}
