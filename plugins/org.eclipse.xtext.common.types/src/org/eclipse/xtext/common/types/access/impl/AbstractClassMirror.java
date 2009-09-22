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
import org.eclipse.xtext.common.types.ComponentType;
import org.eclipse.xtext.common.types.DeclaredType;
import org.eclipse.xtext.common.types.IdentifyableElement;
import org.eclipse.xtext.common.types.Member;
import org.eclipse.xtext.common.types.TypeReference;
import org.eclipse.xtext.common.types.TypeVariable;
import org.eclipse.xtext.common.types.TypeVariableDeclarator;
import org.eclipse.xtext.common.types.TypesFactory;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractClassMirror implements IClassMirror {

	public String getFragment(EObject obj) {
		if (obj instanceof TypeVariable)
			return getFragment(obj.eContainer()) + "/" + ((TypeVariable) obj).getName();
		if (obj instanceof TypeReference)
			return null;
		if (obj instanceof IdentifyableElement)
			return ((IdentifyableElement) obj).getCanonicalName();
		return null;
	}
	
	public EObject getEObject(Resource resource, String fragment) {
		if (fragment.endsWith("[]")) {
			ComponentType component = (ComponentType) getEObject(resource, fragment.substring(0, fragment.length() - 2));
			if (component == null)
				return null;
			if (component.getArrayType() == null) {
				component.setArrayType(TypesFactory.eINSTANCE.createArrayType());
			}
			return component.getArrayType();
		}
		int slash = fragment.indexOf('/'); 
		if (slash != -1) {
			String containerFragment = fragment.substring(0, slash);
			EObject container = getEObject(resource, containerFragment);
			if (container != null) {
				String varName = fragment.substring(slash + 1);
				if (container instanceof TypeVariableDeclarator) {
					TypeVariableDeclarator executable = (TypeVariableDeclarator) container;
					for(TypeVariable variable: executable.getTypeVariables()) {
						if (variable.getName().equals(varName))
							return variable;
					}
				} 
			}
		} else {
			if (getTypeName().equals(fragment))
				return resource.getContents().get(0);
			int paren = fragment.indexOf('(');
			if (paren == -1)
				paren = fragment.length();
			String subFragment = fragment.substring(0, fragment.lastIndexOf('.', paren));
			EObject container = getEObject(resource, subFragment);
			if (container instanceof DeclaredType) {
				EList<Member> members = ((DeclaredType) container).getMembers();
				for(Member member: members) {
					String name = member.getCanonicalName();
					if (name.equals(fragment))
						return member;
				}
			}
		}
		return null;	
	}
	
	protected abstract String getTypeName();
	
}
