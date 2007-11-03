/**
 * 
 */
package de.thesuntoucher.jigg.data;

import java.util.*;

/**
 * 
 * <users timestamp="1176998598" total="1" offset="0" count="1">
 *
 */
public class Users extends AbstractList<User> {
	
	private long timestamp;
	private int total, offset, count;
	private List<User> users = new ArrayList<User>();
	
	/**
	 * 
	 */
	public Users() {
	}

	/**
	 * @param timestamp
	 * @param total
	 * @param offset
	 * @param count
	 */
	public Users(long timestamp, int total, int offset, int count){
		this.timestamp = timestamp;
		this.total = total;
		this.offset = offset;
		this.count = count;
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

	/* (non-Javadoc)
	 * @see java.lang.Iterable#iterator()
	 */
	public Iterator<User> iterator() {
		return this.users.iterator();
	}

	/* (non-Javadoc)
	 * @see java.util.AbstractList#get(int)
	 */
	@Override
	public User get(int index) {
		return this.users.get(index);
	}

	/* (non-Javadoc)
	 * @see java.util.AbstractCollection#size()
	 */
	@Override
	public int size() {
		return this.users.size();
	}

	/* (non-Javadoc)
	 * @see java.util.AbstractList#add(int, java.lang.Object)
	 */
	@Override
	public void add(int index, User element) {
		this.users.add(index, element);
	}
	
	
}
