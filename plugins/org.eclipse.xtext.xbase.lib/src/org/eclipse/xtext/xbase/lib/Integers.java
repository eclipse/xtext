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
public class Integers {

	// TODO: Linking for unary minus operator
	public static int _operator_minus(Integer a) {
		return -a;
	}
	
	public static int _operator_plus(Integer a, Number b) {
		return a+b.intValue();
	}
	
	public static int _operator_minus(Integer a, Number b) {
		return a-b.intValue();
	}
	
	public static int _operator_multiply(Integer a, Number b) {
		return a*b.intValue();
	}
	
	public static int _operator_divide(Integer a, Number b) {
		return a/b.intValue();
	}
	
	public static int _operator_modulo(Integer a, Number b) {
		return a%b.intValue();
	}
	
	public static int _operator_power(Integer a, Number b) {
		return (int) Math.pow(a, b.intValue());
	}
	
}
