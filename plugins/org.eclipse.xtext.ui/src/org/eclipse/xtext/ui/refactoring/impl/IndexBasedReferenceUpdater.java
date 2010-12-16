/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring.impl;

import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.ui.refactoring.ElementRenameInfo;
import org.eclipse.xtext.ui.refactoring.IIndexBasedReferenceUpdater;
import org.eclipse.xtext.ui.refactoring.IRefactoringDocument;

import com.google.common.collect.Sets;
import com.google.inject.Inject;
import com.google.inject.internal.Maps;

/**
 * @author koehnlein - Initial contribution and API
 */
public class IndexBasedReferenceUpdater extends AbstractReferenceUpdater implements IIndexBasedReferenceUpdater {

	@Inject
	private IResourceServiceProvider resourceServiceProvider;

	@Inject
	private IResourceDescriptions index;

	@Inject
	private IRefactoringDocument.Provider documentProvider;

	@Override
	protected CrossRefRenameInfo.Table getCrossReferenceInfos(Iterable<ElementRenameInfo> elementRenameInfos, ResourceSet resourceSet,
			RefactoringStatus status) {
		CrossRefRenameInfo.Table renamedCrossRefs = new CrossRefRenameInfo.Table();
		Map<URI, ElementRenameInfo> uri2elementRenameInfo = Maps.newHashMap();
		Set<URI> declarationResourceURIs = Sets.newHashSet();
		for (ElementRenameInfo elementRenameInfo : elementRenameInfos) {
			uri2elementRenameInfo.put(elementRenameInfo.getElementURI(), elementRenameInfo);
			declarationResourceURIs.add(elementRenameInfo.getElementURI().trimFragment());
		}
		for (IResourceDescription resourceDescription : index.getAllResourceDescriptions()) {
			if (resourceServiceProvider.canHandle(resourceDescription.getURI())
					&& !declarationResourceURIs.contains(resourceDescription.getURI())) {
				IRefactoringDocument referringDocument = null;
				for (IReferenceDescription referenceDescription : resourceDescription.getReferenceDescriptions()) {
					ElementRenameInfo renamedElementInfo = uri2elementRenameInfo.get(referenceDescription
							.getTargetEObjectUri());
					if (renamedElementInfo != null) {
						if (referringDocument == null)
							referringDocument = documentProvider.get(resourceDescription.getURI(), status);
						renamedCrossRefs.add(referringDocument, referenceDescription, renamedElementInfo);
					}
				}
			}
		}
		return renamedCrossRefs;
	}

}
