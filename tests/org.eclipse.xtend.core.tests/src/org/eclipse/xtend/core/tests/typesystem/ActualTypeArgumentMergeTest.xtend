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
import org.eclipse.xtext.xbase.typesystem.references.LightweightBoundTypeArgument
import org.eclipse.xtext.xbase.typesystem.references.LightweightMergedBoundTypeArgument
import org.eclipse.xtext.xbase.typesystem.util.ActualTypeArgumentCollector
import org.eclipse.xtext.xbase.typesystem.util.BoundTypeArgumentMerger
import org.eclipse.xtext.xbase.typesystem.util.BoundTypeArgumentSource
import org.eclipse.xtext.xbase.typesystem.util.VarianceInfo
import org.junit.Test

import static org.eclipse.xtext.xbase.typesystem.util.VarianceInfo.*

/**
 * @author Sebastian Zarnekow
 */
class ActualTypeArgumentMergeTest extends AbstractTestingTypeReferenceOwner {

	@Inject
	extension IXtendJvmAssociations
	
	@Inject
	BoundTypeArgumentMerger merger

	def mappedBy(String typeParameters, String... alternatingTypeReferences) {
		// TODO synthesize unique variable names as soon as the function should be validated
		val signature = '''def «IF !typeParameters.nullOrEmpty»<«typeParameters»>«ENDIF» void method(«alternatingTypeReferences.join(null, ' p, ', ' p') [it]») {}'''
		val function = function(signature.toString)
		val operation = function.directlyInferredOperation
		val collector = new ActualTypeArgumentCollector(operation.typeParameters, BoundTypeArgumentSource::INFERRED, owner)
		for(i: (0..alternatingTypeReferences.size-1).withStep(2)) {
			collector.populateTypeParameterMapping(operation.parameters.get(i).parameterType.toLightweightTypeReference, operation.parameters.get(i+1).parameterType.toLightweightTypeReference)
		}
		return collector.typeParameterMapping
	}
	
	def merge(Map<JvmTypeParameter, List<LightweightBoundTypeArgument>> mapping, String typeParamName) {
		val allKeys = mapping.keySet
		for(key: allKeys) {
			if (key.simpleName == typeParamName) {
				val mappingData = mapping.get(key)
				return mapping->merger.merge(mappingData, owner)
			}
		}
		fail('''No mapping for «typeParamName» in «mapping.keySet.map[simpleName]»'''.toString)
	}
	
	def to(Pair<Map<JvmTypeParameter, List<LightweightBoundTypeArgument>>, LightweightMergedBoundTypeArgument> merged, String type, VarianceInfo variance) {
		if (type == null) {
			assertNull(merged.value)
		} else {
			assertEquals(type, merged.value.typeReference.toString)
			assertEquals(variance, merged.value.variance)
		}
		merged.key
	}
	
	@Test def void testUnusedParam() {
		'T'.mappedBy('CharSequence', 'String').merge('T').to('Object', INVARIANT)
	}
	
	@Test def void testUnusedParams_01() {
		'T, T2'.mappedBy('CharSequence', 'String')
			.merge('T').to('Object', INVARIANT)
			.merge('T2').to('Object', INVARIANT)
	}
	
	@Test def void testUnusedParams_02() {
		'T extends CharSequence, T2'.mappedBy('CharSequence', 'String')
			.merge('T').to('CharSequence', INVARIANT)
			.merge('T2').to('Object', INVARIANT)
	}
	
	@Test def void testUnusedParams_03() {
		'T extends CharSequence, T2 extends T'.mappedBy('CharSequence', 'String')
			.merge('T').to('CharSequence', INVARIANT)
			.merge('T2').to('CharSequence', INVARIANT)
	}
	
	@Test def void testUnusedParams_04() {
		'T extends T2, T2'.mappedBy('CharSequence', 'String')
			.merge('T').to('Object', INVARIANT)
			.merge('T2').to('Object', INVARIANT)
	}
	
	@Test def void testUnusedParams_05() {
		'T extends T2, T2 extends CharSequence'.mappedBy('CharSequence', 'String')
			.merge('T').to('Object', INVARIANT) // forward references are ignored since they are invalid anyway
			.merge('T2').to('CharSequence', INVARIANT)
	}
	
	@Test def void testUnambiguousMapping_01() {
		'T'.mappedBy('java.util.List<T>', 'java.util.List<String>').merge('T').to('String', INVARIANT)
	}
	
	@Test def void testUnambiguousMapping_02() {
		'T'.mappedBy('java.util.Map<T, T>', 'java.util.Map<String, String>').merge('T').to('String', INVARIANT)
	}
	
