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
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;
import org.eclipse.xtext.xbase.tests.typesystem.AbstractFeatureCallTypeTest;
import org.eclipse.xtext.xbase.typing.ITypeProvider;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow
 */
@SuppressWarnings("all")
public class OldAPIFeatureCallTypeTest extends AbstractFeatureCallTypeTest {
  @Inject
  private ITypeProvider typeProvider;
  
  public void resolvesFeatureCallsTo(final String expression, final String... types) {
    final String expressionWithQualifiedNames = expression.replace("$$", "org::eclipse::xtext::xbase::lib::");
    final List<XAbstractFeatureCall> featureCalls = this.findFeatureCalls(expressionWithQualifiedNames);
    final Procedure2<XAbstractFeatureCall,Integer> _function = new Procedure2<XAbstractFeatureCall,Integer>() {
        public void apply(final XAbstractFeatureCall featureCall, final Integer index) {
          final JvmTypeReference type = OldAPIFeatureCallTypeTest.this.typeProvider.getType(featureCall);
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("failed for feature call at ");
          _builder.append(index, "");
          String _get = ((List<String>)Conversions.doWrapArray(types)).get((index).intValue());
          String _simpleName = type.getSimpleName();
          Assert.assertEquals(_builder.toString(), _get, _simpleName);
        }
      };
    IterableExtensions.<XAbstractFeatureCall>forEach(featureCalls, _function);
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testNumberLiteralInClosure_01() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testArray_04() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testArray_07() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testArray_08() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testClosure_03() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testClosure_13() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testClosure_15() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testClosure_27() throws Exception {
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
  public void testSwitchExpression_4() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testSwitchExpression_5() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testSwitchExpression_6() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testTypeGuardedCase_1() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testConstructorTypeInference_04() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testFeatureCall_33() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testFeatureCall_35() throws Exception {
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
  public void testBug_389512() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testTypeByTransitiveExpectation_02() throws Exception {
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
  public void testDeferredTypeArgumentResolution_017() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_041() throws Exception {
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
  public void testDeferredTypeArgumentResolution_107() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_110() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_114() throws Exception {
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
  public void testDeferredTypeArgumentResolution_134() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_138() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_158() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testRecursiveTypeArgumentResolution_05() throws Exception {
    Assert.fail("fails in old implementation");
  }
}
