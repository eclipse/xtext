/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.util;

import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.common.types.JvmCompoundTypeReference;
import org.eclipse.xtext.common.types.JvmDelegateTypeReference;
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmSynonymTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmUpperBound;
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.access.impl.URIHelperConstants;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;

import com.google.common.collect.Sets;
import com.google.inject.Inject;

/*
 * This class should not rely on field injection since it is intended to be used
 * by JvmDeclaredTypeImplCustom#getAll* 
 */
/**
 * Provides the raw type for a given type reference.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class RawTypeReferenceComputer extends
		AbstractTypeReferenceVisitorWithParameter.InheritanceAware<Pair<Resource, Set<JvmType>>, JvmTypeReference> {

	private final TypesFactory factory;

	@Inject
	public RawTypeReferenceComputer(TypesFactory factory) {
		this.factory = factory;
	}

	public JvmTypeReference getRawTypeReference(JvmTypeReference reference, Resource resource) {
		JvmTypeReference result = visit(reference, Tuples.<Resource, Set<JvmType>>create(resource, Sets.<JvmType>newHashSet()));
		return result;
	}

	@Override
	public JvmTypeReference doVisitTypeReference(JvmTypeReference reference, Pair<Resource, Set<JvmType>> context) {
		return reference;
	}

	@Override
	protected JvmTypeReference handleNullReference(Pair<Resource, Set<JvmType>> parameter) {
		return null;
	}

	@Override
	public JvmTypeReference doVisitCompoundTypeReference(JvmCompoundTypeReference reference, Pair<Resource, Set<JvmType>> context) {
		JvmCompoundTypeReference result = null;
		List<JvmTypeReference> components = reference.getReferences();
		int recent = -1;
		for (int i = 0; i < components.size(); i++) {
			JvmTypeReference component = components.get(i);
			JvmTypeReference rawType = visit(component, context);
			if (rawType != null && component != rawType) {
				if (result == null) {
					result = (JvmCompoundTypeReference) EcoreUtil.create(reference.eClass());
				}
				for (int j = recent + 1; j < i; j++) {
					result.getReferences().add(components.get(j));
				}
				result.getReferences().add(rawType);
				recent = i;
			}
		}
		if (result != null)
			return result;
		return reference;
	}

	@Override
	public JvmTypeReference doVisitDelegateTypeReference(JvmDelegateTypeReference reference, Pair<Resource, Set<JvmType>> parameter) {
		JvmTypeReference result = super.doVisitDelegateTypeReference(reference, parameter);
		if (result == reference.getDelegate())
			return reference;
		return result;
	}

	@Override
	public JvmTypeReference doVisitGenericArrayTypeReference(JvmGenericArrayTypeReference reference, Pair<Resource, Set<JvmType>> context) {
		JvmTypeReference componentType = reference.getComponentType();
		JvmTypeReference rawComponentType = visit(componentType, context);
		if (componentType != rawComponentType) {
			JvmGenericArrayTypeReference result = factory.createJvmGenericArrayTypeReference();
			result.setComponentType(rawComponentType);
			return result;
		}
		return reference;
	}

	@Override
	public JvmTypeReference doVisitParameterizedTypeReference(JvmParameterizedTypeReference reference, Pair<Resource, Set<JvmType>> context) {
		JvmType type = reference.getType();
		if (type != null && !type.eIsProxy()) {
			if (type instanceof JvmTypeParameterDeclarator) {
				if (!((JvmTypeParameterDeclarator) type).getTypeParameters().isEmpty()) {
					JvmParameterizedTypeReference result = factory.createJvmParameterizedTypeReference();
					result.setType(type);
					return result;
				}
			} else if (type instanceof JvmTypeParameter) {
				Set<JvmType> recursionGuard = context.getSecond();
				if (recursionGuard.add(type)) {
					return getRawTypeFromConstraints(((JvmTypeParameter) type).getConstraints(), context);
				} else {
					return createObjectReference(context.getFirst());
				}
			}
		}
		return reference;
	}

	@Override
	public JvmTypeReference doVisitWildcardTypeReference(JvmWildcardTypeReference reference, Pair<Resource, Set<JvmType>> context) {
		return getRawTypeFromConstraints(reference.getConstraints(), context);
	}

	protected JvmTypeReference getRawTypeFromConstraints(List<JvmTypeConstraint> constraints, Pair<Resource, Set<JvmType>> context) {
		if (!constraints.isEmpty()) {
			JvmTypeReference result = null;
			for (JvmTypeConstraint constraint : constraints) {
				if (constraint instanceof JvmUpperBound) {
					JvmTypeReference rawType = visit(constraint.getTypeReference(), context);
					if (result == null) {
						if (rawType != null && rawType.eContainer() != null) {
							JvmDelegateTypeReference delegate = factory.createJvmDelegateTypeReference();
							delegate.setDelegate(rawType);
							rawType = delegate;
						}
						result = rawType;
					} else if (!(result instanceof JvmSynonymTypeReference)) {
						JvmSynonymTypeReference synonym = factory.createJvmSynonymTypeReference();
						synonym.getReferences().add(result);
						if (rawType.eContainer() != null) {
							JvmDelegateTypeReference delegate = factory.createJvmDelegateTypeReference();
							delegate.setDelegate(rawType);
							rawType = delegate;
						}
						synonym.getReferences().add(rawType);
						result = synonym;
					} else {
						JvmSynonymTypeReference synonym = (JvmSynonymTypeReference) result;
						if (rawType.eContainer() != null) {
							JvmDelegateTypeReference delegate = factory.createJvmDelegateTypeReference();
							delegate.setDelegate(rawType);
							rawType = delegate;
						}
						synonym.getReferences().add(rawType);
					}
				}
			}
			if (result != null)
				return result;
		}
		return createObjectReference(context.getFirst());
	}

	protected JvmTypeReference createObjectReference(Resource resource) {
		// no upper bound found - seems to be an invalid - assume object as upper bound
		JvmType objectType = factory.createJvmGenericType();
		String objectClassName = Object.class.getName();
		((InternalEObject) objectType).eSetProxyURI(URIHelperConstants.OBJECTS_URI.appendSegment(objectClassName)
				.appendFragment(objectClassName));
		if (resource != null) {
			objectType = (JvmType) EcoreUtil.resolve(objectType, resource);
		}
		JvmParameterizedTypeReference result = factory.createJvmParameterizedTypeReference();
		result.setType(objectType);
		return result;
	}
}