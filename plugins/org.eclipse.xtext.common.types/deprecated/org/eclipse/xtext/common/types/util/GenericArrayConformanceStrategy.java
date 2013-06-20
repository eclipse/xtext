/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.util;

import org.eclipse.xtext.common.types.JvmAnyTypeReference;
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference;
import org.eclipse.xtext.common.types.JvmTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Deprecated
public class GenericArrayConformanceStrategy extends
		TypeConformanceStrategy<JvmGenericArrayTypeReference> {
	public GenericArrayConformanceStrategy(TypeConformanceComputer conformanceComputer) {
		super(conformanceComputer);
	}

	@Override
	public TypeConformanceResult doVisitGenericArrayTypeReference(JvmGenericArrayTypeReference left,
			JvmGenericArrayTypeReference right,
			TypeConformanceComputationArgument.Internal<JvmGenericArrayTypeReference> param) {
		JvmTypeReference leftComponent = left.getComponentType();
		JvmTypeReference rightComponent = right.getComponentType();
		return conformanceComputer.isConformant(leftComponent, rightComponent, new TypeConformanceComputationArgument(param.rawType, param.asTypeArgument, false));
	}

	@Override
	public TypeConformanceResult doVisitAnyTypeReference(JvmGenericArrayTypeReference left, JvmAnyTypeReference reference, TypeConformanceComputationArgument.Internal<JvmGenericArrayTypeReference> param) {
		return TypeConformanceResult.SUCCESS;
	}

	@Override
	public TypeConformanceResult doVisitTypeReference(JvmGenericArrayTypeReference left, JvmTypeReference reference, TypeConformanceComputationArgument.Internal<JvmGenericArrayTypeReference> param) {
		return TypeConformanceResult.FAILED;
	}
}