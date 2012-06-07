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

import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.Primitives;
import org.eclipse.xtext.xtype.XComputedTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString - focus on differences to ActualTypeArgumentCollector and UnboundTypeParameterAwareTypeArgumentCollector
 */
public class DeferredTypeParameterHintCollector extends AbstractTypeReferencePairWalker {

	public DeferredTypeParameterHintCollector(CommonTypeComputationServices services) {
		super(services);
	}
	
	@Override
	protected TypeParameterSubstitutor createTypeParameterSubstitutor(Map<JvmTypeParameter, MergedBoundTypeArgument> mapping) {
		return new UnboundTypeParameterPreservingSubstitutor(mapping, getServices());
	}

	@Override
	public Void doVisitComputedTypeReference(XComputedTypeReference reference, JvmTypeReference param) {
		if (UnboundTypeParameters.isUnboundTypeParameter(reference)) {
			UnboundTypeParameter typeParameter = (UnboundTypeParameter) reference.getTypeProvider();
			addHint(typeParameter, param);
			return null;
		}
		return super.doVisitComputedTypeReference(reference, param);
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
		if (potentialPrimitive instanceof XComputedTypeReference) {
			if (((XComputedTypeReference) potentialPrimitive).getTypeProvider() instanceof UnboundTypeParameter) {
				// since type parameters are never primitives, it's save to add them directly
				return potentialPrimitive;
			}
		}
		Primitives primitives = getServices().getPrimitives();
		JvmTypeReference result = primitives.asWrapperTypeIfPrimitive(potentialPrimitive);
		return result;
	}

}