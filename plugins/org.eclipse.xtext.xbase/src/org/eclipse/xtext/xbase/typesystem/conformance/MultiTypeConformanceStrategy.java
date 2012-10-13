/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.conformance;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.xtext.xbase.typesystem.references.CompoundTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public class MultiTypeConformanceStrategy extends TypeConformanceStrategy<CompoundTypeReference> {
	public MultiTypeConformanceStrategy(TypeConformanceComputer conformanceComputer) {
		super(conformanceComputer);
	}

	@Override
	protected TypeConformanceResult doVisitTypeReference(CompoundTypeReference left, LightweightTypeReference right, TypeConformanceComputationArgument.Internal<CompoundTypeReference> param) {
		for(LightweightTypeReference component: left.getMultiTypeComponents()) {
			// TODO I think we should disable primitive widening / boxing here
			TypeConformanceResult result = conformanceComputer.isConformant(component, right, param);
			if (!result.isConformant())
				return result;
		}
		if (!left.getMultiTypeComponents().isEmpty()) {
			return TypeConformanceResult.SUCCESS;
		}
		return TypeConformanceResult.FAILED;
	}

	@Override
	protected TypeConformanceResult doVisitMultiTypeReference(CompoundTypeReference left, CompoundTypeReference right, TypeConformanceComputationArgument.Internal<CompoundTypeReference> param) {
		return doVisitTypeReference(left, right, param);
	}
}