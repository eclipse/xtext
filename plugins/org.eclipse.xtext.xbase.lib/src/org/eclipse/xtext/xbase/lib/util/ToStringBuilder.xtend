/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.lib.util

import com.google.common.annotations.Beta
import com.google.common.annotations.GwtCompatible
import com.google.common.annotations.GwtIncompatible
import com.google.common.base.Strings
import java.lang.reflect.Field
import java.lang.reflect.Modifier
import java.util.Arrays
import java.util.IdentityHashMap

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
final class ToStringBuilder {

	static extension ToStringContext = ToStringContext.INSTANCE

	val Object instance
	val String typeName

	boolean multiLine = true
	boolean skipNulls = false
	boolean showFieldNames = true
	boolean prettyPrint = true
	val parts = <ToStringBuilder.Part>newArrayList

	/**
	 * Creates a new ToStringBuilder for the given object. If you don't use reflection, then this instance
	 * is only used for obtaining its classes' simplename.
	 * 
	 * @param instance the object to convert to a String
	 */
	new(Object instance) {
		this.instance = instance
		this.typeName = instance.class.simpleName
	}

	/**
	 * Fields are printed on a single line, separated by commas instead of newlines
	 * @return this
	 */
	def singleLine() {
		multiLine = false
		return this
	}

	/**
	 * Fields with null values will be excluded from the output
	 * @return this
	 */
	def skipNulls() {
		skipNulls = true
		return this
	}

	/**
	 * Field names will not be included in the output. Useful for small classes.
	 * @return this
	 */
	def hideFieldNames() {
		showFieldNames = false
		return this
	}
	
	/**
	 * By default, Iterables, Arrays and multiline Strings are pretty-printed.
	 * Switching to their normal representation makes the toString method significantly faster.
	 * @since 2.9
	 * @return this
	 */
	def verbatimValues() {
		prettyPrint = false
		return this
	}

	/**
	 * Adds all fields declared directly in the object's class to the output
	 * @return this
	 */
	@GwtIncompatible("Class.getDeclaredFields")
	def addDeclaredFields() {
		for (it : instance.class.declaredFields)
			addField
		return this
	}

	/**
	 * Adds all fields declared in the object's class and its superclasses to the output.
	 * @return this
	 */
	@GwtIncompatible("Class.getDeclaredFields")
	def addAllFields() {
		for (it : instance.class.allDeclaredFields)
			addField
		return this
	}

	/**
	 * @param fieldName the name of the field to add to the output using reflection
	 * @return this
	 */
	@GwtIncompatible("Class.getDeclaredField(String)")
	def addField(String fieldName) {
		instance.class.allDeclaredFields.findFirst[name == fieldName].addField
	}

	@GwtIncompatible("java.lang.reflect.Field")
	private def addField(Field field) {
		if (!Modifier.isStatic(field.modifiers)) {
			field.accessible = true
			add(field.name, field.get(instance))
		}
	}

	/**
	 * @param value the value to add to the output
	 * @param fieldName the fiel name to list the value under
	 * @return this
	 */
	def add(String fieldName, Object value) {
		addPart(fieldName, value)
	}

	/**
	 * @param value the value to add to the output without a field name
	 * @return this
	 */
	def add(Object value) {
		addPart(value)
	}

	private def addPart() {
		val p = new ToStringBuilder.Part
		parts.add(p)
		return p
	}

	private def addPart(Object value) {
		val p = addPart
		p.value = value
		return this
	}

	private def addPart(String fieldName, Object value) {
		val p = addPart
		p.fieldName = fieldName
		p.value = value
		return this
	}

	/**
	 * @return the String representation of the processed object
	 */
	override toString() {
		if (!instance.startProcessing) {
			return instance.toSimpleReferenceString
		}
		try {
			val builder = new ToStringBuilder.IndentationAwareStringBuilder
			builder.append(typeName).append(" ")
			builder.append("[")
			var nextSeparator = ""
			if (multiLine) {
				builder.increaseIndent
			}
			for (part : parts) {
				if (!skipNulls || part.value !== null) {
					if (multiLine) {
						builder.newLine
					} else {
						builder.append(nextSeparator)
						nextSeparator = ", "
					}
					if (part.fieldName !== null && showFieldNames) {
						builder.append(part.fieldName).append(" = ")
					}
					internalToString(part.value, builder)
				}
			}
			if (multiLine) {
				builder.decreaseIndent.newLine
			}
			builder.append("]")
			return builder.toString
		} finally {
			instance.endProcessing
		}
	}

