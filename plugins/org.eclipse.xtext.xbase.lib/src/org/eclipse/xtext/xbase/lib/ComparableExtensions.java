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
public class ComparableExtensions {
	
	public static <C> boolean operator_lessThan(Comparable<? super C> left, C right) {
		return left.compareTo(right)<0;
	}

	public static <C> boolean operator_greaterThan(Comparable<? super C> left, C right) {
		return left.compareTo(right)>0;
	}

	public static <C> boolean operator_lessEqualsThan(Comparable<? super C> left, C right) {
		return left.compareTo(right)<=0;
	}

	public static <C> boolean operator_greaterEqualsThan(Comparable<? super C> left, C right) {
		return left.compareTo(right)>=0;
	}
}
