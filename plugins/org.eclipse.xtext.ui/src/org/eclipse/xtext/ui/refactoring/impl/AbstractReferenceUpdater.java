/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parsetree.reconstr.ITokenSerializer;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.refactoring.ElementRenameInfo;
import org.eclipse.xtext.ui.refactoring.IRefactoringDocument;
import org.eclipse.xtext.ui.refactoring.IReferenceUpdater;
import org.eclipse.xtext.ui.refactoring.impl.CrossRefRenameInfo.Table;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.ReplaceRegion;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.internal.Maps;

/**
 * @author koehnlein - Initial contribution and API
 */
public abstract class AbstractReferenceUpdater implements IReferenceUpdater {

	@Inject
	private IResourceServiceProvider.Registry resourceServiceProviderRegistry;

	@Inject
	private ILocationInFileProvider locationInFileProvider;

	@Inject
	private ITokenSerializer.ICrossReferenceSerializer crossReferenceSerializer;

	protected abstract Table getCrossReferenceInfos(Iterable<ElementRenameInfo> elementRenameInfos, ResourceSet resourceSet,
			RefactoringStatus status);

	public RefactoringStatus createReferenceUpdates(ElementRenameInfo baseRenameInfo, Iterable<ElementRenameInfo> dependentRenameInfos,
			ReplaceRegion declarationEdit, ResourceSet resourceSet, UpdateAcceptor updateAcceptor) {
		RefactoringStatus status = new RefactoringStatus();
		Iterable<ElementRenameInfo> allRenameInfos = Iterables.concat(Collections.singletonList(baseRenameInfo), dependentRenameInfos);
		Table crossRefInfos = getCrossReferenceInfos(allRenameInfos, resourceSet, status);
		Resource targetResource = resourceSet.getResource(baseRenameInfo.getElementURI().trimFragment(), false);
		if (!(targetResource instanceof XtextResource)) {
			throw new RefactoringStatusException("Cannot load target resource", true);
		}
		loadReferringResources(resourceSet, crossRefInfos);
		ReplaceRegion undoDeclarationEdit = null;
		try {
			undoDeclarationEdit = applyTextEdit((XtextResource) targetResource, declarationEdit);
			OffsetCorrector offsetCorrector = new OffsetCorrector(baseRenameInfo.getDocument(), declarationEdit);
			Map<ElementRenameInfo, EObject> renamedElementsMap = resolveRenamedElements(allRenameInfos, resourceSet,
					offsetCorrector);
			for (IRefactoringDocument referringDocument : crossRefInfos.getDocuments()) {
				XtextResource referringResource = (XtextResource) resourceSet.getResource(referringDocument.getURI(), true);
				referringResource.getCache().clear(referringResource);
				for (CrossRefRenameInfo crossRefInfo : crossRefInfos.getByDocument(referringDocument)) {
					EObject referringElement = resolveReferringElement(referringResource, crossRefInfo, renamedElementsMap);
					EObject renamedElement = renamedElementsMap.get(crossRefInfo.getRenamedTarget());
					createReferenceUpdate(referringElement, crossRefInfo, renamedElement, updateAcceptor,
							offsetCorrector, status);
				}
			}
		} finally {
			if (undoDeclarationEdit != null)
				applyTextEdit((XtextResource) targetResource, undoDeclarationEdit);
		}
		return status;
	}

	protected void loadReferringResources(ResourceSet resourceSet, Table crossRefInfos) {
		for (IRefactoringDocument referringDocument : crossRefInfos.getDocuments()) {
			resourceSet.getResource(referringDocument.getURI(), true);
		}
	}
	
	protected ReplaceRegion applyTextEdit(XtextResource resource, ReplaceRegion replaceEdit) {
		String currentName = resource.getParseResult().getRootNode().getText()
				.substring(replaceEdit.getOffset(), replaceEdit.getOffset() + replaceEdit.getLength());
		resource.update(replaceEdit.getOffset(), replaceEdit.getLength(), replaceEdit.getText());
		ReplaceRegion undoEdit = new ReplaceRegion(replaceEdit.getOffset(), replaceEdit.getText().length(), currentName);
		return undoEdit;
	}

