package org.eclipse.xtext.xbase.tests.typesystem;

import org.eclipse.xtext.xbase.tests.typesystem.EagerReentrantTypeResolver;
import org.eclipse.xtext.xbase.tests.typesystem.ValidatingRootResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.internal.RootResolvedTypes;

/**
 * @author Sebastian Zarnekow
 */
@SuppressWarnings("all")
public class InvariantCheckingEagerReentrantTypeResolver extends EagerReentrantTypeResolver {
  protected RootResolvedTypes createResolvedTypes() {
    ValidatingRootResolvedTypes _validatingRootResolvedTypes = new ValidatingRootResolvedTypes(this);
    return _validatingRootResolvedTypes;
  }
}
