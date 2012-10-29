/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import com.google.inject.Inject;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.xbase.tests.typesystem.AbstractBatchTypeResolverTest;
import org.eclipse.xtext.xbase.tests.typesystem.XbaseShufflingNewTypeSystemInjectorProvider;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * A test that triggers the computation of argument types in reverse order.
 * Furthermore it will shuffle the order of branches in if and switch expressions.
 * @author Sebastian Zarnekow
 */
@RunWith(value = XtextRunner.class)
@InjectWith(value = XbaseShufflingNewTypeSystemInjectorProvider.class)
@SuppressWarnings("all")
public class ShuffledTypeResolverTest extends AbstractBatchTypeResolverTest {
  @Inject
  private IBatchTypeResolver typeResolver;
  
  public IBatchTypeResolver getTypeResolver() {
    return this.typeResolver;
  }
  
  @Test
  @Ignore(value = "TODO deferred closure typing")
  public void testOverloadedOperators_08() throws Exception {
    Assert.fail("TODO deferred closure typing");
  }
  
  @Test
  @Ignore(value = "TODO deferred closure typing")
  public void testOverloadedOperators_09() throws Exception {
    Assert.fail("TODO deferred closure typing");
  }
  
  @Test
  @Ignore(value = "TODO deferred closure typing")
  public void testOverloadedOperators_10() throws Exception {
    Assert.fail("TODO deferred closure typing");
  }
  
  @Test
  @Ignore(value = "TODO deferred closure typing")
  public void testOverloadedOperators_15() throws Exception {
    Assert.fail("TODO deferred closure typing");
  }
  
  @Test
  @Ignore(value = "TODO deferred closure typing")
  public void testClosure_03() throws Exception {
    Assert.fail("TODO deferred closure typing");
  }
  
  @Test
  @Ignore(value = "TODO deferred closure typing")
  public void testClosure_30() throws Exception {
    Assert.fail("TODO deferred closure typing");
  }
  
  @Test
  @Ignore(value = "TODO deferred closure typing")
  public void testClosure_31() throws Exception {
    Assert.fail("TODO deferred closure typing");
  }
  
  @Test
  @Ignore(value = "TODO deferred closure typing")
  public void testEMap_01() throws Exception {
    Assert.fail("TODO deferred closure typing");
  }
  
  @Test
  @Ignore(value = "TODO deferred closure typing")
  public void testEMap_02() throws Exception {
    Assert.fail("TODO deferred closure typing");
  }
  
  @Test
  @Ignore(value = "TODO deferred closure typing")
  public void testEMap_05() throws Exception {
    Assert.fail("TODO deferred closure typing");
  }
  
  @Test
  @Ignore(value = "TODO deferred closure typing")
  public void testEMap_06() throws Exception {
    Assert.fail("TODO deferred closure typing");
  }
  
  @Test
  @Ignore(value = "TODO deferred closure typing")
  public void testEMap_09() throws Exception {
    Assert.fail("TODO deferred closure typing");
  }
  
  @Test
  @Ignore(value = "TODO deferred closure typing")
  public void testEMap_10() throws Exception {
    Assert.fail("TODO deferred closure typing");
  }
  
  @Test
  @Ignore(value = "TODO deferred closure typing")
  public void testMemberFeatureCall_02() throws Exception {
    Assert.fail("TODO deferred closure typing");
  }
  
  @Test
  @Ignore(value = "TODO deferred closure typing")
  public void testFeatureCall_07() throws Exception {
    Assert.fail("TODO deferred closure typing");
  }
  
  @Test
  @Ignore(value = "TODO deferred closure typing")
  public void testFeatureCall_07_01() throws Exception {
    Assert.fail("TODO deferred closure typing");
  }
  
  @Test
  @Ignore(value = "TODO deferred closure typing")
  public void testFeatureCall_07_02() throws Exception {
    Assert.fail("TODO deferred closure typing");
  }
  
  @Test
  @Ignore(value = "TODO deferred closure typing")
  public void testFeatureCall_07_03() throws Exception {
    Assert.fail("TODO deferred closure typing");
  }
  
  @Test
  @Ignore(value = "TODO deferred closure typing")
  public void testFeatureCall_09() throws Exception {
    Assert.fail("TODO deferred closure typing");
  }
  
  @Test
  @Ignore(value = "TODO deferred closure typing")
  public void testFeatureCall_13_6() throws Exception {
    Assert.fail("TODO deferred closure typing");
  }
  
  @Test
  @Ignore(value = "TODO deferred closure typing")
  public void testFeatureCall_17_a() throws Exception {
    Assert.fail("TODO deferred closure typing");
  }
  
  @Test
  @Ignore(value = "TODO deferred closure typing")
  public void testFeatureCall_17_b() throws Exception {
    Assert.fail("TODO deferred closure typing");
  }
  
  @Test
  @Ignore(value = "TODO deferred closure typing")
  public void testFeatureCall_18_a() throws Exception {
    Assert.fail("TODO deferred closure typing");
  }
  
