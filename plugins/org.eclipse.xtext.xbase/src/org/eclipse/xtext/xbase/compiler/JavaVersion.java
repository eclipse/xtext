/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.compiler;

/**
 * Enumeration of Java language versions. This is likely to be extended as new versions are released.
 * 
 * @author Miro Spoenemann - Initial contribution and API
 */
public enum JavaVersion {

	/**
	 * Java 5 language enhancements: generics, simplified for-loop, autoboxing and unboxing, enums,
	 * varargs, static import, annotations.
	 */
	JAVA5("Java 5"),
	
	/**
	 * Java 6 language enhancements: Override annotations for implemented methods.
	 */
	JAVA6("Java 6"),
	
	/**
	 * Java 7 language enhancements: extended numeric literals, switch over strings, type inference,
	 * try-with-resources, catch multiple exceptions.
	 */
	JAVA7("Java 7"),
	
	/**
	 * Java 8 language enhancements: lambda expressions, better type inference, more flexible
	 * annotations.
	 */
	JAVA8("Java 8");
	
	private final String label;
	
	JavaVersion(String label) {
		this.label = label;
	}
	
	public String getLabel() {
		return label;
	}
	
	public boolean isAtLeast(JavaVersion other) {
		// This implementation relies on the correct order of declaration of the enum constants
		return this.ordinal() >= other.ordinal();
	}
	
}
