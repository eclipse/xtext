/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.util;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.common.types.JvmComponentType;
import org.eclipse.xtext.common.types.JvmCompoundTypeReference;
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmUpperBound;
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.access.impl.ClassURIHelper;

import com.google.common.collect.Lists;
import com.google.inject.Inject;

/*
 * This class should not rely on field injection since it is intended to be used
 * by JvmDeclaredTypeImplCustom#getAll* 
 */
/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class RawTypeHelper extends AbstractTypeReferenceVisitorWithParameter.InheritanceAware<Resource, List<JvmType>> implements IRawTypeHelper {

	private final TypesFactory factory;

	@Inject
	public RawTypeHelper(TypesFactory factory) {
		this.factory = factory;
	}
	
	public List<JvmType> getAllRawTypes(JvmTypeReference reference, Resource resource) {
		List<JvmType> result = visit(reference, resource);
		return result;
	}
	
	@Override
	public List<JvmType> doVisitTypeReference(JvmTypeReference reference, Resource resource) {
		return Collections.emptyList();
	}
	
	@Override
	protected List<JvmType> handleNullReference(Resource parameter) {
		return Collections.emptyList();
	}
	
	@Override
	public List<JvmType> doVisitCompoundTypeReference(JvmCompoundTypeReference reference, Resource resource) {
		List<JvmTypeReference> references = reference.getReferences();
		if (references.isEmpty())
			return Collections.emptyList();
		List<JvmType> result = Lists.newArrayList();
		for(JvmTypeReference contained: references) {
			result.addAll(visit(contained, resource));
		}
		return result;
	}
	
	@Override
	public List<JvmType> doVisitGenericArrayTypeReference(JvmGenericArrayTypeReference reference, Resource resource) {
		JvmTypeReference componentType = reference.getComponentType();
		List<JvmType> rawComponentTypes = visit(componentType, resource);
		List<JvmType> result = Lists.newArrayListWithCapacity(rawComponentTypes.size());
		for(JvmType rawComponentType: rawComponentTypes) {
			if (!rawComponentType.eIsProxy() && rawComponentType instanceof JvmComponentType) {
				result.add(((JvmComponentType) rawComponentType).getArrayType());
			}
		}
		return result;
	}
	
	@Override
	public List<JvmType> doVisitParameterizedTypeReference(JvmParameterizedTypeReference reference, Resource resource) {
		JvmType type = reference.getType();
		if (type != null && !type.eIsProxy()) {
			if (type instanceof JvmTypeParameter) {
				return getRawTypesFromConstraints(((JvmTypeParameter) type).getConstraints(), resource);
			}
			return Collections.singletonList(type);
		}
		return Collections.emptyList();
	}
	
	@Override
	public List<JvmType> doVisitWildcardTypeReference(JvmWildcardTypeReference reference, Resource resource) {
		return getRawTypesFromConstraints(reference.getConstraints(), resource);
	}

	protected List<JvmType> getRawTypesFromConstraints(List<JvmTypeConstraint> constraints, Resource resource) {
		if (!constraints.isEmpty()) {
			List<JvmType> result = Lists.newArrayList();
			for(JvmTypeConstraint constraint: constraints) {
				if (constraint instanceof JvmUpperBound) {
					result.addAll(visit(constraint.getTypeReference(), resource));
				}
			}
			if (!result.isEmpty())
				return result;
		}
		return createObjectReference(resource);
	}

	protected List<JvmType> createObjectReference(Resource resource) {
		if (resource != null) {
			// no upper bound found - seems to be an invalid - assume object as upper bound
			URI objectURI = new ClassURIHelper().getFullURI(Object.class);
			JvmType objectType = factory.createJvmGenericType();
			((InternalEObject)objectType).eSetProxyURI(objectURI);
			objectType = (JvmType) EcoreUtil.resolve(objectType, resource);
			return Collections.singletonList(objectType);
		}
		return Collections.emptyList();
	}
}
