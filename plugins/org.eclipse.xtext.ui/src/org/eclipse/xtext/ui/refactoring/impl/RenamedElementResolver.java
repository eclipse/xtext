/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring.impl;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.IGlobalServiceProvider;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.refactoring.ElementRenameInfo;

import com.google.inject.Inject;
import com.google.inject.internal.Maps;

/**
 * @author koehnlein - Initial contribution and API
 */
public class RenamedElementResolver {

	@Inject
	private IGlobalServiceProvider globalServiceProvider;

	public Map<URI, EObject> resolveRenamedElements(Iterable<ElementRenameInfo> elementRenameInfos,
			ResourceSet resourceSet, OffsetCorrector offsetCorrector) {
		HashMap<URI, EObject> renamedElementsMap = Maps.newHashMap();
		for (ElementRenameInfo elementRenameInfo : elementRenameInfos) {
			// eObjectURI might have changed with the declaration so we use the offset to find the renamed element 
			XtextResource renamedElementResource = (XtextResource) resourceSet.getResource(elementRenameInfo
					.getElementURI().trimFragment(), true);
			int correctedOffset = offsetCorrector.oldToNew(elementRenameInfo.getDocument(),
					elementRenameInfo.getOffset());
			EObject renamedElement = getEObjectAtOffsetHelper(elementRenameInfo.getElementURI()).resolveElementAt(
					renamedElementResource, correctedOffset);
			renamedElementsMap.put(elementRenameInfo.getElementURI(), renamedElement);
		}
		return renamedElementsMap;
	}

	protected EObjectAtOffsetHelper getEObjectAtOffsetHelper(URI targetElementURI) {
		EObjectAtOffsetHelper eObjectAtOffsetHelper = globalServiceProvider.findService(
				targetElementURI.trimFragment(), EObjectAtOffsetHelper.class);
		return eObjectAtOffsetHelper;
	}
	
	public EObject resolveReferringElement(Resource referringResource,
			IReferenceDescription referenceDescription, Map<URI, EObject> uri2renamedElement) {
		// referring element might have been renamed, too
		for (URI renamedElementURI : uri2renamedElement.keySet()) {
			if (renamedElementURI.equals(referenceDescription.getSourceEObjectUri())) {
				return uri2renamedElement.get(renamedElementURI);
			}
		}
		return referringResource.getEObject(referenceDescription.getSourceEObjectUri().fragment());
	}

}
