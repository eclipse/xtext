package org.eclipse.xtext.util;

public final class Tuples {
	private Tuples(){}
	
	public static <A,B> Pair<A,B> create(A a, B b) {
		return new Pair<A, B>(a,b);
	}
	
	public static <A,B,C> Triple<A,B,C> create(A a, B b, C c) {
		return new Triple<A, B, C>(a,b,c);
	}

}
