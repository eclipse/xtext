/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.impl;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class XVariableDeclarationImplCustom extends XVariableDeclarationImpl {
	
	@Override
	public String getIdentifier() {
		return name;
	}
	
	@Override
	public String getSimpleName() {
		return name;
	}
	
	@Override
	public String getQualifiedName() {
		return name;
	}
	
	@Override
	public String getQualifiedName(char innerClassDelimiter) {
		return name;
	}
	
	@Override
	public String toString() {
		if (isWriteable()) {
			return "var " + getSimpleName(); 
		}
		return "val " + getSimpleName();
	}
}
