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
 * This is an extension library for {@link Boolean booleans}.
 * 
 * @author Sven Efftinge - Initial contribution and API
 */
@GwtCompatible public class BooleanExtensions {

	/**
	 * The logical <code>and</code> (conjunction). This is the equivalent to the java <code>&&</code> operator.
	 * 
	 * @param a
	 *            a boolean value.
	 * @param b
	 *            another boolean value.
	 * @return <code>a && b</code>
	 */
	@Pure
	@Inline("($1 && $2)")
	public static boolean operator_and(boolean a, boolean b) {
		return a && b;
	}

	/**
	 * A logical <code>or</code> (disjunction). This is the equivalent to the java <code>||</code> operator.
	 * 
	 * @param a
	 *            a boolean value.
	 * @param b
	 *            another boolean value.
	 * @return <code>a || b</code>
	 */
	@Pure
	@Inline("($1 || $2)")
	public static boolean operator_or(boolean a, boolean b) {
		return a || b;
	}

	/**
	 * The logical <code>not</code> (negation). This is the equivalent to the java <code>!</code> operator.
	 * 
	 * @param b
	 *            a boolean value.
	 * @return <code>!b</code>
	 */
	@Pure
	@Inline("(!$1)")
	public static boolean operator_not(boolean b) {
		return !b;
	}
	
	/**
	 * The binary <code>equals</code> operator. This is the equivalent to the java <code>==</code> operator.
	 * 
	 * @param a
	 *            an boolean.
	 * @param b
	 *            an boolean.
	 * @return <code>a==b</code>
	 */
	@Pure
	@Inline("($1 == $2)")
	public static boolean operator_equals(boolean a, boolean b) {
		return a == b;
	}

	/**
	 * The binary <code>not equals</code> operator. This is the equivalent to the java <code>!=</code> operator.
	 * 
	 * @param a
	 *            an boolean.
	 * @param b
	 *            an boolean.
	 * @return <code>a!=b</code>
	 */
	@Pure
	@Inline("($1 != $2)")
	public static boolean operator_notEquals(boolean a, boolean b) {
		return a != b;
	}

	/**
	 * A logical <code>xor</code>. This is the equivalent to the java <code>^</code> operator.
	 * 
	 * @param a
	 *            a boolean value.
	 * @param b
	 *            another boolean value.
	 * @return <code>a ^ b</code>
	 */
	@Pure
	@Inline("($1 ^ $2)")
	public static boolean xor(boolean a, boolean b) {
		return a ^ b;
	}


}
