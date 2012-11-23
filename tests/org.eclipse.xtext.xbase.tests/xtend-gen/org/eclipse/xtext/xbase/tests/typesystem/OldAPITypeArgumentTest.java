/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.ITypeArgumentContext;
import org.eclipse.xtext.common.types.util.TypeArgumentContextProvider;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.impl.FeatureCallToJavaMapping;
import org.eclipse.xtext.xbase.jvmmodel.ILogicalContainerProvider;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;
import org.eclipse.xtext.xbase.tests.typesystem.AbstractTypeArgumentTest;
import org.eclipse.xtext.xbase.tests.typesystem.FeatureCallRequest;
import org.eclipse.xtext.xbase.typing.ITypeProvider;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow
 */
@SuppressWarnings("all")
public class OldAPITypeArgumentTest extends AbstractTypeArgumentTest {
  @Inject
  private TypeArgumentContextProvider typeArgumentContextProvider;
  
  @Inject
  private ITypeProvider typeProvider;
  
  @Inject
  private FeatureCallToJavaMapping featureCallToJavaMapping;
  
  @Inject
  private ILogicalContainerProvider logicalContainerProvider;
  
  protected void resolveTypes(final XExpression expression) {
  }
  
  protected void hasTypeArguments(final XExpression expression, final String... typeArguments) {
    boolean _matched = false;
    if (!_matched) {
      if (expression instanceof XAbstractFeatureCall) {
        final XAbstractFeatureCall _xAbstractFeatureCall = (XAbstractFeatureCall)expression;
        _matched=true;
        this.hasTypeArguments(_xAbstractFeatureCall, typeArguments);
      }
    }
    if (!_matched) {
      if (expression instanceof XConstructorCall) {
        final XConstructorCall _xConstructorCall = (XConstructorCall)expression;
        _matched=true;
        this.hasTypeArguments(_xConstructorCall, typeArguments);
      }
    }
    if (!_matched) {
      String _plus = ("Unexpected expression: " + expression);
      Assert.fail(_plus);
    }
  }
  
  public void hasTypeArguments(final XAbstractFeatureCall call, final String... typeArguments) {
    JvmIdentifiableElement _feature = call.getFeature();
    final JvmExecutable executable = ((JvmExecutable) _feature);
    final EList<JvmTypeParameter> typeParameters = ((JvmTypeParameterDeclarator) executable).getTypeParameters();
    int _size = ((List<String>)Conversions.doWrapArray(typeArguments)).size();
    int _size_1 = typeParameters.size();
    Assert.assertEquals(_size, _size_1);
    final XExpression receiver = this.featureCallToJavaMapping.getActualReceiver(call);
    JvmTypeReference _xifexpression = null;
    boolean _notEquals = ObjectExtensions.operator_notEquals(receiver, null);
    if (_notEquals) {
      JvmTypeReference _type = this.typeProvider.getType(receiver);
      _xifexpression = _type;
    }
    final JvmTypeReference receiverType = _xifexpression;
    final JvmTypeReference expectedType = this.typeProvider.getExpectedType(call);
    final List<JvmTypeReference> argumentTypes = CollectionLiterals.<JvmTypeReference>newArrayList();
    List<XExpression> _actualArguments = this.featureCallToJavaMapping.getActualArguments(call);
    for (final XExpression argument : _actualArguments) {
      JvmTypeReference _type_1 = this.typeProvider.getType(argument);
      argumentTypes.add(_type_1);
    }
    FeatureCallRequest _featureCallRequest = new FeatureCallRequest(call, executable, receiverType, expectedType, argumentTypes, this.logicalContainerProvider);
    final ITypeArgumentContext typeArgumentContext = this.typeArgumentContextProvider.getTypeArgumentContext(_featureCallRequest);
    final ArrayList<JvmTypeReference> actualTypeArguments = CollectionLiterals.<JvmTypeReference>newArrayList();
    final Procedure1<JvmTypeParameter> _function = new Procedure1<JvmTypeParameter>() {
        public void apply(final JvmTypeParameter it) {
          JvmTypeReference _boundArgument = typeArgumentContext.getBoundArgument(it);
          actualTypeArguments.add(_boundArgument);
        }
      };
    IterableExtensions.<JvmTypeParameter>forEach(typeParameters, _function);
    this.assertTypeArguments(typeArguments, actualTypeArguments);
  }
  