	@Test def void testUnambiguousMapping_03() {
		'K, V'.mappedBy('java.util.Map<K, V>', 'java.util.Map<String, Integer>')
			.merge('K').to('String', INVARIANT)
			.merge('V').to('Integer', INVARIANT)
	}
	
	@Test def void testUnambiguousMapping_04() {
		'T'.mappedBy('T', 'CharSequence', 'T', 'CharSequence')
			.merge('T').to('CharSequence', INVARIANT)
	}
	
	@Test def void testUnambiguousMapping_05() {
		'T, T2'.mappedBy('T', 'CharSequence', 'T2', 'CharSequence')
			.merge('T').to('CharSequence', INVARIANT)
			.merge('T2').to('CharSequence', INVARIANT)
	}
	
	@Test def void testUsedTwice_01() {
		'T'.mappedBy('T', 'CharSequence', 'T', 'String')
			.merge('T').to('CharSequence', INVARIANT)
	}
	
	@Test def void testUsedTwice_02() {
		'T'.mappedBy('T', 'String', 'T', 'CharSequence')
			.merge('T').to('CharSequence', INVARIANT)
	}
	
	@Test def void testUsedTwice_03() {
		'T'.mappedBy('T', 'String', 'Iterable<T>', 'Iterable<String>')
			.merge('T').to('String', INVARIANT)
	}
	
	@Test def void testUsedTwice_04() {
		'T'.mappedBy('T', 'String', 'Iterable<T>', 'Iterable<CharSequence>')
			.merge('T').to('CharSequence', INVARIANT)
	}
	
	@Test def void testUsedTwice_05() {
		'T'.mappedBy('T', 'CharSequence', 'Iterable<T>', 'Iterable<String>')
			.merge('T').to('String', INVARIANT)
	}
	
	@Test def void testUsedTwice_06() {
		'T'.mappedBy('Iterable<T>', 'Iterable<CharSequence>', 'Iterable<T>', 'Iterable<String>')
			.merge('T').to('CharSequence', INVARIANT)
	}
	
	@Test def void testUsedTwice_07() {
		'T'.mappedBy('Iterable<T>', 'Iterable<String>', 'Iterable<T>', 'Iterable<CharSequence>')
			.merge('T').to('String', INVARIANT)
	}
	
	@Test def void testUsedTwice_08() {
		'T'.mappedBy('Iterable<T>', 'Iterable<? extends CharSequence>', 'Iterable<T>', 'Iterable<? extends CharSequence>')
			.merge('T').to('CharSequence', null)
	}
	
	@Test def void testUsedTwice_09() {
		'T'.mappedBy('T', 'String', 'Iterable<T>', 'Iterable<? extends CharSequence>')
			.merge('T').to('CharSequence', null)
	}
	
	@Test def void testUsedTwice_10() {
		'T'.mappedBy('T', 'CharSequence', 'Iterable<? extends T>', 'Iterable<String>')
			.merge('T').to('CharSequence', INVARIANT)
	}
	
	@Test def void testUsedTwice_11() {
		'T'.mappedBy('T', 'CharSequence', 'Iterable<? super T>', 'Iterable<String>')
			.merge('T').to('CharSequence', null)
	}
	
	@Test def void testUsedTwice_12() {
		// We used to infer CharSequence where JDT found String to be a better match
		// Former assumptions about CharSequence to be a better match became obsolete so
		// we now infer 'String' here, too 
		'T'.mappedBy('T', 'String', 'Iterable<? super T>', 'Iterable<CharSequence>')
			.merge('T').to('String', INVARIANT) 
	}
	
	@Test def void testUsedTwice_13() {
		'T'.mappedBy('Iterable<? super T>', 'Iterable<String>', 'Iterable<? super T>', 'Iterable<CharSequence>')
			.merge('T').to('String', INVARIANT)
	}
	
	@Test def void testUsedTwice_14() {
		'T'.mappedBy('Iterable<? super T>', 'Iterable<CharSequence>', 'Iterable<? super T>', 'Iterable<String>')
			.merge('T').to('String', INVARIANT)
	}
	
	@Test def void testBestEffortMapping_01() {
		'T'.mappedBy('java.util.List<T>', 'java.util.Set<String>')
			.merge('T').to('String', INVARIANT)
	}
	
	@Test def void testBestEffortMapping_02() {
		'T'.mappedBy('java.util.ArrayList<T>', 'java.util.HashSet<String>')
			.merge('T').to('String', INVARIANT)
	}
	
	@Test def void testBestEffortMapping_03() {
		'T'.mappedBy('java.util.ArrayList<T>', 'Iterable<String>')
			.merge('T').to('String', INVARIANT)
	}
	
