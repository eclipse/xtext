/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import java.util.List;

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
		List<TypeData> result = basicGetExpressionTypes().get(expression);
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
