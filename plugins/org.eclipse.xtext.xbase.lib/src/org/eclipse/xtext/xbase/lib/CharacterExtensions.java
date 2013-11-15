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
 * This is an extension library for {@link Character} numbers.
 * 
 * @author Jan Koehnlein - Code generator
 * @since 2.3
 */
@GwtCompatible public class CharacterExtensions {
	// BEGIN generated code
	/**
	 * The unary <code>minus</code> operator. This is the equivalent to the Java's <code>-</code> function.
	 * 
	 * @param a  a character.
	 * @return   <code>-a</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="(-$1)", constantExpression=true)
	public static int operator_minus(char a) {
		return -a;
	}
	
	/**
	 * The binary <code>plus</code> operator. This is the equivalent to the Java <code>+</code> operator.
	 * 
	 * @param a  a character.
	 * @param b  a double.
	 * @return   <code>a+b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 + $2)", constantExpression=true)
	public static double operator_plus(char a, double b) {
		return a + b;
	}
	
	/**
	 * The binary <code>minus</code> operator. This is the equivalent to the Java <code>-</code> operator.
	 * 
	 * @param a  a character.
	 * @param b  a double.
	 * @return   <code>a-b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 - $2)", constantExpression=true)
	public static double operator_minus(char a, double b) {
		return a - b;
	}
	
	/**
	 * The binary <code>multiply</code> operator. This is the equivalent to the Java <code>*</code> operator.
	 * 
	 * @param a  a character.
	 * @param b  a double.
	 * @return   <code>a*b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 * $2)", constantExpression=true)
	public static double operator_multiply(char a, double b) {
		return a * b;
	}
	
	/**
	 * The binary <code>divide</code> operator. This is the equivalent to the Java <code>/</code> operator.
	 * 
	 * @param a  a character.
	 * @param b  a double.
	 * @return   <code>a/b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 / $2)", constantExpression=true)
	public static double operator_divide(char a, double b) {
		return a / b;
	}
	
	/**
	 * The binary <code>modulo</code> operator. This is the equivalent to the Java <code>%</code> operator.
	 * 
	 * @param a  a character.
	 * @param b  a double.
	 * @return   <code>a%b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 % $2)", constantExpression=true)
	public static double operator_modulo(char a, double b) {
		return a % b;
	}
	
	/**
	 * The binary <code>lessThan</code> operator. This is the equivalent to the Java <code>&lt;</code> operator.
	 * 
	 * @param a  a character.
	 * @param b  a double.
	 * @return   <code>a&lt;b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 < $2)", constantExpression=true)
	public static boolean operator_lessThan(char a, double b) {
		return a < b;
	}
	
	/**
	 * The binary <code>lessEqualsThan</code> operator. This is the equivalent to the Java <code>&lt;=</code> operator.
	 * 
	 * @param a  a character.
	 * @param b  a double.
	 * @return   <code>a&lt;=b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 <= $2)", constantExpression=true)
	public static boolean operator_lessEqualsThan(char a, double b) {
		return a <= b;
	}
	
	/**
	 * The binary <code>greaterThan</code> operator. This is the equivalent to the Java <code>&gt;</code> operator.
	 * 
	 * @param a  a character.
	 * @param b  a double.
	 * @return   <code>a&gt;b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 > $2)", constantExpression=true)
	public static boolean operator_greaterThan(char a, double b) {
		return a > b;
	}
	
	/**
	 * The binary <code>greaterEqualsThan</code> operator. This is the equivalent to the Java <code>&gt;=</code> operator.
	 * 
	 * @param a  a character.
	 * @param b  a double.
	 * @return   <code>a&gt;=b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 >= $2)", constantExpression=true)
	public static boolean operator_greaterEqualsThan(char a, double b) {
		return a >= b;
	}
	
	/**
	 * The binary <code>equals</code> operator. This is the equivalent to the Java <code>==</code> operator.
	 * 
	 * @param a  a character.
	 * @param b  a double.
	 * @return   <code>a==b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 == $2)", constantExpression=true)
	public static boolean operator_equals(char a, double b) {
		return a == b;
	}
	
	/**
	 * The binary <code>notEquals</code> operator. This is the equivalent to the Java <code>!=</code> operator.
	 * 
	 * @param a  a character.
	 * @param b  a double.
	 * @return   <code>a!=b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 != $2)", constantExpression=true)
	public static boolean operator_notEquals(char a, double b) {
		return a != b;
	}
	
	/**
	 * The binary <code>power</code> operator. This is the equivalent to the Java's <code>Math.pow()</code> function.
	 * 
	 * @param a  a character.
	 * @param b  a double.
	 * @return   <code>Math.pow(a, b)</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="$3.pow($1, $2)", imported=Math.class)
	public static double operator_power(char a, double b) {
		return Math.pow(a, b);
	}
	
	/**
	 * The <code>identity equals</code> operator. This is the equivalent to Java's <code>==</code>
	 * operator.
	 * 
	 * @param a  a character.
	 * @param b  a double.
	 * @return   <code>a == b</code>
	 * @since 2.4
	 */
	@Pure
	@Inline(value="($1 == $2)", constantExpression=true)
	public static boolean operator_tripleEquals(char a, double b) {
		return a == b;
	}
	
