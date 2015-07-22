/**
 * 
 */
package org.simpledev.spring.xfire.service.impl;

import org.simpledev.spring.xfire.model.User;
import org.simpledev.spring.xfire.service.HelloService;

import java.rmi.RemoteException;

/**
 * @author hjl
 * @date 2009-6-4
 * @function
 * @version 
 */
public class HelloServiceImpl implements HelloService {

	public User listUserById(int id) throws RemoteException {
		System.out.println("server listUserById invoke");
		User user = new User(id,"纪纱","女",12,"日本都立海原高校");
		return user;
	}

	public String sayHello(String username) throws RemoteException {
		System.out.println("server sayHello invoke");
		return "你好 " + username;
	}

}
