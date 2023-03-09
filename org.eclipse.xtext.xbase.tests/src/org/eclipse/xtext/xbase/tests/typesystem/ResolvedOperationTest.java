/**
 * Copyright (c) 2012, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;

import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.override.BottomResolvedOperation;
import org.eclipse.xtext.xbase.typesystem.override.IOverrideCheckResult;
import org.eclipse.xtext.xbase.typesystem.override.IResolvedOperation;
import org.eclipse.xtext.xbase.typesystem.override.OverrideTester;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.junit.Assert;
import org.junit.Test;

import com.google.common.base.Joiner;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ResolvedOperationTest extends AbstractXbaseTestCase {
	@Inject
	private IBatchTypeResolver typeResolver;

	@Inject
	private OverrideTester overrideTester;

	public IResolvedOperation toOperation(String expression) throws Exception {
		XMemberFeatureCall featureCall = (XMemberFeatureCall) expression(expression);
		IResolvedTypes resolvedTypes = typeResolver.resolveTypes(featureCall);
		LightweightTypeReference receiverType = resolvedTypes.getActualType(featureCall.getMemberCallTarget());
		JvmOperation operation = (JvmOperation) featureCall.getFeature();
		Assert.assertFalse(operation.eIsProxy());
		return new BottomResolvedOperation(operation, receiverType, overrideTester);
	}

	@Test
	public void testArrayListIteratorIsBottom() throws Exception {
		IResolvedOperation operation = toOperation("newArrayList.iterator");
		Assert.assertTrue(operation.isBottomInContext());
		Assert.assertEquals("ArrayList<Object>", operation.getContextType().getSimpleName());
		Assert.assertEquals("iterator", operation.getDeclaration().getSimpleName());
	}

	@Test
	public void testArrayListOfStringIteratesStrings() throws Exception {
		IResolvedOperation operation = toOperation("newArrayList(\"\").iterator");
		Assert.assertEquals("ArrayList<String>", operation.getContextType().getSimpleName());
		Assert.assertEquals("Iterator<String>", operation.getResolvedReturnType().getSimpleName());
	}

	@Test
	public void testTypeParameterConstraints() throws Exception {
		IResolvedOperation operation = toOperation("(null as overrides.AbstractForCharSequence).method");
		Assert.assertTrue(operation.isBottomInContext());
		Assert.assertEquals("AbstractForCharSequence", operation.getContextType().getSimpleName());
		Assert.assertEquals("method", operation.getDeclaration().getSimpleName());
		List<JvmTypeParameter> typeParameters = operation.getResolvedTypeParameters();
		Assert.assertEquals(2, typeParameters.size());
		List<LightweightTypeReference> firstConstraints = operation.getResolvedTypeParameterConstraints(0);
		Assert.assertEquals(1, firstConstraints.size());
		Assert.assertEquals("CharSequence", Iterables.getFirst(firstConstraints, null).getSimpleName());
		List<LightweightTypeReference> secondConstraints = operation.getResolvedTypeParameterConstraints(1);
		Assert.assertEquals(1, secondConstraints.size());
		Assert.assertEquals("V", Iterables.getFirst(secondConstraints, null).getSimpleName());
	}

	@Test
	public void testIterableOfStringsIteratesStrings() throws Exception {
		IResolvedOperation operation = toOperation("(null as Iterable<? extends String>).iterator");
		Assert.assertEquals("Iterator<? extends String>", operation.getResolvedReturnType().getSimpleName());
	}

	@Test
	public void testListOfStringToArray() throws Exception {
		IResolvedOperation operation = toOperation("newArrayList(\"\").toArray(null)");
		Assert.assertEquals("T[]", operation.getResolvedReturnType().getSimpleName());
	}

	@Test
	public void testListToArrayInheritsOne() throws Exception {
		IResolvedOperation operation = toOperation("(null as java.util.List<String>).toArray(null)");
		List<IResolvedOperation> overridden = operation.getOverriddenAndImplementedMethods();
		Assert.assertEquals(1, overridden.size());
		IResolvedOperation firstOverriden = Iterables.getFirst(overridden, null);
		Assert.assertNotNull(firstOverriden);
		JvmTypeParameter typeParameter = Iterables
				.getFirst(firstOverriden.getResolvedTypeParameters(), null);
		Assert.assertNotNull(typeParameter);
		Assert.assertEquals(operation.getDeclaration(), typeParameter.getDeclarator());
	}

	@Test
	public void testArrayListToArrayInheritsTwo() throws Exception {
		IResolvedOperation operation = toOperation("(null as java.util.ArrayList<String>).toArray(null)");
		List<IResolvedOperation> overridden = operation.getOverriddenAndImplementedMethods();
		Assert.assertEquals(2, overridden.size());
		IResolvedOperation firstOverriden = Iterables.getFirst(overridden, null);
		Assert.assertNotNull(firstOverriden);
		JvmTypeParameter typeParameter = Iterables
				.getFirst(firstOverriden.getResolvedTypeParameters(), null);
		Assert.assertNotNull(typeParameter);
		Assert.assertEquals(operation.getDeclaration(), typeParameter.getDeclarator());
		JvmTypeParameter typeParameterOfLast = Iterables
				.getFirst(Iterables.getLast(overridden).getResolvedTypeParameters(), null);
		Assert.assertNotNull(typeParameterOfLast);
		Assert.assertEquals(operation.getDeclaration(), typeParameterOfLast.getDeclarator());
	}

	@Test
	public void testListToArrayHasTwoOrThreeCandidates() throws Exception {
		IResolvedOperation operation = toOperation("(null as java.util.List<String>).toArray(null)");
		List<JvmOperation> candidates = operation.getOverriddenAndImplementedMethodCandidates();
		String message = Joiner.on(", ").join(Lists.transform(candidates, JvmOperation::getIdentifier));
		try {
			Assert.assertEquals(message, 2, candidates.size());
		} catch (AssertionError e) {
			Assert.assertEquals(message, 3, candidates.size());
		}
	}

	@Test
	public void testArrayListOfStringAcceptsStrings() throws Exception {
		IResolvedOperation operation = toOperation("newArrayList(\"\").addAll(null)");
		Assert.assertEquals(1, operation.getResolvedParameterTypes().size());
		Assert.assertEquals("Collection<? extends String>", Iterables.getFirst(operation.getResolvedParameterTypes(), null).getSimpleName());
	}

	@Test
	public void testHashSetInheritsIterator() throws Exception {
		IResolvedOperation operation = toOperation("newHashSet(\"\").iterator");
		List<JvmOperation> candidates = operation.getOverriddenAndImplementedMethodCandidates();
		Assert.assertEquals(2, candidates.size());
		Assert.assertEquals("AbstractCollection", Iterables.getFirst(candidates, null).getDeclaringType().getSimpleName());
		Assert.assertEquals("Set", Iterables.getLast(candidates).getDeclaringType().getSimpleName());
	}

	@Test
	public void testInheritedAbstractCollectionIteratorIsNotBottom() throws Exception {
		IResolvedOperation operation = toOperation("newHashSet(\"\").iterator");
		List<IResolvedOperation> candidates = operation.getOverriddenAndImplementedMethods();
		Assert.assertFalse(Iterables.getFirst(candidates, null).isBottomInContext());
		IResolvedOperation firstCandidate = Iterables.getFirst(candidates, null);
		Assert.assertNotNull(firstCandidate);
		Assert.assertEquals("AbstractCollection<String>",
				firstCandidate.getAsBottom().getContextType().getSimpleName());
	}

	protected IResolvedOperation has(IResolvedOperation operation, int candidates) {
		List<JvmOperation> actualCandidates = operation.getOverriddenAndImplementedMethodCandidates();
		Assert.assertEquals("candidates", candidates, actualCandidates.size());
		return operation;
	}

	protected IResolvedOperation candidatesAndOverrides(IResolvedOperation operation, int overrides) {
		List<IResolvedOperation> actualOverrides = operation.getOverriddenAndImplementedMethods();
		Assert.assertEquals("overrides", overrides, actualOverrides.size());
		return operation;
	}

	protected void withExactDetails(IResolvedOperation operation, IOverrideCheckResult.OverrideCheckDetails... details) {
		Assert.assertEquals(1, operation.getOverriddenAndImplementedMethodCandidates().size());
		JvmOperation candidate = Iterables.getFirst(operation.getOverriddenAndImplementedMethodCandidates(), null);
		EnumSet<IOverrideCheckResult.OverrideCheckDetails> expectation = EnumSet.copyOf(Arrays.asList(details));
		IOverrideCheckResult checkResult = operation.isOverridingOrImplementing(candidate);
		EnumSet<IOverrideCheckResult.OverrideCheckDetails> actual = checkResult.getDetails();
		Assert.assertEquals(expectation.toString(), actual.toString());
	}

	protected void withDetails(IResolvedOperation operation, IOverrideCheckResult.OverrideCheckDetails... details) {
		operation.getOverriddenAndImplementedMethodCandidates().forEach( (JvmOperation it) -> {
			IOverrideCheckResult checkResult = operation.isOverridingOrImplementing(it);
			EnumSet<IOverrideCheckResult.OverrideCheckDetails> actual = checkResult.getDetails();
			StringBuilder builder = new StringBuilder();
			builder.append("Failed: ");
			builder.append(actual);
			builder.append(".containsAll(");
			builder.append(Arrays.asList(details));
			builder.append(")");
			Assert.assertTrue(builder.toString(), actual.containsAll(Arrays.asList(details)));
		});
	}

	protected void withDetail(IResolvedOperation operation, IOverrideCheckResult.OverrideCheckDetails detail) {
		operation.getOverriddenAndImplementedMethodCandidates().forEach((JvmOperation it) -> {
			IOverrideCheckResult checkResult = operation.isOverridingOrImplementing(it);
			EnumSet<IOverrideCheckResult.OverrideCheckDetails> actual = checkResult.getDetails();
			StringBuilder builder = new StringBuilder();
			builder.append("Failed: ");
			builder.append(actual);
			builder.append(".contains(");
			builder.append(detail);
			builder.append(")");
			Assert.assertTrue(builder.toString(), actual.contains(detail));
		});
	}

	@Test
	public void testOverrideMethodResolution_01() throws Exception {
		IResolvedOperation operation = toOperation("(null as testdata.MethodOverrides2).m1(null as Object)");
		withDetail(candidatesAndOverrides(has(operation, 2), 0), IOverrideCheckResult.OverrideCheckDetails.PARAMETER_TYPE_MISMATCH);
	}

	@Test
	public void testOverrideMethodResolution_02() throws Exception {
		IResolvedOperation operation = toOperation("(null as testdata.MethodOverrides2).m1(null /* as String */)");
		candidatesAndOverrides(has(operation, 0), 0);
	}

	@Test
	public void testOverrideMethodResolution_03() throws Exception {
		IResolvedOperation operation = toOperation("(null as testdata.MethodOverrides4).m1(null)");
		withDetail(candidatesAndOverrides(has(operation, 1), 1), IOverrideCheckResult.OverrideCheckDetails.OVERRIDE);
	}

	@Test
	public void testOverrideMethodResolution_04() throws Exception {
		IResolvedOperation operation = toOperation("(null as testdata.MethodOverrides4).m2(null)");
		candidatesAndOverrides(has(operation, 1), 1);
	}

	@Test
	public void testOverrideMethodResolution_05() throws Exception {
		IResolvedOperation operation = toOperation("(null as testdata.MethodOverrides4).m3(null)");
		withExactDetails(candidatesAndOverrides(has(operation, 1), 1), IOverrideCheckResult.OverrideCheckDetails.OVERRIDE,
				IOverrideCheckResult.OverrideCheckDetails.COVARIANT_RETURN,
				IOverrideCheckResult.OverrideCheckDetails.UNCHECKED_CONVERSION_REQUIRED);
	}

	@Test
	public void testOverrideMethodResolution_06() throws Exception {
		IResolvedOperation operation = toOperation("(null as testdata.MethodOverrides4).m4(null)");
		withExactDetails(candidatesAndOverrides(has(operation, 1), 1), IOverrideCheckResult.OverrideCheckDetails.OVERRIDE,
				IOverrideCheckResult.OverrideCheckDetails.COVARIANT_RETURN,
				IOverrideCheckResult.OverrideCheckDetails.UNCHECKED_CONVERSION_REQUIRED);
	}

	@Test
	public void testOverrideMethodResolution_07() throws Exception {
		IResolvedOperation operation = toOperation("(null as testdata.MethodOverrides4).m5(null)");
		candidatesAndOverrides(has(operation, 1), 1);
	}

	@Test
	public void testOverrideMethodResolution_08() throws Exception {
		IResolvedOperation operation = toOperation("(null as testdata.MethodOverrides4).m6()");
		candidatesAndOverrides(has(operation, 1), 1);
	}

	@Test
	public void testOverrideMethodResolution_09() throws Exception {
		IResolvedOperation operation = toOperation("(null as testdata.MethodOverrides4).m7()");
		candidatesAndOverrides(has(operation, 2), 1);
	}

	@Test
	public void testOverrideMethodResolution_10() throws Exception {
		IResolvedOperation operation = toOperation("(null as testdata.MethodOverrides4).m7(null, null, null, null)");
		candidatesAndOverrides(has(operation, 2), 1);
	}

	@Test
	public void testOverrideMethodResolution_11() throws Exception {
		IResolvedOperation operation = toOperation("(null as testdata.MethodOverrides4).m8()");
		candidatesAndOverrides(has(operation, 1), 1);
	}

	@Test
	public void testOverrideMethodResolution_12() throws Exception {
		IResolvedOperation operation = toOperation("(null as testdata.MethodOverrides4).m9()");
		candidatesAndOverrides(has(operation, 1), 1);
	}

	@Test
	public void testOverrideMethodResolution_13() throws Exception {
		IResolvedOperation operation = toOperation("(null as testdata.MethodOverrides4).m10()");
		candidatesAndOverrides(has(operation, 1), 1);
	}

	@Test
	public void testOverrideMethodResolution_14() throws Exception {
		IResolvedOperation operation = toOperation("(null as testdata.MethodOverrides4).m10()");
		JvmOperation candidate = Iterables.getFirst(operation.getOverriddenAndImplementedMethodCandidates(), null);
		Assert.assertNotNull(candidate);
		Assert.assertEquals(1, candidate.getTypeParameters().size());
		Assert.assertEquals(1, operation.getDeclaration().getTypeParameters().size());
		operation.getDeclaration().getTypeParameters().clear();
		withDetail(candidatesAndOverrides(has(operation, 1), 0), IOverrideCheckResult.OverrideCheckDetails.TYPE_PARAMETER_MISMATCH);
	}

	@Test
	public void testOverrideMethodResolution_15() throws Exception {
		IResolvedOperation operation = toOperation("(null as overrides.ConcreteForCharSequence).method");
		JvmOperation candidate = Iterables.getFirst(operation.getOverriddenAndImplementedMethodCandidates(), null);
		Assert.assertNotNull(candidate);
		Assert.assertEquals(2, candidate.getTypeParameters().size());
		Assert.assertEquals(2, operation.getDeclaration().getTypeParameters().size());
		withDetails(candidatesAndOverrides(has(operation, 1), 1), IOverrideCheckResult.OverrideCheckDetails.IMPLEMENTATION);
	}

	@Test
	public void testRawOverrideMethodResolution_01() throws Exception {
		IResolvedOperation operation = toOperation("(null as testdata.MethodOverrides5).m1(null)");
		withDetail(candidatesAndOverrides(has(operation, 1), 1), IOverrideCheckResult.OverrideCheckDetails.OVERRIDE);
	}

	@Test
	public void testRawOverrideMethodResolution_02() throws Exception {
		IResolvedOperation operation = toOperation("(null as testdata.MethodOverrides5).m2(null)");
		candidatesAndOverrides(has(operation, 1), 1);
	}

	@Test
	public void testRawOverrideMethodResolution_03() throws Exception {
		IResolvedOperation operation = toOperation("(null as testdata.MethodOverrides5).m3(null)");
		withExactDetails(candidatesAndOverrides(has(operation, 1), 1), IOverrideCheckResult.OverrideCheckDetails.OVERRIDE,
				IOverrideCheckResult.OverrideCheckDetails.COVARIANT_RETURN);
	}

	@Test
	public void testRawOverrideMethodResolution_04() throws Exception {
		IResolvedOperation operation = toOperation("(null as testdata.MethodOverrides5).m4(null)");
		withExactDetails(candidatesAndOverrides(has(operation, 1), 1), IOverrideCheckResult.OverrideCheckDetails.OVERRIDE,
				IOverrideCheckResult.OverrideCheckDetails.COVARIANT_RETURN);
	}

	@Test
	public void testRawOverrideMethodResolution_05() throws Exception {
		IResolvedOperation operation = toOperation("(null as testdata.MethodOverrides5).m5(null)");
		candidatesAndOverrides(has(operation, 1), 1);
	}

	@Test
	public void testRawOverrideMethodResolution_06() throws Exception {
		IResolvedOperation operation = toOperation("(null as testdata.MethodOverrides5).m6()");
		candidatesAndOverrides(has(operation, 1), 1);
	}

	@Test
	public void testRawOverrideMethodResolution_07() throws Exception {
		IResolvedOperation operation = toOperation("(null as testdata.MethodOverrides5).m7()");
		candidatesAndOverrides(has(operation, 2), 1);
	}

	@Test
	public void testRawOverrideMethodResolution_08() throws Exception {
		IResolvedOperation operation = toOperation("(null as testdata.MethodOverrides5).m7(null, null, null, null)");
		candidatesAndOverrides(has(operation, 2), 1);
	}

	@Test
	public void testRawOverrideMethodResolution_09() throws Exception {
		IResolvedOperation operation = toOperation("(null as testdata.MethodOverrides5).m8()");
		candidatesAndOverrides(has(operation, 1), 1);
	}

	@Test
	public void testRawOverrideMethodResolution_10() throws Exception {
		IResolvedOperation operation = toOperation("(null as testdata.MethodOverrides5).m9()");
		candidatesAndOverrides(has(operation, 1), 1);
	}

	@Test
	public void testPrivateMethodOverride_01() throws Exception {
		IResolvedOperation operation = toOperation("(null as testdata.MethodOverrides4).privateM1(null)");
		withDetails(candidatesAndOverrides(has(operation, 1), 0), IOverrideCheckResult.OverrideCheckDetails.NOT_VISIBLE,
				IOverrideCheckResult.OverrideCheckDetails.PARAMETER_TYPE_MISMATCH);
	}

	@Test
	public void testShadowedMethodResolution_01() throws Exception {
		IResolvedOperation operation = toOperation("(null as testdata.MethodOverrides4).staticM1(null)");
		withDetail(candidatesAndOverrides(has(operation, 1), 1), IOverrideCheckResult.OverrideCheckDetails.SHADOWED);
	}

	@Test
	public void testShadowedMethodResolution_02() throws Exception {
		IResolvedOperation operation = toOperation("(null as testdata.MethodOverrides4).staticM2(null)");
		withDetail(candidatesAndOverrides(has(operation, 1), 1), IOverrideCheckResult.OverrideCheckDetails.SHADOWED);
	}

	@Test
	public void testShadowedMethodResolution_03() throws Exception {
		IResolvedOperation operation = toOperation("(null as testdata.MethodOverrides4).staticM3(null)");
		withDetail(candidatesAndOverrides(has(operation, 1), 1), IOverrideCheckResult.OverrideCheckDetails.SHADOWED);
	}

	@Test
	public void testShadowedMethodResolution_04() throws Exception {
		IResolvedOperation operation = toOperation("(null as testdata.MethodOverrides4).staticM4(null)");
		withDetail(candidatesAndOverrides(has(operation, 1), 1), IOverrideCheckResult.OverrideCheckDetails.SHADOWED);
	}

	@Test
	public void testShadowedMethodResolution_05() throws Exception {
		IResolvedOperation operation = toOperation("(null as testdata.MethodOverrides4).<java.io.Serializable>staticM5(null)");
		withDetail(candidatesAndOverrides(has(operation, 1), 0), IOverrideCheckResult.OverrideCheckDetails.TYPE_PARAMETER_MISMATCH);
	}

	@Test
	public void testShadowedMethodResolution_06() throws Exception {
		IResolvedOperation operation = toOperation("(null as testdata.MethodOverrides4).<CharSequence>staticM5()");
		Assert.assertEquals("MethodOverrides3", operation.getDeclaration().getDeclaringType().getSimpleName());
		candidatesAndOverrides(has(operation, 0), 0);
	}

	@Test
	public void testVarArgsMismatch_01() throws Exception {
		IResolvedOperation operation = toOperation("(null as testdata.MethodOverrides4).withVarArgs(null)");
		operation.getDeclaration().setVisibility(JvmVisibility.PROTECTED);
		operation.getOverriddenAndImplementedMethodCandidates().forEach((JvmOperation it) -> it.setVisibility(JvmVisibility.PUBLIC));
		withDetails(candidatesAndOverrides(has(operation, 1), 1), IOverrideCheckResult.OverrideCheckDetails.REDUCED_VISIBILITY,
				IOverrideCheckResult.OverrideCheckDetails.VAR_ARG_MISMATCH);
	}

	@Test
	public void testVarArgsMismatch_02() throws Exception {
		IResolvedOperation operation = toOperation("(null as testdata.MethodOverrides4).withArray(null)");
		operation.getDeclaration().setVisibility(JvmVisibility.PROTECTED);
		operation.getOverriddenAndImplementedMethodCandidates().forEach( (JvmOperation it) -> it.setVisibility(JvmVisibility.DEFAULT));
		withDetails(candidatesAndOverrides(has(operation, 1), 1), IOverrideCheckResult.OverrideCheckDetails.VAR_ARG_MISMATCH);
	}

	@Test
	public void testVarArgsMismatch_03() throws Exception {
		IResolvedOperation operation = toOperation("(null as testdata.MethodOverrides4).withArray(null)");
		JvmOperation declaration = operation.getDeclaration();
		declaration.setVisibility(JvmVisibility.PUBLIC);
		declaration.setStatic(true);
		operation.getOverriddenAndImplementedMethodCandidates().forEach((JvmOperation it) -> {
			it.setVisibility(JvmVisibility.PROTECTED);
			it.setStatic(true);
		});
		withExactDetails(candidatesAndOverrides(has(operation, 1), 1), IOverrideCheckResult.OverrideCheckDetails.SHADOWED,
				IOverrideCheckResult.OverrideCheckDetails.VAR_ARG_MISMATCH);
	}

	@Test
	public void testVarArgsMismatch_04() throws Exception {
		IResolvedOperation operation = toOperation("(null as testdata.MethodOverrides4).withVarArgs(null)");
		JvmOperation declaration = operation.getDeclaration();
		declaration.setVisibility(JvmVisibility.PROTECTED);
		declaration.setStatic(true);
		operation.getOverriddenAndImplementedMethodCandidates().forEach((JvmOperation it) -> {
			it.setVisibility(JvmVisibility.PROTECTED);
		});
		withDetails(candidatesAndOverrides(has(operation, 1), 0), IOverrideCheckResult.OverrideCheckDetails.STATIC_MISMATCH,
				IOverrideCheckResult.OverrideCheckDetails.VAR_ARG_MISMATCH);
	}

	@Test
	public void testSameErasure_01() throws Exception {
		IResolvedOperation operation = toOperation("(null as testdata.MethodOverrides4).sameErasure1(null)");
		JvmOperation declaration = operation.getDeclaration();
		declaration.setVisibility(JvmVisibility.PROTECTED);
		operation.getOverriddenAndImplementedMethodCandidates().forEach((JvmOperation it) -> {
			it.setVisibility(JvmVisibility.PROTECTED);
		});
		withExactDetails(candidatesAndOverrides(has(operation, 1), 0), IOverrideCheckResult.OverrideCheckDetails.PARAMETER_TYPE_MISMATCH,
				IOverrideCheckResult.OverrideCheckDetails.SAME_ERASURE);
	}

	@Test
	public void testSameErasure_02() throws Exception {
		IResolvedOperation operation = toOperation("(null as testdata.MethodOverrides4).sameErasure2(null)");
		JvmOperation declaration = operation.getDeclaration();
		declaration.setVisibility(JvmVisibility.PROTECTED);
		operation.getOverriddenAndImplementedMethodCandidates().forEach( (JvmOperation it) -> {
			it.setVisibility(JvmVisibility.PROTECTED);
		});
		withExactDetails(candidatesAndOverrides(has(operation, 1), 0), IOverrideCheckResult.OverrideCheckDetails.TYPE_PARAMETER_MISMATCH,
				IOverrideCheckResult.OverrideCheckDetails.SAME_ERASURE);
	}

	@Test
	public void testSameErasure_03() throws Exception {
		IResolvedOperation operation = toOperation("(null as testdata.MethodOverrides4).sameErasure3");
		JvmOperation declaration = operation.getDeclaration();
		declaration.setVisibility(JvmVisibility.PROTECTED);
		operation.getOverriddenAndImplementedMethodCandidates().forEach((JvmOperation it) -> {
			it.setVisibility(JvmVisibility.PROTECTED);
		});
		withExactDetails(candidatesAndOverrides(has(operation, 1), 0), IOverrideCheckResult.OverrideCheckDetails.TYPE_PARAMETER_MISMATCH,
				IOverrideCheckResult.OverrideCheckDetails.SAME_ERASURE);
	}
}