	/**
	 * The <code>identity not equals</code> operator. This is the equivalent to Java's <code>!=</code>
	 * operator.
	 * 
	 * @param a  a character.
	 * @param b  a double.
	 * @return   <code>a != b</code>
	 * @since 2.4
	 */
	@Pure
	@Inline(value="($1 != $2)", constantExpression=true)
	public static boolean operator_tripleNotEquals(char a, double b) {
		return a != b;
	}
	
	/**
	 * The binary <code>plus</code> operator. This is the equivalent to the Java <code>+</code> operator.
	 * 
	 * @param a  a character.
	 * @param b  a float.
	 * @return   <code>a+b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 + $2)", constantExpression=true)
	public static float operator_plus(char a, float b) {
		return a + b;
	}
	
	/**
	 * The binary <code>minus</code> operator. This is the equivalent to the Java <code>-</code> operator.
	 * 
	 * @param a  a character.
	 * @param b  a float.
	 * @return   <code>a-b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 - $2)", constantExpression=true)
	public static float operator_minus(char a, float b) {
		return a - b;
	}
	
	/**
	 * The binary <code>multiply</code> operator. This is the equivalent to the Java <code>*</code> operator.
	 * 
	 * @param a  a character.
	 * @param b  a float.
	 * @return   <code>a*b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 * $2)", constantExpression=true)
	public static float operator_multiply(char a, float b) {
		return a * b;
	}
	
	/**
	 * The binary <code>divide</code> operator. This is the equivalent to the Java <code>/</code> operator.
	 * 
	 * @param a  a character.
	 * @param b  a float.
	 * @return   <code>a/b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 / $2)", constantExpression=true)
	public static float operator_divide(char a, float b) {
		return a / b;
	}
	
	/**
	 * The binary <code>modulo</code> operator. This is the equivalent to the Java <code>%</code> operator.
	 * 
	 * @param a  a character.
	 * @param b  a float.
	 * @return   <code>a%b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 % $2)", constantExpression=true)
	public static float operator_modulo(char a, float b) {
		return a % b;
	}
	
	/**
	 * The binary <code>lessThan</code> operator. This is the equivalent to the Java <code>&lt;</code> operator.
	 * 
	 * @param a  a character.
	 * @param b  a float.
	 * @return   <code>a&lt;b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 < $2)", constantExpression=true)
	public static boolean operator_lessThan(char a, float b) {
		return a < b;
	}
	
	/**
	 * The binary <code>lessEqualsThan</code> operator. This is the equivalent to the Java <code>&lt;=</code> operator.
	 * 
	 * @param a  a character.
	 * @param b  a float.
	 * @return   <code>a&lt;=b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 <= $2)", constantExpression=true)
	public static boolean operator_lessEqualsThan(char a, float b) {
		return a <= b;
	}
	
	/**
	 * The binary <code>greaterThan</code> operator. This is the equivalent to the Java <code>&gt;</code> operator.
	 * 
	 * @param a  a character.
	 * @param b  a float.
	 * @return   <code>a&gt;b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 > $2)", constantExpression=true)
	public static boolean operator_greaterThan(char a, float b) {
		return a > b;
	}
	
	/**
	 * The binary <code>greaterEqualsThan</code> operator. This is the equivalent to the Java <code>&gt;=</code> operator.
	 * 
	 * @param a  a character.
	 * @param b  a float.
	 * @return   <code>a&gt;=b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 >= $2)", constantExpression=true)
	public static boolean operator_greaterEqualsThan(char a, float b) {
		return a >= b;
	}
	
	/**
	 * The binary <code>equals</code> operator. This is the equivalent to the Java <code>==</code> operator.
	 * 
	 * @param a  a character.
	 * @param b  a float.
	 * @return   <code>a==b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 == $2)", constantExpression=true)
	public static boolean operator_equals(char a, float b) {
		return a == b;
	}
	
	/**
	 * The binary <code>notEquals</code> operator. This is the equivalent to the Java <code>!=</code> operator.
	 * 
	 * @param a  a character.
	 * @param b  a float.
	 * @return   <code>a!=b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 != $2)", constantExpression=true)
	public static boolean operator_notEquals(char a, float b) {
		return a != b;
	}
	
	/**
	 * The binary <code>power</code> operator. This is the equivalent to the Java's <code>Math.pow()</code> function.
	 * 
	 * @param a  a character.
	 * @param b  a float.
	 * @return   <code>Math.pow(a, b)</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="$3.pow($1, $2)", imported=Math.class)
	public static double operator_power(char a, float b) {
		return Math.pow(a, b);
	}
	
	/**
	 * The <code>identity equals</code> operator. This is the equivalent to Java's <code>==</code>
	 * operator.
	 * 
	 * @param a  a character.
	 * @param b  a float.
	 * @return   <code>a == b</code>
	 * @since 2.4
	 */
	@Pure
	@Inline(value="($1 == $2)", constantExpression=true)
	public static boolean operator_tripleEquals(char a, float b) {
		return a == b;
	}
	
