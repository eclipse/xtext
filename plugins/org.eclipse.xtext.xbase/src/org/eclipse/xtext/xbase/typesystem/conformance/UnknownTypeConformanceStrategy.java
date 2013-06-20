/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.conformance;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.UnknownTypeReference;

/**
 * Only the any type can be assigned to the any type.
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public class UnknownTypeConformanceStrategy extends TypeConformanceStrategy<UnknownTypeReference> {
	
	protected UnknownTypeConformanceStrategy(TypeConformanceComputer conformanceComputer) {
		super(conformanceComputer);
	}

	@Override
	protected TypeConformanceResult doVisitTypeReference(UnknownTypeReference left, LightweightTypeReference right, TypeConformanceComputationArgument.Internal<UnknownTypeReference> param) {
		return TypeConformanceResult.create(param, ConformanceHint.SUCCESS);
	}
	
}