/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.index.impl;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.index.ResourceDescriptor;
import org.eclipse.emf.index.EObjectDescriptor;
import org.eclipse.emf.index.EClassDescriptor;

/**
 * @author Jan Köhnlein - Initial contribution and API
 */
public class EObjectDescriptorImpl extends BasicEObjectDescriptorImpl {

	private Map<String, String> userData;

	private EObjectDescriptorImpl(ResourceDescriptor resourceDescriptor, String fragment, String name,
			String displayName, EClassDescriptor typeDescriptor, Map<String, String> userData) {
		super(resourceDescriptor, fragment, name, displayName, typeDescriptor);
		this.userData = userData;
	}

	public String getUserData(String key) {
		if (userData != null)
			return userData.get(key);
		return null;
	}

	public Map<String, String> getUserData() {
		return Collections.unmodifiableMap(userData);
	}

	@Override
	public String toString() {
		return displayName;
	}

	public static class Factory implements EObjectDescriptor.Factory {

		public EObjectDescriptor createDescriptor(EObject eObject, ResourceDescriptor resourceDescriptor,
				EClassDescriptor typeDescriptor, Map<String, String> userData) {
			Resource resource = eObject.eResource();
			return new EObjectDescriptorImpl(resourceDescriptor, resource.getURIFragment(eObject),
					nameAttributeValue(eObject), defaultDisplayName(eObject), typeDescriptor, userData);
		}
		
		public EObjectDescriptor createDescriptor(EObject eObject, ResourceDescriptor resourceDescriptor,
				EClassDescriptor typeDescriptor) {
			Resource resource = eObject.eResource();
			return new EObjectDescriptorImpl(resourceDescriptor, resource.getURIFragment(eObject),
					nameAttributeValue(eObject), defaultDisplayName(eObject), typeDescriptor, null);
		}

		public boolean isFactoryFor(EClass eClass) {
			return true;
		}

		public String defaultDisplayName(EObject eObject) {
			String displayName = nameAttributeValue(eObject);
			if (displayName == null)
				displayName = eObject.eResource().getURIFragment(eObject);
			return displayName;
		}

		@SuppressWarnings("unchecked")
		public String nameAttributeValue(EObject eObject) {
			EStructuralFeature nameFeature = eObject.eClass().getEStructuralFeature("name");
			if (nameFeature != null && nameFeature.getEType() instanceof EDataType) {
				if (!nameFeature.isMany())
					return eObject.eGet(nameFeature).toString();
				else {
					List names = (List) eObject.eGet(nameFeature);
					StringBuilder b = new StringBuilder();
					for (Iterator nameIter = names.iterator(); nameIter.hasNext();) {
						b.append(nameIter.next().toString());
					}
					return b.toString();
				}
			}
			return null;
		}
	}

}
