/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package testdata;

@SuppressWarnings("unused")
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
