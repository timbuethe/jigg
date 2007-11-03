/**
 * 
 */
package de.thesuntoucher.jigg.data;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * http://apidoc.digg.com/ListEvents
 *
 * <events timestamp="1176998174" min_date="1176760800" total="19" offset="0" count="10">
 * 
 * @param <E> 
 */
public class Events<E> extends AbstractList<E> {

	private long timestamp;
	private int total, offset, count;
	private Date minDate, maxDate;
	private List<E> events = new ArrayList<E>();
	
	/* (non-Javadoc)
	 * @see java.util.AbstractList#get(int)
	 */
	@Override
	public E get(int index) {
		return this.events.get(index);
	}
	
	/* (non-Javadoc)
	 * @see java.util.AbstractCollection#size()
	 */
	@Override
	public int size() {
		return this.events.size();
	}

	/* (non-Javadoc)
	 * @see java.util.AbstractList#add(int, java.lang.Object)
	 */
	@Override
	public void add(int index, E element) {
		this.events.add(index, element);
	}

	/**
	 * @return the timestamp
	 */
	public long getTimestamp() {
		return timestamp;
	}

	/**
	 * @param timestamp the timestamp to set
	 */
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	/**
	 * @return the total
	 */
	public int getTotal() {
		return total;
	}

	/**
	 * @param total the total to set
	 */
	public void setTotal(int total) {
		this.total = total;
	}

	/**
	 * @return the offset
	 */
	public int getOffset() {
		return offset;
	}

	/**
	 * @param offset the offset to set
	 */
	public void setOffset(int offset) {
		this.offset = offset;
	}

	/**
	 * @return the count
	 */
	public int getCount() {
		return count;
	}

	/**
	 * @param count the count to set
	 */
	public void setCount(int count) {
		this.count = count;
	}

	/**
	 * @return the minDate
	 */
	public Date getMinDate() {
		return minDate;
	}

	/**
	 * @param minDate the minDate to set
	 */
	public void setMinDate(Date minDate) {
		this.minDate = minDate;
	}

	/**
	 * @return the maxDate
	 */
	public Date getMaxDate() {
		return maxDate;
	}

	/**
	 * @param maxDate the maxDate to set
	 */
	public void setMaxDate(Date maxDate) {
		this.maxDate = maxDate;
	}
}
