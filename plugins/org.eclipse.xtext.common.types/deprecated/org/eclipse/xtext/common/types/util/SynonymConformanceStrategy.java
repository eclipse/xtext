/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.util;

import java.util.List;

import org.eclipse.xtext.common.types.JvmMultiTypeReference;
import org.eclipse.xtext.common.types.JvmSynonymTypeReference;
import org.eclipse.xtext.common.types.JvmTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Deprecated
public class SynonymConformanceStrategy extends TypeConformanceStrategy<JvmSynonymTypeReference> {
	protected SynonymConformanceStrategy(TypeConformanceComputer conformanceComputer) {
		super(conformanceComputer);
	}

	@Override
	public TypeConformanceResult doVisitTypeReference(JvmSynonymTypeReference left, JvmTypeReference right, TypeConformanceComputationArgument.Internal<JvmSynonymTypeReference> param) {
		List<JvmTypeReference> leftReferences = left.getReferences();
		if (leftReferences.isEmpty())
			return TypeConformanceResult.FAILED;
		for(JvmTypeReference reference: leftReferences) {
			TypeConformanceResult result = conformanceComputer.isConformant(reference, right, param);
			if (result.isConformant())
				return result;
		}
		return TypeConformanceResult.FAILED;
	}
	
	@Override
	public TypeConformanceResult doVisitMultiTypeReference(JvmSynonymTypeReference left, JvmMultiTypeReference right,
			TypeConformanceComputationArgument.Internal<JvmSynonymTypeReference> param) {
		return doVisitTypeReference(left, right, param);
	}
	
	@Override
	public TypeConformanceResult doVisitSynonymTypeReference(JvmSynonymTypeReference left,
			JvmSynonymTypeReference right, 
			TypeConformanceComputationArgument.Internal<JvmSynonymTypeReference> param) {
		return doVisitTypeReference(left, right, param);
	}
	
	
}