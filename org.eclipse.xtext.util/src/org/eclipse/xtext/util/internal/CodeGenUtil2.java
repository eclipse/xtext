/**
 * Copyright (c) 2002, 2017 IBM Corporation and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   IBM - Initial API and implementation
 */
package org.eclipse.xtext.util.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Partial Copy of EMF's CodeGenUtil
 */
public class CodeGenUtil2 {

	/**
	 * Tests whether the given string is the name of a java.lang type.
	 */
	public static boolean isJavaLangType(String s) {
		return getJavaDefaultTypes().contains(s) && Character.isUpperCase(s.charAt(0));
	}

	/**
	 * Tests whether the given string is the name of a primitive or java.lang type.
	 */
	public static boolean isJavaDefaultType(String s) {
		return getJavaDefaultTypes().contains(s);
	}

	/**
	 * Formats a name by parsing it into words separated by underscores and/or mixed-casing and then recombining them using the specified
	 * separator. A prefix can also be given to be recognized as a separate word or to be trimmed. Leading underscores can be ignored or can
	 * cause a leading separator to be prepended.
	 * 
	 * @since 2.2
	 */
	public static String format(String name, char separator, String prefix, boolean includePrefix, boolean includeLeadingSeparator) {
		String leadingSeparators = includeLeadingSeparator ? getLeadingSeparators(name, '_') : null;
		if (leadingSeparators != null) {
			name = name.substring(leadingSeparators.length());
		}

		List<String> parsedName = new ArrayList<String>();
		if (prefix != null && name.startsWith(prefix) && name.length() > prefix.length()
				&& Character.isUpperCase(name.charAt(prefix.length()))) {
			name = name.substring(prefix.length());
			if (includePrefix) {
				parsedName = parseName(prefix, '_');
			}
		}

		if (name.length() != 0)
			parsedName.addAll(parseName(name, '_'));

		StringBuilder result = new StringBuilder();

		for (Iterator<String> nameIter = parsedName.iterator(); nameIter.hasNext();) {
			String nameComponent = nameIter.next();
			result.append(nameComponent);

			if (nameIter.hasNext() && nameComponent.length() > 1) {
				result.append(separator);
			}
		}

		if (result.length() == 0 && prefix != null) {
			result.append(prefix);
		}
		return leadingSeparators != null ? "_" + result.toString() : result.toString();
	}

	private static String getLeadingSeparators(String name, char separator) {
		int i = 0;
		for (int len = name.length(); i < len && name.charAt(i) == separator; i++) {
			// the for loop's condition finds the separator 
		}
		return i != 0 ? name.substring(0, i) : null;
	}

	/**
	 * This method breaks sourceName into words delimited by separator and/or mixed-case naming.
	 */
	public static List<String> parseName(String sourceName, char separator) {
		List<String> result = new ArrayList<String>();
		if (sourceName != null) {
			StringBuilder currentWord = new StringBuilder();
			boolean lastIsLower = false;
			for (int index = 0, length = sourceName.length(); index < length; ++index) {
				char curChar = sourceName.charAt(index);
				if (Character.isUpperCase(curChar) || (!lastIsLower && Character.isDigit(curChar)) || curChar == separator) {
					if (lastIsLower && currentWord.length() > 1 || curChar == separator && currentWord.length() > 0) {
						result.add(currentWord.toString());
						currentWord = new StringBuilder();
					}
					lastIsLower = false;
				} else {
					if (!lastIsLower) {
						int currentWordLength = currentWord.length();
						if (currentWordLength > 1) {
							char lastChar = currentWord.charAt(--currentWordLength);
							currentWord.setLength(currentWordLength);
							result.add(currentWord.toString());
							currentWord = new StringBuilder();
							currentWord.append(lastChar);
						}
					}
					lastIsLower = true;
				}

				if (curChar != separator) {
					currentWord.append(curChar);
				}
			}

			result.add(currentWord.toString());
		}
		return result;
	}

	private static Set<String> javaDefaultTypes;

