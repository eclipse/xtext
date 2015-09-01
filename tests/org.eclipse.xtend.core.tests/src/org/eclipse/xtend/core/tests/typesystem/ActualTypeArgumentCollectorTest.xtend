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
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations
import org.eclipse.xtext.common.types.JvmTypeParameter
import org.eclipse.xtext.util.Triple
import org.eclipse.xtext.util.Tuples
import org.eclipse.xtext.xbase.typesystem.references.LightweightBoundTypeArgument
import org.eclipse.xtext.xbase.typesystem.util.ActualTypeArgumentCollector
import org.eclipse.xtext.xbase.typesystem.util.BoundTypeArgumentSource
import org.eclipse.xtext.xbase.typesystem.util.VarianceInfo
import org.junit.Test

import static org.eclipse.xtext.xbase.typesystem.util.VarianceInfo.*

/**
 * @author Sebastian Zarnekow
 */
class ActualTypeArgumentCollectorTest extends AbstractTestingTypeReferenceOwner {

	@Inject
	extension IXtendJvmAssociations
	
	def mappedBy(String typeParameters, String... alternatingTypeReferences) {
		val operation = operation(typeParameters, alternatingTypeReferences)
		val collector = new ActualTypeArgumentCollector(operation.typeParameters, BoundTypeArgumentSource::INFERRED, owner)
		for(i: (0..alternatingTypeReferences.size-1).withStep(2)) {
			collector.populateTypeParameterMapping(operation.parameters.get(i).parameterType.toLightweightTypeReference, operation.parameters.get(i+1).parameterType.toLightweightTypeReference)
		}
		return collector.typeParameterMapping
	}
	
	def assertMapping(Map<JvmTypeParameter, List<LightweightBoundTypeArgument>> mapping, String typeParamName, Triple<String,VarianceInfo,VarianceInfo>... mappedTypes) {
		val allKeys = mapping.keySet
		for(key: allKeys) {
			if (key.simpleName == typeParamName) {
				assertNotNull(mappedTypes)
				val mappingData = mapping.get(key)
				assertEquals(mappingData.map['''«typeReference»(«declaredVariance»/«actualVariance»)'''].toString, mappedTypes.size, mappingData.size)
				assertEquals(mappedTypes.toList, mappingData.map[ Tuples::create(typeReference.toString, declaredVariance, actualVariance) ].toList)
				return mapping
			}
		}
		if (mappedTypes != null)
			fail('''No mapping for «typeParamName» in «mapping.keySet.map[simpleName]»'''.toString)
		return mapping
	}
	
	def assertOrigins(Map<JvmTypeParameter, List<LightweightBoundTypeArgument>> mapping, String typeParamName, int count) {
		val allKeys = mapping.keySet
		for(key: allKeys) {
			if (key.simpleName == typeParamName) {
				val mappingData = mapping.get(key)
				assertEquals(count, mappingData.map[origin].toSet.size)
				return mapping
			}
		}
		return mapping
	}

	def protected operation(String typeParameters, String... alternatingTypeReferences) {
		val signature = '''def «IF !typeParameters.nullOrEmpty»<«typeParameters»>«ENDIF» void method(«alternatingTypeReferences.join(null, ' p, ', ' p') [it]») {}'''
		val function = function(signature.toString)
		val operation = function.directlyInferredOperation
		operation
	}
	
	def operator_mappedTo(Pair<String, VarianceInfo> pair, VarianceInfo third) {
		Tuples::create(pair.key, pair.value, third)
	}
	
	@Test def void testNoParams_01() {
		assertTrue(''.mappedBy('String', 'String').empty)
	}
	
	@Test def void testNoParams_02() {
		assertTrue(''.mappedBy('java.util.List<?>', 'java.util.ArrayList<String>').empty)
	}
	
	@Test def void testUnusedParam() {
		'T'.mappedBy('CharSequence', 'String').assertMapping('T', 'Object'->OUT->OUT)
	}
	
