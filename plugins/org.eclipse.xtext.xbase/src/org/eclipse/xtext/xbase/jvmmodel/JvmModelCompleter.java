/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.jvmmodel;

import static com.google.common.collect.Iterables.*;

import java.lang.annotation.Annotation;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.lib.macro.services.Associator;
import org.eclipse.xtext.common.types.JvmAnnotationType;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmEnumerationLiteral;
import org.eclipse.xtext.common.types.JvmEnumerationType;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.util.TypeReferences;

import com.google.inject.Inject;

/**
 * Adds expected default values to a created JvmModel.
 * This is not meant to be enhanced in a language specific way, but really just to add things which
 * are implicit in the Java language, such as default constructors or that a class extends java.lang.Object
 * 
 * @author Sven Efftinge - Initial contribution and API
 * 
 * @noextend This class is not intended to be subclassed by clients.
 */
public class JvmModelCompleter {
	
	@Inject 
	private TypeReferences references;
	
	@Inject 
	private TypesFactory typesFactory;
	
	@Inject 
	private JvmTypeExtensions typeExtensions;  
	
	@Inject
	private IJvmModelAssociations associations;
	
	@Inject
	private IJvmModelAssociator associator;

	public void complete(Iterable<? extends JvmIdentifiableElement> elements) {
		for (JvmIdentifiableElement element : elements) {
			complete(element);
		}
	}
	
	public void complete(JvmIdentifiableElement element) {
		if (element instanceof JvmGenericType) {
			completeJvmGenericType((JvmGenericType)element);
		}
		if (element instanceof JvmDeclaredType) {
			JvmDeclaredType declaredType = (JvmDeclaredType) element;
			complete(declaredType.getMembers());
		}
		if(element instanceof JvmConstructor) {
			completeJvmConstructor((JvmConstructor) element);
		}
		if (element instanceof JvmEnumerationType) {
			completeJvmEnumerationType((JvmEnumerationType)element);
		}
		if (element instanceof JvmEnumerationLiteral) {
			completeJvmEnumerationLiteral((JvmEnumerationLiteral)element);
		}
		if (element instanceof JvmAnnotationType) {
			completeJvmAnnotationType((JvmAnnotationType)element);
		}
	}
	
	protected void completeJvmEnumerationType(JvmEnumerationType element) {
		if (element.getSuperTypes().isEmpty()) {
			JvmTypeReference objectType = references.getTypeForName(Enum.class, element,
					references.createTypeRef(element));
			if (objectType != null)
				element.getSuperTypes().add(objectType);
		}
		EObject primarySourceElement = associations.getPrimarySourceElement(element);
		JvmOperation values = typesFactory.createJvmOperation();
		values.setVisibility(JvmVisibility.PUBLIC);
		values.setStatic(true);
		values.setSimpleName("values");
		values.setReturnType(references.createArrayType(references.createTypeRef(element)));
		typeExtensions.setSynthetic(values, true);
		if (primarySourceElement != null) {
			associator.associatePrimary(primarySourceElement, values);
		}
		element.getMembers().add(values);
		
		JvmOperation valueOf = typesFactory.createJvmOperation();
		valueOf.setVisibility(JvmVisibility.PUBLIC);
		valueOf.setStatic(true);
		valueOf.setSimpleName("valueOf");
		valueOf.setReturnType(references.createTypeRef(element));
		JvmFormalParameter param = typesFactory.createJvmFormalParameter();
		param.setName("name");
		param.setParameterType(references.getTypeForName(String.class, element));
		valueOf.getParameters().add(param);
		typeExtensions.setSynthetic(valueOf, true);
		if (primarySourceElement != null) {
			associator.associatePrimary(primarySourceElement, valueOf);
		}
		element.getMembers().add(valueOf);
	}

	protected void completeJvmEnumerationLiteral(JvmEnumerationLiteral element) {
		if (element.getType() == null) {
			element.setType(references.createTypeRef(element.getDeclaringType()));
		}
		element.setStatic(true);
	}

	protected void completeJvmAnnotationType(JvmAnnotationType element) {
		if (element.getSuperTypes().isEmpty()) {
			JvmTypeReference objectType = references.getTypeForName(Annotation.class, element);
			if (objectType != null)
				element.getSuperTypes().add(objectType);
		}

	}
	
	public void completeJvmConstructor(JvmConstructor constructor) {
		JvmDeclaredType declaringType = constructor.getDeclaringType();
		if(declaringType != null) {
			String simpleName = declaringType.getSimpleName();
			if(simpleName != null) {
				constructor.setSimpleName(simpleName);
				return;
			}
		}
		constructor.setSimpleName("unset");
	}
	
	protected void completeJvmGenericType(JvmGenericType element) {
		// if no super type add Object
		ensureSuperTypeObject(element);
		if (!element.isInterface()) {
			// if no constructors have been added, add a default constructor
			if (isEmpty(element.getDeclaredConstructors())) {
				JvmConstructor constructor = TypesFactory.eINSTANCE.createJvmConstructor();
				constructor.setSimpleName(element.getSimpleName());
				constructor.setVisibility(JvmVisibility.PUBLIC);
				typeExtensions.setSynthetic(constructor, true);
				EObject primarySourceElement = associations.getPrimarySourceElement(element);
				if (primarySourceElement != null) {
					associator.associatePrimary(primarySourceElement, constructor);
				}
				element.getMembers().add(constructor);
			}
		}
	}

	protected void ensureSuperTypeObject(JvmDeclaredType element) {
		if (element.getSuperTypes().isEmpty()) {
			JvmTypeReference objectType = references.getTypeForName(Object.class, element);
			if (objectType != null)
				element.getSuperTypes().add(objectType);
		}
	}
}
