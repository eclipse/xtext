/*******************************************************************************
 * Copyright (c) 2011, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.lib;

import com.google.common.annotations.GwtCompatible;

/**
 * Utilities to print information to the console.
 * 
 * @author Sven Efftinge - Initial contribution and API
 */
@GwtCompatible public class InputOutput {

	/**
	 * Prints a newline to standard out, by delegating directly to <code>System.out.println()</code>
	 * @since 2.3
	 */
	public static void println() {
		System.out.println();
	}
	/**
	 * Prints the given {@code object} to {@link System#out System.out} and terminate the line. Useful to log partial
	 * expressions to trap errors, e.g. the following is possible: <code>println(1 + println(2)) + 3</code>
	 * 
	 * @param object
	 *            the to-be-printed object
	 * @return the printed object.
	 */
	public static <T> T println(T object) {
		System.out.println(object);
		return object;
	}

	/**
	 * Prints the given {@code object} to {@link System#out System.out}. Useful to log partial expressions to trap
	 * errors, e.g. the following is possible: <code>1 + print(2) + 3</code>
	 * 
	 * @param o
	 *            the to-be-printed object
	 * @return the printed object.
	 */
	public static <T> T print(T o) {
		System.out.print(o);
		return o;
	}
}
