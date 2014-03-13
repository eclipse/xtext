/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.lib;

import com.google.common.annotations.GwtCompatible;
import com.google.common.primitives.Booleans;


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
	@Inline(value="($1 && $2)", constantExpression=true)
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
	@Inline(value="($1 || $2)", constantExpression=true)
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
	@Inline(value="(!$1)", constantExpression=true)
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
	@Inline(value="($1 == $2)", constantExpression=true)
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
	@Inline(value="($1 != $2)", constantExpression=true)
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
	
	/**
	 * The binary <code>lessThan</code> operator for boolean values.
	 * {@code false} is considered less than {@code true}.
	 * 
	 * @see Boolean#compareTo(Boolean)
	 * @see Booleans#compare(boolean, boolean)
	 * @param a  a boolean.
	 * @param b  another boolean.
	 * @return   <code>Booleans.compare(a, b)&lt;0</code>
	 * @since 2.4
	 */
	@Pure
	@Inline(value = "($3.compare($1, $2) < 0)", imported = Booleans.class)
	public static boolean operator_lessThan(boolean a, boolean b) {
		return Booleans.compare(a, b) < 0;
	}
	
	/**
	 * The binary <code>lessEqualsThan</code> operator for boolean values.
	 * {@code false} is considered less than {@code true}.
	 * 
	 * @see Boolean#compareTo(Boolean)
	 * @see Booleans#compare(boolean, boolean)
	 * @param a  a boolean.
	 * @param b  another boolean.
	 * @return   <code>Booleans.compare(a, b)&lt;=0</code>
	 * @since 2.4
	 */
	@Pure
	@Inline(value = "($3.compare($1, $2) <= 0)", imported = Booleans.class)
	public static boolean operator_lessEqualsThan(boolean a, boolean b) {
		return Booleans.compare(a, b) <= 0;
	}
	
	/**
	 * The binary <code>greaterThan</code> operator for boolean values.
	 * {@code false} is considered less than {@code true}.
	 * 
	 * @see Boolean#compareTo(Boolean)
	 * @see Booleans#compare(boolean, boolean)
	 * @param a  a boolean.
	 * @param b  another boolean.
	 * @return   <code>Booleans.compare(a, b)&gt;0</code>
	 * @since 2.4
	 */
	@Pure
	@Inline(value = "($3.compare($1, $2) > 0)", imported = Booleans.class)
	public static boolean operator_greaterThan(boolean a, boolean b) {
		return Booleans.compare(a, b) > 0;
	}
	
	/**
	 * The binary <code>greaterEqualsThan</code> operator for boolean values.
	 * {@code false} is considered less than {@code true}.
	 * 
	 * @see Boolean#compareTo(Boolean)
	 * @see Booleans#compare(boolean, boolean)
	 * @param a  a boolean.
	 * @param b  another boolean.
	 * @return   <code>Booleans.compare(a, b)&gt;=0</code>
	 * @since 2.4
	 */
	@Pure
	@Inline(value = "($3.compare($1, $2) >= 0)", imported = Booleans.class)
	public static boolean operator_greaterEqualsThan(boolean a, boolean b) {
		return Booleans.compare(a, b) >= 0;
	}
}