	private def void internalToString(Object object, ToStringBuilder.IndentationAwareStringBuilder sb) {
		if (prettyPrint) {
			if (object instanceof Iterable<?>) {
				serializeIterable(object, sb)
			} else if (object instanceof Object[]) {
				sb.append(Arrays.toString(object))
			} else if (object instanceof byte[]) {
				sb.append(Arrays.toString(object))
			} else if (object instanceof char[]) {
				sb.append(Arrays.toString(object))
			} else if (object instanceof int[]) {
				sb.append(Arrays.toString(object))
			} else if (object instanceof boolean[]) {
				sb.append(Arrays.toString(object))
			} else if (object instanceof long[]) {
				sb.append(Arrays.toString(object))
			} else if (object instanceof float[]) {
				sb.append(Arrays.toString(object))
			} else if (object instanceof double[]) {
				sb.append(Arrays.toString(object))
			} else if (object instanceof CharSequence) {
				sb.append('"').append(object.toString.replace("\n", "\\n").replace("\r", "\\r")).append('"')
			} else if (object instanceof Enum<?>) {
				sb.append(object.name)
			} else {
				sb.append(String.valueOf(object))
			}
		} else {
			sb.append(String.valueOf(object))
		}
	}

	private def void serializeIterable(Iterable<?> object, ToStringBuilder.IndentationAwareStringBuilder sb) {
		val iterator = object.iterator
		sb.append(object.class.simpleName).append(" (")
		if (multiLine) {
			sb.increaseIndent
		}
		var wasEmpty = true
		while (iterator.hasNext) {
			wasEmpty = false
			if (multiLine) {
				sb.newLine
			}
			internalToString(iterator.next, sb)
			if (iterator.hasNext) {
				sb.append(",")
			}
		}
		if (multiLine) {
			sb.decreaseIndent()
		}
		if (!wasEmpty && multiLine) {
			sb.newLine
		}
		sb.append(")")
	}

	private def toSimpleReferenceString(Object obj) {
		obj.class.simpleName + "@" + System.identityHashCode(obj)
	}

	@GwtIncompatible("java.lang.reflect.Field")
	private def getAllDeclaredFields(Class<?> clazz) {
		var current = clazz
		val result = <Field>newArrayList
		do {
			result += current.declaredFields
			current = current.superclass
		} while (current != null)
		return result
	}

	private static final class Part {
		String fieldName
		Object value
	}

	private static class IndentationAwareStringBuilder {
		val builder = new StringBuilder
		val indentationString = "  "
		val newLineString = "\n"

		int indentation = 0

		def increaseIndent() {
			indentation++
			return this
		}

		def decreaseIndent() {
			indentation--
			return this
		}

		def append(CharSequence string) {
			if (indentation > 0) {
				val replacement = newLineString + Strings.repeat(indentationString, indentation)
				val indented = string.toString().replace(newLineString, replacement)
				builder.append(indented)
			} else {
				builder.append(string)
			}
			return this
		}

		def newLine() {
			builder.append(newLineString).append(Strings.repeat(indentationString, indentation))
			return this
		}

		override String toString() {
			builder.toString
		}
	}

}

/*
 * On GWT we just use a static variable instead of a ThreadLocal
 */
@GwtCompatible(emulated=true)
package class ToStringContext {
	
	public static val INSTANCE = new ToStringContext
	
	static val currentlyProcessed = new ThreadLocal<IdentityHashMap<Object, Boolean>>() {
		override initialValue() {
			new IdentityHashMap
		}
	}

	def boolean startProcessing(Object obj) {
		currentlyProcessed.get.put(obj, Boolean.TRUE) == null
	}

	def void endProcessing(Object obj) {
		currentlyProcessed.get.remove(obj)
	}

}
