package tech.lapsa.javax.rs.params;

import java.util.Map;

import javax.ws.rs.ext.ParamConverter;

public interface MyParamConverterProvider<T> {

    Map.Entry<Class<T>, ParamConverter<T>> entry();
}