	@Test def void testUnusedParams_01() {
		'T, T2'.mappedBy('CharSequence', 'String')
			.assertMapping('T', 'Object'->OUT->OUT)
			.assertMapping('T2', 'Object'->OUT->OUT)
	}
	
	@Test def void testUnusedParams_02() {
		'T extends CharSequence, T2'.mappedBy('CharSequence', 'String')
			.assertMapping('T', 'CharSequence'->OUT->OUT)
			.assertMapping('T2', 'Object'->OUT->OUT)
	}
	
	@Test def void testUnusedParams_03() {
		'T extends CharSequence, T2 extends T'.mappedBy('CharSequence', 'String')
			.assertMapping('T', 'CharSequence'->OUT->OUT)
			.assertMapping('T2', 'CharSequence'->OUT->OUT)
	}
	
	@Test def void testUnusedParams_04() {
		'T extends T2, T2'.mappedBy('CharSequence', 'String')
			.assertMapping('T', 'Object'->OUT->OUT)
			.assertMapping('T2', 'Object'->OUT->OUT)
	}
	
	@Test def void testUnusedParams_05() {
		'T extends T2, T2 extends CharSequence'.mappedBy('CharSequence', 'String')
			.assertMapping('T', 'Object'->OUT->OUT)
			.assertMapping('T2', 'CharSequence'->OUT->OUT)
	}
	
	@Test def void testUnambiguousMapping_01() {
		'T'.mappedBy('java.util.List<T>', 'java.util.List<String>').assertMapping('T', 'String'->INVARIANT->INVARIANT)
	}
	
	@Test def void testUnambiguousMapping_02() {
		'T'.mappedBy('java.util.Map<T, T>', 'java.util.Map<String, String>').assertMapping('T', 'String'->INVARIANT->INVARIANT, 'String'->INVARIANT->INVARIANT)
	}
	
	@Test def void testUnambiguousMapping_03() {
		'K, V'.mappedBy('java.util.Map<K, V>', 'java.util.Map<String, Integer>')
			.assertMapping('K', 'String'->INVARIANT->INVARIANT)
			.assertMapping('V', 'Integer'->INVARIANT->INVARIANT)
	}
	
	@Test def void testUnambiguousMapping_04() {
		'T'.mappedBy('T', 'CharSequence', 'T', 'CharSequence')
			.assertMapping('T', 'CharSequence'->OUT->OUT, 'CharSequence'->OUT->OUT)
	}
	
	@Test def void testUnambiguousMapping_05() {
		'T, T2'.mappedBy('T', 'CharSequence', 'T2', 'CharSequence')
			.assertMapping('T', 'CharSequence'->OUT->OUT)
			.assertMapping('T2', 'CharSequence'->OUT->OUT)
	}
	
	@Test def void testUsedTwice_01() {
		'T'.mappedBy('T', 'CharSequence', 'T', 'String')
			.assertMapping('T', 'CharSequence'->OUT->OUT, 'String'->OUT->OUT)
	}
	
	@Test def void testUsedTwice_02() {
		'T'.mappedBy('T', 'String', 'T', 'CharSequence')
			.assertMapping('T', 'String'->OUT->OUT, 'CharSequence'->OUT->OUT)
	}
	
	@Test def void testBestEffortMapping_01() {
		'T'.mappedBy('java.util.List<T>', 'java.util.Set<String>').assertMapping('T', 'String'->INVARIANT->INVARIANT)
	}
	
	@Test def void testBestEffortMapping_02() {
		'T'.mappedBy('java.util.ArrayList<T>', 'java.util.HashSet<String>').assertMapping('T', 'String'->INVARIANT->INVARIANT)
	}
	
	@Test def void testBestEffortMapping_03() {
		'T'.mappedBy('java.util.ArrayList<T>', 'Iterable<String>').assertMapping('T', 'String'->INVARIANT->INVARIANT)
	}
	
