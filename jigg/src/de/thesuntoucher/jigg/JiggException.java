package de.thesuntoucher.jigg;

/**
 * 
 */
public class JiggException extends RuntimeException {

	/**
	 * @param t
	 */
	public JiggException(Throwable t) {
		super(t);
	}
	
	/**
	 * @param code
	 * @param message
	 * @param t
	 */
	public JiggException(int code, String message, Throwable t) {
		super(message, t);
	}
}
