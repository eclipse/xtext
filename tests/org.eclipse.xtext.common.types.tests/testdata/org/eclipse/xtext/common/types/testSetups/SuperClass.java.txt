/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.testSetups;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("unused")
public class SuperClass {
	public static String privateField;
	public String shadowedByPrivateField;
	protected String protectedField;
	public String publicField;
	
	public String publicMethod() {
		return null;
	}
	protected String protectedMethod() {
		return null;
	}
	private String privateMethod(String s) {
		return null;
	}
	private String privateMethod(Object x) {
		return null;
	}
}
