/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.util;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import org.eclipse.xtext.common.types.JvmLowerBound;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;
import org.eclipse.xtext.xtype.XComputedTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString - focus on differences to ActualTypeArgumentCollector and UnboundTypeParameterAwareTypeArgumentCollector
 */
public class DeferredTypeParameterHintCollector extends AbstractTypeReferencePairWalker {

	protected class ComputedTypeReferenceTraverser extends
		AbstractTypeReferenceTraverser<XComputedTypeReference> {
		
		@Override
		public Void doVisitTypeReference(JvmTypeReference reference, XComputedTypeReference declaration) {
			if (UnboundTypeParameters.isUnboundTypeParameter(declaration)) {
				UnboundTypeParameter typeParameter = (UnboundTypeParameter) declaration.getTypeProvider();
				addHint(typeParameter, reference);
				return null;
			}
			return DeferredTypeParameterHintCollector.super.doVisitComputedTypeReference(declaration, reference);
		}
		
		@Override
		public Void doVisitComputedTypeReference(XComputedTypeReference reference, XComputedTypeReference param) {
			return doVisitTypeReference(reference, param);
		}
		
		@Override
		public Void doVisitWildcardTypeReference(JvmWildcardTypeReference reference, XComputedTypeReference declaration) {
			if (UnboundTypeParameters.isUnboundTypeParameter(declaration)) {
				boolean lowerBoundFound = false;
				for (JvmTypeConstraint actualConstraint : reference.getConstraints()) {
					if (actualConstraint instanceof JvmLowerBound) {
						lowerBoundFound = true;
						outerVisit(declaration, actualConstraint.getTypeReference(), declaration, getExpectedVariance(), VarianceInfo.IN);
					}
				}
				if (!lowerBoundFound) {
					for (JvmTypeConstraint actualConstraint : reference.getConstraints()) {
						outerVisit(declaration, actualConstraint.getTypeReference(), declaration, getExpectedVariance(), VarianceInfo.OUT);
					}
				}
				return null;
			}
			return DeferredTypeParameterHintCollector.super.doVisitComputedTypeReference(declaration, reference);
		}
		
	}
	
	private ComputedTypeReferenceTraverser computedTypeReferenceTraverser;
	
	public DeferredTypeParameterHintCollector(CommonTypeComputationServices services) {
		super(services);
		computedTypeReferenceTraverser = createComputedTypeReferenceTraverser();
	}
	
	protected ComputedTypeReferenceTraverser createComputedTypeReferenceTraverser() {
		return new ComputedTypeReferenceTraverser();
	}
	
	@Override
	protected TypeParameterSubstitutor createTypeParameterSubstitutor(Map<JvmTypeParameter, MergedBoundTypeArgument> mapping) {
		return new UnboundTypeParameterPreservingSubstitutor(mapping, getServices());
	}

	@Override
	public Void doVisitComputedTypeReference(XComputedTypeReference reference, JvmTypeReference param) {
		return computedTypeReferenceTraverser.visit(param, reference);
	}

	@Override
	protected ParameterizedTypeReferenceTraverser createParameterizedTypeReferenceTraverser() {
		return new ParameterizedTypeReferenceTraverser() {
			@Override
			public Void doVisitComputedTypeReference(XComputedTypeReference reference,
					JvmParameterizedTypeReference declaration) {
				if (UnboundTypeParameters.isUnboundTypeParameter(reference)) {
					UnboundTypeParameter typeParameter = (UnboundTypeParameter) reference.getTypeProvider();
					addHint(typeParameter, declaration);
					return null;
				}
				return super.doVisitComputedTypeReference(reference, declaration);
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
	protected WildcardTypeReferenceTraverser createWildcardTypeReferenceTraverser() {
		return new UnboundTypeParameterAwareWildcardTypeReferenceTraverser(this);
	}

	@Override
	protected JvmType getTypeFromReference(JvmTypeReference reference) {
		if (reference instanceof XComputedTypeReference) {
			XComputedTypeReference computed = (XComputedTypeReference) reference;
			if (UnboundTypeParameters.isUnboundTypeParameter(computed)) {
				return ((UnboundTypeParameter) computed.getTypeProvider()).getTypeParameter();
			}
		}
		return super.getTypeFromReference(reference);
	}
	
	@Override
	protected JvmTypeParameter findMappedParameter(JvmTypeParameter parameter,
			Map<JvmTypeParameter, MergedBoundTypeArgument> mapping, Collection<JvmTypeParameter> visited) {
		return UnboundTypeParameters.findMappedParameter(parameter, mapping, visited);
	}

	protected void addHint(UnboundTypeParameter typeParameter, JvmTypeReference reference) {
		if (!UnboundTypeParameters.isUnboundAndEqual(typeParameter, reference)) {
			JvmTypeReference wrapped = asWrapperType(reference);
			typeParameter.acceptHint(wrapped, BoundTypeArgumentSource.INFERRED_LATER, getOrigin(), getExpectedVariance(), getActualVariance());
		}
	}

	protected JvmTypeReference asWrapperType(JvmTypeReference potentialPrimitive) {
		return UnboundTypeParameters.asWrapperType(potentialPrimitive, getServices().getPrimitives());
	}

}