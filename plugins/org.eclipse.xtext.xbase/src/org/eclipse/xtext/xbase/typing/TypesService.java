/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typing;

import static com.google.common.collect.Iterables.*;

import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.access.IJvmTypeProvider;
import org.eclipse.xtext.common.types.access.impl.ClassURIHelper;
import org.eclipse.xtext.common.types.util.SuperTypeCollector;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.xbase.lib.Functions;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge
 */
public class TypesService {

	@Inject
	private TypesFactory factory;

	@Inject
	private ClassURIHelper uriHelper;
	
	@Inject
	private IJvmTypeProvider.Factory typeProviderFactory;
	
	@Inject
	private SuperTypeCollector superTypeCollector;
	
	@Inject
	private TypeReferences typeReferences;

	protected URI toCommonTypesUri(Class<?> clazz) {
		URI result = uriHelper.getFullURI(clazz);
		return result;
	}

	public JvmTypeReference getTypeForName(Class<?> clazz, EObject context, JvmTypeReference... params) {
		if (clazz == null)
			throw new NullPointerException("clazz");
		JvmDeclaredType declaredType = findDeclaredType(clazz, context);
		if (declaredType == null)
			return null;
		JvmParameterizedTypeReference result = typeReferences.createTypeRef(declaredType, params);
		return result;
	}

	public JvmDeclaredType findDeclaredType(Class<?> clazz, EObject context) {
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
		JvmDeclaredType declaredType = (JvmDeclaredType) resourceSet.getEObject(uri, true);
		return declaredType;
	}

	public JvmParameterizedTypeReference createFunctionTypeRef(EObject context, List<JvmTypeReference> parameterTypes, JvmTypeReference returnType) {
		JvmParameterizedTypeReference ref = factory.createJvmParameterizedTypeReference();
		final Class<?> loadFunctionClass = loadFunctionClass("Function"+parameterTypes.size());
		JvmGenericType declaredType = (JvmGenericType) findDeclaredType(loadFunctionClass, context);
		ref.setType(declaredType);
		
		for (int i = 0; i< parameterTypes.size();i++) {
			JvmTypeReference xTypeRef = parameterTypes.get(i);
			if (xTypeRef == null) {
				JvmParameterizedTypeReference reference = factory.createJvmParameterizedTypeReference();
				JvmTypeParameter typeParameter = declaredType.getTypeParameters().get(i);
				reference.setType(typeParameter);
				ref.getArguments().add(reference);
			} else {
				ref.getArguments().add(EcoreUtil2.clone(xTypeRef));
			}
		}
		if (returnType!=null) {
			ref.getArguments().add(EcoreUtil2.clone(returnType));
		} else {
			JvmParameterizedTypeReference reference = factory.createJvmParameterizedTypeReference();
			JvmTypeParameter typeParameter = getLast(declaredType.getTypeParameters());
			reference.setType(typeParameter);
			ref.getArguments().add(reference);
		}
		return ref;
	}

	protected Class<?> loadFunctionClass(String simpleFunctionName) {
		try {
			return Functions.class.getClassLoader().loadClass(Functions.class.getCanonicalName()+"$"+simpleFunctionName);
		} catch (ClassNotFoundException e) {
			throw new WrappedException(e);
		}
	}

	public boolean isVoid(JvmTypeReference typeRef) {
		if (typeRef != null) {
			String typeName = typeRef.getCanonicalName();
			return typeName.equals(Void.TYPE.getCanonicalName()) || typeName.equals(Void.class.getCanonicalName());
		}
		return false;
	}

	public boolean isObject(JvmTypeReference typeRef) {
		if (typeRef != null) {
			String typeName = typeRef.getCanonicalName();
			return typeName.equals(Object.class.getCanonicalName()) || typeName.equals(Void.class.getCanonicalName());
		}
		return false;
	}
	public boolean isIterable(JvmTypeReference reference) {
		return reference !=null && Iterable.class.getName().equals(reference.getType().getCanonicalName());
	}

	public boolean isInstanceOfIterable(JvmTypeReference jvmTypeReference) {
		if (isIterable(jvmTypeReference))
			return true;
		Set<JvmTypeReference> types = superTypeCollector.collectSuperTypes(jvmTypeReference);
		for (JvmTypeReference superType : types) {
			if (isIterable(superType))
				return true;
		}
		return false;
	}
}