	/**
	 * Returns the short names of the primitives and types in java.lang (i.e. those that don't need qualification).
	 */
	public static Set<String> getJavaDefaultTypes() {
		if (javaDefaultTypes == null) {
			Set<String> result = new HashSet<String>(125);
			result.add("AbstractMethodError");
			result.add("Appendable");
			result.add("ArithmeticException");
			result.add("ArrayIndexOutOfBoundsException");
			result.add("ArrayStoreException");
			result.add("AssertionError");
			result.add("AutoCloseable");
			result.add("Boolean");
			result.add("BootstrapMethodError");
			result.add("Byte");
			result.add("Character");
			result.add("CharSequence");
			result.add("Class");
			result.add("ClassCastException");
			result.add("ClassCircularityError");
			result.add("ClassFormatError");
			result.add("ClassLoader");
			result.add("ClassNotFoundException");
			result.add("ClassValue");
			result.add("CloneNotSupportedException");
			result.add("Cloneable");
			result.add("Comparable");
			result.add("Compiler");
			result.add("Double");
			result.add("Deprecated");
			result.add("Enum");
			result.add("EnumConstantNotPresentException");
			result.add("Error");
			result.add("Exception");
			result.add("ExceptionInInitializerError");
			result.add("Float");
			result.add("FloatingDecimal");
			result.add("FunctionalInterface");
			result.add("IllegalAccessError");
			result.add("IllegalAccessException");
			result.add("IllegalArgumentException");
			result.add("IllegalCallerException");
			result.add("IllegalMonitorStateException");
			result.add("IllegalStateException");
			result.add("IllegalThreadStateException");
			result.add("IncompatibleClassChangeError");
			result.add("IndexOutOfBoundsException");
			result.add("InheritableThreadLocal");
			result.add("InstantiationError");
			result.add("InstantiationException");
			result.add("Integer");
			result.add("InternalError");
			result.add("InterruptedException");
			result.add("Iterable");
			result.add("LayerInstantiationException");
			result.add("LinkageError");
			result.add("Long");
			result.add("Math");
			result.add("Module");
			result.add("ModuleLayer");
			result.add("NegativeArraySizeException");
			result.add("NoClassDefFoundError");
			result.add("NoSuchFieldError");
			result.add("NoSuchFieldException");
			result.add("NoSuchMethodError");
			result.add("NoSuchMethodException");
			result.add("NullPointerException");
			result.add("Number");
			result.add("NumberFormatException");
			result.add("Object");
			result.add("Override");
			result.add("OutOfMemoryError");
			result.add("Package");
			result.add("Process");
			result.add("ProcessBuilder");
			result.add("Readable");
			result.add("ReflectiveOperationException");
			result.add("Runnable");
			result.add("Runtime");
			result.add("RuntimeException");
			result.add("RuntimePermission");
			result.add("SafeVarargs");
			result.add("SecurityException");
			result.add("SecurityManager");
			result.add("Short");
			result.add("StackOverflowError");
			result.add("StackTraceElement");
			result.add("StackWalker");
			result.add("StrictMath");
			result.add("String");
			result.add("StringBuffer");
			result.add("StringBuilder");
			result.add("StringIndexOutOfBoundsException");
			result.add("SuppressWarnings");
			result.add("System");
			result.add("Thread");
			result.add("ThreadDeath");
			result.add("ThreadGroup");
			result.add("ThreadLocal");
			result.add("Throwable");
			result.add("TypeNotPresentException");
			result.add("UnknownError");
			result.add("UnsatisfiedLinkError");
			result.add("UnsupportedClassVersionError");
			result.add("UnsupportedOperationException");
			result.add("VerifyError");
			result.add("VirtualMachineError");
			result.add("Void");
			result.add("boolean");
			result.add("byte");
			result.add("char");
			result.add("double");
			result.add("float");
			result.add("int");
			result.add("long");
			result.add("short");
			javaDefaultTypes = Collections.unmodifiableSet(result);
		}
		return javaDefaultTypes;
	}
}
