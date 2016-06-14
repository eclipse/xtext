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
import org.eclipse.xtext.util.Triple
import org.eclipse.xtext.util.Tuples
import org.eclipse.xtext.xbase.typesystem.references.LightweightBoundTypeArgument
import org.eclipse.xtext.xbase.typesystem.references.LightweightMergedBoundTypeArgument
import org.eclipse.xtext.xbase.typesystem.util.BoundTypeArgumentMerger
import org.eclipse.xtext.xbase.typesystem.util.VarianceInfo
import org.junit.Test

import static org.eclipse.xtext.xbase.typesystem.util.VarianceInfo.*

/**
 * @author Sebastian Zarnekow
 */
class BoundTypeArgumentMergerTest extends AbstractTestingTypeReferenceOwner {

	@Inject
	extension IXtendJvmAssociations
	
	@Inject
	BoundTypeArgumentMerger merger
	
	def merge(Triple<String,VarianceInfo,VarianceInfo>... mergeUs) {
		mergeWithSource(null, mergeUs)
	}
	
	def mergeWithSource(Object source, Triple<String,VarianceInfo,VarianceInfo>... mergeUs) {
		val signature = '''def void method(«mergeUs.join(null, ' p, ', ' p') [first]») {}'''
		val function = function(signature.toString)
		val operation = function.directlyInferredOperation
		val mergable = <LightweightBoundTypeArgument>newArrayList
		operation.parameters.forEach[ p, i |
			val input = mergeUs.get(i)
			mergable += new LightweightBoundTypeArgument(p.parameterType.toLightweightTypeReference, null, source ?: new Object, input.second, input.third)
		]
		return merger.merge(mergable, owner)
	}
	
	def mergeSuccessive(Triple<String,VarianceInfo,VarianceInfo>... mergeUs) {
		assertTrue(mergeUs.length > 2)
		
		val signature = '''def void method(«mergeUs.join(null, ' p, ', ' p') [first]») {}'''
		val function = function(signature.toString)
		val operation = function.directlyInferredOperation
		val mergable = <LightweightBoundTypeArgument>newArrayList
		operation.parameters.forEach[ p, i |
			val input = mergeUs.get(i)
			mergable += new LightweightBoundTypeArgument(p.parameterType.toLightweightTypeReference, null, new Object, input.second, input.third)
		]
		val iterator = mergable.iterator
		var first = iterator.next
		var second = iterator.next
		var merged = merger.merge(#[first, second], owner)
		while(iterator.hasNext) {
			first = new LightweightBoundTypeArgument(merged.typeReference, null, new Object, merged.variance, merged.variance)
			second = iterator.next
			merged = merger.merge(#[first, second], owner)
		}
		return merged
	}
	
	
	def to(LightweightMergedBoundTypeArgument merged, String type, VarianceInfo variance) {
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

	@Test def void testMergeMultiType_01() {
		merge('StringBuilder'->OUT->OUT, 'StringBuffer'->OUT->OUT).to('AbstractStringBuilder & Serializable', INVARIANT)
	}

	@Test def void testMergeMultiType_02() {
		mergeSuccessive('StringBuilder'->OUT->OUT, 'StringBuffer'->OUT->OUT, 'StringBuilder'->OUT->OUT).to('AbstractStringBuilder & Serializable', INVARIANT)
	}
	
	@Test def void testMergeMultiType_03() {
		merge('StringBuilder'->OUT->INVARIANT, 'StringBuffer'->OUT->INVARIANT, 'String'->OUT->INVARIANT).to('Serializable & CharSequence', INVARIANT)
	}
	
	@Test def void testMergeMultiType_04() {
		merge('AbstractStringBuilder'->OUT->INVARIANT, 'java.io.Serializable'->OUT->INVARIANT, 'String'->OUT->INVARIANT).to('Object', INVARIANT)
	}
	
	@Test def void testBug470766_01() {
		merge('void'->OUT->INVARIANT, 'Integer'->OUT->INVARIANT, 'Long'->OUT->INVARIANT).to('Number & Comparable<?>', INVARIANT)
	}
	
	@Test def void testBug470766_02() {
		merge('String'->OUT->INVARIANT, 'void'->OUT->INVARIANT).to('String', INVARIANT)
	}
}
