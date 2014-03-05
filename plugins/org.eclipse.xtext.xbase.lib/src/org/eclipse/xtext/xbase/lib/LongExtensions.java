/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.lib;

import com.google.common.annotations.GwtCompatible;


/**
 * This is an extension library for {@link Long} numbers.
 * 
 * @author Jan Koehnlein - Code generator
 * @since 2.3
 */
@GwtCompatible public class LongExtensions {
	
	/**
	 * The bitwise inclusive <code>or</code> operation. This is the equivalent to the java <code>|</code> operator.
	 * 
	 * @param a
	 *            a long.
	 * @param b
	 *            a long
	 * @return <code>a|b</code>
	 */
	@Pure
	@Inline("($1 | $2)")
	public static long bitwiseOr(long a, long b) {
		return a | b;
	}

	/**
	 * The bitwise exclusive <code>or</code> operation. This is the equivalent to the java <code>^</code> operator.
	 * 
	 * @param a
	 *            a long.
	 * @param b
	 *            a long.
	 * @return <code>a^b</code>
	 */
	@Pure
	@Inline("($1 ^ $2)")
	public static long bitwiseXor(long a, long b) {
		return a ^ b;
	}

	/**
	 * The bitwise <code>and</code> operation. This is the equivalent to the java <code>&</code> operator.
	 * 
	 * @param a
	 *            a long.
	 * @param b
	 *            a long.
	 * @return <code>a&b</code>
	 */
	@Pure
	@Inline("($1 & $2)")
	public static long bitwiseAnd(long a, long b) {
		return a & b;
	}

	/**
	 * The bitwise complement operation. This is the equivalent to the java <code>~</code> operator.
	 * 
	 * @param a
	 *            a long.
	 * @return the bitwise complement of <code>a</code>.
	 */
	@Pure
	@Inline("(~$1)")
	public static long bitwiseNot(long a) {
		return ~a;
	}

	/**
	 * The binary <code>signed left shift</code> operator. This is the equivalent to the java <code>&lt;&lt;</code> operator.
	 * Fills in a zero as the least significant bit.
	 * 
	 * @param a
	 *            a long.
	 * @param distance 
	 *            the number of times to shift.
	 * @return <code>a&lt;&lt;distance</code>
	 * @deprecated use {@link #operator_doubleLessThan(long, int)} instead.
	 */
	@Deprecated
	@Pure
	@Inline("($1 << $2)")
	public static long shiftLeft(long a, int distance) {
		return a << distance;
	}

	/**
	 * The binary <code>signed left shift</code> operator. This is the equivalent to the java <code>&lt;&lt;</code> operator.
	 * Fills in a zero as the least significant bit.
	 * 
	 * @param a
	 *            a long.
	 * @param distance 
	 *            the number of times to shift.
	 * @return <code>a&lt;&lt;distance</code>
	 */
	@Pure
	@Inline("($1 << $2)")
	public static long operator_doubleLessThan(long a, int distance) {
		return a << distance;
	}

	/**
	 * The binary <code>signed right sift</code> operator. This is the equivalent to the java <code>&gt;&gt;</code> operator.
	 * Shifts in the value of the sign bit as the leftmost bit, thus preserving the sign of the initial value.
	 * 
	 * @param a
	 *            a long.
	 * @param distance 
	 *            the number of times to shift.
	 * @return <code>a&gt;&gt;distance</code>
	 * @deprecated use {@link #operator_doubleGreaterThan(long, int)} instead.
	 */
	@Deprecated
	@Pure
	@Inline("($1 >> $2)")
	public static long shiftRight(long a, int distance) {
		return a >> distance;
	}

	/**
	 * The binary <code>signed right sift</code> operator. This is the equivalent to the java <code>&gt;&gt;</code> operator.
	 * Shifts in the value of the sign bit as the leftmost bit, thus preserving the sign of the initial value.
	 * 
	 * @param a
	 *            a long.
	 * @param distance 
	 *            the number of times to shift.
	 * @return <code>a&gt;&gt;distance</code>
	 */
	@Pure
	@Inline("($1 >> $2)")
	public static long operator_doubleGreaterThan(long a, int distance) {
		return a >> distance;
	}

	/**
	 * The binary <code>unsigned right shift</code> operator. This is the equivalent to the java <code>&gt;&gt;&gt;</code> operator.
	 * Shifts in zeros into as leftmost bits, thus always yielding a positive integer.
	 * 
	 * @param a
	 *            a long.
	 * @param distance
	 *            the number of times to shift.
	 * @return <code>a&gt;&gt;&gt;distance</code>
	 * @deprecated use {@link #operator_tripleGreaterThan(long, int)} instead.
	 */
	@Deprecated
	@Pure
	@Inline("($1 >>> $2)")
	public static long shiftRightUnsigned(long a, int distance) {
		return a >>> distance;
	}

	/**
	 * The binary <code>unsigned right shift</code> operator. This is the equivalent to the java <code>&gt;&gt;&gt;</code> operator.
	 * Shifts in zeros into as leftmost bits, thus always yielding a positive integer.
	 * 
	 * @param a
	 *            a long.
	 * @param distance
	 *            the number of times to shift.
	 * @return <code>a&gt;&gt;&gt;distance</code>
	 */
	@Pure
	@Inline("($1 >>> $2)")
	public static long operator_tripleGreaterThan(long a, int distance) {
		return a >>> distance;
	}