	/**
	 * The <code>identity not equals</code> operator. This is the equivalent to Java's <code>!=</code>
	 * operator.
	 * 
	 * @param a  a character.
	 * @param b  a float.
	 * @return   <code>a != b</code>
	 * @since 2.4
	 */
	@Pure
	@Inline(value="($1 != $2)", constantExpression=true)
	public static boolean operator_tripleNotEquals(char a, float b) {
		return a != b;
	}
	
	/**
	 * The binary <code>plus</code> operator. This is the equivalent to the Java <code>+</code> operator.
	 * 
	 * @param a  a character.
	 * @param b  a long.
	 * @return   <code>a+b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 + $2)", constantExpression=true)
	public static long operator_plus(char a, long b) {
		return a + b;
	}
	
	/**
	 * The binary <code>minus</code> operator. This is the equivalent to the Java <code>-</code> operator.
	 * 
	 * @param a  a character.
	 * @param b  a long.
	 * @return   <code>a-b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 - $2)", constantExpression=true)
	public static long operator_minus(char a, long b) {
		return a - b;
	}
	
	/**
	 * The binary <code>multiply</code> operator. This is the equivalent to the Java <code>*</code> operator.
	 * 
	 * @param a  a character.
	 * @param b  a long.
	 * @return   <code>a*b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 * $2)", constantExpression=true)
	public static long operator_multiply(char a, long b) {
		return a * b;
	}
	
	/**
	 * The binary <code>divide</code> operator. This is the equivalent to the Java <code>/</code> operator.
	 * 
	 * @param a  a character.
	 * @param b  a long.
	 * @return   <code>a/b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 / $2)", constantExpression=true)
	public static long operator_divide(char a, long b) {
		return a / b;
	}
	
	/**
	 * The binary <code>modulo</code> operator. This is the equivalent to the Java <code>%</code> operator.
	 * 
	 * @param a  a character.
	 * @param b  a long.
	 * @return   <code>a%b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 % $2)", constantExpression=true)
	public static long operator_modulo(char a, long b) {
		return a % b;
	}
	
	/**
	 * The binary <code>lessThan</code> operator. This is the equivalent to the Java <code>&lt;</code> operator.
	 * 
	 * @param a  a character.
	 * @param b  a long.
	 * @return   <code>a&lt;b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 < $2)", constantExpression=true)
	public static boolean operator_lessThan(char a, long b) {
		return a < b;
	}
	
	/**
	 * The binary <code>lessEqualsThan</code> operator. This is the equivalent to the Java <code>&lt;=</code> operator.
	 * 
	 * @param a  a character.
	 * @param b  a long.
	 * @return   <code>a&lt;=b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 <= $2)", constantExpression=true)
	public static boolean operator_lessEqualsThan(char a, long b) {
		return a <= b;
	}
	
	/**
	 * The binary <code>greaterThan</code> operator. This is the equivalent to the Java <code>&gt;</code> operator.
	 * 
	 * @param a  a character.
	 * @param b  a long.
	 * @return   <code>a&gt;b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 > $2)", constantExpression=true)
	public static boolean operator_greaterThan(char a, long b) {
		return a > b;
	}
	
	/**
	 * The binary <code>greaterEqualsThan</code> operator. This is the equivalent to the Java <code>&gt;=</code> operator.
	 * 
	 * @param a  a character.
	 * @param b  a long.
	 * @return   <code>a&gt;=b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 >= $2)", constantExpression=true)
	public static boolean operator_greaterEqualsThan(char a, long b) {
		return a >= b;
	}
	
	/**
	 * The binary <code>equals</code> operator. This is the equivalent to the Java <code>==</code> operator.
	 * 
	 * @param a  a character.
	 * @param b  a long.
	 * @return   <code>a==b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 == $2)", constantExpression=true)
	public static boolean operator_equals(char a, long b) {
		return a == b;
	}
	
	/**
	 * The binary <code>notEquals</code> operator. This is the equivalent to the Java <code>!=</code> operator.
	 * 
	 * @param a  a character.
	 * @param b  a long.
	 * @return   <code>a!=b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 != $2)", constantExpression=true)
	public static boolean operator_notEquals(char a, long b) {
		return a != b;
	}
	
	/**
	 * The binary <code>power</code> operator. This is the equivalent to the Java's <code>Math.pow()</code> function.
	 * 
	 * @param a  a character.
	 * @param b  a long.
	 * @return   <code>Math.pow(a, b)</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="$3.pow($1, $2)", imported=Math.class)
	public static double operator_power(char a, long b) {
		return Math.pow(a, b);
	}
	
	/**
	 * The <code>identity equals</code> operator. This is the equivalent to Java's <code>==</code>
	 * operator.
	 * 
	 * @param a  a character.
	 * @param b  a long.
	 * @return   <code>a == b</code>
	 * @since 2.4
	 */
	@Pure
	@Inline(value="($1 == $2)", constantExpression=true)
	public static boolean operator_tripleEquals(char a, long b) {
		return a == b;
	}
	
