package de.thesuntoucher.jigg.handler;

import java.util.Date;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import de.thesuntoucher.jigg.data.*;


/**
 * http://apidoc.digg.com/ListStories
 * 
 * <stories timestamp="1176997447" min_date="1174405440" total="3819" offset="0" count="3">
 * <story id="1806025" link="http://..." submit_date="1176997081" diggs="1" comments="0" media="news" href="http://digg.com/..." status="upcoming">
 *   <title>...</title>
 *   <description>...</description>
 *   <user name="leoinc" icon="http://digg.com/img/...png" registered="1160475488" profileviews="265" />
 *   <topic name="Apple" short_name="apple" />
 *   <container name="Technology" short_name="technology" />
 * </story>
 *
 */
public class StoriesResponseHandler extends ResponseHandler {

		private Story story;
		private Stories stories = new Stories();

		public void startElement(String uri, String localName, String name, Attributes attributes) throws SAXException {
			
			// <story id="" link="" submit_date="" diggs="" comments="0" status="upcoming" href="http://digg.com/apple/...">
			if(name.equals("story")){
				
				String promoteDate = attributes.getValue("promote_date");
				
				story = new Story(
					new Integer(attributes.getValue("id")), 
					attributes.getValue("link"),
					new Date(new Long(attributes.getValue("submit_date"))),
					promoteDate == null ? null : new Date(new Long(promoteDate)),
					new Integer(attributes.getValue("diggs")),
					new Integer(attributes.getValue("comments")),
					Status.valueOf(attributes.getValue("status")),
					Media.valueOf(attributes.getValue("media").toUpperCase()),
					attributes.getValue("href"));
				stories.add(story);
			}
			
			// <user name="" icon="http://digg.com/img/....png" registered="123" profileviews="123"/>
			else if(name.equals("user")){
				story.setUser(new User(
						attributes.getValue("name"), 
						attributes.getValue("icon"),
						new Date(new Long(attributes.getValue("registered"))),
						new Integer(attributes.getValue("profileviews"))));
			}
			
			// <topic name="" short_name=""/>
			else if(name.equals("topic")){
				story.setTopic(new Topic(
						attributes.getValue("name"), 
						attributes.getValue("short_name")));
			}
			
			// <container name="Technology" short_name="technology"/>
			else if(name.equals("container")){
				story.setContainer(new Container(
						attributes.getValue("name"), 
						attributes.getValue("short_name")));
			}
			
			// <stories timestamp="1176997447" min_date="1174405440" total="3819" offset="0" count="3">
			else if(name.equals("stories")){
				stories.setTimestamp(new Long(attributes.getValue("timestamp")));
				stories.setTotal(new Integer(attributes.getValue("total")));
				stories.setOffset(new Integer(attributes.getValue("offset")));
				stories.setCount(new Integer(attributes.getValue("count")));

				if(attributes.getValue("min_date") != null){
					stories.setMinDate(new Date(new Long(attributes.getValue("min_date"))));
				}
			}
			
		}

		public void endElement(String uri, String localName, String name) throws SAXException {
			
			// <title></title>
			if(name.equals("title")){
				story.setTitle(characterBuffer.toString().trim());
			}
			
			// <description></description>
			else if(name.equals("description")){
				story.setDescription(characterBuffer.toString().trim());
			}
			
			characterBuffer.setLength(0);
		}

		/**
		 * @return
		 */
		public Stories getStories() {
			return this.stories;
		}
	}