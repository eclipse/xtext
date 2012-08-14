package org.eclipse.xtext.xbase.tests.typesystem;

import com.google.inject.Inject;
import org.eclipse.xtext.xbase.tests.typesystem.AbstractBatchTypeResolverTest;
import org.eclipse.xtext.xbase.tests.typesystem.InvariantCheckingEagerBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

/**
 * This tests ensures that the type calculation does not depend on some lazy evaluation.
 * Therefore all argument types for all overloaded variants are computed eagerly.
 * @author Sebastian Zarnekow
 */
@SuppressWarnings("all")
public class InvariantCheckingIsolationTest extends AbstractBatchTypeResolverTest {
  @Inject
  private InvariantCheckingEagerBatchTypeResolver typeResolver;
  
  public IBatchTypeResolver getTypeResolver() {
    return this.typeResolver;
  }
  
  @Ignore(value = "error candidates")
  @Test
  public void testEMap_01() throws Exception {
    Assert.fail();
  }
  
  @Ignore(value = "error candidates")
  @Test
  public void testEMap_02() throws Exception {
    Assert.fail();
  }
  
  @Ignore(value = "error candidates")
  @Test
  public void testFeatureCall_07_02() throws Exception {
    Assert.fail();
  }
  
  @Ignore(value = "error candidates")
  @Test
  public void testFeatureCall_07_03() throws Exception {
    Assert.fail();
  }
  
  @Ignore(value = "wrong expectation")
  @Test
  public void testFeatureCall_13_5() throws Exception {
    Assert.fail();
  }
  
  @Ignore(value = "error candidates")
  @Test
  public void testFeatureCall_17_b() throws Exception {
    Assert.fail();
  }
  
  @Ignore(value = "error candidates")
  @Test
  public void testFeatureCall_18_b() throws Exception {
    Assert.fail();
  }
  
  @Ignore(value = "error candidates")
  @Test
  public void testFeatureCall_19_b() throws Exception {
    Assert.fail();
  }
  
  @Ignore(value = "error candidates")
  @Test
  public void testFeatureCall_20_b() throws Exception {
    Assert.fail();
  }
  
  @Ignore(value = "error candidates")
  @Test
  public void testFeatureCall_21_b() throws Exception {
    Assert.fail();
  }
  
  @Ignore(value = "error candidates")
  @Test
  public void testFeatureCall_22_b() throws Exception {
    Assert.fail();
  }
  
  @Ignore(value = "error candidates")
  @Test
  public void testFeatureCall_23_b() throws Exception {
    Assert.fail();
  }
  
  @Ignore(value = "error candidates")
  @Test
  public void testFeatureCall_24_b() throws Exception {
    Assert.fail();
  }
  
  @Ignore(value = "error candidates")
  @Test
  public void testFeatureCall_26a() throws Exception {
    Assert.fail();
  }
  
  @Ignore(value = "error candidates")
  @Test
  public void testFeatureCall_31() throws Exception {
    Assert.fail();
  }
}