	/**
	 * The <code>identity not equals</code> operator. This is the equivalent to Java's <code>!=</code>
	 * operator.
	 * 
	 * @param a  a character.
	 * @param b  a long.
	 * @return   <code>a != b</code>
	 * @since 2.4
	 */
	@Pure
	@Inline(value="($1 != $2)", constantExpression=true)
	public static boolean operator_tripleNotEquals(char a, long b) {
		return a != b;
	}
	
	/**
	 * The binary <code>plus</code> operator. This is the equivalent to the Java <code>+</code> operator.
	 * 
	 * @param a  a character.
	 * @param b  an integer.
	 * @return   <code>a+b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 + $2)", constantExpression=true)
	public static int operator_plus(char a, int b) {
		return a + b;
	}
	
	/**
	 * The binary <code>minus</code> operator. This is the equivalent to the Java <code>-</code> operator.
	 * 
	 * @param a  a character.
	 * @param b  an integer.
	 * @return   <code>a-b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 - $2)", constantExpression=true)
	public static int operator_minus(char a, int b) {
		return a - b;
	}
	
	/**
	 * The binary <code>multiply</code> operator. This is the equivalent to the Java <code>*</code> operator.
	 * 
	 * @param a  a character.
	 * @param b  an integer.
	 * @return   <code>a*b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 * $2)", constantExpression=true)
	public static int operator_multiply(char a, int b) {
		return a * b;
	}
	
	/**
	 * The binary <code>divide</code> operator. This is the equivalent to the Java <code>/</code> operator.
	 * 
	 * @param a  a character.
	 * @param b  an integer.
	 * @return   <code>a/b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 / $2)", constantExpression=true)
	public static int operator_divide(char a, int b) {
		return a / b;
	}
	
	/**
	 * The binary <code>modulo</code> operator. This is the equivalent to the Java <code>%</code> operator.
	 * 
	 * @param a  a character.
	 * @param b  an integer.
	 * @return   <code>a%b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 % $2)", constantExpression=true)
	public static int operator_modulo(char a, int b) {
		return a % b;
	}
	
	/**
	 * The binary <code>lessThan</code> operator. This is the equivalent to the Java <code>&lt;</code> operator.
	 * 
	 * @param a  a character.
	 * @param b  an integer.
	 * @return   <code>a&lt;b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 < $2)", constantExpression=true)
	public static boolean operator_lessThan(char a, int b) {
		return a < b;
	}
	
	/**
	 * The binary <code>lessEqualsThan</code> operator. This is the equivalent to the Java <code>&lt;=</code> operator.
	 * 
	 * @param a  a character.
	 * @param b  an integer.
	 * @return   <code>a&lt;=b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 <= $2)", constantExpression=true)
	public static boolean operator_lessEqualsThan(char a, int b) {
		return a <= b;
	}
	
	/**
	 * The binary <code>greaterThan</code> operator. This is the equivalent to the Java <code>&gt;</code> operator.
	 * 
	 * @param a  a character.
	 * @param b  an integer.
	 * @return   <code>a&gt;b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 > $2)", constantExpression=true)
	public static boolean operator_greaterThan(char a, int b) {
		return a > b;
	}
	
	/**
	 * The binary <code>greaterEqualsThan</code> operator. This is the equivalent to the Java <code>&gt;=</code> operator.
	 * 
	 * @param a  a character.
	 * @param b  an integer.
	 * @return   <code>a&gt;=b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 >= $2)", constantExpression=true)
	public static boolean operator_greaterEqualsThan(char a, int b) {
		return a >= b;
	}
	
	/**
	 * The binary <code>equals</code> operator. This is the equivalent to the Java <code>==</code> operator.
	 * 
	 * @param a  a character.
	 * @param b  an integer.
	 * @return   <code>a==b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 == $2)", constantExpression=true)
	public static boolean operator_equals(char a, int b) {
		return a == b;
	}
	
	/**
	 * The binary <code>notEquals</code> operator. This is the equivalent to the Java <code>!=</code> operator.
	 * 
	 * @param a  a character.
	 * @param b  an integer.
	 * @return   <code>a!=b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 != $2)", constantExpression=true)
	public static boolean operator_notEquals(char a, int b) {
		return a != b;
	}
	
	/**
	 * The binary <code>power</code> operator. This is the equivalent to the Java's <code>Math.pow()</code> function.
	 * 
	 * @param a  a character.
	 * @param b  an integer.
	 * @return   <code>Math.pow(a, b)</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="$3.pow($1, $2)", imported=Math.class)
	public static double operator_power(char a, int b) {
		return Math.pow(a, b);
	}
	
	/**
	 * The <code>identity equals</code> operator. This is the equivalent to Java's <code>==</code>
	 * operator.
	 * 
	 * @param a  a character.
	 * @param b  an integer.
	 * @return   <code>a == b</code>
	 * @since 2.4
	 */
	@Pure
	@Inline(value="($1 == $2)", constantExpression=true)
	public static boolean operator_tripleEquals(char a, int b) {
		return a == b;
	}
	
