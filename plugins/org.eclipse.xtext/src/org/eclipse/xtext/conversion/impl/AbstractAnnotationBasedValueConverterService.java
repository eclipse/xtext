package org.eclipse.xtext.conversion.impl;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.conversion.ValueConverter;

public class AbstractAnnotationBasedValueConverterService implements IValueConverterService {
	
	private Log log = LogFactory.getLog(AbstractAnnotationBasedValueConverterService.class);

	public final String toString(Object value, String lexerRule) {
		return getConverter(lexerRule).toString(value);
	}
	public final Object toValue(String string, String lexerRule) {
		return getConverter(lexerRule).toValue(string);
	}

	private final IValueConverter getConverter(String lexerRule) {
		Map<String, IValueConverter> map = getConverters();
		if (map.containsKey(lexerRule)) {
			return map.get(lexerRule);
		}
		return IValueConverter.NO_OP_CONVERTER;
	}
	
	private HashMap<String, IValueConverter> converters;
	private Map<String, IValueConverter> getConverters() {
		if (converters==null) {
			converters = new HashMap<String, IValueConverter>();
			internalRegisterForClass(converters,getClass());
		}
		return converters;
	}
	
	private void internalRegisterForClass(HashMap<String, IValueConverter> converters, Class<?> class1) {
		Method[] methods = getClass().getDeclaredMethods();
		for (Method method : methods) {
			if(isConfigurationMethod(method)) {
				try {
					String lexerRule = method.getAnnotation(ValueConverter.class).rule();
					if (!converters.containsKey(lexerRule)) {
						log.info("value converter for lexer rule "+lexerRule+ " in class "+class1.getSimpleName()+" has been overwritten.");
					} else {
						converters.put(lexerRule, (IValueConverter) method.invoke(this));
					}
				} catch (Exception e) {
					log.error(e.getMessage(), e);
				}
			}
		}
		if (class1.getSuperclass()!=null) {
			internalRegisterForClass(converters, class1.getSuperclass());
		}
	}
	
	private boolean isConfigurationMethod(Method method) {
		return method.isAnnotationPresent(ValueConverter.class) && method.getParameterTypes().length==0 && IValueConverter.class.isAssignableFrom(method.getReturnType());
	}

}
