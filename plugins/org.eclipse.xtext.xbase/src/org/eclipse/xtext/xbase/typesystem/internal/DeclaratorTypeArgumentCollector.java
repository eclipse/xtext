/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.xtext.common.types.JvmCompoundTypeReference;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;
import org.eclipse.xtext.common.types.util.AbstractTypeReferenceVisitor;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString
 */
public class DeclaratorTypeArgumentCollector extends AbstractTypeReferenceVisitor.InheritanceAware<Boolean> {
	
	private final Set<JvmType> visited = Sets.newHashSet();
	private final Map<JvmTypeParameter, JvmTypeReference> typeParameterMapping = Maps.newHashMap();

	@Override
	protected Boolean handleNullReference() {
		return Boolean.TRUE;
	}

	@Override
	public Boolean doVisitTypeReference(JvmTypeReference reference) {
		return Boolean.FALSE;
	}

	@Override
	public Boolean doVisitCompoundTypeReference(JvmCompoundTypeReference reference) {
		// TODO error message, cannot extend compound reference
		for(JvmTypeReference component: reference.getReferences()) {
			if (visit(component))
				return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}

	@Override
	public Boolean doVisitGenericArrayTypeReference(JvmGenericArrayTypeReference reference) {
		// TODO error message, cannot extend array type
		return Boolean.FALSE;
	}
	
	@Override
	public Boolean doVisitWildcardTypeReference(JvmWildcardTypeReference reference) {
		// TODO error message, cannot extend wildcard type
		return Boolean.FALSE;
	}

	@Override
	public Boolean doVisitParameterizedTypeReference(JvmParameterizedTypeReference reference) {
		JvmType type = reference.getType();
		// TODO improve handling of redundant super types where a better path to the supertype exists
		/*
		 * e.g. MyList extends AbstractList implements List<String> {}
		 * the implements clause seems to be redundant but provides more reliable information
		 */
		if (type != null && !type.eIsProxy() && visited.add(type)) {
			// TODO check constraints, add validation messages if necessary
			if (type instanceof JvmTypeParameterDeclarator) {
				List<JvmTypeParameter> typeParameters = ((JvmTypeParameterDeclarator) type).getTypeParameters();
				List<JvmTypeReference> typeArguments = reference.getArguments();
				int size = Math.min(typeArguments.size(), typeParameters.size());
				for (int i = 0; i <  size; i++) {
					JvmTypeParameter param = typeParameters.get(i);
					JvmTypeReference argument = typeArguments.get(i);
					if (param != null && argument != null) {
						typeParameterMapping.put(param, argument);
					}
				}
			}
			if (type instanceof JvmDeclaredType) {
				List<JvmTypeReference> superTypes = ((JvmDeclaredType) type).getSuperTypes();
				for(JvmTypeReference superType: superTypes) {
					if (visit(superType)) {
						return Boolean.TRUE;
					}
				}
			}
		}
		return Boolean.FALSE;
	}
	
	public Map<JvmTypeParameter, JvmTypeReference> getTypeParameterMapping() {
		return typeParameterMapping;
	}
}