	/**
	 * The <code>identity not equals</code> operator. This is the equivalent to Java's <code>!=</code>
	 * operator.
	 * 
	 * @param a  a character.
	 * @param b  an integer.
	 * @return   <code>a != b</code>
	 * @since 2.4
	 */
	@Pure
	@Inline(value="($1 != $2)", constantExpression=true)
	public static boolean operator_tripleNotEquals(char a, int b) {
		return a != b;
	}
	
	/**
	 * The binary <code>plus</code> operator. This is the equivalent to the Java <code>+</code> operator.
	 * 
	 * @param a  a character.
	 * @param b  a character.
	 * @return   <code>a+b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 + $2)", constantExpression=true)
	public static int operator_plus(char a, char b) {
		return a + b;
	}
	
	/**
	 * The binary <code>minus</code> operator. This is the equivalent to the Java <code>-</code> operator.
	 * 
	 * @param a  a character.
	 * @param b  a character.
	 * @return   <code>a-b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 - $2)", constantExpression=true)
	public static int operator_minus(char a, char b) {
		return a - b;
	}
	
	/**
	 * The binary <code>multiply</code> operator. This is the equivalent to the Java <code>*</code> operator.
	 * 
	 * @param a  a character.
	 * @param b  a character.
	 * @return   <code>a*b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 * $2)", constantExpression=true)
	public static int operator_multiply(char a, char b) {
		return a * b;
	}
	
	/**
	 * The binary <code>divide</code> operator. This is the equivalent to the Java <code>/</code> operator.
	 * 
	 * @param a  a character.
	 * @param b  a character.
	 * @return   <code>a/b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 / $2)", constantExpression=true)
	public static int operator_divide(char a, char b) {
		return a / b;
	}
	
	/**
	 * The binary <code>modulo</code> operator. This is the equivalent to the Java <code>%</code> operator.
	 * 
	 * @param a  a character.
	 * @param b  a character.
	 * @return   <code>a%b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 % $2)", constantExpression=true)
	public static int operator_modulo(char a, char b) {
		return a % b;
	}
	
	/**
	 * The binary <code>lessThan</code> operator. This is the equivalent to the Java <code>&lt;</code> operator.
	 * 
	 * @param a  a character.
	 * @param b  a character.
	 * @return   <code>a&lt;b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 < $2)", constantExpression=true)
	public static boolean operator_lessThan(char a, char b) {
		return a < b;
	}
	
	/**
	 * The binary <code>lessEqualsThan</code> operator. This is the equivalent to the Java <code>&lt;=</code> operator.
	 * 
	 * @param a  a character.
	 * @param b  a character.
	 * @return   <code>a&lt;=b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 <= $2)", constantExpression=true)
	public static boolean operator_lessEqualsThan(char a, char b) {
		return a <= b;
	}
	
	/**
	 * The binary <code>greaterThan</code> operator. This is the equivalent to the Java <code>&gt;</code> operator.
	 * 
	 * @param a  a character.
	 * @param b  a character.
	 * @return   <code>a&gt;b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 > $2)", constantExpression=true)
	public static boolean operator_greaterThan(char a, char b) {
		return a > b;
	}
	
	/**
	 * The binary <code>greaterEqualsThan</code> operator. This is the equivalent to the Java <code>&gt;=</code> operator.
	 * 
	 * @param a  a character.
	 * @param b  a character.
	 * @return   <code>a&gt;=b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 >= $2)", constantExpression=true)
	public static boolean operator_greaterEqualsThan(char a, char b) {
		return a >= b;
	}
	
	/**
	 * The binary <code>equals</code> operator. This is the equivalent to the Java <code>==</code> operator.
	 * 
	 * @param a  a character.
	 * @param b  a character.
	 * @return   <code>a==b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 == $2)", constantExpression=true)
	public static boolean operator_equals(char a, char b) {
		return a == b;
	}
	
	/**
	 * The binary <code>notEquals</code> operator. This is the equivalent to the Java <code>!=</code> operator.
	 * 
	 * @param a  a character.
	 * @param b  a character.
	 * @return   <code>a!=b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 != $2)", constantExpression=true)
	public static boolean operator_notEquals(char a, char b) {
		return a != b;
	}
	
	/**
	 * The binary <code>power</code> operator. This is the equivalent to the Java's <code>Math.pow()</code> function.
	 * 
	 * @param a  a character.
	 * @param b  a character.
	 * @return   <code>Math.pow(a, b)</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="$3.pow($1, $2)", imported=Math.class)
	public static double operator_power(char a, char b) {
		return Math.pow(a, b);
	}
	
	/**
	 * The <code>identity equals</code> operator. This is the equivalent to Java's <code>==</code>
	 * operator.
	 * 
	 * @param a  a character.
	 * @param b  a character.
	 * @return   <code>a == b</code>
	 * @since 2.4
	 */
	@Pure
	@Inline(value="($1 == $2)", constantExpression=true)
	public static boolean operator_tripleEquals(char a, char b) {
		return a == b;
	}
	
