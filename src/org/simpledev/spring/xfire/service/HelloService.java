/**
 * 
 */
package org.simpledev.spring.xfire.service;

import org.simpledev.spring.xfire.model.User;

import java.rmi.RemoteException;

/**
 * @author hjl
 * @date 2009-6-4
 * @function
 * @version 
 */
public interface HelloService {
	String sayHello(String username) throws RemoteException;
	User listUserById(int id) throws RemoteException;
}
