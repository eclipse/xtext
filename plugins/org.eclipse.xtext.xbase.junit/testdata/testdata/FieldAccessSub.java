/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
