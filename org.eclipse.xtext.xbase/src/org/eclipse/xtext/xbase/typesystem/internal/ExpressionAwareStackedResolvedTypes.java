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

import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.scoping.batch.BucketedEObjectDescription;
import org.eclipse.xtext.xbase.scoping.batch.SimpleIdentifiableElementDescription;
import org.eclipse.xtext.xbase.typesystem.computation.IApplicableCandidate;
import org.eclipse.xtext.xbase.typesystem.computation.IFeatureLinkingCandidate;
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
	
	/**
	 * @since 2.30
	 */
	protected XExpression expression() {
		return expression;
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
	
	@Override
	protected void performMergeIntoParent() {
		if (canBeForwardResolved()) {
			/*
			 * XExpressions that can be forward-resolved will be kept around in the forwardComputedChildren map.
			 * 
			 * There are two cases: Either we performed the computation for the first time or we are
			 * in a subsequent iteration where we used refined results from a previous run.
			 */
 			IApplicableCandidate candidate = basicGetLinkingMap().get(expression);
			if (candidate instanceof AbstractPendingLinkingCandidate<?>) {
				AbstractPendingLinkingCandidate<?> casted = (AbstractPendingLinkingCandidate<?>) candidate;
				if (casted.description instanceof BucketedEObjectDescription || casted.description instanceof SimpleIdentifiableElementDescription) {
					forwardLinking().put((XAbstractFeatureCall) expression, casted);
				}
			}
		}
		super.performMergeIntoParent();
	}
	
	protected boolean canBeForwardResolved() {
		if (expression instanceof XAbstractFeatureCall 
				&& basicGetTypeParameters().isEmpty() 
				&& basicGetTypeParameterHints().isEmpty() 
				&& basicGetDeclardTypeParameters() == null
				&& basicGetReassignedTypes().isEmpty()
				&& basicGetPropagatedTypes().isEmpty()
				&& basicGetRefinedTypes().isEmpty()
				&& basicGetTypes().isEmpty()) {
			IFeatureLinkingCandidate candidate = this.getFeature((XAbstractFeatureCall)expression);
			if (candidate != null && candidate.getTypeArguments().isEmpty()) {
				return true;
			}
		}
		return false;
	}

}
