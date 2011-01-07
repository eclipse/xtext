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
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
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

	public static final QualifiedName JAVA_LANG_CLASS;
	public static final QualifiedName INTEGER_TYPE_NAME;
	public static final QualifiedName VOID_TYPE_NAME;
	public static final QualifiedName BOOLEAN_TYPE_NAME;
	public static final QualifiedName STRING_TYPE_NAME;
	public static final QualifiedName OBJECT_TYPE_NAME;
	public static final QualifiedName JAVA_LANG_THROWABLE;
	public static final QualifiedName JAVA_LANG_ITERABLE;

	static {
		IQualifiedNameConverter.DefaultImpl nameConverter = new IQualifiedNameConverter.DefaultImpl();
		JAVA_LANG_CLASS = nameConverter.toQualifiedName(Class.class.getName());
		INTEGER_TYPE_NAME = nameConverter.toQualifiedName(Integer.class.getName());
		VOID_TYPE_NAME = nameConverter.toQualifiedName(Void.class.getName());
		BOOLEAN_TYPE_NAME = nameConverter.toQualifiedName(Boolean.class.getName());
		STRING_TYPE_NAME = nameConverter.toQualifiedName(String.class.getName());
		OBJECT_TYPE_NAME = nameConverter.toQualifiedName(Object.class.getName());
		JAVA_LANG_THROWABLE = nameConverter.toQualifiedName(Throwable.class.getName());
		JAVA_LANG_ITERABLE = nameConverter.toQualifiedName(Iterable.class.getName());
	}
	
	public JvmTypeReference getTypeForName(QualifiedName qualifiedName, EObject context, JvmTypeReference... params) {
		IScope scope = scopeProvider.getScope(context, syntheticReference);
		IEObjectDescription contentByName = scope.getSingleElement(qualifiedName);
		if (contentByName != null) {
			JvmParameterizedTypeReference simpleType = factory.createJvmParameterizedTypeReference();
			simpleType.setType((JvmType) contentByName.getEObjectOrProxy());
			// TODO wildcard types do not allow method calls with parameters of type <?> - create raw types instead
//			if (params.length==0) {
//				if (simpleType.getType() instanceof JvmTypeParameterDeclarator) {
//					JvmTypeParameterDeclarator type = (JvmTypeParameterDeclarator) simpleType.getType();
//					for (@SuppressWarnings("unused") JvmTypeParameter typeParam : type.getTypeParameters()) {
//						simpleType.getArguments().add(factory.createJvmWildcardTypeReference());
//					}
//				}
//			} else {
			for (JvmTypeReference xTypeRef : params) {
				simpleType.getArguments().add(EcoreUtil2.clone(xTypeRef));
			}
//			}
			return simpleType;
		}
		return null;
	}

	public XFunctionTypeRef createFunctionTypeRef(List<JvmTypeReference> parameterTypes, JvmTypeReference returnType) {
		XFunctionTypeRef ref = XtypeFactory.eINSTANCE.createXFunctionTypeRef();
		for (JvmTypeReference xTypeRef : parameterTypes) {
			ref.getParamTypes().add(EcoreUtil2.clone(xTypeRef));
		}
		ref.setReturnType(EcoreUtil2.clone(returnType));
		return ref;
	}

}
