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

import org.eclipse.xtext.common.types.JvmCompoundTypeReference;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;
import org.eclipse.xtext.common.types.util.AbstractTypeReferenceVisitorWithParameter;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString
 */
public class DeclaratorTypeArgumentCollector extends AbstractTypeReferenceVisitorWithParameter.InheritanceAware<TraversalData, Boolean> {
	
	@Override
	protected Boolean handleNullReference(TraversalData data) {
		return Boolean.TRUE;
	}

	@Override
	public Boolean doVisitTypeReference(JvmTypeReference reference, TraversalData data) {
		return Boolean.FALSE;
	}

	@Override
	public Boolean doVisitCompoundTypeReference(JvmCompoundTypeReference reference, TraversalData data) {
		// TODO error message, cannot extend compound reference
		for(JvmTypeReference component: reference.getReferences()) {
			if (visit(component, data))
				return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}

	@Override
	public Boolean doVisitGenericArrayTypeReference(JvmGenericArrayTypeReference reference, TraversalData data) {
		// TODO error message, cannot extend array type
		return Boolean.FALSE;
	}
	
	@Override
	public Boolean doVisitWildcardTypeReference(JvmWildcardTypeReference reference, TraversalData data) {
		// TODO error message, cannot extend wildcard type
		return Boolean.FALSE;
	}

	@Override
	public Boolean doVisitParameterizedTypeReference(JvmParameterizedTypeReference reference, TraversalData data) {
		JvmType type = reference.getType();
		// TODO improve handling of redundant super types where a better path to the supertype exists
		/*
		 * e.g. MyList extends AbstractList implements List<String> {}
		 * the implements clause seems to be redundant but provides more reliable information
		 */
		if (type != null && !type.eIsProxy() && data.getVisited().add(type)) {
			return doVisitParameterizedTypeReference(reference, type, data);
		}
		return Boolean.FALSE;
	}

	protected Boolean doVisitParameterizedTypeReference(JvmParameterizedTypeReference reference, JvmType type,
			TraversalData data) {
		// TODO check constraints, add validation messages if necessary
		if (type instanceof JvmTypeParameterDeclarator) {
			List<JvmTypeParameter> typeParameters = ((JvmTypeParameterDeclarator) type).getTypeParameters();
			List<JvmTypeReference> typeArguments = reference.getArguments();
			int size = Math.min(typeArguments.size(), typeParameters.size());
			for (int i = 0; i <  size; i++) {
				JvmTypeParameter param = typeParameters.get(i);
				JvmTypeReference argument = typeArguments.get(i);
				if (param != null && argument != null) {
					data.getTypeParameterMapping().put(param, new MergedBoundTypeArgument(argument, VarianceInfo.INVARIANT));
				}
			}
		}
		if (type instanceof JvmDeclaredType) {
			List<JvmTypeReference> superTypes = ((JvmDeclaredType) type).getSuperTypes();
			for(JvmTypeReference superType: superTypes) {
				if (visit(superType, data)) {
					return Boolean.TRUE;
				}
			}
		}
		return Boolean.FALSE;
	}
	
	public Map<JvmTypeParameter, MergedBoundTypeArgument> getTypeParameterMapping(JvmTypeReference reference) {
		TraversalData data = new TraversalData();
		visit(reference, data);
		return data.getTypeParameterMapping();
	}
	
}