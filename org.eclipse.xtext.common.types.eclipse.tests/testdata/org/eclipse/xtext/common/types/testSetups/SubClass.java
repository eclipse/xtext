/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.testSetups;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("unused")
public class SubClass extends SuperClass {
	private String privateField;
	private String shadowedByPrivateField;
	protected String protectedField;
	public String publicField;
	
	@Override
	public String publicMethod() {
		return privateField;
	}
	
	private String privateMethod(String s) {
		return privateField;
	}
	private String privateMethod(Object x) {
		return privateField;
	}
}
