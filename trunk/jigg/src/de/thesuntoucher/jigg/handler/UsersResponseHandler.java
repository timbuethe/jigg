package de.thesuntoucher.jigg.handler;

import java.util.Date;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import de.thesuntoucher.jigg.data.User;
import de.thesuntoucher.jigg.data.Users;

/**
 * See: <a href="http://apidoc.digg.com/ListUsers">apidoc.digg.com/ListUsers</a><br>
 * <br>
 * <pre>
 * &lt;users timestamp="1190660508" total="1" offset="0" count="1"&gt;
 * 	&lt;user name="sbwms" icon="http://digg.com/users/sbwms/l.png" registered="1135702996" profileviews="7843"/&gt;
 * &lt;/users&gt;
 * </pre>
 */
public class UsersResponseHandler extends ResponseHandler {
	
	private Users users = new Users();
	
	@Override
	public void startElement(String uri, String localName, String name, Attributes attributes) throws SAXException {
		
		if(name.equals("user")){
			users.add(new User(
					attributes.getValue("name"), 
					attributes.getValue("icon"), 
					new Date(new Long(attributes.getValue("registered"))), 
					new Integer(attributes.getValue("profileviews"))));
		}
		
		else if(name.equals("users")){
			users.setTimestamp(new Long(attributes.getValue("timestamp")));
			users.setTotal(new Integer(attributes.getValue("total")));
			users.setOffset(new Integer(attributes.getValue("offset")));
			users.setCount(new Integer(attributes.getValue("count")));
		}
	}
	
	/**
	 * @return
	 */
	public Users getUsers() {
		return users;
	}
}
