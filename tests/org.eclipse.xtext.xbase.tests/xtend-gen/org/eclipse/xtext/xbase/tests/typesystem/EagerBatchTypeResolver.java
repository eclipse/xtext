package org.eclipse.xtext.xbase.tests.typesystem;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.xtext.xbase.tests.typesystem.EagerReentrantTypeResolver;
import org.eclipse.xtext.xbase.typesystem.internal.DefaultBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.internal.IReentrantTypeResolver;

/**
 * @author Sebastian Zarnekow
 */
@SuppressWarnings("all")
public class EagerBatchTypeResolver extends DefaultBatchTypeResolver {
  @Inject
  private Provider<EagerReentrantTypeResolver> resolverProvider;
  
  protected IReentrantTypeResolver createResolver() {
    EagerReentrantTypeResolver _get = this.resolverProvider.get();
    return _get;
  }
}
