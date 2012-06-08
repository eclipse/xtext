package org.eclipse.xtext.xbase.tests.typesystem;

import org.eclipse.xtext.xbase.scoping.batch.IBatchScopeProvider;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeComputer;
import org.eclipse.xtext.xbase.typesystem.internal.DefaultReentrantTypeResolver;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class PublicReentrantTypeResolver extends DefaultReentrantTypeResolver {
  public void setTypeComputer(final ITypeComputer typeComputer) {
    super.setTypeComputer(typeComputer);
  }
  
  public IBatchScopeProvider getBatchScopeProvider() {
    IBatchScopeProvider _batchScopeProvider = super.getBatchScopeProvider();
    return _batchScopeProvider;
  }
}