	// BEGIN generated code
	/**
	 * The unary <code>minus</code> operator. This is the equivalent to the Java's <code>-</code> function.
	 * 
	 * @param a  a long.
	 * @return   <code>-a</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="(-$1)", constantExpression=true)
	public static long operator_minus(long a) {
		return -a;
	}
	
	/**
	 * The unary <code>decrement</code> operator. This is the equivalent to the Java's <code>--</code> postfix function.
	 * 
	 * @param a  a long.
	 * @return   <code>a--</code>
	 * @since 2.6
	 */
	@Inline(value="$1--")
	public static long operator_minusMinus(long a) {
		return a--;
	}
	
	/**
	 * The unary <code>decrement</code> operator. This is the equivalent to the Java's <code>--</code> postfix function.
	 * 
	 * @param a  a long.
	 * @return   <code>a--</code>
	 * @since 2.6
	 */
	@Inline(value="$1--")
	public static long operator_minusMinus(Long a) {
		return a--;
	}
	
	/**
	 * The unary <code>increment</code> operator. This is the equivalent to the Java's <code>++</code> postfix function.
	 * 
	 * @param a  a long.
	 * @return   <code>a++</code>
	 * @since 2.6
	 */
	@Inline(value="$1++")
	public static long operator_plusPlus(long a) {
		return a++;
	}
	
	/**
	 * The unary <code>increment</code> operator. This is the equivalent to the Java's <code>++</code> postfix function.
	 * 
	 * @param a  a long.
	 * @return   <code>a++</code>
	 * @since 2.6
	 */
	@Inline(value="$1++")
	public static long operator_plusPlus(Long a) {
		return a++;
	}
	
	/**
	 * The binary <code>plus</code> operator. This is the equivalent to the Java <code>+</code> operator.
	 * 
	 * @param a  a long.
	 * @param b  a double.
	 * @return   <code>a+b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 + $2)", constantExpression=true)
	public static double operator_plus(long a, double b) {
		return a + b;
	}
	
	/**
	 * The binary <code>minus</code> operator. This is the equivalent to the Java <code>-</code> operator.
	 * 
	 * @param a  a long.
	 * @param b  a double.
	 * @return   <code>a-b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 - $2)", constantExpression=true)
	public static double operator_minus(long a, double b) {
		return a - b;
	}
	
	/**
	 * The binary <code>multiply</code> operator. This is the equivalent to the Java <code>*</code> operator.
	 * 
	 * @param a  a long.
	 * @param b  a double.
	 * @return   <code>a*b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 * $2)", constantExpression=true)
	public static double operator_multiply(long a, double b) {
		return a * b;
	}
	
	/**
	 * The binary <code>divide</code> operator. This is the equivalent to the Java <code>/</code> operator.
	 * 
	 * @param a  a long.
	 * @param b  a double.
	 * @return   <code>a/b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 / $2)", constantExpression=true)
	public static double operator_divide(long a, double b) {
		return a / b;
	}
	
	/**
	 * The binary <code>modulo</code> operator. This is the equivalent to the Java <code>%</code> operator.
	 * 
	 * @param a  a long.
	 * @param b  a double.
	 * @return   <code>a%b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 % $2)", constantExpression=true)
	public static double operator_modulo(long a, double b) {
		return a % b;
	}
	
	/**
	 * The binary <code>lessThan</code> operator. This is the equivalent to the Java <code>&lt;</code> operator.
	 * 
	 * @param a  a long.
	 * @param b  a double.
	 * @return   <code>a&lt;b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 < $2)", constantExpression=true)
	public static boolean operator_lessThan(long a, double b) {
		return a < b;
	}
	
	/**
	 * The binary <code>lessEqualsThan</code> operator. This is the equivalent to the Java <code>&lt;=</code> operator.
	 * 
	 * @param a  a long.
	 * @param b  a double.
	 * @return   <code>a&lt;=b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 <= $2)", constantExpression=true)
	public static boolean operator_lessEqualsThan(long a, double b) {
		return a <= b;
	}
	
	/**
	 * The binary <code>greaterThan</code> operator. This is the equivalent to the Java <code>&gt;</code> operator.
	 * 
	 * @param a  a long.
	 * @param b  a double.
	 * @return   <code>a&gt;b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 > $2)", constantExpression=true)
	public static boolean operator_greaterThan(long a, double b) {
		return a > b;
	}
	
	/**
	 * The binary <code>greaterEqualsThan</code> operator. This is the equivalent to the Java <code>&gt;=</code> operator.
	 * 
	 * @param a  a long.
	 * @param b  a double.
	 * @return   <code>a&gt;=b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 >= $2)", constantExpression=true)
	public static boolean operator_greaterEqualsThan(long a, double b) {
		return a >= b;
	}
	
	/**
	 * The binary <code>equals</code> operator. This is the equivalent to the Java <code>==</code> operator.
	 * 
	 * @param a  a long.
	 * @param b  a double.
	 * @return   <code>a==b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 == $2)", constantExpression=true)
	public static boolean operator_equals(long a, double b) {
		return a == b;
	}
	
	/**
	 * The binary <code>notEquals</code> operator. This is the equivalent to the Java <code>!=</code> operator.
	 * 
	 * @param a  a long.
	 * @param b  a double.
	 * @return   <code>a!=b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 != $2)", constantExpression=true)
	public static boolean operator_notEquals(long a, double b) {
		return a != b;
	}
	
	/**
	 * The binary <code>power</code> operator. This is the equivalent to the Java's <code>Math.pow()</code> function.
	 * 
	 * @param a  a long.
	 * @param b  a double.
	 * @return   <code>Math.pow(a, b)</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="$3.pow($1, $2)", imported=Math.class)
	public static double operator_power(long a, double b) {
		return Math.pow(a, b);
	}
	
	/**
	 * The <code>identity equals</code> operator. This is the equivalent to Java's <code>==</code>
	 * operator.
	 * 
	 * @param a  a long.
	 * @param b  a double.
	 * @return   <code>a == b</code>
	 * @since 2.4
	 */
	@Pure
	@Inline(value="($1 == $2)", constantExpression=true)
	public static boolean operator_tripleEquals(long a, double b) {
		return a == b;
	}
	
