/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.typesystem

import org.junit.runner.RunWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase
import org.eclipse.xtext.xbase.typesystem.^override.IResolvedOperation
import org.eclipse.xtext.xbase.XMemberFeatureCall
import com.google.inject.Inject
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver
import org.eclipse.xtext.common.types.JvmOperation
import org.eclipse.xtext.xbase.typesystem.^override.BottomResolvedOperation
import org.junit.Test
import org.eclipse.xtext.xbase.typesystem.^override.OverrideTester

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@RunWith(typeof(XtextRunner))
@InjectWith(typeof(XbaseNewTypeSystemInjectorProvider))
class ResolvedOperationTest extends AbstractXbaseTestCase {
	
	@Inject
	IBatchTypeResolver typeResolver
	
	@Inject
	OverrideTester overrideTester
	
	def IResolvedOperation toOperation(String expression) {
		val featureCall = expression.expression as XMemberFeatureCall
		val resolvedTypes = typeResolver.resolveTypes(featureCall)
		val receiverType = resolvedTypes.getActualType(featureCall.memberCallTarget)
		val operation = featureCall.feature as JvmOperation
		return new BottomResolvedOperation(operation, receiverType, overrideTester)
	}
	
	@Test
	def void testArrayListIteratorIsBottom() {
		val operation = 'newArrayList.iterator'.toOperation
		assertTrue(operation.bottomInContext)
		assertEquals('ArrayList<Object>', operation.contextType.simpleName)
		assertEquals('iterator', operation.declaration.simpleName)
	}
	
	@Test
	def void testArrayListOfStringIteratesStrings() {
		val operation = 'newArrayList("").iterator'.toOperation
		assertEquals('ArrayList<String>', operation.contextType.simpleName)
		assertEquals('Iterator<String>', operation.returnType.simpleName)
	}
	
	@Test
	def void testIterableOfStringsIteratesStrings() {
		val operation = '(null as Iterable<? extends String>).iterator'.toOperation
		assertEquals('Iterator<? extends String>', operation.returnType.simpleName)
	}
	
	@Test
	def void testListOfStringToArray() {
		val operation = 'newArrayList("").toArray(null)'.toOperation
		assertEquals('T[]', operation.returnType.simpleName)
	}
	
	@Test
	def void testListToArrayInheritsOne() {
		val operation = '(null as java.util.List<String>).toArray(null)'.toOperation
		val overridden = operation.overriddenAndImplementedMethods
		assertEquals(1, overridden.size)
		val typeParameter = overridden.head.resolvedTypeParameters.head
		assertEquals(operation.declaration, typeParameter.declarator)
	}
	
	@Test
	def void testArrayListToArrayInheritsTwo() {
		val operation = '(null as java.util.ArrayList<String>).toArray(null)'.toOperation
		val overridden = operation.overriddenAndImplementedMethods
		assertEquals(2, overridden.size)
		val typeParameter = overridden.head.resolvedTypeParameters.head
		assertEquals(operation.declaration, typeParameter.declarator)
		val typeParameterOfLast = overridden.last.resolvedTypeParameters.head
		assertEquals(operation.declaration, typeParameterOfLast.declarator)
	}
	
	@Test
	def void testListToArrayHasTwoCandidates() {
		val operation = '(null as java.util.List<String>).toArray(null)'.toOperation
		val candidates = operation.overriddenAndImplementedMethodCandidates
		assertEquals(2, candidates.size)
	}
	
	@Test
	def void testArrayListOfStringAcceptsStrings() {
		val operation = 'newArrayList("").addAll(null)'.toOperation
		assertEquals(1, operation.parameterTypes.size)
		assertEquals('Collection<? extends String>', operation.parameterTypes.head.simpleName)
	}
	
	@Test
	def void testHashSetInheritsIterator() {
		val operation = 'newHashSet("").iterator'.toOperation
		val candidates = operation.overriddenAndImplementedMethodCandidates
		assertEquals(2, candidates.size)
		assertEquals('AbstractCollection', candidates.head.declaringType.simpleName)
		assertEquals('Set', candidates.last.declaringType.simpleName)
	}
	
	@Test
	def void testInheritedAbstractCollectionIteratorIsNotBottom() {
		val operation = 'newHashSet("").iterator'.toOperation
		val candidates = operation.overriddenAndImplementedMethods
		assertFalse(candidates.head.bottomInContext)
		assertEquals('AbstractCollection<String>', candidates.head.asBottom.contextType.simpleName)
	}
	
