package com.fsnip.platform.system;

import com.fsnip.platform.core.BaseEntity;
import com.fsnip.platform.core.annotation.Column;
import com.fsnip.platform.core.annotation.Id;
import com.fsnip.platform.core.annotation.Table;

import java.util.Map;

@Table("s_menu")
public class Menu  extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String id;
	@Column
	private String text;
	@Column
	private Integer iframe;
	@Column
	private String iconCls;
	@Column
	private String pid;
	@Column
	private Integer expanded;
	@Column
	private Integer leaf;
	@Column
	private String resourceId;
	@Column
	private Integer sort;
	@Column
	private Integer type;
	@Column
	private String param;
	@Column
	private String state;
	@Column
	private String path;
	
	private Map<String, Object> attributes;
	
	private String url; //资源链接
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getIframe() {
		return iframe;
	}
	public void setIframe(Integer iframe) {
		this.iframe = iframe;
	}
	public String getIconCls() {
		return iconCls;
	}
	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public Integer getExpanded() {
		return expanded;
	}
	public void setExpanded(Integer expanded) {
		this.expanded = expanded;
	}
	public Integer getLeaf() {
		return leaf;
	}
	public void setLeaf(Integer leaf) {
		this.leaf = leaf;
	}
	public String getResourceId() {
		return resourceId;
	}
	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getParam() {
		return param;
	}
	public void setParam(String param) {
		this.param = param;
	}
	public Map<String, Object> getAttributes() {
		return attributes;
	}
	public void setAttributes(Map<String, Object> attributes) {
		this.attributes = attributes;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	
}
