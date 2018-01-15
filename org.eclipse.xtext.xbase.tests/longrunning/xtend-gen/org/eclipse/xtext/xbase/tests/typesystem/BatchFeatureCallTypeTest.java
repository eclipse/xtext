/**
 * Copyright (c) 2012, 2017 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;
import org.eclipse.xtext.xbase.tests.typesystem.AbstractFeatureCallTypeTest;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow
 */
@SuppressWarnings("all")
public class BatchFeatureCallTypeTest extends AbstractFeatureCallTypeTest {
  @Inject
  private IBatchTypeResolver batchTypeResolver;
  
  public IBatchTypeResolver getTypeResolver() {
    return this.batchTypeResolver;
  }
  
  @Override
  public void resolvesFeatureCallsTo(final String expression, final String... types) {
    final String expressionWithQualifiedNames = expression.replace("$$", "org::eclipse::xtext::xbase::lib::");
    final List<XAbstractFeatureCall> featureCalls = this.findFeatureCalls(expressionWithQualifiedNames);
    final IResolvedTypes resolvedTypes = this.getTypeResolver().resolveTypes(IterableExtensions.<XAbstractFeatureCall>head(featureCalls));
    final Iterable<XAbstractFeatureCall> actualFeatureCalls = this.filterTypeLiteralsAndPackageFragments(featureCalls);
    Assert.assertFalse(IterableExtensions.isEmpty(actualFeatureCalls));
    Assert.assertEquals(("" + actualFeatureCalls), ((List<String>)Conversions.doWrapArray(types)).size(), IterableExtensions.size(actualFeatureCalls));
    final Procedure2<XAbstractFeatureCall, Integer> _function = (XAbstractFeatureCall featureCall, Integer index) -> {
      final LightweightTypeReference type = resolvedTypes.getActualType(featureCall);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("failed for feature call at ");
      _builder.append(index);
      Assert.assertEquals(_builder.toString(), types[(index).intValue()], type.getSimpleName());
    };
    IterableExtensions.<XAbstractFeatureCall>forEach(actualFeatureCalls, _function);
  }
  
  @Test
  @Ignore("TODO Fix me")
  @Override
  public void testRawType_01() throws Exception {
    super.testRawType_01();
  }
  
  @Test
  @Ignore("TODO Fix me")
  @Override
  public void testRawType_02() throws Exception {
    super.testRawType_02();
  }
  
  @Test
  @Ignore("TODO Fix me")
  @Override
  public void testRawType_05() throws Exception {
    super.testRawType_05();
  }
  
  @Test
  @Ignore("TODO This should work")
  @Override
  public void testBug_391758() throws Exception {
    super.testBug_391758();
  }
  
  @Test
  @Ignore("TODO Fix me")
  @Override
  public void testArray_09() throws Exception {
    super.testArray_09();
  }
}
