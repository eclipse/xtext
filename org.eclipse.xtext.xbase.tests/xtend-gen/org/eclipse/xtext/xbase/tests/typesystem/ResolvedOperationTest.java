/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import com.google.inject.Inject;
import java.util.Collection;
import java.util.EnumSet;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
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
      XExpression _memberCallTarget = featureCall.getMemberCallTarget();
      final LightweightTypeReference receiverType = resolvedTypes.getActualType(_memberCallTarget);
      JvmIdentifiableElement _feature = featureCall.getFeature();
      final JvmOperation operation = ((JvmOperation) _feature);
      boolean _eIsProxy = operation.eIsProxy();
      Assert.assertFalse(_eIsProxy);
      return new BottomResolvedOperation(operation, receiverType, this.overrideTester);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testArrayListIteratorIsBottom() {
    final IResolvedOperation operation = this.toOperation("newArrayList.iterator");
    boolean _isBottomInContext = operation.isBottomInContext();
    Assert.assertTrue(_isBottomInContext);
    LightweightTypeReference _contextType = operation.getContextType();
    String _simpleName = _contextType.getSimpleName();
    Assert.assertEquals("ArrayList<Object>", _simpleName);
    JvmOperation _declaration = operation.getDeclaration();
    String _simpleName_1 = _declaration.getSimpleName();
    Assert.assertEquals("iterator", _simpleName_1);
  }
  
  @Test
  public void testArrayListOfStringIteratesStrings() {
    final IResolvedOperation operation = this.toOperation("newArrayList(\"\").iterator");
    LightweightTypeReference _contextType = operation.getContextType();
    String _simpleName = _contextType.getSimpleName();
    Assert.assertEquals("ArrayList<String>", _simpleName);
    LightweightTypeReference _resolvedReturnType = operation.getResolvedReturnType();
    String _simpleName_1 = _resolvedReturnType.getSimpleName();
    Assert.assertEquals("Iterator<String>", _simpleName_1);
  }
  
  @Test
  public void testTypeParameterConstraints() {
    final IResolvedOperation operation = this.toOperation("(null as overrides.AbstractForCharSequence).method");
    boolean _isBottomInContext = operation.isBottomInContext();
    Assert.assertTrue(_isBottomInContext);
    LightweightTypeReference _contextType = operation.getContextType();
    String _simpleName = _contextType.getSimpleName();
    Assert.assertEquals("AbstractForCharSequence", _simpleName);
    JvmOperation _declaration = operation.getDeclaration();
    String _simpleName_1 = _declaration.getSimpleName();
    Assert.assertEquals("method", _simpleName_1);
    final List<JvmTypeParameter> typeParameters = operation.getResolvedTypeParameters();
    int _size = typeParameters.size();
    Assert.assertEquals(2, _size);
    final List<LightweightTypeReference> firstConstraints = operation.getResolvedTypeParameterConstraints(0);
    int _size_1 = firstConstraints.size();
    Assert.assertEquals(1, _size_1);
    LightweightTypeReference _head = IterableExtensions.<LightweightTypeReference>head(firstConstraints);
    String _simpleName_2 = _head.getSimpleName();
    Assert.assertEquals("CharSequence", _simpleName_2);
    final List<LightweightTypeReference> secondConstraints = operation.getResolvedTypeParameterConstraints(1);
    int _size_2 = secondConstraints.size();
    Assert.assertEquals(1, _size_2);
    LightweightTypeReference _head_1 = IterableExtensions.<LightweightTypeReference>head(secondConstraints);
    String _simpleName_3 = _head_1.getSimpleName();
    Assert.assertEquals("V", _simpleName_3);
  }
  
  @Test
  public void testIterableOfStringsIteratesStrings() {
    final IResolvedOperation operation = this.toOperation("(null as Iterable<? extends String>).iterator");
    LightweightTypeReference _resolvedReturnType = operation.getResolvedReturnType();
    String _simpleName = _resolvedReturnType.getSimpleName();
    Assert.assertEquals("Iterator<? extends String>", _simpleName);
  }
  
  @Test
  public void testListOfStringToArray() {
    final IResolvedOperation operation = this.toOperation("newArrayList(\"\").toArray(null)");
    LightweightTypeReference _resolvedReturnType = operation.getResolvedReturnType();
    String _simpleName = _resolvedReturnType.getSimpleName();
    Assert.assertEquals("T[]", _simpleName);
  }
  
  @Test
  public void testListToArrayInheritsOne() {
    final IResolvedOperation operation = this.toOperation("(null as java.util.List<String>).toArray(null)");
    final List<IResolvedOperation> overridden = operation.getOverriddenAndImplementedMethods();
    int _size = overridden.size();
    Assert.assertEquals(1, _size);
    IResolvedOperation _head = IterableExtensions.<IResolvedOperation>head(overridden);
    List<JvmTypeParameter> _resolvedTypeParameters = _head.getResolvedTypeParameters();
    final JvmTypeParameter typeParameter = IterableExtensions.<JvmTypeParameter>head(_resolvedTypeParameters);
    JvmOperation _declaration = operation.getDeclaration();
    JvmTypeParameterDeclarator _declarator = typeParameter.getDeclarator();
    Assert.assertEquals(_declaration, _declarator);
  }
  
  @Test
  public void testArrayListToArrayInheritsTwo() {
    final IResolvedOperation operation = this.toOperation("(null as java.util.ArrayList<String>).toArray(null)");
    final List<IResolvedOperation> overridden = operation.getOverriddenAndImplementedMethods();
    int _size = overridden.size();
    Assert.assertEquals(2, _size);
    IResolvedOperation _head = IterableExtensions.<IResolvedOperation>head(overridden);
    List<JvmTypeParameter> _resolvedTypeParameters = _head.getResolvedTypeParameters();
    final JvmTypeParameter typeParameter = IterableExtensions.<JvmTypeParameter>head(_resolvedTypeParameters);
    JvmOperation _declaration = operation.getDeclaration();
    JvmTypeParameterDeclarator _declarator = typeParameter.getDeclarator();
    Assert.assertEquals(_declaration, _declarator);
    IResolvedOperation _last = IterableExtensions.<IResolvedOperation>last(overridden);
    List<JvmTypeParameter> _resolvedTypeParameters_1 = _last.getResolvedTypeParameters();
    final JvmTypeParameter typeParameterOfLast = IterableExtensions.<JvmTypeParameter>head(_resolvedTypeParameters_1);
    JvmOperation _declaration_1 = operation.getDeclaration();
    JvmTypeParameterDeclarator _declarator_1 = typeParameterOfLast.getDeclarator();
    Assert.assertEquals(_declaration_1, _declarator_1);
  }
  
  @Test
  public void testListToArrayHasTwoCandidates() {
    final IResolvedOperation operation = this.toOperation("(null as java.util.List<String>).toArray(null)");
    final List<JvmOperation> candidates = operation.getOverriddenAndImplementedMethodCandidates();
    int _size = candidates.size();
    Assert.assertEquals(2, _size);
  }
  
  @Test
  public void testArrayListOfStringAcceptsStrings() {
    final IResolvedOperation operation = this.toOperation("newArrayList(\"\").addAll(null)");
    List<LightweightTypeReference> _resolvedParameterTypes = operation.getResolvedParameterTypes();
    int _size = _resolvedParameterTypes.size();
    Assert.assertEquals(1, _size);
    List<LightweightTypeReference> _resolvedParameterTypes_1 = operation.getResolvedParameterTypes();
    LightweightTypeReference _head = IterableExtensions.<LightweightTypeReference>head(_resolvedParameterTypes_1);
    String _simpleName = _head.getSimpleName();
    Assert.assertEquals("Collection<? extends String>", _simpleName);
  }
  
  @Test
  public void testHashSetInheritsIterator() {
    final IResolvedOperation operation = this.toOperation("newHashSet(\"\").iterator");
    final List<JvmOperation> candidates = operation.getOverriddenAndImplementedMethodCandidates();
    int _size = candidates.size();
    Assert.assertEquals(2, _size);
    JvmOperation _head = IterableExtensions.<JvmOperation>head(candidates);
    JvmDeclaredType _declaringType = _head.getDeclaringType();
    String _simpleName = _declaringType.getSimpleName();
    Assert.assertEquals("AbstractCollection", _simpleName);
    JvmOperation _last = IterableExtensions.<JvmOperation>last(candidates);
    JvmDeclaredType _declaringType_1 = _last.getDeclaringType();
    String _simpleName_1 = _declaringType_1.getSimpleName();
    Assert.assertEquals("Set", _simpleName_1);
  }
  
  @Test
  public void testInheritedAbstractCollectionIteratorIsNotBottom() {
    final IResolvedOperation operation = this.toOperation("newHashSet(\"\").iterator");
    final List<IResolvedOperation> candidates = operation.getOverriddenAndImplementedMethods();
    IResolvedOperation _head = IterableExtensions.<IResolvedOperation>head(candidates);
    boolean _isBottomInContext = _head.isBottomInContext();
    Assert.assertFalse(_isBottomInContext);
    IResolvedOperation _head_1 = IterableExtensions.<IResolvedOperation>head(candidates);
    IResolvedOperation _asBottom = _head_1.getAsBottom();
    LightweightTypeReference _contextType = _asBottom.getContextType();
    String _simpleName = _contextType.getSimpleName();
    Assert.assertEquals("AbstractCollection<String>", _simpleName);
  }
  
  protected IResolvedOperation has(final IResolvedOperation operation, final int candidates) {
    final List<JvmOperation> actualCandidates = operation.getOverriddenAndImplementedMethodCandidates();
    int _size = actualCandidates.size();
    Assert.assertEquals("candidates", candidates, _size);
    return operation;
  }
  
  protected IResolvedOperation candidatesAndOverrides(final IResolvedOperation operation, final int overrides) {
    final List<IResolvedOperation> actualOverrides = operation.getOverriddenAndImplementedMethods();
    int _size = actualOverrides.size();
    Assert.assertEquals("overrides", overrides, _size);
    return operation;
  }
  
  protected void withExactDetails(final IResolvedOperation operation, final IOverrideCheckResult.OverrideCheckDetails... details) {
    List<JvmOperation> _overriddenAndImplementedMethodCandidates = operation.getOverriddenAndImplementedMethodCandidates();
    int _size = _overriddenAndImplementedMethodCandidates.size();
    Assert.assertEquals(1, _size);
    List<JvmOperation> _overriddenAndImplementedMethodCandidates_1 = operation.getOverriddenAndImplementedMethodCandidates();
    final JvmOperation candidate = IterableExtensions.<JvmOperation>head(_overriddenAndImplementedMethodCandidates_1);
    final EnumSet<IOverrideCheckResult.OverrideCheckDetails> expectation = EnumSet.<IOverrideCheckResult.OverrideCheckDetails>copyOf(((Collection<IOverrideCheckResult.OverrideCheckDetails>)Conversions.doWrapArray(details)));
    final IOverrideCheckResult checkResult = operation.isOverridingOrImplementing(candidate);
    final EnumSet<IOverrideCheckResult.OverrideCheckDetails> actual = checkResult.getDetails();
    String _string = expectation.toString();
    String _string_1 = actual.toString();
    Assert.assertEquals(_string, _string_1);
  }
  
  protected void withDetails(final IResolvedOperation operation, final IOverrideCheckResult.OverrideCheckDetails... details) {
    List<JvmOperation> _overriddenAndImplementedMethodCandidates = operation.getOverriddenAndImplementedMethodCandidates();
    final Consumer<JvmOperation> _function = (JvmOperation it) -> {
      final IOverrideCheckResult checkResult = operation.isOverridingOrImplementing(it);
      final EnumSet<IOverrideCheckResult.OverrideCheckDetails> actual = checkResult.getDetails();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Failed: ");
      _builder.append(actual, "");
      _builder.append(".containsAll(");
      List<IOverrideCheckResult.OverrideCheckDetails> _list = IterableExtensions.<IOverrideCheckResult.OverrideCheckDetails>toList(((Iterable<IOverrideCheckResult.OverrideCheckDetails>)Conversions.doWrapArray(details)));
      _builder.append(_list, "");
      _builder.append(")");
      boolean _containsAll = actual.containsAll(((Collection<?>)Conversions.doWrapArray(details)));
      Assert.assertTrue(_builder.toString(), _containsAll);
    };
    _overriddenAndImplementedMethodCandidates.forEach(_function);
  }
  
  protected void withDetail(final IResolvedOperation operation, final IOverrideCheckResult.OverrideCheckDetails detail) {
    List<JvmOperation> _overriddenAndImplementedMethodCandidates = operation.getOverriddenAndImplementedMethodCandidates();
    final Consumer<JvmOperation> _function = (JvmOperation it) -> {
      final IOverrideCheckResult checkResult = operation.isOverridingOrImplementing(it);
      final EnumSet<IOverrideCheckResult.OverrideCheckDetails> actual = checkResult.getDetails();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Failed: ");
      _builder.append(actual, "");
      _builder.append(".contains(");
      _builder.append(detail, "");
      _builder.append(")");
      boolean _contains = actual.contains(detail);
      Assert.assertTrue(_builder.toString(), _contains);
    };
    _overriddenAndImplementedMethodCandidates.forEach(_function);
  }
  
  @Test
  public void testOverrideMethodResolution_01() {
    final IResolvedOperation operation = this.toOperation("(null as testdata.MethodOverrides2).m1(null as Object)");
    IResolvedOperation _has = this.has(operation, 2);
    IResolvedOperation _candidatesAndOverrides = this.candidatesAndOverrides(_has, 0);
    this.withDetail(_candidatesAndOverrides, IOverrideCheckResult.OverrideCheckDetails.PARAMETER_TYPE_MISMATCH);
  }
  
  @Test
  public void testOverrideMethodResolution_02() {
    final IResolvedOperation operation = this.toOperation("(null as testdata.MethodOverrides2).m1(null /* as String */)");
    IResolvedOperation _has = this.has(operation, 0);
    this.candidatesAndOverrides(_has, 0);
  }
  
  @Test
  public void testOverrideMethodResolution_03() {
    final IResolvedOperation operation = this.toOperation("(null as testdata.MethodOverrides4).m1(null)");
    IResolvedOperation _has = this.has(operation, 1);
    IResolvedOperation _candidatesAndOverrides = this.candidatesAndOverrides(_has, 1);
    this.withDetail(_candidatesAndOverrides, IOverrideCheckResult.OverrideCheckDetails.OVERRIDE);
  }
  
  @Test
  public void testOverrideMethodResolution_04() {
    final IResolvedOperation operation = this.toOperation("(null as testdata.MethodOverrides4).m2(null)");
    IResolvedOperation _has = this.has(operation, 1);
    this.candidatesAndOverrides(_has, 1);
  }
  
  @Test
  public void testOverrideMethodResolution_05() {
    final IResolvedOperation operation = this.toOperation("(null as testdata.MethodOverrides4).m3(null)");
    IResolvedOperation _has = this.has(operation, 1);
    IResolvedOperation _candidatesAndOverrides = this.candidatesAndOverrides(_has, 1);
    this.withExactDetails(_candidatesAndOverrides, IOverrideCheckResult.OverrideCheckDetails.OVERRIDE, IOverrideCheckResult.OverrideCheckDetails.COVARIANT_RETURN, IOverrideCheckResult.OverrideCheckDetails.UNCHECKED_CONVERSION_REQUIRED);
  }
  
  @Test
  public void testOverrideMethodResolution_06() {
    final IResolvedOperation operation = this.toOperation("(null as testdata.MethodOverrides4).m4(null)");
    IResolvedOperation _has = this.has(operation, 1);
    IResolvedOperation _candidatesAndOverrides = this.candidatesAndOverrides(_has, 1);
    this.withExactDetails(_candidatesAndOverrides, IOverrideCheckResult.OverrideCheckDetails.OVERRIDE, IOverrideCheckResult.OverrideCheckDetails.COVARIANT_RETURN, IOverrideCheckResult.OverrideCheckDetails.UNCHECKED_CONVERSION_REQUIRED);
  }
  
  @Test
  public void testOverrideMethodResolution_07() {
    final IResolvedOperation operation = this.toOperation("(null as testdata.MethodOverrides4).m5(null)");
    IResolvedOperation _has = this.has(operation, 1);
    this.candidatesAndOverrides(_has, 1);
  }
  
  @Test
  public void testOverrideMethodResolution_08() {
    final IResolvedOperation operation = this.toOperation("(null as testdata.MethodOverrides4).m6()");
    IResolvedOperation _has = this.has(operation, 1);
    this.candidatesAndOverrides(_has, 1);
  }
  
  @Test
  public void testOverrideMethodResolution_09() {
    final IResolvedOperation operation = this.toOperation("(null as testdata.MethodOverrides4).m7()");
    IResolvedOperation _has = this.has(operation, 2);
    this.candidatesAndOverrides(_has, 1);
  }
  
  @Test
  public void testOverrideMethodResolution_10() {
    final IResolvedOperation operation = this.toOperation("(null as testdata.MethodOverrides4).m7(null, null, null, null)");
    IResolvedOperation _has = this.has(operation, 2);
    this.candidatesAndOverrides(_has, 1);
  }
  
  @Test
  public void testOverrideMethodResolution_11() {
    final IResolvedOperation operation = this.toOperation("(null as testdata.MethodOverrides4).m8()");
    IResolvedOperation _has = this.has(operation, 1);
    this.candidatesAndOverrides(_has, 1);
  }
  
  @Test
  public void testOverrideMethodResolution_12() {
    final IResolvedOperation operation = this.toOperation("(null as testdata.MethodOverrides4).m9()");
    IResolvedOperation _has = this.has(operation, 1);
    this.candidatesAndOverrides(_has, 1);
  }
  
  @Test
  public void testOverrideMethodResolution_13() {
    final IResolvedOperation operation = this.toOperation("(null as testdata.MethodOverrides4).m10()");
    IResolvedOperation _has = this.has(operation, 1);
    this.candidatesAndOverrides(_has, 1);
  }
  
  @Test
  public void testOverrideMethodResolution_14() {
    IResolvedOperation _operation = this.toOperation("(null as testdata.MethodOverrides4).m10()");
    final Procedure1<IResolvedOperation> _function = (IResolvedOperation it) -> {
      List<JvmOperation> _overriddenAndImplementedMethodCandidates = it.getOverriddenAndImplementedMethodCandidates();
      final JvmOperation candidate = IterableExtensions.<JvmOperation>head(_overriddenAndImplementedMethodCandidates);
      EList<JvmTypeParameter> _typeParameters = candidate.getTypeParameters();
      int _size = _typeParameters.size();
      Assert.assertEquals(1, _size);
      JvmOperation _declaration = it.getDeclaration();
      EList<JvmTypeParameter> _typeParameters_1 = _declaration.getTypeParameters();
      int _size_1 = _typeParameters_1.size();
      Assert.assertEquals(1, _size_1);
      JvmOperation _declaration_1 = it.getDeclaration();
      EList<JvmTypeParameter> _typeParameters_2 = _declaration_1.getTypeParameters();
      _typeParameters_2.clear();
      IResolvedOperation _has = this.has(it, 1);
      IResolvedOperation _candidatesAndOverrides = this.candidatesAndOverrides(_has, 0);
      this.withDetail(_candidatesAndOverrides, IOverrideCheckResult.OverrideCheckDetails.TYPE_PARAMETER_MISMATCH);
    };
    ObjectExtensions.<IResolvedOperation>operator_doubleArrow(_operation, _function);
  }
  
  @Test
  public void testOverrideMethodResolution_15() {
    IResolvedOperation _operation = this.toOperation("(null as overrides.ConcreteForCharSequence).method");
    final Procedure1<IResolvedOperation> _function = (IResolvedOperation it) -> {
      List<JvmOperation> _overriddenAndImplementedMethodCandidates = it.getOverriddenAndImplementedMethodCandidates();
      final JvmOperation candidate = IterableExtensions.<JvmOperation>head(_overriddenAndImplementedMethodCandidates);
      EList<JvmTypeParameter> _typeParameters = candidate.getTypeParameters();
      int _size = _typeParameters.size();
      Assert.assertEquals(2, _size);
      JvmOperation _declaration = it.getDeclaration();
      EList<JvmTypeParameter> _typeParameters_1 = _declaration.getTypeParameters();
      int _size_1 = _typeParameters_1.size();
      Assert.assertEquals(2, _size_1);
      IResolvedOperation _has = this.has(it, 1);
      IResolvedOperation _candidatesAndOverrides = this.candidatesAndOverrides(_has, 1);
      this.withDetails(_candidatesAndOverrides, IOverrideCheckResult.OverrideCheckDetails.IMPLEMENTATION);
    };
    ObjectExtensions.<IResolvedOperation>operator_doubleArrow(_operation, _function);
  }
  
  @Test
  public void testRawOverrideMethodResolution_01() {
    final IResolvedOperation operation = this.toOperation("(null as testdata.MethodOverrides5).m1(null)");
    IResolvedOperation _has = this.has(operation, 1);
    IResolvedOperation _candidatesAndOverrides = this.candidatesAndOverrides(_has, 1);
    this.withDetail(_candidatesAndOverrides, IOverrideCheckResult.OverrideCheckDetails.OVERRIDE);
  }
  
  @Test
  public void testRawOverrideMethodResolution_02() {
    final IResolvedOperation operation = this.toOperation("(null as testdata.MethodOverrides5).m2(null)");
    IResolvedOperation _has = this.has(operation, 1);
    this.candidatesAndOverrides(_has, 1);
  }
  
  @Test
  public void testRawOverrideMethodResolution_03() {
    final IResolvedOperation operation = this.toOperation("(null as testdata.MethodOverrides5).m3(null)");
    IResolvedOperation _has = this.has(operation, 1);
    IResolvedOperation _candidatesAndOverrides = this.candidatesAndOverrides(_has, 1);
    this.withExactDetails(_candidatesAndOverrides, IOverrideCheckResult.OverrideCheckDetails.OVERRIDE, IOverrideCheckResult.OverrideCheckDetails.COVARIANT_RETURN);
  }
  
  @Test
  public void testRawOverrideMethodResolution_04() {
    final IResolvedOperation operation = this.toOperation("(null as testdata.MethodOverrides5).m4(null)");
    IResolvedOperation _has = this.has(operation, 1);
    IResolvedOperation _candidatesAndOverrides = this.candidatesAndOverrides(_has, 1);
    this.withExactDetails(_candidatesAndOverrides, IOverrideCheckResult.OverrideCheckDetails.OVERRIDE, IOverrideCheckResult.OverrideCheckDetails.COVARIANT_RETURN);
  }
  
  @Test
  public void testRawOverrideMethodResolution_05() {
    final IResolvedOperation operation = this.toOperation("(null as testdata.MethodOverrides5).m5(null)");
    IResolvedOperation _has = this.has(operation, 1);
    this.candidatesAndOverrides(_has, 1);
  }
  
  @Test
  public void testRawOverrideMethodResolution_06() {
    final IResolvedOperation operation = this.toOperation("(null as testdata.MethodOverrides5).m6()");
    IResolvedOperation _has = this.has(operation, 1);
    this.candidatesAndOverrides(_has, 1);
  }
  
  @Test
  public void testRawOverrideMethodResolution_07() {
    final IResolvedOperation operation = this.toOperation("(null as testdata.MethodOverrides5).m7()");
    IResolvedOperation _has = this.has(operation, 2);
    this.candidatesAndOverrides(_has, 1);
  }
  
  @Test
  public void testRawOverrideMethodResolution_08() {
    final IResolvedOperation operation = this.toOperation("(null as testdata.MethodOverrides5).m7(null, null, null, null)");
    IResolvedOperation _has = this.has(operation, 2);
    this.candidatesAndOverrides(_has, 1);
  }
  
  @Test
  public void testRawOverrideMethodResolution_09() {
    final IResolvedOperation operation = this.toOperation("(null as testdata.MethodOverrides5).m8()");
    IResolvedOperation _has = this.has(operation, 1);
    this.candidatesAndOverrides(_has, 1);
  }
  
  @Test
  public void testRawOverrideMethodResolution_10() {
    final IResolvedOperation operation = this.toOperation("(null as testdata.MethodOverrides5).m9()");
    IResolvedOperation _has = this.has(operation, 1);
    this.candidatesAndOverrides(_has, 1);
  }
  
  @Test
  public void testPrivateMethodOverride_01() {
    final IResolvedOperation operation = this.toOperation("(null as testdata.MethodOverrides4).privateM1(null)");
    IResolvedOperation _has = this.has(operation, 1);
    IResolvedOperation _candidatesAndOverrides = this.candidatesAndOverrides(_has, 0);
    this.withDetails(_candidatesAndOverrides, IOverrideCheckResult.OverrideCheckDetails.NOT_VISIBLE, IOverrideCheckResult.OverrideCheckDetails.PARAMETER_TYPE_MISMATCH);
  }
  
  @Test
  public void testShadowedMethodResolution_01() {
    final IResolvedOperation operation = this.toOperation("(null as testdata.MethodOverrides4).staticM1(null)");
    IResolvedOperation _has = this.has(operation, 1);
    IResolvedOperation _candidatesAndOverrides = this.candidatesAndOverrides(_has, 1);
    this.withDetail(_candidatesAndOverrides, IOverrideCheckResult.OverrideCheckDetails.SHADOWED);
  }
  
  @Test
  public void testShadowedMethodResolution_02() {
    final IResolvedOperation operation = this.toOperation("(null as testdata.MethodOverrides4).staticM2(null)");
    IResolvedOperation _has = this.has(operation, 1);
    IResolvedOperation _candidatesAndOverrides = this.candidatesAndOverrides(_has, 1);
    this.withDetail(_candidatesAndOverrides, IOverrideCheckResult.OverrideCheckDetails.SHADOWED);
  }
  
  @Test
  public void testShadowedMethodResolution_03() {
    final IResolvedOperation operation = this.toOperation("(null as testdata.MethodOverrides4).staticM3(null)");
    IResolvedOperation _has = this.has(operation, 1);
    IResolvedOperation _candidatesAndOverrides = this.candidatesAndOverrides(_has, 1);
    this.withDetail(_candidatesAndOverrides, IOverrideCheckResult.OverrideCheckDetails.SHADOWED);
  }
  
  @Test
  public void testShadowedMethodResolution_04() {
    final IResolvedOperation operation = this.toOperation("(null as testdata.MethodOverrides4).staticM4(null)");
    IResolvedOperation _has = this.has(operation, 1);
    IResolvedOperation _candidatesAndOverrides = this.candidatesAndOverrides(_has, 1);
    this.withDetail(_candidatesAndOverrides, IOverrideCheckResult.OverrideCheckDetails.SHADOWED);
  }
  
  @Test
  public void testShadowedMethodResolution_05() {
    final IResolvedOperation operation = this.toOperation("(null as testdata.MethodOverrides4).<java.io.Serializable>staticM5()");
    IResolvedOperation _has = this.has(operation, 1);
    IResolvedOperation _candidatesAndOverrides = this.candidatesAndOverrides(_has, 0);
    this.withDetail(_candidatesAndOverrides, IOverrideCheckResult.OverrideCheckDetails.TYPE_PARAMETER_MISMATCH);
  }
  
  @Test
  public void testShadowedMethodResolution_06() {
    final IResolvedOperation operation = this.toOperation("(null as testdata.MethodOverrides4).<CharSequence>staticM5()");
    JvmOperation _declaration = operation.getDeclaration();
    JvmDeclaredType _declaringType = _declaration.getDeclaringType();
    String _simpleName = _declaringType.getSimpleName();
    Assert.assertEquals("MethodOverrides3", _simpleName);
    IResolvedOperation _has = this.has(operation, 0);
    this.candidatesAndOverrides(_has, 0);
  }
  
  @Test
  public void testVarArgsMismatch_01() {
    final IResolvedOperation operation = this.toOperation("(null as testdata.MethodOverrides4).withVarArgs(null)");
    JvmOperation _declaration = operation.getDeclaration();
    _declaration.setVisibility(JvmVisibility.PROTECTED);
    List<JvmOperation> _overriddenAndImplementedMethodCandidates = operation.getOverriddenAndImplementedMethodCandidates();
    final Consumer<JvmOperation> _function = (JvmOperation it) -> {
      it.setVisibility(JvmVisibility.PUBLIC);
    };
    _overriddenAndImplementedMethodCandidates.forEach(_function);
    IResolvedOperation _has = this.has(operation, 1);
    IResolvedOperation _candidatesAndOverrides = this.candidatesAndOverrides(_has, 1);
    this.withDetails(_candidatesAndOverrides, IOverrideCheckResult.OverrideCheckDetails.REDUCED_VISIBILITY, IOverrideCheckResult.OverrideCheckDetails.VAR_ARG_MISMATCH);
  }
  
  @Test
  public void testVarArgsMismatch_02() {
    final IResolvedOperation operation = this.toOperation("(null as testdata.MethodOverrides4).withArray(null)");
    JvmOperation _declaration = operation.getDeclaration();
    _declaration.setVisibility(JvmVisibility.PROTECTED);
    List<JvmOperation> _overriddenAndImplementedMethodCandidates = operation.getOverriddenAndImplementedMethodCandidates();
    final Consumer<JvmOperation> _function = (JvmOperation it) -> {
      it.setVisibility(JvmVisibility.DEFAULT);
    };
    _overriddenAndImplementedMethodCandidates.forEach(_function);
    IResolvedOperation _has = this.has(operation, 1);
    IResolvedOperation _candidatesAndOverrides = this.candidatesAndOverrides(_has, 1);
    this.withDetails(_candidatesAndOverrides, IOverrideCheckResult.OverrideCheckDetails.VAR_ARG_MISMATCH);
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
    List<JvmOperation> _overriddenAndImplementedMethodCandidates = operation.getOverriddenAndImplementedMethodCandidates();
    final Consumer<JvmOperation> _function_1 = (JvmOperation it) -> {
      it.setVisibility(JvmVisibility.PROTECTED);
      it.setStatic(true);
    };
    _overriddenAndImplementedMethodCandidates.forEach(_function_1);
    IResolvedOperation _has = this.has(operation, 1);
    IResolvedOperation _candidatesAndOverrides = this.candidatesAndOverrides(_has, 1);
    this.withExactDetails(_candidatesAndOverrides, IOverrideCheckResult.OverrideCheckDetails.SHADOWED, IOverrideCheckResult.OverrideCheckDetails.VAR_ARG_MISMATCH);
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
    List<JvmOperation> _overriddenAndImplementedMethodCandidates = operation.getOverriddenAndImplementedMethodCandidates();
    final Consumer<JvmOperation> _function_1 = (JvmOperation it) -> {
      it.setVisibility(JvmVisibility.PROTECTED);
    };
    _overriddenAndImplementedMethodCandidates.forEach(_function_1);
    IResolvedOperation _has = this.has(operation, 1);
    IResolvedOperation _candidatesAndOverrides = this.candidatesAndOverrides(_has, 0);
    this.withDetails(_candidatesAndOverrides, IOverrideCheckResult.OverrideCheckDetails.STATIC_MISMATCH, IOverrideCheckResult.OverrideCheckDetails.VAR_ARG_MISMATCH);
  }
  
  @Test
  public void testSameErasure_01() {
    final IResolvedOperation operation = this.toOperation("(null as testdata.MethodOverrides4).sameErasure1(null)");
    JvmOperation _declaration = operation.getDeclaration();
    final Procedure1<JvmOperation> _function = (JvmOperation it) -> {
      it.setVisibility(JvmVisibility.PROTECTED);
    };
    ObjectExtensions.<JvmOperation>operator_doubleArrow(_declaration, _function);
    List<JvmOperation> _overriddenAndImplementedMethodCandidates = operation.getOverriddenAndImplementedMethodCandidates();
    final Consumer<JvmOperation> _function_1 = (JvmOperation it) -> {
      it.setVisibility(JvmVisibility.PROTECTED);
    };
    _overriddenAndImplementedMethodCandidates.forEach(_function_1);
    IResolvedOperation _has = this.has(operation, 1);
    IResolvedOperation _candidatesAndOverrides = this.candidatesAndOverrides(_has, 0);
    this.withExactDetails(_candidatesAndOverrides, IOverrideCheckResult.OverrideCheckDetails.PARAMETER_TYPE_MISMATCH, IOverrideCheckResult.OverrideCheckDetails.SAME_ERASURE);
  }
  
  @Test
  public void testSameErasure_02() {
    final IResolvedOperation operation = this.toOperation("(null as testdata.MethodOverrides4).sameErasure2(null)");
    JvmOperation _declaration = operation.getDeclaration();
    final Procedure1<JvmOperation> _function = (JvmOperation it) -> {
      it.setVisibility(JvmVisibility.PROTECTED);
    };
    ObjectExtensions.<JvmOperation>operator_doubleArrow(_declaration, _function);
    List<JvmOperation> _overriddenAndImplementedMethodCandidates = operation.getOverriddenAndImplementedMethodCandidates();
    final Consumer<JvmOperation> _function_1 = (JvmOperation it) -> {
      it.setVisibility(JvmVisibility.PROTECTED);
    };
    _overriddenAndImplementedMethodCandidates.forEach(_function_1);
    IResolvedOperation _has = this.has(operation, 1);
    IResolvedOperation _candidatesAndOverrides = this.candidatesAndOverrides(_has, 0);
    this.withExactDetails(_candidatesAndOverrides, IOverrideCheckResult.OverrideCheckDetails.TYPE_PARAMETER_MISMATCH, IOverrideCheckResult.OverrideCheckDetails.SAME_ERASURE);
  }
  
  @Test
  public void testSameErasure_03() {
    final IResolvedOperation operation = this.toOperation("(null as testdata.MethodOverrides4).sameErasure3");
    JvmOperation _declaration = operation.getDeclaration();
    final Procedure1<JvmOperation> _function = (JvmOperation it) -> {
      it.setVisibility(JvmVisibility.PROTECTED);
    };
    ObjectExtensions.<JvmOperation>operator_doubleArrow(_declaration, _function);
    List<JvmOperation> _overriddenAndImplementedMethodCandidates = operation.getOverriddenAndImplementedMethodCandidates();
    final Consumer<JvmOperation> _function_1 = (JvmOperation it) -> {
      it.setVisibility(JvmVisibility.PROTECTED);
    };
    _overriddenAndImplementedMethodCandidates.forEach(_function_1);
    IResolvedOperation _has = this.has(operation, 1);
    IResolvedOperation _candidatesAndOverrides = this.candidatesAndOverrides(_has, 0);
    this.withExactDetails(_candidatesAndOverrides, IOverrideCheckResult.OverrideCheckDetails.TYPE_PARAMETER_MISMATCH, IOverrideCheckResult.OverrideCheckDetails.SAME_ERASURE);
  }
}