	/**
	 * The <code>identity not equals</code> operator. This is the equivalent to Java's <code>!=</code>
	 * operator.
	 * 
	 * @param a  a long.
	 * @param b  a double.
	 * @return   <code>a != b</code>
	 * @since 2.4
	 */
	@Pure
	@Inline(value="($1 != $2)", constantExpression=true)
	public static boolean operator_tripleNotEquals(long a, double b) {
		return a != b;
	}
	
	/**
	 * The binary <code>plus</code> operator. This is the equivalent to the Java <code>+</code> operator.
	 * 
	 * @param a  a long.
	 * @param b  a float.
	 * @return   <code>a+b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 + $2)", constantExpression=true)
	public static float operator_plus(long a, float b) {
		return a + b;
	}
	
	/**
	 * The binary <code>minus</code> operator. This is the equivalent to the Java <code>-</code> operator.
	 * 
	 * @param a  a long.
	 * @param b  a float.
	 * @return   <code>a-b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 - $2)", constantExpression=true)
	public static float operator_minus(long a, float b) {
		return a - b;
	}
	
	/**
	 * The binary <code>multiply</code> operator. This is the equivalent to the Java <code>*</code> operator.
	 * 
	 * @param a  a long.
	 * @param b  a float.
	 * @return   <code>a*b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 * $2)", constantExpression=true)
	public static float operator_multiply(long a, float b) {
		return a * b;
	}
	
	/**
	 * The binary <code>divide</code> operator. This is the equivalent to the Java <code>/</code> operator.
	 * 
	 * @param a  a long.
	 * @param b  a float.
	 * @return   <code>a/b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 / $2)", constantExpression=true)
	public static float operator_divide(long a, float b) {
		return a / b;
	}
	
	/**
	 * The binary <code>modulo</code> operator. This is the equivalent to the Java <code>%</code> operator.
	 * 
	 * @param a  a long.
	 * @param b  a float.
	 * @return   <code>a%b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 % $2)", constantExpression=true)
	public static float operator_modulo(long a, float b) {
		return a % b;
	}
	
	/**
	 * The binary <code>lessThan</code> operator. This is the equivalent to the Java <code>&lt;</code> operator.
	 * 
	 * @param a  a long.
	 * @param b  a float.
	 * @return   <code>a&lt;b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 < $2)", constantExpression=true)
	public static boolean operator_lessThan(long a, float b) {
		return a < b;
	}
	
	/**
	 * The binary <code>lessEqualsThan</code> operator. This is the equivalent to the Java <code>&lt;=</code> operator.
	 * 
	 * @param a  a long.
	 * @param b  a float.
	 * @return   <code>a&lt;=b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 <= $2)", constantExpression=true)
	public static boolean operator_lessEqualsThan(long a, float b) {
		return a <= b;
	}
	
	/**
	 * The binary <code>greaterThan</code> operator. This is the equivalent to the Java <code>&gt;</code> operator.
	 * 
	 * @param a  a long.
	 * @param b  a float.
	 * @return   <code>a&gt;b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 > $2)", constantExpression=true)
	public static boolean operator_greaterThan(long a, float b) {
		return a > b;
	}
	
	/**
	 * The binary <code>greaterEqualsThan</code> operator. This is the equivalent to the Java <code>&gt;=</code> operator.
	 * 
	 * @param a  a long.
	 * @param b  a float.
	 * @return   <code>a&gt;=b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 >= $2)", constantExpression=true)
	public static boolean operator_greaterEqualsThan(long a, float b) {
		return a >= b;
	}
	
	/**
	 * The binary <code>equals</code> operator. This is the equivalent to the Java <code>==</code> operator.
	 * 
	 * @param a  a long.
	 * @param b  a float.
	 * @return   <code>a==b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 == $2)", constantExpression=true)
	public static boolean operator_equals(long a, float b) {
		return a == b;
	}
	
	/**
	 * The binary <code>notEquals</code> operator. This is the equivalent to the Java <code>!=</code> operator.
	 * 
	 * @param a  a long.
	 * @param b  a float.
	 * @return   <code>a!=b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 != $2)", constantExpression=true)
	public static boolean operator_notEquals(long a, float b) {
		return a != b;
	}
	
	/**
	 * The binary <code>power</code> operator. This is the equivalent to the Java's <code>Math.pow()</code> function.
	 * 
	 * @param a  a long.
	 * @param b  a float.
	 * @return   <code>Math.pow(a, b)</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="$3.pow($1, $2)", imported=Math.class)
	public static double operator_power(long a, float b) {
		return Math.pow(a, b);
	}
	
	/**
	 * The <code>identity equals</code> operator. This is the equivalent to Java's <code>==</code>
	 * operator.
	 * 
	 * @param a  a long.
	 * @param b  a float.
	 * @return   <code>a == b</code>
	 * @since 2.4
	 */
	@Pure
	@Inline(value="($1 == $2)", constantExpression=true)
	public static boolean operator_tripleEquals(long a, float b) {
		return a == b;
	}
	
