/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.util;

import java.util.List;
import java.util.Map;

import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.UnboundTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString
 */
public abstract class TypeParameterByUnboundSubstitutor extends CustomTypeParameterSubstitutor {

	public TypeParameterByUnboundSubstitutor(Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> typeParameterMapping,
			ITypeReferenceOwner owner) {
		super(typeParameterMapping, owner);
	}
	
	@Override
	public LightweightTypeReference doVisitUnboundTypeReference(UnboundTypeReference reference, ConstraintVisitingInfo param) {
		return copy(reference);
	}
	
	@Override
	protected LightweightTypeReference getUnmappedSubstitute(ParameterizedTypeReference reference, JvmTypeParameter type, ConstraintVisitingInfo visiting) {
		List<JvmTypeParameter> declaredTypeParameters = getOwner().getDeclaredTypeParameters();
		if (declaredTypeParameters.contains(type)) {
			return reference.copyInto(getOwner());
		}
		LightweightTypeReference result = createUnboundTypeReference(type);
		if (result == null) {
			result = new TypeParameterByConstraintSubstitutor(getTypeParameterMapping(), getOwner()).substitute(type);
		}
		return result;
	}
	
	/* @Nullable */
	protected abstract UnboundTypeReference createUnboundTypeReference(JvmTypeParameter type);
	
}
