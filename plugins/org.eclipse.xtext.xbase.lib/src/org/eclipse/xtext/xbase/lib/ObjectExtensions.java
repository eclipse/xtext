/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.lib;


public class ObjectExtensions {
	
	public static boolean operator_notEquals(Object a, Object b) {
		return !operator_equals(a, b);
	}
	
	public static boolean operator_equals(Object a, Object b) {
		if (a==b)
			return true;
		if (a==null)
			return false;
		return a.equals(b);
	}
	
	public static <A,B> Pair<A,B> operator_mappedTo(A a, B b) {
		return new Pair<A,B>(a,b);
	}
	
}
