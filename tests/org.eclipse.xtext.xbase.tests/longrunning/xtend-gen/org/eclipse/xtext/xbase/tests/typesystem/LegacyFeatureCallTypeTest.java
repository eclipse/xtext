/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.tests.typesystem.AbstractOldAPIFeatureCallTypeTest;
import org.eclipse.xtext.xbase.typesystem.legacy.XbaseBatchTypeProvider;
import org.eclipse.xtext.xbase.typing.ITypeProvider;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow
 */
@SuppressWarnings("all")
public class LegacyFeatureCallTypeTest extends AbstractOldAPIFeatureCallTypeTest {
  @Inject
  private ITypeProvider typeProvider;
  
  protected ITypeProvider getTypeProvider() {
    return this.typeProvider;
  }
  
  protected List<XAbstractFeatureCall> findFeatureCalls(final CharSequence expression) {
    List<XAbstractFeatureCall> _findFeatureCalls = super.findFeatureCalls(expression);
    Iterable<XAbstractFeatureCall> _filterTypeLiteralsAndPackageFragments = this.filterTypeLiteralsAndPackageFragments(_findFeatureCalls);
    return IterableExtensions.<XAbstractFeatureCall>toList(_filterTypeLiteralsAndPackageFragments);
  }
  
  @Test
  public void testSetup() {
    Assert.assertTrue((this.typeProvider instanceof XbaseBatchTypeProvider));
  }
  
  @Test
  @Ignore("TODO Fix me")
  public void testRawType_01() throws Exception {
    super.testRawType_01();
  }
  
  @Test
  @Ignore("TODO Fix me")
  public void testRawType_02() throws Exception {
    super.testRawType_02();
  }
  
  @Test
  @Ignore("TODO Fix me")
  public void testRawType_05() throws Exception {
    super.testRawType_05();
  }
  
  @Test
  @Ignore("TODO This should work")
  public void testBug_391758() throws Exception {
    super.testBug_391758();
  }
  
  @Test
  @Ignore("TODO Fix me")
  public void testArray_09() throws Exception {
    super.testArray_09();
  }
}
