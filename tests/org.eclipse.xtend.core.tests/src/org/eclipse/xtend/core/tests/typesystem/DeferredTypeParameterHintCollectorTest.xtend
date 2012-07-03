/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.typesystem

import com.google.inject.Inject
import java.util.List
import java.util.Map
import java.util.Set
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations
import org.eclipse.xtend.core.tests.AbstractXtendTestCase
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference
import org.eclipse.xtext.common.types.JvmTypeParameter
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.util.Triple
import org.eclipse.xtext.util.Tuples
import org.eclipse.xtext.xbase.XbaseFactory
import org.eclipse.xtext.xbase.lib.Pair
import org.eclipse.xtext.xbase.typesystem.internal.BaseUnboundTypeParameter
import org.eclipse.xtext.xbase.typesystem.internal.DefaultReentrantTypeResolver
import org.eclipse.xtext.xbase.typesystem.util.BoundTypeArgument
import org.eclipse.xtext.xbase.typesystem.util.BoundTypeArgumentSource
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices
import org.eclipse.xtext.xbase.typesystem.util.DeferredTypeParameterHintCollector
import org.eclipse.xtext.xbase.typesystem.util.MergedBoundTypeArgument
import org.eclipse.xtext.xbase.typesystem.util.TypeParameterSubstitutor
import org.eclipse.xtext.xbase.typesystem.util.UnboundTypeParameter
import org.eclipse.xtext.xbase.typesystem.util.VarianceInfo
import org.eclipse.xtext.xtype.XComputedTypeReference
import org.junit.Test

import static org.eclipse.xtext.xbase.typesystem.util.VarianceInfo.*
import static org.junit.Assert.*
import org.eclipse.xtext.xbase.typesystem.internal.ResolvedTypes
import org.eclipse.xtext.xbase.XExpression

/**
 * @author Sebastian Zarnekow
 */
class DeferredTypeParameterHintCollectorTest extends AbstractXtendTestCase {

	@Inject
	extension IXtendJvmAssociations
	
	@Inject
	CommonTypeComputationServices services
	
	@Inject
	DefaultReentrantTypeResolver resolver
	
	def in(String typeParameters, String expectedType, String actualType) {
		// TODO synthesize unique variable names as soon as the function should be validated
		val signature = '''def <«typeParameters»> void method(«expectedType» expected, «actualType» actual) {}'''
		val function = function(signature.toString)
		val operation = function.directlyInferredOperation
		val collector = new DeferredTypeParameterHintCollector(services)
		val substitutor = new MockTypeParameterSubstitutor(services, new PublicResolvedTypes(resolver))
		val hasUnbounds = substitutor.substitute(operation.parameters.head.parameterType)
		val isActual = operation.parameters.last.parameterType
		collector.processPairedReferences(hasUnbounds, isActual)
		return substitutor.typeParameterMapping
	}
	
	def hasHintsFor(Map<JvmTypeParameter, MergedBoundTypeArgument> mapping, String typeParamName) {
		val allKeys = mapping.keySet
		for(key: allKeys) {
			if (key.simpleName == typeParamName) {
				val computed = mapping.get(key).typeReference as XComputedTypeReference
				val unbound = computed.typeProvider as BaseUnboundTypeParameter
				unbound.getAllHints.forEach [ assertEquals( BoundTypeArgumentSource::INFERRED_LATER, source ) ]
				return unbound.getAllHints
			}
		}
		fail('''No mapping for «typeParamName» in «mapping.keySet.map[simpleName]»'''.toString)
	}
	
	def hasNoHintsFor(Map<JvmTypeParameter, MergedBoundTypeArgument> mapping, String typeParamName) {
		val allKeys = mapping.keySet
		for(key: allKeys) {
			if (key.simpleName == typeParamName) {
				val computed = mapping.get(key).typeReference as XComputedTypeReference
				val unbound = computed.typeProvider as BaseUnboundTypeParameter
				if (!unbound.getAllHints.empty)
					fail('''Unexpected mapping for «typeParamName» in «mapping.keySet.map[simpleName]»'''.toString)
			}
		}
		
	}
	
	def like(List<BoundTypeArgument> mappingData, Triple<String, VarianceInfo, VarianceInfo>... mappedTypes) {
		assertEquals(mappingData.map['''«typeReference.simpleName»(«declaredVariance»/«actualVariance»)'''].toString, mappedTypes.size, mappingData.size)
		assertEquals(mappedTypes.toList as Object, mappingData.map[ Tuples::create(typeReference.simpleName, declaredVariance, actualVariance) ].toList)
		return mappingData
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
class MockTypeParameterSubstitutor extends TypeParameterSubstitutor {
	
	val PublicResolvedTypes resolvedTypes
	
	new(CommonTypeComputationServices services, PublicResolvedTypes resolvedTypes) {
		super(<JvmTypeParameter, MergedBoundTypeArgument>emptyMap(), services)
		this.resolvedTypes = resolvedTypes
	}
	
	override public getTypeParameterMapping() {
		super.getTypeParameterMapping()
	}
	
	override doVisitParameterizedTypeReference(JvmParameterizedTypeReference reference, Set<JvmTypeParameter> visiting) {
		val type = reference.getType();
		if (type instanceof JvmTypeParameter) {
			if (!visiting.add(type as JvmTypeParameter)) {
				return null;
			}
			try {
				val mappedReference = getTypeParameterMapping().get(type);
				if (mappedReference != null) {
					return visit(mappedReference.typeReference, visiting);
				} else {
					val result = services.xtypeFactory.createXComputedTypeReference
					result.typeProvider = resolvedTypes.createUnboundTypeParameter(XbaseFactory::eINSTANCE.createXFeatureCall, type as JvmTypeParameter)
					typeParameterMapping.put(type as JvmTypeParameter, new MergedBoundTypeArgument(result, INVARIANT))
					return result
				}
			} finally {
				visiting.remove(type);
			}
		}
		val result = getServices().getTypesFactory().createJvmParameterizedTypeReference();
		result.setType(type);
		var i = 0
		while(i < reference.getArguments().size()) {
			val argument = reference.getArguments().get(i);
			var copiedArgument = visit(argument, visiting);
			if (copiedArgument == null) {
				throw new IllegalStateException("copied argument may not be null")
			}
			result.getArguments().add(copiedArgument);			
			i = i + 1
		}
		return result;
	}
	
	override doVisitComputedTypeReference(XComputedTypeReference reference, Set<JvmTypeParameter> param) {
		if (reference.getTypeProvider() instanceof UnboundTypeParameter) {
			val result = getServices().getXtypeFactory().createXComputedTypeReference();
			result.setTypeProvider(reference.getTypeProvider());
			return result;
		}
		return super.doVisitComputedTypeReference(reference, param);
	}
	
	override substitute(JvmTypeReference original) {
		visit(original, newHashSet());
	}

}

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class PublicResolvedTypes extends ResolvedTypes {
	new(DefaultReentrantTypeResolver resolver) {
		super(resolver)
	}
	
	override public createUnboundTypeParameter(XExpression expression, JvmTypeParameter type) {
		super.createUnboundTypeParameter(expression, type)
	}
	
	override public getUnboundTypeParameter(Object handle) {
		super.getUnboundTypeParameter(handle)
	}
	
}
