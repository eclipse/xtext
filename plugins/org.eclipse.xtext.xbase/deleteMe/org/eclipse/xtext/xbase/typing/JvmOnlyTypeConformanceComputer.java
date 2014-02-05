/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typing;

import java.util.EnumSet;

import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.TypeConformanceComputationArgument;
import org.eclipse.xtext.common.types.util.TypeConformanceComputer;
import org.eclipse.xtext.common.types.util.TypeConformanceResult;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@Deprecated
public class JvmOnlyTypeConformanceComputer extends TypeConformanceComputer {
	
	@Override
	public TypeConformanceResult isConformant(JvmTypeReference left, JvmTypeReference right,
			TypeConformanceComputationArgument flags) {
		TypeConformanceResult result = super.isConformant(left, right, flags);
		if (result.isConformant()) {
			EnumSet<TypeConformanceResult.Kind> kinds = result.getKinds();
			if (kinds.contains(TypeConformanceResult.Kind.DEMAND_CONVERSION) ||
					kinds.contains(TypeConformanceResult.Kind.SYNONYM)) {
				return TypeConformanceResult.FAILED;
			}
		}
		return result;
	}
	
}
