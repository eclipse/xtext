/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.lib;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class StringExtensions {
	
	/**
	 * concatenation operator
	 */
	public static String operator_plus(String a, Object b) {
		return a+b;
	}
	
	public static boolean isNullOrEmpty(String s) {
		return s == null || s.equals("");
	}
	
	public static String toFirstUpper(String s) {
		if (s == null || s.length() == 0)
			return s;
		if (Character.isUpperCase(s.charAt(0)))
			return s;
		if (s.length() == 1)
			return s.toUpperCase();
		return s.substring(0, 1).toUpperCase() + s.substring(1);
	}

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
