package org.eclipse.xtext.xbase.tests.typesystem;

import com.google.inject.Inject;
import com.google.inject.Injector;
import java.util.List;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;
import org.eclipse.xtext.xbase.tests.typesystem.AbstractTypeArgumentTest;
import org.eclipse.xtext.xbase.tests.typesystem.AvoidDeprecatedTypeSystemStandaloneSetup;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.junit.After;
import org.junit.Assert;

/**
 * @author Sebastian Zarnekow
 */
@SuppressWarnings("all")
public class BatchTypeArgumentTest extends AbstractTypeArgumentTest {
  private final static Injector batchInjector = new Function0<Injector>() {
    public Injector apply() {
      Injector _setup = AvoidDeprecatedTypeSystemStandaloneSetup.setup();
      return _setup;
    }
  }.apply();
  
  public Injector getInjector() {
    return BatchTypeArgumentTest.batchInjector;
  }
  
  @Inject
  private IBatchTypeResolver typeResolver;
  
  private IResolvedTypes resolvedTypes;
  
  protected void resolveTypes(final XExpression expression) {
    IResolvedTypes _resolveTypes = this.typeResolver.resolveTypes(expression);
    this.resolvedTypes = _resolveTypes;
  }
  
  @After
  public void discardResolvedTypes() {
    this.resolvedTypes = null;
  }
  
  protected void hasTypeArguments(final XExpression expression, final String... typeArguments) {
    final List<LightweightTypeReference> actualTypeArguments = this.resolvedTypes.getActualTypeArguments(expression);
    int _size = ((List<String>)Conversions.doWrapArray(typeArguments)).size();
    int _size_1 = actualTypeArguments.size();
    Assert.assertEquals(_size, _size_1);
    final Procedure2<String,Integer> _function = new Procedure2<String,Integer>() {
        public void apply(final String typeArgument, final Integer i) {
          StringConcatenation _builder = new StringConcatenation();
          String _join = IterableExtensions.join(((Iterable<? extends Object>)Conversions.doWrapArray(typeArguments)), ", ");
          _builder.append(_join, "");
          _builder.append(" vs ");
          final Function1<LightweightTypeReference,String> _function = new Function1<LightweightTypeReference,String>() {
              public String apply(final LightweightTypeReference it) {
                String _simpleName = it.getSimpleName();
                return _simpleName;
              }
            };
          List<String> _map = ListExtensions.<LightweightTypeReference, String>map(actualTypeArguments, _function);
          String _join_1 = IterableExtensions.join(_map, ", ");
          _builder.append(_join_1, "");
          LightweightTypeReference _get = actualTypeArguments.get((i).intValue());
          String _simpleName = _get.getSimpleName();
          Assert.assertEquals(_builder.toString(), typeArgument, _simpleName);
        }
      };
    IterableExtensions.<String>forEach(((Iterable<String>)Conversions.doWrapArray(typeArguments)), _function);
  }
}
