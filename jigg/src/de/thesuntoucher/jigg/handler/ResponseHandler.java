/**
 * 
 */
package de.thesuntoucher.jigg.handler;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * @author tbuethe
 *
 */
public abstract class ResponseHandler extends DefaultHandler {

	protected StringBuilder characterBuffer = new StringBuilder();

	public void characters(char[] ch, int start, int length) throws SAXException {
		characterBuffer.append(new String(ch, start, length));
	}
}
