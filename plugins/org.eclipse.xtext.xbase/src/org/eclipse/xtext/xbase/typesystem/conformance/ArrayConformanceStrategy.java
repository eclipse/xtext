/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.conformance;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.xtext.xbase.typesystem.references.AnyTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ArrayTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public class ArrayConformanceStrategy extends TypeConformanceStrategy<ArrayTypeReference> {
	
	public ArrayConformanceStrategy(TypeConformanceComputer conformanceComputer) {
		super(conformanceComputer);
	}

	@Override
	protected TypeConformanceResult doVisitArrayTypeReference(ArrayTypeReference left,
			ArrayTypeReference right,
			TypeConformanceComputationArgument.Internal<ArrayTypeReference> param) {
		LightweightTypeReference leftComponent = left.getComponentType();
		LightweightTypeReference rightComponent = right.getComponentType();
		return conformanceComputer.isConformant(leftComponent, rightComponent, new TypeConformanceComputationArgument(param.rawType, param.asTypeArgument, false));
	}

	@Override
	protected TypeConformanceResult doVisitAnyTypeReference(ArrayTypeReference left, AnyTypeReference reference, TypeConformanceComputationArgument.Internal<ArrayTypeReference> param) {
		return TypeConformanceResult.SUCCESS;
	}

	@Override
	protected TypeConformanceResult doVisitTypeReference(ArrayTypeReference left, LightweightTypeReference reference, TypeConformanceComputationArgument.Internal<ArrayTypeReference> param) {
		return TypeConformanceResult.FAILED;
	}
}