	/**
	 * The <code>identity not equals</code> operator. This is the equivalent to Java's <code>!=</code>
	 * operator.
	 * 
	 * @param a  a character.
	 * @param b  a character.
	 * @return   <code>a != b</code>
	 * @since 2.4
	 */
	@Pure
	@Inline(value="($1 != $2)", constantExpression=true)
	public static boolean operator_tripleNotEquals(char a, char b) {
		return a != b;
	}
	
	/**
	 * The binary <code>plus</code> operator. This is the equivalent to the Java <code>+</code> operator.
	 * 
	 * @param a  a character.
	 * @param b  a short.
	 * @return   <code>a+b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 + $2)", constantExpression=true)
	public static int operator_plus(char a, short b) {
		return a + b;
	}
	
	/**
	 * The binary <code>minus</code> operator. This is the equivalent to the Java <code>-</code> operator.
	 * 
	 * @param a  a character.
	 * @param b  a short.
	 * @return   <code>a-b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 - $2)", constantExpression=true)
	public static int operator_minus(char a, short b) {
		return a - b;
	}
	
	/**
	 * The binary <code>multiply</code> operator. This is the equivalent to the Java <code>*</code> operator.
	 * 
	 * @param a  a character.
	 * @param b  a short.
	 * @return   <code>a*b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 * $2)", constantExpression=true)
	public static int operator_multiply(char a, short b) {
		return a * b;
	}
	
	/**
	 * The binary <code>divide</code> operator. This is the equivalent to the Java <code>/</code> operator.
	 * 
	 * @param a  a character.
	 * @param b  a short.
	 * @return   <code>a/b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 / $2)", constantExpression=true)
	public static int operator_divide(char a, short b) {
		return a / b;
	}
	
	/**
	 * The binary <code>modulo</code> operator. This is the equivalent to the Java <code>%</code> operator.
	 * 
	 * @param a  a character.
	 * @param b  a short.
	 * @return   <code>a%b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 % $2)", constantExpression=true)
	public static int operator_modulo(char a, short b) {
		return a % b;
	}
	
	/**
	 * The binary <code>lessThan</code> operator. This is the equivalent to the Java <code>&lt;</code> operator.
	 * 
	 * @param a  a character.
	 * @param b  a short.
	 * @return   <code>a&lt;b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 < $2)", constantExpression=true)
	public static boolean operator_lessThan(char a, short b) {
		return a < b;
	}
	
	/**
	 * The binary <code>lessEqualsThan</code> operator. This is the equivalent to the Java <code>&lt;=</code> operator.
	 * 
	 * @param a  a character.
	 * @param b  a short.
	 * @return   <code>a&lt;=b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 <= $2)", constantExpression=true)
	public static boolean operator_lessEqualsThan(char a, short b) {
		return a <= b;
	}
	
	/**
	 * The binary <code>greaterThan</code> operator. This is the equivalent to the Java <code>&gt;</code> operator.
	 * 
	 * @param a  a character.
	 * @param b  a short.
	 * @return   <code>a&gt;b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 > $2)", constantExpression=true)
	public static boolean operator_greaterThan(char a, short b) {
		return a > b;
	}
	
	/**
	 * The binary <code>greaterEqualsThan</code> operator. This is the equivalent to the Java <code>&gt;=</code> operator.
	 * 
	 * @param a  a character.
	 * @param b  a short.
	 * @return   <code>a&gt;=b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 >= $2)", constantExpression=true)
	public static boolean operator_greaterEqualsThan(char a, short b) {
		return a >= b;
	}
	
	/**
	 * The binary <code>equals</code> operator. This is the equivalent to the Java <code>==</code> operator.
	 * 
	 * @param a  a character.
	 * @param b  a short.
	 * @return   <code>a==b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 == $2)", constantExpression=true)
	public static boolean operator_equals(char a, short b) {
		return a == b;
	}
	
	/**
	 * The binary <code>notEquals</code> operator. This is the equivalent to the Java <code>!=</code> operator.
	 * 
	 * @param a  a character.
	 * @param b  a short.
	 * @return   <code>a!=b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 != $2)", constantExpression=true)
	public static boolean operator_notEquals(char a, short b) {
		return a != b;
	}
	
	/**
	 * The binary <code>power</code> operator. This is the equivalent to the Java's <code>Math.pow()</code> function.
	 * 
	 * @param a  a character.
	 * @param b  a short.
	 * @return   <code>Math.pow(a, b)</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="$3.pow($1, $2)", imported=Math.class)
	public static double operator_power(char a, short b) {
		return Math.pow(a, b);
	}
	
	/**
	 * The <code>identity equals</code> operator. This is the equivalent to Java's <code>==</code>
	 * operator.
	 * 
	 * @param a  a character.
	 * @param b  a short.
	 * @return   <code>a == b</code>
	 * @since 2.4
	 */
	@Pure
	@Inline(value="($1 == $2)", constantExpression=true)
	public static boolean operator_tripleEquals(char a, short b) {
		return a == b;
	}
	