	/**
	 * The <code>identity not equals</code> operator. This is the equivalent to Java's <code>!=</code>
	 * operator.
	 * 
	 * @param a  a long.
	 * @param b  a float.
	 * @return   <code>a != b</code>
	 * @since 2.4
	 */
	@Pure
	@Inline(value="($1 != $2)", constantExpression=true)
	public static boolean operator_tripleNotEquals(long a, float b) {
		return a != b;
	}
	
	/**
	 * The binary <code>plus</code> operator. This is the equivalent to the Java <code>+</code> operator.
	 * 
	 * @param a  a long.
	 * @param b  a long.
	 * @return   <code>a+b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 + $2)", constantExpression=true)
	public static long operator_plus(long a, long b) {
		return a + b;
	}
	
	/**
	 * The binary <code>minus</code> operator. This is the equivalent to the Java <code>-</code> operator.
	 * 
	 * @param a  a long.
	 * @param b  a long.
	 * @return   <code>a-b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 - $2)", constantExpression=true)
	public static long operator_minus(long a, long b) {
		return a - b;
	}
	
	/**
	 * The binary <code>multiply</code> operator. This is the equivalent to the Java <code>*</code> operator.
	 * 
	 * @param a  a long.
	 * @param b  a long.
	 * @return   <code>a*b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 * $2)", constantExpression=true)
	public static long operator_multiply(long a, long b) {
		return a * b;
	}
	
	/**
	 * The binary <code>divide</code> operator. This is the equivalent to the Java <code>/</code> operator.
	 * 
	 * @param a  a long.
	 * @param b  a long.
	 * @return   <code>a/b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 / $2)", constantExpression=true)
	public static long operator_divide(long a, long b) {
		return a / b;
	}
	
	/**
	 * The binary <code>modulo</code> operator. This is the equivalent to the Java <code>%</code> operator.
	 * 
	 * @param a  a long.
	 * @param b  a long.
	 * @return   <code>a%b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 % $2)", constantExpression=true)
	public static long operator_modulo(long a, long b) {
		return a % b;
	}
	
	/**
	 * The binary <code>lessThan</code> operator. This is the equivalent to the Java <code>&lt;</code> operator.
	 * 
	 * @param a  a long.
	 * @param b  a long.
	 * @return   <code>a&lt;b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 < $2)", constantExpression=true)
	public static boolean operator_lessThan(long a, long b) {
		return a < b;
	}
	
	/**
	 * The binary <code>lessEqualsThan</code> operator. This is the equivalent to the Java <code>&lt;=</code> operator.
	 * 
	 * @param a  a long.
	 * @param b  a long.
	 * @return   <code>a&lt;=b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 <= $2)", constantExpression=true)
	public static boolean operator_lessEqualsThan(long a, long b) {
		return a <= b;
	}
	
	/**
	 * The binary <code>greaterThan</code> operator. This is the equivalent to the Java <code>&gt;</code> operator.
	 * 
	 * @param a  a long.
	 * @param b  a long.
	 * @return   <code>a&gt;b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 > $2)", constantExpression=true)
	public static boolean operator_greaterThan(long a, long b) {
		return a > b;
	}
	
	/**
	 * The binary <code>greaterEqualsThan</code> operator. This is the equivalent to the Java <code>&gt;=</code> operator.
	 * 
	 * @param a  a long.
	 * @param b  a long.
	 * @return   <code>a&gt;=b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 >= $2)", constantExpression=true)
	public static boolean operator_greaterEqualsThan(long a, long b) {
		return a >= b;
	}
	
	/**
	 * The binary <code>equals</code> operator. This is the equivalent to the Java <code>==</code> operator.
	 * 
	 * @param a  a long.
	 * @param b  a long.
	 * @return   <code>a==b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 == $2)", constantExpression=true)
	public static boolean operator_equals(long a, long b) {
		return a == b;
	}
	
	/**
	 * The binary <code>notEquals</code> operator. This is the equivalent to the Java <code>!=</code> operator.
	 * 
	 * @param a  a long.
	 * @param b  a long.
	 * @return   <code>a!=b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 != $2)", constantExpression=true)
	public static boolean operator_notEquals(long a, long b) {
		return a != b;
	}
	
	/**
	 * The binary <code>power</code> operator. This is the equivalent to the Java's <code>Math.pow()</code> function.
	 * 
	 * @param a  a long.
	 * @param b  a long.
	 * @return   <code>Math.pow(a, b)</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="$3.pow($1, $2)", imported=Math.class)
	public static double operator_power(long a, long b) {
		return Math.pow(a, b);
	}
	
	/**
	 * The <code>identity equals</code> operator. This is the equivalent to Java's <code>==</code>
	 * operator.
	 * 
	 * @param a  a long.
	 * @param b  a long.
	 * @return   <code>a == b</code>
	 * @since 2.4
	 */
	@Pure
	@Inline(value="($1 == $2)", constantExpression=true)
	public static boolean operator_tripleEquals(long a, long b) {
		return a == b;
	}
	
