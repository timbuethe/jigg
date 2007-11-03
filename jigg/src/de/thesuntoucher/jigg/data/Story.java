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
	 * @return this
	 */
	public Story setId(int id) {
		this.id = id;
		return this;
	}

	/**
	 * @return the diggs
	 */
	public int getDiggs() {
		return diggs;
	}

	/**
	 * @param diggs the diggs to set
	 * @return this
	 */
	public Story setDiggs(int diggs) {
		this.diggs = diggs;
		return this;
	}

	/**
	 * @return the comments
	 */
	public int getComments() {
		return comments;
	}

	/**
	 * @param comments the comments to set
	 * @return this
	 */
	public Story setComments(int comments) {
		this.comments = comments;
		return this;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 * @return this
	 */
	public Story setTitle(String title) {
		this.title = title;
		return this;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 * @return this
	 */
	public Story setDescription(String description) {
		this.description = description;
		return this;
	}

	/**
	 * @return the link
	 */
	public String getLink() {
		return link;
	}

	/**
	 * @param link the link to set
	 * @return this
	 */
	public Story setLink(String link) {
		this.link = link;
		return this;
	}

	/**
	 * @return the href
	 */
	public String getHref() {
		return href;
	}

	/**
	 * @param href the href to set
	 * @return this
	 */
	public Story setHref(String href) {
		this.href = href;
		return this;
	}

	/**
	 * @return the status
	 */
	public Status getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 * @return this
	 */
	public Story setStatus(Status status) {
		this.status = status;
		return this;
	}

	/**
	 * @return the submitDate
	 */
	public Date getSubmitDate() {
		return submitDate;
	}

	/**
	 * @param submitDate the submitDate to set
	 * @return this
	 */
	public Story setSubmitDate(Date submitDate) {
		this.submitDate = submitDate;
		return this;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 * @return this
	 */
	public Story setUser(User user) {
		this.user = user;
		return this;
	}

	/**
	 * @return the topic
	 */
	public Topic getTopic() {
		return topic;
	}

	/**
	 * @param topic the topic to set
	 * @return this
	 */
	public Story setTopic(Topic topic) {
		this.topic = topic;
		return this;
	}

	/**
	 * @return the container
	 */
	public Container getContainer() {
		return container;
	}

	/**
	 * @param container the container to set
	 * @return this
	 */
	public Story setContainer(Container container) {
		this.container = container;
		return this;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return getTitle() + "(id: " + getId() + ")";
	}
}