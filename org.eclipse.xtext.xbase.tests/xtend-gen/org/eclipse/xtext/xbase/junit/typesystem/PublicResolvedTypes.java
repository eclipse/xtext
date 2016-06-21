/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.junit.typesystem;

import java.util.List;
import java.util.Map;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.internal.DefaultReentrantTypeResolver;
import org.eclipse.xtext.xbase.typesystem.internal.RootResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.internal.TypeData;
import org.eclipse.xtext.xbase.typesystem.references.LightweightBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.UnboundTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class PublicResolvedTypes extends RootResolvedTypes {
  public PublicResolvedTypes(final DefaultReentrantTypeResolver resolver) {
    super(resolver, CancelIndicator.NullImpl);
  }
  
  @Override
  public UnboundTypeReference createUnboundTypeReference(final XExpression expression, final JvmTypeParameter type) {
    return super.createUnboundTypeReference(expression, type);
  }
  
  @Override
  public UnboundTypeReference getUnboundTypeReference(final Object handle) {
    return super.getUnboundTypeReference(handle);
  }
  
  @Override
  public List<LightweightBoundTypeArgument> getHints(final Object handle) {
    return super.getHints(handle);
  }
  
  @Override
  public Map<XExpression, List<TypeData>> basicGetExpressionTypes() {
    return super.basicGetExpressionTypes();
  }
}
