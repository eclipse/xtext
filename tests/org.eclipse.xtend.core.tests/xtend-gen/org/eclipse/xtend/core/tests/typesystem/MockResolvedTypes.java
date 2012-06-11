package org.eclipse.xtend.core.tests.typesystem;

import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.internal.DefaultReentrantTypeResolver;
import org.eclipse.xtext.xbase.typesystem.internal.ResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.internal.RootUnboundTypeParameter;

/**
 * @author Sebastian Zarnekow
 */
@SuppressWarnings("all")
public class MockResolvedTypes extends ResolvedTypes {
  public MockResolvedTypes(final DefaultReentrantTypeResolver resolver) {
    super(resolver);
  }
  
  public RootUnboundTypeParameter createUnboundTypeParameter(final XExpression expression, final JvmTypeParameter type) {
    RootUnboundTypeParameter _createUnboundTypeParameter = super.createUnboundTypeParameter(expression, type);
    return _createUnboundTypeParameter;
  }
}
