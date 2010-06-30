/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typing;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmReferenceTypeArgument;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeArgument;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.xtype.XFunctionTypeRef;
import org.eclipse.xtext.xtype.XtypeFactory;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge
 */
public class TypesService {
	
	@Inject
	private IScopeProvider scopeProvider;
	
	private final EReference syntheticReference;
	
	{
		syntheticReference = EcoreFactory.eINSTANCE.createEReference();
		syntheticReference.setEType(TypesPackage.eINSTANCE.getJvmType());
		syntheticReference.setName("synthetic_EReference");
		EClass syntheticContainer = EcoreFactory.eINSTANCE.createEClass();
		syntheticContainer.setName("Synthetic_EClass");
		syntheticContainer.getEStructuralFeatures().add(syntheticReference);
	}
	
	public JvmTypeReference getTypeForName(String name, EObject context, JvmTypeReference...params) {
		IScope scope = scopeProvider.getScope(context, syntheticReference);
		IEObjectDescription contentByName = scope.getContentByName(name);
		if (contentByName!=null) {
			JvmParameterizedTypeReference simpleType = createJvmTypeReference((JvmType) contentByName.getEObjectOrProxy());
			for (JvmTypeReference xTypeRef : params) {
				simpleType.getArguments().add(createArgument(copy(xTypeRef)));
			}
			return simpleType;
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	protected <T extends EObject> T copy(T xTypeRef) {
		return (T) EcoreUtil.copy(xTypeRef);
	}

	public JvmParameterizedTypeReference createJvmTypeReference(JvmType eObjectOrProxy) {
		JvmParameterizedTypeReference typeRef = TypesFactory.eINSTANCE.createJvmParameterizedTypeReference();
		typeRef.setType(eObjectOrProxy);
		return typeRef;
	}

	public JvmTypeReference getCommonType(List<JvmTypeReference> returnTypes) {
		for (JvmTypeReference xTypeRef : returnTypes) {
			for (JvmTypeReference xTypeRef1 : returnTypes) {
				isAssignableFrom(xTypeRef,xTypeRef1);
			}
		}
		return returnTypes.get(0);
	}

	public boolean isAssignableFrom(JvmTypeReference xTypeRef, JvmTypeReference xTypeRef1) {
		
		return false;
	}

	public XFunctionTypeRef createFunctionTypeRef(List<JvmTypeReference> parameterTypes,
			JvmTypeReference returnType) {
		XFunctionTypeRef ref = XtypeFactory.eINSTANCE.createXFunctionTypeRef();
		for (JvmTypeReference xTypeRef : parameterTypes) {
			ref.getArguments().add(createArgument(copy(xTypeRef)));
		}
		ref.getArguments().add(createArgument(copy(returnType)));
		return ref;
	}

	protected JvmTypeArgument createArgument(JvmTypeReference typeRef) {
		JvmReferenceTypeArgument argument = TypesFactory.eINSTANCE.createJvmReferenceTypeArgument();
		argument.setTypeReference(typeRef);
		return argument;
	}

}