	/**
	 * The <code>identity not equals</code> operator. This is the equivalent to Java's <code>!=</code>
	 * operator.
	 * 
	 * @param a  a character.
	 * @param b  a short.
	 * @return   <code>a != b</code>
	 * @since 2.4
	 */
	@Pure
	@Inline(value="($1 != $2)", constantExpression=true)
	public static boolean operator_tripleNotEquals(char a, short b) {
		return a != b;
	}
	
	/**
	 * The binary <code>plus</code> operator. This is the equivalent to the Java <code>+</code> operator.
	 * 
	 * @param a  a character.
	 * @param b  a byte.
	 * @return   <code>a+b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 + $2)", constantExpression=true)
	public static int operator_plus(char a, byte b) {
		return a + b;
	}
	
	/**
	 * The binary <code>minus</code> operator. This is the equivalent to the Java <code>-</code> operator.
	 * 
	 * @param a  a character.
	 * @param b  a byte.
	 * @return   <code>a-b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 - $2)", constantExpression=true)
	public static int operator_minus(char a, byte b) {
		return a - b;
	}
	
	/**
	 * The binary <code>multiply</code> operator. This is the equivalent to the Java <code>*</code> operator.
	 * 
	 * @param a  a character.
	 * @param b  a byte.
	 * @return   <code>a*b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 * $2)", constantExpression=true)
	public static int operator_multiply(char a, byte b) {
		return a * b;
	}
	
	/**
	 * The binary <code>divide</code> operator. This is the equivalent to the Java <code>/</code> operator.
	 * 
	 * @param a  a character.
	 * @param b  a byte.
	 * @return   <code>a/b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 / $2)", constantExpression=true)
	public static int operator_divide(char a, byte b) {
		return a / b;
	}
	
	/**
	 * The binary <code>modulo</code> operator. This is the equivalent to the Java <code>%</code> operator.
	 * 
	 * @param a  a character.
	 * @param b  a byte.
	 * @return   <code>a%b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 % $2)", constantExpression=true)
	public static int operator_modulo(char a, byte b) {
		return a % b;
	}
	
	/**
	 * The binary <code>lessThan</code> operator. This is the equivalent to the Java <code>&lt;</code> operator.
	 * 
	 * @param a  a character.
	 * @param b  a byte.
	 * @return   <code>a&lt;b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 < $2)", constantExpression=true)
	public static boolean operator_lessThan(char a, byte b) {
		return a < b;
	}
	
	/**
	 * The binary <code>lessEqualsThan</code> operator. This is the equivalent to the Java <code>&lt;=</code> operator.
	 * 
	 * @param a  a character.
	 * @param b  a byte.
	 * @return   <code>a&lt;=b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 <= $2)", constantExpression=true)
	public static boolean operator_lessEqualsThan(char a, byte b) {
		return a <= b;
	}
	
	/**
	 * The binary <code>greaterThan</code> operator. This is the equivalent to the Java <code>&gt;</code> operator.
	 * 
	 * @param a  a character.
	 * @param b  a byte.
	 * @return   <code>a&gt;b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 > $2)", constantExpression=true)
	public static boolean operator_greaterThan(char a, byte b) {
		return a > b;
	}
	
	/**
	 * The binary <code>greaterEqualsThan</code> operator. This is the equivalent to the Java <code>&gt;=</code> operator.
	 * 
	 * @param a  a character.
	 * @param b  a byte.
	 * @return   <code>a&gt;=b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 >= $2)", constantExpression=true)
	public static boolean operator_greaterEqualsThan(char a, byte b) {
		return a >= b;
	}
	
	/**
	 * The binary <code>equals</code> operator. This is the equivalent to the Java <code>==</code> operator.
	 * 
	 * @param a  a character.
	 * @param b  a byte.
	 * @return   <code>a==b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 == $2)", constantExpression=true)
	public static boolean operator_equals(char a, byte b) {
		return a == b;
	}
	
	/**
	 * The binary <code>notEquals</code> operator. This is the equivalent to the Java <code>!=</code> operator.
	 * 
	 * @param a  a character.
	 * @param b  a byte.
	 * @return   <code>a!=b</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="($1 != $2)", constantExpression=true)
	public static boolean operator_notEquals(char a, byte b) {
		return a != b;
	}
	
	/**
	 * The binary <code>power</code> operator. This is the equivalent to the Java's <code>Math.pow()</code> function.
	 * 
	 * @param a  a character.
	 * @param b  a byte.
	 * @return   <code>Math.pow(a, b)</code>
	 * @since 2.3
	 */
	@Pure
	@Inline(value="$3.pow($1, $2)", imported=Math.class)
	public static double operator_power(char a, byte b) {
		return Math.pow(a, b);
	}
	
	/**
	 * The <code>identity equals</code> operator. This is the equivalent to Java's <code>==</code>
	 * operator.
	 * 
	 * @param a  a character.
	 * @param b  a byte.
	 * @return   <code>a == b</code>
	 * @since 2.4
	 */
	@Pure
	@Inline(value="($1 == $2)", constantExpression=true)
	public static boolean operator_tripleEquals(char a, byte b) {
		return a == b;
	}
	
	/**
	 * The <code>identity not equals</code> operator. This is the equivalent to Java's <code>!=</code>
	 * operator.
	 * 
	 * @param a  a character.
	 * @param b  a byte.
	 * @return   <code>a != b</code>
	 * @since 2.4
	 */
	@Pure
	@Inline(value="($1 != $2)", constantExpression=true)
	public static boolean operator_tripleNotEquals(char a, byte b) {
		return a != b;
	}
	
	// END generated code

















}
