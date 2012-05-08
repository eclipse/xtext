/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.typesystem

import com.google.inject.Inject
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations
import org.eclipse.xtend.core.tests.AbstractXtendTestCase
import org.eclipse.xtext.util.Triple
import org.eclipse.xtext.util.Tuples
import org.eclipse.xtext.xbase.lib.Pair
import org.eclipse.xtext.xbase.typesystem.util.BoundTypeArgument
import org.eclipse.xtext.xbase.typesystem.util.BoundTypeArgumentMerger
import org.eclipse.xtext.xbase.typesystem.util.MergedBoundTypeArgument
import org.eclipse.xtext.xbase.typesystem.util.VarianceInfo
import org.junit.Test

import static org.eclipse.xtext.xbase.typesystem.util.VarianceInfo.*
import static org.junit.Assert.*

/**
 * @author Sebastian Zarnekow
 */
class BoundTypeArgumentMergerTest extends AbstractXtendTestCase {

	@Inject
	extension IXtendJvmAssociations
	
	@Inject
	BoundTypeArgumentMerger merger

	def merge(Triple<String,VarianceInfo,VarianceInfo>... mergeUs) {
		mergeWithSource(null, mergeUs)
	}
	
	def mergeWithSource(Object source, Triple<String,VarianceInfo,VarianceInfo>... mergeUs) {
		// TODO synthesize unique variable names as soon as the function should be validated
		val signature = '''def void method(«mergeUs.join(null, ' p, ', ' p') [first]») {}'''
		val function = function(signature.toString)
		val operation = function.directlyInferredOperation
		val mergable = <BoundTypeArgument>newArrayList
		operation.parameters.forEach[ p, i |
			val input = mergeUs.get(i)
			mergable += new BoundTypeArgument(p.parameterType, null, source ?: new Object, input.second, input.third)
		]
		return merger.merge(mergable)
	}
	
	def to(MergedBoundTypeArgument merged, String type, VarianceInfo variance) {
		if (type == null) {
			assertNull(merged)
		} else {
			assertEquals(type, merged.typeReference.simpleName)
			assertEquals(variance, merged.variance)
		}
	}
	
	def operator_mappedTo(Pair<String, VarianceInfo> pair, VarianceInfo third) {
		Tuples::create(pair.key, pair.value, third)
	}
	
	@Test def void testNothingToMerge_01() {
		merge().to(null, null)
	}
	
	@Test def void testNothingToMerge_02() {
		merge('String'->INVARIANT->INVARIANT).to('String', INVARIANT)
		merge('String'->INVARIANT->OUT).to('String', OUT)
		merge('String'->INVARIANT->IN).to('String', IN)
	}
	
	@Test def void testNothingToMerge_03() {
		merge('String'->OUT->INVARIANT).to('String', INVARIANT)
		merge('String'->OUT->OUT).to('String', INVARIANT)
		merge('String'->OUT->IN).to('String', null)
	}
	
	@Test def void testNothingToMerge_04() {
		merge('String'->IN->INVARIANT).to('String', INVARIANT)
		merge('String'->IN->OUT).to('String', null)
		merge('String'->IN->IN).to('String', INVARIANT)
	}
	
	@Test def void testArgumentTypeUsedTwiceDifferentTypes_01() {
		merge('String'->INVARIANT->INVARIANT, 'Integer'->INVARIANT->INVARIANT).to('String', INVARIANT)
		merge('Integer'->INVARIANT->INVARIANT, 'String'->INVARIANT->INVARIANT).to('Integer', INVARIANT)
	}
	
	@Test def void testArgumentTypeUsedTwice_01_a() {
		merge('String'->INVARIANT->INVARIANT, 'String'->INVARIANT->INVARIANT).to('String', INVARIANT)
	}
	
	@Test def void testArgumentTypeUsedTwice_01_b() {	
		merge('String'->INVARIANT->OUT, 'String'->INVARIANT->INVARIANT).to('String', null)
	}
	
	@Test def void testArgumentTypeUsedTwice_01_c() {	
		merge('String'->INVARIANT->IN, 'String'->INVARIANT->INVARIANT).to('String', null)
	}
	
