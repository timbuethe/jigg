package de.thesuntoucher.jigg.args;

/**
 * http://apidoc.digg.com/ListUsers#Arguments
 *
 */
public class UsersArguments extends Arguments<UsersArguments> {
	
	/** username-asc: A-Z */
	public static final String SORT_USERNAME_ASC = "username-asc";

	/** username-desc: Z-A (default) */
	public static final String SORT_USERNAME_DESC = "username-desc";

	private String sort = null;

	/**
	 * How to sort returned users.
	 * One of:
	 * username-asc: A-Z.
	 * username-desc: Z-A (default).
	 * Default: username-asc
	 *
	 * @param sort the sort to set
	 * @return this
	 */
	public UsersArguments setSort(String sort) {
		this.sort = sort;
		return this;
	}

	/**
	 * @return the sort
	 */
	public String getSort() {
		return sort;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return super.toString() + 
			(sort != null ? "&sort=" + sort : "");
	}
}
