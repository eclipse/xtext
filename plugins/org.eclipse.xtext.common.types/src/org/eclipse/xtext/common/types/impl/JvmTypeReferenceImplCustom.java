/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.impl;

import org.eclipse.xtext.common.types.JvmType;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class JvmTypeReferenceImplCustom extends JvmTypeReferenceImpl {

	@Override
	public String getIdentifier() {
		JvmType type = getType();
		if (type != null)
			return type.getIdentifier();
		return null;
	}
	
	@Override
	public String getSimpleName() {
		JvmType type = getType();
		if (type != null)
			return type.getSimpleName();
		return null;
	}
	
	@Override
	public final String getQualifiedName() {
		return getQualifiedName('$');
	}
	
	@Override
	public String getQualifiedName(char innerClassDelimiter) {
		JvmType type = getType();
		if (type != null)
			return type.getQualifiedName(innerClassDelimiter);
		return null;
	}
	
}