	@Test def void testArgumentTypeUsedTwice_01_d() {
		merge('String'->INVARIANT->INVARIANT, 'String'->INVARIANT->OUT).to('String', null)
	}
	
	@Test def void testArgumentTypeUsedTwice_01_e() {	
		merge('String'->INVARIANT->OUT, 'String'->INVARIANT->OUT).to('String', null)
	}
	
	@Test def void testArgumentTypeUsedTwice_01_f() {	
		merge('String'->INVARIANT->IN, 'String'->INVARIANT->OUT).to('String', null)
	}
	
	@Test def void testArgumentTypeUsedTwice_01_g() {
		merge('String'->INVARIANT->INVARIANT, 'String'->INVARIANT->IN).to('String', null)
	}
	
	@Test def void testArgumentTypeUsedTwice_01_h() {
		merge('String'->INVARIANT->OUT, 'String'->INVARIANT->IN).to('String', null)
	}
	
	@Test def void testArgumentTypeUsedTwice_01_i() {
		merge('String'->INVARIANT->IN, 'String'->INVARIANT->IN).to('String', null)
	}
	
	@Test def void testArgumentTypeUsedTwice_02_a() {
		merge('String'->INVARIANT->INVARIANT, 'String'->OUT->INVARIANT).to('String', INVARIANT)
	}
	
	@Test def void testArgumentTypeUsedTwice_02_b() {
		merge('String'->INVARIANT->OUT, 'String'->OUT->INVARIANT).to('String', null)
	}
	
	@Test def void testArgumentTypeUsedTwice_02_c() {
		merge('String'->INVARIANT->IN, 'String'->OUT->INVARIANT).to('String', IN)
	}
	
	@Test def void testArgumentTypeUsedTwice_02_d() {
		merge('String'->INVARIANT->INVARIANT, 'String'->OUT->OUT).to('String', INVARIANT)
	}
	
	@Test def void testArgumentTypeUsedTwice_02_e() {
		merge('String'->INVARIANT->OUT, 'String'->OUT->OUT).to('String', null)
	}
	
	@Test def void testArgumentTypeUsedTwice_02_f() {
		merge('String'->INVARIANT->IN, 'String'->OUT->OUT).to('String', IN)
	}
	
	@Test def void testArgumentTypeUsedTwice_02_g() {
		merge('String'->INVARIANT->INVARIANT, 'String'->OUT->IN).to('String', null)
	}
	
	@Test def void testArgumentTypeUsedTwice_02_h() {
		merge('String'->INVARIANT->OUT, 'String'->OUT->IN).to('String', null)
	}
	
	@Test def void testArgumentTypeUsedTwice_02_i() {
		merge('String'->INVARIANT->IN, 'String'->OUT->IN).to('String', null)
	}
	
	@Test def void testArgumentTypeUsedTwice_03_a() {
		merge('String'->INVARIANT->INVARIANT, 'String'->IN->INVARIANT).to('String', INVARIANT)
	}
	
	@Test def void testArgumentTypeUsedTwice_03_b() {
		merge('String'->INVARIANT->OUT, 'String'->IN->INVARIANT).to('String', OUT)
	}
	
	@Test def void testArgumentTypeUsedTwice_03_c() {
		merge('String'->INVARIANT->IN, 'String'->IN->INVARIANT).to('String', null)
	}
	
	@Test def void testArgumentTypeUsedTwice_03_d() {
		merge('String'->INVARIANT->INVARIANT, 'String'->IN->OUT).to('String', null)
	}
	
	@Test def void testArgumentTypeUsedTwice_03_e() {
		merge('String'->INVARIANT->OUT, 'String'->IN->OUT).to('String', null)
	}
	
	@Test def void testArgumentTypeUsedTwice_03_f() {
		merge('String'->INVARIANT->IN, 'String'->IN->OUT).to('String', null)
	}
	
	@Test def void testArgumentTypeUsedTwice_03_g() {
		merge('String'->INVARIANT->INVARIANT, 'String'->IN->IN).to('String', INVARIANT)
	}
	
	@Test def void testArgumentTypeUsedTwice_03_h() {
		merge('String'->INVARIANT->OUT, 'String'->IN->IN).to('String', OUT)
	}
	
