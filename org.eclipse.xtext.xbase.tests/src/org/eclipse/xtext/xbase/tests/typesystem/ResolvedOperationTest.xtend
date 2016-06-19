/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.typesystem

import com.google.inject.Inject
import java.util.EnumSet
import org.eclipse.xtext.common.types.JvmOperation
import org.eclipse.xtext.common.types.JvmVisibility
import org.eclipse.xtext.xbase.XMemberFeatureCall
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver
import org.eclipse.xtext.xbase.typesystem.^override.BottomResolvedOperation
import org.eclipse.xtext.xbase.typesystem.^override.IOverrideCheckResult
import org.eclipse.xtext.xbase.typesystem.^override.IResolvedOperation
import org.eclipse.xtext.xbase.typesystem.^override.OverrideTester
import org.junit.Test

import static org.eclipse.xtext.xbase.typesystem.^override.IOverrideCheckResult$OverrideCheckDetails.*

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
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
		assertFalse(operation.eIsProxy)
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
		assertEquals('Iterator<String>', operation.resolvedReturnType.simpleName)
	}
	
	@Test
	def void testTypeParameterConstraints() {
		val operation = '(null as overrides.AbstractForCharSequence).method'.toOperation
		assertTrue(operation.bottomInContext)
		assertEquals('AbstractForCharSequence', operation.contextType.simpleName)
		assertEquals('method', operation.declaration.simpleName)
		val typeParameters = operation.resolvedTypeParameters
		assertEquals(2, typeParameters.size)
		val firstConstraints = operation.getResolvedTypeParameterConstraints(0)
		assertEquals(1, firstConstraints.size)
		assertEquals('CharSequence', firstConstraints.head.simpleName)
		val secondConstraints = operation.getResolvedTypeParameterConstraints(1)
		assertEquals(1, secondConstraints.size)
		assertEquals('V', secondConstraints.head.simpleName)
	}
	
	@Test
	def void testIterableOfStringsIteratesStrings() {
		val operation = '(null as Iterable<? extends String>).iterator'.toOperation
		assertEquals('Iterator<? extends String>', operation.resolvedReturnType.simpleName)
	}
	
	@Test
	def void testListOfStringToArray() {
		val operation = 'newArrayList("").toArray(null)'.toOperation
		assertEquals('T[]', operation.resolvedReturnType.simpleName)
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
		assertEquals(1, operation.resolvedParameterTypes.size)
		assertEquals('Collection<? extends String>', operation.resolvedParameterTypes.head.simpleName)
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
	
	def protected has(IResolvedOperation operation, int candidates) {
		val actualCandidates = operation.overriddenAndImplementedMethodCandidates
		assertEquals("candidates", candidates, actualCandidates.size)
		return operation
	}
	
	def protected candidatesAndOverrides(IResolvedOperation operation, int overrides) {
		val actualOverrides = operation.overriddenAndImplementedMethods
		assertEquals("overrides", overrides, actualOverrides.size)
		return operation
	}
	
	def protected withExactDetails(IResolvedOperation operation, IOverrideCheckResult$OverrideCheckDetails... details) {
		assertEquals(1, operation.overriddenAndImplementedMethodCandidates.size)
		val candidate = operation.overriddenAndImplementedMethodCandidates.head
		val expectation = EnumSet::copyOf(details)
		val checkResult = operation.isOverridingOrImplementing(candidate)
		val actual = checkResult.details
		assertEquals(expectation.toString, actual.toString)
	}
	
	def protected withDetails(IResolvedOperation operation, IOverrideCheckResult$OverrideCheckDetails... details) {
		operation.overriddenAndImplementedMethodCandidates.forEach [
			val checkResult = operation.isOverridingOrImplementing(it)
			val actual = checkResult.details
			assertTrue('''Failed: «actual».containsAll(«details.toList»)''', actual.containsAll(details))
		]
	}
	
	def protected withDetail(IResolvedOperation operation, IOverrideCheckResult$OverrideCheckDetails detail) {
		operation.overriddenAndImplementedMethodCandidates.forEach [
			val checkResult = operation.isOverridingOrImplementing(it)
			val actual = checkResult.details
			assertTrue('''Failed: «actual».contains(«detail»)''', actual.contains(detail))
		]
	}
	
	@Test
	def void testOverrideMethodResolution_01() {
		val operation = '(null as testdata.MethodOverrides2).m1(null as Object)'.toOperation
		operation.has(2).candidatesAndOverrides(0).withDetail(PARAMETER_TYPE_MISMATCH)
	}
	
	@Test
	def void testOverrideMethodResolution_02() {
		val operation = '(null as testdata.MethodOverrides2).m1(null /* as String */)'.toOperation
		operation.has(0).candidatesAndOverrides(0)
	}
	
	@Test
	def void testOverrideMethodResolution_03() {
		val operation = '(null as testdata.MethodOverrides4).m1(null)'.toOperation
		operation.has(1).candidatesAndOverrides(1).withDetail(OVERRIDE)
	}
	
	@Test
	def void testOverrideMethodResolution_04() {
		val operation = '(null as testdata.MethodOverrides4).m2(null)'.toOperation
		operation.has(1).candidatesAndOverrides(1)
	}
	
	@Test
	def void testOverrideMethodResolution_05() {
		val operation = '(null as testdata.MethodOverrides4).m3(null)'.toOperation
		operation.has(1).candidatesAndOverrides(1).withExactDetails(OVERRIDE, COVARIANT_RETURN, UNCHECKED_CONVERSION_REQUIRED)
	}
	
	@Test
	def void testOverrideMethodResolution_06() {
		val operation = '(null as testdata.MethodOverrides4).m4(null)'.toOperation
		operation.has(1).candidatesAndOverrides(1).withExactDetails(OVERRIDE, COVARIANT_RETURN, UNCHECKED_CONVERSION_REQUIRED)
	}
	
	@Test
	def void testOverrideMethodResolution_07() {
		val operation = '(null as testdata.MethodOverrides4).m5(null)'.toOperation
		operation.has(1).candidatesAndOverrides(1)
	}
	
	@Test
	def void testOverrideMethodResolution_08() {
		val operation = '(null as testdata.MethodOverrides4).m6()'.toOperation
		operation.has(1).candidatesAndOverrides(1)
	}
	
	@Test
	def void testOverrideMethodResolution_09() {
		val operation = '(null as testdata.MethodOverrides4).m7()'.toOperation
		operation.has(2).candidatesAndOverrides(1)
	}
	
	@Test
	def void testOverrideMethodResolution_10() {
		val operation = '(null as testdata.MethodOverrides4).m7(null, null, null, null)'.toOperation
		operation.has(2).candidatesAndOverrides(1)
	}
	
	@Test
	def void testOverrideMethodResolution_11() {
		val operation = '(null as testdata.MethodOverrides4).m8()'.toOperation
		operation.has(1).candidatesAndOverrides(1)
	}
	
	@Test
	def void testOverrideMethodResolution_12() {
		val operation = '(null as testdata.MethodOverrides4).m9()'.toOperation
		operation.has(1).candidatesAndOverrides(1)
	}
	
	@Test
	def void testOverrideMethodResolution_13() {
		val operation = '(null as testdata.MethodOverrides4).m10()'.toOperation
		operation.has(1).candidatesAndOverrides(1)
	}
	
	@Test
	def void testOverrideMethodResolution_14() {
		'(null as testdata.MethodOverrides4).m10()'.toOperation => [
			val candidate = overriddenAndImplementedMethodCandidates.head
			assertEquals(1, candidate.typeParameters.size)
			assertEquals(1, declaration.typeParameters.size)
			declaration.typeParameters.clear
			has(1).candidatesAndOverrides(0).withDetail(TYPE_PARAMETER_MISMATCH)
		]
	}
	
	@Test
	def void testOverrideMethodResolution_15() {
		'(null as overrides.ConcreteForCharSequence).method'.toOperation => [
			val candidate = overriddenAndImplementedMethodCandidates.head
			assertEquals(2, candidate.typeParameters.size)
			assertEquals(2, declaration.typeParameters.size)
			has(1).candidatesAndOverrides(1).withDetails(IMPLEMENTATION)
		]
	}
	
	@Test
	def void testRawOverrideMethodResolution_01() {
		val operation = '(null as testdata.MethodOverrides5).m1(null)'.toOperation
		operation.has(1).candidatesAndOverrides(1).withDetail(OVERRIDE)
	}
	
	@Test
	def void testRawOverrideMethodResolution_02() {
		val operation = '(null as testdata.MethodOverrides5).m2(null)'.toOperation
		operation.has(1).candidatesAndOverrides(1)
	}
	
	@Test
	def void testRawOverrideMethodResolution_03() {
		val operation = '(null as testdata.MethodOverrides5).m3(null)'.toOperation
		operation.has(1).candidatesAndOverrides(1).withExactDetails(OVERRIDE, COVARIANT_RETURN)
	}
	
	@Test
	def void testRawOverrideMethodResolution_04() {
		val operation = '(null as testdata.MethodOverrides5).m4(null)'.toOperation
		operation.has(1).candidatesAndOverrides(1).withExactDetails(OVERRIDE, COVARIANT_RETURN)
	}
	
	@Test
	def void testRawOverrideMethodResolution_05() {
		val operation = '(null as testdata.MethodOverrides5).m5(null)'.toOperation
		operation.has(1).candidatesAndOverrides(1)
	}
	
	@Test
	def void testRawOverrideMethodResolution_06() {
		val operation = '(null as testdata.MethodOverrides5).m6()'.toOperation
		operation.has(1).candidatesAndOverrides(1)
	}
	
	@Test
	def void testRawOverrideMethodResolution_07() {
		val operation = '(null as testdata.MethodOverrides5).m7()'.toOperation
		operation.has(2).candidatesAndOverrides(1)
	}
	
	@Test
	def void testRawOverrideMethodResolution_08() {
		val operation = '(null as testdata.MethodOverrides5).m7(null, null, null, null)'.toOperation
		operation.has(2).candidatesAndOverrides(1)
	}
	
	@Test
	def void testRawOverrideMethodResolution_09() {
		val operation = '(null as testdata.MethodOverrides5).m8()'.toOperation
		operation.has(1).candidatesAndOverrides(1)
	}
	
	@Test
	def void testRawOverrideMethodResolution_10() {
		val operation = '(null as testdata.MethodOverrides5).m9()'.toOperation
		operation.has(1).candidatesAndOverrides(1)
	}
	
	@Test
	def void testPrivateMethodOverride_01() {
		val operation = "(null as testdata.MethodOverrides4).privateM1(null)".toOperation
		operation.has(1).candidatesAndOverrides(0).withDetails(NOT_VISIBLE, PARAMETER_TYPE_MISMATCH)
	}
	
	// we use statics here as instance methods to simplify the test setup
	@Test
	def void testShadowedMethodResolution_01() {
		val operation = '(null as testdata.MethodOverrides4).staticM1(null)'.toOperation
		operation.has(1).candidatesAndOverrides(1).withDetail(SHADOWED)
	}
	
	@Test
	def void testShadowedMethodResolution_02() {
		val operation = '(null as testdata.MethodOverrides4).staticM2(null)'.toOperation
		operation.has(1).candidatesAndOverrides(1).withDetail(SHADOWED)
	}
	
	@Test
	def void testShadowedMethodResolution_03() {
		val operation = '(null as testdata.MethodOverrides4).staticM3(null)'.toOperation
		operation.has(1).candidatesAndOverrides(1).withDetail(SHADOWED)
	}
	
	@Test
	def void testShadowedMethodResolution_04() {
		val operation = '(null as testdata.MethodOverrides4).staticM4(null)'.toOperation
		operation.has(1).candidatesAndOverrides(1).withDetail(SHADOWED)
	}
	
	@Test
	def void testShadowedMethodResolution_05() {
		val operation = '(null as testdata.MethodOverrides4).<java.io.Serializable>staticM5(null)'.toOperation
		operation.has(1).candidatesAndOverrides(0).withDetail(TYPE_PARAMETER_MISMATCH)
	}
	
	@Test
	def void testShadowedMethodResolution_06() {
		val operation = '(null as testdata.MethodOverrides4).<CharSequence>staticM5()'.toOperation
		assertEquals("MethodOverrides3", operation.declaration.declaringType.simpleName)
		operation.has(0).candidatesAndOverrides(0)
	}
	
	@Test
	def void testVarArgsMismatch_01() {
		val operation = '(null as testdata.MethodOverrides4).withVarArgs(null)'.toOperation
		operation.declaration.visibility = JvmVisibility::PROTECTED
		operation.overriddenAndImplementedMethodCandidates.forEach [
			visibility = JvmVisibility::PUBLIC
		]
		operation.has(1).candidatesAndOverrides(1).withDetails(REDUCED_VISIBILITY, VAR_ARG_MISMATCH)
	}
	
	@Test
	def void testVarArgsMismatch_02() {
		val operation = '(null as testdata.MethodOverrides4).withArray(null)'.toOperation
		operation.declaration.visibility = JvmVisibility::PROTECTED
		operation.overriddenAndImplementedMethodCandidates.forEach [
			visibility = JvmVisibility::DEFAULT
		]
		operation.has(1).candidatesAndOverrides(1).withDetails(VAR_ARG_MISMATCH)
	}
	
	@Test
	def void testVarArgsMismatch_03() {
		val operation = '(null as testdata.MethodOverrides4).withArray(null)'.toOperation
		operation.declaration => [
			visibility = JvmVisibility::PUBLIC
			setStatic(true)
		]
		operation.overriddenAndImplementedMethodCandidates.forEach [
			visibility = JvmVisibility::PROTECTED
			setStatic(true)
		]
		operation.has(1).candidatesAndOverrides(1).withExactDetails(SHADOWED, VAR_ARG_MISMATCH)
	}
	
	@Test
	def void testVarArgsMismatch_04() {
		val operation = '(null as testdata.MethodOverrides4).withVarArgs(null)'.toOperation
		operation.declaration => [
			visibility = JvmVisibility::PROTECTED
			setStatic(true)
		]
		operation.overriddenAndImplementedMethodCandidates.forEach [
			visibility = JvmVisibility::PROTECTED
		]
		operation.has(1).candidatesAndOverrides(0).withDetails(STATIC_MISMATCH, VAR_ARG_MISMATCH)
	}
	
	@Test
	def void testSameErasure_01() {
		val operation = '(null as testdata.MethodOverrides4).sameErasure1(null)'.toOperation
		operation.declaration => [
			visibility = JvmVisibility::PROTECTED
		]
		operation.overriddenAndImplementedMethodCandidates.forEach [
			visibility = JvmVisibility::PROTECTED
		]
		operation.has(1).candidatesAndOverrides(0).withExactDetails(PARAMETER_TYPE_MISMATCH, SAME_ERASURE)
	}
	
	@Test
	def void testSameErasure_02() {
		val operation = '(null as testdata.MethodOverrides4).sameErasure2(null)'.toOperation
		operation.declaration => [
			visibility = JvmVisibility::PROTECTED
		]
		operation.overriddenAndImplementedMethodCandidates.forEach [
			visibility = JvmVisibility::PROTECTED
		]
		operation.has(1).candidatesAndOverrides(0).withExactDetails(TYPE_PARAMETER_MISMATCH, SAME_ERASURE)
	}
	
	@Test
	def void testSameErasure_03() {
		val operation = '(null as testdata.MethodOverrides4).sameErasure3'.toOperation
		operation.declaration => [
			visibility = JvmVisibility::PROTECTED
		]
		operation.overriddenAndImplementedMethodCandidates.forEach [
			visibility = JvmVisibility::PROTECTED
		]
		operation.has(1).candidatesAndOverrides(0).withExactDetails(TYPE_PARAMETER_MISMATCH, SAME_ERASURE)
	}
}