/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.typesystem

import com.google.common.collect.ListMultimap
import com.google.inject.Inject
import java.util.List
import java.util.Map
import java.util.Set
import org.eclipse.xtext.common.types.JvmTypeParameter
import org.eclipse.xtext.common.types.util.TypeConformanceComputationArgument
import org.eclipse.xtext.util.Triple
import org.eclipse.xtext.util.Tuples
import org.eclipse.xtext.xbase.junit.typesystem.PublicResolvedTypes
import org.eclipse.xtext.xbase.typesystem.internal.DefaultReentrantTypeResolver
import org.eclipse.xtext.xbase.typesystem.util.DeferredTypeParameterHintCollector
import org.eclipse.xtext.xbase.typesystem.references.LightweightBoundTypeArgument
import org.eclipse.xtext.xbase.typesystem.references.LightweightMergedBoundTypeArgument
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference
import org.eclipse.xtext.xbase.typesystem.references.OwnedConverter
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference
import org.eclipse.xtext.xbase.typesystem.util.TypeParameterSubstitutor
import org.eclipse.xtext.xbase.typesystem.references.TypeReferenceOwner
import org.eclipse.xtext.xbase.typesystem.references.UnboundTypeReference
import org.eclipse.xtext.xbase.typesystem.util.BoundTypeArgumentSource
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices
import org.eclipse.xtext.xbase.typesystem.util.Multimaps2
import org.eclipse.xtext.xbase.typesystem.util.VarianceInfo

import static org.eclipse.xtext.xbase.typesystem.util.VarianceInfo.*
import static org.junit.Assert.*
import org.eclipse.emf.ecore.resource.ResourceSet
import org.junit.After

/**
 * @author Sebastian Zarnekow
 */
class DeferredTypeParameterHintCollectorTest extends AbstractDeferredTypeParameterHintCollectorTest implements TypeReferenceOwner {

	@Inject
	CommonTypeComputationServices services
	
	@Inject
	DefaultReentrantTypeResolver resolver
	
	ResourceSet contextResourceSet
	
	extension OwnedConverter = new OwnedConverter(this)
	
	ListMultimap<Object, LightweightBoundTypeArgument> hints = Multimaps2::newLinkedHashListMultimap
	
	override in(String typeParameters, String expectedType, String actualType) {
		val operation = operation(typeParameters, expectedType, actualType)
		val collector = new DeferredTypeParameterHintCollector(this)
		val substitutor = new MockTypeParameterSubstitutor(this, new PublicResolvedTypes(resolver))
		val hasUnbounds = substitutor.substitute(operation.parameters.head.parameterType.toLightweightReference)
		val isActual = operation.parameters.last.parameterType.toLightweightReference
		collector.processPairedReferences(hasUnbounds, isActual)
		return substitutor.typeParameterMapping
	}
	
	override hasHintsFor(Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> mapping, String typeParamName) {
		val allKeys = mapping.keySet
		for(key: allKeys) {
			if (key.simpleName == typeParamName) {
				val unbound = (mapping.get(key) as LightweightMergedBoundTypeArgument).typeReference as UnboundTypeReference
				unbound.getAllHints.forEach [ assertEquals( BoundTypeArgumentSource::INFERRED_LATER, source ) ]
				return unbound.getAllHints
			}
		}
		fail('''No mapping for «typeParamName» in «mapping.keySet.map[simpleName]»'''.toString)
	}
	
	override hasNoHintsFor(Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> mapping, String typeParamName) {
		val allKeys = mapping.keySet
		for(key: allKeys) {
			if (key.simpleName == typeParamName) {
				val unbound = (mapping.get(key) as LightweightMergedBoundTypeArgument).typeReference as UnboundTypeReference
				if (!unbound.getAllHints.empty)
					fail('''Unexpected mapping for «typeParamName» in «mapping.keySet.map[simpleName]»'''.toString)
			}
		}
		
	}
	
	override like(List<LightweightBoundTypeArgument> mappingData, Triple<String, VarianceInfo, VarianceInfo>... mappedTypes) {
		assertEquals(mappingData.map[ o | val it = o as LightweightBoundTypeArgument '''«typeReference.toString»(«declaredVariance»/«actualVariance»)'''].toString, mappedTypes.size, mappingData.size)
		assertEquals(mappedTypes.toList as Object, mappingData.map[ o | val it = o as LightweightBoundTypeArgument Tuples::create(typeReference.toString, declaredVariance, actualVariance) ].toList)
		return mappingData
	}

	override acceptHint(Object handle, LightweightBoundTypeArgument boundTypeArgument) {
		hints.put(handle, boundTypeArgument)
	}
	
	override getAllHints(Object handle) {
		hints.get(handle)
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
	
	override getServices() {
		return services
	}
	
}

/**
 * @author Sebastian Zarnekow
 */
class MockTypeParameterSubstitutor extends TypeParameterSubstitutor<Set<JvmTypeParameter>> {
	
	val PublicResolvedTypes resolvedTypes
	
	new(TypeReferenceOwner owner, PublicResolvedTypes resolvedTypes) {
		super(<JvmTypeParameter, LightweightMergedBoundTypeArgument>emptyMap(), owner)
		this.resolvedTypes = resolvedTypes
	}
	
	override public getTypeParameterMapping() {
		super.getTypeParameterMapping()
	}
	
	override doVisitParameterizedTypeReference(ParameterizedTypeReference reference, Set<JvmTypeParameter> visiting) {
		val type = reference.getType();
		if (type instanceof JvmTypeParameter) {
			if (!visiting.add(type as JvmTypeParameter)) {
				return null;
			}
			try {
				val mappedReference = getTypeParameterMapping().get(type);
				if (mappedReference != null) {
					return mappedReference.typeReference.accept(this, visiting)
				} else {
					val result = new UnboundTypeReference(owner, type as JvmTypeParameter, new Object)
					typeParameterMapping.put(type as JvmTypeParameter, new LightweightMergedBoundTypeArgument(result, INVARIANT))
					return result
				}
			} finally {
				visiting.remove(type);
			}
		}
		return super.doVisitParameterizedTypeReference(reference, visiting)
	}
	
	override doVisitUnboundTypeReference(UnboundTypeReference reference, Set<JvmTypeParameter> param) {
		return reference.copyInto(getOwner)
	}
	
	override substitute(LightweightTypeReference original) {
		original.accept(this, newHashSet)
	}

	override protected createVisiting() {
		return newHashSet
	}
	
} 
