package org.eclipse.xtext.xbase.tests.typesystem;

import com.google.inject.Inject;
import com.google.inject.Injector;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.tests.typesystem.AbstractBatchTypeResolverTest;
import org.eclipse.xtext.xbase.tests.typesystem.ShuffledTypeSystemStandaloneSetup;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

/**
 * A test that triggers the computation of argument types in reverse order.
 * Furthermore it will shuffle the order of branches in if and switch expressions.
 * @author Sebastian Zarnekow
 */
@SuppressWarnings("all")
public class ShuffledTypeResolverTest extends AbstractBatchTypeResolverTest {
  private final static Injector shuffleInjector = new Function0<Injector>() {
    public Injector apply() {
      Injector _setup = ShuffledTypeSystemStandaloneSetup.setup();
      return _setup;
    }
  }.apply();
  
  public Injector getInjector() {
    return ShuffledTypeResolverTest.shuffleInjector;
  }
  
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
}
