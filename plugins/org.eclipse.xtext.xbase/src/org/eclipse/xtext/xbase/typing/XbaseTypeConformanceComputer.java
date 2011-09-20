/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typing;

import java.util.Set;

import org.eclipse.xtext.common.types.JvmDelegateTypeReference;
import org.eclipse.xtext.common.types.JvmSynonymTypeReference;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.TypeConformanceComputationArgument;
import org.eclipse.xtext.common.types.util.TypeConformanceComputer;
import org.eclipse.xtext.common.types.util.TypeConformanceResult;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @author Sven Efftinge
 */
@Singleton
public class XbaseTypeConformanceComputer extends TypeConformanceComputer {
	
	@Inject 
	private Closures closures;
	
	@Inject
	private SynonymTypesProvider synonymTypeProvider;

	@Override
	public TypeConformanceResult isConformant(JvmTypeReference left, JvmTypeReference right,
			TypeConformanceComputationArgument flags) {
		TypeConformanceResult result = super.isConformant(left, right, flags);
		if (result.isConformant()) {
			return result;
		}
		// entry call
		if (!flags.isAsTypeArgument() && flags.isAllowPrimitiveConversion()) {
			JvmTypeReference leftFunction = closures.getCompatibleFunctionType(left, flags.isRawType());
			JvmTypeReference rightFunction = closures.getCompatibleFunctionType(right, flags.isRawType());
			if (leftFunction != null && rightFunction != null && (left != leftFunction || right != rightFunction)) {
				result = isConformant(leftFunction, rightFunction, flags);
				if (result.isConformant()) {
					result = TypeConformanceResult.merge(result, new TypeConformanceResult(TypeConformanceResult.Kind.DEMAND_CONVERSION));
					return result;
				}
			}
		}
		// TODO remove this code here since the type references should be wrapped as soon
		// as they are created
		Iterable<JvmTypeReference> synonymTypes = synonymTypeProvider.getSynonymTypes(right, true);
		for (JvmTypeReference synonymType : synonymTypes) {
			result = super.isConformant(left, synonymType, flags);
			if (result.isConformant())
				return result;
		}
		return result;
	}
	
}
