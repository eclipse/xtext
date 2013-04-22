/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.util;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.UnboundTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString - focus on differences to ActualTypeArgumentCollector and UnboundTypeParameterAwareTypeArgumentCollector
 */
@NonNullByDefault
public class ExpectationTypeParameterHintCollector extends DeferredTypeParameterHintCollector {

	protected class DeferredParameterizedTypeReferenceTraverser extends ParameterizedTypeReferenceTraverser {
		@Override
		public void doVisitUnboundTypeReference(UnboundTypeReference reference,
				ParameterizedTypeReference declaration) {
			boolean constraintSeen = false;
			if (reference.getTypeParameter() != declaration.getType()) {
				List<LightweightBoundTypeArgument> hints = reference.getAllHints();
				for(LightweightBoundTypeArgument hint: hints) {
					if (hint.getSource() == BoundTypeArgumentSource.CONSTRAINT) {
						constraintSeen = true;
						outerVisit(hint.getTypeReference(), declaration, hint.getSource(), hint.getDeclaredVariance(), hint.getActualVariance());
					}
				}
			} else {
				if (getOwner().getDeclaredTypeParameters().contains(reference.getTypeParameter())) {
					reference.acceptHint(declaration, BoundTypeArgumentSource.RESOLVED, this, VarianceInfo.INVARIANT, VarianceInfo.INVARIANT);
					return;
				}
			}
			if (!constraintSeen && !reference.internalIsResolved() && declaration.isResolved() && !getOwner().isResolved(reference.getHandle()) && reference.canResolveTo(declaration)) {
				reference.acceptHint(declaration, BoundTypeArgumentSource.RESOLVED, this, VarianceInfo.INVARIANT, VarianceInfo.INVARIANT);
			} else {
				reference.tryResolve();
				if (reference.internalIsResolved()) {
					outerVisit(reference, declaration);
				} else {
					addHint(reference, declaration);
				}
			}
		}

		@Override
		protected boolean shouldProcessInContextOf(JvmTypeParameter declaredTypeParameter, Set<JvmTypeParameter> boundParameters,
				Set<JvmTypeParameter> visited) {
			if (getOwner().getDeclaredTypeParameters().contains(declaredTypeParameter))
				return true;
			if (boundParameters.contains(declaredTypeParameter) && !visited.add(declaredTypeParameter)) {
				return false;
			}
			return true;
		}
	}

	public ExpectationTypeParameterHintCollector(ITypeReferenceOwner owner) {
		super(owner);
	}
	
	@Override
	protected TypeParameterSubstitutor<?> createTypeParameterSubstitutor(
			Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> mapping) {
		return new UnboundTypeParameterPreservingSubstitutor(mapping, getOwner());
	}
	
	@Override
	protected ParameterizedTypeReferenceTraverser createParameterizedTypeReferenceTraverser() {
		return new DeferredParameterizedTypeReferenceTraverser();
	}
	
}