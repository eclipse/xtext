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
import com.google.inject.Provider
import java.util.List
import java.util.Map
import java.util.Set
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations
import org.eclipse.xtext.common.types.JvmTypeParameter
import org.eclipse.xtext.util.Triple
import org.eclipse.xtext.util.Tuples
import org.eclipse.xtext.xbase.junit.typesystem.PublicResolvedTypes
import org.eclipse.xtext.xbase.typesystem.internal.DefaultReentrantTypeResolver
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner
import org.eclipse.xtext.xbase.typesystem.references.LightweightBoundTypeArgument
import org.eclipse.xtext.xbase.typesystem.references.LightweightMergedBoundTypeArgument
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference
import org.eclipse.xtext.xbase.typesystem.references.StandardTypeReferenceOwner
import org.eclipse.xtext.xbase.typesystem.references.UnboundTypeReference
import org.eclipse.xtext.xbase.typesystem.util.BoundTypeArgumentSource
import org.eclipse.xtext.xbase.typesystem.util.DeferredTypeParameterHintCollector
import org.eclipse.xtext.xbase.typesystem.util.Multimaps2
import org.eclipse.xtext.xbase.typesystem.util.TypeParameterSubstitutor
import org.eclipse.xtext.xbase.typesystem.util.VarianceInfo
import org.junit.Test

import static org.eclipse.xtext.xbase.typesystem.util.VarianceInfo.*

/**
 * @author Sebastian Zarnekow
 */
class DeferredTypeParameterHintCollectorTest extends AbstractTestingTypeReferenceOwner {

	@Inject
	extension IXtendJvmAssociations
	
	@Inject
	Provider<DefaultReentrantTypeResolver> resolverProvider
	
	ListMultimap<Object, LightweightBoundTypeArgument> hints = Multimaps2::newLinkedHashListMultimap
	
	def operation(String typeParameters, String expectedType, String actualType) {
		// TODO synthesize unique variable names as soon as the function should be validated
		val signature = '''def <«typeParameters»> void method(«expectedType» expected, «actualType» actual) {}'''
		val function = function(signature.toString)
		val operation = function.directlyInferredOperation
		return operation
	}
	
	def in(String typeParameters, String expectedType, String actualType) {
		val operation = operation(typeParameters, expectedType, actualType)
		val collector = new DeferredTypeParameterHintCollector(owner)
		val resolver = resolverProvider.get
		resolver.initializeFrom(EcoreUtil.getRootContainer(operation))
		val substitutor = new MockTypeParameterSubstitutor(owner, new PublicResolvedTypes(resolver))
		val hasUnbounds = substitutor.substitute(operation.parameters.head.parameterType.toLightweightTypeReference)
		val isActual = operation.parameters.last.parameterType.toLightweightTypeReference
		collector.processPairedReferences(hasUnbounds, isActual)
		return substitutor.typeParameterMapping
	}
	
	def hasHintsFor(Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> mapping, String typeParamName) {
		val allKeys = mapping.keySet
		for(key: allKeys) {
			if (key.simpleName == typeParamName) {
				val unbound = mapping.get(key).typeReference as UnboundTypeReference
				unbound.getAllHints.forEach [ assertEquals( BoundTypeArgumentSource::INFERRED_LATER, source ) ]
				return unbound.getAllHints
			}
		}
		fail('''No mapping for «typeParamName» in «mapping.keySet.map[simpleName]»'''.toString)
	}
	
	def hasNoHintsFor(Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> mapping, String typeParamName) {
		val allKeys = mapping.keySet
		for(key: allKeys) {
			if (key.simpleName == typeParamName) {
				val unbound = mapping.get(key).typeReference as UnboundTypeReference
				if (!unbound.getAllHints.empty)
					fail('''Unexpected mapping for «typeParamName» in «mapping.keySet.map[simpleName]»'''.toString)
			}
		}
		
	}
	