	/**
	 * The <code>identity not equals</code> operator. This is the equivalent to Java's <code>!=</code>
	 * operator.
	 * 
	 * @param a  a long.
	 * @param b  a long.
	 * @return   <code>a != b</code>
	 * @since 2.4
	 */
	@Pure
	@Inline(value="($1 != $2)", constantExpression=true)
	public static boolean operator_tripleNotEquals(long a, long b) {
		return a != b;
	}
	
	/**
	 * The binary <code>plus</code> operator. This is the equivalent to the Java <code>+</code> operator.
	 * 
	 * @param a  a long.
	 * @param b  an integer.
	 * @return   <code>a+b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 + $2)", constantExpression=true)
	public static long operator_plus(long a, int b) {
		return a + b;
	}
	
	/**
	 * The binary <code>minus</code> operator. This is the equivalent to the Java <code>-</code> operator.
	 * 
	 * @param a  a long.
	 * @param b  an integer.
	 * @return   <code>a-b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 - $2)", constantExpression=true)
	public static long operator_minus(long a, int b) {
		return a - b;
	}
	
	/**
	 * The binary <code>multiply</code> operator. This is the equivalent to the Java <code>*</code> operator.
	 * 
	 * @param a  a long.
	 * @param b  an integer.
	 * @return   <code>a*b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 * $2)", constantExpression=true)
	public static long operator_multiply(long a, int b) {
		return a * b;
	}
	
	/**
	 * The binary <code>divide</code> operator. This is the equivalent to the Java <code>/</code> operator.
	 * 
	 * @param a  a long.
	 * @param b  an integer.
	 * @return   <code>a/b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 / $2)", constantExpression=true)
	public static long operator_divide(long a, int b) {
		return a / b;
	}
	
	/**
	 * The binary <code>modulo</code> operator. This is the equivalent to the Java <code>%</code> operator.
	 * 
	 * @param a  a long.
	 * @param b  an integer.
	 * @return   <code>a%b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 % $2)", constantExpression=true)
	public static long operator_modulo(long a, int b) {
		return a % b;
	}
	
	/**
	 * The binary <code>lessThan</code> operator. This is the equivalent to the Java <code>&lt;</code> operator.
	 * 
	 * @param a  a long.
	 * @param b  an integer.
	 * @return   <code>a&lt;b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 < $2)", constantExpression=true)
	public static boolean operator_lessThan(long a, int b) {
		return a < b;
	}
	
	/**
	 * The binary <code>lessEqualsThan</code> operator. This is the equivalent to the Java <code>&lt;=</code> operator.
	 * 
	 * @param a  a long.
	 * @param b  an integer.
	 * @return   <code>a&lt;=b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 <= $2)", constantExpression=true)
	public static boolean operator_lessEqualsThan(long a, int b) {
		return a <= b;
	}
	
	/**
	 * The binary <code>greaterThan</code> operator. This is the equivalent to the Java <code>&gt;</code> operator.
	 * 
	 * @param a  a long.
	 * @param b  an integer.
	 * @return   <code>a&gt;b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 > $2)", constantExpression=true)
	public static boolean operator_greaterThan(long a, int b) {
		return a > b;
	}
	
	/**
	 * The binary <code>greaterEqualsThan</code> operator. This is the equivalent to the Java <code>&gt;=</code> operator.
	 * 
	 * @param a  a long.
	 * @param b  an integer.
	 * @return   <code>a&gt;=b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 >= $2)", constantExpression=true)
	public static boolean operator_greaterEqualsThan(long a, int b) {
		return a >= b;
	}
	
	/**
	 * The binary <code>equals</code> operator. This is the equivalent to the Java <code>==</code> operator.
	 * 
	 * @param a  a long.
	 * @param b  an integer.
	 * @return   <code>a==b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 == $2)", constantExpression=true)
	public static boolean operator_equals(long a, int b) {
		return a == b;
	}
	
	/**
	 * The binary <code>notEquals</code> operator. This is the equivalent to the Java <code>!=</code> operator.
	 * 
	 * @param a  a long.
	 * @param b  an integer.
	 * @return   <code>a!=b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 != $2)", constantExpression=true)
	public static boolean operator_notEquals(long a, int b) {
		return a != b;
	}
	
	/**
	 * The binary <code>power</code> operator. This is the equivalent to the Java's <code>Math.pow()</code> function.
	 * 
	 * @param a  a long.
	 * @param b  an integer.
	 * @return   <code>Math.pow(a, b)</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="$3.pow($1, $2)", imported=Math.class)
	public static double operator_power(long a, int b) {
		return Math.pow(a, b);
	}
	
	/**
	 * The <code>identity equals</code> operator. This is the equivalent to Java's <code>==</code>
	 * operator.
	 * 
	 * @param a  a long.
	 * @param b  an integer.
	 * @return   <code>a == b</code>
	 * @since 2.4
	 */
	@Pure
	@Inline(value="($1 == $2)", constantExpression=true)
	public static boolean operator_tripleEquals(long a, int b) {
		return a == b;
	}
	
