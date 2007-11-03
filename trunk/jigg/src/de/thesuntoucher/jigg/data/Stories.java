/**
 * 
 */
package de.thesuntoucher.jigg.data;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * http://apidoc.digg.com/ListStories
 * 
 * <stories timestamp="1176997447" min_date="1174405440" total="3819" offset="0" count="3">
 *
 */
public class Stories extends AbstractList<Story> {

	private long timestamp;
	private int total, offset, count;
	private Date minDate;
	private List<Story> stories = new ArrayList<Story>();
	
	/* (non-Javadoc)
	 * @see java.util.AbstractList#get(int)
	 */
	@Override
	public Story get(int index) {
		return this.stories.get(index);
	}
	
	/* (non-Javadoc)
	 * @see java.util.AbstractCollection#size()
	 */
	@Override
	public int size() {
		return this.stories.size();
	}
	
	/* (non-Javadoc)
	 * @see java.util.AbstractList#add(int, java.lang.Object)
	 */
	@Override
	public void add(int index, Story element) {
		this.stories.add(index, element);
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
}