	@Test def void testBestEffortMapping_04() {
		'T'.mappedBy('java.util.HashMap<java.util.ArrayList<T>, java.util.ArrayList<T>>', 'java.util.Map<Iterable<String>, java.util.HashSet<Integer>>')
			.assertMapping('T', 'String'->INVARIANT->INVARIANT, 'Integer'->INVARIANT->INVARIANT)
	}
	
	@Test def void testBestEffortMapping_05() {
		'T'.mappedBy('org.eclipse.xtend.core.tests.typesystem.MapType<T>', 'java.util.HashMap<String, Integer>')
			.assertMapping('T', 'String'->INVARIANT->INVARIANT, 'Integer'->INVARIANT->INVARIANT)
	}
	
	@Test def void testInheritanceMapping_01() {
		'E'.mappedBy('Iterable<E>', 'java.util.ArrayList<String>')
			.assertMapping('E', 'String'->INVARIANT->INVARIANT)
	}
	
	@Test def void testInheritanceMapping_02() {
		'C'.mappedBy('Comparable<C>', 'String')
			.assertMapping('C', 'String'->INVARIANT->INVARIANT)
	}
	
	@Test def void testMappedGenericType_01() {
		'T'.mappedBy('Iterable<T>', 'Iterable<Iterable<String>>').assertMapping('T', 'Iterable<String>'->INVARIANT->INVARIANT)
	}
	
	@Test def void testMappedArray_01() {
		'T'.mappedBy('T[]', 'String[]').assertMapping('T', 'String'->OUT->OUT)
	}
	
	@Test def void testMappedArray_02() {
		'T'.mappedBy('T[]', 'String[][]').assertMapping('T', 'String[]'->OUT->OUT)
	}
	
	@Test def void testUpperBound_01() {
		'T'.mappedBy('Iterable<? extends T>', 'Iterable<String>').assertMapping('T', 'String'->OUT->INVARIANT)
	}
	
	@Test def void testUpperBound_02() {
		'T'.mappedBy('Iterable<? extends T>', 'Iterable<? extends String>').assertMapping('T', 'String'->OUT->OUT)
	}
	
	@Test def void testUpperBound_03() {
		'T'.mappedBy('Iterable<? extends T>', 'Iterable<? super String>')
			.assertMapping('T', 'Object'->OUT->OUT, 'String'->OUT->IN)
			.assertOrigins('T', 1)
	}
	
	@Test def void testUpperBound_04() {
		'T'.mappedBy('Iterable<T>', 'Iterable<? extends String>').assertMapping('T', 'String'->INVARIANT->OUT)
	}
	
	@Test def void testUpperBound_05() {
		'T'.mappedBy('Iterable<Iterable<T>>', 'Iterable<Iterable<? extends CharSequence>>').assertMapping('T', 'CharSequence'->INVARIANT->OUT)
	}
	
	@Test def void testUpperBound_06() {
		'T'.mappedBy('Iterable<T>', 'Iterable<Iterable<? extends CharSequence>>').assertMapping('T', 'Iterable<? extends CharSequence>'->INVARIANT->INVARIANT)
	}
	
	@Test def void testUpperBound_07() {
		'T'.mappedBy('Iterable<? extends Iterable<T>>', 'Iterable<Iterable<? extends CharSequence>>').assertMapping('T', 'CharSequence'->INVARIANT->OUT)
	}
	
	@Test def void testUpperBound_08() {
		'T'.mappedBy('Iterable<? extends Iterable<T>>', 'Iterable<Iterable<CharSequence>>').assertMapping('T', 'CharSequence'->INVARIANT->INVARIANT)
	}
	
	@Test def void testUpperBound_09() {
		'T'.mappedBy('Iterable<? extends Iterable<T>>', 'Iterable<? extends Iterable<CharSequence>>').assertMapping('T', 'CharSequence'->INVARIANT->INVARIANT)
	}
	