  public void assertTypeArguments(final String[] typeArguments, final List<JvmTypeReference> actualTypeArguments) {
    final Procedure2<String,Integer> _function = new Procedure2<String,Integer>() {
        public void apply(final String typeArgument, final Integer i) {
          final JvmTypeReference actualTypeArgument = actualTypeArguments.get((i).intValue());
          Assert.assertNotNull(typeArgument, actualTypeArgument);
          String _simpleName = actualTypeArgument.getSimpleName();
          Assert.assertEquals(typeArgument, _simpleName);
        }
      };
    IterableExtensions.<String>forEach(((Iterable<String>)Conversions.doWrapArray(typeArguments)), _function);
  }
  
  public void hasTypeArguments(final XConstructorCall call, final String... typeArguments) {
    JvmTypeReference _type = this.typeProvider.getType(call);
    final JvmParameterizedTypeReference producedType = ((JvmParameterizedTypeReference) _type);
    final EList<JvmTypeReference> actualTypeArguments = producedType.getArguments();
    this.assertTypeArguments(typeArguments, actualTypeArguments);
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testNumberLiteralInClosure_01() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testOverloadedMethods_09() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testFeatureCall_06() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testFeatureCall_28() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testFeatureCall_31() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testFeatureCall_71() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testFeatureCall_72() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testFeatureCall_74() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testMethodTypeParamInference_11() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testMethodTypeParamInference_13() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testImplicitImportPrintln_01() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testImplicitImportEmptyList_02() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testClosure_03() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testClosure_06() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testClosure_07() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testClosure_08() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testClosure_09() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testClosure_13() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testClosure_13a() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testClosure_13b() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testClosure_16() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testClosure_17() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testClosure_18() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testClosure_19() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testClosure_20() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testClosure_21() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testClosure_24() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testClosure_25() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testClosure_26() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testClosure_27() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testEMap_01() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testEMap_02() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testEMap_03() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testEMap_05() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testEMap_06() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testEMap_07() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testEMap_09() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testEMap_10() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testEMap_11() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testConstructorCall_03() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testConstructorCall_04() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testConstructorCall_05() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testConstructorCall_06() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testConstructorCall_07() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testConstructorTypeInference_04() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testToList_04() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testToList_05() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testToList_07() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testTypeByTransitiveExpectation_02() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testExpectationActualMismatch_02() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDependentTypeArgumentResolution_03() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDependentTypeArgumentResolution_05() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDependentTypeArgumentResolution_08() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDependentTypeArgumentResolution_10() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_002() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_003() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_004() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_005() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_006() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_007() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_008() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_009() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_010() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_011() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_012() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_013() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_014() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_015() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_016() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_017() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_018() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_019() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_020() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_021() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_022() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_023() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_024() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_025() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_026() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_027() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_028() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_029() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_030() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_031() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_032() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_033() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_034() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_035() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_036() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_037() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_041() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_042() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_043() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_044() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_045() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_046() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_048() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_049() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_050() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_051() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_053() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_057() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_060() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_061() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_062() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_063() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_064() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_065() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_067() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_068() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_069() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_070() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_071() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_072() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_073() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_074() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_075() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_076() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_077() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_078() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_079() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_080() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_081() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_082() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_083() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_084() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_085() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_086() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_087() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_088() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_089() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_090() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_091() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_092() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_093() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_094() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_095() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_096() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_097() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_098() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_099() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_100() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_101() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_102() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_103() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_107() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_108() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_109() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_110() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_111() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_112() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_113() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_114() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_115() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_116() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_117() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_118() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_119() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_123() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_126() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_127() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_128() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_129() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_130() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_131() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_133() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_134() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_135() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_136() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_137() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_138() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_139() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_143() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_148() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_149() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_150() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_152() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_153() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_154() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_155() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_156() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_157() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_158() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_159() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_160() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_161() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testRecursiveTypeArgumentResolution_01() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testRecursiveTypeArgumentResolution_03() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testRecursiveTypeArgumentResolution_04() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testRecursiveTypeArgumentResolution_05() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testRecursiveTypeArgumentResolution_06() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testRecursiveTypeArgumentResolution_07() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testRecursiveTypeArgumentResolution_08() throws Exception {
    Assert.fail("fails in old implementation");
  }
}
