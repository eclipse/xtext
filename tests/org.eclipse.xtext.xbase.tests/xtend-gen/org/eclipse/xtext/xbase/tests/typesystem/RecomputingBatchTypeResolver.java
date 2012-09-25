package org.eclipse.xtext.xbase.tests.typesystem;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.xtext.xbase.tests.typesystem.RecomputingReentrantTypeResolver;
import org.eclipse.xtext.xbase.typesystem.internal.DefaultBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.internal.IReentrantTypeResolver;

/**
 * @author Sebastian Zarnekow
 */
@SuppressWarnings("all")
public class RecomputingBatchTypeResolver extends DefaultBatchTypeResolver {
  @Inject
  private Provider<RecomputingReentrantTypeResolver> resolverProvider;
  
  public IReentrantTypeResolver createResolver() {
    RecomputingReentrantTypeResolver _get = this.resolverProvider.get();
    return _get;
  }
}
