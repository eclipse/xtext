/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.lib.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.eclipse.xtext.xbase.lib.Exceptions;

/**
 * Extension methods to simplify reflective invocation of methods and fields.
 * 
 * @author Sven Efftinge - Initial contribution and API
 * @since 2.3
 */
public class ReflectExtensions {

	/**
	 * Sets the given value on an the receivers's accessible field with the given name.
	 * @param receiver the receiver
	 * @param fieldName the field's name
	 * @param value the value to set
	 */
	public void set(Object receiver, String fieldName, Object value) {
		try {
			if (receiver == null)
				throw new NullPointerException("receiver");
			Class<? extends Object> clazz = receiver.getClass();
			Field f = clazz.getField(fieldName);
			f.set(receiver, value);
		} catch (Exception e) {
			throw Exceptions.sneakyThrow(e);
		}
	}
	
	/**
	 * Retrieves the value of the given accessible field of the given receiver.
	 * @param receiver the container of the field
	 * @param fieldName the field's name
	 * @return the value of the field
	 */
	@SuppressWarnings("unchecked")
	public <T> T get(Object receiver, String fieldName) {
		try {
			if (receiver == null)
				throw new NullPointerException("receiver");
			
			Class<? extends Object> clazz = receiver.getClass();
			Field f = clazz.getField(fieldName);
			return (T) f.get(receiver);
		} catch (Exception e) {
			throw Exceptions.sneakyThrow(e);
		}
	}
	
	/**
	 * Invokes the first accessible method defined on the receiver'c class with the given name and
	 * a parameter list compatible to the given arguments.
	 * 
	 * @param receiver the method call receiver
	 * @param methodName the method name
	 * @param args the arguments for the method invocation
	 * @return the result of the method invocation. <code>null</code> if the method was of type void.
	 */
	public Object invoke(Object receiver, String methodName, Object...args) {
		try {
			if (receiver == null)
				throw new NullPointerException("receiver");
			
			Class<? extends Object> clazz = receiver.getClass();
			for (Method candidate : clazz.getMethods()) {
				if (isCompatible(candidate, methodName, args))
					return candidate.invoke(receiver, args);
			}
			// not found provoke method not found exception
			Class<?>[] paramTypes = new Class<?>[args.length];
			for (int i = 0; i< args.length ; i++) {
				paramTypes[i] = args[i] == null ? Object.class : args[i].getClass();
			}
			Method method = clazz.getMethod(methodName, paramTypes);
			return method.invoke(receiver, args);
		} catch (InvocationTargetException e) {
			throw Exceptions.sneakyThrow(e.getTargetException());
		} catch (Exception e) {
			throw Exceptions.sneakyThrow(e);
		}
	}
	
	private boolean isCompatible(Method candidate, String featureName, Object... args) {
		if (!candidate.getName().equals(featureName))
			return false;
		if (candidate.getParameterTypes().length != args.length)
			return false;
		for (int i = 0; i< candidate.getParameterTypes().length; i++) {
			Object param = args[i];
			if (param != null && !candidate.getParameterTypes()[i].isInstance(param))
				return false;
		}
		return true;
	}
	
}