	@Test
	def void testOverrideMethodResolution_01() {
		val operation = '(null as testdata.MethodOverrides2).m1(null as Object)'.toOperation
		val candidates = operation.overriddenAndImplementedMethodCandidates
		assertEquals(2, candidates.size)
		val overriddenMethods = operation.overriddenAndImplementedMethods
		assertTrue(overriddenMethods.empty)
	}
	
	@Test
	def void testOverrideMethodResolution_02() {
		val operation = '(null as testdata.MethodOverrides2).m1(null /* as String */)'.toOperation
		val candidates = operation.overriddenAndImplementedMethodCandidates
		assertTrue(candidates.empty)
		val overriddenMethods = operation.overriddenAndImplementedMethods
		assertTrue(overriddenMethods.empty)
	}
	
	@Test
	def void testOverrideMethodResolution_03() {
		val operation = '(null as testdata.MethodOverrides4).m1(null)'.toOperation
		val candidates = operation.overriddenAndImplementedMethodCandidates
		assertEquals(1, candidates.size)
		val overriddenMethods = operation.overriddenAndImplementedMethods
		assertEquals(1, overriddenMethods.size)
	}
	
	@Test
	def void testOverrideMethodResolution_04() {
		val operation = '(null as testdata.MethodOverrides4).m2(null)'.toOperation
		val candidates = operation.overriddenAndImplementedMethodCandidates
		assertEquals(1, candidates.size)
		val overriddenMethods = operation.overriddenAndImplementedMethods
		assertEquals(1, overriddenMethods.size)
	}
	
	@Test
	def void testOverrideMethodResolution_05() {
		val operation = '(null as testdata.MethodOverrides4).m3(null)'.toOperation
		val candidates = operation.overriddenAndImplementedMethodCandidates
		assertEquals(1, candidates.size)
		val overriddenMethods = operation.overriddenAndImplementedMethods
		assertEquals(1, overriddenMethods.size)
	}
	
	@Test
	def void testOverrideMethodResolution_06() {
		val operation = '(null as testdata.MethodOverrides4).m4(null)'.toOperation
		val candidates = operation.overriddenAndImplementedMethodCandidates
		assertEquals(1, candidates.size)
		val overriddenMethods = operation.overriddenAndImplementedMethods
		assertEquals(1, overriddenMethods.size)
	}
	
	@Test
	def void testOverrideMethodResolution_07() {
		val operation = '(null as testdata.MethodOverrides4).m5(null)'.toOperation
		val candidates = operation.overriddenAndImplementedMethodCandidates
		assertEquals(1, candidates.size)
		val overriddenMethods = operation.overriddenAndImplementedMethods
		assertEquals(1, overriddenMethods.size)
	}
	
	@Test
	def void testOverrideMethodResolution_08() {
		val operation = '(null as testdata.MethodOverrides4).m6()'.toOperation
		val candidates = operation.overriddenAndImplementedMethodCandidates
		assertEquals(1, candidates.size)
		val overriddenMethods = operation.overriddenAndImplementedMethods
		assertEquals(1, overriddenMethods.size)
	}
	
	@Test
	def void testOverrideMethodResolution_09() {
		val operation = '(null as testdata.MethodOverrides4).m7()'.toOperation
		val candidates = operation.overriddenAndImplementedMethodCandidates
		assertEquals(2, candidates.size)
		val overriddenMethods = operation.overriddenAndImplementedMethods
		assertEquals(1, overriddenMethods.size)
	}
	
	@Test
	def void testOverrideMethodResolution_10() {
		val operation = '(null as testdata.MethodOverrides4).m7(null, null, null, null)'.toOperation
		val candidates = operation.overriddenAndImplementedMethodCandidates
		assertEquals(2, candidates.size)
		val overriddenMethods = operation.overriddenAndImplementedMethods
		assertEquals(1, overriddenMethods.size)
	}
	
	@Test
	def void testOverrideMethodResolution_11() {
		val operation = '(null as testdata.MethodOverrides4).m8()'.toOperation
		val candidates = operation.overriddenAndImplementedMethodCandidates
		assertEquals(1, candidates.size)
		val overriddenMethods = operation.overriddenAndImplementedMethods
		assertEquals(1, overriddenMethods.size)
	}
	