  @Test
  @Ignore(value = "TODO deferred closure typing")
  public void testFeatureCall_18_b() throws Exception {
    Assert.fail("TODO deferred closure typing");
  }
  
  @Test
  @Ignore(value = "TODO deferred closure typing")
  public void testFeatureCall_19_a() throws Exception {
    Assert.fail("TODO deferred closure typing");
  }
  
  @Test
  @Ignore(value = "TODO deferred closure typing")
  public void testFeatureCall_19_b() throws Exception {
    Assert.fail("TODO deferred closure typing");
  }
  
  @Test
  @Ignore(value = "TODO deferred closure typing")
  public void testFeatureCall_20_a() throws Exception {
    Assert.fail("TODO deferred closure typing");
  }
  
  @Test
  @Ignore(value = "TODO deferred closure typing")
  public void testFeatureCall_20_b() throws Exception {
    Assert.fail("TODO deferred closure typing");
  }
  
  @Test
  @Ignore(value = "TODO deferred closure typing")
  public void testFeatureCall_21_a() throws Exception {
    Assert.fail("TODO deferred closure typing");
  }
  
  @Test
  @Ignore(value = "TODO deferred closure typing")
  public void testFeatureCall_21_b() throws Exception {
    Assert.fail("TODO deferred closure typing");
  }
  
  @Test
  @Ignore(value = "TODO deferred closure typing")
  public void testFeatureCall_22_a() throws Exception {
    Assert.fail("TODO deferred closure typing");
  }
  
  @Test
  @Ignore(value = "TODO deferred closure typing")
  public void testFeatureCall_22_b() throws Exception {
    Assert.fail("TODO deferred closure typing");
  }
  
  @Test
  @Ignore(value = "TODO deferred closure typing")
  public void testFeatureCall_23_a() throws Exception {
    Assert.fail("TODO deferred closure typing");
  }
  
  @Test
  @Ignore(value = "TODO deferred closure typing")
  public void testFeatureCall_23_b() throws Exception {
    Assert.fail("TODO deferred closure typing");
  }
  
  @Test
  @Ignore(value = "TODO deferred closure typing")
  public void testFeatureCall_24_a() throws Exception {
    Assert.fail("TODO deferred closure typing");
  }
  
  @Test
  @Ignore(value = "TODO deferred closure typing")
  public void testFeatureCall_24_b() throws Exception {
    Assert.fail("TODO deferred closure typing");
  }
  
  @Test
  @Ignore(value = "TODO deferred closure typing")
  public void testFeatureCall_25_a() throws Exception {
    Assert.fail("TODO deferred closure typing");
  }
  
  @Test
  @Ignore(value = "TODO deferred closure typing")
  public void testFeatureCall_25_b() throws Exception {
    Assert.fail("TODO deferred closure typing");
  }
  
  @Test
  @Ignore(value = "TODO deferred closure typing")
  public void testFeatureCall_25_c() throws Exception {
    Assert.fail("TODO deferred closure typing");
  }
  
  @Test
  @Ignore(value = "TODO deferred closure typing")
  public void testFeatureCall_25_d() throws Exception {
    Assert.fail("TODO deferred closure typing");
  }
  
  @Test
  @Ignore(value = "TODO deferred closure typing")
  public void testFeatureCall_26() throws Exception {
    Assert.fail("TODO deferred closure typing");
  }
  
  @Test
  @Ignore(value = "TODO deferred closure typing")
  public void testFeatureCall_26a() throws Exception {
    Assert.fail("TODO deferred closure typing");
  }
  
  @Test
  @Ignore(value = "TODO deferred closure typing")
  public void testFeatureCall_26b() throws Exception {
    Assert.fail("TODO deferred closure typing");
  }
  
  @Test
  @Ignore(value = "TODO deferred closure typing")
  public void testFeatureCall_27() throws Exception {
    Assert.fail("TODO deferred closure typing");
  }
  
  @Test
  @Ignore(value = "TODO deferred closure typing")
  public void testFeatureCall_28() throws Exception {
    Assert.fail("TODO deferred closure typing");
  }
  
  @Test
  @Ignore(value = "TODO deferred closure typing")
  public void testFeatureCall_30() throws Exception {
    Assert.fail("TODO deferred closure typing");
  }
  
  @Test
  @Ignore(value = "TODO deferred closure typing")
  public void testFeatureCall_31() throws Exception {
    Assert.fail("TODO deferred closure typing");
  }
  
  @Test
  @Ignore(value = "TODO deferred closure typing")
  public void testFeatureCall_37() throws Exception {
    Assert.fail("TODO deferred closure typing");
  }
  
  @Test
  @Ignore(value = "TODO deferred closure typing")
  public void testFeatureCall_38() throws Exception {
    Assert.fail("TODO deferred closure typing");
  }
  
  @Test
  @Ignore(value = "TODO deferred closure typing")
  public void testBug_389512() throws Exception {
    Assert.fail("TODO deferred closure typing");
  }
}
