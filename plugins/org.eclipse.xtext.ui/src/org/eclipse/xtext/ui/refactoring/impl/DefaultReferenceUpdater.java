/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring.impl;

import static org.eclipse.xtext.util.Strings.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parsetree.reconstr.ITokenSerializer;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.IGlobalServiceProvider;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.refactoring.ElementRenameArguments;
import org.eclipse.xtext.ui.refactoring.ElementRenameInfo;
import org.eclipse.xtext.ui.refactoring.IRefactoringDocument;
import org.eclipse.xtext.ui.refactoring.IReferenceUpdater;
import org.eclipse.xtext.ui.refactoring.IRenameStrategy;
import org.eclipse.xtext.ui.refactoring.UpdateAcceptor;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.ReplaceRegion;

import com.google.common.collect.Multimap;
import com.google.inject.Inject;
import com.google.inject.internal.Maps;

/**
 * @author koehnlein - Initial contribution and API
 */
public class DefaultReferenceUpdater implements IReferenceUpdater {

	@Inject
	private ReferenceDescriptionSorter sorter;

	@Inject
	private RefactoringResourceSetProvider resourceSetProvider;

	@Inject
	private IRefactoringDocument.Provider refactoringDocumentProvider;

	@Inject
	private IGlobalServiceProvider globalServiceProvider;

	@Inject
	private ILocationInFileProvider locationInFileProvider;

	@Inject
	private ITokenSerializer.ICrossReferenceSerializer crossReferenceSerializer;

	public RefactoringStatus createReferenceUpdates(ElementRenameArguments elementRenameArguments,
			IRenameStrategy renameStrategy, Iterable<IReferenceDescription> referenceDescriptions,
			UpdateAcceptor updateAcceptor, IProgressMonitor monitor) {
		RefactoringStatus status = new RefactoringStatus();
		try {
			Multimap<IProject, IReferenceDescription> project2references = sorter.sortByProject(referenceDescriptions);
			for (IProject project : project2references.keySet()) {
				Multimap<URI, IReferenceDescription> resource2references = sorter.sortByResource(project2references
						.get(project));
				ResourceSet resourceSet = resourceSetProvider.get(project);
				XtextResource targetResource = loadTargetResource(resourceSet, elementRenameArguments);
				loadReferringResources(resourceSet, resource2references);
				ReplaceRegion declarationEdit = renameStrategy.getReplaceRegion(elementRenameArguments.getNewName());
				applyDeclarationEdit(targetResource, declarationEdit);
				OffsetCorrector offsetCorrector = new OffsetCorrector(elementRenameArguments.getBaseElementRenameInfo()
						.getDocument(), declarationEdit);
				Map<URI, EObject> uri2renamedElement = resolveRenamedElements(
						elementRenameArguments.getAllElementRenameInfos(), resourceSet, offsetCorrector);
				for (URI referringResourceURI : resource2references.keySet()) {
					XtextResource referringResource = (XtextResource) resourceSet.getResource(referringResourceURI,
							false);
					referringResource.getCache().clear(referringResource);

					IRefactoringDocument referringDocument = refactoringDocumentProvider.get(referringResourceURI,
							status);
					for (IReferenceDescription referenceDescription : resource2references.get(referringResourceURI)) {
						EObject referringElement = resolveReferringElement(referringResource, referenceDescription,
								uri2renamedElement);
						EObject newTargetElement = uri2renamedElement.get(referenceDescription.getTargetEObjectUri());
						createReferenceUpdate(referringElement, referringDocument,
								referenceDescription.getEReference(), referenceDescription.getIndexInList(),
								newTargetElement, updateAcceptor, offsetCorrector, status);
					}
				}
			}
		} catch (Exception exc) {
			RefactoringStatusExtension.handleException(status, exc);
		}
		return status;
	}

	protected XtextResource loadTargetResource(ResourceSet resourceSet, ElementRenameArguments elementRenameArguments) {
		Resource targetResource = resourceSet.getResource(elementRenameArguments.getBaseElementRenameInfo()
				.getElementURI().trimFragment(), true);
		if (!(targetResource instanceof XtextResource)) {
			throw new RefactoringStatusException("Cannot load target resource", true);
		}
		return (XtextResource) targetResource;
	}

	protected void loadReferringResources(ResourceSet resourceSet,
			Multimap<URI, IReferenceDescription> resource2references) {
		for (URI referringResourceURI : resource2references.keySet()) {
			Resource referringResource = resourceSet.getResource(referringResourceURI, true);
			if (referringResource == null)
				throw new RefactoringStatusException("Resource " + notNull(referringResourceURI) + " cannot be loaded",
						true);
			if (!(referringResource instanceof XtextResource))
				throw new RefactoringStatusException("Resource " + notNull(referringResourceURI)
						+ " is not an XtextResource", true);
		}
	}

	protected void applyDeclarationEdit(XtextResource resource, ReplaceRegion declarationEdit) {
		resource.update(declarationEdit.getOffset(), declarationEdit.getLength(), declarationEdit.getText());
	}

	protected void createReferenceUpdate(EObject referringElement, IRefactoringDocument referringDocument,
			EReference reference, int indexInList, EObject newTargetElement, UpdateAcceptor updateAcceptor,
			OffsetCorrector offsetCorrector, final RefactoringStatus status) {
		try {
			ITextRegion referenceTextRegion = locationInFileProvider.getFullTextRegion(referringElement, reference,
					indexInList);
			CrossReference crossReference = getCrossReference(referringElement, referenceTextRegion.getOffset());
			String newReferenceText = crossReferenceSerializer.serializeCrossRef(referringElement, crossReference,
					newTargetElement, null);
			// TODO: add import hook
			int correctedOffset = offsetCorrector.newToOld(referringDocument, referenceTextRegion.getOffset());
			ReplaceRegion referenceEdit = new ReplaceRegion(correctedOffset, referenceTextRegion.getLength(),
					newReferenceText);
			updateAcceptor.accept(referringDocument, referenceEdit);
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

	protected Map<URI, EObject> resolveRenamedElements(Iterable<ElementRenameInfo> elementRenameInfos,
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

	protected EObject resolveReferringElement(XtextResource referringResource,
			IReferenceDescription referenceDescription, Map<URI, EObject> uri2renamedElement) {
		// referring element might have been renamed, too
		for (URI renamedElementURI : uri2renamedElement.keySet()) {
			if (renamedElementURI.equals(referenceDescription.getSourceEObjectUri())) {
				return uri2renamedElement.get(renamedElementURI);
			}
		}
		return referringResource.getEObject(referenceDescription.getSourceEObjectUri().fragment());
	}

	protected EObjectAtOffsetHelper getEObjectAtOffsetHelper(URI targetElementURI) {
		EObjectAtOffsetHelper eObjectAtOffsetHelper = globalServiceProvider.findService(
				targetElementURI.trimFragment(), EObjectAtOffsetHelper.class);
		return eObjectAtOffsetHelper;
	}

}
