package de.thesuntoucher.jigg.data;

import java.util.Date;

/**
 * <story id="3552578" link="" submit_date="" diggs="1" comments="0"
 * status="upcoming"
 * href="http://digg.com/apple/The_History_Of_Apple_s_Products_From_The_Apple_1_Through_The_New_iMac">
 * <title></title> <description></description> <user name="darkrain1"
 * icon="http://digg.com/img/udl.png" registered="1189709258"
 * profileviews="17"/> <topic name="Apple" short_name="apple"/> <container
 * name="Technology" short_name="technology"/> </story>
 */

public class Story {

	private int id, diggs, comments;
	private String title, description, link, href;
	private Status status;
	private Date submitDate;
	private User user;
	private Topic topic;
	private Container container;

	/**
	 * 
	 */
	public Story() {

	}

	/**
	 * @param id
	 * @param link
	 * @param submitDate
	 * @param diggs
	 * @param comments
	 * @param status
	 * @param href
	 */
	public Story(int id, String link, Date submitDate, int diggs, int comments, Status status, String href) {
		this.id = id;
		this.link = link;
		this.submitDate = submitDate;
		this.diggs = diggs;
		this.comments = comments;
		this.status = status;
		this.href = href;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the diggs
	 */
	public int getDiggs() {
		return diggs;
	}

	/**
	 * @param diggs the diggs to set
	 */
	public void setDiggs(int diggs) {
		this.diggs = diggs;
	}

	/**
	 * @return the comments
	 */
	public int getComments() {
		return comments;
	}

	/**
	 * @param comments the comments to set
	 */
	public void setComments(int comments) {
		this.comments = comments;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the link
	 */
	public String getLink() {
		return link;
	}

	/**
	 * @param link the link to set
	 */
	public void setLink(String link) {
		this.link = link;
	}

	/**
	 * @return the href
	 */
	public String getHref() {
		return href;
	}

	/**
	 * @param href the href to set
	 */
	public void setHref(String href) {
		this.href = href;
	}

	/**
	 * @return the status
	 */
	public Status getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(Status status) {
		this.status = status;
	}

	/**
	 * @return the submitDate
	 */
	public Date getSubmitDate() {
		return submitDate;
	}

	/**
	 * @param submitDate the submitDate to set
	 */
	public void setSubmitDate(Date submitDate) {
		this.submitDate = submitDate;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the topic
	 */
	public Topic getTopic() {
		return topic;
	}

	/**
	 * @param topic the topic to set
	 */
	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	/**
	 * @return the container
	 */
	public Container getContainer() {
		return container;
	}

	/**
	 * @param container the container to set
	 */
	public void setContainer(Container container) {
		this.container = container;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return getTitle() + "(id: " + getId() + ")";
	}
}