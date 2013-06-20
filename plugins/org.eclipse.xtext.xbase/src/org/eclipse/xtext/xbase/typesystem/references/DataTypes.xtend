/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.references

import java.util.Map
import java.util.Set
import org.eclipse.xtend.lib.Data
import org.eclipse.xtext.common.types.JvmType
import org.eclipse.xtext.common.types.JvmTypeParameter
import org.eclipse.xtext.xbase.typesystem.util.BoundTypeArgumentSource
import org.eclipse.xtext.xbase.typesystem.util.VarianceInfo

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc
 */
@Data
class LightweightTraversalData {
	Set<JvmType> visited = newHashSet
	Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> typeParameterMapping = newLinkedHashMap
}

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc
 */
@Data
class LightweightBoundTypeArgument {
	LightweightTypeReference typeReference
	BoundTypeArgumentSource source
	Object origin
	VarianceInfo declaredVariance
	VarianceInfo actualVariance
	
	def isValidVariancePair() {
		declaredVariance.mergeDeclaredWithActual(actualVariance) != null
	}
}

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc
 */
@Data
class LightweightMergedBoundTypeArgument {
	LightweightTypeReference typeReference
	VarianceInfo variance
}