/**
 * Copyright (c) 2014, 2023 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.lib.util;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.eclipse.xtext.xbase.lib.Exceptions;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Strings;

/**
 * Helps with the construction of good {@link Object#toString()} representations.
 * <p>You can customize the output using the builder-style methods {@link ToStringBuilder#singleLine()} {@link ToStringBuilder#skipNulls()} and {@link ToStringBuilder#hideFieldNames()}.</p>
 * <p>You can either directly list fields to include via {@link ToStringBuilder#add(String, Object)} and {@link ToStringBuilder#add(Object)}
 * or you can let the builder do it automatically using reflection, either including the fields declared in this class or including all superclasses.</p>
 * <p>The builder will automatically handle cycles in the object tree. It also pretty prints arrays and Iterables.</p>
 *
 * This class is not thread safe.
 * @since 2.7
 */
@Beta
@GwtCompatible
public final class ToStringBuilder {
	
	private static ToStringContext toStringContext = ToStringContext.INSTANCE;
	
	private final Object instance;

	private final String typeName;

	private boolean multiLine = true;

	private boolean skipNulls = false;

	private boolean showFieldNames = true;

	private boolean prettyPrint = true;

	private final List<Part> parts = new ArrayList<Part>();

	/**
	 * Creates a new ToStringBuilder for the given object. If you don't use reflection, then this instance
	 * is only used for obtaining its classes' simple name.
	 *
	 * @param instance the object to convert to a String
	 */
	public ToStringBuilder(final Object instance) {
		this.instance = instance;
		this.typeName = instance.getClass().getSimpleName();
	}

	/**
	 * Fields are printed on a single line, separated by commas instead of newlines
	 * @return this
	 */
	public ToStringBuilder singleLine() {
		this.multiLine = false;
		return this;
	}

	/**
	 * Fields with null values will be excluded from the output
	 * @return this
	 */
	public ToStringBuilder skipNulls() {
		this.skipNulls = true;
		return this;
	}

	/**
	 * Field names will not be included in the output. Useful for small classes.
	 * @return this
	 */
	public ToStringBuilder hideFieldNames() {
		this.showFieldNames = false;
		return this;
	}

	/**
	 * By default, Iterables, Arrays and multiline Strings are pretty-printed.
	 * Switching to their normal representation makes the toString method significantly faster.
	 * @since 2.9
	 * @return this
	 */
	public ToStringBuilder verbatimValues() {
		this.prettyPrint = false;
		return this;
	}

	/**
	 * Adds all fields declared directly in the object's class to the output
	 * @return this
	 */
	@GwtIncompatible("Class.getDeclaredFields")
	public ToStringBuilder addDeclaredFields() {
		Field[] fields = instance.getClass().getDeclaredFields();
		for(Field field : fields) {
			addField(field);
		}
		return this;
	}

	/**
	 * Adds all fields declared in the object's class and its superclasses to the output.
	 * @return this
	 */
	@GwtIncompatible("Class.getDeclaredFields")
	public ToStringBuilder addAllFields() {
		List<Field> fields = getAllDeclaredFields(instance.getClass());
		for(Field field : fields) {
			addField(field);
		}
		return this;
	}

	/**
	 * @param fieldName the name of the field to add to the output using reflection
	 * @return this
	 */
	@GwtIncompatible("Class.getDeclaredField(String)")
	public ToStringBuilder addField(final String fieldName) {
		List<Field> fields = getAllDeclaredFields(instance.getClass());
		for(Field field : fields) {
			if(fieldName.equals(field.getName())) {
				addField(field);
				break;
			}
		}
		return this;
	}

	@GwtIncompatible("java.lang.reflect.Field")
	private ToStringBuilder addField(final Field field) {
		if (!Modifier.isStatic(field.getModifiers())) {
			field.setAccessible(true);
			try {
				add(field.getName(), field.get(instance));
			} catch(IllegalAccessException e) {
				throw Exceptions.sneakyThrow(e);
			}
		}
		return this;
	}

	/**
	 * @param value the value to add to the output
	 * @param fieldName the field name to list the value under
	 * @return this
	 */
	public ToStringBuilder add(final String fieldName, final Object value) {
		return addPart(fieldName, value);
	}

	/**
	 * @param value the value to add to the output without a field name
	 * @return this
	 */
	public ToStringBuilder add(final Object value) {
		return addPart(value);
	}

	private Part addPart() {
		final Part p = new Part();
		this.parts.add(p);
		return p;
	}

