/**
 * 
 */
package de.thesuntoucher.jigg.data;

/**
 * <error code="404" message="Not found" />
 */
public class Error {

	private int code;
	private String message;
	
	/**
	 * @param code
	 * @param message
	 */
	public Error(int code, String message){
		this.code = code;
		this.message = message;
	}

	/**
	 * @return the code
	 */
	public int getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(int code) {
		this.code = code;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return message + " (" + code + ")";
	}
}
