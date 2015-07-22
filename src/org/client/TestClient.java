package org.client;

import org.codehaus.xfire.client.XFireProxyFactory;
import org.codehaus.xfire.service.Service;
import org.codehaus.xfire.service.binding.ObjectServiceFactory;
import org.simpledev.spring.xfire.model.User;
import org.simpledev.spring.xfire.service.HelloService;

import java.net.MalformedURLException;
import java.rmi.RemoteException;

public class TestClient {
	public static void main(String[] args) {
		try {
			Service serviceModel = new ObjectServiceFactory()
					.create(HelloService.class);
			HelloService service = (HelloService) new XFireProxyFactory()
					.create(serviceModel,
							"http://127.0.0.1:8080/test/service/HelloService");
			// 方法一 测试
			String str = service.sayHello("世界");
			System.out.println(str);
			// 方法二 测试
			User user = service.listUserById(1);
			System.out.println("id:" + user.getId());
			System.out.println("username:" + user.getUsername());
			System.out.println("sex:" + user.getSex());
			System.out.println("age:" + user.getAge());
			System.out.println("address:" + user.getAddress());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}