	@Test
	def void testOverrideMethodResolution_12() {
		val operation = '(null as testdata.MethodOverrides4).m9()'.toOperation
		val candidates = operation.overriddenAndImplementedMethodCandidates
		assertEquals(1, candidates.size)
		val overriddenMethods = operation.overriddenAndImplementedMethods
		assertEquals(1, overriddenMethods.size)
	}
	
	@Test
	def void testRawOverrideMethodResolution_01() {
		val operation = '(null as testdata.MethodOverrides5).m1(null)'.toOperation
		val candidates = operation.overriddenAndImplementedMethodCandidates
		assertEquals(1, candidates.size)
		val overriddenMethods = operation.overriddenAndImplementedMethods
		assertEquals(1, overriddenMethods.size)
	}
	
	@Test
	def void testRawOverrideMethodResolution_02() {
		val operation = '(null as testdata.MethodOverrides5).m2(null)'.toOperation
		val candidates = operation.overriddenAndImplementedMethodCandidates
		assertEquals(1, candidates.size)
		val overriddenMethods = operation.overriddenAndImplementedMethods
		assertEquals(1, overriddenMethods.size)
	}
	
	@Test
	def void testRawOverrideMethodResolution_03() {
		val operation = '(null as testdata.MethodOverrides5).m3(null)'.toOperation
		val candidates = operation.overriddenAndImplementedMethodCandidates
		assertEquals(1, candidates.size)
		val overriddenMethods = operation.overriddenAndImplementedMethods
		assertEquals(1, overriddenMethods.size)
	}
	
	@Test
	def void testRawOverrideMethodResolution_04() {
		val operation = '(null as testdata.MethodOverrides5).m4(null)'.toOperation
		val candidates = operation.overriddenAndImplementedMethodCandidates
		assertEquals(1, candidates.size)
		val overriddenMethods = operation.overriddenAndImplementedMethods
		assertEquals(1, overriddenMethods.size)
	}
	
	@Test
	def void testRawOverrideMethodResolution_05() {
		val operation = '(null as testdata.MethodOverrides5).m5(null)'.toOperation
		val candidates = operation.overriddenAndImplementedMethodCandidates
		assertEquals(1, candidates.size)
		val overriddenMethods = operation.overriddenAndImplementedMethods
		assertEquals(1, overriddenMethods.size)
	}
	
	@Test
	def void testRawOverrideMethodResolution_06() {
		val operation = '(null as testdata.MethodOverrides5).m6()'.toOperation
		val candidates = operation.overriddenAndImplementedMethodCandidates
		assertEquals(1, candidates.size)
		val overriddenMethods = operation.overriddenAndImplementedMethods
		assertEquals(1, overriddenMethods.size)
	}
	
	@Test
	def void testRawOverrideMethodResolution_07() {
		val operation = '(null as testdata.MethodOverrides5).m7()'.toOperation
		val candidates = operation.overriddenAndImplementedMethodCandidates
		assertEquals(2, candidates.size)
		val overriddenMethods = operation.overriddenAndImplementedMethods
		assertEquals(1, overriddenMethods.size)
	}
	
	@Test
	def void testRawOverrideMethodResolution_08() {
		val operation = '(null as testdata.MethodOverrides5).m7(null, null, null, null)'.toOperation
		val candidates = operation.overriddenAndImplementedMethodCandidates
		assertEquals(2, candidates.size)
		val overriddenMethods = operation.overriddenAndImplementedMethods
		assertEquals(1, overriddenMethods.size)
	}
	
	@Test
	def void testRawOverrideMethodResolution_09() {
		val operation = '(null as testdata.MethodOverrides5).m8()'.toOperation
		val candidates = operation.overriddenAndImplementedMethodCandidates
		assertEquals(1, candidates.size)
		val overriddenMethods = operation.overriddenAndImplementedMethods
		assertEquals(1, overriddenMethods.size)
	}
	
	@Test
	def void testRawOverrideMethodResolution_10() {
		val operation = '(null as testdata.MethodOverrides5).m9()'.toOperation
		val candidates = operation.overriddenAndImplementedMethodCandidates
		assertEquals(1, candidates.size)
		val overriddenMethods = operation.overriddenAndImplementedMethods
		assertEquals(1, overriddenMethods.size)
	}
	
}