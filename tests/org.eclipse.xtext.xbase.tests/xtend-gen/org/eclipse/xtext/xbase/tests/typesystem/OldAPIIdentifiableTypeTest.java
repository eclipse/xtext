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
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;
import org.eclipse.xtext.xbase.tests.typesystem.AbstractIdentifiableTypeTest;
import org.eclipse.xtext.xbase.typing.ITypeProvider;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow
 */
@SuppressWarnings("all")
public class OldAPIIdentifiableTypeTest extends AbstractIdentifiableTypeTest {
  @Inject
  private ITypeProvider typeProvider;
  
  public void resolvesIdentifiablesTo(final String expression, final String... types) {
    final String expressionWithQualifiedNames = expression.replace("$$", "org::eclipse::xtext::xbase::lib::");
    final List<JvmIdentifiableElement> identifiables = this.findIdentifiables(expressionWithQualifiedNames);
    final Procedure2<JvmIdentifiableElement,Integer> _function = new Procedure2<JvmIdentifiableElement,Integer>() {
        public void apply(final JvmIdentifiableElement identifiable, final Integer index) {
          final JvmTypeReference type = OldAPIIdentifiableTypeTest.this.typeProvider.getTypeForIdentifiable(identifiable);
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("failed for identifiable at ");
          _builder.append(index, "");
          String _get = ((List<String>)Conversions.doWrapArray(types)).get((index).intValue());
          String _simpleName = type.getSimpleName();
          Assert.assertEquals(_builder.toString(), _get, _simpleName);
        }
      };
    IterableExtensions.<JvmIdentifiableElement>forEach(identifiables, _function);
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testClosure_03() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testClosure_04() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testClosure_13() throws Exception {
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
  public void testFeatureCall_32() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testFeatureCall_35() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_002() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_012() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_016() throws Exception {
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
  public void testDeferredTypeArgumentResolution_040() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_042() throws Exception {
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
  public void testDeferredTypeArgumentResolution_102() throws Exception {
    Assert.fail("fails in old implementation");
  }
  
  @Ignore(value = "fails in old implementation")
  @Test
  public void testDeferredTypeArgumentResolution_106() throws Exception {
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
  
  @Ignore(value = "takes too long")
  @Test
  public void testFeatureCall_15_b() throws Exception {
    Assert.fail("takes too long");
  }
  
  @Ignore(value = "takes too long")
  @Test
  public void testFeatureCall_15_f() throws Exception {
    Assert.fail("takes too long");
  }
}