	/**
	 * The <code>identity not equals</code> operator. This is the equivalent to Java's <code>!=</code>
	 * operator.
	 * 
	 * @param a  a long.
	 * @param b  an integer.
	 * @return   <code>a != b</code>
	 * @since 2.4
	 */
	@Pure
	@Inline(value="($1 != $2)", constantExpression=true)
	public static boolean operator_tripleNotEquals(long a, int b) {
		return a != b;
	}
	
	/**
	 * The binary <code>plus</code> operator. This is the equivalent to the Java <code>+</code> operator.
	 * 
	 * @param a  a long.
	 * @param b  a character.
	 * @return   <code>a+b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 + $2)", constantExpression=true)
	public static long operator_plus(long a, char b) {
		return a + b;
	}
	
	/**
	 * The binary <code>minus</code> operator. This is the equivalent to the Java <code>-</code> operator.
	 * 
	 * @param a  a long.
	 * @param b  a character.
	 * @return   <code>a-b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 - $2)", constantExpression=true)
	public static long operator_minus(long a, char b) {
		return a - b;
	}
	
	/**
	 * The binary <code>multiply</code> operator. This is the equivalent to the Java <code>*</code> operator.
	 * 
	 * @param a  a long.
	 * @param b  a character.
	 * @return   <code>a*b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 * $2)", constantExpression=true)
	public static long operator_multiply(long a, char b) {
		return a * b;
	}
	
	/**
	 * The binary <code>divide</code> operator. This is the equivalent to the Java <code>/</code> operator.
	 * 
	 * @param a  a long.
	 * @param b  a character.
	 * @return   <code>a/b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 / $2)", constantExpression=true)
	public static long operator_divide(long a, char b) {
		return a / b;
	}
	
	/**
	 * The binary <code>modulo</code> operator. This is the equivalent to the Java <code>%</code> operator.
	 * 
	 * @param a  a long.
	 * @param b  a character.
	 * @return   <code>a%b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 % $2)", constantExpression=true)
	public static long operator_modulo(long a, char b) {
		return a % b;
	}
	
	/**
	 * The binary <code>lessThan</code> operator. This is the equivalent to the Java <code>&lt;</code> operator.
	 * 
	 * @param a  a long.
	 * @param b  a character.
	 * @return   <code>a&lt;b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 < $2)", constantExpression=true)
	public static boolean operator_lessThan(long a, char b) {
		return a < b;
	}
	
	/**
	 * The binary <code>lessEqualsThan</code> operator. This is the equivalent to the Java <code>&lt;=</code> operator.
	 * 
	 * @param a  a long.
	 * @param b  a character.
	 * @return   <code>a&lt;=b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 <= $2)", constantExpression=true)
	public static boolean operator_lessEqualsThan(long a, char b) {
		return a <= b;
	}
	
	/**
	 * The binary <code>greaterThan</code> operator. This is the equivalent to the Java <code>&gt;</code> operator.
	 * 
	 * @param a  a long.
	 * @param b  a character.
	 * @return   <code>a&gt;b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 > $2)", constantExpression=true)
	public static boolean operator_greaterThan(long a, char b) {
		return a > b;
	}
	
	/**
	 * The binary <code>greaterEqualsThan</code> operator. This is the equivalent to the Java <code>&gt;=</code> operator.
	 * 
	 * @param a  a long.
	 * @param b  a character.
	 * @return   <code>a&gt;=b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 >= $2)", constantExpression=true)
	public static boolean operator_greaterEqualsThan(long a, char b) {
		return a >= b;
	}
	
	/**
	 * The binary <code>equals</code> operator. This is the equivalent to the Java <code>==</code> operator.
	 * 
	 * @param a  a long.
	 * @param b  a character.
	 * @return   <code>a==b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 == $2)", constantExpression=true)
	public static boolean operator_equals(long a, char b) {
		return a == b;
	}
	
	/**
	 * The binary <code>notEquals</code> operator. This is the equivalent to the Java <code>!=</code> operator.
	 * 
	 * @param a  a long.
	 * @param b  a character.
	 * @return   <code>a!=b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 != $2)", constantExpression=true)
	public static boolean operator_notEquals(long a, char b) {
		return a != b;
	}
	
	/**
	 * The binary <code>power</code> operator. This is the equivalent to the Java's <code>Math.pow()</code> function.
	 * 
	 * @param a  a long.
	 * @param b  a character.
	 * @return   <code>Math.pow(a, b)</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="$3.pow($1, $2)", imported=Math.class)
	public static double operator_power(long a, char b) {
		return Math.pow(a, b);
	}
	
	/**
	 * The <code>identity equals</code> operator. This is the equivalent to Java's <code>==</code>
	 * operator.
	 * 
	 * @param a  a long.
	 * @param b  a character.
	 * @return   <code>a == b</code>
	 * @since 2.4
	 */
	@Pure
	@Inline(value="($1 == $2)", constantExpression=true)
	public static boolean operator_tripleEquals(long a, char b) {
		return a == b;
	}
	
