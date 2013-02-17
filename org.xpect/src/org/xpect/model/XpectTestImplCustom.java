/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xpect.model;

import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmTypeReference;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class XpectTestImplCustom extends XpectTestImpl {
	
	

	
	@Override
	public JvmDeclaredType getComponentClass() {
		JvmDeclaredType setupClass = null;// getSetupClass();
		if (setupClass == null || setupClass.eIsProxy())
			return null;
		if (setupClass.getSuperTypes().size() == 0 && setupClass.getSuperTypes().get(0) instanceof JvmParameterizedTypeReference)
			return null;
		JvmParameterizedTypeReference superClass = (JvmParameterizedTypeReference) setupClass.getSuperTypes().get(0);
		if (superClass.getArguments().size() != 4)
			return null;
		JvmTypeReference typeReference = superClass.getArguments().get(3);
		if (typeReference != null && typeReference.getType() != null && !typeReference.getType().eIsProxy())
			return (JvmDeclaredType) typeReference.getType();
		return null;

		// for (JvmFeature feature :
		// setupClass.findAllFeaturesByName("beforeFile"))
		// if (feature instanceof JvmOperation && ((JvmOperation)
		// feature).getParameters().size() == 3) {
		// JvmTypeReference parameterType = ((JvmOperation)
		// feature).getParameters().get(2).getParameterType();
		// if (parameterType instanceof JvmParameterizedTypeReference) {
		// JvmTypeReference target = ((JvmParameterizedTypeReference)
		// parameterType).getArguments().get(0);
		// if (target != null && target.getType() != null &&
		// !target.getType().eIsProxy())
		// return (JvmDeclaredType) target.getType();
		// }
		// }
		// return null;
	}
}
