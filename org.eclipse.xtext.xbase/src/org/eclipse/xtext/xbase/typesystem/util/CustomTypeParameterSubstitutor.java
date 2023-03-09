/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.util;

import java.util.Map;

import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator;
import org.eclipse.xtext.common.types.JvmUpperBound;
import org.eclipse.xtext.xbase.typesystem.references.ArrayTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.UnboundTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.WildcardTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class CustomTypeParameterSubstitutor extends TypeParameterSubstitutor<ConstraintVisitingInfo> {

	protected CustomTypeParameterSubstitutor(Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> typeParameterMapping,
			ITypeReferenceOwner owner) {
		super(typeParameterMapping, owner);
	}
	
	@Override
	public LightweightTypeReference doVisitParameterizedTypeReference(ParameterizedTypeReference reference, ConstraintVisitingInfo visiting) {
		if (reference.isResolved() && reference.isOwnedBy(getOwner()))
			return reference;
		JvmType type = reference.getType();
		if (type instanceof JvmTypeParameter) {
			JvmTypeParameter typeParameter = (JvmTypeParameter) type;
			if (!visiting.tryVisit(typeParameter)) {
				if (!isDeclaredTypeParameter(typeParameter)) {
					if (visiting.getCurrentDeclarator() != null) {
						LightweightTypeReference mappedReference = getDeclaredUpperBound(visiting.getCurrentDeclarator(), visiting.getCurrentIndex(), visiting);
						getTypeParameterMapping().put((JvmTypeParameter)type, new LightweightMergedBoundTypeArgument(mappedReference, VarianceInfo.INVARIANT));
						return mappedReference;
					} else {
						LightweightMergedBoundTypeArgument candidate = getTypeParameterMapping().get(typeParameter);
						if (candidate != null && candidate.getTypeReference() != null)
							return candidate.getTypeReference();
						LightweightTypeReference mappedReference = getDeclaredUpperBound(typeParameter, visiting);
						if (mappedReference == null) {
							mappedReference = getObjectReference();
						}
						getTypeParameterMapping().put((JvmTypeParameter)type, new LightweightMergedBoundTypeArgument(mappedReference, VarianceInfo.INVARIANT));
						return mappedReference;
					}
				}
			} else {
				try {
					LightweightMergedBoundTypeArgument boundTypeArgument = getBoundTypeArgument(typeParameter, visiting);
					if (boundTypeArgument != null && boundTypeArgument.getTypeReference() != reference) {
						LightweightTypeReference result = boundTypeArgument.getTypeReference().accept(this, visiting);
						if (boundTypeArgument.getVariance() == VarianceInfo.OUT) {
							WildcardTypeReference wildcard = getOwner().newWildcardTypeReference();
							wildcard.addUpperBound(result.getInvariantBoundSubstitute());
							result = wildcard;
						} else if (boundTypeArgument.getVariance() == VarianceInfo.IN) {
							WildcardTypeReference wildcard = getOwner().newWildcardTypeReference();
							wildcard.addUpperBound(getObjectReference());
							wildcard.setLowerBound(result.getInvariantBoundSubstitute());
							result = wildcard;
						}
						return result;
					} else {
						LightweightTypeReference mappedReference = getUnmappedSubstitute(reference, (JvmTypeParameter) type, visiting);
						if (mappedReference != null) {
							getTypeParameterMapping().put((JvmTypeParameter)type, new LightweightMergedBoundTypeArgument(mappedReference, VarianceInfo.INVARIANT));
							return mappedReference;
						}
					}
				} finally {
					visiting.didVisit(typeParameter);
				}
			}
		}
		return doVisitParameterizedTypeReference(reference, type, visiting);
	}

	@Override
	protected LightweightTypeReference enhanceParameterizedTypeReference(ParameterizedTypeReference origin, JvmType type, ParameterizedTypeReference result, ConstraintVisitingInfo visiting) {
		for(int i = 0; i < origin.getTypeArguments().size(); i++) {
			LightweightTypeReference argument = origin.getTypeArguments().get(i);
			visiting.pushInfo(type instanceof JvmTypeParameterDeclarator ? (JvmTypeParameterDeclarator) type : null, i);
			LightweightTypeReference visitedArgument = visitTypeArgument(argument, visiting);
			result.addTypeArgument(visitedArgument);
		}
		return result;
	}

	protected boolean isDeclaredTypeParameter(JvmTypeParameter typeParameter) {
		return getOwner().getDeclaredTypeParameters().contains(typeParameter);
	}

	/**
	 * @param type the type parameter that is bound
	 * @param info the current traversal state
	 */
	/* @Nullable */
	protected LightweightMergedBoundTypeArgument getBoundTypeArgument(JvmTypeParameter type, ConstraintVisitingInfo info) {
		return getTypeParameterMapping().get(type);
	}
	
	/* @Nullable */
	protected abstract LightweightTypeReference getUnmappedSubstitute(ParameterizedTypeReference reference, JvmTypeParameter type, ConstraintVisitingInfo visiting);
	
	protected LightweightTypeReference getDeclaredUpperBound(/* @Nullable */ JvmTypeParameterDeclarator type, int parameterIndex, ConstraintVisitingInfo visiting) {
		if (type != null && type.getTypeParameters().size() > parameterIndex) {
			JvmTypeParameter typeParameter = type.getTypeParameters().get(parameterIndex);
			LightweightTypeReference result = getDeclaredUpperBound(typeParameter, visiting);
			if (result != null)
				return result;
		}
		return getObjectReference();
	}

	protected LightweightTypeReference getObjectReference() {
		return getOwner().newReferenceToObject();
	}

	/* @Nullable */
	protected LightweightTypeReference getDeclaredUpperBound(JvmTypeParameter typeParameter, ConstraintVisitingInfo visiting) {
		if (!typeParameter.getConstraints().isEmpty()) {
			JvmTypeConstraint constraint = typeParameter.getConstraints().get(0);
			if (constraint instanceof JvmUpperBound) {
				LightweightTypeReference reference = getOwner().toLightweightTypeReference(constraint.getTypeReference());
				if (visiting.getCurrentDeclarator() != reference.getType()) {
					return visitTypeArgument(reference, visiting);
				}
				WildcardTypeReference result = getOwner().newWildcardTypeReference();
				result.addUpperBound(getObjectReference());
				return result;
			}
		}
		return null;
	}
	
	@Override
	public LightweightTypeReference substitute(LightweightTypeReference original) {
		if (original instanceof ArrayTypeReference) {
			LightweightTypeReference componentType = original.getComponentType();
			if (componentType instanceof UnboundTypeReference) {
				LightweightTypeReference substitutedComponentType = substitute(componentType);
				return getOwner().newArrayTypeReference(substitutedComponentType);
			}
		}
		if (original instanceof UnboundTypeReference) {
			ConstraintVisitingInfo visitingInfo = createVisiting();
			JvmTypeParameter typeParameter = ((UnboundTypeReference) original).getTypeParameter();
			JvmTypeParameterDeclarator declarator = typeParameter.getDeclarator();
			visitingInfo.pushInfo(declarator, declarator.getTypeParameters().indexOf(typeParameter));
			LightweightTypeReference result = visitTypeArgument(original, visitingInfo);
			return result;
		} else {
			LightweightTypeReference result = original.accept(this, createVisiting());
			return result;
		}
	}
	
	@Override
	protected ConstraintVisitingInfo createVisiting() {
		return new ConstraintVisitingInfo();
	}
	
	protected ConstraintVisitingInfo createVisiting(JvmTypeParameter initialValue) {
		ConstraintVisitingInfo result = createVisiting();
		result.tryVisit(initialValue);
		return result;
	}
}
