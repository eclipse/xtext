/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.util;

import static com.google.common.collect.Lists.*;

import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmArrayType;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmUpperBound;
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.access.IJvmTypeProvider;
import org.eclipse.xtext.common.types.access.TypeNotFoundException;
import org.eclipse.xtext.common.types.access.impl.ClassURIHelper;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class TypeReferences {
	
	private final static Logger log = Logger.getLogger(TypeReferences.class);

	@Inject
	private TypesFactory factory = TypesFactory.eINSTANCE;
	
	@Inject
	private IJvmTypeProvider.Factory typeProviderFactory;
	
	@Inject
	private ClassURIHelper uriHelper;
	
	@Inject
	private SuperTypeCollector superTypeCollector;
	
	public JvmParameterizedTypeReference createTypeRef(JvmType type, JvmTypeReference... typeArgs) {
		List<JvmTypeReference> typeReferences = newArrayList();
		if (typeArgs!=null) {
			for (int i = 0; i < typeArgs.length; i++) {
				JvmTypeReference jvmTypeReference = typeArgs[i];
				typeReferences.add(EcoreUtil2.clone(jvmTypeReference));
			}
		}
		if (type instanceof JvmGenericType) {
			EList<JvmTypeParameter> list = ((JvmGenericType) type).getTypeParameters();
			if (!typeReferences.isEmpty() && list.size() != typeReferences.size()) {
				throw new IllegalArgumentException("The type " + type.getCanonicalName() + " expects " + list.size()
						+ " type arguments, but was " + typeReferences.size()
						+ ". Either pass zero arguments (raw type) or the correct number.");
			}
			// Raw type -> create type refereces to type param
			if (typeReferences.isEmpty() && !list.isEmpty()) {
				for (JvmTypeParameter typeParameter : list) {
					typeReferences.add(createTypeRef(typeParameter));
				}
			}
		}
		JvmParameterizedTypeReference reference = factory.createJvmParameterizedTypeReference();
		reference.setType(type);
		if (!typeReferences.isEmpty())
			reference.getArguments().addAll(typeReferences);
		return reference;
	}

	public JvmTypeReference getArgument(JvmTypeReference left, int index) {
		if (left.getType() instanceof JvmGenericType) {
			EList<JvmTypeParameter> typeParameters = ((JvmGenericType) left.getType()).getTypeParameters();
			if (typeParameters.size() <= index) {
				throw new IllegalArgumentException("The type " + left.getType().getCanonicalName()
						+ " cannot be parameterized with more than " + typeParameters.size() + " type arguments.");
			}
			if (left instanceof JvmParameterizedTypeReference) {
				EList<JvmTypeReference> arguments = ((JvmParameterizedTypeReference) left).getArguments();
				if (arguments.size() == typeParameters.size()) {
					return arguments.get(index);
				}
			}
			final JvmTypeParameter jvmTypeParameter = typeParameters.get(index);
			return createTypeRef(jvmTypeParameter);
		}
		throw new IllegalArgumentException(left.getType().getCanonicalName() + " is not generic.");
	}

	public JvmTypeReference wildCardExtends(JvmTypeReference clone) {
		JvmWildcardTypeReference result = factory.createJvmWildcardTypeReference();
		JvmUpperBound upperBound = factory.createJvmUpperBound();
		upperBound.setTypeReference(clone);
		result.getConstraints().add(upperBound);
		return result;
	}
	
	protected URI toCommonTypesUri(Class<?> clazz) {
		URI result = uriHelper.getFullURI(clazz);
		return result;
	}

	public JvmTypeReference getTypeForName(Class<?> clazz, EObject context, JvmTypeReference... params) {
		if (clazz == null)
			throw new NullPointerException("clazz");
		JvmType declaredType = findDeclaredType(clazz, context);
		if (declaredType == null)
			return null;
		JvmParameterizedTypeReference result = createTypeRef(declaredType, params);
		return result;
	}

	public JvmType findDeclaredType(Class<?> clazz, EObject context) {
		if (context == null)
			throw new NullPointerException("context");
		if (context.eResource() == null)
			throw new NullPointerException("context must be contained in a resource");
		final ResourceSet resourceSet = context.eResource().getResourceSet();
		if (resourceSet == null)
			throw new NullPointerException("context must be contained in a resource set");
		// make sure a type provider is configured in the resource set. 
		typeProviderFactory.findOrCreateTypeProvider(resourceSet);
		URI uri = toCommonTypesUri(clazz);
		try {
			JvmType declaredType = (JvmType) resourceSet.getEObject(uri, true);
			return declaredType;
		} catch (TypeNotFoundException e) {
			log.error(e.getMessage(), e);
			return null;
		}
	}
	
	public boolean is(final JvmTypeReference reference, final Class<?> clazz) {
		if (isNullOrProxy(reference))
			return false;
		final boolean equals = clazz.getCanonicalName().equals(reference.getType().getCanonicalName());
		return equals;
	}

	public boolean isNullOrProxy(final JvmTypeReference reference) {
		return reference==null || reference.getType()==null || reference.getType().eIsProxy();
	}
	
	public boolean isInstanceOf(JvmTypeReference reference, Class<?> clazz) {
		if (isNullOrProxy(reference))
			return false;
		if (is(reference,clazz)) {
			return true;
		}
		Set<JvmTypeReference> types = superTypeCollector.collectSuperTypes(reference);
		for (JvmTypeReference jvmTypeReference : types) {
			if (is(jvmTypeReference,clazz))
				return true;
		}
		return false;
	}
	
	public boolean isArray(JvmTypeReference type) {
		if (isNullOrProxy(type))
			return false;
		return type.getType() instanceof JvmArrayType;
	}
}
