/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.util;

import java.util.Map;
import java.util.Set;

import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator;
import org.eclipse.xtext.common.types.JvmUpperBound;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTraversalData;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.OwnedConverter;
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.UnboundTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.WildcardTypeReference;

import com.google.common.collect.Sets;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString
 */
public class TypeParameterByConstraintSubstitutor extends CustomTypeParameterSubstitutor {

	private final boolean ignoreDeclaredTypeParameters;

	public TypeParameterByConstraintSubstitutor(Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> typeParameterMapping,
			ITypeReferenceOwner owner) {
		this(typeParameterMapping, owner, false);
	}
	
	public TypeParameterByConstraintSubstitutor(Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> typeParameterMapping,
			ITypeReferenceOwner owner, boolean ignoreDeclaredTypeParameters) {
		super(typeParameterMapping, owner);
		this.ignoreDeclaredTypeParameters = ignoreDeclaredTypeParameters;
	}
	
	@Override
	protected LightweightTypeReference doVisitUnboundTypeReference(UnboundTypeReference reference, ConstraintVisitingInfo visiting) {
		JvmTypeParameter typeParameter = reference.getTypeParameter();
		if (!visiting.tryVisit(typeParameter)) {
			LightweightTypeReference mappedReference = getDeclaredUpperBound(typeParameter, visiting);
			getTypeParameterMapping().put(typeParameter, new LightweightMergedBoundTypeArgument(mappedReference, VarianceInfo.INVARIANT));
			if (mappedReference != null)
				return mappedReference;
			return getObjectReference();
		}
		try {
			LightweightMergedBoundTypeArgument boundTypeArgument = getTypeParameterMapping().get(typeParameter);
			if (boundTypeArgument != null && boundTypeArgument.getTypeReference() != reference) {
				LightweightTypeReference result = boundTypeArgument.getTypeReference().accept(this, visiting);
				return result;
			} else {
				JvmTypeParameterDeclarator currentDeclarator = visiting.getCurrentDeclarator();
				LightweightTypeReference mappedReference = currentDeclarator != null 
						? getDeclaredUpperBound(currentDeclarator, visiting.getCurrentIndex(), visiting)
						: getDeclaredUpperBound(typeParameter, visiting);
				if (mappedReference == null)
					mappedReference = getObjectReference();
				getTypeParameterMapping().put(typeParameter, new LightweightMergedBoundTypeArgument(mappedReference, VarianceInfo.INVARIANT));
				return mappedReference;
			}
		} finally {
			visiting.didVisit(typeParameter);
		}
	}
	
	@Override
	protected LightweightTypeReference visitTypeArgument(LightweightTypeReference reference, ConstraintVisitingInfo visiting, boolean lowerBound) {
		if (lowerBound && (reference instanceof ParameterizedTypeReference)) {
			if (reference.getType() instanceof JvmTypeParameter) {
				JvmTypeParameter typeParameter = (JvmTypeParameter) reference.getType();
				// don't recurse into lower bounds of wildcards, e.g. constraint bound of 
				// C extends Comparable<? super C> 
				// is not 
				// Comparable<? super Object> 
				// but 
				// Comparable<?>
				if (!visiting.canVisit(typeParameter)) {
					WildcardTypeReference result = new WildcardTypeReference(reference.getOwner());
					JvmType objectType = getOwner().getServices().getTypeReferences().findDeclaredType(Object.class, getOwner().getContextResourceSet());
					result.addUpperBound(new ParameterizedTypeReference(getOwner(), objectType));
					return result;
				}
			}
		}
		return super.visitTypeArgument(reference, visiting, lowerBound);
	}
	
	@Override
	/* @Nullable */
	protected LightweightTypeReference getDeclaredUpperBound(JvmTypeParameter typeParameter, ConstraintVisitingInfo visiting) {
		if (!typeParameter.getConstraints().isEmpty() &&
					((DeclaredConstraintVisitingInfo)visiting).tryVisitDeclaredUpperBoundsOf(typeParameter)) {
			try {
				JvmTypeConstraint constraint = typeParameter.getConstraints().get(0);
				if (constraint instanceof JvmUpperBound) {
					LightweightTypeReference reference = new OwnedConverter(getOwner()).toLightweightReference(constraint.getTypeReference());
					if (visiting.getCurrentDeclarator() != reference.getType()) {
						return reference.accept(this, visiting);
					}
					WildcardTypeReference result = new WildcardTypeReference(getOwner());
					result.addUpperBound(getObjectReference());
					return result;
				}
			} finally {
				((DeclaredConstraintVisitingInfo)visiting).didVisitDeclaredUpperBoundsOf(typeParameter);
			}
		}
		return null;
	}
	
	@Override
	protected DeclaredConstraintVisitingInfo createVisiting() {
		return new DeclaredConstraintVisitingInfo();
	}
	
	public LightweightTypeReference substitute(JvmTypeParameter original) {
		return substitute(new ParameterizedTypeReference(getOwner(), original));
	}
	
	@Override
	/* @Nullable */
	protected LightweightTypeReference getUnmappedSubstitute(ParameterizedTypeReference reference, JvmTypeParameter type, ConstraintVisitingInfo visiting) {
		if (!ignoreDeclaredTypeParameters) {
			if (isDeclaredTypeParameter(type)) {
				return reference;
			}
		}
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
	
	protected static class DeclaredConstraintVisitingInfo extends ConstraintVisitingInfo {
		private Set<JvmTypeParameter> upperBounds = Sets.newHashSetWithExpectedSize(2);
		
		public boolean tryVisitDeclaredUpperBoundsOf(JvmTypeParameter typeParameter) {
			return upperBounds.add(typeParameter);
		}
		
		public void didVisitDeclaredUpperBoundsOf(JvmTypeParameter typeParameter) {
			upperBounds.remove(typeParameter);
		}
	}
}
