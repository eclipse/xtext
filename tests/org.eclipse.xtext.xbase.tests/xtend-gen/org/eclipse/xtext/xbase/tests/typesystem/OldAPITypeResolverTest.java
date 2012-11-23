/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import com.google.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.XCasePart;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XSwitchExpression;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.tests.typesystem.AbstractTypeResolverTest;
import org.eclipse.xtext.xbase.typing.ITypeProvider;
import org.eclipse.xtext.xtype.XFunctionTypeRef;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow
 */
@SuppressWarnings("all")
public class OldAPITypeResolverTest extends AbstractTypeResolverTest<JvmTypeReference> {
  @Inject
  private ITypeProvider typeProvider;
  
  public JvmTypeReference resolvesTo(final String expression, final String type) {
    try {
      final XExpression xExpression = this.expression(expression, false);
      Resource _eResource = xExpression.eResource();
      EList<Diagnostic> _errors = _eResource.getErrors();
      boolean _isEmpty = _errors.isEmpty();
      Assert.assertTrue(_isEmpty);
      Resource _eResource_1 = xExpression.eResource();
      EList<Diagnostic> _warnings = _eResource_1.getWarnings();
      boolean _isEmpty_1 = _warnings.isEmpty();
      Assert.assertTrue(_isEmpty_1);
      final JvmTypeReference resolvedType = this.typeProvider.getType(xExpression);
      String _simpleName = resolvedType==null?(String)null:resolvedType.getSimpleName();
      Assert.assertEquals(type, _simpleName);
      TreeIterator<EObject> _eAllContents = xExpression.eAllContents();
      Iterable<EObject> _iterable = IteratorExtensions.<EObject>toIterable(_eAllContents);
      for (final EObject content : _iterable) {
        boolean _matched = false;
        if (!_matched) {
          if (content instanceof XSwitchExpression) {
            final XSwitchExpression _xSwitchExpression = (XSwitchExpression)content;
            _matched=true;
            this.assertExpressionTypeIsResolved(_xSwitchExpression);
            String _localVarName = _xSwitchExpression.getLocalVarName();
            boolean _notEquals = ObjectExtensions.operator_notEquals(_localVarName, null);
            if (_notEquals) {
              this.assertIdentifiableTypeIsResolved(_xSwitchExpression);
            }
          }
        }
        if (!_matched) {
          if (content instanceof XExpression) {
            final XExpression _xExpression = (XExpression)content;
            _matched=true;
            this.assertExpressionTypeIsResolved(_xExpression);
          }
        }
        if (!_matched) {
          if (content instanceof XCasePart) {
            final XCasePart _xCasePart = (XCasePart)content;
            _matched=true;
          }
        }
        if (!_matched) {
          if (content instanceof JvmIdentifiableElement) {
            final JvmIdentifiableElement _jvmIdentifiableElement = (JvmIdentifiableElement)content;
            _matched=true;
            this.assertIdentifiableTypeIsResolved(_jvmIdentifiableElement);
          }
        }
      }
      Resource _eResource_2 = xExpression.eResource();
      EList<Diagnostic> _errors_1 = _eResource_2.getErrors();
      boolean _isEmpty_2 = _errors_1.isEmpty();
      Assert.assertTrue(_isEmpty_2);
      Resource _eResource_3 = xExpression.eResource();
      EList<Diagnostic> _warnings_1 = _eResource_3.getWarnings();
      boolean _isEmpty_3 = _warnings_1.isEmpty();
      Assert.assertTrue(_isEmpty_3);
      return resolvedType;
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void isFunctionAndEquivalentTo(final JvmTypeReference reference, final String type) {
    Assert.assertTrue((reference instanceof XFunctionTypeRef));
    JvmTypeReference _equivalent = ((XFunctionTypeRef) reference).getEquivalent();
    String _simpleName = _equivalent.getSimpleName();
    Assert.assertEquals(type, _simpleName);
  }
  
  public void assertExpressionTypeIsResolved(final XExpression expression) {
    final JvmTypeReference type = this.typeProvider.getType(expression);
    String _string = expression.toString();
    Assert.assertNotNull(_string, type);
    String _string_1 = expression.toString();
    String _plus = (_string_1 + " / ");
    String _plus_1 = (_plus + type);
    String _identifier = type.getIdentifier();
    Assert.assertNotNull(_plus_1, _identifier);
  }
  
  public void assertIdentifiableTypeIsResolved(final JvmIdentifiableElement identifiable) {
    final JvmTypeReference type = this.typeProvider.getTypeForIdentifiable(identifiable);
    String _string = identifiable.toString();
    Assert.assertNotNull(_string, type);
    String _string_1 = identifiable.toString();
    String _plus = (_string_1 + " / ");
    String _plus_1 = (_plus + type);
    String _identifier = type.getIdentifier();
    Assert.assertNotNull(_plus_1, _identifier);
  }
  
  @Ignore(value = "not a timeout but too slow")
  @Test
  public void testBlockExpression_03() throws Exception {
    Assert.fail("not a timeout but too slow");
  }
  
  @Ignore(value = "not a timeout but too slow")
  @Test
  public void testFeatureCall_15_b() throws Exception {
    Assert.fail("not a timeout but too slow");
  }
  
  @Ignore(value = "not a timeout but too slow")
  @Test
  public void testFeatureCall_15_c() throws Exception {
    Assert.fail("not a timeout but too slow");
  }
  
  @Ignore(value = "not a timeout but too slow")
  @Test
  public void testFeatureCall_15_d() throws Exception {
    Assert.fail("not a timeout but too slow");
  }
  
  @Ignore(value = "timeout")
  @Test
  public void testFeatureCall_15_d_2() throws Exception {
    Assert.fail("timeout");
  }
  
  @Ignore(value = "not a timeout but too slow")
  @Test
  public void testFeatureCall_15_e_2() throws Exception {
    Assert.fail("not a timeout but too slow");
  }
  
  @Ignore(value = "not a timeout but too slow")
  @Test
  public void testFeatureCall_15_f() throws Exception {
    Assert.fail("not a timeout but too slow");
  }
  
  @Ignore(value = "not a timeout but too slow")
  @Test
  public void testFeatureCall_15_f_2() throws Exception {
    Assert.fail("not a timeout but too slow");
  }
  
  @Ignore(value = "not a timeout but too slow")
  @Test
  public void testFeatureCall_15_g() throws Exception {
    Assert.fail("not a timeout but too slow");
  }
  
  @Ignore(value = "not a timeout but too slow")
  @Test
  public void testFeatureCall_15_g_2() throws Exception {
    Assert.fail("not a timeout but too slow");
  }
  
  @Ignore(value = "timeout")
  @Test
  public void testFeatureCall_15_h() throws Exception {
    Assert.fail("timeout");
  }
  
  @Ignore(value = "timeout")
  @Test
  public void testFeatureCall_15_h_2() throws Exception {
    Assert.fail("timeout");
  }
  
  @Ignore(value = "timeout")
  @Test
  public void testFeatureCall_15_i() throws Exception {
    Assert.fail("timeout");
  }
  
  @Ignore(value = "timeout")
  @Test
  public void testFeatureCall_15_i_2() throws Exception {
    Assert.fail("timeout");
  }
  
  @Ignore(value = "not a timeout but too slow")
  @Test
  public void testFeatureCall_15_i_3() throws Exception {
    Assert.fail("not a timeout but too slow");
  }
  
  @Ignore(value = "not a timeout but too slow")
  @Test
  public void testFeatureCall_15_i_4() throws Exception {
    Assert.fail("not a timeout but too slow");
  }
  
  @Ignore(value = "timeout")
  @Test
  public void testFeatureCall_15_j() throws Exception {
    Assert.fail("timeout");
  }
  
  @Ignore(value = "timeout")
  @Test
  public void testFeatureCall_15_j_2() throws Exception {
    Assert.fail("timeout");
  }
  
  @Ignore(value = "timeout")
  @Test
  public void testFeatureCall_15_k() throws Exception {
    Assert.fail("timeout");
  }
  
  @Ignore(value = "timeout")
  @Test
  public void testFeatureCall_15_k_2() throws Exception {
    Assert.fail("timeout");
  }
  
  @Ignore(value = "timeout")
  @Test
  public void testFeatureCall_15_l() throws Exception {
    Assert.fail("timeout");
  }
  
  @Ignore(value = "timeout")
  @Test
  public void testFeatureCall_15_l_2() throws Exception {
    Assert.fail("timeout");
  }
  
  @Ignore(value = "timeout")
  @Test
  public void testFeatureCall_15_m() throws Exception {
    Assert.fail("timeout");
  }
  
  @Ignore(value = "timeout")
  @Test
  public void testFeatureCall_15_n() throws Exception {
    Assert.fail("timeout");
  }
  
  @Ignore(value = "timeout")
  @Test
  public void testFeatureCall_15_n_1() throws Exception {
    Assert.fail("timeout");
  }
  
  @Ignore(value = "timeout")
  @Test
  public void testFeatureCall_15_n_2() throws Exception {
    Assert.fail("timeout");
  }
  
  @Ignore(value = "not a timeout but too slow")
  @Test
  public void testFeatureCall_25_d() throws Exception {
    Assert.fail("not a timeout but too slow");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testFeatureCall_03_b() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testFeatureCall_10() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testFeatureCall_13() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testFeatureCall_24_a() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testFeatureCall_24_b() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testFeatureCall_32() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testFeatureCall_33() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testOverloadedVarArgs_03() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testOverloadedOperators_20() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testImplicitImportPrintln_01() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testImplicitImportEmptyList() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testMethodTypeParamInference_03() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testMethodTypeParamInference_04() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testMethodTypeParamInference_05() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testClosure_03() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testClosure_05() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testClosure_06() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testClosure_08() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testClosure_10() throws Exception {
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
  public void testClosure_15() throws Exception {
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
  public void testClosure_22() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testClosure_23() throws Exception {
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
  public void testClosure_28() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testClosure_29() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testClosure_30() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testClosure_31() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testIfExpression_03() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testIfExpression_06() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testIfExpression_07() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testIfExpression_08() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testIfExpression_09() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testIfExpression_11() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testIfExpression_12() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testSwitchExpression_4() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testSwitchExpression_7() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testSwitchExpression_8() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testTypeLiteral_2() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testTypeLiteral_3() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testTypeGuardedCase_2() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testConstructorCall_01() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testConstructorCall_02() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testConstructorCall_03() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testFeatureCall_06_00() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testFeatureCall_27() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testFeatureCall_28() throws Exception {
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
  public void testBounds_24() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testBounds_26() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testPropertyAccess_05() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testPropertyAccess_06() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testBug_381466_01() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testBug_381466_02() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testBug_381466_03() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testBug_381466_04() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testTypeByTransitiveExpectation_01() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testTypeByTransitiveExpectation_02() throws Exception {
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
  public void testDeferredTypeArgumentResolution_038() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_039() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_040() throws Exception {
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
  public void testDeferredTypeArgumentResolution_052() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_053() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_054() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_055() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_056() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_057() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_058() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_059() throws Exception {
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
  public void testDeferredTypeArgumentResolution_066() throws Exception {
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
  public void testDeferredTypeArgumentResolution_104() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_105() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_106() throws Exception {
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
  public void testDeferredTypeArgumentResolution_120() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_121() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_122() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_123() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_124() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_125() throws Exception {
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
  public void testDeferredTypeArgumentResolution_132() throws Exception {
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
  public void testDeferredTypeArgumentResolution_140() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_141() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_142() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_143() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_144() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_145() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_146() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_147() throws Exception {
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
  public void testDeferredTypeArgumentResolution_151() throws Exception {
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
