package de.thesuntoucher.jigg.data;

import java.util.Date;

/**
 * <user name="darkrain1" icon="http://digg.com/img/udl.png"
 * registered="1189709258" profileviews="17"/>
 * 
 */
public class User {

	private String name, icon;
	private Date registered;
	private int profileviews;
	
	/**
	 * 
	 */
	public User(){
		
	}

	/**
	 * @param name
	 */
	public User(String name){
		this.name = name;
	}

	/**
	 * @param name
	 * @param icon
	 * @param registered
	 * @param profileviews
	 */
	public User(String name, String icon, Date registered, int profileviews) {
		this.name = name;
		this.icon = icon;
		this.registered = registered;
		this.profileviews = profileviews;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the icon
	 */
	public String getIcon() {
		return icon;
	}

	/**
	 * @param icon the icon to set
	 */
	public void setIcon(String icon) {
		this.icon = icon;
	}

	/**
	 * @return the registered
	 */
	public Date getRegistered() {
		return registered;
	}

	/**
	 * @param registered the registered to set
	 */
	public void setRegistered(Date registered) {
		this.registered = registered;
	}

	/**
	 * @return the profileviews
	 */
	public int getProfileviews() {
		return profileviews;
	}

	/**
	 * @param profileviews the profileviews to set
	 */
	public void setProfileviews(int profileviews) {
		this.profileviews = profileviews;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return name + "(" + registered + ")";
	}
}