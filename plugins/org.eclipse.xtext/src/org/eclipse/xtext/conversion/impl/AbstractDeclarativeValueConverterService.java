/*******************************************************************************
 * Copyright (c) itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.conversion.impl;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.xtext.Stable;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverter;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.parsetree.AbstractNode;

/**
 * @author Sven Efftinge - Initial contribution and API
 *
 */
@Stable(since="0.7.0")
public abstract class AbstractDeclarativeValueConverterService extends AbstractValueConverterService {
	
	private static Logger log = Logger.getLogger(AbstractDeclarativeValueConverterService.class);

	public final String toString(Object value, String lexerRule) {
		return getConverter(lexerRule).toString(value);
	}
	public final Object toValue(String string, String lexerRule, AbstractNode node) throws ValueConverterException{
		return getConverter(lexerRule).toValue(string, node);
	}

	@SuppressWarnings("unchecked")
	private final IValueConverter<Object> getConverter(String lexerRule) {
		Map<String, IValueConverter<Object>> map = getConverters();
		if (map.containsKey(lexerRule)) {
			return map.get(lexerRule);
		}
		return (IValueConverter<Object>) IValueConverter.NO_OP_CONVERTER;
	}
	
	private Map<String, IValueConverter<Object>> converters;
	
	private Map<String, IValueConverter<Object>> getConverters() {
		if (converters==null) {
			converters = new HashMap<String, IValueConverter<Object>>();
			internalRegisterForClass(getClass());
		}
		return converters;
	}
	
	@SuppressWarnings("unchecked")
	private void internalRegisterForClass(Class<?> clazz) {
		Method[] methods = clazz.getDeclaredMethods();
		for (Method method : methods) {
			if(isConfigurationMethod(method)) {
				try {
					String lexerRule = method.getAnnotation(ValueConverter.class).rule();
					if (converters.containsKey(lexerRule)) {
						log.info("value converter for lexer rule "+lexerRule+ " in class "+clazz.getSimpleName()+" has been overwritten.");
					}
					converters.put(lexerRule, (IValueConverter<Object>) method.invoke(this));
					
				} catch (Exception e) {
					log.error(e.getMessage(), e);
				}
			}
		}
		if (clazz.getSuperclass()!=null) {
			internalRegisterForClass(clazz.getSuperclass());
		}
	}
	
	private boolean isConfigurationMethod(Method method) {
		return method.isAnnotationPresent(ValueConverter.class) && method.getParameterTypes().length==0 && IValueConverter.class.isAssignableFrom(method.getReturnType());
	}

}
