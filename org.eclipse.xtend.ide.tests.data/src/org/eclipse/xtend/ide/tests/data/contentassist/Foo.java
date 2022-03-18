/*******************************************************************************
 * Copyright (c) 2010, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.data.contentassist;

public class Foo {
	
	//static methods
	public static void publicStaticMethod() {
		
	}
	
	static void defaultStaticMethod() {
		
	}
	
	protected static void protectedStaticMethod() {
		
	}
	
	@SuppressWarnings("unused")
	private static void privateStaticMethod() {
		
	}
	
	//static fields
	public static String publicStaticField;
	
	static String defaultStaticField;
	
	protected static String protectedStaticField;
	
	@SuppressWarnings("unused")
	private static String privateStaticField;
	
	//instance methods
	public void publicMethod() {
		
	}
	
	void defaultMethod() {
		
	}
	
	protected void protectedMethod() {
		
	}
	
	@SuppressWarnings("unused")
	private void privateMethod() {
		
	}
	
	//instance fields
	public String publicField;
	
	String defaultField;
	
	protected String protectedField;
	
	@SuppressWarnings("unused")
	private String privateField;

}
