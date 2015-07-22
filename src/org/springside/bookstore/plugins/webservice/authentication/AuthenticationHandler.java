package org.springside.bookstore.plugins.webservice.authentication;

import org.apache.log4j.Logger;
import org.codehaus.xfire.MessageContext;
import org.codehaus.xfire.exchange.InMessage;
import org.codehaus.xfire.fault.XFireFault;
import org.codehaus.xfire.handler.AbstractHandler;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.Namespace;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

import java.io.FileWriter;

/**
 * XFire的回调的Handler，在XFire配置文件中配置 Server端的认证模块，回调处理模块
 * 
 * ClientAuthHandler跟AuthenticationHandler要一起用，或者都不用
 * 
 * @author david.turing
 * @blog openssl.blogjava.net
 * 
 */
public class AuthenticationHandler extends AbstractHandler {
	private static final Logger log = Logger
			.getLogger(AuthenticationHandler.class);

	public void invoke(MessageContext context) throws Exception {

		log.info("#AuthenticationHandler is invoked");
		InMessage message = context.getInMessage();

		final Namespace TOKEN_NS = Namespace.getNamespace("SpringSide",
				"http://service.webservice.plugins.bookstore.springside.org");

		if (message.getHeader() == null) {
			System.out.println("请求必须包含验证信息");
			throw new XFireFault("GetRelation Service Should be Authenticated",
					XFireFault.SENDER);
		}
		System.out.println(message.getHeader());
		System.out.println(message.getHeader().getChild("SpringSide:header"));
		Document document = new Document();
		document.addContent(new Element("root"));
		Format format = Format.getPrettyFormat();
		format.setIndent(" ");
		System.out.println(message.getHeader().toString());
		System.out.println(document.toString());
		XMLOutputter out = new XMLOutputter(format);
		out.output(document, new FileWriter("jdom2.xml"));

		Element token = message.getHeader().getChild("AuthenticationToken",
				TOKEN_NS);
		System.out.println(message.getHeader().getChild("Security", TOKEN_NS));
		System.out.println(message.getHeader().getChild("Username", TOKEN_NS));
		if (token == null) {
			System.out.println("请求必须包含身份验证信息");
			throw new XFireFault("Request must include authentication token.",
					XFireFault.SENDER);
		}

		String username = token.getChild("Username", TOKEN_NS).getValue();
		String password = token.getChild("Password", TOKEN_NS).getValue();

		System.out.println("username=" + username);
		System.out.println("password=" + password);

		if (username == null || password == null)
			throw new XFireFault("Supplied Username and Password Please",
					XFireFault.SENDER);

		/**
		 * 检查用户名密码是否正确
		 */
		//String uname = PropertiesConfig.getUname();
		//String pwd = PropertiesConfig.getPwd();
		if (username.equals(password)) {
			System.out.println("身份验证通过");
		} else {
			System.out.println("身份验证失败");
			throw new XFireFault(
					"Authentication Fail! Check username/password",
					XFireFault.SENDER);
		}

	}
}