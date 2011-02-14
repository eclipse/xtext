/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.impl;

import org.eclipse.xtext.common.types.JvmArrayType;
import org.eclipse.xtext.common.types.JvmTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class JvmGenericArrayTypeReferenceImplCustom extends JvmGenericArrayTypeReferenceImpl {
	
	@Override
	public JvmTypeReference getComponentType() {
		JvmArrayType arrayType = getType();
		if (arrayType != null)
			return arrayType.getComponentType();
		return null;
	}
	
	@Override
	public int getDimensions() {
		JvmArrayType arrayType = getType();
		if (arrayType != null)
			return arrayType.getDimensions();
		return -1;
	}
	
}
