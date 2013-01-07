/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.eclipse.xtext.xbase.tests.typesystem.XbaseNewTypeSystemInjectorProvider;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.override.BottomResolvedOperation;
import org.eclipse.xtext.xbase.typesystem.override.IResolvedOperation;
import org.eclipse.xtext.xbase.typesystem.override.OverrideTester;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@RunWith(value = XtextRunner.class)
@InjectWith(value = XbaseNewTypeSystemInjectorProvider.class)
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
      BottomResolvedOperation _bottomResolvedOperation = new BottomResolvedOperation(operation, receiverType, this.overrideTester);
      return _bottomResolvedOperation;
    } catch (Exception _e) {
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
    LightweightTypeReference _returnType = operation.getReturnType();
    String _simpleName_1 = _returnType.getSimpleName();
    Assert.assertEquals("Iterator<String>", _simpleName_1);
  }
  
  @Test
  public void testIterableOfStringsIteratesStrings() {
    final IResolvedOperation operation = this.toOperation("(null as Iterable<? extends String>).iterator");
    LightweightTypeReference _returnType = operation.getReturnType();
    String _simpleName = _returnType.getSimpleName();
    Assert.assertEquals("Iterator<? extends String>", _simpleName);
  }
  
  @Test
  public void testListOfStringToArray() {
    final IResolvedOperation operation = this.toOperation("newArrayList(\"\").toArray(null)");
    LightweightTypeReference _returnType = operation.getReturnType();
    String _simpleName = _returnType.getSimpleName();
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
    List<LightweightTypeReference> _parameterTypes = operation.getParameterTypes();
    int _size = _parameterTypes.size();
    Assert.assertEquals(1, _size);
    List<LightweightTypeReference> _parameterTypes_1 = operation.getParameterTypes();
    LightweightTypeReference _head = IterableExtensions.<LightweightTypeReference>head(_parameterTypes_1);
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
  
  @Test
  public void testOverrideMethodResolution_01() {
    final IResolvedOperation operation = this.toOperation("(null as testdata.MethodOverrides2).m1(null as Object)");
    final List<JvmOperation> candidates = operation.getOverriddenAndImplementedMethodCandidates();
    int _size = candidates.size();
    Assert.assertEquals(2, _size);
    final List<IResolvedOperation> overriddenMethods = operation.getOverriddenAndImplementedMethods();
    boolean _isEmpty = overriddenMethods.isEmpty();
    Assert.assertTrue(_isEmpty);
  }
  
  @Test
  public void testOverrideMethodResolution_02() {
    final IResolvedOperation operation = this.toOperation("(null as testdata.MethodOverrides2).m1(null /* as String */)");
    final List<JvmOperation> candidates = operation.getOverriddenAndImplementedMethodCandidates();
    boolean _isEmpty = candidates.isEmpty();
    Assert.assertTrue(_isEmpty);
    final List<IResolvedOperation> overriddenMethods = operation.getOverriddenAndImplementedMethods();
    boolean _isEmpty_1 = overriddenMethods.isEmpty();
    Assert.assertTrue(_isEmpty_1);
  }
  
  @Test
  public void testOverrideMethodResolution_03() {
    final IResolvedOperation operation = this.toOperation("(null as testdata.MethodOverrides4).m1(null)");
    final List<JvmOperation> candidates = operation.getOverriddenAndImplementedMethodCandidates();
    int _size = candidates.size();
    Assert.assertEquals(1, _size);
    final List<IResolvedOperation> overriddenMethods = operation.getOverriddenAndImplementedMethods();
    int _size_1 = overriddenMethods.size();
    Assert.assertEquals(1, _size_1);
  }
  
  @Test
  public void testOverrideMethodResolution_04() {
    final IResolvedOperation operation = this.toOperation("(null as testdata.MethodOverrides4).m2(null)");
    final List<JvmOperation> candidates = operation.getOverriddenAndImplementedMethodCandidates();
    int _size = candidates.size();
    Assert.assertEquals(1, _size);
    final List<IResolvedOperation> overriddenMethods = operation.getOverriddenAndImplementedMethods();
    int _size_1 = overriddenMethods.size();
    Assert.assertEquals(1, _size_1);
  }
  
  @Test
  public void testOverrideMethodResolution_05() {
    final IResolvedOperation operation = this.toOperation("(null as testdata.MethodOverrides4).m3(null)");
    final List<JvmOperation> candidates = operation.getOverriddenAndImplementedMethodCandidates();
    int _size = candidates.size();
    Assert.assertEquals(1, _size);
    final List<IResolvedOperation> overriddenMethods = operation.getOverriddenAndImplementedMethods();
    int _size_1 = overriddenMethods.size();
    Assert.assertEquals(1, _size_1);
  }
  
  @Test
  public void testOverrideMethodResolution_06() {
    final IResolvedOperation operation = this.toOperation("(null as testdata.MethodOverrides4).m4(null)");
    final List<JvmOperation> candidates = operation.getOverriddenAndImplementedMethodCandidates();
    int _size = candidates.size();
    Assert.assertEquals(1, _size);
    final List<IResolvedOperation> overriddenMethods = operation.getOverriddenAndImplementedMethods();
    int _size_1 = overriddenMethods.size();
    Assert.assertEquals(1, _size_1);
  }
  
  @Test
  public void testOverrideMethodResolution_07() {
    final IResolvedOperation operation = this.toOperation("(null as testdata.MethodOverrides4).m5(null)");
    final List<JvmOperation> candidates = operation.getOverriddenAndImplementedMethodCandidates();
    int _size = candidates.size();
    Assert.assertEquals(1, _size);
    final List<IResolvedOperation> overriddenMethods = operation.getOverriddenAndImplementedMethods();
    int _size_1 = overriddenMethods.size();
    Assert.assertEquals(1, _size_1);
  }
  
  @Test
  public void testOverrideMethodResolution_08() {
    final IResolvedOperation operation = this.toOperation("(null as testdata.MethodOverrides4).m6(null)");
    final List<JvmOperation> candidates = operation.getOverriddenAndImplementedMethodCandidates();
    int _size = candidates.size();
    Assert.assertEquals(1, _size);
    final List<IResolvedOperation> overriddenMethods = operation.getOverriddenAndImplementedMethods();
    int _size_1 = overriddenMethods.size();
    Assert.assertEquals(1, _size_1);
  }
  
  @Test
  public void testOverrideMethodResolution_09() {
    final IResolvedOperation operation = this.toOperation("(null as testdata.MethodOverrides4).m7(null)");
    final List<JvmOperation> candidates = operation.getOverriddenAndImplementedMethodCandidates();
    int _size = candidates.size();
    Assert.assertEquals(1, _size);
    final List<IResolvedOperation> overriddenMethods = operation.getOverriddenAndImplementedMethods();
    int _size_1 = overriddenMethods.size();
    Assert.assertEquals(1, _size_1);
  }
  
  @Test
  public void testOverrideMethodResolution_10() {
    final IResolvedOperation operation = this.toOperation("(null as testdata.MethodOverrides4).m8(null)");
    final List<JvmOperation> candidates = operation.getOverriddenAndImplementedMethodCandidates();
    int _size = candidates.size();
    Assert.assertEquals(1, _size);
    final List<IResolvedOperation> overriddenMethods = operation.getOverriddenAndImplementedMethods();
    int _size_1 = overriddenMethods.size();
    Assert.assertEquals(1, _size_1);
  }
  
  @Test
  public void testOverrideMethodResolution_11() {
    final IResolvedOperation operation = this.toOperation("(null as testdata.MethodOverrides4).m9(null)");
    final List<JvmOperation> candidates = operation.getOverriddenAndImplementedMethodCandidates();
    int _size = candidates.size();
    Assert.assertEquals(1, _size);
    final List<IResolvedOperation> overriddenMethods = operation.getOverriddenAndImplementedMethods();
    int _size_1 = overriddenMethods.size();
    Assert.assertEquals(1, _size_1);
  }
  
  @Test
  public void testRawOverrideMethodResolution_01() {
    final IResolvedOperation operation = this.toOperation("(null as testdata.MethodOverrides5).m1(null)");
    final List<JvmOperation> candidates = operation.getOverriddenAndImplementedMethodCandidates();
    int _size = candidates.size();
    Assert.assertEquals(1, _size);
    final List<IResolvedOperation> overriddenMethods = operation.getOverriddenAndImplementedMethods();
    int _size_1 = overriddenMethods.size();
    Assert.assertEquals(1, _size_1);
  }
  
  @Test
  public void testRawOverrideMethodResolution_02() {
    final IResolvedOperation operation = this.toOperation("(null as testdata.MethodOverrides5).m2(null)");
    final List<JvmOperation> candidates = operation.getOverriddenAndImplementedMethodCandidates();
    int _size = candidates.size();
    Assert.assertEquals(1, _size);
    final List<IResolvedOperation> overriddenMethods = operation.getOverriddenAndImplementedMethods();
    int _size_1 = overriddenMethods.size();
    Assert.assertEquals(1, _size_1);
  }
  
  @Test
  public void testRawOverrideMethodResolution_03() {
    final IResolvedOperation operation = this.toOperation("(null as testdata.MethodOverrides5).m3(null)");
    final List<JvmOperation> candidates = operation.getOverriddenAndImplementedMethodCandidates();
    int _size = candidates.size();
    Assert.assertEquals(1, _size);
    final List<IResolvedOperation> overriddenMethods = operation.getOverriddenAndImplementedMethods();
    int _size_1 = overriddenMethods.size();
    Assert.assertEquals(1, _size_1);
  }
  
  @Test
  public void testRawOverrideMethodResolution_04() {
    final IResolvedOperation operation = this.toOperation("(null as testdata.MethodOverrides5).m4(null)");
    final List<JvmOperation> candidates = operation.getOverriddenAndImplementedMethodCandidates();
    int _size = candidates.size();
    Assert.assertEquals(1, _size);
    final List<IResolvedOperation> overriddenMethods = operation.getOverriddenAndImplementedMethods();
    int _size_1 = overriddenMethods.size();
    Assert.assertEquals(1, _size_1);
  }
  
  @Test
  public void testRawOverrideMethodResolution_05() {
    final IResolvedOperation operation = this.toOperation("(null as testdata.MethodOverrides5).m5(null)");
    final List<JvmOperation> candidates = operation.getOverriddenAndImplementedMethodCandidates();
    int _size = candidates.size();
    Assert.assertEquals(1, _size);
    final List<IResolvedOperation> overriddenMethods = operation.getOverriddenAndImplementedMethods();
    int _size_1 = overriddenMethods.size();
    Assert.assertEquals(1, _size_1);
  }
  
  @Test
  public void testRawOverrideMethodResolution_06() {
    final IResolvedOperation operation = this.toOperation("(null as testdata.MethodOverrides5).m6(null)");
    final List<JvmOperation> candidates = operation.getOverriddenAndImplementedMethodCandidates();
    int _size = candidates.size();
    Assert.assertEquals(1, _size);
    final List<IResolvedOperation> overriddenMethods = operation.getOverriddenAndImplementedMethods();
    int _size_1 = overriddenMethods.size();
    Assert.assertEquals(1, _size_1);
  }
  
  @Test
  public void testRawOverrideMethodResolution_07() {
    final IResolvedOperation operation = this.toOperation("(null as testdata.MethodOverrides5).m7(null)");
    final List<JvmOperation> candidates = operation.getOverriddenAndImplementedMethodCandidates();
    int _size = candidates.size();
    Assert.assertEquals(1, _size);
    final List<IResolvedOperation> overriddenMethods = operation.getOverriddenAndImplementedMethods();
    int _size_1 = overriddenMethods.size();
    Assert.assertEquals(1, _size_1);
  }
  
  @Test
  public void testRawOverrideMethodResolution_08() {
    final IResolvedOperation operation = this.toOperation("(null as testdata.MethodOverrides5).m8(null)");
    final List<JvmOperation> candidates = operation.getOverriddenAndImplementedMethodCandidates();
    int _size = candidates.size();
    Assert.assertEquals(1, _size);
    final List<IResolvedOperation> overriddenMethods = operation.getOverriddenAndImplementedMethods();
    int _size_1 = overriddenMethods.size();
    Assert.assertEquals(1, _size_1);
  }
  
  @Test
  public void testRawOverrideMethodResolution_09() {
    final IResolvedOperation operation = this.toOperation("(null as testdata.MethodOverrides5).m9(null)");
    final List<JvmOperation> candidates = operation.getOverriddenAndImplementedMethodCandidates();
    int _size = candidates.size();
    Assert.assertEquals(1, _size);
    final List<IResolvedOperation> overriddenMethods = operation.getOverriddenAndImplementedMethods();
    int _size_1 = overriddenMethods.size();
    Assert.assertEquals(1, _size_1);
  }
}