	@Test def void testUpperBound_10() {
		'T'.mappedBy('Iterable<? extends Iterable<T>>', 'Iterable<? super Iterable<CharSequence>>').assertMapping('T', 'CharSequence'->INVARIANT->INVARIANT)
	}
	
	@Test def void testUpperBound_11() {
		'T'.mappedBy('java.util.Map<? extends T, ? extends T>', 'java.util.Map<String, Integer>')
			.assertMapping('T', 'String'->OUT->INVARIANT, 'Integer'->OUT->INVARIANT)
			.assertOrigins('T', 2)
	}
	
	@Test def void testLowerBound_01() {
		'T'.mappedBy('Iterable<? super T>', 'Iterable<String>').assertMapping('T', 'String'->IN->INVARIANT)
	}
	
	@Test def void testLowerBound_02() {
		'T'.mappedBy('Iterable<? super T>', 'Iterable<? super String>').assertMapping('T', 'String'->IN->IN)
	}
	
	@Test def void testLowerBound_03() {
		'T'.mappedBy('Iterable<? super T>', 'Iterable<? extends String>').assertMapping('T', 'String'->IN->OUT)
	}
	
	@Test def void testLowerBound_04() {
		'T, T2 extends T'.mappedBy('Iterable<? super T>', 'Iterable<? extends String>')
			.assertMapping('T', 'String'->IN->OUT)
			.assertMapping('T2', 'String'->IN->OUT)
	}
	
	@Test def void testLowerBound_05() {
		'T, T2 extends T'.mappedBy('java.util.Map<? super T, T>', 'java.util.Map<? extends String, Integer>')
			.assertMapping('T', 'String'->IN->OUT, 'Integer'->INVARIANT->INVARIANT)
			.assertMapping('T2', 'String'->IN->OUT, 'Integer'->INVARIANT->INVARIANT)
	}
	
	@Test def void testLowerBound_06() {
		'T'.mappedBy('Iterable<T>', 'Iterable<? super String>').assertMapping('T', 'String'->INVARIANT->IN)
	}
	
	@Test def void testLowerBound_07() {
		'T'.mappedBy('Iterable<Iterable<T>>', 'java.util.LinkedList<Iterable<? super String>>').assertMapping('T', 'String'->INVARIANT->IN)
	}
	
	@Test def void testLowerBound_08() {
		'T'.mappedBy('Iterable<T>', 'Iterable<Iterable<? super String>>').assertMapping('T', 'Iterable<? super String>'->INVARIANT->INVARIANT)
	}
	
	@Test def void testLowerBound_09() {
		'T extends T2, T2'.mappedBy('Iterable<? super T2>', 'Iterable<? extends String>')
			.assertMapping('T', 'String'->IN->OUT)
			.assertMapping('T2', 'String'->IN->OUT)
	}
	
	@Test def void testDependentTypeParams_01() {
		'T extends CharSequence, T2 extends T'.mappedBy('java.util.Map<T, T2>', 'java.util.Map<String, String>')
			.assertMapping('T', 'String'->INVARIANT->INVARIANT)
			.assertMapping('T2', 'String'->INVARIANT->INVARIANT)
	}
	
	@Test def void testDependentTypeParams_02() {
		'T, T2 extends T'.mappedBy('Iterable<T>', 'Iterable<String>')
			.assertMapping('T', 'String'->INVARIANT->INVARIANT)
			.assertMapping('T2', 'String'->INVARIANT->INVARIANT)
	}
	
	@Test def void testDependentTypeParams_03() {
		'T extends T2, T2 extends CharSequence'.mappedBy('Iterable<T2>', 'Iterable<String>')
			.assertMapping('T', 'String'->INVARIANT->INVARIANT)
			.assertMapping('T2', 'String'->INVARIANT->INVARIANT)
	}
	