	@Test def void testBestEffortMapping_04() {
		'T'.mappedBy('java.util.HashMap<java.util.ArrayList<T>, java.util.ArrayList<T>>', 'java.util.Map<Iterable<String>, java.util.HashSet<Integer>>')
			.merge('T').to('String', INVARIANT)
	}
	
	@Test def void testBestEffortMapping_05() {
		'T'.mappedBy('java.util.HashMap<java.util.ArrayList<T>, java.util.ArrayList<T>>', 'java.util.Map<Iterable<Integer>, java.util.HashSet<String>>')
			.merge('T').to('Integer', INVARIANT)
	}
	
	@Test def void testBestEffortMapping_06() {
		'T'.mappedBy('org.eclipse.xtend.core.tests.typesystem.MapType<T>', 'java.util.HashMap<String, Integer>')
			.merge('T').to('String', INVARIANT)
	}
	
	@Test def void testBestEffortMapping_07() {
		'T'.mappedBy('org.eclipse.xtend.core.tests.typesystem.MapType<T>', 'java.util.HashMap<Integer, String>')
			.merge('T').to('Integer', INVARIANT)
	}
	
	@Test def void testInheritanceMapping_01() {
		'E'.mappedBy('Iterable<E>', 'java.util.ArrayList<String>')
			.merge('E').to('String', INVARIANT)
	}
	
	@Test def void testInheritanceMapping_02() {
		'C'.mappedBy('Comparable<C>', 'String')
			.merge('C').to('String', INVARIANT)
	}
	
	@Test def void testMappedGenericType_01() {
		'T'.mappedBy('Iterable<T>', 'Iterable<Iterable<String>>')
			.merge('T').to('Iterable<String>', INVARIANT)
	}
	
	@Test def void testMappedArray_01() {
		'T'.mappedBy('T[]', 'String[]')
			.merge('T').to('String', INVARIANT)
	}
	
	@Test def void testMappedArray_02() {
		'T'.mappedBy('T[]', 'String[][]')
			.merge('T').to('String[]', INVARIANT)
	}
	
	@Test def void testUpperBound_01() {
		'T'.mappedBy('Iterable<? extends T>', 'Iterable<String>')
			.merge('T').to('String', INVARIANT)
	}
	
	@Test def void testUpperBound_02() {
		'T'.mappedBy('Iterable<? extends T>', 'Iterable<? extends String>')
			.merge('T').to('String', INVARIANT)
	}
	
	@Test def void testUpperBound_03() {
		'T'.mappedBy('Iterable<? extends T>', 'Iterable<? super String>')
			.merge('T').to('Object', INVARIANT)
	}
	
	@Test def void testUpperBound_04() {
		'T'.mappedBy('Iterable<T>', 'Iterable<? extends String>')
			.merge('T').to('String', OUT)
	}
	
	@Test def void testUpperBound_05() {
		'T'.mappedBy('Iterable<Iterable<T>>', 'Iterable<Iterable<? extends CharSequence>>')
			.merge('T').to('CharSequence', OUT)
	}
	
	@Test def void testUpperBound_06() {
		'T'.mappedBy('Iterable<T>', 'Iterable<Iterable<? extends CharSequence>>')
			.merge('T').to('Iterable<? extends CharSequence>', INVARIANT)
	}
	
	@Test def void testUpperBound_07() {
		'T'.mappedBy('Iterable<? extends Iterable<T>>', 'Iterable<Iterable<? extends CharSequence>>')
			.merge('T').to('CharSequence', OUT)
	}
	
	@Test def void testUpperBound_08() {
		'T'.mappedBy('Iterable<? extends Iterable<T>>', 'Iterable<Iterable<CharSequence>>')
			.merge('T').to('CharSequence', INVARIANT)
	}
	
	@Test def void testUpperBound_09() {
		'T'.mappedBy('Iterable<? extends Iterable<T>>', 'Iterable<? extends Iterable<CharSequence>>')
			.merge('T').to('CharSequence', INVARIANT)
	}
	
	@Test def void testUpperBound_10() {
		'T'.mappedBy('Iterable<? extends Iterable<T>>', 'Iterable<? super Iterable<CharSequence>>')
			.merge('T').to('CharSequence', INVARIANT)
	}
	
	@Test def void testUpperBound_11() {
		'T'.mappedBy('java.util.Map<? extends T, ? extends T>', 'java.util.Map<String, Integer>')
			.merge('T').to('Comparable<?> & Serializable', INVARIANT)
	}
	
	@Test def void testLowerBound_01() {
		'T'.mappedBy('Iterable<? super T>', 'Iterable<String>')
			.merge('T').to('String', INVARIANT)
	}
	
	@Test def void testLowerBound_02() {
		'T'.mappedBy('Iterable<? super T>', 'Iterable<? super String>')
			.merge('T').to('String', INVARIANT)
	}
	
