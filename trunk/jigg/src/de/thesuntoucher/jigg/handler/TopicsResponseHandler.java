package de.thesuntoucher.jigg.handler;

import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import de.thesuntoucher.jigg.data.Container;
import de.thesuntoucher.jigg.data.Topic;
import de.thesuntoucher.jigg.data.Topics;

/**
 * http://apidoc.digg.com/ListTopics
 * 
 * <topics timestamp="1176998448">
 * 	<topic name="Apple" short_name="apple">
 * 		<container name="Technology" short_name="technology" />
 * 	</topic>
 * <topic name="Design" short_name="design">
 * ...
 *
 */
public class TopicsResponseHandler extends ResponseHandler {
	
	private Topic topic;
	private Topics topics = new Topics();
	
	@Override
	public void startElement(String uri, String localName, String name, Attributes attributes) throws SAXException {
		
		// <topic name="" short_name=""/>
		if(name.equals("topic")){
			topic = new Topic(
					attributes.getValue("name"), 
					attributes.getValue("short_name"));
			topics.add(topic);
		}
		
		// <container name="Technology" short_name="technology"/>
		else if(name.equals("container")){
			topic.setContainer(new Container(
					attributes.getValue("name"), 
					attributes.getValue("short_name")));
		}
		
		// <topics timestamp="1176998448">
		else if(name.equals("topics")){
			topics.setTimestamp(new Long(attributes.getValue("timestamp")));
		}
	}
	
	/**
	 * @return
	 */
	public Topics getTopics() {
		return topics;
	}

}
