/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
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
