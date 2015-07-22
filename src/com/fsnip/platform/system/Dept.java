package com.fsnip.platform.system;

import com.fsnip.platform.core.BaseEntity;
import com.fsnip.platform.core.annotation.Column;
import com.fsnip.platform.core.annotation.Id;
import com.fsnip.platform.core.annotation.Table;

@Table("s_dept")
public class Dept extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String id;
	@Column
	private String pid;
	@Column
	private String name;
	@Column
	private Integer leaf;
	@Column
	private String state;
	@Column
	private String path;
	@Column
	private Integer lft;
	@Column
	private Integer rgt;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getLeaf() {
		return leaf;
	}

	public void setLeaf(Integer leaf) {
		this.leaf = leaf;
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

	public Integer getLft() {
		return lft;
	}

	public void setLft(Integer lft) {
		this.lft = lft;
	}

	public Integer getRgt() {
		return rgt;
	}

	public void setRgt(Integer rgt) {
		this.rgt = rgt;
	}

}
