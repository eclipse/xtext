/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package testdata;

public class LinkingStaticType {

	protected static String protectedField;
	
	public static String publicField;
	
	public static String fieldOverloadsMethod;
	
	public static void withArgument(Object o, int i, int j) {}
	public static void fieldOverloadsMethod(int i, int j) {}
	protected static String getProtectedField() {
		return protectedField;
	}
	public static String getPublicField() {
		return publicField;
	}
	public static String getFieldOverloadsMethod() {
		return fieldOverloadsMethod;
	}
	
}