	def like(List<LightweightBoundTypeArgument> mappingData, Triple<String, VarianceInfo, VarianceInfo>... mappedTypes) {
		assertEquals(mappingData.map[ '''«typeReference.toString»(«declaredVariance»/«actualVariance»)'''].toString, mappedTypes.size, mappingData.size)
		assertEquals(mappedTypes.toList as Object, mappingData.map[ Tuples::create(typeReference.toString, declaredVariance, actualVariance) ].toList)
		return mappingData
	}
	
	override protected createOwner() {
		new StandardTypeReferenceOwner(services, contextResourceSet) {
			override acceptHint(Object handle, LightweightBoundTypeArgument boundTypeArgument) {
				hints.put(handle, boundTypeArgument)
			}
			
			override getAllHints(Object handle) {
				hints.get(handle)
			}
			
			override isResolved(Object handle) {
				return false
			}
		}
	}

	def operator_mappedTo(Pair<String, VarianceInfo> pair, VarianceInfo third) {
		Tuples::create(pair.key, pair.value, third)
	}
	
	@Test
	def void testDirectUnboundExpectation() {
		"T".in("T", "String").hasHintsFor("T").like("String"->OUT->OUT)
	}
	
	@Test
	def void testNestedUnboundExpectation_01() {
		"T".in("Iterable<T>", "java.util.List<String>").hasHintsFor("T").like("String"->INVARIANT->INVARIANT)
	}
	
	@Test
	def void testNestedUnboundExpectation_02() {
		"T".in("Iterable<? extends T>", "java.util.List<String>").hasHintsFor("T").like("String"->OUT->INVARIANT)
	}
	
	@Test
	def void testNestedUnboundExpectation_03() {
		"T".in("Iterable<? super T>", "java.util.List<String>").hasHintsFor("T").like("String"->IN->INVARIANT)
	}
	
	@Test
	def void testUsedTwice() {
		"T".in("java.util.Map<T, T>", "com.google.common.collect.BiMap<CharSequence, Integer>").hasHintsFor("T")
			.like("CharSequence"->INVARIANT->INVARIANT, "Integer"->INVARIANT->INVARIANT)
	}
	
	@Test
	def void testDependsOnOther() {
		"T, V".in("java.util.Map<T, String>", "java.util.Map<V, Integer>").hasHintsFor("T").like("V"->INVARIANT->INVARIANT)
	}
	
	@Test
	def void testUnusedExpectation_01() {
		"T".in("Iterable<T>", "String").hasNoHintsFor("T")
	}
	
	@Test
	def void testUnusedExpectation_02() {
		"T".in("String", "Iterable<T>").hasNoHintsFor("T")
	}
}

/**
 * @author Sebastian Zarnekow
 */
class MockTypeParameterSubstitutor extends TypeParameterSubstitutor<Set<JvmTypeParameter>> {
	
	val PublicResolvedTypes resolvedTypes
	
	new(ITypeReferenceOwner owner, PublicResolvedTypes resolvedTypes) {
		super(<JvmTypeParameter, LightweightMergedBoundTypeArgument>emptyMap(), owner)
		this.resolvedTypes = resolvedTypes
	}
	
	override public getTypeParameterMapping() {
		super.getTypeParameterMapping()
	}
	
	override doVisitParameterizedTypeReference(ParameterizedTypeReference reference, Set<JvmTypeParameter> visiting) {
		val type = reference.getType();
		if (type instanceof JvmTypeParameter) {
			if (!visiting.add(type)) {
				return null;
			}
			try {
				val mappedReference = getTypeParameterMapping().get(type);
				if (mappedReference != null) {
					return mappedReference.typeReference.accept(this, visiting)
				} else {
					val result = new SimpleUnboundTypeReference(owner, type, new Object)
					typeParameterMapping.put(type, new LightweightMergedBoundTypeArgument(result, INVARIANT))
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

class SimpleUnboundTypeReference extends UnboundTypeReference {
	
	new(ITypeReferenceOwner owner, JvmTypeParameter typeParameter, Object handle) {
		super(owner, null, typeParameter, handle)
	}

	override protected createCopy(ITypeReferenceOwner owner) {
		return new SimpleUnboundTypeReference(owner, typeParameter, handle)
	}
		
}

