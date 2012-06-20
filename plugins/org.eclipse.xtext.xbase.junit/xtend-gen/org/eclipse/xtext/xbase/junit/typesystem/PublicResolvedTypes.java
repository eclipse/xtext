package org.eclipse.xtext.xbase.junit.typesystem;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.internal.DefaultReentrantTypeResolver;
import org.eclipse.xtext.xbase.typesystem.internal.RootResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.internal.RootUnboundTypeParameter;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
@SuppressWarnings("all")
public class PublicResolvedTypes extends RootResolvedTypes {
  public PublicResolvedTypes(final DefaultReentrantTypeResolver resolver) {
    super(resolver);
  }
  
  public RootUnboundTypeParameter createUnboundTypeParameter(final XExpression expression, final JvmTypeParameter type) {
    RootUnboundTypeParameter _createUnboundTypeParameter = super.createUnboundTypeParameter(expression, type);
    return _createUnboundTypeParameter;
  }
  
  public RootUnboundTypeParameter getUnboundTypeParameter(final Object handle) {
    RootUnboundTypeParameter _unboundTypeParameter = super.getUnboundTypeParameter(handle);
    return _unboundTypeParameter;
  }
}
