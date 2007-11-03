/**
 * 
 */
package de.thesuntoucher.jigg.args;

import java.util.Date;

import de.thesuntoucher.jigg.Jigg;

/**
 * implements <a href="http://apidoc.digg.com/ListStories#Arguments">this list of arguments</a>
 *
 */
public class StoriesArguments extends Arguments {
	
	/** newest-promoted first (default for popular stories) */
	public static final String SORT_PROMOTE_DATE_DESC = "promote_date-desc";
	
	/** oldest-promoted first */
	public static final String SORT_PROMOTE_DATE_ASC = "promote_date-asc";
	
	/** newest-submitted first (default for everything else) */
	public static final String SORT_SUBMIT_DATE_DESC = "submit_date-desc";
	
	/** oldest-submitted first */
	public static final String SORT_SUBMIT_DATE_ASC = "submit_date-asc";
	
	private Date minSubmit, maxSubmit, minPromote, maxPromote;
	private String domain, link, sort;
	
	
	/**
	 * @param minSubmit the minSubmit to set
	 * @return this
	 */
	public StoriesArguments setMinSubmit(Date minSubmit) {
		this.minSubmit = minSubmit;
		return this;
	}

	/**
	 * @param maxSubmit the maxSubmit to set
	 * @return this
	 */
	public StoriesArguments setMaxSubmit(Date maxSubmit) {
		this.maxSubmit = maxSubmit;
		return this;
	}

	/**
	 * @param minPromote the minPromote to set
	 * @return this
	 */
	public StoriesArguments setMinPromote(Date minPromote) {
		this.minPromote = minPromote;
		return this;
	}

	/**
	 * @param maxPromote the maxPromote to set
	 * @return this
	 */
	public StoriesArguments setMaxPromote(Date maxPromote) {
		this.maxPromote = maxPromote;
		return this;
	}

	/**
	 * @param domain the domain to set
	 * @return this
	 */
	public StoriesArguments setDomain(String domain) {
		this.domain = domain;
		return this;
	}

	/**
	 * @param link the link to set
	 * @return this
	 */
	public StoriesArguments setLink(String link) {
		this.link = Jigg.encodeUrl(link);
		return this;
	}

	/**
	 * @param sort the sort to set
	 * @return this
	 */
	public StoriesArguments setSort(String sort) {
		
		if(	!sort.equals(SORT_PROMOTE_DATE_ASC) &&
			!sort.equals(SORT_PROMOTE_DATE_DESC) &&
			!sort.equals(SORT_SUBMIT_DATE_ASC) &&
			!sort.equals(SORT_SUBMIT_DATE_DESC)){
			
			throw new IllegalArgumentException("the argument sort invalid. sort: " + sort);
		}
		
		this.sort = sort;
		return this;
	}

	/* (non-Javadoc)
	 * @see de.thesuntoucher.jigg.args.Arguments#toString()
	 */
	@Override
	public String toString() {
		return super.toString() + 
			(minSubmit != null ? "&min_submit_date=" + minSubmit.getTime() : "") + 
			(maxSubmit != null ? "&max_submit_date=" + maxSubmit.getTime() : "") + 
			(minPromote != null ? "&min_promote_date=" + minPromote.getTime() : "") + 
			(maxPromote != null ? "&max_promote_date=" + maxPromote.getTime() : "") + 
			(domain != null ? "&domain=" + domain : "") + 
			(link != null ? "&link=" + link : "") + 
			(sort != null ? "&sort=" + sort : "");
	}
}
