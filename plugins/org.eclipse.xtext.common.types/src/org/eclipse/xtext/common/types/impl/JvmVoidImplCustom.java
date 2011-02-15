/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.impl;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class JvmVoidImplCustom extends JvmVoidImpl {

	private static final String VOID = "void"; 
	
	@Override
	public String getIdentifier() {
		return VOID;
	}
	
	@Override
	public String getSimpleName() {
		return VOID;
	}
	
	@Override
	public String getQualifiedName(char innerClassDelimiter) {
		return VOID;
	}

}
