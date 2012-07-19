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
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.computation.ConformanceHint;
import org.eclipse.xtext.xbase.typesystem.references.LightweightBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.UnboundTypeReference;

import com.google.common.collect.ListMultimap;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO Javadoc
 */
@NonNullByDefault
public class ExpressionAwareStackedResolvedTypes extends StackedResolvedTypes {

	private final XExpression expression;

	protected ExpressionAwareStackedResolvedTypes(ResolvedTypes parent, XExpression expression) {
		super(parent);
		this.expression = expression;
	}

	@Override
	protected LightweightTypeReference acceptType(XExpression expression, AbstractTypeExpectation expectation,
			LightweightTypeReference type, ConformanceHint conformanceHint, boolean returnType) {
		LightweightTypeReference result = super.acceptType(expression, expectation, type, conformanceHint, returnType);
		if (returnType) {
			acceptType(expression, new TypeData(expression, expectation, result, conformanceHint, false));
		}
		return result;
	}
	
	@Override
	protected void mergeTypeParametersIntoParent(ResolvedTypes parent) {
		for(UnboundTypeReference unbound: basicGetTypeParameters().values()) {
			if (unbound.getExpression() == expression) {
				unbound.tryResolve();
			}
			LightweightTypeReference reference = unbound.copyInto(parent.getReferenceOwner());
			if (reference instanceof UnboundTypeReference) {
				parent.acceptUnboundTypeReference(unbound.getHandle(), (UnboundTypeReference) reference);
			}
		}
		ListMultimap<Object, LightweightBoundTypeArgument> typeParameterHints = basicGetTypeParameterHints();
		for(Map.Entry<Object, LightweightBoundTypeArgument> hint: typeParameterHints.entries()) {
			if (!parent.isResolved(hint.getKey())) {
				LightweightBoundTypeArgument boundTypeArgument = hint.getValue();
				LightweightBoundTypeArgument copy = new LightweightBoundTypeArgument(
						boundTypeArgument.getTypeReference().copyInto(parent.getReferenceOwner()), 
						boundTypeArgument.getSource(), 
						boundTypeArgument.getOrigin(), 
						boundTypeArgument.getDeclaredVariance(), 
						boundTypeArgument.getActualVariance());
				parent.acceptHint(hint.getKey(), copy);
			}
		}
	}
	
	@Override
	protected void mergeExpressionTypesIntoParent(ResolvedTypes parent) {
		Collection<TypeData> result = basicGetExpressionTypes().get(expression);
		if (result.isEmpty()) {
			// TODO add error information because we could not compute a type for 'current'
			super.mergeExpressionTypesIntoParent(parent);
		}
		TypeData returnTypeData = mergeTypeData(expression, result, true, true);
		if (returnTypeData != null)
			parent.acceptType(expression, returnTypeData.copyInto(parent.getReferenceOwner()));
		TypeData actualTypeData = mergeTypeData(expression, result, false, true);
		if (actualTypeData != null)
			parent.acceptType(expression, actualTypeData.copyInto(parent.getReferenceOwner()));
		for(Map.Entry<XExpression, Collection<TypeData>> entry: basicGetExpressionTypes().asMap().entrySet()) {
			for(TypeData typeData: entry.getValue()) {
				if (!entry.getKey().equals(expression) || typeData.isReturnType() && returnTypeData == null || !typeData.isReturnType() && actualTypeData == null) {
					parent.acceptType(entry.getKey(), typeData.copyInto(parent.getReferenceOwner()));
				}
			}
		}
	}
	
}
