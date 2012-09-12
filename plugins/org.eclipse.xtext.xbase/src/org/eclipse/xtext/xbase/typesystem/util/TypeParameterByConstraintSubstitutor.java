/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.util;

import java.util.Map;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTraversalData;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.UnboundTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString
 */
@NonNullByDefault
public class TypeParameterByConstraintSubstitutor extends CustomTypeParameterSubstitutor {

	public TypeParameterByConstraintSubstitutor(Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> typeParameterMapping,
			ITypeReferenceOwner owner) {
		super(typeParameterMapping, owner);
	}
	
	@Override
	protected LightweightTypeReference doVisitUnboundTypeReference(UnboundTypeReference reference, ConstraintVisitingInfo visiting) {
		JvmTypeParameter typeParameter = reference.getTypeParameter();
		if (!visiting.tryVisit(typeParameter)) {
			LightweightTypeReference mappedReference = getDeclaredUpperBound(typeParameter, visiting);
			getTypeParameterMapping().put(typeParameter, new LightweightMergedBoundTypeArgument(mappedReference, VarianceInfo.INVARIANT));
			if (mappedReference != null)
				return mappedReference;
			return getObjectReference(typeParameter);
		}
		try {
			LightweightMergedBoundTypeArgument boundTypeArgument = getTypeParameterMapping().get(typeParameter);
			if (boundTypeArgument != null && boundTypeArgument.getTypeReference() != reference) {
				LightweightTypeReference result = boundTypeArgument.getTypeReference().accept(this, visiting);
				return result;
			} else {
				LightweightTypeReference mappedReference = getDeclaredUpperBound(visiting.getCurrentDeclarator(), visiting.getCurrentIndex(), visiting);
				getTypeParameterMapping().put(typeParameter, new LightweightMergedBoundTypeArgument(mappedReference, VarianceInfo.INVARIANT));
				return mappedReference;
			}
		} finally {
			visiting.didVisit(typeParameter);
		}
	}
	
	@Override
	@Nullable
	protected LightweightTypeReference getUnmappedSubstitute(ParameterizedTypeReference reference, JvmTypeParameter type, ConstraintVisitingInfo visiting) {
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
	
}
