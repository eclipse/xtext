/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.lib;

/**
 * Utilities to print information to the console.
 * 
 * @author Sven Efftinge - Initial contribution and API
 */
public class InputOutput {

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
	 * @param object
	 *            the to-be-printed object
	 * @return the printed object.
	 */
	public static <T> T print(T o) {
		System.out.print(o);
		return o;
	}
}
