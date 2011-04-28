/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.lib;

import org.eclipse.xtext.xbase.lib.Functions.*;

/**
 * This is an extension library for {@link Functions functions}, e.g. closures.
 * 
 * @author Sven Efftinge - Initial contribution and API
 * @see Functions
 */
public class FunctionExtensions {
	
	/**
	 * Curries a function that takes one argument.
	 * @param function the original function. May not be <code>null</code>.
	 * @param argument the fixed argument. 
	 * @return a function that takes no arguments. Never <code>null</code>.
	 */
	public static <P1,RESULT> Function0<RESULT> curry(final Function1<P1,RESULT> function, final P1 argument) {
		if (function == null)
			throw new NullPointerException("function");
		return new Function0<RESULT>() {
			public RESULT apply() {
				return function.apply(argument);
			}};
	}
	
	/**
	 * Curries a function that takes two arguments.
	 * @param function the original function. May not be <code>null</code>.
	 * @param argument the fixed first argument of {@code function}. 
	 * @return a function that takes one argument. Never <code>null</code>.
	 */
	public static <P1,P2,RESULT> Function1<P2,RESULT> curry(final Function2<P1,P2,RESULT> function, final P1 argument) {
		if (function == null)
			throw new NullPointerException("function");
		return new Function1<P2,RESULT>() {
			public RESULT apply(P2 p) {
				return function.apply(argument, p);
			}};
	}
	
	/**
	 * Curries a function that takes three arguments.
	 * @param function the original function. May not be <code>null</code>.
	 * @param argument the fixed first argument of {@code function}. 
	 * @return a function that takes two arguments. Never <code>null</code>.
	 */
	public static <P1,P2,P3,RESULT> Function2<P2,P3,RESULT> curry(final Function3<P1,P2,P3,RESULT> function, final P1 argument) {
		if (function == null)
			throw new NullPointerException("function");
		return new Function2<P2,P3,RESULT>() {
			public RESULT apply(P2 p2, P3 p3) {
				return function.apply(argument, p2, p3);
			}};
	}
	
	/**
	 * Curries a function that takes four arguments.
	 * @param function the original function. May not be <code>null</code>.
	 * @param argument the fixed first argument of {@code function}. 
	 * @return a function that takes three arguments. Never <code>null</code>.
	 */
	public static <P1,P2,P3,P4,RESULT> Function3<P2,P3,P4,RESULT> curry(final Function4<P1,P2,P3,P4,RESULT> function, final P1 argument) {
		if (function == null)
			throw new NullPointerException("function");
		return new Function3<P2,P3,P4,RESULT>() {
			public RESULT apply(P2 p2,P3 p3,P4 p4) {
				return function.apply(argument, p2, p3, p4);
			}};
	}
	
	/**
	 * Curries a function that takes five arguments.
	 * @param function the original function. May not be <code>null</code>.
	 * @param argument the fixed first argument of {@code function}. 
	 * @return a function that takes four arguments. Never <code>null</code>.
	 */
	public static <P1,P2,P3,P4,P5,RESULT> Function4<P2,P3,P4,P5,RESULT> curry(final Function5<P1,P2,P3,P4,P5,RESULT> function, final P1 argument) {
		if (function == null)
			throw new NullPointerException("function");
		return new Function4<P2,P3,P4,P5,RESULT>() {
			public RESULT apply(P2 p2,P3 p3,P4 p4,P5 p5) {
				return function.apply(argument, p2, p3, p4,p5);
			}};
	}
	
	/**
	 * Curries a function that takes six arguments.
	 * @param function the original function. May not be <code>null</code>.
	 * @param argument the fixed first argument of {@code function}. 
	 * @return a function that takes five arguments. Never <code>null</code>.
	 */
	public static <P1,P2,P3,P4,P5,P6,RESULT> Function5<P2,P3,P4,P5,P6,RESULT> curry(final Function6<P1,P2,P3,P4,P5,P6,RESULT> function, final P1 argument) {
		if (function == null)
			throw new NullPointerException("function");
		return new Function5<P2,P3,P4,P5,P6,RESULT>() {
			public RESULT apply(P2 p2,P3 p3,P4 p4,P5 p5,P6 p6) {
				return function.apply(argument, p2, p3, p4,p5,p6);
			}};
	}
}
