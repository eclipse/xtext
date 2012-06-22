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
import org.eclipse.xtend.core.tests.AbstractXtendTestCase
import org.eclipse.xtext.common.types.JvmTypeParameter
import org.eclipse.xtext.util.Triple
import org.eclipse.xtext.util.Tuples
import org.eclipse.xtext.xbase.lib.Pair
import org.eclipse.xtext.xbase.typesystem.util.VarianceInfo
import org.junit.Test

import static org.eclipse.xtext.xbase.typesystem.util.VarianceInfo.*
import org.eclipse.xtext.xbase.typesystem.references.LightweightBoundTypeArgument
import org.eclipse.xtext.xbase.typesystem.references.LightweightMergedBoundTypeArgument

/**
 * @author Sebastian Zarnekow
 */
abstract class AbstractDeferredTypeParameterHintCollectorTest extends AbstractXtendTestCase {

	@Inject
	extension IXtendJvmAssociations
	
	def Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> in(String typeParameters, String expectedType, String actualType)
	
	def operation(String typeParameters, String expectedType, String actualType) {
		// TODO synthesize unique variable names as soon as the function should be validated
		val signature = '''def <«typeParameters»> void method(«expectedType» expected, «actualType» actual) {}'''
		val function = function(signature.toString)
		val operation = function.directlyInferredOperation
		return operation
	}
	
	def List<LightweightBoundTypeArgument> hasHintsFor(Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> mapping, String typeParamName)
	
	def void hasNoHintsFor(Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> mapping, String typeParamName)
	
	def List<LightweightBoundTypeArgument> like(List<LightweightBoundTypeArgument> mappingData, Triple<String, VarianceInfo, VarianceInfo>... mappedTypes)
	
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

