/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.xtend2.impl;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class CreateExtensionInfoImplCustom extends CreateExtensionInfoImpl {
	@Override
	public String getSimpleName() {
		return getName();
	}
	
	@Override
	public String getQualifiedName(char innerClassDelimiter) {
		return getName();
	}
	
	@Override
	public String getIdentifier() {
		return getName();
	}
}
