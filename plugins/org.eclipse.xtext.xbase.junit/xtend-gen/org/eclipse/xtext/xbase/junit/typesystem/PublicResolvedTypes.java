package org.eclipse.xtext.xbase.junit.typesystem;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.internal.DefaultReentrantTypeResolver;
import org.eclipse.xtext.xbase.typesystem.internal.RootResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.internal.RootUnboundTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
@SuppressWarnings("all")
public class PublicResolvedTypes extends RootResolvedTypes {
  public PublicResolvedTypes(final DefaultReentrantTypeResolver resolver) {
    super(resolver);
  }
  
  public RootUnboundTypeReference createUnboundTypeReference(final XExpression expression, final JvmTypeParameter type) {
    RootUnboundTypeReference _createUnboundTypeReference = super.createUnboundTypeReference(expression, type);
    return _createUnboundTypeReference;
  }
  
  public RootUnboundTypeReference getUnboundTypeReference(final Object handle) {
    RootUnboundTypeReference _unboundTypeReference = super.getUnboundTypeReference(handle);
    return _unboundTypeReference;
  }
}
