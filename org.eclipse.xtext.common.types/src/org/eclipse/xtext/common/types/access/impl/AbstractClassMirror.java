/*******************************************************************************
 * Copyright (c) 2009, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.impl;

import static org.eclipse.xtext.util.Strings.*;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.common.types.JvmArrayType;
import org.eclipse.xtext.common.types.JvmComponentType;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.resource.IFragmentProvider;

/**
 * A mirror that is used at runtime to allow lazy initialization of resource contents.
 * Also it implements the contract of fragments and EObject retrieval by identifier.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractClassMirror implements IClassMirror {

	private static final Logger logger = Logger.getLogger(AbstractClassMirror.class);
	private boolean isEmptynessLogged = false;
	protected TypeResourceServices typeResourceServices;

	public AbstractClassMirror() {
	}
	
	public AbstractClassMirror(TypeResourceServices typeResourceServices) {
		this.typeResourceServices = typeResourceServices;
	}
	
	@Override
	public String getFragment(EObject obj, IFragmentProvider.Fallback fallback) {
		if (obj instanceof JvmTypeParameter)
			return getFragment(obj.eContainer(), fallback) + "/" + ((JvmTypeParameter) obj).getName();
		if (obj instanceof JvmTypeReference || obj instanceof JvmFormalParameter)
			return fallback.getFragment(obj);
		if (obj instanceof JvmIdentifiableElement) {
			if (obj instanceof JvmArrayType) {
				if (obj.eContainer() instanceof JvmGenericArrayTypeReference)
					return fallback.getFragment(obj);
				if (obj.eContainer() instanceof JvmIdentifiableElement) {
					return getFragment(obj.eContainer(), fallback) + "[]";
				}
			}
			return ((JvmIdentifiableElement) obj).getIdentifier();
		}
		return fallback.getFragment(obj);
	}
	
	@Override
	public EObject getEObject(Resource resource, String fragment, IFragmentProvider.Fallback fallback) {
		if (fragment.endsWith("[]")) {
			return getArrayEObject(resource, fragment, fallback);
		}
		int slash = fragment.indexOf('/'); 
		if (slash != -1) {
			if (slash == 0)
				return fallback.getEObject(fragment);
			String containerFragment = fragment.substring(0, slash);
			EObject container = getEObject(resource, containerFragment, fallback);
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
			if (resource.getContents().isEmpty()) {
				if (typeResourceServices!= null) 
					typeResourceServices.outdatedStateManager.checkCanceled(resource.getResourceSet());
				if (!isEmptynessLogged) {
					isEmptynessLogged = true;
					logger.error("resource is empty: " + resource.getURI(), new IllegalStateException());
					if (logger.isDebugEnabled()) {
						logger.debug(getClass().getName(), new Exception());
					}
				}
				return null;
			}
			final EObject type = resource.getContents().get(0);
			if (type instanceof JvmType) {
				String typeName = getTypeName((JvmType) type);
				if (typeName.equals(fragment)) {
					return type;
				}
				if(fragment.startsWith(typeName)) {
					EObject member = findMember(type, fragment);
					if(member != null)
						return member;
				}
			}
		}
		return fallback.getEObject(fragment);	
	}
	
	protected String getTypeName(JvmType type) {
		return getTypeName();
	}

	protected EObject findMember(EObject container, String fragment) {
		if (container instanceof JvmDeclaredType) {
			EList<JvmMember> members = ((JvmDeclaredType) container).getMembers();
			for(JvmMember member: members) {
				String name = member.getIdentifier();
				if(equal(fragment,name)) {
					return member;
				}
			}
			for(JvmMember member: members) {
				String name = member.getIdentifier();
				if(fragment.startsWith(name)) {
					EObject match = findMember(member, fragment);
					if(match != null) 
						return match;
				}
			}
		}
		return null;
	}

	protected EObject getArrayEObject(Resource resource, String fragment, IFragmentProvider.Fallback fallback) {
		JvmComponentType component = (JvmComponentType) getEObject(resource, fragment.substring(0, fragment.length() - 2), fallback);
		if (component == null)
			return null;
		return component.getArrayType();
	}
	
	protected abstract String getTypeName();
	
}
