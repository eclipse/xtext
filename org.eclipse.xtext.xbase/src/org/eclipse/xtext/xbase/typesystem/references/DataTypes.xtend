/*******************************************************************************
 * Copyright (c) 2012, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.references

import java.util.Map
import java.util.Set
import org.eclipse.xtext.common.types.JvmType
import org.eclipse.xtext.common.types.JvmTypeParameter
import org.eclipse.xtext.xbase.typesystem.util.BoundTypeArgumentSource
import org.eclipse.xtext.xbase.typesystem.util.VarianceInfo
import org.eclipse.xtend.lib.annotations.Data

/**
 * Small utility data structure to carry around in the type reference visitors.
 * May help to guard against infinite recursion and to collect type parameter data.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Data
class LightweightTraversalData {
	Set<JvmType> visited = newHashSet
	Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> typeParameterMapping = newLinkedHashMap
}

/**
 * Encapsulates the information that is collected as a type hint to later resolve an
 * unbound type reference.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Data
class LightweightBoundTypeArgument {
	LightweightTypeReference typeReference
	BoundTypeArgumentSource source
	Object origin
	VarianceInfo declaredVariance
	VarianceInfo actualVariance
	
	def isValidVariancePair() {
		declaredVariance.mergeDeclaredWithActual(actualVariance) !== null
	}
}

/**
 * The result of a merge operation where different type bound type arguments are incorporated into
 * a result.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Data
class LightweightMergedBoundTypeArgument {
	LightweightTypeReference typeReference
	VarianceInfo variance
}
