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
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;
import org.eclipse.xtext.xbase.tests.typesystem.AbstractConstructorCallTypeTest;
import org.eclipse.xtext.xbase.typing.ITypeProvider;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow
 */
@SuppressWarnings("all")
public class OldAPIConstructorCallTypeTest extends AbstractConstructorCallTypeTest {
  @Inject
  private ITypeProvider typeProvider;
  
  public void resolvesConstructorCallsTo(final String expression, final String... types) {
    final String expressionWithQualifiedNames = expression.replace("$$", "org::eclipse::xtext::xbase::lib::");
    final List<XConstructorCall> featureCalls = this.findConstructorCalls(expressionWithQualifiedNames);
    final Procedure2<XConstructorCall,Integer> _function = new Procedure2<XConstructorCall,Integer>() {
        public void apply(final XConstructorCall featureCall, final Integer index) {
          final JvmTypeReference type = OldAPIConstructorCallTypeTest.this.typeProvider.getType(featureCall);
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("failed for constructor call at ");
          _builder.append(index, "");
          String _get = ((List<String>)Conversions.doWrapArray(types)).get((index).intValue());
          String _simpleName = type.getSimpleName();
          Assert.assertEquals(_builder.toString(), _get, _simpleName);
        }
      };
    IterableExtensions.<XConstructorCall>forEach(featureCalls, _function);
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testConstructorTypeParameters_01() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testConstructorTypeParameters_02() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testConstructorTypeParameters_03() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testConstructorTypeParameters_04() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testConstructorTypeInference_04() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testConstructorTypeInference_06() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testConstructorTypeInference_07() throws Exception {
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
  public void testDeferredTypeArgumentResolution_134() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_136() throws Exception {
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
  public void testDeferredTypeArgumentResolution_155() throws Exception {
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