	@Test def void testDependentTypeParams_04() {
		'T, T2 extends T, T3 extends T2'.mappedBy('java.util.Map<T, T3>', 'java.util.Map<String, Integer>')
			.assertMapping('T', 'String'->INVARIANT->INVARIANT)
			.assertMapping('T2', 'String'->INVARIANT->INVARIANT)
			.assertMapping('T3', 'Integer'->INVARIANT->INVARIANT)
	}
	
	@Test def void testCircularTypeParams_01() {
		'T extends T'.mappedBy('String', 'String')
			.assertMapping('T', 'Object'->OUT->OUT)
	}
	
	@Test def void testCircularTypeParams_02() {
		'T extends Iterable<T>'.mappedBy('CharSequence', 'String')
			.assertMapping('T', 'Iterable<Object>'->OUT->OUT)
	}
	
	@Test def void testCircularTypeParams_03() {
		'T extends Iterable<T>'.mappedBy('T', 'java.util.List<String>')
			.assertMapping('T', 'List<String>'->OUT->OUT)
	}
	
	@Test def void testCircularTypeParams_04() {
		'T extends Iterable<T>'.mappedBy('Iterable<? extends T>', 'java.util.List<String>')
			.assertMapping('T', 'String'->OUT->INVARIANT)
	}
	
	@Test def void testCircularTypeParams_05() {
		'T extends Iterable<? extends T>'.mappedBy('CharSequence', 'String')
			.assertMapping('T', 'Iterable<?>'->OUT->OUT)
	}
	
	@Test def void testCircularTypeParams_06() {
		'T extends Iterable<T>'.mappedBy('CharSequence', 'String')
			.assertMapping('T', 'Iterable<Object>'->OUT->OUT)
	}
	
	@Test def void testCircularTypeParams_07() {
		'T extends Iterable<? super T>'.mappedBy('CharSequence', 'String')
			.assertMapping('T', 'Iterable<?>'->OUT->OUT)
	}
	
	@Test def void testCircularTypeParams_08() {
		'T extends org.eclipse.xtend.core.tests.typesystem.CharIterable<T>'.mappedBy('CharSequence', 'String')
			.assertMapping('T', 'CharIterable<CharSequence>'->OUT->OUT)
	}
	
	@Test def void testCircularTypeParams_09() {
		'T extends org.eclipse.xtend.core.tests.typesystem.CharIterable<? extends T>'.mappedBy('CharSequence', 'String')
			.assertMapping('T', 'CharIterable<? extends CharSequence>'->OUT->OUT)
	}
	
	@Test def void testCircularTypeParams_10() {
		'T extends Iterable<T>, T2 extends Iterable<T>'.mappedBy('CharSequence', 'String')
			.assertMapping('T', 'Iterable<Object>'->OUT->OUT)
			.assertMapping('T2', 'Iterable<Iterable<Object>>'->OUT->OUT)
	}
	
	@Test def void testCircularTypeParams_11() {
		'T extends (Object)=>T'.mappedBy('T', 'Object')
			.assertMapping('T', 'Object'->OUT->OUT)
	}
	
	@Test def void testCircularTypeParams_12() {
		'T extends (Object)=>T'.mappedBy('T', '(Object)=>Object')
			.assertMapping('T', '(Object)=>Object'->OUT->OUT)
	}
	
	@Test def void testCircularTypeParams_13() {
		'T extends T2, T2 extends T'.mappedBy('T2', 'String')
			.assertMapping('T', 'String'->OUT->OUT)
			.assertMapping('T2', 'String'->OUT->OUT)
	}
	
	@Test def void testCircularTypeParams_14() {
		'T extends T2, T2 extends T'.mappedBy('T', 'String')
			.assertMapping('T', 'String'->OUT->OUT)
			.assertMapping('T2', 'String'->OUT->OUT)
	}
}

abstract class MapType<T> implements Map<T, T> {} 
abstract class CharIterable<T extends CharSequence> implements Iterable<T> {}
abstract class RawIterable implements Iterable {}