	@Test def void testArgumentTypeUsedTwice_03_i() {
		merge('String'->INVARIANT->IN, 'String'->IN->IN).to('String', null)
	}
	
	@Test def void testArgumentTypeUsedTwice_04_a() {
		merge('String'->OUT->INVARIANT, 'String'->INVARIANT->INVARIANT).to('String', INVARIANT)
	}
	
	@Test def void testArgumentTypeUsedTwice_04_b() {
		merge('String'->OUT->OUT, 'String'->INVARIANT->INVARIANT).to('String', INVARIANT)
	}
	
	@Test def void testArgumentTypeUsedTwice_04_c() {
		merge('String'->OUT->IN, 'String'->INVARIANT->INVARIANT).to('String', null)
	}
	
	@Test def void testArgumentTypeUsedTwice_04_d() {
		merge('String'->OUT->INVARIANT, 'String'->INVARIANT->OUT).to('String', null)
	}
	
	@Test def void testArgumentTypeUsedTwice_04_e() {
		merge('String'->OUT->OUT, 'String'->INVARIANT->OUT).to('String', null)
	}
	
	@Test def void testArgumentTypeUsedTwice_04_f() {
		merge('String'->OUT->IN, 'String'->INVARIANT->OUT).to('String', null)
	}
	
	@Test def void testArgumentTypeUsedTwice_04_g() {
		merge('String'->OUT->INVARIANT, 'String'->INVARIANT->IN).to('String', IN)
	}
	
	@Test def void testArgumentTypeUsedTwice_04_h() {
		merge('String'->OUT->OUT, 'String'->INVARIANT->IN).to('String', IN)
	}
	
	@Test def void testArgumentTypeUsedTwice_04_i() {
		merge('String'->OUT->IN, 'String'->INVARIANT->IN).to('String', null)
	}
	
	@Test def void testArgumentTypeUsedTwice_05_a() {
		merge('String'->IN->INVARIANT, 'String'->INVARIANT->INVARIANT).to('String', INVARIANT)
	}
	
	@Test def void testArgumentTypeUsedTwice_05_b() {
		merge('String'->IN->OUT, 'String'->INVARIANT->INVARIANT).to('String', null)
	}
	
	@Test def void testArgumentTypeUsedTwice_05_c() {
		merge('String'->IN->IN, 'String'->INVARIANT->INVARIANT).to('String', INVARIANT)
	}
	
	@Test def void testArgumentTypeUsedTwice_05_d() {
		merge('String'->IN->INVARIANT, 'String'->INVARIANT->OUT).to('String', OUT)
	}
	
	@Test def void testArgumentTypeUsedTwice_05_e() {
		merge('String'->IN->OUT, 'String'->INVARIANT->OUT).to('String', null)
	}
	
	@Test def void testArgumentTypeUsedTwice_05_f() {
		merge('String'->IN->IN, 'String'->INVARIANT->OUT).to('String', OUT)
	}
	
	@Test def void testArgumentTypeUsedTwice_05_g() {
		merge('String'->IN->INVARIANT, 'String'->INVARIANT->IN).to('String', null)
	}
	
	@Test def void testArgumentTypeUsedTwice_05_h() {
		merge('String'->IN->OUT, 'String'->INVARIANT->IN).to('String', null)
	}
	
	@Test def void testArgumentTypeUsedTwice_05_i() {
		merge('String'->IN->IN, 'String'->INVARIANT->IN).to('String', null)
	}
	
	@Test def void testArgumentTypeUsedTwice_06_a() {
		merge('String'->OUT->INVARIANT, 'String'->OUT->INVARIANT).to('String', INVARIANT)
	}
	
	@Test def void testArgumentTypeUsedTwice_06_b() {
		merge('String'->OUT->OUT, 'String'->OUT->INVARIANT).to('String', INVARIANT)
	}
	
	@Test def void testArgumentTypeUsedTwice_06_c() {
		merge('String'->OUT->IN, 'String'->OUT->INVARIANT).to('String', null)
	}
	
	@Test def void testArgumentTypeUsedTwice_06_d() {
		merge('String'->OUT->INVARIANT, 'String'->OUT->OUT).to('String', INVARIANT)
	}
	
