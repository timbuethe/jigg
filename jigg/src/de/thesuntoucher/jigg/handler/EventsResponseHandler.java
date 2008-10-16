package de.thesuntoucher.jigg.handler;

import java.util.Date;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import de.thesuntoucher.jigg.data.*;
import static de.thesuntoucher.jigg.util.JiggDateUtil.parse;

/**
 * <a href="http://apidoc.digg.com/ListEvents">http://apidoc.digg.com/ListEvents</a><br>
 * <br>
 * <pre>
 * <events timestamp="1194127871" min_date="1176760800" max_date="1176764400" total="805" offset="0" count="10">
 *  <comment date="1176764399" id="6191927" story="1778714" up="2" down="0" replies="0" replyto="6188301" user="adml_shake">
 * </pre>
 * 
 * <pre>
 * <events timestamp="1176998174" min_date="1176760800" total="19" offset="0" count="10">
 * 	<digg date="1176935035" story="1776206" id="65657478" user="kevinrose" status="upcoming" />
 * </pre>
 * 
 * @param <E> 
 */
public class EventsResponseHandler<E> extends ResponseHandler {
	
	private Events<E> events = new Events<E>();
	
	@SuppressWarnings("unchecked")
	@Override
	public void startElement(String uri, String localName, String name, Attributes attributes) throws SAXException {
		
		// <events timestamp="1194127871" min_date="1176760800" max_date="1176764400" total="805" offset="0" count="10">
		if(name.equals("events")){
			events.setTimestamp(new Long(attributes.getValue("timestamp")));
			events.setMinDate(parse(attributes.getValue("min_date")));
			events.setTotal(new Integer(attributes.getValue("total")));
			events.setOffset(new Integer(attributes.getValue("offset")));
			events.setCount(new Integer(attributes.getValue("count")));

			if(attributes.getValue("max_date") != null){
				events.setMaxDate(parse(attributes.getValue("max_date")));
			}
		}
		
		// <comment date="1176764399" id="6191927" story="1778714" up="2" down="0" replies="0" replyto="6188301" user="adml_shake">
		else if(name.equals("comment")){
			
			Comment comment = new Comment();
			comment.setDate(parse(attributes.getValue("date")));
			comment.setStory(new Story().setId(new Integer(attributes.getValue("story"))));
			comment.setId(new Long(attributes.getValue("id")));
			comment.setUp(new Integer(attributes.getValue("up")));
			comment.setDown(new Integer(attributes.getValue("down")));
			comment.setReplies(new Integer(attributes.getValue("replies")));
			comment.setReplyto(new Long(attributes.getValue("replyto")));
			
			events.add((E) comment);
		}
		
		// <digg date="1176935035" story="1776206" id="65657478" user="kevinrose" status="upcoming" />
		else if(name.equals("digg")){
			
			Digg digg = new Digg();
			digg.setDate(parse(attributes.getValue("date")));
			digg.setStory(new Story().setId(new Integer(attributes.getValue("story"))));
			digg.setId(new Long(attributes.getValue("id")));
			digg.setUser(new User(attributes.getValue("user")));
			digg.setStatus(Status.valueOf(attributes.getValue("status")));
			
			events.add((E) digg);
		}
	}
	
	/**
	 * @return
	 */
	public Events<E> getEvents() {
		return events;
	}
}
