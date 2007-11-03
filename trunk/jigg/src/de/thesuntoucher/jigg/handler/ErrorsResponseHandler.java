/**
 * 
 */
package de.thesuntoucher.jigg.handler;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import de.thesuntoucher.jigg.data.Error;
import de.thesuntoucher.jigg.data.Errors;

/**
 * <a href="http://apidoc.digg.com/ListErrors">http://apidoc.digg.com/ListErrors</a>
 * 
 * <errors timestamp="1176998323">
 * 	<error code="403" message="Forbidden" />
 *
 */
public class ErrorsResponseHandler extends ResponseHandler {

	private Errors errors = new Errors();
	
	@Override
	public void startElement(String uri, String localName, String name, Attributes attributes) throws SAXException {
		
		if(name.equals("error")){
			errors.add(new Error(
					new Integer(attributes.getValue("code")), 
					attributes.getValue("message")));
		}
		
		else if(name.equals("errors")){
			errors.setTimestamp(new Long(attributes.getValue("timestamp")));
		}
	}
	
	/**
	 * @return
	 */
	public Errors getErrors() {
		return errors;
	}
	
}
