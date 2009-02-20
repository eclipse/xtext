/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.index.impl;

import java.util.Iterator;
import java.util.List;

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
public class ElementDescriptorImpl extends BasicEObjectDescriptorImpl {

	private ElementDescriptorImpl(ResourceDescriptor resourceDescriptor, String fragment, String name, String displayName,
			EClassDescriptor typeDescriptor) {
		super(resourceDescriptor, fragment, name, displayName, typeDescriptor);
	}

	public String getUserData(String key) {
		return null;
	}

	@Override
	public String toString() {
		return displayName;
	}

	public static class Factory implements EObjectDescriptor.Factory {

		public EObjectDescriptor createDescriptor(EObject eObject, ResourceDescriptor resourceDescriptor, EClassDescriptor typeDescriptor) {
			Resource resource = eObject.eResource();
			return new ElementDescriptorImpl(resourceDescriptor, resource.getURIFragment(eObject),
					nameAttributeValue(eObject), defaultDisplayName(eObject), typeDescriptor);
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
