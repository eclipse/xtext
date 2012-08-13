package org.eclipse.xtext.xbase.junit.typesystem;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.xtext.xbase.scoping.batch.IBatchScopeProvider;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeComputer;
import org.eclipse.xtext.xbase.typesystem.internal.DefaultReentrantTypeResolver;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
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
