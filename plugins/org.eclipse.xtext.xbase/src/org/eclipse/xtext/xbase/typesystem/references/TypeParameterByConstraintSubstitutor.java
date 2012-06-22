/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.references;

import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator;
import org.eclipse.xtext.common.types.JvmUpperBound;
import org.eclipse.xtext.xbase.typesystem.util.VarianceInfo;

import com.google.common.collect.Sets;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString
 */
@NonNullByDefault
public class TypeParameterByConstraintSubstitutor extends TypeParameterSubstitutor {

	public TypeParameterByConstraintSubstitutor(Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> typeParameterMapping,
			TypeReferenceOwner owner) {
		super(typeParameterMapping, owner);
	}
	
	@Override
	public LightweightTypeReference doVisitParameterizedTypeReference(ParameterizedTypeReference reference, Set<JvmTypeParameter> visiting) {
		if (reference.isResolved() && reference.isOwnedBy(getOwner()))
			return reference;
		JvmType type = reference.getType();
		if (type instanceof JvmTypeParameter) {
			if (!visiting.add((JvmTypeParameter) type)) {
				return reference;
			}
			try {
				LightweightMergedBoundTypeArgument boundTypeArgument = getTypeParameterMapping().get(type);
				if (boundTypeArgument != null && boundTypeArgument.getTypeReference() != reference) {
					LightweightTypeReference result = boundTypeArgument.getTypeReference().accept(this, visiting);
					if (boundTypeArgument.getVariance() == VarianceInfo.OUT) {
						WildcardTypeReference wildcard = new WildcardTypeReference(getOwner());
						wildcard.addUpperBound(result);
						result = wildcard;
					} else if (boundTypeArgument.getVariance() == VarianceInfo.IN) {
						WildcardTypeReference wildcard = new WildcardTypeReference(getOwner());
						JvmType objectType = getOwner().getServices().getTypeReferences().findDeclaredType(Object.class, type);
						wildcard.addUpperBound(new ParameterizedTypeReference(getOwner(), objectType));
						wildcard.setLowerBound(result);
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
				visiting.remove(type);
			}
		}
		ParameterizedTypeReference result = new ParameterizedTypeReference(getOwner(), type);
		for(int i = 0; i < reference.getTypeArguments().size(); i++) {
			LightweightTypeReference argument = reference.getTypeArguments().get(i);
			LightweightTypeReference visitedArgument = argument.accept(this, visiting);
			if (visitedArgument.getType() instanceof JvmTypeParameter && type instanceof JvmTypeParameterDeclarator) {
				visitedArgument = getDeclaredUpperBound((JvmTypeParameterDeclarator) type, i, visiting);
			} else if (visitedArgument instanceof WildcardTypeReference && !visitedArgument.isResolved()) {
				visitedArgument = getDeclaredUpperBound((JvmTypeParameterDeclarator) type, i, visiting);
			}
			result.addTypeArgument(visitedArgument);
		}
		return result;
	}
	
	@Nullable
	protected LightweightTypeReference getUnmappedSubstitute(ParameterizedTypeReference reference, JvmTypeParameter type, Set<JvmTypeParameter> visiting) {
		ConstraintAwareTypeArgumentCollector collector = new ConstraintAwareTypeArgumentCollector(getOwner());
		LightweightTraversalData data = new LightweightTraversalData();
		data.getTypeParameterMapping().putAll(getTypeParameterMapping());
		reference.accept(collector, data);
		LightweightMergedBoundTypeArgument boundTypeArgument = data.getTypeParameterMapping().get(type);
		if (boundTypeArgument != null && boundTypeArgument.getTypeReference() != reference) {
			return boundTypeArgument.getTypeReference().accept(this, visiting);
		}
		if (boundTypeArgument != null)
			return boundTypeArgument.getTypeReference();
		return null;
	}
	
	protected LightweightTypeReference getDeclaredUpperBound(JvmTypeParameterDeclarator type, int parameterIndex, Set<JvmTypeParameter> visiting) {
		if (type.getTypeParameters().size() > parameterIndex) {
			JvmTypeParameter typeParameter = type.getTypeParameters().get(parameterIndex);
			if (!typeParameter.getConstraints().isEmpty()) {
				JvmTypeConstraint constraint = typeParameter.getConstraints().get(0);
				if (constraint instanceof JvmUpperBound) {
					LightweightTypeReference reference = new OwnedConverter(getOwner()).toLightweightReference(constraint.getTypeReference());
					return reference.accept(this, visiting);
				}
			}
		}
		
		JvmType objectType = getOwner().getServices().getTypeReferences().findDeclaredType(Object.class, type);
		return new ParameterizedTypeReference(getOwner(), objectType);
	}
	
	@Override
	public LightweightTypeReference substitute(LightweightTypeReference original) {
		LightweightTypeReference result = original.accept(this, Sets.<JvmTypeParameter>newHashSet());
		return result;
	}
}
