package org.eclipse.xtext.xbase.tests.typesystem;

import org.eclipse.xtext.xbase.typesystem.internal.DefaultReentrantTypeResolver;
import org.eclipse.xtext.xbase.typesystem.internal.TypeResolution;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class MyTypeResolution extends TypeResolution {
  public MyTypeResolution(final DefaultReentrantTypeResolver resolver) {
    super(resolver);
  }
}
