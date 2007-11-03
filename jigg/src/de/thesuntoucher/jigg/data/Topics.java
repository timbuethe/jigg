/**
 * 
 */
package de.thesuntoucher.jigg.data;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/**
 * @author tbuethe
 *
 */
public class Topics extends AbstractList<Topic> {

	private long timestamp;
	private List<Topic> topics = new ArrayList<Topic>();
	
	/* (non-Javadoc)
	 * @see java.util.AbstractList#get(int)
	 */
	@Override
	public Topic get(int index) {
		return this.topics.get(index);
	}
	
	/* (non-Javadoc)
	 * @see java.util.AbstractCollection#size()
	 */
	@Override
	public int size() {
		return this.topics.size();
	}

	/* (non-Javadoc)
	 * @see java.util.AbstractList#add(int, java.lang.Object)
	 */
	@Override
	public void add(int index, Topic element) {
		this.topics.add(index, element);
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
}