	@Test def void testArgumentTypeUsedTwice_06_e() {
		merge('String'->OUT->OUT, 'String'->OUT->OUT).to('String', INVARIANT)
	}
	
	@Test def void testArgumentTypeUsedTwice_06_f() {
		merge('String'->OUT->IN, 'String'->OUT->OUT).to('String', null)
	}
	
	@Test def void testArgumentTypeUsedTwice_06_g() {
		merge('String'->OUT->INVARIANT, 'String'->OUT->IN).to('String', null)
	}
	
	@Test def void testArgumentTypeUsedTwice_06_h() {
		merge('String'->OUT->OUT, 'String'->OUT->IN).to('String', null)
	}
	
	@Test def void testArgumentTypeUsedTwice_06_i() {
		merge('String'->OUT->IN, 'String'->OUT->IN).to('String', null)
	}
	
	@Test def void testArgumentTypeUsedTwice_07_a() {
		merge('String'->IN->INVARIANT, 'String'->OUT->INVARIANT).to('String', INVARIANT)
	}
	
	@Test def void testArgumentTypeUsedTwice_07_b() {
		merge('String'->IN->OUT, 'String'->OUT->INVARIANT).to('String', null)
	}
	
	@Test def void testArgumentTypeUsedTwice_07_c() {
		merge('String'->IN->IN, 'String'->OUT->INVARIANT).to('String', INVARIANT)
	}
	
	@Test def void testArgumentTypeUsedTwice_07_d() {
		merge('String'->IN->INVARIANT, 'String'->OUT->OUT).to('String', INVARIANT)
	}
	
	@Test def void testArgumentTypeUsedTwice_07_e() {
		merge('String'->IN->OUT, 'String'->OUT->OUT).to('String', null)
	}
	
	@Test def void testArgumentTypeUsedTwice_07_f() {
		merge('String'->IN->IN, 'String'->OUT->OUT).to('String', INVARIANT)
	}
	
	@Test def void testArgumentTypeUsedTwice_07_g() {
		merge('String'->IN->INVARIANT, 'String'->OUT->IN).to('String', null)
	}
	
	@Test def void testArgumentTypeUsedTwice_07_h() {
		merge('String'->IN->OUT, 'String'->OUT->IN).to('String', null)
	}
	
	@Test def void testArgumentTypeUsedTwice_07_i() {
		merge('String'->IN->IN, 'String'->OUT->IN).to('String', null)
	}
	
	@Test def void testArgumentTypeUsedTwice_08_a() {
		merge('String'->OUT->INVARIANT, 'String'->IN->INVARIANT).to('String', INVARIANT)
	}
	
	@Test def void testArgumentTypeUsedTwice_08_b() {
		merge('String'->OUT->OUT, 'String'->IN->INVARIANT).to('String', INVARIANT)
	}
	
	@Test def void testArgumentTypeUsedTwice_08_c() {
		merge('String'->OUT->IN, 'String'->IN->INVARIANT).to('String', null)
	}
	
	@Test def void testArgumentTypeUsedTwice_08_d() {
		merge('String'->OUT->INVARIANT, 'String'->IN->OUT).to('String', null)
	}
	
	@Test def void testArgumentTypeUsedTwice_08_e() {
		merge('String'->OUT->OUT, 'String'->IN->OUT).to('String', null)
	}
	
	@Test def void testArgumentTypeUsedTwice_08_f() {
		merge('String'->OUT->IN, 'String'->IN->OUT).to('String', null)
	}
	
	@Test def void testArgumentTypeUsedTwice_08_g() {
		merge('String'->OUT->INVARIANT, 'String'->IN->IN).to('String', INVARIANT)
	}
	
	@Test def void testArgumentTypeUsedTwice_08_h() {
		merge('String'->OUT->OUT, 'String'->IN->IN).to('String', INVARIANT)
	}
	
	@Test def void testArgumentTypeUsedTwice_08_i() {
		merge('String'->OUT->IN, 'String'->IN->IN).to('String', null)
	}
	
