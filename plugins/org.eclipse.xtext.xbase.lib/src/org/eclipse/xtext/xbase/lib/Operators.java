package org.eclipse.xtext.xbase.lib;

import java.util.Collection;

public class Operators {
	
	public static int _operator_plus(int a, int b) {
		return a+b;
	}

	public static int _operator_minus(int a, int b) {
		return a-b;
	}

	public static int _operator_multiply(int a, int b) {
		return a*b;
	}

	public static int _operator_divide(int a, int b) {
		return a/b;
	}

	public static int _operator_modulo(int a, int b) {
		return a%b;
	}

	public static int _operator_power(int a, int b) {
		return (int) Math.pow(a, b);
	}

	// TODO: Linking for unary minus operator
	public static int _operator_minus(int a) {
		return -a;
	}

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

	public static boolean _operator_and(boolean a, boolean b) {
		return a&&b;
	}

	public static boolean _operator_or(boolean a, boolean b) {
		return a||b;
	}

	public static boolean _operator_not(boolean b) {
		return !b;
	}
	
	public static boolean _operator_notEquals(Object a, Object b) {
		return !_operator_equals(a, b);
	}
	
	public static boolean _operator_equals(Object a, Object b) {
		if (a==b)
			return true;
		if (a==null)
			return false;
		return a.equals(b);
	}
	
	public static <A extends Collection<B>,B> boolean _operator_add(A a, B b) {
		return a.add(b);
	}
	
}
