/*******************************************************************************
 * Copyright (c) 2010, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package testdata;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class FieldAccessSub extends FieldAccess {
	
	public String stringField() {
		return "stringField()";
	}
	
	public String stringField;
	
	@SuppressWarnings("unused")
	private String privateField;  
	
	public String privateField() {
		return "privateField()";
	}
	
	@SuppressWarnings("unused")
	private String shadowedByPrivateField;
}
