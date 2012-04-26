/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.lib.internal;

import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.google.common.base.Strings;

/**
 * A helper class to assist construction of proper {@link Object#toString()} implementation
 * for value objects.
 * 
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("javadoc")
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
	
	public String toString(Object obj) {
		if (obj == null)
			return "null";
		final Class<? extends Object> clazz = obj.getClass();
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
	}
	
	protected void addField(Field field, Object obj, IndentationAwareStringBuilder sb) {
		try {
			field.setAccessible(true);
			Object value = field.get(obj);
			sb.newLine().append(field.getName()).append(" = ");
			internalToString(value, sb);
		} catch (Exception e) {
			sb.append(" // ERROR problems serializing field "+field.getName()+" : "+e.getClass().getSimpleName());
		}
	}
	
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
		} else {
			try {
				object.getClass().getDeclaredMethod("toString");
				sb.append(object.toString());
			} catch (NoSuchMethodException e) {
				sb.append(toString(object));
			}
		}
	}
	
	protected List<Field> getAllDeclaredFields(Class<?> clazz) {
		ArrayList<Field> fields = new ArrayList<Field>(Arrays.asList(clazz.getDeclaredFields()));
		if (clazz.getSuperclass() != null && clazz.getSuperclass() != Object.class) {
			fields.addAll(getAllDeclaredFields(clazz.getSuperclass()));
		}
		return fields;
	}
	
}
