/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.references;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.xbase.typesystem.util.BoundTypeArgumentSource;
import org.eclipse.xtext.xbase.typesystem.util.VarianceInfo;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString - focus on differences to ActualTypeArgumentCollector and UnboundTypeParameterAwareTypeArgumentCollector
 */
@NonNullByDefault
public class DeferredTypeParameterHintCollector extends AbstractTypeReferencePairWalker {

	protected class ComputedTypeReferenceTraverser extends
		TypeReferenceVisitorWithParameter<UnboundTypeReference> {
		
		@Override
		protected void doVisitTypeReference(LightweightTypeReference reference, UnboundTypeReference declaration) {
			addHint(declaration, reference);
		}
		
		@Override
		public void doVisitWildcardTypeReference(WildcardTypeReference reference, UnboundTypeReference declaration) {
			LightweightTypeReference lowerBound = reference.getLowerBound();
			if (lowerBound != null) {
				outerVisit(declaration, lowerBound, declaration, getExpectedVariance(), VarianceInfo.IN);
			} else {
				for (LightweightTypeReference upperBound : reference.getUpperBounds()) {
					outerVisit(declaration, upperBound, declaration, getExpectedVariance(), VarianceInfo.OUT);
				}
			}
		}
		
	}
	
	private ComputedTypeReferenceTraverser computedTypeReferenceTraverser;
	
	public DeferredTypeParameterHintCollector(TypeReferenceOwner owner) {
		super(owner);
		computedTypeReferenceTraverser = createComputedTypeReferenceTraverser();
	}
	
	protected ComputedTypeReferenceTraverser createComputedTypeReferenceTraverser() {
		return new ComputedTypeReferenceTraverser();
	}
	
	@Override
	protected TypeParameterSubstitutor<?> createTypeParameterSubstitutor(Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> mapping) {
		return new StandardTypeParameterSubstitutor(mapping, getOwner()) {
			@Override
			protected LightweightTypeReference doVisitUnboundTypeReference(UnboundTypeReference reference, Object param) {
				return reference.copyInto(getOwner());
			}
		};
	}

	@Override
	public void doVisitUnboundTypeReference(UnboundTypeReference reference, LightweightTypeReference param) {
		param.accept(computedTypeReferenceTraverser, reference);
	}
	
	protected LightweightTypeReference copy(UnboundTypeReference reference) {
		return reference.copyInto(getOwner());
	}

	@Override
	protected ParameterizedTypeReferenceTraverser createParameterizedTypeReferenceTraverser() {
		return new ParameterizedTypeReferenceTraverser() {
			@Override
			public void doVisitUnboundTypeReference(UnboundTypeReference reference,
					ParameterizedTypeReference declaration) {
				addHint(reference, declaration);
			}
			
			@Override
			protected boolean shouldProcessInContextOf(JvmTypeParameter declaredTypeParameter, Set<JvmTypeParameter> boundParameters,
					Set<JvmTypeParameter> visited) {
				if (boundParameters.contains(declaredTypeParameter) && !visited.add(declaredTypeParameter)) {
					return false;
				}
				return true;
			}
		};
	}
	
	@Override
	protected JvmTypeParameter findMappedParameter(JvmTypeParameter parameter,
			Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> mapping, Collection<JvmTypeParameter> visited) {
		return UnboundTypeReferences.findMappedParameter(parameter, mapping, visited);
	}

	protected void addHint(UnboundTypeReference typeParameter, LightweightTypeReference reference) {
		LightweightTypeReference wrapped = reference.getWrapperTypeIfPrimitive();
		typeParameter.acceptHint(wrapped, BoundTypeArgumentSource.INFERRED_LATER, getOrigin(), getExpectedVariance(), getActualVariance());
	}

}