package org.eclipse.xtext.xbase.tests.typesystem;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.util.ReflectExtensions;
import org.eclipse.xtext.xbase.tests.typesystem.BatchTypeResolverTest;
import org.eclipse.xtext.xbase.tests.typesystem.EagerArgumentTypeResolver;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.internal.DefaultBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.internal.IReentrantTypeResolver;
import org.junit.Before;

/**
 * This tests ensures that the type calculation does not depend on some lazy evaluation.
 * Therefore all argument types for all overloaded variants are computed eagerly.
 * @author Sebastian Zarnekow
 */
@SuppressWarnings("all")
public class IsolationTest extends BatchTypeResolverTest {
  @Inject
  private EagerArgumentTypeResolver eagerResolver;
  
  @Inject
  private Provider<IReentrantTypeResolver> typeResolverProvider;
  
  @Inject
  private ReflectExtensions _reflectExtensions;
  
  @Before
  public void setEagerResolver() {
    try {
      IBatchTypeResolver _typeResolver = this.getTypeResolver();
      final DefaultBatchTypeResolver castedResolver = ((DefaultBatchTypeResolver) _typeResolver);
      final Function0<IReentrantTypeResolver> _function = new Function0<IReentrantTypeResolver>() {
          public IReentrantTypeResolver apply() {
            try {
              final IReentrantTypeResolver reentrantResolver = IsolationTest.this.typeResolverProvider.get();
              IsolationTest.this._reflectExtensions.set(reentrantResolver, "typeComputer", IsolationTest.this.eagerResolver);
              return reentrantResolver;
            } catch (Exception _e) {
              throw Exceptions.sneakyThrow(_e);
            }
          }
        };
      final Provider<IReentrantTypeResolver> provider = new Provider<IReentrantTypeResolver>() {
          public IReentrantTypeResolver get() {
            return _function.apply();
          }
      };
      this._reflectExtensions.set(castedResolver, "typeResolverProvider", provider);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
