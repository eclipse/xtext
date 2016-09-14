/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
	 * Prints the given {@code byte} to {@link System#out System.out} and terminate the line. Useful to log partial
	 * expressions to trap errors, e.g. the following is possible: <code>println(1 + println(2)) + 3</code>
	 * 
	 * @param object
	 *            the to-be-printed byte
	 * @return the printed byte.
	 * @since 2.11
	 */
	public static byte println(byte object) {
		System.out.println(object);
		return object;
	}

	/**
	 * Prints the given {@code short} to {@link System#out System.out} and terminate the line. Useful to log partial
	 * expressions to trap errors, e.g. the following is possible: <code>println(1 + println(2)) + 3</code>
	 * 
	 * @param object
	 *            the to-be-printed short
	 * @return the printed short.
	 * @since 2.11
	 */	
	public static short println(short object) {
		System.out.println(object);
		return object;
	}

	/**
	 * Prints the given {@code int} to {@link System#out System.out} and terminate the line. Useful to log partial
	 * expressions to trap errors, e.g. the following is possible: <code>println(1 + println(2)) + 3</code>
	 * 
	 * @param object
	 *            the to-be-printed int
	 * @return the printed int.
	 * @since 2.11
	 */	
	public static int println(int object) {
		System.out.println(object);
		return object;
	}

	/**
	 * Prints the given {@code long} to {@link System#out System.out} and terminate the line. Useful to log partial
	 * expressions to trap errors, e.g. the following is possible: <code>println(1 + println(2)) + 3</code>
	 * 
	 * @param object
	 *            the to-be-printed long
	 * @return the printed long.
	 * @since 2.11
	 */	
	public static long println(long object) {
		System.out.println(object);
		return object;
	}

	/**
	 * Prints the given {@code float} to {@link System#out System.out} and terminate the line. Useful to log partial
	 * expressions to trap errors, e.g. the following is possible: <code>println(1.0f + println(2.0f)) + 3.0f</code>
	 * 
	 * @param object
	 *            the to-be-printed float
	 * @return the printed float.
	 * @since 2.11
	 */	
	public static float println(float object) {
		System.out.println(object);
		return object;
	}

	/**
	 * Prints the given {@code double} to {@link System#out System.out} and terminate the line. Useful to log partial
	 * expressions to trap errors, e.g. the following is possible: <code>println(1.0d + println(2.0d)) + 3.0d</code>
	 * 
	 * @param object
	 *            the to-be-printed double
	 * @return the printed double.
	 * @since 2.11
	 */	
	public static double println(double object) {
		System.out.println(object);
		return object;
	}

	/**
	 * Prints the given {@code char} to {@link System#out System.out} and terminate the line. Useful to log partial
	 * expressions to trap errors, e.g. the following is possible: <code>println('a' + println('b')) + 'c'</code>
	 * 
	 * @param object
	 *            the to-be-printed char
	 * @return the printed char.
	 * @since 2.11
	 */	
	public static char println(char object) {
		System.out.println(object);
		return object;
	}

	/**
	 * Prints the given {@code boolean} to {@link System#out System.out} and terminate the line. Useful to log partial
	 * expressions to trap errors, e.g. the following is possible: <code>println(true && println(true)) || false</code>
	 * 
	 * @param object
	 *            the to-be-printed boolean
	 * @return the printed boolean.
	 * @since 2.11
	 */	
	public static boolean println(boolean object) {
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
	
	/**
	 * Prints the given {@code byte} to {@link System#out System.out}. Useful to log partial expressions to trap
	 * errors, e.g. the following is possible: <code>1 + print(2) + 3</code>
	 * 
	 * @param object
	 *            the to-be-printed byte
	 * @return the printed byte.
	 * @since 2.11
	 */
	public static byte print(byte object) {
		System.out.print(object);
		return object;
	}
	
	/**
	 * Prints the given {@code short} to {@link System#out System.out}. Useful to log partial expressions to trap
	 * errors, e.g. the following is possible: <code>1 + print(2) + 3</code>
	 * 
	 * @param object
	 *            the to-be-printed short
	 * @return the printed short.
	 * @since 2.11
	 */
	public static short print(short object) {
		System.out.print(object);
		return object;
	}
	
	/**
	 * Prints the given {@code int} to {@link System#out System.out}. Useful to log partial expressions to trap
	 * errors, e.g. the following is possible: <code>1 + print(2) + 3</code>
	 * 
	 * @param object
	 *            the to-be-printed int
	 * @return the printed int.
	 * @since 2.11
	 */
	public static int print(int object) {
		System.out.print(object);
		return object;
	}
	
	/**
	 * Prints the given {@code long} to {@link System#out System.out}. Useful to log partial expressions to trap
	 * errors, e.g. the following is possible: <code>1 + print(2) + 3</code>
	 * 
	 * @param object
	 *            the to-be-printed long
	 * @return the printed long.
	 * @since 2.11
	 */
	public static long print(long object) {
		System.out.print(object);
		return object;
	}
	
	/**
	 * Prints the given {@code float} to {@link System#out System.out}. Useful to log partial expressions to trap
	 * errors, e.g. the following is possible: <code>1.0f + print(2.0f) + 3.0f</code>
	 * 
	 * @param object
	 *            the to-be-printed float
	 * @return the printed float.
	 * @since 2.11
	 */
	public static float print(float object) {
		System.out.print(object);
		return object;
	}
	
	/**
	 * Prints the given {@code double} to {@link System#out System.out}. Useful to log partial expressions to trap
	 * errors, e.g. the following is possible: <code>1.0d + print(2.0d) + 3.0d</code>
	 * 
	 * @param object
	 *            the to-be-printed double
	 * @return the printed double.
	 * @since 2.11
	 */
	public static double print(double object) {
		System.out.print(object);
		return object;
	}
	
	/**
	 * Prints the given {@code char} to {@link System#out System.out}. Useful to log partial expressions to trap
	 * errors, e.g. the following is possible: <code>'a' + print('b') + 'c'</code>
	 * 
	 * @param object
	 *            the to-be-printed char
	 * @return the printed char.
	 * @since 2.11
	 */
	public static char print(char object) {
		System.out.print(object);
		return object;
	}
	
	/**
	 * Prints the given {@code boolean} to {@link System#out System.out}. Useful to log partial expressions to trap
	 * errors, e.g. the following is possible: <code>true && print(true) || false</code>
	 * 
	 * @param object
	 *            the to-be-printed boolean
	 * @return the printed boolean.
	 * @since 2.11
	 */
	public static boolean print(boolean object) {
		System.out.print(object);
		return object;
	}
}
