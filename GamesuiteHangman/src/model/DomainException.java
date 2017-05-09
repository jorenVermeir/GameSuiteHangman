package model;

public class DomainException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DomainException(String message, Exception exception){
		super(message, exception);
	}
}
