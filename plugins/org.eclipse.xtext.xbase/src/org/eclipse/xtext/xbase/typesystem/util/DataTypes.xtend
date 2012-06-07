/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.util

import java.util.Map
import java.util.Set
import org.eclipse.xtend.lib.Data
import org.eclipse.xtext.common.types.JvmType
import org.eclipse.xtext.common.types.JvmTypeParameter
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.common.types.util.TypeReferences
import com.google.inject.Inject
import org.eclipse.xtext.common.types.util.TypeConformanceComputer
import org.eclipse.xtext.xtype.XtypeFactory
import org.eclipse.xtext.common.types.TypesFactory
import org.eclipse.xtext.common.types.util.Primitives

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc
 */
@Data
class TraversalData {
	Set<JvmType> visited = newHashSet
	Map<JvmTypeParameter, MergedBoundTypeArgument> typeParameterMapping = newLinkedHashMap
}

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc
 */
@Data
class BoundTypeArgument {
	JvmTypeReference typeReference
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
class MergedBoundTypeArgument {
	JvmTypeReference typeReference
	VarianceInfo variance
}

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc
 */
class CommonTypeComputationServices {
	@Inject
	@Property
	TypeReferences typeReferences
	
	@Inject
	@Property
	TypeConformanceComputer typeConformanceComputer;
	
	@Inject
	@Property
	Primitives primitives;
	
	@Inject
	@Property
	BoundTypeArgumentMerger boundTypeArgumentMerger

	@Inject(optional = true)
	@Property
	XtypeFactory xtypeFactory = XtypeFactory::eINSTANCE;
	
	@Inject(optional = true)
	@Property
	TypesFactory typesFactory = TypesFactory::eINSTANCE;
}
