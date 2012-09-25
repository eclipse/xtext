package org.eclipse.xtext.xbase.tests.typesystem;

import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.tests.typesystem.BatchTypeResolverTest;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.rules.Timeout;

/**
 * @author Sebastian Zarnekow
 */
@SuppressWarnings("all")
public abstract class TypeResolverPerformanceTest extends BatchTypeResolverTest {
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
      final LightweightTypeReference lightweight = resolvedTypes.getActualType(xExpression);
      String _simpleName = lightweight.getSimpleName();
      Assert.assertEquals(type, _simpleName);
      return lightweight;
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