	@Test def void testArgumentTypeUsedTwice_09_a() {
		merge('String'->IN->INVARIANT, 'String'->IN->INVARIANT).to('String', INVARIANT)
	}
	
	@Test def void testArgumentTypeUsedTwice_09_b() {
		merge('String'->IN->OUT, 'String'->IN->INVARIANT).to('String', null)
	}
	
	@Test def void testArgumentTypeUsedTwice_09_c() {
		merge('String'->IN->IN, 'String'->IN->INVARIANT).to('String', INVARIANT)
	}
	
	@Test def void testArgumentTypeUsedTwice_09_d() {
		merge('String'->IN->INVARIANT, 'String'->IN->OUT).to('String', null)
	}
	
	@Test def void testArgumentTypeUsedTwice_09_e() {
		merge('String'->IN->OUT, 'String'->IN->OUT).to('String', null)
	}
	
	@Test def void testArgumentTypeUsedTwice_09_f() {
		merge('String'->IN->IN, 'String'->IN->OUT).to('String', null)
	}
	
	@Test def void testArgumentTypeUsedTwice_09_g() {
		merge('String'->IN->INVARIANT, 'String'->IN->IN).to('String', INVARIANT)
	}
	
	@Test def void testArgumentTypeUsedTwice_09_h() {
		merge('String'->IN->OUT, 'String'->IN->IN).to('String', null)
	}
	
	@Test def void testArgumentTypeUsedTwice_09_i() {
		merge('String'->IN->IN, 'String'->IN->IN).to('String', INVARIANT)
	}
	
