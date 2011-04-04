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
 * @author Sven Efftinge - Initial contribution and API
 */
public class FunctionExtensions {
	
	/**
	 * curries a one param function
	 */
	public static <P1,RESULT> Function0<RESULT> curry(final Function1<P1,RESULT> function, final P1 argument) {
		return new Function0<RESULT>() {
			public RESULT apply() {
				return function.apply(argument);
			}};
	}
	
	/**
	 * curries a two params function
	 */
	public static <P1,P2,RESULT> Function1<P2,RESULT> curry(final Function2<P1,P2,RESULT> function, final P1 argument) {
		return new Function1<P2,RESULT>() {
			public RESULT apply(P2 p) {
				return function.apply(argument, p);
			}};
	}
	
	/**
	 * curries a three params function
	 */
	public static <P1,P2,P3,RESULT> Function2<P2,P3,RESULT> curry(final Function3<P1,P2,P3,RESULT> function, final P1 argument) {
		return new Function2<P2,P3,RESULT>() {
			public RESULT apply(P2 p2, P3 p3) {
				return function.apply(argument, p2, p3);
			}};
	}
	
	/**
	 * curries a four params function
	 */
	public static <P1,P2,P3,P4,RESULT> Function3<P2,P3,P4,RESULT> curry(final Function4<P1,P2,P3,P4,RESULT> function, final P1 argument) {
		return new Function3<P2,P3,P4,RESULT>() {
			public RESULT apply(P2 p2,P3 p3,P4 p4) {
				return function.apply(argument, p2, p3, p4);
			}};
	}
	
	/**
	 * curries a five params function
	 */
	public static <P1,P2,P3,P4,P5,RESULT> Function4<P2,P3,P4,P5,RESULT> curry(final Function5<P1,P2,P3,P4,P5,RESULT> function, final P1 argument) {
		return new Function4<P2,P3,P4,P5,RESULT>() {
			public RESULT apply(P2 p2,P3 p3,P4 p4,P5 p5) {
				return function.apply(argument, p2, p3, p4,p5);
			}};
	}
	
	/**
	 * curries a six params function
	 */
	public static <P1,P2,P3,P4,P5,P6,RESULT> Function5<P2,P3,P4,P5,P6,RESULT> curry(final Function6<P1,P2,P3,P4,P5,P6,RESULT> function, final P1 argument) {
		return new Function5<P2,P3,P4,P5,P6,RESULT>() {
			public RESULT apply(P2 p2,P3 p3,P4 p4,P5 p5,P6 p6) {
				return function.apply(argument, p2, p3, p4,p5,p6);
			}};
	}
}
