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

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;

/**
 * Extension methods to simplify reflective invocation of methods and fields.
 * 
 * @author Sven Efftinge - Initial contribution and API
 * @since 2.3
 */
@Beta
@GwtCompatible public class ReflectExtensions {

	/**
	 * Sets the given value on an the receivers's accessible field with the given name.
	 * 
	 * @param receiver the receiver, never <code>null</code>
	 * @param fieldName the field's name, never <code>null</code>
	 * @param value the value to set
	 * 
	 * @throws NoSuchFieldException see {@link Class#getField(String)}
	 * @throws SecurityException see {@link Class#getField(String)}
	 * @throws IllegalAccessException see {@link Field#set(Object, Object)}
	 * @throws IllegalArgumentException see {@link Field#set(Object, Object)}
	 */
	public void set(Object receiver, String fieldName, /* @Nullable */ Object value) throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
		Preconditions.checkNotNull(receiver,"receiver");
		Preconditions.checkNotNull(fieldName,"fieldName");
		Class<? extends Object> clazz = receiver.getClass();
		Field f = getDeclaredField(clazz, fieldName);
		if (!f.isAccessible())
			f.setAccessible(true);
		f.set(receiver, value);
	}
	
	/**
	 * Retrieves the value of the given accessible field of the given receiver.
	 * 
	 * @param receiver the container of the field, not <code>null</code>
	 * @param fieldName the field's name, not <code>null</code>
	 * @return the value of the field
	 * 
	 * @throws NoSuchFieldException see {@link Class#getField(String)}
	 * @throws SecurityException see {@link Class#getField(String)}
	 * @throws IllegalAccessException see {@link Field#get(Object)}
	 * @throws IllegalArgumentException see {@link Field#get(Object)}
	 */
	@SuppressWarnings("unchecked")
	/* @Nullable */
	public <T> T get(Object receiver, String fieldName) throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
		Preconditions.checkNotNull(receiver,"receiver");
		Preconditions.checkNotNull(fieldName,"fieldName");
		
		Class<? extends Object> clazz = receiver.getClass();
		Field f = getDeclaredField(clazz, fieldName);
		if (!f.isAccessible())
			f.setAccessible(true);
		return (T) f.get(receiver);
	}
	
	private Field getDeclaredField(Class<?> clazz, String name) throws NoSuchFieldException {
		NoSuchFieldException initialException = null;
		do {
			try {
				Field f = clazz.getDeclaredField(name);
				return f;
			} catch(NoSuchFieldException noSuchField) {
				if (initialException == null) {
					initialException = noSuchField;
				}
			}
		} while((clazz = clazz.getSuperclass()) != null);
		throw initialException;
	}
	
	/**
	 * Invokes the first accessible method defined on the receiver'c class with the given name and
	 * a parameter list compatible to the given arguments.
	 * 
	 * @param receiver the method call receiver, not <code>null</code>
	 * @param methodName the method name, not <code>null</code>
	 * @param args the arguments for the method invocation
	 * @return the result of the method invocation. <code>null</code> if the method was of type void.
	 * 
	 * @throws SecurityException see {@link Class#getMethod(String, Class...)}
	 * @throws NoSuchMethodException see {@link Class#getMethod(String, Class...)}
	 * @throws IllegalAccessException see {@link Method#invoke(Object, Object...)}
	 * @throws IllegalArgumentException see {@link Method#invoke(Object, Object...)}
	 * @throws InvocationTargetException see {@link Method#invoke(Object, Object...)}
	 */
	/* @Nullable */
	public Object invoke(Object receiver, String methodName, /* @Nullable */ Object...args) throws SecurityException, IllegalArgumentException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		Preconditions.checkNotNull(receiver,"receiver");
		Preconditions.checkNotNull(methodName,"methodName");
		final Object[] arguments = args==null ? new Object[]{null}:args;
		
		Class<? extends Object> clazz = receiver.getClass();
		Method compatible = null;
		do {
			for (Method candidate : clazz.getDeclaredMethods()) {
				if (candidate != null && !candidate.isBridge() && isCompatible(candidate, methodName, arguments)) {
					if (compatible != null) 
						throw new IllegalStateException("Ambiguous methods to invoke. Both "+compatible+" and  "+candidate+" would be compatible choices.");
					compatible = candidate;
				}
			}
		} while(compatible == null && (clazz = clazz.getSuperclass()) != null);
		if (compatible != null) {
			if (!compatible.isAccessible())
				compatible.setAccessible(true);
			return compatible.invoke(receiver, arguments);
		}
		// not found provoke method not found exception
		Class<?>[] paramTypes = new Class<?>[arguments.length];
		for (int i = 0; i< arguments.length ; i++) {
			paramTypes[i] = arguments[i] == null ? Object.class : arguments[i].getClass();
		}
		Method method = receiver.getClass().getMethod(methodName, paramTypes);
		return method.invoke(receiver, arguments);
	}
	
	private boolean isCompatible(Method candidate, String featureName, Object... args) {
		if (!candidate.getName().equals(featureName))
			return false;
		if (candidate.getParameterTypes().length != args.length)
			return false;
		for (int i = 0; i< candidate.getParameterTypes().length; i++) {
			Object param = args[i];
			Class<?> class1 = candidate.getParameterTypes()[i];
			if (class1.isPrimitive())
				class1 = wrapperTypeFor(class1);
			if (param != null && !class1.isInstance(param))
				return false;
		}
		return true;
	}
	
	private Class<?> wrapperTypeFor(Class<?> primitive) {
		Preconditions.checkNotNull(primitive);
        if (primitive == Boolean.TYPE) return Boolean.class;
        if (primitive == Byte.TYPE) return Byte.class;
        if (primitive == Character.TYPE) return Character.class;
        if (primitive == Short.TYPE) return Short.class;
        if (primitive == Integer.TYPE) return Integer.class;
        if (primitive == Long.TYPE) return Long.class;
        if (primitive == Float.TYPE) return Float.class;
        if (primitive == Double.TYPE) return Double.class;
        if (primitive == Void.TYPE) return Void.class;
        throw new IllegalArgumentException(primitive+ " is not a primitive");
    }
	
}
