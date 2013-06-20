/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.util;

import org.eclipse.xtext.common.types.JvmMultiTypeReference;
import org.eclipse.xtext.common.types.JvmTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Deprecated
public class MultiTypeConformanceStrategy extends TypeConformanceStrategy<JvmMultiTypeReference> {
	public MultiTypeConformanceStrategy(TypeConformanceComputer conformanceComputer) {
		super(conformanceComputer);
	}

	@Override
	public TypeConformanceResult doVisitTypeReference(JvmMultiTypeReference left, JvmTypeReference right, TypeConformanceComputationArgument.Internal<JvmMultiTypeReference> param) {
		for(JvmTypeReference component: left.getReferences()) {
			// TODO I think we should disable primitive widening / boxing here
			TypeConformanceResult result = conformanceComputer.isConformant(component, right, param);
			if (!result.isConformant())
				return result;
		}
		if (!left.getReferences().isEmpty()) {
			return TypeConformanceResult.SUCCESS;
		}
		return TypeConformanceResult.FAILED;
	}

	@Override
	public TypeConformanceResult doVisitMultiTypeReference(JvmMultiTypeReference left, JvmMultiTypeReference right, TypeConformanceComputationArgument.Internal<JvmMultiTypeReference> param) {
		return doVisitTypeReference(left, right, param);
	}
}