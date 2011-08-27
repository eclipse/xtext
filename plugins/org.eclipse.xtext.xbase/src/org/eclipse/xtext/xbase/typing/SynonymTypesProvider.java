/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typing;

import static com.google.common.collect.Iterables.*;
import static java.util.Collections.*;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmArrayType;
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmUpperBound;
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;
import org.eclipse.xtext.common.types.util.Primitives;
import org.eclipse.xtext.common.types.util.SuperTypeCollector;
import org.eclipse.xtext.common.types.util.TypeReferences;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class SynonymTypesProvider {
	
	@Inject
	private Primitives primitives;
	
	@Inject
	private TypeReferences typeRefs;
	
	@Inject
	private SuperTypeCollector superTypeCollector;

	public Iterable<JvmTypeReference> getSynonymTypes(JvmTypeReference type) {
		if (type == null || typeRefs.is(type, Void.class) || typeRefs.is(type,Void.TYPE)) {
			return emptySet();
		} else if (primitives.isPrimitive(type)) {
			return singleton(primitives.asWrapperTypeIfPrimitive(type));
		} else if (primitives.isWrapperType(type)) {
			return singleton(primitives.asPrimitiveIfWrapperType(type));
		} else if (typeRefs.isArray(type)) {
			if (type instanceof JvmGenericArrayTypeReference) {
				JvmTypeReference componentType = ((JvmGenericArrayTypeReference) type).getComponentType();
				JvmTypeReference typeArg = primitives.asWrapperTypeIfPrimitive(componentType);
				JvmTypeReference iterable = typeRefs.getTypeForName(List.class, findContext(type.getType()), typeArg);
				return singleton(iterable);
			} else {
				JvmArrayType array = (JvmArrayType) type.getType();
				JvmTypeReference typeArg = primitives.asWrapperTypeIfPrimitive(typeRefs.createTypeRef(array.getComponentType()));
				JvmTypeReference iterable = typeRefs.getTypeForName(List.class, findContext(array), typeArg);
				return singleton(iterable);
			}
		} else if (isList(type)) {
			JvmTypeReference componentType = null;
			if (type instanceof JvmParameterizedTypeReference) {
				EList<JvmTypeReference> arguments = ((JvmParameterizedTypeReference) type).getArguments();
				if (arguments.size()==1) {
					final JvmTypeReference jvmTypeReference = arguments.get(0);
					componentType = jvmTypeReference;
					if (componentType instanceof JvmWildcardTypeReference) {
						EList<JvmTypeConstraint> list = ((JvmWildcardTypeReference) componentType).getConstraints();
						componentType = typeRefs.getTypeForName(Object.class, findContext(type.getType()));
						for (JvmTypeConstraint constraint : list) {
							if (constraint instanceof JvmUpperBound) {
								componentType = constraint.getTypeReference();
							}
						}
					}
				}
			}
			if (componentType == null)
				componentType = typeRefs.getTypeForName(Object.class, type.getType());
			JvmTypeReference result = typeRefs.createArrayType(componentType);
			return singleton(result);
		}
		return emptySet();
	}

	protected boolean isList(JvmTypeReference type) {
		return typeRefs.is(type, List.class) || typeRefs.is(type, Iterable.class) || typeRefs.is(type, Collection.class);
	}

	protected EObject findContext(JvmType type) {
		return type;
	}

	public boolean hasSynonymTypes(JvmTypeReference toBeConverted) {
		final Iterable<JvmTypeReference> synonymTypes = getSynonymTypes(toBeConverted);
		if (synonymTypes instanceof Collection)
			return !((Collection<?>) synonymTypes).isEmpty();
		return !isEmpty(synonymTypes);
	}

	public JvmTypeReference findCompatibleSynonymType(JvmTypeReference toBeConverted, JvmType toBeCompatible) {
		if (isAssignable(toBeConverted, toBeCompatible)) 
			return toBeConverted;
		
		Iterable<JvmTypeReference> types = getSynonymTypes(toBeConverted);
		for (JvmTypeReference synonym : types) {
			if (isAssignable(synonym, toBeCompatible))
				return synonym;
		}
		return null;
	}

	protected boolean isAssignable(JvmTypeReference toBeConverted, JvmType toBeCompatible) {
		if (toBeConverted == null)
			return false;
		if (toBeConverted.getType() == toBeCompatible)
			return true;
		Set<JvmType> rawTypes = superTypeCollector.collectSuperTypesAsRawTypes(toBeConverted);
		for (JvmType jvmType : rawTypes) {
			if (jvmType == toBeCompatible)
				return true;
		}
		return false;
	}
	
}
