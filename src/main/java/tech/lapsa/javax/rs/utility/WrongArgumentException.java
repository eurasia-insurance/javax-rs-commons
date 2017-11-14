package tech.lapsa.javax.rs.utility;

public class WrongArgumentException extends Exception {

    private static final long serialVersionUID = 1L;

    public WrongArgumentException() {
	super();
    }

    public WrongArgumentException(String message, Throwable cause, boolean enableSuppression,
	    boolean writableStackTrace) {
	super(message, cause, enableSuppression, writableStackTrace);
    }

    public WrongArgumentException(String message, Throwable cause) {
	super(message, cause);
    }

    public WrongArgumentException(String message) {
	super(message);
    }

    public WrongArgumentException(Throwable cause) {
	super(cause);
    }
}
