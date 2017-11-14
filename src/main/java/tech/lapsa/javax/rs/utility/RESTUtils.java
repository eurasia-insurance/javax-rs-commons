package tech.lapsa.javax.rs.utility;

import java.util.Locale;

import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

public final class RESTUtils {
    public static final String DEFAULT_ENCODING = "UTF-8";

    public static final CacheControl CACHE_CONTROL_NO_CACHE;
    static {
	CACHE_CONTROL_NO_CACHE = new CacheControl();
	CACHE_CONTROL_NO_CACHE.setMustRevalidate(true);
	CACHE_CONTROL_NO_CACHE.setNoCache(true);
	CACHE_CONTROL_NO_CACHE.setNoStore(true);
	CACHE_CONTROL_NO_CACHE.setProxyRevalidate(true);
    }

    //

    public static final Response responseServerError(String message) {
	return response(Status.INTERNAL_SERVER_ERROR, message);
    }

    public static final Response responseServerError(InternalServerErrorException e) {
	return response(Status.INTERNAL_SERVER_ERROR, e.getMessage());
    }

    public static final Response responseInternalServerError(InternalServerErrorException e, Locale locale) {
	return response(Status.INTERNAL_SERVER_ERROR, locale, e.getMessage());
    }

    //

    public static final Response responseNotFound(Object entity) {
	return response(Status.NOT_FOUND, entity);
    }

    public static final Response responseNotFound(Object entity, Locale locale) {
	return response(Status.NOT_FOUND, locale, entity);
    }

    //

    public static final Response responseBadRequest(String message) {
	return response(Status.BAD_REQUEST, message);
    }

    public static final Response responseBadRequest(WrongArgumentException e) {
	return response(Status.BAD_REQUEST, e.getMessage());
    }

    public static final Response responseWrongArgument(WrongArgumentException e, Locale locale) {
	return response(Status.BAD_REQUEST, locale, e.getMessage());
    }

    //

    public static final Response responseOk(Object entity) {
	return response(Status.OK, entity);
    }

    public static final Response responseOk(Object entity, Locale locale) {
	return response(Status.OK, locale, entity);
    }

    //

    public static final Response response(Status status, Object entity) {
	return response(status, Locale.getDefault(), entity);
    }

    public static final Response response(Status status, Locale locale, Object entity) {
	return Response
		.status(status)
		.cacheControl(RESTUtils.CACHE_CONTROL_NO_CACHE)
		.entity(entity)
		.language(locale)
		.encoding(DEFAULT_ENCODING)
		.build();
    }

}
