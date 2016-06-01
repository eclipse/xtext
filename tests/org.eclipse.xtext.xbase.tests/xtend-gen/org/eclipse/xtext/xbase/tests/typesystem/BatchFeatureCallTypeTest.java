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
    IBatchTypeResolver _typeResolver = this.getTypeResolver();
    XAbstractFeatureCall _head = IterableExtensions.<XAbstractFeatureCall>head(featureCalls);
    final IResolvedTypes resolvedTypes = _typeResolver.resolveTypes(_head);
    final Iterable<XAbstractFeatureCall> actualFeatureCalls = this.filterTypeLiteralsAndPackageFragments(featureCalls);
    boolean _isEmpty = IterableExtensions.isEmpty(actualFeatureCalls);
    Assert.assertFalse(_isEmpty);
    int _size = ((List<String>)Conversions.doWrapArray(types)).size();
    int _size_1 = IterableExtensions.size(actualFeatureCalls);
    Assert.assertEquals(("" + actualFeatureCalls), _size, _size_1);
    final Procedure2<XAbstractFeatureCall, Integer> _function = (XAbstractFeatureCall featureCall, Integer index) -> {
      final LightweightTypeReference type = resolvedTypes.getActualType(featureCall);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("failed for feature call at ");
      _builder.append(index, "");
      Object _get = types[(index).intValue()];
      String _simpleName = type.getSimpleName();
      Assert.assertEquals(_builder.toString(), _get, _simpleName);
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
