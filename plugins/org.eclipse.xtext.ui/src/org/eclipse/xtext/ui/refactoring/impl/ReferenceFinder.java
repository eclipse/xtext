/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.util.EcoreUtil.CrossReferencer;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.refactoring.IRefactoringDocument;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.inject.Inject;

/**
 * @author koehnlein - Initial contribution and API
 */
public class ReferenceFinder {

	@Inject
	private IResourceDescriptions index;
	
	@Inject
	private RefactoringDocumentProvider documentProvider; 

	public CrossRefRenameInfo.Table findReferences(final ElementRenameInfo.Table renamedElements,
			URI targetElementURI, final IRefactoringDocument targetDocument, RefactoringStatus status) {
		CrossRefRenameInfo.Table renamedCrossRefs = new CrossRefRenameInfo.Table();
		addInternalReferences(renamedCrossRefs, renamedElements, targetDocument, status);
		addReferencesFromIndex(renamedCrossRefs, renamedElements, targetElementURI, targetDocument, status);
		return renamedCrossRefs;
	}

	protected void addReferencesFromIndex(CrossRefRenameInfo.Table renamedCrossRefs,
			ElementRenameInfo.Table renamedElements, URI targetElementURI,
			final IRefactoringDocument targetDocument, RefactoringStatus status) {
		URI targetResourceURI = targetElementURI.trimFragment();
		for (IResourceDescription resourceDescription : index.getAllResourceDescriptions()) {
			if (!targetResourceURI.equals(resourceDescription.getURI())) {
				IRefactoringDocument referringDocument = null;
				for (IReferenceDescription referenceDescription : resourceDescription.getReferenceDescriptions()) {
					ElementRenameInfo renamedElementInfo = renamedElements.getByURI(referenceDescription
							.getTargetEObjectUri());
					if (renamedElementInfo != null) {
						if(referringDocument== null) 
							referringDocument = documentProvider.get(resourceDescription.getURI(), status);
						renamedCrossRefs.add(referringDocument, referenceDescription,
								renamedElementInfo);
					}
				}
			}
		}
	}

	protected void addInternalReferences(final CrossRefRenameInfo.Table renamedCrossRefs,
			final ElementRenameInfo.Table renamedElements, final IRefactoringDocument targetDocument,
			final RefactoringStatus status) {
		targetDocument.readOnly(new IUnitOfWork.Void<XtextResource>() {
			@Override
			public void process(XtextResource targetResource) throws Exception {
				Map<EObject, Collection<Setting>> targetResourceInternalCrossRefs = CrossReferencer.find(Collections
						.singletonList(targetResource.getContents().get(0)));
				for (ElementRenameInfo renamedElementInfo : renamedElements.getByDocument(targetDocument)) {
					EObject renamedElement = targetResource.getEObject(renamedElementInfo.getRenamedElementURI()
							.fragment());
					Collection<Setting> crossRefSettings = targetResourceInternalCrossRefs.get(renamedElement);
					for (Setting crossRefSetting : crossRefSettings) {
						if (crossRefSetting.getEStructuralFeature().isMany()) {
							List<?> values = (List<?>) crossRefSetting.getEObject().eGet(
									crossRefSetting.getEStructuralFeature());
							for (int i = 0; i < values.size(); ++i) {
								if (renamedElement == values.get(i)) {
									renamedCrossRefs.add(targetDocument, crossRefSetting.getEObject(),
											(EReference) crossRefSetting.getEStructuralFeature(), i, renamedElementInfo);
								}
							}
						} else {
							renamedCrossRefs.add(targetDocument, crossRefSetting.getEObject(),
									(EReference) crossRefSetting.getEStructuralFeature(), 0, renamedElementInfo);
						}
					}
				}
			}
		});
	}

}
