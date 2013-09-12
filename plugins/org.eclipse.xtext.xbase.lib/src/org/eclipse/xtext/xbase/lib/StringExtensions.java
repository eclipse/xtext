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
 * This is an extension library for {@link String strings}.
 * 
 * @author Sven Efftinge - Initial contribution and API
 */
@GwtCompatible public class StringExtensions {

	/**
	 * The binary <code>+</code> operator that concatenates a string and the string
	 * reprentation of an object.
	 * 
	 * @param a
	 *            a string.
	 * @param b
	 *            an object.
	 * @return <code>a + b</code>
	 */
	@Pure /* not guaranteed, since toString() is invoked */
	@Inline("($1 + $2)")
	public static String operator_plus(String a, Object b) {
		return a + b;
	}
	
	/**
	 * The binary <code>+</code> operator that concatenates two strings.
	 * 
	 * @param a
	 *            a string.
	 * @param b
	 *            another string.
	 * @return <code>a + b</code>
	 * 
	 * @since 2.5
	 */
	@Pure /* not guaranteed, since toString() is invoked */
	@Inline("($1 + $2)")
	public static String operator_plus(String a, String b) {
		return a + b;
	}

	/**
	 * Returns <code>true</code> if {@code s} is <code>null</code> or equal to the empty {@link String} <code>""</code>.
	 * 
	 * @param s
	 *            the string
	 * @return <code>true</code> if {@code s} is <code>null</code> or equal to the empty {@link String} <code>""</code>
	 */
	@Pure
	public static boolean isNullOrEmpty(String s) {
		return s == null || s.length() == 0;
	}

	/**
	 * Returns the {@link String} {@code s} with an {@link Character#isUpperCase(char) upper case} first character. This
	 * function is null-safe.
	 * 
	 * @param s
	 *            the string that should get an upper case first character. May be <code>null</code>.
	 * @return the {@link String} {@code s} with an upper case first character or <code>null</code> if the input
	 *         {@link String} {@code s} was <code>null</code>.
	 */
	@Pure
	public static String toFirstUpper(String s) {
		if (s == null || s.length() == 0)
			return s;
		if (Character.isUpperCase(s.charAt(0)))
			return s;
		if (s.length() == 1)
			return s.toUpperCase();
		return s.substring(0, 1).toUpperCase() + s.substring(1);
	}

	/**
	 * Returns the {@link String} {@code s} with an {@link Character#isLowerCase(char) lower case} first character. This
	 * function is null-safe.
	 * 
	 * @param s
	 *            the string that should get an lower case first character. May be <code>null</code>.
	 * @return the {@link String} {@code s} with an lower case first character or <code>null</code> if the input
	 *         {@link String} {@code s} was <code>null</code>.
	 */
	@Pure
	public static String toFirstLower(String s) {
		if (s == null || s.length() == 0)
			return s;
		if (Character.isLowerCase(s.charAt(0)))
			return s;
		if (s.length() == 1)
			return s.toLowerCase();
		return s.substring(0, 1).toLowerCase() + s.substring(1);
	}
}
