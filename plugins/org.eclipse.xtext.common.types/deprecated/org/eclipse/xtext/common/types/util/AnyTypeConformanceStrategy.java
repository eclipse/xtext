/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.util;

import org.eclipse.xtext.common.types.JvmAnyTypeReference;
import org.eclipse.xtext.common.types.JvmTypeReference;

/**
 * Only the any type can be assigned to the any type.
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Deprecated
public class AnyTypeConformanceStrategy extends TypeConformanceStrategy<JvmAnyTypeReference> {
	protected AnyTypeConformanceStrategy(TypeConformanceComputer conformanceComputer) {
		super(conformanceComputer);
	}

	@Override
	public TypeConformanceResult doVisitAnyTypeReference(JvmAnyTypeReference left, JvmAnyTypeReference right, TypeConformanceComputationArgument.Internal<JvmAnyTypeReference> param) {
		return TypeConformanceResult.SUCCESS;
	}

	@Override
	public TypeConformanceResult doVisitTypeReference(JvmAnyTypeReference left, JvmTypeReference right, TypeConformanceComputationArgument.Internal<JvmAnyTypeReference> param) {
		return TypeConformanceResult.FAILED;
	}
}