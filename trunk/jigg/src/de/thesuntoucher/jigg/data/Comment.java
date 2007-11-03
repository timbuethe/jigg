/**
 * 
 */
package de.thesuntoucher.jigg.data;

/**
 * http://apidoc.digg.com/ListEvents
 * 
 * <events timestamp="1194127871" min_date="1176760800" max_date="1176764400" total="805" offset="0" count="10">
 *	<comment date="1176764399" id="6191927" story="1778714" up="2" down="0" replies="0" replyto="6188301" user="adml_shake">
 *  
 */
public class Comment extends Event {

	private int up, down, replies;
	private long replyto;
	/**
	 * @return the up
	 */
	public int getUp() {
		return up;
	}
	/**
	 * @param up the up to set
	 */
	public void setUp(int up) {
		this.up = up;
	}
	/**
	 * @return the down
	 */
	public int getDown() {
		return down;
	}
	/**
	 * @param down the down to set
	 */
	public void setDown(int down) {
		this.down = down;
	}
	/**
	 * @return the replies
	 */
	public int getReplies() {
		return replies;
	}
	/**
	 * @param replies the replies to set
	 */
	public void setReplies(int replies) {
		this.replies = replies;
	}
	/**
	 * @return the replyto
	 */
	public long getReplyto() {
		return replyto;
	}
	/**
	 * @param replyto the replyto to set
	 */
	public void setReplyto(long replyto) {
		this.replyto = replyto;
	}
}
