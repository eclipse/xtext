/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.junit.typesystem;

import com.google.common.collect.Multimap;
import java.util.List;
import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.internal.DefaultReentrantTypeResolver;
import org.eclipse.xtext.xbase.typesystem.internal.RootResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.internal.TypeData;
import org.eclipse.xtext.xbase.typesystem.references.LightweightBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.UnboundTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
@SuppressWarnings("all")
public class PublicResolvedTypes extends RootResolvedTypes {
  public PublicResolvedTypes(final DefaultReentrantTypeResolver resolver) {
    super(resolver);
  }
  
  public UnboundTypeReference createUnboundTypeReference(final XExpression expression, final JvmTypeParameter type) {
    UnboundTypeReference _createUnboundTypeReference = super.createUnboundTypeReference(expression, type);
    return _createUnboundTypeReference;
  }
  
  public UnboundTypeReference getUnboundTypeReference(final Object handle) {
    UnboundTypeReference _unboundTypeReference = super.getUnboundTypeReference(handle);
    return _unboundTypeReference;
  }
  
  public List<LightweightBoundTypeArgument> getHints(final Object handle) {
    List<LightweightBoundTypeArgument> _hints = super.getHints(handle);
    return _hints;
  }
  
  public Multimap<XExpression,TypeData> basicGetExpressionTypes() {
    Multimap<XExpression,TypeData> _basicGetExpressionTypes = super.basicGetExpressionTypes();
    return _basicGetExpressionTypes;
  }
}
