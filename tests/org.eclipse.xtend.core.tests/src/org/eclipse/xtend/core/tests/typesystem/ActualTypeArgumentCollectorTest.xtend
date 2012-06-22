/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.typesystem

import com.google.common.collect.Multimap
import com.google.inject.Inject
import java.util.Collection
import org.eclipse.xtext.common.types.JvmTypeParameter
import org.eclipse.xtext.util.Triple
import org.eclipse.xtext.util.Tuples
import org.eclipse.xtext.xbase.typesystem.references.LightweightBoundTypeArgument
import org.eclipse.xtext.xbase.typesystem.references.OwnedConverter
import org.eclipse.xtext.xbase.typesystem.references.TypeReferenceOwner
import org.eclipse.xtext.xbase.typesystem.util.ActualTypeArgumentCollector
import org.eclipse.xtext.xbase.typesystem.util.BoundTypeArgumentSource
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices
import org.eclipse.xtext.xbase.typesystem.util.VarianceInfo

import static org.junit.Assert.*
import org.eclipse.emf.ecore.resource.ResourceSet
import org.junit.After

/**
 * @author Sebastian Zarnekow
 */
class LightweightActualTypeArgumentCollectorTest extends AbstractTypeArgumentCollectorTest implements TypeReferenceOwner {

	@Inject
	CommonTypeComputationServices services
	
	ResourceSet contextResourceSet
	
	extension OwnedConverter = new OwnedConverter(this)

	override mappedBy(String typeParameters, String... alternatingTypeReferences) {
		val operation = operation(typeParameters, alternatingTypeReferences)
		val collector = new ActualTypeArgumentCollector(operation.typeParameters, BoundTypeArgumentSource::INFERRED, this)
		for(i: (0..alternatingTypeReferences.size-1).withStep(2)) {
			collector.populateTypeParameterMapping(operation.parameters.get(i).parameterType.toLightweightReference, operation.parameters.get(i+1).parameterType.toLightweightReference)
		}
		return collector.typeParameterMapping
	}
	
	override protected function(String string) throws Exception {
		val result = super.function(string)
		contextResourceSet = result.eResource.resourceSet
		return result
	}
	
	@After
	def void tearDown() {
		contextResourceSet = null
	}
	
	override getContextResourceSet() {
		return contextResourceSet
	}
	
	override assertMapping(Multimap<JvmTypeParameter, ? extends Object> mapping, String typeParamName, Triple<String,VarianceInfo,VarianceInfo>... mappedTypes) {
		val allKeys = mapping.keySet
		for(key: allKeys) {
			if (key.simpleName == typeParamName) {
				assertNotNull(mappedTypes)
				val mappingData = mapping.get(key) as Collection<LightweightBoundTypeArgument>
				assertEquals(mappingData.map['''«typeReference»(«declaredVariance»/«actualVariance»)'''].toString, mappedTypes.size, mappingData.size)
				assertEquals(mappedTypes.toList as Object, mappingData.map[ Tuples::create(typeReference.toString, declaredVariance, actualVariance) ].toList)
				return mapping
			}
		}
		if (mappedTypes != null)
			fail('''No mapping for «typeParamName» in «mapping.keySet.map[simpleName]»'''.toString)
		return mapping
	}
	
	override assertOrigins(Multimap<JvmTypeParameter, ? extends Object> mapping, String typeParamName, int count) {
		val allKeys = mapping.keySet
		for(key: allKeys) {
			if (key.simpleName == typeParamName) {
				val mappingData = mapping.get(key) as Collection<LightweightBoundTypeArgument>
				assertEquals(count, mappingData.map[origin].toSet.size)
				return mapping
			}
		}
		return mapping
	}

	override getServices() {
		return services
	}
	
	override acceptHint(Object handle, LightweightBoundTypeArgument boundTypeArgument) {
		throw new UnsupportedOperationException("Should not be invoked")
	}
	
	override getAllHints(Object handle) {
		throw new UnsupportedOperationException("Should not be invoked")
	}
	
}
