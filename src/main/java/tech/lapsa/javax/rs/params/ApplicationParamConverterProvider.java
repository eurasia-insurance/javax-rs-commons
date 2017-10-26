package tech.lapsa.javax.rs.params;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.StreamSupport;

import javax.ws.rs.ext.ParamConverter;
import javax.ws.rs.ext.ParamConverterProvider;
import javax.ws.rs.ext.Provider;

import tech.lapsa.java.commons.function.MyMaps;

@Provider
public class ApplicationParamConverterProvider implements ParamConverterProvider {

    @SuppressWarnings("unchecked")
    private static final Map<Class<?>, ParamConverter<?>> REGISTERED_CONVERTERS = MyMaps.ofEntries( //
	    StreamSupport.stream(Spliterators.spliteratorUnknownSize( //
		    ServiceLoader.load(MyParamConverterProvider.class) //
		    .iterator(),
		    Spliterator.ORDERED), false) //
		    .map(MyParamConverterProvider::entry) //
		    .toArray(Map.Entry[]::new));

    @SuppressWarnings("unchecked")
    @Override
    public <T> ParamConverter<T> getConverter(Class<T> rawType, Type genericType, Annotation[] annotations) {
	return (ParamConverter<T>) REGISTERED_CONVERTERS.keySet() //
		.stream() //
		.filter(x -> x.equals(rawType)) //
		.findFirst() //
		.map(REGISTERED_CONVERTERS::get)
		.orElse(null);
    }

}
