/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typing;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.access.IJvmTypeProvider;
import org.eclipse.xtext.common.types.access.impl.ClassURIHelper;
import org.eclipse.xtext.xtype.XFunctionTypeRef;
import org.eclipse.xtext.xtype.XtypeFactory;

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

	protected URI toCommonTypesUri(Class<?> clazz) {
		URI result = uriHelper.getFullURI(clazz);
		return result;
	}

	public JvmTypeReference getTypeForName(Class<?> clazz, EObject context, JvmTypeReference... params) {
		if (clazz == null)
			throw new NullPointerException("clazz");
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
		if (declaredType == null)
			return null;
		JvmParameterizedTypeReference simpleType = factory.createJvmParameterizedTypeReference();
		simpleType.setType(declaredType);
		for (JvmTypeReference xTypeRef : params) {
			simpleType.getArguments().add(EcoreUtil2.clone(xTypeRef));
		}
		return simpleType;
	}

	public XFunctionTypeRef createFunctionTypeRef(List<JvmTypeReference> parameterTypes, JvmTypeReference returnType) {
		XFunctionTypeRef ref = XtypeFactory.eINSTANCE.createXFunctionTypeRef();
		for (JvmTypeReference xTypeRef : parameterTypes) {
			ref.getParamTypes().add(EcoreUtil2.clone(xTypeRef));
		}
		ref.setReturnType(EcoreUtil2.clone(returnType));
		return ref;
	}

	public boolean isVoid(JvmTypeReference typeRef) {
		if (typeRef != null) {
			String typeName = typeRef.getCanonicalName();
			return typeName.equals(Void.TYPE.getCanonicalName()) || typeName.equals(Void.class.getCanonicalName());
		}
		return false;
	}
}
