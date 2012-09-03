/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import java.util.Collections;
import java.util.List;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.scoping.batch.IFeatureScopeSession;
import org.eclipse.xtext.xbase.typesystem.conformance.ConformanceHint;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString
 */
@NonNullByDefault
public class TypeComputationStateWithRootExpectation extends TypeComputationStateWithExpectation {

	protected class RootExpectationAwareExpressionTypeComputationState extends ExpressionTypeComputationState {
		protected RootExpectationAwareExpressionTypeComputationState(StackedResolvedTypes resolvedTypes,
				IFeatureScopeSession featureScopeSession, DefaultReentrantTypeResolver reentrantTypeResolver,
				AbstractTypeComputationState parent, XExpression expression) {
			super(resolvedTypes, featureScopeSession, reentrantTypeResolver, parent, expression);
		}

		@Override
		public List<AbstractTypeExpectation> getImmediateExpectations(
				AbstractTypeComputationState actualState) {
			AbstractTypeExpectation result = createTypeExpectation(getExpectedType(), actualState, false);
			return Collections.singletonList(result);
		}

		@Override
		public List<AbstractTypeExpectation> getReturnExpectations(AbstractTypeComputationState actualState) {
			AbstractTypeExpectation result = createTypeExpectation(getExpectedType(), actualState, true);
			return Collections.singletonList(result);
		}
		
		boolean returnTypeSeen = false;
		
		@Override
		protected LightweightTypeReference acceptType(ResolvedTypes resolvedTypes, AbstractTypeExpectation expectation,
				LightweightTypeReference type, boolean returnType, ConformanceHint... hints) {
			if (returnTypeSeen) {
				if (!returnType && type.isPrimitiveVoid())
					return type;
			}
			if (returnType)
				returnTypeSeen = true;
			return super.acceptType(resolvedTypes, expectation, type, returnType, hints);
		}

		protected AbstractTypeExpectation createTypeExpectation(@Nullable LightweightTypeReference expectedType, AbstractTypeComputationState actualState, boolean returnType) {
			AbstractTypeExpectation result = null;
			if (expectedType != null) {
				LightweightTypeReference copied = expectedType.copyInto(actualState.getReferenceOwner());
				result = returnType ? new TypeExpectation(copied, actualState, returnType) {
					@Override
					public void acceptActualType(LightweightTypeReference type, ConformanceHint... hints) {
						acceptType(getResolvedTypes(), this, type, true, hints);
					}
				}: new TypeExpectation(copied, actualState, returnType);
			} else {
				result = returnType ? new RootNoExpectation(actualState) : new NoExpectation(actualState, returnType);
			}
			return result;
		}
		
	}

	protected TypeComputationStateWithRootExpectation(
			ResolvedTypes resolvedTypes,
			IFeatureScopeSession featureScopeSession,
			DefaultReentrantTypeResolver reentrantTypeResolver,
			AbstractTypeComputationState parent,
			@Nullable LightweightTypeReference typeReference) {
		super(resolvedTypes, featureScopeSession, reentrantTypeResolver, parent, typeReference);
	}
	
	@Override
	public List<AbstractTypeExpectation> getReturnExpectations(AbstractTypeComputationState actualState) {
		AbstractTypeExpectation result = createTypeExpectation(getExpectedType(), actualState, true);
		return Collections.singletonList(result);
	}
	
	@Override
	protected ExpressionTypeComputationState createExpressionComputationState(XExpression expression,
			StackedResolvedTypes typeResolution) {
		return new RootExpectationAwareExpressionTypeComputationState(typeResolution, getFeatureScopeSession(), getResolver(), this, expression);
	}
	
	@Override
	public TypeAssigner assignTypes() {
		TypeCheckpointComputationState state = new TypeCheckpointComputationState(getResolvedTypes(), getFeatureScopeSession(), getResolver(), this) {
			@Override
			protected ExpressionTypeComputationState createExpressionComputationState(XExpression expression,
					StackedResolvedTypes typeResolution) {
				return new RootExpectationAwareExpressionTypeComputationState(typeResolution, getFeatureScopeSession(), getResolver(), this, expression);
			}
		};
		return createTypeAssigner(state);
	}
	
}
