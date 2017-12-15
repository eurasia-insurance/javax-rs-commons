package tech.lapsa.javax.rs.utility;

import java.util.Locale;

import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.MediaType;
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

    public static final Response responseServerError(final String message) {
	return response(Status.INTERNAL_SERVER_ERROR, MediaType.TEXT_PLAIN_TYPE, message);
    }

    public static final Response responseServerError(final InternalServerErrorException e) {
	return response(Status.INTERNAL_SERVER_ERROR, MediaType.TEXT_PLAIN_TYPE, e.getMessage());
    }

    public static final Response responseInternalServerError(final InternalServerErrorException e,
	    final Locale locale) {
	return response(Status.INTERNAL_SERVER_ERROR, locale, MediaType.TEXT_PLAIN_TYPE, e.getMessage());
    }

    //

    public static final Response responseNotFound(final Object entity) {
	return response(Status.NOT_FOUND, entity);
    }

    public static final Response responseNotFound(final MediaType type, final Object entity) {
	return response(Status.NOT_FOUND, type, entity);
    }

    public static final Response responseNotFound(final Object entity, final Locale locale) {
	return response(Status.NOT_FOUND, locale, entity);
    }

    public static final Response responseNotFound(final MediaType type, final Object entity, final Locale locale) {
	return response(Status.NOT_FOUND, locale, type, entity);
    }

    //

    public static final Response responseBadRequest(final String message) {
	return response(Status.BAD_REQUEST, MediaType.TEXT_PLAIN_TYPE, message);
    }

    public static final Response responseBadRequest(final WrongArgumentException e) {
	return response(Status.BAD_REQUEST, MediaType.TEXT_PLAIN_TYPE, e.getMessage());
    }

    public static final Response responseWrongArgument(final WrongArgumentException e, final Locale locale) {
	return response(Status.BAD_REQUEST, locale, MediaType.TEXT_PLAIN_TYPE, e.getMessage());
    }

    //

    public static final Response responseOk(final Object entity) {
	return response(Status.OK, entity);
    }

    public static final Response responseOk(final MediaType type, final Object entity) {
	return response(Status.OK, type, entity);
    }

    public static final Response responseOk(final Object entity, final Locale locale) {
	return response(Status.OK, locale, entity);
    }

    public static final Response responseOk(final MediaType type, final Object entity, final Locale locale) {
	return response(Status.OK, locale, type, entity);
    }

    //

    public static final Response response(final Status status, final Object entity) {
	return response(status, Locale.getDefault(), entity);
    }

    public static final Response response(final Status status, final MediaType type, final Object entity) {
	return response(status, Locale.getDefault(), type, entity);
    }

    public static final Response response(final Status status, final Locale locale, final Object entity) {
	return Response
		.status(status) //
		.cacheControl(RESTUtils.CACHE_CONTROL_NO_CACHE) //
		.entity(entity) //
		.language(locale) //
		.encoding(DEFAULT_ENCODING) //
		.build();
    }

    public static final Response response(final Status status, final Locale locale, final MediaType type,
	    final Object entity) {
	return Response
		.status(status) //
		.cacheControl(RESTUtils.CACHE_CONTROL_NO_CACHE) //
		.entity(entity) //
		.type(type) //
		.language(locale) //
		.encoding(DEFAULT_ENCODING) //
		.build();
    }

}