	@Test def void testLowerBound_03() {
		'T'.mappedBy('Iterable<? super T>', 'Iterable<? extends String>')
			.merge('T').to('String', null)
	}
	
	@Test def void testLowerBound_04() {
		'T, T2 extends T'.mappedBy('Iterable<? super T>', 'Iterable<? extends String>')
			.merge('T').to('String', null)
			.merge('T2').to('String', null)
	}
	
	@Test def void testLowerBound_05() {
		'T, T2 extends T'.mappedBy('java.util.Map<? super T, T>', 'java.util.Map<? extends String, Integer>')
			.merge('T').to('Integer', null)
			.merge('T2').to('Integer', null)
	}
	
	@Test def void testLowerBound_06() {
		'T'.mappedBy('Iterable<T>', 'Iterable<? super String>')
			.merge('T').to('String', IN)
	}
	
	@Test def void testLowerBound_07() {
		'T'.mappedBy('Iterable<Iterable<T>>', 'java.util.LinkedList<Iterable<? super String>>')
			.merge('T').to('String', IN)
	}
	
	@Test def void testLowerBound_08() {
		'T'.mappedBy('Iterable<T>', 'Iterable<Iterable<? super String>>')
			.merge('T').to('Iterable<? super String>', INVARIANT)
	}
	
	@Test def void testLowerBound_09() {
		'T extends T2, T2'.mappedBy('Iterable<? super T2>', 'Iterable<? extends String>')
			.merge('T').to('String', null)
			.merge('T2').to('String', null)
	}
	
	@Test def void testDependentTypeParams_01() {
		'T extends CharSequence, T2 extends T'.mappedBy('java.util.Map<T, T2>', 'java.util.Map<String, String>')
			.merge('T').to('String', INVARIANT)
			.merge('T2').to('String', INVARIANT)
	}
	
	@Test def void testDependentTypeParams_02() {
		'T, T2 extends T'.mappedBy('Iterable<T>', 'Iterable<String>')
			.merge('T').to('String', INVARIANT)
			.merge('T2').to('String', INVARIANT)
	}
	
	@Test def void testDependentTypeParams_03() {
		'T extends T2, T2 extends CharSequence'.mappedBy('Iterable<T2>', 'Iterable<String>')
			.merge('T').to('String', INVARIANT)
			.merge('T2').to('String', INVARIANT)
	}
	
	@Test def void testDependentTypeParams_04() {
		'T, T2 extends T, T3 extends T2'.mappedBy('java.util.Map<T, T3>', 'java.util.Map<String, Integer>')
			.merge('T').to('String', INVARIANT)
			.merge('T2').to('String', INVARIANT)
			.merge('T3').to('Integer', INVARIANT)
	}
	
	@Test def void testCircularTypeParams_01() {
		'T extends T'.mappedBy('String', 'String')
			.merge('T').to('Object', INVARIANT)
	}
	
	@Test def void testCircularTypeParams_02() {
		'T extends Iterable<T>'.mappedBy('CharSequence', 'String')
			.merge('T').to('Iterable<Object>', INVARIANT)
	}
	
	@Test def void testCircularTypeParams_03() {
		'T extends Iterable<T>'.mappedBy('T', 'java.util.List<String>')
			.merge('T').to('List<String>', INVARIANT)
	}
	
	@Test def void testCircularTypeParams_04() {
		'T extends Iterable<T>'.mappedBy('Iterable<? extends T>', 'java.util.List<String>')
			.merge('T').to('String', INVARIANT)
	}
	
	@Test def void testCircularTypeParams_05() {
		'T extends Iterable<? extends T>'.mappedBy('CharSequence', 'String')
			.merge('T').to('Iterable<?>', INVARIANT)
	}
	
	@Test def void testCircularTypeParams_06() {
		'T extends org.eclipse.xtend.core.tests.typesystem.CharIterable<T>'.mappedBy('CharSequence', 'String')
			.merge('T').to('CharIterable<CharSequence>', INVARIANT)
	}
	
	@Test def void testCircularTypeParams_07() {
		'T extends org.eclipse.xtend.core.tests.typesystem.CharIterable<? extends T>'.mappedBy('CharSequence', 'String')
			.merge('T').to('CharIterable<? extends CharSequence>', INVARIANT)
	}
	
	@Test def void testCircularTypeParams_08() {
		'T extends Iterable<T>, T2 extends Iterable<T>'.mappedBy('CharSequence', 'String')
			.merge('T').to('Iterable<Object>', INVARIANT)
			.merge('T2').to('Iterable<Iterable<Object>>', INVARIANT)
	}
	
}