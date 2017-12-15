package tech.lapsa.javax.rs.utility;

public class InternalServerErrorException extends Exception {

    private static final long serialVersionUID = 1L;

    public InternalServerErrorException() {
	super();
    }

    public InternalServerErrorException(final String message, final Throwable cause, final boolean enableSuppression,
	    final boolean writableStackTrace) {
	super(message, cause, enableSuppression, writableStackTrace);
    }

    public InternalServerErrorException(final String message, final Throwable cause) {
	super(message, cause);
    }

    public InternalServerErrorException(final String message) {
	super(message);
    }

    public InternalServerErrorException(final Throwable cause) {
	super(cause);
    }
}
