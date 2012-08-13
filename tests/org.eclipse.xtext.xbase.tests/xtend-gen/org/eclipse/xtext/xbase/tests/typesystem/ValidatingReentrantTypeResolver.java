package org.eclipse.xtext.xbase.tests.typesystem;

import org.eclipse.xtext.xbase.tests.typesystem.ValidatingRootResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.internal.DefaultReentrantTypeResolver;
import org.eclipse.xtext.xbase.typesystem.internal.RootResolvedTypes;

/**
 * @author Sebastian Zarnekow
 */
@SuppressWarnings("all")
public class ValidatingReentrantTypeResolver extends DefaultReentrantTypeResolver {
  public RootResolvedTypes createResolvedTypes() {
    ValidatingRootResolvedTypes _validatingRootResolvedTypes = new ValidatingRootResolvedTypes(this);
    return _validatingRootResolvedTypes;
  }
}
