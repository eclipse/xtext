/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package test;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class ExtensionMethods {
	
	public static final String OPERATOR_MINUS_OBJECT_STRING = "operator_minus(Object,String)";
	public static final String OPERATOR_MINUS_STRING_STRING = "operator_minus(String,String)";
	public static final String OPERATOR_MINUS_STRING_CHARSEQUENCE = "operator_minus(String,Charsequence)";
	public static final String OPERATOR_MINUS_STRING_OBJECT = "operator_minus(String,Object)";

	public String operator_minus(String left, String right) {
		return OPERATOR_MINUS_STRING_STRING;
	}
	
	public String operator_minus(String left, CharSequence right) {
		return OPERATOR_MINUS_STRING_CHARSEQUENCE;
	}
	
	public String operator_minus(String left, Object right) {
		return OPERATOR_MINUS_STRING_OBJECT;
	}
	
	public String operator_minus(Object left, String right) {
		return OPERATOR_MINUS_OBJECT_STRING;
	}
	
	public static final String GENERIC_T = "generic(T)";
	public <T extends CharSequence> String generic(T t) {
		return GENERIC_T;
	}
	public static final String GENERIC_STRING = "generic(String)";
	public String generic(String t) {
		return GENERIC_STRING;
	}

	public static String staticExtension(String s) {
		return "static" + s;
	}

	public String instanceExtension(String s) {
		return "static" + s;
	}
}
