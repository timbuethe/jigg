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
public class Errors extends AbstractList<Error> {

	private long timestamp;
	private List<Error> errors = new ArrayList<Error>();
	
	/* (non-Javadoc)
	 * @see java.util.AbstractList#get(int)
	 */
	@Override
	public Error get(int index) {
		return this.errors.get(index);
	}
	
	/* (non-Javadoc)
	 * @see java.util.AbstractCollection#size()
	 */
	@Override
	public int size() {
		return this.errors.size();
	}

	/* (non-Javadoc)
	 * @see java.util.AbstractList#add(int, java.lang.Object)
	 */
	@Override
	public void add(int index, Error element) {
		this.errors.add(index, element);
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
