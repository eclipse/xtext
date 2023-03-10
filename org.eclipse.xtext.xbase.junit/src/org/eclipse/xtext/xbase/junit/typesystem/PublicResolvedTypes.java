/**
 * Copyright (c) 2012, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
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
 * @deprecated Use org.eclipse.xtext.xbase.testing.typesystem.PublicResolvedTypes instead
 */
@Deprecated(forRemoval = true)
public class PublicResolvedTypes extends RootResolvedTypes {
	public PublicResolvedTypes(DefaultReentrantTypeResolver resolver) {
		super(resolver, CancelIndicator.NullImpl);
	}

	@Override
	public UnboundTypeReference createUnboundTypeReference(XExpression expression, JvmTypeParameter type) {
		return super.createUnboundTypeReference(expression, type);
	}

	@Override
	public UnboundTypeReference getUnboundTypeReference(Object handle) {
		return super.getUnboundTypeReference(handle);
	}

	@Override
	public List<LightweightBoundTypeArgument> getHints(Object handle) {
		return super.getHints(handle);
	}

	@Override
	public Map<XExpression, List<TypeData>> basicGetExpressionTypes() {
		return super.basicGetExpressionTypes();
	}
}
