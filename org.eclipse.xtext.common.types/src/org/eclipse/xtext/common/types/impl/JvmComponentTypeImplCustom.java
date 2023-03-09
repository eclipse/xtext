/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.impl;

import org.eclipse.xtext.common.types.JvmArrayType;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.TypesPackage;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class JvmComponentTypeImplCustom extends JvmComponentTypeImpl {

	@Override
	public JvmArrayType getArrayType() {
		JvmArrayType result = super.getArrayType();
		if (result == null) {
			result = TypesFactory.eINSTANCE.createJvmArrayType();
			boolean wasDeliver = eDeliver();
			eSetDeliver(false);
			try {
				setArrayType(result);
			} finally {
				eSetDeliver(wasDeliver);
			}
		}
		return result;
	}
	
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType)
	{
		switch (featureID)
		{
			case TypesPackage.JVM_COMPONENT_TYPE__ARRAY_TYPE:
				// don't demand-create the array if queried reflectively
				return arrayType;
		}
		return super.eGet(featureID, resolve, coreType);
	}
	
}
