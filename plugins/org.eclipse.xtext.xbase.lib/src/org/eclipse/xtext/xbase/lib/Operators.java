package org.eclipse.xtext.xbase.lib;

public class Operators {
	
	public static int _operator_plus(int a, int b) {
		return a+b;
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
	
}
