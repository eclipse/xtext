/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.impl;

import java.util.Iterator;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.common.types.JvmArrayType;
import org.eclipse.xtext.common.types.JvmComponentType;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
// TODO honor container configuration
public class IndexedJvmTypeAccess {
	
	private final static Logger logger = Logger.getLogger(IndexedJvmTypeAccess.class);

	@Inject
	private ResourceDescriptionsProvider resourceDescriptionsProvider;
	
	public EObject getIndexedJvmType(URI javaObjectURI, ResourceSet resourceSet) {
		if (resourceSet != null) {
			IResourceDescriptions descriptions = resourceDescriptionsProvider.getResourceDescriptions(resourceSet);
			if (descriptions != null) {
				URI withoutFragment = javaObjectURI.trimFragment();
				String fqn = withoutFragment.segment(withoutFragment.segmentCount() - 1);
				String[] fqnSegments = fqn.split("\\.");
				QualifiedName qualifiedName = QualifiedName.create(fqnSegments);
				Iterable<IEObjectDescription> candidates = descriptions.getExportedObjects(TypesPackage.Literals.JVM_TYPE, qualifiedName, false);
				Iterator<IEObjectDescription> iterator = candidates.iterator();
				if (iterator.hasNext()) {
					IEObjectDescription description = iterator.next();
					EObject typeProxy = description.getEObjectOrProxy();
					if (typeProxy.eIsProxy()) {
						typeProxy = EcoreUtil.resolve(typeProxy, resourceSet);
					}
					if (!typeProxy.eIsProxy() && typeProxy instanceof JvmType) {
						EObject result = resolveJavaObject((JvmType)typeProxy, javaObjectURI.fragment());
						if (result != null)
							return result;
					}
				}
			}
		}
		return null;
	}
	
	public EObject resolveJavaObject(JvmType rootType, String fragment) {
		if (fragment.endsWith("[]")) {
			return resolveJavaArrayObject(rootType, fragment);
		}
		int slash = fragment.indexOf('/'); 
		if (slash != -1) {
			if (slash == 0)
				return null;
			String containerFragment = fragment.substring(0, slash);
			EObject container = resolveJavaObject(rootType, containerFragment);
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
			if (rootType.getIdentifier().equals(fragment)) {
				return rootType;
			}
			int paren = fragment.indexOf('(');
			if (paren == -1)
				paren = fragment.length();
			int dollar = fragment.lastIndexOf('$', paren);
			int dot = fragment.lastIndexOf('.', paren);
			final int max = Math.max(dollar, dot);
			if (max == -1) {
				logger.warn("Couldn't resolve java object for root type "+rootType!=null?rootType.getQualifiedName():"null"+" and fragment '"+fragment);
				return null;
			}
			String subFragment = fragment.substring(0, max);
			EObject container = resolveJavaObject(rootType, subFragment);
			if (container instanceof JvmDeclaredType) {
				EList<JvmMember> members = ((JvmDeclaredType) container).getMembers();
				for(JvmMember member: members) {
					String name = member.getIdentifier();
					if (name.equals(fragment))
						return member;
				}
			}
		}
		return null;	
	}

	public EObject resolveJavaArrayObject(JvmType rootType, String fragment) {
		JvmComponentType component = (JvmComponentType) resolveJavaObject(rootType, fragment.substring(0, fragment.length() - 2));
		if (component == null)
			return null;
		if (component.getArrayType() == null) {
			JvmArrayType arrayType = TypesFactory.eINSTANCE.createJvmArrayType();
			arrayType.setComponentType(component);
		}
		return component.getArrayType();
	}
	
}