	private ToStringBuilder addPart(final Object value) {
		final Part p = this.addPart();
		p.value = value;
		return this;
	}

	private ToStringBuilder addPart(final String fieldName, final Object value) {
		final Part p = this.addPart();
		p.fieldName = fieldName;
		p.value = value;
		return this;
	}

	/**
	 * @return the String representation of the processed object
	 */
	@Override
	public String toString() {
		boolean startProcessing = ToStringBuilder.toStringContext.startProcessing(this.instance);
		if (!startProcessing) {
			return this.toSimpleReferenceString(this.instance);
		}
		try {
			final IndentationAwareStringBuilder builder = new IndentationAwareStringBuilder();
			builder.append(typeName).append(" ");
			builder.append("[");
			String nextSeparator = "";
			if (multiLine) {
				builder.increaseIndent();
			}
			for (Part part : parts) {
				if (!skipNulls || part.value != null) {
					if (multiLine) {
						builder.newLine();
					} else {
						builder.append(nextSeparator);
						nextSeparator = ", ";
					}
					if (part.fieldName != null && this.showFieldNames) {
						builder.append(part.fieldName).append(" = ");
					}
					this.internalToString(part.value, builder);
				}
			}
			if (multiLine) {
				builder.decreaseIndent().newLine();
			}
			builder.append("]");
			return builder.toString();
		} finally {
			ToStringBuilder.toStringContext.endProcessing(this.instance);
		}
	}

	private void internalToString(final Object object, final IndentationAwareStringBuilder sb) {
		if (prettyPrint) {
			if (object instanceof Iterable<?>) {
				serializeIterable((Iterable<?>)object, sb);
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
				sb.append("\"").append(((CharSequence)object).toString().replace("\n", "\\n").replace("\r", "\\r")).append("\"");
			} else if (object instanceof Enum<?>) {
				sb.append(((Enum<?>)object).name());
			} else {
				sb.append(String.valueOf(object));
			}
		} else {
			sb.append(String.valueOf(object));
		}
	}

	private void serializeIterable(final Iterable<?> object, final IndentationAwareStringBuilder sb) {
		final Iterator<?> iterator = object.iterator();
		sb.append(object.getClass().getSimpleName()).append(" (");
		if (multiLine) {
			sb.increaseIndent();
		}
		boolean wasEmpty = true;
		while (iterator.hasNext()) {
			wasEmpty = false;
			if (multiLine) {
				sb.newLine();
			}
			this.internalToString(iterator.next(), sb);
			if (iterator.hasNext()) {
				sb.append(",");
			}
		}
		if (multiLine) {
			sb.decreaseIndent();
		}
		if (!wasEmpty && this.multiLine) {
			sb.newLine();
		}
		sb.append(")");
	}

	private String toSimpleReferenceString(final Object obj) {
		String simpleName = obj.getClass().getSimpleName();
		int identityHashCode = System.identityHashCode(obj);
		return simpleName + "@" + Integer.valueOf(identityHashCode);
	}

	@GwtIncompatible("java.lang.reflect.Field")
	private List<Field> getAllDeclaredFields(final Class<?> clazz) {
		final ArrayList<Field> result = new ArrayList<>();

		for(Class<?> current = clazz; current != null; current = current.getSuperclass()) {
			Field[] declaredFields = current.getDeclaredFields();
			result.addAll(Arrays.asList(declaredFields));
			
		}
		return result;
	}

	private static final class Part {
		private String fieldName;
		private Object value;
	}

	private static class IndentationAwareStringBuilder {
		private final StringBuilder builder = new StringBuilder();

		private final String indentationString = "  ";

		private final String newLineString = "\n";

		private int indentation = 0;

		public IndentationAwareStringBuilder increaseIndent() {
			indentation++;
			return this;
		}

		public IndentationAwareStringBuilder decreaseIndent() {
			indentation--;
			return this;
		}

		public IndentationAwareStringBuilder append(final CharSequence string) {
			if (indentation > 0) {
				String indented = string.toString().replace(
					newLineString,
					newLineString + Strings.repeat(indentationString, indentation)
				);
				builder.append(indented);
			} else {
				builder.append(string);
			}
			return this;
		}

		public IndentationAwareStringBuilder newLine() {
			builder.append(newLineString).
			append(Strings.repeat(this.indentationString, this.indentation));
			return this;
		}

		@Override
		public String toString() {
			return this.builder.toString();
		}
	}
}
