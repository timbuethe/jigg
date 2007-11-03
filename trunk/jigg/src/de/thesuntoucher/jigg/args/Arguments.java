package de.thesuntoucher.jigg.args;

/**
 * @author tbuethe
 *
 */
public abstract class Arguments {
	
	/** An empty Argument-Objekt that does nothing */
	public static final Arguments EMPTY_ARGUMENTS = new Arguments(){
		@Override
		public String toString() {
			return "";
		}
	};

	private int count = -1;
	private int offset = -1;
	
	/**
	 * Offset in complete user list.
	 * Integer.
	 * Default: 0.
	 *
	 * @param offset the offset to set
	 * @return this
	 */
	public Arguments setOffset(int offset) {
		this.offset = offset;
		return this;
	}
	
	/**
	 * Number of entries to retrieve.
	 * Default: 10, Maximum: 100.
	 * 403 Error with explanatory message is returned for count > 100.
	 *
	 * @param count the count to set
	 * @return this
	 */
	public Arguments setCount(int count) {
		
		if(count < 0 || count > 100){
			throw new IllegalArgumentException(
					"count is out of range. count: " + count + " range 0-100");
		}
		
		this.count = count;
		return this;
	}

	/**
	 * @return the count
	 */
	public int getCount() {
		return count;
	}

	/**
	 * @return the offset
	 */
	public int getOffset() {
		return offset;
	}
	
	@Override
	public String toString(){
		return (count >= 0 ? "&count=" + count : "") + 
			(offset >= 0 ? "&offset=" + offset : "");
	}
}
