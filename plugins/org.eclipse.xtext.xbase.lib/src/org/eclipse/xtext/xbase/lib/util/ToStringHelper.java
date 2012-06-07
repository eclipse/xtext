/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.lib.util;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;

import com.google.common.annotations.Beta;
import com.google.common.base.Strings;

/**
 * A helper class to assist construction of proper {@link Object#toString()} implementation
 * for value objects.
 * 
 * @author Sven Efftinge - Initial contribution and API
 * 
 * @since 2.3
 */
@Beta
public class ToStringHelper {
	
	private static class IndentationAwareStringBuilder {
		private StringBuilder builder = new StringBuilder();
		private int indentation = 0;
		private String indentationString = "  ";
		private String newLineString = "\n";
		
		public IndentationAwareStringBuilder increaseIndent() {
			indentation++;
			return this;
		}
		
		public IndentationAwareStringBuilder decreaseIndent() {
			indentation--;
			return this;
		}
		
		public IndentationAwareStringBuilder append(CharSequence string) {
			if (indentation>0) {
				final String replacement = newLineString + Strings.repeat(indentationString, indentation);
				final String indented = string.toString().replace(newLineString, replacement);
				builder.append(indented);
			} else {
				builder.append(string);
			}
			return this;
		}
		
		public IndentationAwareStringBuilder newLine() {
			builder.append(newLineString).append(Strings.repeat(indentationString, indentation));
			return this;
		}
		
		@Override
		public String toString() {
			return builder.toString();
		}
	}
	
	private final static ThreadLocal<IdentityHashMap<Object, Boolean>> currentlyProcessed = new ThreadLocal<IdentityHashMap<Object,Boolean>>() {
		@Override
		protected IdentityHashMap<Object, Boolean> initialValue() {
			return new IdentityHashMap<Object, Boolean>();
		}
	};
	
	/**
	 * @return false if the object is already beeing processed
	 */
	private static boolean startProcessing(Object x) {
		final IdentityHashMap<Object, Boolean> identityHashMap = currentlyProcessed.get();
		return identityHashMap.put(x, Boolean.TRUE) == null;
	}
	
	private static void endProcessing(Object x) {
		final IdentityHashMap<Object, Boolean> identityHashMap = currentlyProcessed.get();
		identityHashMap.remove(x);
	}
	
	/**
	 * Creates a string representation of the given object by listing the internal
	 * state of all fields.
	 * @param obj the object that should be printed.
	 * @return the string representation. Never <code>null</code>.
	 */
	public String toString(Object obj) {
		if (obj == null)
			return "null";
		final Class<? extends Object> clazz = obj.getClass();
		if (!startProcessing(obj)) {
			return toSimpleReferenceString(obj);
		}
		try {
			List<Field> fields = getAllDeclaredFields(clazz);
			IndentationAwareStringBuilder sb = new IndentationAwareStringBuilder();
			sb.append(clazz.getSimpleName()).append(" [").increaseIndent();
			for (Field f : fields) {
				addField(f, obj, sb);
			}
			sb.decreaseIndent();
			if (!fields.isEmpty())
				sb.newLine();
			sb.append("]");
			return sb.toString();
		} finally {
			endProcessing(obj);
		}
	}
	
	private String toSimpleReferenceString(Object obj) {
		//TODO we could try to guess a better short representation, i.e. by looking for fields named 'name' or 'id'.
		return obj.getClass().getSimpleName()+"@"+System.identityHashCode(obj);
	}

	/**
	 * Appends the fields and its value to the given string builder.
	 * @param field the field. May be a private field.
	 * @param obj the object that owns the field.
	 * @param sb the accumulating result.
	 */
	protected void addField(Field field, Object obj, IndentationAwareStringBuilder sb) {
		if (!Modifier.isStatic(field.getModifiers())) {
			try {
				field.setAccessible(true);
				Object value = field.get(obj);
				sb.newLine().append(field.getName()).append(" = ");
				internalToString(value, sb);
			} catch (Exception e) {
				sb.append(" // ERROR problems serializing field "+field.getName()+" : "+e.getClass().getSimpleName());
			}
		}
	}
	
	/**
	 * Append the field value {@code object} the the given string builder.
	 * @param object the value. May be <code>null</code>. 
	 * @param sb the accumulating result. 
	 */
	protected void internalToString(Object object, IndentationAwareStringBuilder sb) {
		if (object == null)
			sb.append("null");
		else if (object instanceof Iterable) {
			Iterator<?> iterator = ((Iterable<?>) object).iterator();
			String simpleName = object.getClass().isAnonymousClass() ? "AnonymousIterable" : object.getClass().getSimpleName();
			sb.append(simpleName).append(" (");
			sb.increaseIndent();
			boolean wasEmpty = true;
			while (iterator.hasNext()) {
				wasEmpty = false;
				sb.newLine();
				internalToString(iterator.next(), sb);
				if (iterator.hasNext()) {
					sb.append(",");
				}
			}
			sb.decreaseIndent();
			if (!wasEmpty) {
				sb.newLine();
			}
			sb.append(")");
		} else if (object instanceof Object[]) {
			sb.append(Arrays.toString((Object[])object));
		} else if (object instanceof byte[]) {
			sb.append(Arrays.toString((byte[])object));
		} else if (object instanceof char[]) {
			sb.append(Arrays.toString((char[])object));
		} else if (object instanceof int[]) {
			sb.append(Arrays.toString((int[])object));
		} else if (object instanceof boolean[]) {
			sb.append(Arrays.toString((boolean[])object));
		} else if (object instanceof long[]) {
			sb.append(Arrays.toString((long[])object));
		} else if (object instanceof float[]) {
			sb.append(Arrays.toString((float[])object));
		} else if (object instanceof double[]) {
			sb.append(Arrays.toString((double[])object));
		} else if (object instanceof CharSequence) {
			sb.append("\"").append(object.toString().replace("\n", "\\n")).append("\"");
		} else if (object instanceof Enum<?>) {
			sb.append(((Enum<?>)object).name());
		} else {
			sb.append(object.toString());
		}
	}
	
	/**
	 * Computes a list of all declared fields of the given class and
	 * its super classes. Fields of super types are appended to the list.
	 * @param clazz the clazz whose fields shall be collected.
	 * @return the list of fields. Never <code>null</code>.
	 */
	protected List<Field> getAllDeclaredFields(Class<?> clazz) {
		List<Field> result = new ArrayList<Field>();
		do {
			Collections.addAll(result, clazz.getDeclaredFields());
			clazz = clazz.getSuperclass();
		} while(clazz != null);
		return result;
	}
	
}
