/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring.impl;

import static com.google.common.collect.Iterables.*;
import static org.eclipse.xtext.util.Strings.*;

import java.util.Iterator;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
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
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.refactoring.ElementRenameArguments;
import org.eclipse.xtext.ui.refactoring.IRefactoringDocument;
import org.eclipse.xtext.ui.refactoring.IReferenceUpdater;
import org.eclipse.xtext.ui.refactoring.IRenameStrategy;
import org.eclipse.xtext.ui.refactoring.UpdateAcceptor;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.ReplaceRegion;

import com.google.common.collect.Multimap;
import com.google.inject.Inject;

/**
 * @author koehnlein - Initial contribution and API
 */
public class DefaultReferenceUpdater implements IReferenceUpdater {
	@Inject
	private ReferenceDescriptionSorter sorter;

	@Inject
	private RefactoringResourceSetProvider resourceSetProvider;

	@Inject
	private RenamedElementTracker renamedElementTracker;

	public RefactoringStatus createReferenceUpdates(ElementRenameArguments elementRenameArguments,
			IRenameStrategy renameStrategy, Iterable<IReferenceDescription> referenceDescriptions,
			UpdateAcceptor updateAcceptor, IProgressMonitor monitor) {
		SubMonitor progress = SubMonitor.convert(monitor, 100);
		RefactoringStatus status = new RefactoringStatus();
		try {
			progress.beginTask("Sort references by project", 5);
			Multimap<IProject, IReferenceDescription> project2references = sorter.sortByProject(referenceDescriptions);
			SubMonitor allProjectsProgress = progress.newChild(95).setWorkRemaining(project2references.keySet().size());
			for (IProject project : project2references.keySet()) {
				if (allProjectsProgress.isCanceled())
					break;
				Multimap<URI, IReferenceDescription> resource2references = sorter.sortByResource(project2references
						.get(project));
				int numResources = resource2references.keySet().size();
				SubMonitor projectProgress = allProjectsProgress.newChild(1).setWorkRemaining(numResources + 2);
				ResourceSet resourceSet = resourceSetProvider.get(project);
				loadTargetResource(resourceSet, elementRenameArguments, projectProgress.newChild(1));
				loadReferringResources(resourceSet, resource2references.keySet(),
						projectProgress.newChild(numResources));
				renamedElementTracker.rename(elementRenameArguments, resourceSet, renameStrategy);
				internalCreateReferenceUpdates(elementRenameArguments, resource2references, resourceSet,
						renamedElementTracker, updateAcceptor, status, projectProgress.newChild(1));
			}
		} catch (Exception exc) {
			RefactoringStatusExtension.handleException(status, exc);
		}
		return status;
	}

	protected XtextResource loadTargetResource(ResourceSet resourceSet, ElementRenameArguments elementRenameArguments,
			IProgressMonitor monitor) {
		SubMonitor progress = SubMonitor.convert(monitor, "Loading target resource", 1);
		Resource targetResource = resourceSet.getResource(elementRenameArguments.getBaseElementURI().trimFragment(),
				true);
		if (!(targetResource instanceof XtextResource)) {
			throw new RefactoringStatusException("Cannot load target resource", true);
		}
		progress.worked(1);
		return (XtextResource) targetResource;
	}

	protected void loadReferringResources(ResourceSet resourceSet, Iterable<URI> referringResourceURIs,
			IProgressMonitor monitor) {
		SubMonitor progress = SubMonitor.convert(monitor, "Loading referencing resources", size(referringResourceURIs));
		for (URI referringResourceURI : referringResourceURIs) {
			Resource referringResource = resourceSet.getResource(referringResourceURI, true);
			if (referringResource == null)
				throw new RefactoringStatusException("Resource " + notNull(referringResourceURI) + " cannot be loaded",
						true);
			progress.worked(1);
		}
	}

	@Inject
	private IRefactoringDocument.Provider refactoringDocumentProvider;

	@Inject
	private ILocationInFileProvider locationInFileProvider;

	@Inject
	private ITokenSerializer.ICrossReferenceSerializer crossReferenceSerializer;

	protected void internalCreateReferenceUpdates(ElementRenameArguments elementRenameArguments,
			Multimap<URI, IReferenceDescription> resource2references, ResourceSet resourceSet,
			RenamedElementTracker renamedElementTracker, UpdateAcceptor updateAcceptor, RefactoringStatus status,
			IProgressMonitor monitor) {
		SubMonitor progress = SubMonitor.convert(monitor, "Creating reference updates", resource2references.keySet()
				.size());
		for (URI referringResourceURI : resource2references.keySet()) {
			Resource referringResource = resourceSet.getResource(referringResourceURI, false);
			IRefactoringDocument referringDocument = refactoringDocumentProvider.get(referringResourceURI, status);
			if (!(referringResource instanceof XtextResource)) {
				throw new RefactoringStatusException("Resource " + notNull(referringResourceURI)
						+ " is not an XtextResource", true);
			}
			((XtextResource) referringResource).getCache().clear(referringResource);
			for (IReferenceDescription referenceDescription : resource2references.get(referringResourceURI)) {
				URI referringElementNewURI = renamedElementTracker.getNewURI(referenceDescription.getSourceEObjectUri());
				EObject referringElement = resourceSet.getEObject(referringElementNewURI, false);
				URI targetElementNewURI = renamedElementTracker.getNewURI(referenceDescription.getTargetEObjectUri());
				EObject newTargetElement = resourceSet.getEObject(targetElementNewURI, false);
				createReferenceUpdate(referringElement, referringDocument, referenceDescription.getEReference(),
						referenceDescription.getIndexInList(), newTargetElement, updateAcceptor, 
						status);
			}
			progress.worked(1);
		}
	}

	protected void createReferenceUpdate(EObject referringElement, IRefactoringDocument referringDocument,
			EReference reference, int indexInList, EObject newTargetElement, UpdateAcceptor updateAcceptor,
			final RefactoringStatus status) {
		ITextRegion referenceTextRegion = locationInFileProvider.getFullTextRegion(referringElement, reference,
				indexInList);
		CrossReference crossReference = getCrossReference(referringElement, referenceTextRegion.getOffset());
		String newReferenceText = crossReferenceSerializer.serializeCrossRef(referringElement, crossReference,
				newTargetElement, null);
		// TODO: add import hook
		ReplaceRegion referenceEdit = new ReplaceRegion(referenceTextRegion.getOffset(), referenceTextRegion.getLength(),
				newReferenceText);
		updateAcceptor.accept(referringDocument, referenceEdit);
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

}
