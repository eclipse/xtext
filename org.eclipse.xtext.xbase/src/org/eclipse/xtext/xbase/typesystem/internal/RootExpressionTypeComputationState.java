/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import java.util.Collections;
import java.util.List;

import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.scoping.batch.IFeatureScopeSession;
import org.eclipse.xtext.xbase.typesystem.conformance.ConformanceFlags;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class RootExpressionTypeComputationState extends ExpressionTypeComputationState {
	
	protected static class PendingRootExpectation extends RootNoExpectation {
		
		private RootExpressionTypeComputationState rootState;

		public PendingRootExpectation(AbstractTypeComputationState state, RootExpressionTypeComputationState rootState, boolean voidAllowed) {
			super(state, voidAllowed);
			this.rootState = rootState;
		}

		@Override
		public void acceptActualType(LightweightTypeReference type, int flags) {
			if ((flags & ConformanceFlags.EXPLICIT_VOID_RETURN) != 0) {
				rootState.expectedReturnType = type;
			}
			super.acceptActualType(type, flags);
		}
		
		@Override
		/* @Nullable */
		public LightweightTypeReference getExpectedType() {
			if (rootState.expectedReturnType != null) {
				return rootState.expectedReturnType;
			}
			return super.getExpectedType();
		}

		@Override
		public boolean isNoTypeExpectation() {
			if (rootState.expectedReturnType != null) {
				return false;
			}
			return super.isNoTypeExpectation();
		}

		@Override
		public boolean isVoidTypeAllowed() {
			if (rootState.expectedReturnType != null) {
				return true;
			}
			return super.isVoidTypeAllowed();
		}
	}

	private final LightweightTypeReference expectedType;
	private LightweightTypeReference expectedReturnType;

	protected RootExpressionTypeComputationState(StackedResolvedTypes resolvedTypes,
			IFeatureScopeSession featureScopeSession,
			AbstractTypeComputationState parent, 
			XExpression expression, 
			/* @Nullable */ LightweightTypeReference expectedType) {
		super(resolvedTypes, featureScopeSession, parent, expression);
		this.expectedType = expectedType;
		this.expectedReturnType = expectedType;
	}

	@Override
	public List<AbstractTypeExpectation> getExpectations(
			AbstractTypeComputationState actualState) {
		AbstractTypeExpectation result = createTypeExpectation(expectedType, actualState, true, false);
		return Collections.singletonList(result);
	}

	@Override
	protected List<AbstractTypeExpectation> getReturnExpectations(AbstractTypeComputationState actualState, boolean asActualExpectation) {
		AbstractTypeExpectation result = createTypeExpectation(expectedReturnType, actualState, !asActualExpectation, true);
		return Collections.singletonList(result);
	}
	
	protected AbstractTypeExpectation createTypeExpectation(/* @Nullable */ LightweightTypeReference expectedType, AbstractTypeComputationState actualState, boolean voidAllowed, boolean returnType) {
		AbstractTypeExpectation result = null;
		if (expectedType != null) {
			LightweightTypeReference copied = expectedType.copyInto(actualState.getReferenceOwner());
			result = new RootTypeExpectation(copied, actualState);
		} else if (returnType) {
			result = new PendingRootExpectation(actualState, this, voidAllowed);
		} else {
			result = new RootNoExpectation(actualState, voidAllowed);
		}
		return result;
	}
	
}