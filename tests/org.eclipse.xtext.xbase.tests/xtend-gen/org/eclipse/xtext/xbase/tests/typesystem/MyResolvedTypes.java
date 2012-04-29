package org.eclipse.xtext.xbase.tests.typesystem;

import org.eclipse.xtext.xbase.typesystem.internal.DefaultReentrantTypeResolver;
import org.eclipse.xtext.xbase.typesystem.internal.ResolvedTypes;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class MyResolvedTypes extends ResolvedTypes {
  public MyResolvedTypes(final DefaultReentrantTypeResolver resolver) {
    super(resolver);
  }
}
