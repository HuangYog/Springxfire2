/**
 * 
 */
package org.simpledev.spring.xfire.model;

/**
 * @author hjl
 * @date 2009-6-4
 * @function
 * @version 
 */
public class User {
	private int id;
	private String username;
	private String sex;
	private int age;
	private String address;
	
	public User() {
		super();
	}
	
	public User(int id, String username, String sex, int age, String address) {
		super();
		this.id = id;
		this.username = username;
		this.sex = sex;
		this.age = age;
		this.address = address;
	}

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
}
