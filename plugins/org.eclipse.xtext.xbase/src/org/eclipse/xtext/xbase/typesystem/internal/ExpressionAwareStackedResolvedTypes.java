/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import java.util.Collection;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.computation.ConformanceHint;

import com.google.common.collect.Multimap;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO Javadoc
 */
public class ExpressionAwareStackedResolvedTypes extends StackedResolvedTypes {

	private final XExpression expression;

	@NonNullByDefault
	protected ExpressionAwareStackedResolvedTypes(ResolvedTypes parent, XExpression expression) {
		super(parent);
		this.expression = expression;
	}

	@Override
	protected void mergeInto(ResolvedTypes parent) {
		Collection<TypeData> result = ensureExpressionTypesMapExists().get(expression);
		if (result.isEmpty()) {
			// TODO add error information because we could not compute a type for 'current'
			super.mergeInto(parent);
		} else {
			mergeExpressionTypes(parent, result);
			parent.ensureTypesMapExists().putAll(ensureTypesMapExists());
			parent.ensureLinkingMapExists().putAll(ensureLinkingMapExists());
			mergeTypeParametersIntoParent(parent);
		}
	}
	
	@Override
	protected JvmTypeReference acceptType(XExpression expression, AbstractTypeExpectation expectation,
			JvmTypeReference type, ConformanceHint conformanceHint, boolean returnType) {
		// TODO Auto-generated method stub
		return super.acceptType(expression, expectation, type, conformanceHint, returnType);
	}

	protected void mergeExpressionTypes(ResolvedTypes parent, Collection<TypeData> result) {
		Multimap<XExpression, TypeData> parentExpressionTypes = parent.ensureExpressionTypesMapExists();
		TypeData returnTypeData = mergeTypeData(expression, result, true, true);
		if (returnTypeData != null)
			parentExpressionTypes.put(expression, returnTypeData);
		TypeData actualTypeData = mergeTypeData(expression, result, false, true);
		if (actualTypeData != null)
			parentExpressionTypes.put(expression, actualTypeData);
		for(Map.Entry<XExpression, Collection<TypeData>> entry: ensureExpressionTypesMapExists().asMap().entrySet()) {
			if (!entry.getKey().equals(expression)) {
				parentExpressionTypes.putAll(entry.getKey(), entry.getValue());
			}
		}
	}
	
}
