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

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ArrayTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.CompoundTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTraversalData;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.OwnedConverter;
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.TypeReferenceVisitorWithParameterAndResult;
import org.eclipse.xtext.xbase.typesystem.references.WildcardTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString
 * TODO implement as member function of ParameterizedTypeReference
 */
@NonNullByDefault
public class DeclaratorTypeArgumentCollector extends TypeReferenceVisitorWithParameterAndResult<LightweightTraversalData, Boolean> {
	
	@Override
	protected Boolean doVisitTypeReference(LightweightTypeReference reference, LightweightTraversalData data) {
		return Boolean.FALSE;
	}

	@Override
	public Boolean doVisitCompoundTypeReference(CompoundTypeReference reference, LightweightTraversalData data) {
		// TODO error message, cannot extend compound reference
		boolean result = true;
		for(LightweightTypeReference component: reference.getMultiTypeComponents()) {
			Boolean componentsDone = component.accept(this, data);
			result &= componentsDone != null && componentsDone.booleanValue();
		}
		return result;
	}

	@Override
	public Boolean doVisitArrayTypeReference(ArrayTypeReference reference, LightweightTraversalData data) {
		// TODO error message, cannot extend array type
		return Boolean.FALSE;
	}
	
	@Override
	public Boolean doVisitWildcardTypeReference(WildcardTypeReference reference, LightweightTraversalData data) {
		// TODO error message, cannot extend wildcard type
		return Boolean.FALSE;
	}

	@Override
	public Boolean doVisitParameterizedTypeReference(ParameterizedTypeReference reference, LightweightTraversalData data) {
		JvmType type = reference.getType();
		// TODO improve handling of redundant super types where a better path to the supertype exists
		/*
		 * e.g. MyList extends AbstractList implements List<String> {}
		 * the implements clause seems to be redundant but provides more reliable information
		 */
		if (!type.eIsProxy() && data.getVisited().add(type)) {
			return doVisitParameterizedTypeReference(reference, type, data);
		}
		return Boolean.FALSE;
	}

	protected Boolean doVisitParameterizedTypeReference(ParameterizedTypeReference reference, JvmType type,
			LightweightTraversalData data) {
		// TODO check constraints, add validation messages if necessary
		if (type instanceof JvmTypeParameterDeclarator) {
			List<JvmTypeParameter> typeParameters = ((JvmTypeParameterDeclarator) type).getTypeParameters();
			List<LightweightTypeReference> typeArguments = reference.getTypeArguments();
			int size = Math.min(typeArguments.size(), typeParameters.size());
			for (int i = 0; i <  size; i++) {
				JvmTypeParameter param = typeParameters.get(i);
				LightweightTypeReference argument = typeArguments.get(i);
				if (param != null && argument != null) {
					data.getTypeParameterMapping().put(param, new LightweightMergedBoundTypeArgument(argument, VarianceInfo.INVARIANT));
				}
			}
		}
		if (type instanceof JvmDeclaredType) {
			ITypeReferenceOwner owner = reference.getOwner();
			OwnedConverter converter = new OwnedConverter(owner);
			List<JvmTypeReference> superTypes = ((JvmDeclaredType) type).getSuperTypes();
			for(JvmTypeReference superType: superTypes) {
				LightweightTypeReference lightweightSuperType = converter.toLightweightReference(superType);
				Boolean recursion = lightweightSuperType.accept(this, data);
				if (recursion != null && recursion.booleanValue()) {
					return Boolean.TRUE;
				}
			}
		} else if (type instanceof JvmTypeParameter) {
			ITypeReferenceOwner owner = reference.getOwner();
			OwnedConverter converter = new OwnedConverter(owner);
			List<JvmTypeConstraint> constraints = ((JvmTypeParameter) type).getConstraints();
			for(JvmTypeConstraint constraint: constraints) {
				JvmTypeReference constraintReference = constraint.getTypeReference();
				LightweightTypeReference lightweightSuperType = converter.toLightweightReference(constraintReference);
				Boolean recursion = lightweightSuperType.accept(this, data);
				if (recursion != null && recursion.booleanValue()) {
					return Boolean.TRUE;
				}
			}
		}
		return Boolean.FALSE;
	}
	
	public Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> getTypeParameterMapping(LightweightTypeReference reference) {
		LightweightTraversalData data = new LightweightTraversalData();
		reference.accept(this, data);
		return data.getTypeParameterMapping();
	}
	
}