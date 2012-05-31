/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.jvmmodel;

import static com.google.common.collect.Iterables.*;

import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
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
	
	@Inject private TypeReferences references;

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
		if (!element.isInterface()) {
			// if no super type add Object
			if (element.getSuperTypes().isEmpty()) {
				JvmTypeReference objectType = references.getTypeForName(Object.class, element);
				if (objectType != null)
					element.getSuperTypes().add(objectType);
			}
			// if no constructors have been added, add a default constructor
			if (isEmpty(element.getDeclaredConstructors())) {
				JvmConstructor constructor = TypesFactory.eINSTANCE.createJvmConstructor();
				constructor.setSimpleName(element.getSimpleName());
				constructor.setVisibility(JvmVisibility.PUBLIC);
				element.getMembers().add(constructor);
			}
		}
	}
}
