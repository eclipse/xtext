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
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.common.types.util.IJvmTypeConformanceComputer;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.scoping.ISelector;
import org.eclipse.xtext.typing.ITypeConformanceComputer;
import org.eclipse.xtext.xtype.XFunctionTypeRef;
import org.eclipse.xtext.xtype.XtypeFactory;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge
 */
public class TypesService implements ITypeConformanceComputer<JvmTypeReference> {

	@Inject
	private IScopeProvider scopeProvider;

	@Inject
	private IJvmTypeConformanceComputer conformanceComputer;

	@Inject
	private TypesFactory factory;

	private final EReference syntheticReference;

	{
		syntheticReference = EcoreFactory.eINSTANCE.createEReference();
		syntheticReference.setEType(TypesPackage.eINSTANCE.getJvmType());
		syntheticReference.setName("synthetic_EReference");
		EClass syntheticContainer = EcoreFactory.eINSTANCE.createEClass();
		syntheticContainer.setName("Synthetic_EClass");
		syntheticContainer.getEStructuralFeatures().add(syntheticReference);
	}

	public JvmTypeReference getTypeForName(QualifiedName qualifiedName, EObject context, JvmTypeReference... params) {
		IScope scope = scopeProvider.getScope(context, syntheticReference);
		IEObjectDescription contentByName = scope.getSingleElement(new ISelector.SelectByName(qualifiedName));
		if (contentByName != null) {
			JvmParameterizedTypeReference simpleType = factory.createJvmParameterizedTypeReference();
			simpleType.setType((JvmType) contentByName.getEObjectOrProxy());
			for (JvmTypeReference xTypeRef : params) {
				simpleType.getArguments().add(EcoreUtil2.clone(xTypeRef));
			}
			return simpleType;
		}
		return null;
	}

	public JvmTypeReference getCommonType(List<JvmTypeReference> returnTypes) {
		return conformanceComputer.getCommonSuperType(returnTypes);
	}

	public boolean isConformant(JvmTypeReference xTypeRef, JvmTypeReference xTypeRef1) {
		return conformanceComputer.isConformant(xTypeRef, xTypeRef1);
	}

	public XFunctionTypeRef createFunctionTypeRef(List<JvmTypeReference> parameterTypes, JvmTypeReference returnType) {
		XFunctionTypeRef ref = XtypeFactory.eINSTANCE.createXFunctionTypeRef();
		for (JvmTypeReference xTypeRef : parameterTypes) {
			ref.getParamTypes().add(EcoreUtil2.clone(xTypeRef));
		}
		ref.setReturnType(EcoreUtil2.clone(returnType));
		return ref;
	}

	public String getName(JvmTypeReference actual) {
		return conformanceComputer.getName(actual);
	}

}
