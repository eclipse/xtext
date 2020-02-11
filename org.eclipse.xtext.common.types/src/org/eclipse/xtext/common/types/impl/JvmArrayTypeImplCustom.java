/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.impl;

import org.eclipse.xtext.common.types.JvmArrayType;
import org.eclipse.xtext.common.types.JvmComponentType;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class JvmArrayTypeImplCustom extends JvmArrayTypeImpl {

	@Override
	public int getDimensions() {
		int result = 1;
		JvmComponentType componentType = getComponentType();
		if (componentType == null)
			throw new NullPointerException("component type may not be null");
		while (componentType instanceof JvmArrayType) {
			result++;
			componentType = ((JvmArrayType) componentType).getComponentType();
			if (componentType == null)
				return result;
		}
		return result;
	}

	@Override
	public String getIdentifier() {
		JvmComponentType componentType = getComponentType();
		if (componentType != null)
			return componentType.getIdentifier() + "[]";
		return null;
	}
	
	@Override
	public String getSimpleName() {
		JvmComponentType componentType = getComponentType();
		if (componentType != null)
			return componentType.getSimpleName() + "[]";
		return null;
	}
	
	@Override
	public String getQualifiedName(char innerClassDelimiter) {
		JvmComponentType componentType = getComponentType();
		if (componentType != null)
			return componentType.getQualifiedName(innerClassDelimiter) + "[]";
		return null;
	}

}
