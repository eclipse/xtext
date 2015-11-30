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
 * This is an extension library for {@link Comparable comparables}.
 * 
 * @author Sven Efftinge - Initial contribution and API
 */
@GwtCompatible public class ComparableExtensions {

	/**
	 * The comparison operator <code>less than</code>.
	 * 
	 * @param left
	 *            a comparable
	 * @param right
	 *            the value to compare with
	 * @return <code>left.compareTo(right) < 0</code>
	 */
	@Pure /* not guaranteed, since compareTo() is invoked */
	@Inline("($1.compareTo($2) < 0)")
	public static <C> boolean operator_lessThan(Comparable<? super C> left, C right) {
		return left.compareTo(right) < 0;
	}

	/**
	 * The comparison operator <code>greater than</code>.
	 * 
	 * @param left
	 *            a comparable
	 * @param right
	 *            the value to compare with
	 * @return <code>left.compareTo(right) > 0</code>
	 */
	@Pure /* not guaranteed, since compareTo() is invoked */
	@Inline("($1.compareTo($2) > 0)")
	public static <C> boolean operator_greaterThan(Comparable<? super C> left, C right) {
		return left.compareTo(right) > 0;
	}

	/**
	 * The comparison operator <code>less than or equals</code>.
	 * 
	 * @param left
	 *            a comparable
	 * @param right
	 *            the value to compare with
	 * @return <code>left.compareTo(right) <= 0</code>
	 */
	@Pure /* not guaranteed, since compareTo() is invoked */
	@Inline("($1.compareTo($2) <= 0)")
	public static <C> boolean operator_lessEqualsThan(Comparable<? super C> left, C right) {
		return left.compareTo(right) <= 0;
	}

	/**
	 * The comparison operator <code>greater than or equals</code>.
	 * 
	 * @param left
	 *            a comparable
	 * @param right
	 *            the value to compare with
	 * @return <code>left.compareTo(right) >= 0</code>
	 */
	@Pure /* not guaranteed, since compareTo() is invoked */
	@Inline("($1.compareTo($2) >= 0)")
	public static <C> boolean operator_greaterEqualsThan(Comparable<? super C> left, C right) {
		return left.compareTo(right) >= 0;
	}
	
	/**
	 * The spaceship operator <code>&lt;=&gt;</code>.
	 * 
	 * @param left
	 *            a comparable
	 * @param right
	 *            the value to compare with
	 * @return <code>left.compareTo(right)</code>
	 * @since 2.4
	 */
	@Pure /* not guaranteed, since compareTo() is invoked */
	@Inline("($1.compareTo($2))")
	public static <C> int operator_spaceship(Comparable<? super C> left, C right) {
		return left.compareTo(right);
	}
}