	protected void createReferenceUpdate(final EObject referringElement, final CrossRefRenameInfo crossRefInfo,
			final EObject newTargetEObject, final UpdateAcceptor updateAcceptor, final OffsetCorrector offsetCorrector,
			final RefactoringStatus status) {
		try {
			ITextRegion referenceTextRegion = locationInFileProvider.getFullTextRegion(referringElement,
					crossRefInfo.getEReference(), crossRefInfo.getIndex());
			CrossReference crossReference = getCrossReference(referringElement, referenceTextRegion.getOffset());
			String newReferenceText = crossReferenceSerializer.serializeCrossRef(referringElement, crossReference,
					newTargetEObject, null);
			// TODO: add import hook
			int correctedOffset = offsetCorrector.newToOld(crossRefInfo.getReferringDocument(),
					referenceTextRegion.getOffset());
			ReplaceRegion referenceEdit = new ReplaceRegion(correctedOffset, referenceTextRegion.getLength(), newReferenceText);
			updateAcceptor.accept(crossRefInfo.getReferringDocument(), referenceEdit);
		} catch (Exception e) {
			status.addFatalError(e.getMessage());
		}
	}

	protected CrossReference getCrossReference(EObject referringElement, int offset) {
		ICompositeNode node = NodeModelUtils.getNode(referringElement);
		Iterator<INode> iter = node.getAsTreeIterable().iterator();
		while (iter.hasNext()) {
			INode childNode = iter.next();
			if (childNode.getOffset() >= offset && childNode.getGrammarElement() instanceof CrossReference)
				return (CrossReference) childNode.getGrammarElement();
		}
		return null;
	}

	protected Map<ElementRenameInfo, EObject> resolveRenamedElements(Iterable<ElementRenameInfo> elementRenameInfos, ResourceSet resourceSet,
			OffsetCorrector offsetCorrector) {
		HashMap<ElementRenameInfo, EObject> renamedElementsMap = Maps.newHashMap();
		for (ElementRenameInfo elementRenameInfo : elementRenameInfos) {
			// eObjectURI might have changed with the declaration so we use the offset to find the renamed element 
			XtextResource renamedElementResource = (XtextResource) resourceSet.getResource(elementRenameInfo
					.getElementURI().trimFragment(), true);
			int correctedOffset = offsetCorrector.oldToNew(elementRenameInfo.getDocument(),
					elementRenameInfo.getOffset());
			EObject renamedElement = getEObjectAtOffsetHelper(elementRenameInfo.getElementURI())
					.resolveElementAt(renamedElementResource, correctedOffset);
			renamedElementsMap.put(elementRenameInfo, renamedElement);
		}
		return renamedElementsMap;
	}

	protected EObject resolveReferringElement(XtextResource referringResource, CrossRefRenameInfo crossRefInfo, Map<ElementRenameInfo, EObject> renamedElementsMap) {
		// referring element might have been renamed, too
		for(ElementRenameInfo renamedElementInfo: renamedElementsMap.keySet()) {
			if(renamedElementInfo.getElementURI().equals(crossRefInfo.getReferrerElementURI())) {
				return renamedElementsMap.get(renamedElementInfo);
			}
		}
		return referringResource.getEObject(crossRefInfo.getReferrerElementURI()
				.fragment());
	}

	protected EObjectAtOffsetHelper getEObjectAtOffsetHelper(URI targetElementURI) {
		IResourceServiceProvider resourceServiceProvider = resourceServiceProviderRegistry
				.getResourceServiceProvider(targetElementURI.trimFragment());
		if (resourceServiceProvider == null)
			throw new RefactoringStatusException("Cannot find a reosurce service provider for target language", true);
		EObjectAtOffsetHelper eObjectAtOffsetHelper = resourceServiceProvider.get(EObjectAtOffsetHelper.class);
		return eObjectAtOffsetHelper;
	}

}
