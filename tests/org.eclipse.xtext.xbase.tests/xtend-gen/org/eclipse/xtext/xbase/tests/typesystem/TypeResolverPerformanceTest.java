package org.eclipse.xtext.xbase.tests.typesystem;

import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.tests.typesystem.BatchTypeResolverTest;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.references.LightweightResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

/**
 * @author Sebastian Zarnekow
 */
@SuppressWarnings("all")
public class TypeResolverPerformanceTest extends BatchTypeResolverTest {
  @Rule
  public final Timeout timeout = new Function0<Timeout>() {
    public Timeout apply() {
      Timeout _timeout = new Timeout(400);
      return _timeout;
    }
  }.apply();
  
  public LightweightTypeReference resolvesTo(final String expression, final String type) {
    try {
      String _replace = expression.replace("$$", "org::eclipse::xtext::xbase::lib::");
      final XExpression xExpression = this.expression(_replace, false);
      IBatchTypeResolver _typeResolver = this.getTypeResolver();
      final IResolvedTypes resolvedTypes = _typeResolver.resolveTypes(xExpression);
      final LightweightResolvedTypes lightweightResolvedTypes = ((LightweightResolvedTypes) resolvedTypes);
      final LightweightTypeReference lightweight = lightweightResolvedTypes.internalGetActualType(xExpression);
      String _simpleName = lightweight.getSimpleName();
      Assert.assertEquals(type, _simpleName);
      return lightweight;
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  @Ignore(value = "Performance")
  public void testBlockExpression_03() throws Exception {
    super.testBlockExpression_03();
  }
  
  @Test
  @Ignore(value = "Performance")
  public void testFeatureCall_15_n() throws Exception {
    super.testFeatureCall_15_n();
  }
  
  @Test
  @Ignore(value = "Performance")
  public void testFeatureCall_25_a() throws Exception {
    super.testFeatureCall_25_a();
  }
  
  @Test
  @Ignore(value = "Performance")
  public void testFeatureCall_25_b() throws Exception {
    super.testFeatureCall_25_b();
  }
  
  @Test
  @Ignore(value = "Performance")
  public void testFeatureCall_25_c() throws Exception {
    super.testFeatureCall_25_c();
  }
}
