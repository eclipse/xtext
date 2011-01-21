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
public class Comparables {
	
	public static <A extends Comparable<B>, B> boolean _operator_lessThan(A a, B b) {
		return a.compareTo(b)<0;
	}

	public static <A extends Comparable<B>, B> boolean _operator_greaterThan(A a, B b) {
		return a.compareTo(b)>0;
	}

	public static <A extends Comparable<B>, B> boolean _operator_lessEqualsThan(A a, B b) {
		return a.compareTo(b)<=0;
	}

	public static <A extends Comparable<B>, B> boolean _operator_greaterEqualsThan(A a, B b) {
		return a.compareTo(b)>=0;
	}
}