	@Test def void testValidityPrecedence_01() {
		mergeWithSource(new Object(), 'Object'->OUT->OUT, 'String'->OUT->IN).to('Object', INVARIANT)
	}
	
//	
//	@Test def void testNoParams_02() {
//		assertTrue(''.mappedBy('java.util.List<?>', 'java.util.ArrayList<String>').empty)
//	}
//	
//	@Test def void testUnusedParam() {
//		'T'.mappedBy('CharSequence', 'String').assertMapping('T', 'Object'->OUT->OUT)
//	}
//	
//	@Test def void testUnusedParams_01() {
//		'T, T2'.mappedBy('CharSequence', 'String')
//			.assertMapping('T', 'Object'->OUT->OUT)
//			.assertMapping('T2', 'Object'->OUT->OUT)
//	}
//	
//	@Test def void testUnusedParams_02() {
//		'T extends CharSequence, T2'.mappedBy('CharSequence', 'String')
//			.assertMapping('T', 'CharSequence'->OUT->OUT)
//			.assertMapping('T2', 'Object'->OUT->OUT)
//	}
//	
//	@Test def void testUnusedParams_03() {
//		'T extends CharSequence, T2 extends T'.mappedBy('CharSequence', 'String')
//			.assertMapping('T', 'CharSequence'->OUT->OUT)
//			.assertMapping('T2', 'CharSequence'->OUT->OUT)
//	}
//	
//	@Test def void testUnusedParams_04() {
//		'T extends T2, T2'.mappedBy('CharSequence', 'String')
//			.assertMapping('T', 'Object'->OUT->OUT)
//			.assertMapping('T2', 'Object'->OUT->OUT)
//	}
//	
//	@Test def void testUnusedParams_05() {
//		'T extends T2, T2 extends CharSequence'.mappedBy('CharSequence', 'String')
//			.assertMapping('T', 'Object'->OUT->OUT)
//			.assertMapping('T2', 'CharSequence'->OUT->OUT)
//	}
//	
//	@Test def void testUnambiguousMapping_01() {
//		'T'.mappedBy('java.util.List<T>', 'java.util.List<String>').assertMapping('T', 'String'->INVARIANT->INVARIANT)
//	}
//	
//	@Test def void testUnambiguousMapping_02() {
//		'T'.mappedBy('java.util.Map<T, T>', 'java.util.Map<String, String>').assertMapping('T', 'String'->INVARIANT->INVARIANT, 'String'->INVARIANT->INVARIANT)
//	}
//	
//	@Test def void testUnambiguousMapping_03() {
//		'K, V'.mappedBy('java.util.Map<K, V>', 'java.util.Map<String, Integer>')
//			.assertMapping('K', 'String'->INVARIANT->INVARIANT)
//			.assertMapping('V', 'Integer'->INVARIANT->INVARIANT)
//	}
//	
//	@Test def void testUnambiguousMapping_04() {
//		'T'.mappedBy('T', 'CharSequence', 'T', 'CharSequence')
//			.assertMapping('T', 'CharSequence'->OUT->OUT, 'CharSequence'->OUT->OUT)
//	}
//	
//	@Test def void testUnambiguousMapping_05() {
//		'T, T2'.mappedBy('T', 'CharSequence', 'T2', 'CharSequence')
//			.assertMapping('T', 'CharSequence'->OUT->OUT)
//			.assertMapping('T2', 'CharSequence'->OUT->OUT)
//	}
//	
//	@Test def void testUsedTwice_01() {
//		'T'.mappedBy('T', 'CharSequence', 'T', 'String')
//			.assertMapping('T', 'CharSequence'->OUT->OUT, 'String'->OUT->OUT)
//	}
//	
//	@Test def void testUsedTwice_02() {
//		'T'.mappedBy('T', 'String', 'T', 'CharSequence')
//			.assertMapping('T', 'String'->OUT->OUT, 'CharSequence'->OUT->OUT)
//	}
//	
//	@Test def void testBestEffortMapping_01() {
//		'T'.mappedBy('java.util.List<T>', 'java.util.Set<String>').assertMapping('T', 'String'->INVARIANT->INVARIANT)
//	}
//	
//	@Test def void testBestEffortMapping_02() {
//		'T'.mappedBy('java.util.ArrayList<T>', 'java.util.HashSet<String>').assertMapping('T', 'String'->INVARIANT->INVARIANT)
//	}
//	
//	@Test def void testBestEffortMapping_03() {
//		'T'.mappedBy('java.util.ArrayList<T>', 'Iterable<String>').assertMapping('T', 'String'->INVARIANT->INVARIANT)
//	}
//	
//	@Test def void testBestEffortMapping_04() {
//		'T'.mappedBy('java.util.HashMap<java.util.ArrayList<T>, java.util.ArrayList<T>>', 'java.util.Map<Iterable<String>, java.util.HashSet<Integer>>')
//			.assertMapping('T', 'String'->INVARIANT->INVARIANT, 'Integer'->INVARIANT->INVARIANT)
//	}
//	
//	@Test def void testBestEffortMapping_05() {
//		'T'.mappedBy('org.eclipse.xtend.core.tests.typesystem.MapType<T>', 'java.util.HashMap<String, Integer>')
//			.assertMapping('T', 'String'->INVARIANT->INVARIANT, 'Integer'->INVARIANT->INVARIANT)
//	}
//	
//	@Test def void testInheritanceMapping_01() {
//		'E'.mappedBy('Iterable<E>', 'java.util.ArrayList<String>')
//			.assertMapping('E', 'String'->INVARIANT->INVARIANT)
//	}
//	
//	@Test def void testInheritanceMapping_02() {
//		'C'.mappedBy('Comparable<C>', 'String')
//			.assertMapping('C', 'String'->INVARIANT->INVARIANT)
//	}
//	
//	@Test def void testMappedGenericType_01() {
//		'T'.mappedBy('Iterable<T>', 'Iterable<Iterable<String>>').assertMapping('T', 'Iterable<String>'->INVARIANT->INVARIANT)
//	}
//	
//	@Test def void testMappedArray_01() {
//		'T'.mappedBy('T[]', 'String[]').assertMapping('T', 'String'->OUT->OUT)
//	}
//	
//	@Test def void testMappedArray_02() {
//		'T'.mappedBy('T[]', 'String[][]').assertMapping('T', 'String[]'->OUT->OUT)
//	}
//	
//	@Test def void testUpperBound_01() {
//		'T'.mappedBy('Iterable<? extends T>', 'Iterable<String>').assertMapping('T', 'String'->OUT->INVARIANT)
//	}
//	
//	@Test def void testUpperBound_02() {
//		'T'.mappedBy('Iterable<? extends T>', 'Iterable<? extends String>').assertMapping('T', 'String'->OUT->OUT)
//	}
//	
//	@Test def void testUpperBound_03() {
//		'T'.mappedBy('Iterable<? extends T>', 'Iterable<? super String>').assertMapping('T', 'Object'->OUT->OUT, 'String'->OUT->IN)
//	}
//	
//	@Test def void testUpperBound_04() {
//		'T'.mappedBy('Iterable<T>', 'Iterable<? extends String>').assertMapping('T', 'String'->INVARIANT->OUT)
//	}
//	
//	@Test def void testUpperBound_05() {
//		'T'.mappedBy('Iterable<Iterable<T>>', 'Iterable<Iterable<? extends CharSequence>>').assertMapping('T', 'CharSequence'->INVARIANT->OUT)
//	}
//	
//	@Test def void testUpperBound_06() {
//		'T'.mappedBy('Iterable<T>', 'Iterable<Iterable<? extends CharSequence>>').assertMapping('T', 'Iterable<? extends CharSequence>'->INVARIANT->INVARIANT)
//	}
//	
//	@Test def void testUpperBound_07() {
//		'T'.mappedBy('Iterable<? extends Iterable<T>>', 'Iterable<Iterable<? extends CharSequence>>').assertMapping('T', 'CharSequence'->INVARIANT->OUT)
//	}
//	
//	@Test def void testUpperBound_08() {
//		'T'.mappedBy('Iterable<? extends Iterable<T>>', 'Iterable<Iterable<CharSequence>>').assertMapping('T', 'CharSequence'->INVARIANT->INVARIANT)
//	}
//	
//	@Test def void testUpperBound_09() {
//		'T'.mappedBy('Iterable<? extends Iterable<T>>', 'Iterable<? extends Iterable<CharSequence>>').assertMapping('T', 'CharSequence'->INVARIANT->INVARIANT)
//	}
//	
//	@Test def void testUpperBound_10() {
//		'T'.mappedBy('Iterable<? extends Iterable<T>>', 'Iterable<? super Iterable<CharSequence>>').assertMapping('T', 'CharSequence'->INVARIANT->INVARIANT)
//	}
//	
//	@Test def void testUpperBound_11() {
//		'T'.mappedBy('java.util.Map<? extends T, ? extends T>', 'java.util.Map<String, Integer>').assertMapping('T', 'String'->OUT->INVARIANT, 'Integer'->OUT->INVARIANT)
//	}
//	
//	@Test def void testLowerBound_01() {
//		'T'.mappedBy('Iterable<? super T>', 'Iterable<String>').assertMapping('T', 'String'->IN->INVARIANT)
//	}
//	
//	@Test def void testLowerBound_02() {
//		'T'.mappedBy('Iterable<? super T>', 'Iterable<? super String>').assertMapping('T', 'String'->IN->IN)
//	}
//	
//	@Test def void testLowerBound_03() {
//		'T'.mappedBy('Iterable<? super T>', 'Iterable<? extends String>').assertMapping('T', 'String'->IN->OUT)
//	}
//	
//	@Test def void testLowerBound_04() {
//		'T, T2 extends T'.mappedBy('Iterable<? super T>', 'Iterable<? extends String>')
//			.assertMapping('T', 'String'->IN->OUT)
//			.assertMapping('T2', 'String'->IN->OUT)
//	}
//	
//	@Test def void testLowerBound_05() {
//		'T, T2 extends T'.mappedBy('java.util.Map<? super T, T>', 'java.util.Map<? extends String, Integer>')
//			.assertMapping('T', 'String'->IN->OUT, 'Integer'->INVARIANT->INVARIANT)
//			.assertMapping('T2', 'String'->IN->OUT, 'Integer'->INVARIANT->INVARIANT)
//	}
//	
//	@Test def void testLowerBound_06() {
//		'T'.mappedBy('Iterable<T>', 'Iterable<? super String>').assertMapping('T', 'String'->INVARIANT->IN)
//	}
//	
//	@Test def void testLowerBound_07() {
//		'T'.mappedBy('Iterable<Iterable<T>>', 'java.util.LinkedList<Iterable<? super String>>').assertMapping('T', 'String'->INVARIANT->IN)
//	}
//	
//	@Test def void testLowerBound_08() {
//		'T'.mappedBy('Iterable<T>', 'Iterable<Iterable<? super String>>').assertMapping('T', 'Iterable<? super String>'->INVARIANT->INVARIANT)
//	}
//	
//	@Test def void testLowerBound_09() {
//		'T extends T2, T2'.mappedBy('Iterable<? super T2>', 'Iterable<? extends String>')
//			.assertMapping('T', 'String'->IN->OUT)
//			.assertMapping('T2', 'String'->IN->OUT)
//	}
//	
//	@Test def void testDependentTypeParams_01() {
//		'T extends CharSequence, T2 extends T'.mappedBy('java.util.Map<T, T2>', 'java.util.Map<String, String>')
//			.assertMapping('T', 'String'->INVARIANT->INVARIANT)
//			.assertMapping('T2', 'String'->INVARIANT->INVARIANT)
//	}
//	
//	@Test def void testDependentTypeParams_02() {
//		'T, T2 extends T'.mappedBy('Iterable<T>', 'Iterable<String>')
//			.assertMapping('T', 'String'->INVARIANT->INVARIANT)
//			.assertMapping('T2', 'String'->INVARIANT->INVARIANT)
//	}
//	
//	@Test def void testDependentTypeParams_03() {
//		'T extends T2, T2 extends CharSequence'.mappedBy('Iterable<T2>', 'Iterable<String>')
//			.assertMapping('T', 'String'->INVARIANT->INVARIANT)
//			.assertMapping('T2', 'String'->INVARIANT->INVARIANT)
//	}
//	
//	@Test def void testDependentTypeParams_04() {
//		'T, T2 extends T, T3 extends T2'.mappedBy('java.util.Map<T, T3>', 'java.util.Map<String, Integer>')
//			.assertMapping('T', 'String'->INVARIANT->INVARIANT)
//			.assertMapping('T2', 'String'->INVARIANT->INVARIANT)
//			.assertMapping('T3', 'Integer'->INVARIANT->INVARIANT)
//	}
//	
//	@Test def void testCircularTypeParams_01() {
//		'T extends T'.mappedBy('String', 'String')
//			.assertMapping('T', 'Object'->OUT->OUT)
//	}
//	
//	@Test def void testCircularTypeParams_02() {
//		'T extends Iterable<T>'.mappedBy('CharSequence', 'String')
//			.assertMapping('T', 'Iterable<Object>'->OUT->OUT)
//	}
//	
//	@Test def void testCircularTypeParams_03() {
//		'T extends Iterable<T>'.mappedBy('T', 'java.util.List<String>')
//			.assertMapping('T', 'List<String>'->OUT->OUT)
//	}
//	
//	@Test def void testCircularTypeParams_04() {
//		'T extends Iterable<T>'.mappedBy('Iterable<? extends T>', 'java.util.List<String>')
//			.assertMapping('T', 'String'->OUT->INVARIANT)
//	}
//	
//	@Test def void testCircularTypeParams_05() {
//		'T extends Iterable<? extends T>'.mappedBy('CharSequence', 'String')
//			.assertMapping('T', 'Iterable<Object>'->OUT->OUT)
//	}
//	
//	@Test def void testCircularTypeParams_06() {
//		'T extends org.eclipse.xtend.core.tests.typesystem.CharIterable<T>'.mappedBy('CharSequence', 'String')
//			.assertMapping('T', 'CharIterable<CharSequence>'->OUT->OUT)
//	}
//	
//	@Test def void testCircularTypeParams_07() {
//		'T extends org.eclipse.xtend.core.tests.typesystem.CharIterable<? extends T>'.mappedBy('CharSequence', 'String')
//			.assertMapping('T', 'CharIterable<CharSequence>'->OUT->OUT)
//	}
//	
//	@Test def void testCircularTypeParams_08() {
//		'T extends Iterable<T>, T2 extends Iterable<T>'.mappedBy('CharSequence', 'String')
//			.assertMapping('T', 'Iterable<Object>'->OUT->OUT)
//			.assertMapping('T2', 'Iterable<Iterable<Object>>'->OUT->OUT)
//	}
}
