package com.fsnip.platform.system;

import com.fsnip.platform.core.BaseEntity;
import com.fsnip.platform.core.annotation.Column;
import com.fsnip.platform.core.annotation.Id;
import com.fsnip.platform.core.annotation.Table;

import java.util.Date;

@Table("s_user_log")
public class UserLog  extends BaseEntity{

	private static final long serialVersionUID = 1L;
	
	
	@Id
	private String id;
	@Column
	private String userId;
	@Column
	private String resourceId;
	@Column
	private Date cdate;
	@Column
	private String ip;
	
	//查询字段
	private String account;
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getResourceId() {
		return resourceId;
	}

	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}


	public Date getCdate() {
		return cdate;
	}

	public void setCdate(Date cdate) {
		this.cdate = cdate;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

}
