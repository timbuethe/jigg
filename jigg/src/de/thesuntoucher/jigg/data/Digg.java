/**
 * 
 */
package de.thesuntoucher.jigg.data;

import de.thesuntoucher.jigg.util.JiggDateUtil;

/**
 * http://apidoc.digg.com/ListEvents
 *
 * <events timestamp="1176998174" min_date="1176760800" total="19" offset="0" count="10">
 *  <digg date="1176935035" story="1776206" id="65657478" user="kevinrose" status="upcoming" />
 */
public class Digg extends Event {

	private Status status;

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
	
	@Override
	public String toString() {
		return "Digg (by " + getUser() + " at " + JiggDateUtil.format(getDate()) + ")";
	}
}
