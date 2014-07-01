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

	static extension ToStringContext = ToStringContext.instance

	private static def gwtCompatibleSimpleName(Class<?> clazz) {
		var name = clazz.name.replaceAll("\\$[0-9]+", "\\$")
		var start = name.lastIndexOf('$')
		if (start == -1) {
			start = name.lastIndexOf('.')
		}
		val simpleName = name.substring(start + 1)
		if(simpleName.empty) "Anonymous" else simpleName
	}

	val Object instance
	val String typeName

	boolean multiLine = true
	boolean skipNulls = false
	boolean showFieldNames = true
	val parts = <ToStringBuilder.Part>newArrayList

	/**
	 * Creates a new ToStringBuilder for the given object. If you don't use reflection, then this instance
	 * is only used for obtaining its classes' simplename.
	 * 
	 * @param instance the object to convert to a String
	 */
	new(Object instance) {
		this.instance = instance
		this.typeName = instance.class.gwtCompatibleSimpleName
	}

	/**
	 * Fields are printed on a single line, separated by commas instead of newlines
	 * @return this
	 */
	def singleLine() {
		multiLine = false
		this
	}

	/**
	 * Fields with null values will be excluded from the output
	 * @return this
	 */
	def skipNulls() {
		skipNulls = true
		this
	}

	/**
	 * Field names will not be included in the output. Useful for small classes.
	 * @return this
	 */
	def hideFieldNames() {
		showFieldNames = false
		this
	}

	/**
	 * Adds all fields declared directly in the object's class to the output
	 * @return this
	 */
	@GwtIncompatible("Class.getDeclaredFields")
	def addDeclaredFields() {
		instance.class.declaredFields.forEach[addField]
		this
	}

	/**
	 * Adds all fields declared in the object's class and its superclasses to the output.
	 * @return this
	 */
	@GwtIncompatible("Class.getDeclaredFields")
	def addAllFields() {
		instance.class.allDeclaredFields.forEach[addField]
		this
	}

	/**
	 * @param fieldName the name of the field to add to the output using reflection
	 * @return this
	 */
	@GwtIncompatible("Class.getDeclaredField(String)")
	def addField(String fieldName) {
		instance.class.allDeclaredFields.findFirst[name == fieldName].addField
	}

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
		p
	}

	private def addPart(Object value) {
		val p = addPart
		p.value = value
		this
	}

	private def addPart(String fieldName, Object value) {
		val p = addPart
		p.fieldName = fieldName
		p.value = value
		this
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
			builder.toString
		} finally {
			instance.endProcessing
		}
	}

	private def void internalToString(Object object, ToStringBuilder.IndentationAwareStringBuilder sb) {
		if (object == null) {
			sb.append("null")
		} else if (object instanceof Iterable<?>) {
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
			sb.append(object.toString)
		}
	}

	private def serializeIterable(Iterable<?> object, ToStringBuilder.IndentationAwareStringBuilder sb) {
		val iterator = object.iterator
		val simpleName = object.class.gwtCompatibleSimpleName
		sb.append(simpleName).append(" (")
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
		obj.class.gwtCompatibleSimpleName + "@" + System.identityHashCode(obj)
	}

	private def getAllDeclaredFields(Class<?> clazz) {
		var current = clazz
		val result = <Field>newArrayList
		do {
			result += current.declaredFields
			current = current.superclass
		} while (current != null)
		result
	}

	@GwtCompatible
	private static final class Part {
		String fieldName
		Object value
	}

	@GwtCompatible
	private static class IndentationAwareStringBuilder {
		val builder = new StringBuilder
		val indentationString = "  "
		val newLineString = "\n"

		int indentation = 0

		def increaseIndent() {
			indentation++
			this
		}

		def decreaseIndent() {
			indentation--
			this
		}

		def append(CharSequence string) {
			if (indentation > 0) {
				val replacement = newLineString + Strings.repeat(indentationString, indentation)
				val indented = string.toString().replace(newLineString, replacement)
				builder.append(indented)
			} else {
				builder.append(string)
			}
			this
		}

		def newLine() {
			builder.append(newLineString).append(Strings.repeat(indentationString, indentation))
			this
		}

		override String toString() {
			builder.toString
		}
	}

}

@GwtCompatible
package abstract class ToStringContext {

	def static instance() {
		try {
			ToStringContext.classLoader.loadClass("org.eclipse.xtext.xbase.lib.util.ThreadLocalToStringContext").newInstance as ToStringContext
		} catch (ClassNotFoundException e) {
			ToStringContext.classLoader.loadClass("org.eclipse.xtext.xbase.lib.util.GwtToStringContext").newInstance as ToStringContext
		}
	}

	def boolean startProcessing(Object obj) {
		currentlyProcessed.put(obj, Boolean.TRUE) == null
	}

	def void endProcessing(Object obj) {
		currentlyProcessed.remove(obj)
	}

	def abstract IdentityHashMap<Object, Boolean> getCurrentlyProcessed()
}

package class ThreadLocalToStringContext extends ToStringContext {

	static val currentlyProcessed = new ThreadLocal<IdentityHashMap<Object, Boolean>>() {
		override initialValue() {
			new IdentityHashMap
		}
	}

	override getCurrentlyProcessed() {
		ThreadLocalToStringContext.currentlyProcessed.get
	}

}

@GwtCompatible
package class GwtToStringContext extends ToStringContext {

	static val currentlyProcessed = new IdentityHashMap<Object, Boolean>

	override getCurrentlyProcessed() {
		GwtToStringContext.currentlyProcessed
	}

}
