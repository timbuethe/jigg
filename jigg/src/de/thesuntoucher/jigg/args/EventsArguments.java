/**
 * 
 */
package de.thesuntoucher.jigg.args;

import java.util.Date;

/**
 * implements <a href="http://apidoc.digg.com/ListEvents#Arguments">this list of arguments</a>
 * 
 */
public class EventsArguments extends Arguments<EventsArguments> {
	
	/** newest first (default) */
	public static final String SORT_DATE_DESC = "date-desc";
	
	/** oldest first */
	public static final String SORT_DATE_ASC = "date-asc";
	
	private Date minDate, maxDate;
	private String sort = SORT_DATE_DESC;
	
	/**
	 * @return the minDate
	 */
	public Date getMinDate() {
		return minDate;
	}
	
	/**
	 * @param minDate the minDate to set
	 * @return this
	 */
	public EventsArguments setMinDate(Date minDate) {
		this.minDate = minDate;
		return this;
	}
	
	/**
	 * @return the maxDate
	 */
	public Date getMaxDate() {
		return maxDate;
	}
	
	/**
	 * @param maxDate the maxDate to set
	 * @return this
	 */
	public EventsArguments setMaxDate(Date maxDate) {
		this.maxDate = maxDate;
		return this;
	}
	
	/**
	 * @return the sort
	 */
	public String getSort() {
		return sort;
	}
	
	/**
	 * @param sort the sort to set
	 * @return this
	 */
	public EventsArguments setSort(String sort) {
		this.sort = sort;
		return this;
	}
}
