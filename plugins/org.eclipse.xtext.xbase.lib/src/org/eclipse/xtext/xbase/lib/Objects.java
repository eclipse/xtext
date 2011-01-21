package org.eclipse.xtext.xbase.lib;


public class Objects {
	
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
