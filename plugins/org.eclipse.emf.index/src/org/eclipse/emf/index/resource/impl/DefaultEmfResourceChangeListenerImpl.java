/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.index.resource.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.index.ECrossReferenceDescriptor;
import org.eclipse.emf.index.IIndexStore;
import org.eclipse.emf.index.impl.Logger;
import org.eclipse.emf.index.resource.EmfResourceChangeListener;
import org.eclipse.emf.index.resource.IndexFeeder;

/**
 * @author Jan Köhnlein - Initial contribution and API
 */
public class DefaultEmfResourceChangeListenerImpl implements EmfResourceChangeListener {

	public void resourceChanged(URI resourceURI, IIndexStore store, IndexFeeder feeder) {
		Resource resource = loadResource(resourceURI);
		if (resource != null) {
			feeder.createResourceDescriptor(resource, getResourceUserData(resource));
			for (Iterator<EObject> i = EcoreUtil.getAllProperContents(resource, false); i.hasNext();) {
				EObject element = i.next();
				if (isIndexElement(element)) {
					feeder.createEObjectDescriptor(element, getEObjectName(element), getEObjectDisplayName(element),
							getEObjectUserData(element));
					URI sourceURI = EcoreUtil.getURI(element);
					if (sourceURI != null) {
						for (EReference eReference : element.eClass().getEAllReferences()) {
							String eReferenceName = eReference.getName();
							if (isIndexReference(eReference, element)) {
								if (eReference.isMany()) {
									List<?> targets = (List<?>) ((InternalEObject) element).eGet(eReference, false);
									for (int index = 0; index < targets.size(); ++index) {
										Object target = targets.get(index);
										createECrossReferenceDescriptor(feeder, sourceURI, eReferenceName, index,
												target);
									}
								}
								else {
									Object target = ((InternalEObject) element).eGet(eReference, false);
									createECrossReferenceDescriptor(feeder, sourceURI, eReferenceName,
											ECrossReferenceDescriptor.NO_INDEX, target);
								}
							}
						}
					}
				}
			}
		}
	}

	private void createECrossReferenceDescriptor(IndexFeeder feeder, URI sourceURI, String eReferenceName, int index,
			Object target) {
		if (target instanceof EObject) {
			URI targetURI = EcoreUtil.getURI((EObject) target);
			if (targetURI != null) {
				feeder.createECrossReferenceDescriptor(sourceURI, eReferenceName, index, targetURI);
			}
		}
	}

	protected Resource loadResource(URI resourceURI) {
		try {
			ResourceSet resourceSet = new ResourceSetImpl();
			return resourceSet.getResource(resourceURI, true);
		}
		catch (Exception exc) {
			Logger.logError("Error loading resource", exc);
			return null;
		}
	}

	protected Map<String, String> getResourceUserData(Resource resource) {
		return null;
	}

	protected boolean isIndexElement(EObject element) {
		return true;
	}

	@SuppressWarnings("unchecked")
	protected String getEObjectName(EObject eObject) {
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

	protected String getEObjectDisplayName(EObject eObject) {
		String displayName = getEObjectName(eObject);
		if (displayName == null)
			displayName = eObject.eResource().getURIFragment(eObject);
		return displayName;
	}

	protected Map<String, String> getEObjectUserData(EObject eObject) {
		return null;
	}

	protected boolean isIndexReference(EReference eReference, EObject element) {
		return !eReference.isContainment() && !eReference.isDerived() && element.eIsSet(eReference);
	}
}
