package org.eclipse.xtext.xbase.junit.typesystem;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.internal.BaseUnboundTypeParameter;
import org.eclipse.xtext.xbase.typesystem.internal.DefaultReentrantTypeResolver;
import org.eclipse.xtext.xbase.typesystem.internal.ResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.internal.RootUnboundTypeParameter;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
@SuppressWarnings("all")
public class PublicResolvedTypes extends ResolvedTypes {
  public PublicResolvedTypes(final DefaultReentrantTypeResolver resolver) {
    super(resolver);
  }
  
  public RootUnboundTypeParameter createUnboundTypeParameter(final XExpression expression, final JvmTypeParameter type) {
    RootUnboundTypeParameter _createUnboundTypeParameter = super.createUnboundTypeParameter(expression, type);
    return _createUnboundTypeParameter;
  }
  
  public BaseUnboundTypeParameter getUnboundTypeParameter(final Object handle) {
    BaseUnboundTypeParameter _unboundTypeParameter = super.getUnboundTypeParameter(handle);
    return _unboundTypeParameter;
  }
}