	/**
	 * The <code>identity not equals</code> operator. This is the equivalent to Java's <code>!=</code>
	 * operator.
	 * 
	 * @param a  a long.
	 * @param b  a character.
	 * @return   <code>a != b</code>
	 * @since 2.4
	 */
	@Pure
	@Inline(value="($1 != $2)", constantExpression=true)
	public static boolean operator_tripleNotEquals(long a, char b) {
		return a != b;
	}
	
	/**
	 * The binary <code>plus</code> operator. This is the equivalent to the Java <code>+</code> operator.
	 * 
	 * @param a  a long.
	 * @param b  a short.
	 * @return   <code>a+b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 + $2)", constantExpression=true)
	public static long operator_plus(long a, short b) {
		return a + b;
	}
	
	/**
	 * The binary <code>minus</code> operator. This is the equivalent to the Java <code>-</code> operator.
	 * 
	 * @param a  a long.
	 * @param b  a short.
	 * @return   <code>a-b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 - $2)", constantExpression=true)
	public static long operator_minus(long a, short b) {
		return a - b;
	}
	
	/**
	 * The binary <code>multiply</code> operator. This is the equivalent to the Java <code>*</code> operator.
	 * 
	 * @param a  a long.
	 * @param b  a short.
	 * @return   <code>a*b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 * $2)", constantExpression=true)
	public static long operator_multiply(long a, short b) {
		return a * b;
	}
	
	/**
	 * The binary <code>divide</code> operator. This is the equivalent to the Java <code>/</code> operator.
	 * 
	 * @param a  a long.
	 * @param b  a short.
	 * @return   <code>a/b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 / $2)", constantExpression=true)
	public static long operator_divide(long a, short b) {
		return a / b;
	}
	
	/**
	 * The binary <code>modulo</code> operator. This is the equivalent to the Java <code>%</code> operator.
	 * 
	 * @param a  a long.
	 * @param b  a short.
	 * @return   <code>a%b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 % $2)", constantExpression=true)
	public static long operator_modulo(long a, short b) {
		return a % b;
	}
	
	/**
	 * The binary <code>lessThan</code> operator. This is the equivalent to the Java <code>&lt;</code> operator.
	 * 
	 * @param a  a long.
	 * @param b  a short.
	 * @return   <code>a&lt;b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 < $2)", constantExpression=true)
	public static boolean operator_lessThan(long a, short b) {
		return a < b;
	}
	
	/**
	 * The binary <code>lessEqualsThan</code> operator. This is the equivalent to the Java <code>&lt;=</code> operator.
	 * 
	 * @param a  a long.
	 * @param b  a short.
	 * @return   <code>a&lt;=b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 <= $2)", constantExpression=true)
	public static boolean operator_lessEqualsThan(long a, short b) {
		return a <= b;
	}
	
	/**
	 * The binary <code>greaterThan</code> operator. This is the equivalent to the Java <code>&gt;</code> operator.
	 * 
	 * @param a  a long.
	 * @param b  a short.
	 * @return   <code>a&gt;b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 > $2)", constantExpression=true)
	public static boolean operator_greaterThan(long a, short b) {
		return a > b;
	}
	
	/**
	 * The binary <code>greaterEqualsThan</code> operator. This is the equivalent to the Java <code>&gt;=</code> operator.
	 * 
	 * @param a  a long.
	 * @param b  a short.
	 * @return   <code>a&gt;=b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 >= $2)", constantExpression=true)
	public static boolean operator_greaterEqualsThan(long a, short b) {
		return a >= b;
	}
	
	/**
	 * The binary <code>equals</code> operator. This is the equivalent to the Java <code>==</code> operator.
	 * 
	 * @param a  a long.
	 * @param b  a short.
	 * @return   <code>a==b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 == $2)", constantExpression=true)
	public static boolean operator_equals(long a, short b) {
		return a == b;
	}
	
	/**
	 * The binary <code>notEquals</code> operator. This is the equivalent to the Java <code>!=</code> operator.
	 * 
	 * @param a  a long.
	 * @param b  a short.
	 * @return   <code>a!=b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 != $2)", constantExpression=true)
	public static boolean operator_notEquals(long a, short b) {
		return a != b;
	}
	
	/**
	 * The binary <code>power</code> operator. This is the equivalent to the Java's <code>Math.pow()</code> function.
	 * 
	 * @param a  a long.
	 * @param b  a short.
	 * @return   <code>Math.pow(a, b)</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="$3.pow($1, $2)", imported=Math.class)
	public static double operator_power(long a, short b) {
		return Math.pow(a, b);
	}
	
	/**
	 * The <code>identity equals</code> operator. This is the equivalent to Java's <code>==</code>
	 * operator.
	 * 
	 * @param a  a long.
	 * @param b  a short.
	 * @return   <code>a == b</code>
	 * @since 2.4
	 */
	@Pure
	@Inline(value="($1 == $2)", constantExpression=true)
	public static boolean operator_tripleEquals(long a, short b) {
		return a == b;
	}
	
	/**
	 * The <code>identity not equals</code> operator. This is the equivalent to Java's <code>!=</code>
	 * operator.
	 * 
	 * @param a  a long.
	 * @param b  a short.
	 * @return   <code>a != b</code>
	 * @since 2.4
	 */
	@Pure
	@Inline(value="($1 != $2)", constantExpression=true)
	public static boolean operator_tripleNotEquals(long a, short b) {
		return a != b;
	}
	
