package de.thesuntoucher.jigg.data;

import java.util.Date;

/**
 * 
 *
 */
public abstract class Event {

	protected Date date;
	protected Story story;
	protected long id;
	protected User user;
	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	/**
	 * @return the story
	 */
	public Story getStory() {
		return story;
	}
	/**
	 * @param story the story to set
	 */
	public void setStory(Story story) {
		this.story = story;
	}
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
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
}
