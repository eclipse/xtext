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

public class JvmArrayTypeImplCustom extends JvmArrayTypeImpl {

	@Override
	public int getDimensions() {
		int result = 1;
		JvmTypeReference componentType = getComponentType();
		if (componentType == null)
			throw new NullPointerException("component type may not be null");
		while (componentType.getType() instanceof JvmArrayType) {
			result++;
			componentType = ((JvmArrayType) componentType.getType()).getComponentType();
			if (componentType == null)
				return result;
		}
		return result;
	}

	@Override
	public String getCanonicalName() {
		if (componentType != null)
			return getComponentType().getCanonicalName() + "[]";
		return null;
	}

}
