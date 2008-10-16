/**
 * 
 */
package de.thesuntoucher.jigg.args;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import de.thesuntoucher.jigg.Jigg;
import de.thesuntoucher.jigg.data.Media;

/**
 * implements <a href="http://apidoc.digg.com/ListStories#Arguments">this list of arguments</a>
 *
 */
public class StoriesArguments extends Arguments<StoriesArguments> {
	
	/** newest-promoted first (default for popular stories) */
	public static final String SORT_PROMOTE_DATE_DESC = "promote_date-desc";
	
	/** oldest-promoted first */
	public static final String SORT_PROMOTE_DATE_ASC = "promote_date-asc";
	
	/** newest-submitted first (default for everything else) */
	public static final String SORT_SUBMIT_DATE_DESC = "submit_date-desc";
	
	/** oldest-submitted first */
	public static final String SORT_SUBMIT_DATE_ASC = "submit_date-asc";

	/** lowest digg count first */
	public static final String SORT_DIGG_COUNT_ASC = "digg_count-asc";
	
	/** highest digg count first */
	public static final String SORT_DIGG_COUNT_DESC = "digg_count-desc";
	
	private Date minSubmit, maxSubmit, minPromote, maxPromote, minDate, maxDate;
	private String domain, link, sort;
	private List<Media> media;
	
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
	 * @param minDate
	 * @return this
	 */
	public StoriesArguments setMinDate(Date minDate) {
		this.minDate = minDate;
		return this;
	}

	/**
	 * @param maxDate
	 * @return this
	 */
	public StoriesArguments setMaxDate(Date maxDate) {
		this.maxDate = maxDate;
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
	 * @param media
	 * @return this
	 */
	public StoriesArguments setMedia(Media... media) {
		this.media = Arrays.asList(media);
		return this;
	}
	
	private String getMediaString(){
		
		if(media == null || media.isEmpty()){
			return "all";
		}
		
		StringBuilder sb = new StringBuilder();
		for (Media media : this.media) {
			sb.append(media.getShortName() + ",");
		}
		
		return sb.substring(0, sb.length()-1);
	}

	/**
	 * @param sort the sort to set
	 * @return this
	 */
	public StoriesArguments setSort(String sort) {
		
		if(	!sort.equals(SORT_PROMOTE_DATE_ASC) &&
			!sort.equals(SORT_PROMOTE_DATE_DESC) &&
			!sort.equals(SORT_SUBMIT_DATE_ASC) &&
			!sort.equals(SORT_SUBMIT_DATE_DESC) &&
			!sort.equals(SORT_DIGG_COUNT_ASC) &&
			!sort.equals(SORT_DIGG_COUNT_DESC)){
			
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
			(minSubmit != null ? "&min_submit_date=" + minSubmit.getTime() / 1000 : "") + 
			(maxSubmit != null ? "&max_submit_date=" + maxSubmit.getTime() / 1000 : "") + 
			(minPromote != null ? "&min_promote_date=" + minPromote.getTime() / 1000 : "") + 
			(maxPromote != null ? "&max_promote_date=" + maxPromote.getTime() / 1000 : "") + 
			(minDate != null ? "&min_date=" + minDate.getTime() / 1000 : "") + 
			(maxDate != null ? "&max_date=" + maxDate.getTime() / 1000 : "") + 
			(domain != null ? "&domain=" + domain : "") + 
			(link != null ? "&link=" + link : "") + 
			(media != null && media.size() > 0 ? "&media=" + getMediaString() : "") + 
			(sort != null ? "&sort=" + sort : "");
	}
}
