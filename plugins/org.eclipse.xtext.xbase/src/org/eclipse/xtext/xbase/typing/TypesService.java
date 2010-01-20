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
import org.eclipse.xtext.common.types.Type;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.xtype.XFunctionTypeRef;
import org.eclipse.xtext.xtype.XSimpleTypeRef;
import org.eclipse.xtext.xtype.XTypeRef;
import org.eclipse.xtext.xtype.XtypeFactory;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge
 */
public class TypesService {
	
	@Inject
	private IScopeProvider scopeProvider;
	
	private EReference syntheticReference;
	
	{
		syntheticReference = EcoreFactory.eINSTANCE.createEReference();
		syntheticReference.setEType(TypesPackage.eINSTANCE.getType());
		syntheticReference.setName("synthetic_EReference");
		EClass syntheticContainer = EcoreFactory.eINSTANCE.createEClass();
		syntheticContainer.setName("Synthetic_EClass");
		syntheticContainer.getEStructuralFeatures().add(syntheticReference);
	}
	
	public XSimpleTypeRef getTypeForName(String name, EObject context, XTypeRef...params) {
		IScope scope = scopeProvider.getScope(context, syntheticReference);
		IEObjectDescription contentByName = scope.getContentByName(name);
		if (contentByName!=null) {
			XSimpleTypeRef simpleType = createSimpleTypeRef((Type) contentByName.getEObjectOrProxy());
			for (XTypeRef xTypeRef : params) {
				simpleType.getTypeParams().add(copy(xTypeRef));
			}
			return simpleType;
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	protected <T extends EObject> T copy(T xTypeRef) {
		return (T) EcoreUtil.copy(xTypeRef);
	}

	public XSimpleTypeRef createSimpleTypeRef(Type eObjectOrProxy) {
		XSimpleTypeRef typeRef = XtypeFactory.eINSTANCE.createXSimpleTypeRef();
		typeRef.setType(eObjectOrProxy);
		return typeRef;
	}

	public XTypeRef getCommonType(List<XTypeRef> returnTypes) {
		for (XTypeRef xTypeRef : returnTypes) {
			for (XTypeRef xTypeRef1 : returnTypes) {
				isAssignableFrom(xTypeRef,xTypeRef1);
			}
		}
		return returnTypes.get(0);
	}

	public boolean isAssignableFrom(XTypeRef xTypeRef, XTypeRef xTypeRef1) {
		
		return false;
	}

	public XTypeRef createFunctionTypeRef(List<XTypeRef> parameterTypes,
			XTypeRef returnType) {
		XFunctionTypeRef ref = XtypeFactory.eINSTANCE.createXFunctionTypeRef();
		ref.setReturnType(copy(returnType));
		for (XTypeRef xTypeRef : parameterTypes) {
			ref.getParamTypes().add(copy(xTypeRef));
		}
		return ref;
	}

}