	/**
	 * The binary <code>plus</code> operator. This is the equivalent to the Java <code>+</code> operator.
	 * 
	 * @param a  a long.
	 * @param b  a byte.
	 * @return   <code>a+b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 + $2)", constantExpression=true)
	public static long operator_plus(long a, byte b) {
		return a + b;
	}
	
	/**
	 * The binary <code>minus</code> operator. This is the equivalent to the Java <code>-</code> operator.
	 * 
	 * @param a  a long.
	 * @param b  a byte.
	 * @return   <code>a-b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 - $2)", constantExpression=true)
	public static long operator_minus(long a, byte b) {
		return a - b;
	}
	
	/**
	 * The binary <code>multiply</code> operator. This is the equivalent to the Java <code>*</code> operator.
	 * 
	 * @param a  a long.
	 * @param b  a byte.
	 * @return   <code>a*b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 * $2)", constantExpression=true)
	public static long operator_multiply(long a, byte b) {
		return a * b;
	}
	
	/**
	 * The binary <code>divide</code> operator. This is the equivalent to the Java <code>/</code> operator.
	 * 
	 * @param a  a long.
	 * @param b  a byte.
	 * @return   <code>a/b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 / $2)", constantExpression=true)
	public static long operator_divide(long a, byte b) {
		return a / b;
	}
	
	/**
	 * The binary <code>modulo</code> operator. This is the equivalent to the Java <code>%</code> operator.
	 * 
	 * @param a  a long.
	 * @param b  a byte.
	 * @return   <code>a%b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 % $2)", constantExpression=true)
	public static long operator_modulo(long a, byte b) {
		return a % b;
	}
	
	/**
	 * The binary <code>lessThan</code> operator. This is the equivalent to the Java <code>&lt;</code> operator.
	 * 
	 * @param a  a long.
	 * @param b  a byte.
	 * @return   <code>a&lt;b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 < $2)", constantExpression=true)
	public static boolean operator_lessThan(long a, byte b) {
		return a < b;
	}
	
	/**
	 * The binary <code>lessEqualsThan</code> operator. This is the equivalent to the Java <code>&lt;=</code> operator.
	 * 
	 * @param a  a long.
	 * @param b  a byte.
	 * @return   <code>a&lt;=b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 <= $2)", constantExpression=true)
	public static boolean operator_lessEqualsThan(long a, byte b) {
		return a <= b;
	}
	
	/**
	 * The binary <code>greaterThan</code> operator. This is the equivalent to the Java <code>&gt;</code> operator.
	 * 
	 * @param a  a long.
	 * @param b  a byte.
	 * @return   <code>a&gt;b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 > $2)", constantExpression=true)
	public static boolean operator_greaterThan(long a, byte b) {
		return a > b;
	}
	
	/**
	 * The binary <code>greaterEqualsThan</code> operator. This is the equivalent to the Java <code>&gt;=</code> operator.
	 * 
	 * @param a  a long.
	 * @param b  a byte.
	 * @return   <code>a&gt;=b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 >= $2)", constantExpression=true)
	public static boolean operator_greaterEqualsThan(long a, byte b) {
		return a >= b;
	}
	
	/**
	 * The binary <code>equals</code> operator. This is the equivalent to the Java <code>==</code> operator.
	 * 
	 * @param a  a long.
	 * @param b  a byte.
	 * @return   <code>a==b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 == $2)", constantExpression=true)
	public static boolean operator_equals(long a, byte b) {
		return a == b;
	}
	
	/**
	 * The binary <code>notEquals</code> operator. This is the equivalent to the Java <code>!=</code> operator.
	 * 
	 * @param a  a long.
	 * @param b  a byte.
	 * @return   <code>a!=b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 != $2)", constantExpression=true)
	public static boolean operator_notEquals(long a, byte b) {
		return a != b;
	}
	
	/**
	 * The binary <code>power</code> operator. This is the equivalent to the Java's <code>Math.pow()</code> function.
	 * 
	 * @param a  a long.
	 * @param b  a byte.
	 * @return   <code>Math.pow(a, b)</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="$3.pow($1, $2)", imported=Math.class)
	public static double operator_power(long a, byte b) {
		return Math.pow(a, b);
	}
	
	/**
	 * The <code>identity equals</code> operator. This is the equivalent to Java's <code>==</code>
	 * operator.
	 * 
	 * @param a  a long.
	 * @param b  a byte.
	 * @return   <code>a == b</code>
	 * @since 2.4
	 */
	@Pure
	@Inline(value="($1 == $2)", constantExpression=true)
	public static boolean operator_tripleEquals(long a, byte b) {
		return a == b;
	}
	
	/**
	 * The <code>identity not equals</code> operator. This is the equivalent to Java's <code>!=</code>
	 * operator.
	 * 
	 * @param a  a long.
	 * @param b  a byte.
	 * @return   <code>a != b</code>
	 * @since 2.4
	 */
	@Pure
	@Inline(value="($1 != $2)", constantExpression=true)
	public static boolean operator_tripleNotEquals(long a, byte b) {
		return a != b;
	}
	
	// END generated code

















}
