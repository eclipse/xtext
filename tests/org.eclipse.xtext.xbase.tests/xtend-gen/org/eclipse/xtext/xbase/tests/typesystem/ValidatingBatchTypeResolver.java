package org.eclipse.xtext.xbase.tests.typesystem;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.xtext.xbase.tests.typesystem.ValidatingReentrantTypeResolver;
import org.eclipse.xtext.xbase.typesystem.internal.DefaultBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.internal.IReentrantTypeResolver;

/**
 * @author Sebastian Zarnekow
 */
@SuppressWarnings("all")
public class ValidatingBatchTypeResolver extends DefaultBatchTypeResolver {
  @Inject
  private Provider<ValidatingReentrantTypeResolver> resolverProvider;
  
  public IReentrantTypeResolver createResolver() {
    ValidatingReentrantTypeResolver _get = this.resolverProvider.get();
    return _get;
  }
}
