/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import com.google.inject.Inject;
import org.eclipse.xtext.common.types.util.TypeArgumentContextProvider;
import org.eclipse.xtext.xbase.tests.typesystem.AbstractOldAPITypeArgumentTest;
import org.eclipse.xtext.xbase.typesystem.legacy.LegacyTypeArgumentContextProvider;
import org.eclipse.xtext.xbase.typesystem.legacy.XbaseBatchTypeProvider;
import org.eclipse.xtext.xbase.typing.ITypeProvider;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow
 */
@SuppressWarnings("all")
public class LegacyTypeArgumentTest extends AbstractOldAPITypeArgumentTest {
  @Inject
  private ITypeProvider typeProvider;
  
  @Inject
  private TypeArgumentContextProvider typeArgumentContextProvider;
  
  protected ITypeProvider getTypeProvider() {
    return this.typeProvider;
  }
  
  protected TypeArgumentContextProvider getTypeArgumentContextProvider() {
    return this.typeArgumentContextProvider;
  }
  
  @Test
  public void testSetup() {
    Assert.assertTrue((this.typeProvider instanceof XbaseBatchTypeProvider));
    Assert.assertTrue((this.typeArgumentContextProvider instanceof LegacyTypeArgumentContextProvider));
  }
  
  @Test
  @Ignore(value = "TODO Fix me")
  public void testRawType_01() throws Exception {
    super.testRawType_01();
  }
  
  @Test
  @Ignore(value = "TODO Fix me")
  public void testRawType_02() throws Exception {
    super.testRawType_02();
  }
  
  @Test
  @Ignore(value = "TODO Fix me")
  public void testRawType_05() throws Exception {
    super.testRawType_05();
  }
  
  @Test
  @Ignore(value = "TODO Fix me")
  public void testFeatureCallWithExpectation_01() throws Exception {
    super.testFeatureCallWithExpectation_01();
  }
  
  @Test
  @Ignore(value = "TODO Fix me")
  public void testFeatureCallWithExpectation_02() throws Exception {
    super.testFeatureCallWithExpectation_02();
  }
  
  @Test
  @Ignore(value = "TODO Fix me")
  public void testFeatureCallWithExpectation_04() throws Exception {
    super.testFeatureCallWithExpectation_04();
  }
  
  @Test
  @Ignore(value = "TODO Fix me")
  public void testFeatureCallWithExpectation_05() throws Exception {
    super.testFeatureCallWithExpectation_05();
  }
}
