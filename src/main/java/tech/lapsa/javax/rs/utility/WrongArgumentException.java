package tech.lapsa.javax.rs.utility;

public class WrongArgumentException extends Exception {

    private static final long serialVersionUID = 1L;

    public WrongArgumentException() {
	super();
    }

    public WrongArgumentException(final String message, final Throwable cause, final boolean enableSuppression,
	    final boolean writableStackTrace) {
	super(message, cause, enableSuppression, writableStackTrace);
    }

    public WrongArgumentException(final String message, final Throwable cause) {
	super(message, cause);
    }

    public WrongArgumentException(final String message) {
	super(message);
    }

    public WrongArgumentException(final Throwable cause) {
	super(cause);
    }
}
