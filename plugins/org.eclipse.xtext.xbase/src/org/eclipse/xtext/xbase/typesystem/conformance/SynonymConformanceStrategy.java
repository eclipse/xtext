/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.conformance;

import java.util.List;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.xtext.xbase.typesystem.references.CompoundTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public class SynonymConformanceStrategy extends TypeConformanceStrategy<CompoundTypeReference> {
	protected SynonymConformanceStrategy(TypeConformanceComputer conformanceComputer) {
		super(conformanceComputer);
	}

	@Override
	protected TypeConformanceResult doVisitTypeReference(CompoundTypeReference left, LightweightTypeReference right, TypeConformanceComputationArgument.Internal<CompoundTypeReference> param) {
		List<LightweightTypeReference> leftReferences = left.getMultiTypeComponents();
		if (leftReferences.isEmpty())
			return TypeConformanceResult.FAILED;
		for(LightweightTypeReference reference: leftReferences) {
			TypeConformanceResult result = conformanceComputer.isConformant(reference, right, param);
			if (result.isConformant())
				return result;
		}
		return TypeConformanceResult.FAILED;
	}
	
	@Override
	protected TypeConformanceResult doVisitMultiTypeReference(CompoundTypeReference left, CompoundTypeReference right,
			TypeConformanceComputationArgument.Internal<CompoundTypeReference> param) {
		return doVisitTypeReference(left, right, param);
	}
	
	@Override
	protected TypeConformanceResult doVisitSynonymTypeReference(CompoundTypeReference left,
			CompoundTypeReference right, 
			TypeConformanceComputationArgument.Internal<CompoundTypeReference> param) {
		return doVisitTypeReference(left, right, param);
	}
	
	
}