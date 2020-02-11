/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import com.google.inject.Inject;
import java.util.Collection;
import java.util.EnumSet;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
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

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class ResolvedOperationTest extends AbstractXbaseTestCase {
  @Inject
  private IBatchTypeResolver typeResolver;
  
  @Inject
  private OverrideTester overrideTester;
  
  public IResolvedOperation toOperation(final String expression) {
    try {
      XExpression _expression = this.expression(expression);
      final XMemberFeatureCall featureCall = ((XMemberFeatureCall) _expression);
      final IResolvedTypes resolvedTypes = this.typeResolver.resolveTypes(featureCall);
      final LightweightTypeReference receiverType = resolvedTypes.getActualType(featureCall.getMemberCallTarget());
      JvmIdentifiableElement _feature = featureCall.getFeature();
      final JvmOperation operation = ((JvmOperation) _feature);
      Assert.assertFalse(operation.eIsProxy());
      return new BottomResolvedOperation(operation, receiverType, this.overrideTester);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testArrayListIteratorIsBottom() {
    final IResolvedOperation operation = this.toOperation("newArrayList.iterator");
    Assert.assertTrue(operation.isBottomInContext());
    Assert.assertEquals("ArrayList<Object>", operation.getContextType().getSimpleName());
    Assert.assertEquals("iterator", operation.getDeclaration().getSimpleName());
  }
  
  @Test
  public void testArrayListOfStringIteratesStrings() {
    final IResolvedOperation operation = this.toOperation("newArrayList(\"\").iterator");
    Assert.assertEquals("ArrayList<String>", operation.getContextType().getSimpleName());
    Assert.assertEquals("Iterator<String>", operation.getResolvedReturnType().getSimpleName());
  }
  
  @Test
  public void testTypeParameterConstraints() {
    final IResolvedOperation operation = this.toOperation("(null as overrides.AbstractForCharSequence).method");
    Assert.assertTrue(operation.isBottomInContext());
    Assert.assertEquals("AbstractForCharSequence", operation.getContextType().getSimpleName());
    Assert.assertEquals("method", operation.getDeclaration().getSimpleName());
    final List<JvmTypeParameter> typeParameters = operation.getResolvedTypeParameters();
    Assert.assertEquals(2, typeParameters.size());
    final List<LightweightTypeReference> firstConstraints = operation.getResolvedTypeParameterConstraints(0);
    Assert.assertEquals(1, firstConstraints.size());
    Assert.assertEquals("CharSequence", IterableExtensions.<LightweightTypeReference>head(firstConstraints).getSimpleName());
    final List<LightweightTypeReference> secondConstraints = operation.getResolvedTypeParameterConstraints(1);
    Assert.assertEquals(1, secondConstraints.size());
    Assert.assertEquals("V", IterableExtensions.<LightweightTypeReference>head(secondConstraints).getSimpleName());
  }
  
  @Test
  public void testIterableOfStringsIteratesStrings() {
    final IResolvedOperation operation = this.toOperation("(null as Iterable<? extends String>).iterator");
    Assert.assertEquals("Iterator<? extends String>", operation.getResolvedReturnType().getSimpleName());
  }
  
  @Test
  public void testListOfStringToArray() {
    final IResolvedOperation operation = this.toOperation("newArrayList(\"\").toArray(null)");
    Assert.assertEquals("T[]", operation.getResolvedReturnType().getSimpleName());
  }
  
  @Test
  public void testListToArrayInheritsOne() {
    final IResolvedOperation operation = this.toOperation("(null as java.util.List<String>).toArray(null)");
    final List<IResolvedOperation> overridden = operation.getOverriddenAndImplementedMethods();
    Assert.assertEquals(1, overridden.size());
    final JvmTypeParameter typeParameter = IterableExtensions.<JvmTypeParameter>head(IterableExtensions.<IResolvedOperation>head(overridden).getResolvedTypeParameters());
    Assert.assertEquals(operation.getDeclaration(), typeParameter.getDeclarator());
  }
  
  @Test
  public void testArrayListToArrayInheritsTwo() {
    final IResolvedOperation operation = this.toOperation("(null as java.util.ArrayList<String>).toArray(null)");
    final List<IResolvedOperation> overridden = operation.getOverriddenAndImplementedMethods();
    Assert.assertEquals(2, overridden.size());
    final JvmTypeParameter typeParameter = IterableExtensions.<JvmTypeParameter>head(IterableExtensions.<IResolvedOperation>head(overridden).getResolvedTypeParameters());
    Assert.assertEquals(operation.getDeclaration(), typeParameter.getDeclarator());
    final JvmTypeParameter typeParameterOfLast = IterableExtensions.<JvmTypeParameter>head(IterableExtensions.<IResolvedOperation>last(overridden).getResolvedTypeParameters());
    Assert.assertEquals(operation.getDeclaration(), typeParameterOfLast.getDeclarator());
  }
  
  @Test
  public void testListToArrayHasTwoOrThreeCandidates() {
    final IResolvedOperation operation = this.toOperation("(null as java.util.List<String>).toArray(null)");
    final List<JvmOperation> candidates = operation.getOverriddenAndImplementedMethodCandidates();
    final Function1<JvmOperation, String> _function = (JvmOperation it) -> {
      return it.getIdentifier();
    };
    final String message = IterableExtensions.join(ListExtensions.<JvmOperation, String>map(candidates, _function), ", ");
    try {
      Assert.assertEquals(message, 2, candidates.size());
    } catch (final Throwable _t) {
      if (_t instanceof AssertionError) {
        Assert.assertEquals(message, 3, candidates.size());
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  @Test
  public void testArrayListOfStringAcceptsStrings() {
    final IResolvedOperation operation = this.toOperation("newArrayList(\"\").addAll(null)");
    Assert.assertEquals(1, operation.getResolvedParameterTypes().size());
    Assert.assertEquals("Collection<? extends String>", IterableExtensions.<LightweightTypeReference>head(operation.getResolvedParameterTypes()).getSimpleName());
  }
  
  @Test
  public void testHashSetInheritsIterator() {
    final IResolvedOperation operation = this.toOperation("newHashSet(\"\").iterator");
    final List<JvmOperation> candidates = operation.getOverriddenAndImplementedMethodCandidates();
    Assert.assertEquals(2, candidates.size());
    Assert.assertEquals("AbstractCollection", IterableExtensions.<JvmOperation>head(candidates).getDeclaringType().getSimpleName());
    Assert.assertEquals("Set", IterableExtensions.<JvmOperation>last(candidates).getDeclaringType().getSimpleName());
  }
  
  @Test
  public void testInheritedAbstractCollectionIteratorIsNotBottom() {
    final IResolvedOperation operation = this.toOperation("newHashSet(\"\").iterator");
    final List<IResolvedOperation> candidates = operation.getOverriddenAndImplementedMethods();
    Assert.assertFalse(IterableExtensions.<IResolvedOperation>head(candidates).isBottomInContext());
    Assert.assertEquals("AbstractCollection<String>", IterableExtensions.<IResolvedOperation>head(candidates).getAsBottom().getContextType().getSimpleName());
  }
  
  protected IResolvedOperation has(final IResolvedOperation operation, final int candidates) {
    final List<JvmOperation> actualCandidates = operation.getOverriddenAndImplementedMethodCandidates();
    Assert.assertEquals("candidates", candidates, actualCandidates.size());
    return operation;
  }
  
  protected IResolvedOperation candidatesAndOverrides(final IResolvedOperation operation, final int overrides) {
    final List<IResolvedOperation> actualOverrides = operation.getOverriddenAndImplementedMethods();
    Assert.assertEquals("overrides", overrides, actualOverrides.size());
    return operation;
  }
  
  protected void withExactDetails(final IResolvedOperation operation, final IOverrideCheckResult.OverrideCheckDetails... details) {
    Assert.assertEquals(1, operation.getOverriddenAndImplementedMethodCandidates().size());
    final JvmOperation candidate = IterableExtensions.<JvmOperation>head(operation.getOverriddenAndImplementedMethodCandidates());
    final EnumSet<IOverrideCheckResult.OverrideCheckDetails> expectation = EnumSet.<IOverrideCheckResult.OverrideCheckDetails>copyOf(((Collection<IOverrideCheckResult.OverrideCheckDetails>)Conversions.doWrapArray(details)));
    final IOverrideCheckResult checkResult = operation.isOverridingOrImplementing(candidate);
    final EnumSet<IOverrideCheckResult.OverrideCheckDetails> actual = checkResult.getDetails();
    Assert.assertEquals(expectation.toString(), actual.toString());
  }
  
  protected void withDetails(final IResolvedOperation operation, final IOverrideCheckResult.OverrideCheckDetails... details) {
    final Consumer<JvmOperation> _function = (JvmOperation it) -> {
      final IOverrideCheckResult checkResult = operation.isOverridingOrImplementing(it);
      final EnumSet<IOverrideCheckResult.OverrideCheckDetails> actual = checkResult.getDetails();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Failed: ");
      _builder.append(actual);
      _builder.append(".containsAll(");
      List<IOverrideCheckResult.OverrideCheckDetails> _list = IterableExtensions.<IOverrideCheckResult.OverrideCheckDetails>toList(((Iterable<IOverrideCheckResult.OverrideCheckDetails>)Conversions.doWrapArray(details)));
      _builder.append(_list);
      _builder.append(")");
      Assert.assertTrue(_builder.toString(), actual.containsAll(((Collection<?>)Conversions.doWrapArray(details))));
    };
    operation.getOverriddenAndImplementedMethodCandidates().forEach(_function);
  }
  
  protected void withDetail(final IResolvedOperation operation, final IOverrideCheckResult.OverrideCheckDetails detail) {
    final Consumer<JvmOperation> _function = (JvmOperation it) -> {
      final IOverrideCheckResult checkResult = operation.isOverridingOrImplementing(it);
      final EnumSet<IOverrideCheckResult.OverrideCheckDetails> actual = checkResult.getDetails();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Failed: ");
      _builder.append(actual);
      _builder.append(".contains(");
      _builder.append(detail);
      _builder.append(")");
      Assert.assertTrue(_builder.toString(), actual.contains(detail));
    };
    operation.getOverriddenAndImplementedMethodCandidates().forEach(_function);
  }
  
  @Test
  public void testOverrideMethodResolution_01() {
    final IResolvedOperation operation = this.toOperation("(null as testdata.MethodOverrides2).m1(null as Object)");
    this.withDetail(this.candidatesAndOverrides(this.has(operation, 2), 0), IOverrideCheckResult.OverrideCheckDetails.PARAMETER_TYPE_MISMATCH);
  }
  
  @Test
  public void testOverrideMethodResolution_02() {
    final IResolvedOperation operation = this.toOperation("(null as testdata.MethodOverrides2).m1(null /* as String */)");
    this.candidatesAndOverrides(this.has(operation, 0), 0);
  }
  
  @Test
  public void testOverrideMethodResolution_03() {
    final IResolvedOperation operation = this.toOperation("(null as testdata.MethodOverrides4).m1(null)");
    this.withDetail(this.candidatesAndOverrides(this.has(operation, 1), 1), IOverrideCheckResult.OverrideCheckDetails.OVERRIDE);
  }
  
  @Test
  public void testOverrideMethodResolution_04() {
    final IResolvedOperation operation = this.toOperation("(null as testdata.MethodOverrides4).m2(null)");
    this.candidatesAndOverrides(this.has(operation, 1), 1);
  }
  
  @Test
  public void testOverrideMethodResolution_05() {
    final IResolvedOperation operation = this.toOperation("(null as testdata.MethodOverrides4).m3(null)");
    this.withExactDetails(this.candidatesAndOverrides(this.has(operation, 1), 1), IOverrideCheckResult.OverrideCheckDetails.OVERRIDE, IOverrideCheckResult.OverrideCheckDetails.COVARIANT_RETURN, IOverrideCheckResult.OverrideCheckDetails.UNCHECKED_CONVERSION_REQUIRED);
  }
  
  @Test
  public void testOverrideMethodResolution_06() {
    final IResolvedOperation operation = this.toOperation("(null as testdata.MethodOverrides4).m4(null)");
    this.withExactDetails(this.candidatesAndOverrides(this.has(operation, 1), 1), IOverrideCheckResult.OverrideCheckDetails.OVERRIDE, IOverrideCheckResult.OverrideCheckDetails.COVARIANT_RETURN, IOverrideCheckResult.OverrideCheckDetails.UNCHECKED_CONVERSION_REQUIRED);
  }
  
  @Test
  public void testOverrideMethodResolution_07() {
    final IResolvedOperation operation = this.toOperation("(null as testdata.MethodOverrides4).m5(null)");
    this.candidatesAndOverrides(this.has(operation, 1), 1);
  }
  
  @Test
  public void testOverrideMethodResolution_08() {
    final IResolvedOperation operation = this.toOperation("(null as testdata.MethodOverrides4).m6()");
    this.candidatesAndOverrides(this.has(operation, 1), 1);
  }
  
  @Test
  public void testOverrideMethodResolution_09() {
    final IResolvedOperation operation = this.toOperation("(null as testdata.MethodOverrides4).m7()");
    this.candidatesAndOverrides(this.has(operation, 2), 1);
  }
  
  @Test
  public void testOverrideMethodResolution_10() {
    final IResolvedOperation operation = this.toOperation("(null as testdata.MethodOverrides4).m7(null, null, null, null)");
    this.candidatesAndOverrides(this.has(operation, 2), 1);
  }
  
  @Test
  public void testOverrideMethodResolution_11() {
    final IResolvedOperation operation = this.toOperation("(null as testdata.MethodOverrides4).m8()");
    this.candidatesAndOverrides(this.has(operation, 1), 1);
  }
  
  @Test
  public void testOverrideMethodResolution_12() {
    final IResolvedOperation operation = this.toOperation("(null as testdata.MethodOverrides4).m9()");
    this.candidatesAndOverrides(this.has(operation, 1), 1);
  }
  
  @Test
  public void testOverrideMethodResolution_13() {
    final IResolvedOperation operation = this.toOperation("(null as testdata.MethodOverrides4).m10()");
    this.candidatesAndOverrides(this.has(operation, 1), 1);
  }
  
  @Test
  public void testOverrideMethodResolution_14() {
    IResolvedOperation _operation = this.toOperation("(null as testdata.MethodOverrides4).m10()");
    final Procedure1<IResolvedOperation> _function = (IResolvedOperation it) -> {
      final JvmOperation candidate = IterableExtensions.<JvmOperation>head(it.getOverriddenAndImplementedMethodCandidates());
      Assert.assertEquals(1, candidate.getTypeParameters().size());
      Assert.assertEquals(1, it.getDeclaration().getTypeParameters().size());
      it.getDeclaration().getTypeParameters().clear();
      this.withDetail(this.candidatesAndOverrides(this.has(it, 1), 0), IOverrideCheckResult.OverrideCheckDetails.TYPE_PARAMETER_MISMATCH);
    };
    ObjectExtensions.<IResolvedOperation>operator_doubleArrow(_operation, _function);
  }
  
  @Test
  public void testOverrideMethodResolution_15() {
    IResolvedOperation _operation = this.toOperation("(null as overrides.ConcreteForCharSequence).method");
    final Procedure1<IResolvedOperation> _function = (IResolvedOperation it) -> {
      final JvmOperation candidate = IterableExtensions.<JvmOperation>head(it.getOverriddenAndImplementedMethodCandidates());
      Assert.assertEquals(2, candidate.getTypeParameters().size());
      Assert.assertEquals(2, it.getDeclaration().getTypeParameters().size());
      this.withDetails(this.candidatesAndOverrides(this.has(it, 1), 1), IOverrideCheckResult.OverrideCheckDetails.IMPLEMENTATION);
    };
    ObjectExtensions.<IResolvedOperation>operator_doubleArrow(_operation, _function);
  }
  
  @Test
  public void testRawOverrideMethodResolution_01() {
    final IResolvedOperation operation = this.toOperation("(null as testdata.MethodOverrides5).m1(null)");
    this.withDetail(this.candidatesAndOverrides(this.has(operation, 1), 1), IOverrideCheckResult.OverrideCheckDetails.OVERRIDE);
  }
  
  @Test
  public void testRawOverrideMethodResolution_02() {
    final IResolvedOperation operation = this.toOperation("(null as testdata.MethodOverrides5).m2(null)");
    this.candidatesAndOverrides(this.has(operation, 1), 1);
  }
  
  @Test
  public void testRawOverrideMethodResolution_03() {
    final IResolvedOperation operation = this.toOperation("(null as testdata.MethodOverrides5).m3(null)");
    this.withExactDetails(this.candidatesAndOverrides(this.has(operation, 1), 1), IOverrideCheckResult.OverrideCheckDetails.OVERRIDE, IOverrideCheckResult.OverrideCheckDetails.COVARIANT_RETURN);
  }
  
  @Test
  public void testRawOverrideMethodResolution_04() {
    final IResolvedOperation operation = this.toOperation("(null as testdata.MethodOverrides5).m4(null)");
    this.withExactDetails(this.candidatesAndOverrides(this.has(operation, 1), 1), IOverrideCheckResult.OverrideCheckDetails.OVERRIDE, IOverrideCheckResult.OverrideCheckDetails.COVARIANT_RETURN);
  }
  
  @Test
  public void testRawOverrideMethodResolution_05() {
    final IResolvedOperation operation = this.toOperation("(null as testdata.MethodOverrides5).m5(null)");
    this.candidatesAndOverrides(this.has(operation, 1), 1);
  }
  
  @Test
  public void testRawOverrideMethodResolution_06() {
    final IResolvedOperation operation = this.toOperation("(null as testdata.MethodOverrides5).m6()");
    this.candidatesAndOverrides(this.has(operation, 1), 1);
  }
  
  @Test
  public void testRawOverrideMethodResolution_07() {
    final IResolvedOperation operation = this.toOperation("(null as testdata.MethodOverrides5).m7()");
    this.candidatesAndOverrides(this.has(operation, 2), 1);
  }
  
  @Test
  public void testRawOverrideMethodResolution_08() {
    final IResolvedOperation operation = this.toOperation("(null as testdata.MethodOverrides5).m7(null, null, null, null)");
    this.candidatesAndOverrides(this.has(operation, 2), 1);
  }
  
  @Test
  public void testRawOverrideMethodResolution_09() {
    final IResolvedOperation operation = this.toOperation("(null as testdata.MethodOverrides5).m8()");
    this.candidatesAndOverrides(this.has(operation, 1), 1);
  }
  
  @Test
  public void testRawOverrideMethodResolution_10() {
    final IResolvedOperation operation = this.toOperation("(null as testdata.MethodOverrides5).m9()");
    this.candidatesAndOverrides(this.has(operation, 1), 1);
  }
  
  @Test
  public void testPrivateMethodOverride_01() {
    final IResolvedOperation operation = this.toOperation("(null as testdata.MethodOverrides4).privateM1(null)");
    this.withDetails(this.candidatesAndOverrides(this.has(operation, 1), 0), IOverrideCheckResult.OverrideCheckDetails.NOT_VISIBLE, IOverrideCheckResult.OverrideCheckDetails.PARAMETER_TYPE_MISMATCH);
  }
  
  @Test
  public void testShadowedMethodResolution_01() {
    final IResolvedOperation operation = this.toOperation("(null as testdata.MethodOverrides4).staticM1(null)");
    this.withDetail(this.candidatesAndOverrides(this.has(operation, 1), 1), IOverrideCheckResult.OverrideCheckDetails.SHADOWED);
  }
  
  @Test
  public void testShadowedMethodResolution_02() {
    final IResolvedOperation operation = this.toOperation("(null as testdata.MethodOverrides4).staticM2(null)");
    this.withDetail(this.candidatesAndOverrides(this.has(operation, 1), 1), IOverrideCheckResult.OverrideCheckDetails.SHADOWED);
  }
  
  @Test
  public void testShadowedMethodResolution_03() {
    final IResolvedOperation operation = this.toOperation("(null as testdata.MethodOverrides4).staticM3(null)");
    this.withDetail(this.candidatesAndOverrides(this.has(operation, 1), 1), IOverrideCheckResult.OverrideCheckDetails.SHADOWED);
  }
  
  @Test
  public void testShadowedMethodResolution_04() {
    final IResolvedOperation operation = this.toOperation("(null as testdata.MethodOverrides4).staticM4(null)");
    this.withDetail(this.candidatesAndOverrides(this.has(operation, 1), 1), IOverrideCheckResult.OverrideCheckDetails.SHADOWED);
  }
  
  @Test
  public void testShadowedMethodResolution_05() {
    final IResolvedOperation operation = this.toOperation("(null as testdata.MethodOverrides4).<java.io.Serializable>staticM5(null)");
    this.withDetail(this.candidatesAndOverrides(this.has(operation, 1), 0), IOverrideCheckResult.OverrideCheckDetails.TYPE_PARAMETER_MISMATCH);
  }
  
  @Test
  public void testShadowedMethodResolution_06() {
    final IResolvedOperation operation = this.toOperation("(null as testdata.MethodOverrides4).<CharSequence>staticM5()");
    Assert.assertEquals("MethodOverrides3", operation.getDeclaration().getDeclaringType().getSimpleName());
    this.candidatesAndOverrides(this.has(operation, 0), 0);
  }
  
  @Test
  public void testVarArgsMismatch_01() {
    final IResolvedOperation operation = this.toOperation("(null as testdata.MethodOverrides4).withVarArgs(null)");
    JvmOperation _declaration = operation.getDeclaration();
    _declaration.setVisibility(JvmVisibility.PROTECTED);
    final Consumer<JvmOperation> _function = (JvmOperation it) -> {
      it.setVisibility(JvmVisibility.PUBLIC);
    };
    operation.getOverriddenAndImplementedMethodCandidates().forEach(_function);
    this.withDetails(this.candidatesAndOverrides(this.has(operation, 1), 1), IOverrideCheckResult.OverrideCheckDetails.REDUCED_VISIBILITY, IOverrideCheckResult.OverrideCheckDetails.VAR_ARG_MISMATCH);
  }
  
  @Test
  public void testVarArgsMismatch_02() {
    final IResolvedOperation operation = this.toOperation("(null as testdata.MethodOverrides4).withArray(null)");
    JvmOperation _declaration = operation.getDeclaration();
    _declaration.setVisibility(JvmVisibility.PROTECTED);
    final Consumer<JvmOperation> _function = (JvmOperation it) -> {
      it.setVisibility(JvmVisibility.DEFAULT);
    };
    operation.getOverriddenAndImplementedMethodCandidates().forEach(_function);
    this.withDetails(this.candidatesAndOverrides(this.has(operation, 1), 1), IOverrideCheckResult.OverrideCheckDetails.VAR_ARG_MISMATCH);
  }
  
  @Test
  public void testVarArgsMismatch_03() {
    final IResolvedOperation operation = this.toOperation("(null as testdata.MethodOverrides4).withArray(null)");
    JvmOperation _declaration = operation.getDeclaration();
    final Procedure1<JvmOperation> _function = (JvmOperation it) -> {
      it.setVisibility(JvmVisibility.PUBLIC);
      it.setStatic(true);
    };
    ObjectExtensions.<JvmOperation>operator_doubleArrow(_declaration, _function);
    final Consumer<JvmOperation> _function_1 = (JvmOperation it) -> {
      it.setVisibility(JvmVisibility.PROTECTED);
      it.setStatic(true);
    };
    operation.getOverriddenAndImplementedMethodCandidates().forEach(_function_1);
    this.withExactDetails(this.candidatesAndOverrides(this.has(operation, 1), 1), IOverrideCheckResult.OverrideCheckDetails.SHADOWED, IOverrideCheckResult.OverrideCheckDetails.VAR_ARG_MISMATCH);
  }
  
  @Test
  public void testVarArgsMismatch_04() {
    final IResolvedOperation operation = this.toOperation("(null as testdata.MethodOverrides4).withVarArgs(null)");
    JvmOperation _declaration = operation.getDeclaration();
    final Procedure1<JvmOperation> _function = (JvmOperation it) -> {
      it.setVisibility(JvmVisibility.PROTECTED);
      it.setStatic(true);
    };
    ObjectExtensions.<JvmOperation>operator_doubleArrow(_declaration, _function);
    final Consumer<JvmOperation> _function_1 = (JvmOperation it) -> {
      it.setVisibility(JvmVisibility.PROTECTED);
    };
    operation.getOverriddenAndImplementedMethodCandidates().forEach(_function_1);
    this.withDetails(this.candidatesAndOverrides(this.has(operation, 1), 0), IOverrideCheckResult.OverrideCheckDetails.STATIC_MISMATCH, IOverrideCheckResult.OverrideCheckDetails.VAR_ARG_MISMATCH);
  }
  
  @Test
  public void testSameErasure_01() {
    final IResolvedOperation operation = this.toOperation("(null as testdata.MethodOverrides4).sameErasure1(null)");
    JvmOperation _declaration = operation.getDeclaration();
    final Procedure1<JvmOperation> _function = (JvmOperation it) -> {
      it.setVisibility(JvmVisibility.PROTECTED);
    };
    ObjectExtensions.<JvmOperation>operator_doubleArrow(_declaration, _function);
    final Consumer<JvmOperation> _function_1 = (JvmOperation it) -> {
      it.setVisibility(JvmVisibility.PROTECTED);
    };
    operation.getOverriddenAndImplementedMethodCandidates().forEach(_function_1);
    this.withExactDetails(this.candidatesAndOverrides(this.has(operation, 1), 0), IOverrideCheckResult.OverrideCheckDetails.PARAMETER_TYPE_MISMATCH, IOverrideCheckResult.OverrideCheckDetails.SAME_ERASURE);
  }
  
  @Test
  public void testSameErasure_02() {
    final IResolvedOperation operation = this.toOperation("(null as testdata.MethodOverrides4).sameErasure2(null)");
    JvmOperation _declaration = operation.getDeclaration();
    final Procedure1<JvmOperation> _function = (JvmOperation it) -> {
      it.setVisibility(JvmVisibility.PROTECTED);
    };
    ObjectExtensions.<JvmOperation>operator_doubleArrow(_declaration, _function);
    final Consumer<JvmOperation> _function_1 = (JvmOperation it) -> {
      it.setVisibility(JvmVisibility.PROTECTED);
    };
    operation.getOverriddenAndImplementedMethodCandidates().forEach(_function_1);
    this.withExactDetails(this.candidatesAndOverrides(this.has(operation, 1), 0), IOverrideCheckResult.OverrideCheckDetails.TYPE_PARAMETER_MISMATCH, IOverrideCheckResult.OverrideCheckDetails.SAME_ERASURE);
  }
  
  @Test
  public void testSameErasure_03() {
    final IResolvedOperation operation = this.toOperation("(null as testdata.MethodOverrides4).sameErasure3");
    JvmOperation _declaration = operation.getDeclaration();
    final Procedure1<JvmOperation> _function = (JvmOperation it) -> {
      it.setVisibility(JvmVisibility.PROTECTED);
    };
    ObjectExtensions.<JvmOperation>operator_doubleArrow(_declaration, _function);
    final Consumer<JvmOperation> _function_1 = (JvmOperation it) -> {
      it.setVisibility(JvmVisibility.PROTECTED);
    };
    operation.getOverriddenAndImplementedMethodCandidates().forEach(_function_1);
    this.withExactDetails(this.candidatesAndOverrides(this.has(operation, 1), 0), IOverrideCheckResult.OverrideCheckDetails.TYPE_PARAMETER_MISMATCH, IOverrideCheckResult.OverrideCheckDetails.SAME_ERASURE);
  }
}
