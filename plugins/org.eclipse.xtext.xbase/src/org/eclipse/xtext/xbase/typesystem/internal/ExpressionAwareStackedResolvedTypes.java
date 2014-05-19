/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import java.util.Collection;

import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.references.UnboundTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API TODO Javadoc
 */
public class ExpressionAwareStackedResolvedTypes extends StackedResolvedTypes {

	private final XExpression expression;

	protected ExpressionAwareStackedResolvedTypes(ResolvedTypes parent, XExpression expression) {
		super(parent);
		this.expression = expression;
	}

	@Override
	protected void prepareMergeIntoParent() {
		tryResolveUnboundReferences();
		mergeLocalTypes();
	}

	protected void mergeLocalTypes() {
		Collection<TypeData> result = basicGetExpressionTypes().get(expression);
		if (result != null && !result.isEmpty()) {
			TypeData returnTypeData = mergeTypeData(expression, result, true, true);
			TypeData actualTypeData = mergeTypeData(expression, result, false, true);
			result.clear();
			if (returnTypeData != null)
				result.add(returnTypeData);
			if (actualTypeData != null)
				result.add(actualTypeData);
		}
	}

	protected void tryResolveUnboundReferences() {
		for (UnboundTypeReference unbound : basicGetTypeParameters().values()) {
			if (unbound.getExpression() == expression) {
				// resolve all type parameters of the expression that
				// have already been annotated with significant hints
				// the type constraints themselves are not considered to
				// be significant 'enough'
				unbound.tryResolve(false);
			}
		}
	}

}
