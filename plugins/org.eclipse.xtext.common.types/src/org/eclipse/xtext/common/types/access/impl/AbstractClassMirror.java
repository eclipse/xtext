/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.impl;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.common.types.JvmArrayType;
import org.eclipse.xtext.common.types.JvmComponentType;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmIdentifyableElement;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.TypesFactory;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractClassMirror implements IClassMirror {

	public String getFragment(EObject obj) {
		if (obj instanceof JvmTypeParameter)
			return getFragment(obj.eContainer()) + "/" + ((JvmTypeParameter) obj).getName();
		if (obj instanceof JvmTypeReference)
			return null; // use default implementation
		if (obj instanceof JvmIdentifyableElement)
			return ((JvmIdentifyableElement) obj).getCanonicalName();
		return null;
	}
	
	public EObject getEObject(Resource resource, String fragment) {
		if (fragment.endsWith("[]")) {
			return getArrayEObject(resource, fragment);
		}
		int slash = fragment.indexOf('/'); 
		if (slash != -1) {
			String containerFragment = fragment.substring(0, slash);
			EObject container = getEObject(resource, containerFragment);
			if (container != null) {
				String parameterName = fragment.substring(slash + 1);
				if (container instanceof JvmTypeParameterDeclarator) {
					JvmTypeParameterDeclarator executable = (JvmTypeParameterDeclarator) container;
					for(JvmTypeParameter parameter: executable.getTypeParameters()) {
						if (parameter.getName().equals(parameterName))
							return parameter;
					}
				} 
			}
		} else {
			if (getTypeName().equals(fragment))
				return resource.getContents().get(0);
			int paren = fragment.indexOf('(');
			if (paren == -1)
				paren = fragment.length();
			int dollar = fragment.lastIndexOf('$', paren);
			int dot = fragment.lastIndexOf('.', paren);
			String subFragment = fragment.substring(0, Math.max(dollar, dot));
			EObject container = getEObject(resource, subFragment);
			if (container instanceof JvmDeclaredType) {
				EList<JvmMember> members = ((JvmDeclaredType) container).getMembers();
				for(JvmMember member: members) {
					String name = member.getCanonicalName();
					if (name.equals(fragment))
						return member;
				}
			}
		}
		return null;	
	}

	protected EObject getArrayEObject(Resource resource, String fragment) {
		JvmComponentType component = (JvmComponentType) getEObject(resource, fragment.substring(0, fragment.length() - 2));
		if (component == null)
			return null;
		if (component.getArrayType() == null) {
			JvmArrayType arrayType = TypesFactory.eINSTANCE.createJvmArrayType();
			JvmParameterizedTypeReference componentTypeReference = TypesFactory.eINSTANCE.createJvmParameterizedTypeReference();
			componentTypeReference.setType(component);
			arrayType.setComponentType(componentTypeReference);
			component.setArrayType(arrayType);
		}
		return component.getArrayType();
	}
	
	protected abstract String getTypeName();
	
}
